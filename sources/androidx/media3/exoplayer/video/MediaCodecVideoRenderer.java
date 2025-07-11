package androidx.media3.exoplayer.video;

import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import android.view.Display;
import android.view.Surface;
import androidx.compose.material3.MenuKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.common.C;
import androidx.media3.common.Effect;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.Timeline;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.MediaFormatUtil;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.TraceUtil;
import androidx.media3.common.util.Util;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.Renderer;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.mediacodec.MediaCodecAdapter;
import androidx.media3.exoplayer.mediacodec.MediaCodecDecoderException;
import androidx.media3.exoplayer.mediacodec.MediaCodecInfo;
import androidx.media3.exoplayer.mediacodec.MediaCodecRenderer;
import androidx.media3.exoplayer.mediacodec.MediaCodecSelector;
import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.video.PlaybackVideoGraphWrapper;
import androidx.media3.exoplayer.video.VideoFrameReleaseControl;
import androidx.media3.exoplayer.video.VideoRendererEventListener;
import androidx.media3.exoplayer.video.VideoSink;
import androidx.media3.extractor.metadata.dvbsi.AppInfoTableDecoder;
import androidx.media3.extractor.ts.TsExtractor;
import com.google.android.gms.common.Scopes;
import com.google.common.base.Ascii;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.MoreExecutors;
import io.appmetrica.analytics.BuildConfig;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.PriorityQueue;
import kotlin.text.Typography;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.internal.ws.WebSocketProtocol;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
/* loaded from: classes2.dex */
public class MediaCodecVideoRenderer extends MediaCodecRenderer implements VideoFrameReleaseControl.FrameTimingEvaluator {
    private static final int HEVC_MAX_INPUT_SIZE_THRESHOLD = 2097152;
    private static final float INITIAL_FORMAT_MAX_INPUT_SIZE_SCALE_FACTOR = 1.5f;
    private static final String KEY_CROP_BOTTOM = "crop-bottom";
    private static final String KEY_CROP_LEFT = "crop-left";
    private static final String KEY_CROP_RIGHT = "crop-right";
    private static final String KEY_CROP_TOP = "crop-top";
    private static final int MAX_CONSECUTIVE_DROPPED_INPUT_BUFFERS_COUNT_TO_DISCARD_HEADER = 0;
    private static final long MIN_EARLY_US_LATE_THRESHOLD = -30000;
    private static final long MIN_EARLY_US_VERY_LATE_THRESHOLD = -500000;
    private static final long OFFSET_FROM_PERIOD_END_TO_TREAT_AS_LAST_US = 100000;
    private static final long OFFSET_FROM_RESET_POSITION_TO_ALLOW_INPUT_BUFFER_DROPPING_US = 200000;
    private static final int[] STANDARD_LONG_EDGE_VIDEO_PX = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private static final String TAG = "MediaCodecVideoRenderer";
    private static final long TUNNELING_EOS_PRESENTATION_TIME_US = Long.MAX_VALUE;
    private static boolean deviceNeedsSetOutputSurfaceWorkaround;
    private static boolean evaluatedDeviceNeedsSetOutputSurfaceWorkaround;
    private final Av1SampleDependencyParser av1SampleDependencyParser;
    private int buffersInCodecCount;
    private int changeFrameRateStrategy;
    private boolean codecHandlesHdr10PlusOutOfBandMetadata;
    private CodecMaxValues codecMaxValues;
    private boolean codecNeedsSetOutputSurfaceWorkaround;
    private int consecutiveDroppedFrameCount;
    private int consecutiveDroppedInputBufferCount;
    private final Context context;
    private VideoSize decodedVideoSize;
    private final boolean deviceNeedsNoPostProcessWorkaround;
    private Surface displaySurface;
    private final PriorityQueue<Long> droppedDecoderInputBufferTimestamps;
    private long droppedFrameAccumulationStartTimeMs;
    private int droppedFrames;
    private final VideoRendererEventListener.EventDispatcher eventDispatcher;
    private VideoFrameMetadataListener frameMetadataListener;
    private boolean hasSetVideoSink;
    private boolean haveReportedFirstFrameRenderedForCurrentSurface;
    private long lastFrameReleaseTimeNs;
    private final int maxDroppedFramesToNotify;
    private final long minEarlyUsToDropDecoderInput;
    private Size outputResolution;
    private final boolean ownsVideoSink;
    private boolean pendingVideoSinkInputStreamChange;
    private long periodDurationUs;
    private PlaceholderSurface placeholderSurface;
    private int rendererPriority;
    private VideoSize reportedVideoSize;
    private int scalingMode;
    private boolean shouldDropDecoderInputBuffers;
    private long startPositionUs;
    private long totalVideoFrameProcessingOffsetUs;
    private boolean tunneling;
    private int tunnelingAudioSessionId;
    OnFrameRenderedListenerV23 tunnelingOnFrameRenderedListener;
    private List<Effect> videoEffects;
    private int videoFrameProcessingOffsetCount;
    private final VideoFrameReleaseControl videoFrameReleaseControl;
    private final VideoFrameReleaseControl.FrameReleaseInfo videoFrameReleaseInfo;
    private VideoSink videoSink;

    protected boolean shouldDropBuffersToKeyframe(long j, long j2, boolean z) {
        return j < MIN_EARLY_US_VERY_LATE_THRESHOLD && !z;
    }

    protected boolean shouldDropOutputBuffer(long j, long j2, boolean z) {
        return j < MIN_EARLY_US_LATE_THRESHOLD && !z;
    }

    protected boolean shouldForceRenderOutputBuffer(long j, long j2) {
        return j < MIN_EARLY_US_LATE_THRESHOLD && j2 > 100000;
    }

    protected boolean shouldSkipBuffersWithIdenticalReleaseTime() {
        return true;
    }

    /* loaded from: classes2.dex */
    public static final class Builder {
        private long allowedJoiningTimeMs;
        private boolean buildCalled;
        private MediaCodecAdapter.Factory codecAdapterFactory;
        private final Context context;
        private boolean enableDecoderFallback;
        private Handler eventHandler;
        private VideoRendererEventListener eventListener;
        private int maxDroppedFramesToNotify;
        private boolean parseAv1SampleDependencies;
        private VideoSink videoSink;
        private MediaCodecSelector mediaCodecSelector = MediaCodecSelector.DEFAULT;
        private float assumedMinimumCodecOperatingRate = 30.0f;
        private long lateThresholdToDropDecoderInputUs = C.TIME_UNSET;

        public Builder(Context context) {
            this.context = context;
            this.codecAdapterFactory = MediaCodecAdapter.Factory.getDefault(context);
        }

        public Builder setMediaCodecSelector(MediaCodecSelector mediaCodecSelector) {
            this.mediaCodecSelector = mediaCodecSelector;
            return this;
        }

        public Builder setCodecAdapterFactory(MediaCodecAdapter.Factory factory) {
            this.codecAdapterFactory = factory;
            return this;
        }

        public Builder setAllowedJoiningTimeMs(long j) {
            this.allowedJoiningTimeMs = j;
            return this;
        }

        public Builder setEnableDecoderFallback(boolean z) {
            this.enableDecoderFallback = z;
            return this;
        }

        public Builder setEventHandler(Handler handler) {
            this.eventHandler = handler;
            return this;
        }

        public Builder setEventListener(VideoRendererEventListener videoRendererEventListener) {
            this.eventListener = videoRendererEventListener;
            return this;
        }

        public Builder setMaxDroppedFramesToNotify(int i) {
            this.maxDroppedFramesToNotify = i;
            return this;
        }

        public Builder setAssumedMinimumCodecOperatingRate(float f) {
            this.assumedMinimumCodecOperatingRate = f;
            return this;
        }

        public Builder setVideoSink(VideoSink videoSink) {
            this.videoSink = videoSink;
            return this;
        }

        public Builder experimentalSetParseAv1SampleDependencies(boolean z) {
            this.parseAv1SampleDependencies = z;
            return this;
        }

        public Builder experimentalSetLateThresholdToDropDecoderInputUs(long j) {
            this.lateThresholdToDropDecoderInputUs = j;
            return this;
        }

        public MediaCodecVideoRenderer build() {
            Assertions.checkState(!this.buildCalled);
            Handler handler = this.eventHandler;
            Assertions.checkState((handler == null && this.eventListener == null) || !(handler == null || this.eventListener == null));
            this.buildCalled = true;
            return new MediaCodecVideoRenderer(this);
        }
    }

    @Deprecated
    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector) {
        this(new Builder(context).setMediaCodecSelector(mediaCodecSelector));
    }

    @Deprecated
    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, long j) {
        this(new Builder(context).setMediaCodecSelector(mediaCodecSelector).setAllowedJoiningTimeMs(j));
    }

    @Deprecated
    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, long j, Handler handler, VideoRendererEventListener videoRendererEventListener, int i) {
        this(new Builder(context).setMediaCodecSelector(mediaCodecSelector).setAllowedJoiningTimeMs(j).setEventHandler(handler).setEventListener(videoRendererEventListener).setMaxDroppedFramesToNotify(i));
    }

    @Deprecated
    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, long j, boolean z, Handler handler, VideoRendererEventListener videoRendererEventListener, int i) {
        this(new Builder(context).setMediaCodecSelector(mediaCodecSelector).setAllowedJoiningTimeMs(j).setEnableDecoderFallback(z).setEventHandler(handler).setEventListener(videoRendererEventListener).setMaxDroppedFramesToNotify(i));
    }

    @Deprecated
    public MediaCodecVideoRenderer(Context context, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, long j, boolean z, Handler handler, VideoRendererEventListener videoRendererEventListener, int i) {
        this(new Builder(context).setMediaCodecSelector(mediaCodecSelector).setCodecAdapterFactory(factory).setAllowedJoiningTimeMs(j).setEnableDecoderFallback(z).setEventHandler(handler).setEventListener(videoRendererEventListener).setMaxDroppedFramesToNotify(i));
    }

    @Deprecated
    public MediaCodecVideoRenderer(Context context, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, long j, boolean z, Handler handler, VideoRendererEventListener videoRendererEventListener, int i, float f) {
        this(new Builder(context).setMediaCodecSelector(mediaCodecSelector).setCodecAdapterFactory(factory).setAllowedJoiningTimeMs(j).setEnableDecoderFallback(z).setEventHandler(handler).setEventListener(videoRendererEventListener).setMaxDroppedFramesToNotify(i).setAssumedMinimumCodecOperatingRate(f));
    }

    @Deprecated
    public MediaCodecVideoRenderer(Context context, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, long j, boolean z, Handler handler, VideoRendererEventListener videoRendererEventListener, int i, float f, VideoSinkProvider videoSinkProvider) {
        this(new Builder(context).setMediaCodecSelector(mediaCodecSelector).setCodecAdapterFactory(factory).setAllowedJoiningTimeMs(j).setEnableDecoderFallback(z).setEventHandler(handler).setEventListener(videoRendererEventListener).setMaxDroppedFramesToNotify(i).setAssumedMinimumCodecOperatingRate(f).setVideoSink(videoSinkProvider == null ? null : videoSinkProvider.getSink(0)));
    }

    @Deprecated
    public MediaCodecVideoRenderer(Context context, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, long j, boolean z, Handler handler, VideoRendererEventListener videoRendererEventListener, int i, float f, VideoSink videoSink) {
        this(new Builder(context).setMediaCodecSelector(mediaCodecSelector).setCodecAdapterFactory(factory).setAllowedJoiningTimeMs(j).setEnableDecoderFallback(z).setEventHandler(handler).setEventListener(videoRendererEventListener).setMaxDroppedFramesToNotify(i).setAssumedMinimumCodecOperatingRate(f).setVideoSink(videoSink));
    }

    protected MediaCodecVideoRenderer(Builder builder) {
        super(2, builder.codecAdapterFactory, builder.mediaCodecSelector, builder.enableDecoderFallback, builder.assumedMinimumCodecOperatingRate);
        Context applicationContext = builder.context.getApplicationContext();
        this.context = applicationContext;
        this.maxDroppedFramesToNotify = builder.maxDroppedFramesToNotify;
        this.videoSink = builder.videoSink;
        this.eventDispatcher = new VideoRendererEventListener.EventDispatcher(builder.eventHandler, builder.eventListener);
        this.ownsVideoSink = this.videoSink == null;
        this.videoFrameReleaseControl = new VideoFrameReleaseControl(applicationContext, this, builder.allowedJoiningTimeMs);
        this.videoFrameReleaseInfo = new VideoFrameReleaseControl.FrameReleaseInfo();
        this.deviceNeedsNoPostProcessWorkaround = deviceNeedsNoPostProcessWorkaround();
        this.outputResolution = Size.UNKNOWN;
        this.scalingMode = 1;
        this.changeFrameRateStrategy = 0;
        this.decodedVideoSize = VideoSize.UNKNOWN;
        this.tunnelingAudioSessionId = 0;
        this.reportedVideoSize = null;
        this.rendererPriority = -1000;
        long j = C.TIME_UNSET;
        this.startPositionUs = C.TIME_UNSET;
        this.periodDurationUs = C.TIME_UNSET;
        this.av1SampleDependencyParser = builder.parseAv1SampleDependencies ? new Av1SampleDependencyParser() : null;
        this.droppedDecoderInputBufferTimestamps = new PriorityQueue<>();
        this.minEarlyUsToDropDecoderInput = builder.lateThresholdToDropDecoderInputUs != C.TIME_UNSET ? -builder.lateThresholdToDropDecoderInputUs : j;
    }

    @Override // androidx.media3.exoplayer.video.VideoFrameReleaseControl.FrameTimingEvaluator
    public boolean shouldForceReleaseFrame(long j, long j2) {
        return shouldForceRenderOutputBuffer(j, j2);
    }

    @Override // androidx.media3.exoplayer.video.VideoFrameReleaseControl.FrameTimingEvaluator
    public boolean shouldDropFrame(long j, long j2, boolean z) {
        return shouldDropOutputBuffer(j, j2, z);
    }

    @Override // androidx.media3.exoplayer.video.VideoFrameReleaseControl.FrameTimingEvaluator
    public boolean shouldIgnoreFrame(long j, long j2, long j3, boolean z, boolean z2) throws ExoPlaybackException {
        if (this.minEarlyUsToDropDecoderInput != C.TIME_UNSET) {
            this.shouldDropDecoderInputBuffers = j2 > getLastResetPositionUs() + OFFSET_FROM_RESET_POSITION_TO_ALLOW_INPUT_BUFFER_DROPPING_US && j < this.minEarlyUsToDropDecoderInput;
        }
        return shouldDropBuffersToKeyframe(j, j3, z) && maybeDropBuffersToKeyframe(j2, z2);
    }

    @Override // androidx.media3.exoplayer.Renderer
    public String getName() {
        return TAG;
    }

    public static int supportsFormat(Context context, MediaCodecSelector mediaCodecSelector, Format format) throws MediaCodecUtil.DecoderQueryException {
        return supportsFormatInternal(context, mediaCodecSelector, format);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected int supportsFormat(MediaCodecSelector mediaCodecSelector, Format format) throws MediaCodecUtil.DecoderQueryException {
        return supportsFormatInternal(this.context, mediaCodecSelector, format);
    }

    private static int supportsFormatInternal(Context context, MediaCodecSelector mediaCodecSelector, Format format) throws MediaCodecUtil.DecoderQueryException {
        boolean z;
        int i = 0;
        if (!MimeTypes.isVideo(format.sampleMimeType)) {
            return RendererCapabilities.create(0);
        }
        boolean z2 = format.drmInitData != null;
        List<MediaCodecInfo> decoderInfos = getDecoderInfos(context, mediaCodecSelector, format, z2, false);
        if (z2 && decoderInfos.isEmpty()) {
            decoderInfos = getDecoderInfos(context, mediaCodecSelector, format, false, false);
        }
        if (decoderInfos.isEmpty()) {
            return RendererCapabilities.create(1);
        }
        if (!supportsFormatDrm(format)) {
            return RendererCapabilities.create(2);
        }
        MediaCodecInfo mediaCodecInfo = decoderInfos.get(0);
        boolean isFormatSupported = mediaCodecInfo.isFormatSupported(format);
        if (!isFormatSupported) {
            for (int i2 = 1; i2 < decoderInfos.size(); i2++) {
                MediaCodecInfo mediaCodecInfo2 = decoderInfos.get(i2);
                if (mediaCodecInfo2.isFormatSupported(format)) {
                    z = false;
                    isFormatSupported = true;
                    mediaCodecInfo = mediaCodecInfo2;
                    break;
                }
            }
        }
        z = true;
        int i3 = isFormatSupported ? 4 : 3;
        int i4 = mediaCodecInfo.isSeamlessAdaptationSupported(format) ? 16 : 8;
        int i5 = mediaCodecInfo.hardwareAccelerated ? 64 : 0;
        int i6 = z ? 128 : 0;
        if (Util.SDK_INT >= 26 && MimeTypes.VIDEO_DOLBY_VISION.equals(format.sampleMimeType) && !Api26.doesDisplaySupportDolbyVision(context)) {
            i6 = 256;
        }
        if (isFormatSupported) {
            List<MediaCodecInfo> decoderInfos2 = getDecoderInfos(context, mediaCodecSelector, format, z2, true);
            if (!decoderInfos2.isEmpty()) {
                MediaCodecInfo mediaCodecInfo3 = MediaCodecUtil.getDecoderInfosSortedByFormatSupport(decoderInfos2, format).get(0);
                if (mediaCodecInfo3.isFormatSupported(format) && mediaCodecInfo3.isSeamlessAdaptationSupported(format)) {
                    i = 32;
                }
            }
        }
        return RendererCapabilities.create(i3, i4, i, i5, i6);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected List<MediaCodecInfo> getDecoderInfos(MediaCodecSelector mediaCodecSelector, Format format, boolean z) throws MediaCodecUtil.DecoderQueryException {
        return MediaCodecUtil.getDecoderInfosSortedByFormatSupport(getDecoderInfos(this.context, mediaCodecSelector, format, z, this.tunneling), format);
    }

    private static List<MediaCodecInfo> getDecoderInfos(Context context, MediaCodecSelector mediaCodecSelector, Format format, boolean z, boolean z2) throws MediaCodecUtil.DecoderQueryException {
        if (format.sampleMimeType == null) {
            return ImmutableList.of();
        }
        if (Util.SDK_INT >= 26 && MimeTypes.VIDEO_DOLBY_VISION.equals(format.sampleMimeType) && !Api26.doesDisplaySupportDolbyVision(context)) {
            List<MediaCodecInfo> alternativeDecoderInfos = MediaCodecUtil.getAlternativeDecoderInfos(mediaCodecSelector, format, z, z2);
            if (!alternativeDecoderInfos.isEmpty()) {
                return alternativeDecoderInfos;
            }
        }
        return MediaCodecUtil.getDecoderInfosSoftMatch(mediaCodecSelector, format, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class Api26 {
        private Api26() {
        }

        public static boolean doesDisplaySupportDolbyVision(Context context) {
            DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
            Display display = displayManager != null ? displayManager.getDisplay(0) : null;
            if (display != null && display.isHdr()) {
                for (int i : display.getHdrCapabilities().getSupportedHdrTypes()) {
                    if (i == 1) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.BaseRenderer
    public void onInit() {
        super.onInit();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
    protected void onEnabled(boolean z, boolean z2) throws ExoPlaybackException {
        super.onEnabled(z, z2);
        boolean z3 = getConfiguration().tunneling;
        Assertions.checkState((z3 && this.tunnelingAudioSessionId == 0) ? false : true);
        if (this.tunneling != z3) {
            this.tunneling = z3;
            releaseCodec();
        }
        this.eventDispatcher.enabled(this.decoderCounters);
        if (!this.hasSetVideoSink) {
            if (this.videoEffects != null && this.videoSink == null) {
                PlaybackVideoGraphWrapper build = new PlaybackVideoGraphWrapper.Builder(this.context, this.videoFrameReleaseControl).setClock(getClock()).build();
                build.setTotalVideoInputCount(1);
                this.videoSink = build.getSink(0);
            }
            this.hasSetVideoSink = true;
        }
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            videoSink.setListener(new VideoSink.Listener() { // from class: androidx.media3.exoplayer.video.MediaCodecVideoRenderer.1
                @Override // androidx.media3.exoplayer.video.VideoSink.Listener
                public void onVideoSizeChanged(VideoSink videoSink2, VideoSize videoSize) {
                }

                @Override // androidx.media3.exoplayer.video.VideoSink.Listener
                public void onFirstFrameRendered(VideoSink videoSink2) {
                    if (MediaCodecVideoRenderer.this.displaySurface != null) {
                        MediaCodecVideoRenderer.this.notifyRenderedFirstFrame();
                    }
                }

                @Override // androidx.media3.exoplayer.video.VideoSink.Listener
                public void onFrameDropped(VideoSink videoSink2) {
                    if (MediaCodecVideoRenderer.this.displaySurface != null) {
                        MediaCodecVideoRenderer.this.updateDroppedBufferCounters(0, 1);
                    }
                }

                @Override // androidx.media3.exoplayer.video.VideoSink.Listener
                public void onError(VideoSink videoSink2, VideoSink.VideoSinkException videoSinkException) {
                    MediaCodecVideoRenderer mediaCodecVideoRenderer = MediaCodecVideoRenderer.this;
                    mediaCodecVideoRenderer.setPendingPlaybackException(mediaCodecVideoRenderer.createRendererException(videoSinkException, videoSinkException.format, PlaybackException.ERROR_CODE_VIDEO_FRAME_PROCESSING_FAILED));
                }
            }, MoreExecutors.directExecutor());
            VideoFrameMetadataListener videoFrameMetadataListener = this.frameMetadataListener;
            if (videoFrameMetadataListener != null) {
                this.videoSink.setVideoFrameMetadataListener(videoFrameMetadataListener);
            }
            if (this.displaySurface != null && !this.outputResolution.equals(Size.UNKNOWN)) {
                this.videoSink.setOutputSurfaceInfo(this.displaySurface, this.outputResolution);
            }
            this.videoSink.setChangeFrameRateStrategy(this.changeFrameRateStrategy);
            this.videoSink.setPlaybackSpeed(getPlaybackSpeed());
            List<Effect> list = this.videoEffects;
            if (list != null) {
                this.videoSink.setVideoEffects(list);
            }
            this.videoSink.onRendererEnabled(z2);
            Renderer.WakeupListener wakeupListener = getWakeupListener();
            if (wakeupListener != null) {
                this.videoSink.setWakeupListener(wakeupListener);
                return;
            }
            return;
        }
        this.videoFrameReleaseControl.setClock(getClock());
        this.videoFrameReleaseControl.onEnabled(z2);
    }

    @Override // androidx.media3.exoplayer.Renderer
    public void enableMayRenderStartOfStream() {
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            videoSink.enableMayRenderStartOfStream();
        } else {
            this.videoFrameReleaseControl.allowReleaseFirstFrameBeforeStarted();
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
    protected void onStreamChanged(Format[] formatArr, long j, long j2, MediaSource.MediaPeriodId mediaPeriodId) throws ExoPlaybackException {
        super.onStreamChanged(formatArr, j, j2, mediaPeriodId);
        if (this.startPositionUs == C.TIME_UNSET) {
            this.startPositionUs = j;
        }
        updatePeriodDurationUs(mediaPeriodId);
    }

    private void updatePeriodDurationUs(MediaSource.MediaPeriodId mediaPeriodId) {
        Timeline timeline = getTimeline();
        if (timeline.isEmpty()) {
            this.periodDurationUs = C.TIME_UNSET;
        } else {
            this.periodDurationUs = timeline.getPeriodByUid(((MediaSource.MediaPeriodId) Assertions.checkNotNull(mediaPeriodId)).periodUid, new Timeline.Period()).getDurationUs();
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
    protected void onPositionReset(long j, boolean z) throws ExoPlaybackException {
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            if (!z) {
                videoSink.flush(true);
            }
            this.videoSink.setStreamTimestampInfo(getOutputStreamStartPositionUs(), getBufferTimestampAdjustmentUs());
            this.pendingVideoSinkInputStreamChange = true;
        }
        super.onPositionReset(j, z);
        if (this.videoSink == null) {
            this.videoFrameReleaseControl.reset();
        }
        if (z) {
            VideoSink videoSink2 = this.videoSink;
            if (videoSink2 != null) {
                videoSink2.join(false);
            } else {
                this.videoFrameReleaseControl.join(false);
            }
        }
        maybeSetupTunnelingForFirstFrame();
        this.consecutiveDroppedFrameCount = 0;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.Renderer
    public boolean isEnded() {
        if (super.isEnded()) {
            VideoSink videoSink = this.videoSink;
            return videoSink == null || videoSink.isEnded();
        }
        return false;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.Renderer
    public boolean isReady() {
        boolean isReady = super.isReady();
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            return videoSink.isReady(isReady);
        }
        if (isReady && (getCodec() == null || this.tunneling)) {
            return true;
        }
        return this.videoFrameReleaseControl.isReady(isReady);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
    protected void onStarted() {
        super.onStarted();
        this.droppedFrames = 0;
        this.droppedFrameAccumulationStartTimeMs = getClock().elapsedRealtime();
        this.totalVideoFrameProcessingOffsetUs = 0L;
        this.videoFrameProcessingOffsetCount = 0;
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            videoSink.onRendererStarted();
        } else {
            this.videoFrameReleaseControl.onStarted();
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
    protected void onStopped() {
        maybeNotifyDroppedFrames();
        maybeNotifyVideoFrameProcessingOffset();
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            videoSink.onRendererStopped();
        } else {
            this.videoFrameReleaseControl.onStopped();
        }
        super.onStopped();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
    protected void onDisabled() {
        this.reportedVideoSize = null;
        this.periodDurationUs = C.TIME_UNSET;
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            videoSink.onRendererDisabled();
        } else {
            this.videoFrameReleaseControl.onDisabled();
        }
        maybeSetupTunnelingForFirstFrame();
        this.haveReportedFirstFrameRenderedForCurrentSurface = false;
        this.tunnelingOnFrameRenderedListener = null;
        try {
            super.onDisabled();
        } finally {
            this.eventDispatcher.disabled(this.decoderCounters);
            this.eventDispatcher.videoSizeChanged(VideoSize.UNKNOWN);
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
    protected void onReset() {
        try {
            super.onReset();
        } finally {
            this.hasSetVideoSink = false;
            this.startPositionUs = C.TIME_UNSET;
            releasePlaceholderSurface();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.BaseRenderer
    public void onRelease() {
        super.onRelease();
        VideoSink videoSink = this.videoSink;
        if (videoSink == null || !this.ownsVideoSink) {
            return;
        }
        videoSink.release();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer, androidx.media3.exoplayer.PlayerMessage.Target
    public void handleMessage(int i, Object obj) throws ExoPlaybackException {
        if (i == 1) {
            setOutput(obj);
        } else if (i == 7) {
            VideoFrameMetadataListener videoFrameMetadataListener = (VideoFrameMetadataListener) Assertions.checkNotNull(obj);
            this.frameMetadataListener = videoFrameMetadataListener;
            VideoSink videoSink = this.videoSink;
            if (videoSink != null) {
                videoSink.setVideoFrameMetadataListener(videoFrameMetadataListener);
            }
        } else if (i == 10) {
            int intValue = ((Integer) Assertions.checkNotNull(obj)).intValue();
            if (this.tunnelingAudioSessionId != intValue) {
                this.tunnelingAudioSessionId = intValue;
                if (this.tunneling) {
                    releaseCodec();
                }
            }
        } else if (i == 4) {
            this.scalingMode = ((Integer) Assertions.checkNotNull(obj)).intValue();
            MediaCodecAdapter codec = getCodec();
            if (codec != null) {
                codec.setVideoScalingMode(this.scalingMode);
            }
        } else if (i == 5) {
            int intValue2 = ((Integer) Assertions.checkNotNull(obj)).intValue();
            this.changeFrameRateStrategy = intValue2;
            VideoSink videoSink2 = this.videoSink;
            if (videoSink2 != null) {
                videoSink2.setChangeFrameRateStrategy(intValue2);
            } else {
                this.videoFrameReleaseControl.setChangeFrameRateStrategy(intValue2);
            }
        } else if (i == 13) {
            setVideoEffects((List) Assertions.checkNotNull(obj));
        } else if (i == 14) {
            Size size = (Size) Assertions.checkNotNull(obj);
            if (size.getWidth() == 0 || size.getHeight() == 0) {
                return;
            }
            this.outputResolution = size;
            VideoSink videoSink3 = this.videoSink;
            if (videoSink3 != null) {
                videoSink3.setOutputSurfaceInfo((Surface) Assertions.checkStateNotNull(this.displaySurface), size);
            }
        } else if (i == 16) {
            this.rendererPriority = ((Integer) Assertions.checkNotNull(obj)).intValue();
            updateCodecImportance();
        } else if (i == 17) {
            Surface surface = this.displaySurface;
            setOutput(null);
            ((MediaCodecVideoRenderer) Assertions.checkNotNull(obj)).handleMessage(1, surface);
        } else {
            super.handleMessage(i, obj);
        }
    }

    private void setOutput(Object obj) throws ExoPlaybackException {
        Surface surface = obj instanceof Surface ? (Surface) obj : null;
        if (this.displaySurface == surface) {
            if (surface != null) {
                maybeRenotifyVideoSizeChanged();
                maybeRenotifyRenderedFirstFrame();
                return;
            }
            return;
        }
        this.displaySurface = surface;
        if (this.videoSink == null) {
            this.videoFrameReleaseControl.setOutputSurface(surface);
        }
        this.haveReportedFirstFrameRenderedForCurrentSurface = false;
        int state = getState();
        MediaCodecAdapter codec = getCodec();
        if (codec != null && this.videoSink == null) {
            MediaCodecInfo mediaCodecInfo = (MediaCodecInfo) Assertions.checkNotNull(getCodecInfo());
            boolean hasSurfaceForCodec = hasSurfaceForCodec(mediaCodecInfo);
            if (Util.SDK_INT >= 23 && hasSurfaceForCodec && !this.codecNeedsSetOutputSurfaceWorkaround) {
                setOutputSurface(codec, getSurfaceForCodec(mediaCodecInfo));
            } else {
                releaseCodec();
                maybeInitCodecOrBypass();
            }
        }
        if (surface != null) {
            maybeRenotifyVideoSizeChanged();
        } else {
            this.reportedVideoSize = null;
            VideoSink videoSink = this.videoSink;
            if (videoSink != null) {
                videoSink.clearOutputSurfaceInfo();
            }
        }
        if (state == 2) {
            VideoSink videoSink2 = this.videoSink;
            if (videoSink2 != null) {
                videoSink2.join(true);
            } else {
                this.videoFrameReleaseControl.join(true);
            }
        }
        maybeSetupTunnelingForFirstFrame();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected boolean shouldInitCodec(MediaCodecInfo mediaCodecInfo) {
        return hasSurfaceForCodec(mediaCodecInfo);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected boolean getCodecNeedsEosPropagation() {
        return this.tunneling && Util.SDK_INT < 23;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected MediaCodecAdapter.Configuration getMediaCodecConfiguration(MediaCodecInfo mediaCodecInfo, Format format, MediaCrypto mediaCrypto, float f) {
        String str = mediaCodecInfo.codecMimeType;
        CodecMaxValues codecMaxValues = getCodecMaxValues(mediaCodecInfo, format, getStreamFormats());
        this.codecMaxValues = codecMaxValues;
        MediaFormat mediaFormat = getMediaFormat(format, str, codecMaxValues, f, this.deviceNeedsNoPostProcessWorkaround, this.tunneling ? this.tunnelingAudioSessionId : 0);
        Surface surfaceForCodec = getSurfaceForCodec(mediaCodecInfo);
        maybeSetKeyAllowFrameDrop(mediaFormat);
        return MediaCodecAdapter.Configuration.createForVideoDecoding(mediaCodecInfo, mediaFormat, format, surfaceForCodec, mediaCrypto);
    }

    private void maybeSetKeyAllowFrameDrop(MediaFormat mediaFormat) {
        if (this.videoSink == null || Util.isFrameDropAllowedOnSurfaceInput(this.context)) {
            return;
        }
        mediaFormat.setInteger("allow-frame-drop", 0);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected DecoderReuseEvaluation canReuseCodec(MediaCodecInfo mediaCodecInfo, Format format, Format format2) {
        DecoderReuseEvaluation canReuseCodec = mediaCodecInfo.canReuseCodec(format, format2);
        int i = canReuseCodec.discardReasons;
        CodecMaxValues codecMaxValues = (CodecMaxValues) Assertions.checkNotNull(this.codecMaxValues);
        if (format2.width > codecMaxValues.width || format2.height > codecMaxValues.height) {
            i |= 256;
        }
        if (getMaxInputSize(mediaCodecInfo, format2) > codecMaxValues.inputSize) {
            i |= 64;
        }
        int i2 = i;
        return new DecoderReuseEvaluation(mediaCodecInfo.name, format, format2, i2 != 0 ? 0 : canReuseCodec.result, i2);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.Renderer
    public void render(long j, long j2) throws ExoPlaybackException {
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            try {
                videoSink.render(j, j2);
            } catch (VideoSink.VideoSinkException e) {
                throw createRendererException(e, e.format, PlaybackException.ERROR_CODE_VIDEO_FRAME_PROCESSING_FAILED);
            }
        }
        super.render(j, j2);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected void resetCodecStateForFlush() {
        super.resetCodecStateForFlush();
        this.droppedDecoderInputBufferTimestamps.clear();
        this.shouldDropDecoderInputBuffers = false;
        this.buffersInCodecCount = 0;
        this.consecutiveDroppedInputBufferCount = 0;
        Av1SampleDependencyParser av1SampleDependencyParser = this.av1SampleDependencyParser;
        if (av1SampleDependencyParser != null) {
            av1SampleDependencyParser.reset();
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.Renderer
    public void setPlaybackSpeed(float f, float f2) throws ExoPlaybackException {
        super.setPlaybackSpeed(f, f2);
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            videoSink.setPlaybackSpeed(f);
        } else {
            this.videoFrameReleaseControl.setPlaybackSpeed(f);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x008e, code lost:
        if (r3.equals(androidx.media3.common.MimeTypes.VIDEO_AV1) == false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int getCodecMaxInputSize(MediaCodecInfo mediaCodecInfo, Format format) {
        int i = format.width;
        int i2 = format.height;
        if (i == -1 || i2 == -1) {
            return -1;
        }
        String str = (String) Assertions.checkNotNull(format.sampleMimeType);
        char c = 1;
        if (MimeTypes.VIDEO_DOLBY_VISION.equals(str)) {
            Pair<Integer, Integer> codecProfileAndLevel = MediaCodecUtil.getCodecProfileAndLevel(format);
            if (codecProfileAndLevel != null) {
                int intValue = ((Integer) codecProfileAndLevel.first).intValue();
                if (intValue == 512 || intValue == 1 || intValue == 2) {
                    str = MimeTypes.VIDEO_H264;
                } else if (intValue == 1024) {
                    str = MimeTypes.VIDEO_AV1;
                }
            }
            str = MimeTypes.VIDEO_H265;
        }
        str.hashCode();
        switch (str.hashCode()) {
            case -1664118616:
                if (str.equals(MimeTypes.VIDEO_H263)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1662735862:
                break;
            case -1662541442:
                if (str.equals(MimeTypes.VIDEO_H265)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1187890754:
                if (str.equals(MimeTypes.VIDEO_MP4V)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1331836730:
                if (str.equals(MimeTypes.VIDEO_H264)) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 1599127256:
                if (str.equals(MimeTypes.VIDEO_VP8)) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 1599127257:
                if (str.equals(MimeTypes.VIDEO_VP9)) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 3:
            case 5:
                return getMaxSampleSize(i * i2, 2);
            case 2:
                return Math.max(2097152, getMaxSampleSize(i * i2, 2));
            case 4:
                if ("BRAVIA 4K 2015".equals(Build.MODEL) || ("Amazon".equals(Build.MANUFACTURER) && ("KFSOWI".equals(Build.MODEL) || ("AFTS".equals(Build.MODEL) && mediaCodecInfo.secure)))) {
                    return -1;
                }
                return getMaxSampleSize(Util.ceilDivide(i, 16) * Util.ceilDivide(i2, 16) * 256, 2);
            case 6:
                return getMaxSampleSize(i * i2, 4);
            default:
                return -1;
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected float getCodecOperatingRateV23(float f, Format format, Format[] formatArr) {
        float f2 = -1.0f;
        for (Format format2 : formatArr) {
            float f3 = format2.frameRate;
            if (f3 != -1.0f) {
                f2 = Math.max(f2, f3);
            }
        }
        if (f2 == -1.0f) {
            return -1.0f;
        }
        return f2 * f;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected boolean maybeInitializeProcessingPipeline(Format format) throws ExoPlaybackException {
        VideoSink videoSink = this.videoSink;
        if (videoSink == null || videoSink.isInitialized()) {
            return true;
        }
        try {
            return this.videoSink.initialize(format);
        } catch (VideoSink.VideoSinkException e) {
            throw createRendererException(e, format, 7000);
        }
    }

    public void setVideoEffects(List<Effect> list) {
        this.videoEffects = list;
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            videoSink.setVideoEffects(list);
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected void onCodecInitialized(String str, MediaCodecAdapter.Configuration configuration, long j, long j2) {
        this.eventDispatcher.decoderInitialized(str, j, j2);
        this.codecNeedsSetOutputSurfaceWorkaround = codecNeedsSetOutputSurfaceWorkaround(str);
        this.codecHandlesHdr10PlusOutOfBandMetadata = ((MediaCodecInfo) Assertions.checkNotNull(getCodecInfo())).isHdr10PlusOutOfBandMetadataSupported();
        maybeSetupTunnelingForFirstFrame();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected void onCodecReleased(String str) {
        this.eventDispatcher.decoderReleased(str);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected void onCodecError(Exception exc) {
        Log.e(TAG, "Video codec error", exc);
        this.eventDispatcher.videoCodecError(exc);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected void onWakeupListenerSet(Renderer.WakeupListener wakeupListener) {
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            videoSink.setWakeupListener(wakeupListener);
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected DecoderReuseEvaluation onInputFormatChanged(FormatHolder formatHolder) throws ExoPlaybackException {
        DecoderReuseEvaluation onInputFormatChanged = super.onInputFormatChanged(formatHolder);
        this.eventDispatcher.inputFormatChanged((Format) Assertions.checkNotNull(formatHolder.format), onInputFormatChanged);
        return onInputFormatChanged;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
        if (this.av1SampleDependencyParser != null && ((MediaCodecInfo) Assertions.checkNotNull(getCodecInfo())).mimeType.equals(MimeTypes.VIDEO_AV1) && decoderInputBuffer.data != null) {
            this.av1SampleDependencyParser.queueInputBuffer(decoderInputBuffer.data);
        }
        this.consecutiveDroppedInputBufferCount = 0;
        if (!this.tunneling) {
            this.buffersInCodecCount++;
        }
        if (Util.SDK_INT >= 23 || !this.tunneling) {
            return;
        }
        onProcessedTunneledBuffer(decoderInputBuffer.timeUs);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected int getCodecBufferFlags(DecoderInputBuffer decoderInputBuffer) {
        return (Util.SDK_INT >= 34 && this.tunneling && isBufferBeforeStartTime(decoderInputBuffer)) ? 32 : 0;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected boolean shouldDiscardDecoderInputBuffer(DecoderInputBuffer decoderInputBuffer) {
        if (isBufferProbablyLastSample(decoderInputBuffer) || decoderInputBuffer.isEncrypted()) {
            return false;
        }
        boolean isBufferBeforeStartTime = isBufferBeforeStartTime(decoderInputBuffer);
        if ((isBufferBeforeStartTime || this.shouldDropDecoderInputBuffers) && !decoderInputBuffer.hasSupplementalData()) {
            if (decoderInputBuffer.notDependedOn()) {
                decoderInputBuffer.clear();
                if (isBufferBeforeStartTime) {
                    this.decoderCounters.skippedInputBufferCount++;
                } else if (this.shouldDropDecoderInputBuffers) {
                    this.droppedDecoderInputBufferTimestamps.add(Long.valueOf(decoderInputBuffer.timeUs));
                    this.consecutiveDroppedInputBufferCount++;
                }
                return true;
            }
            if (this.av1SampleDependencyParser != null && ((MediaCodecInfo) Assertions.checkNotNull(getCodecInfo())).mimeType.equals(MimeTypes.VIDEO_AV1) && decoderInputBuffer.data != null) {
                boolean z = isBufferBeforeStartTime || this.consecutiveDroppedInputBufferCount <= 0;
                ByteBuffer asReadOnlyBuffer = decoderInputBuffer.data.asReadOnlyBuffer();
                asReadOnlyBuffer.flip();
                int sampleLimitAfterSkippingNonReferenceFrame = this.av1SampleDependencyParser.sampleLimitAfterSkippingNonReferenceFrame(asReadOnlyBuffer, z);
                boolean z2 = ((CodecMaxValues) Assertions.checkNotNull(this.codecMaxValues)).inputSize + sampleLimitAfterSkippingNonReferenceFrame < asReadOnlyBuffer.capacity();
                if (sampleLimitAfterSkippingNonReferenceFrame != asReadOnlyBuffer.limit() && z2) {
                    ((ByteBuffer) Assertions.checkNotNull(decoderInputBuffer.data)).position(sampleLimitAfterSkippingNonReferenceFrame);
                    if (isBufferBeforeStartTime) {
                        this.decoderCounters.skippedInputBufferCount++;
                    } else if (this.shouldDropDecoderInputBuffers) {
                        this.droppedDecoderInputBufferTimestamps.add(Long.valueOf(decoderInputBuffer.timeUs));
                        this.consecutiveDroppedInputBufferCount++;
                    }
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private boolean isBufferProbablyLastSample(DecoderInputBuffer decoderInputBuffer) {
        if (hasReadStreamToEnd() || decoderInputBuffer.isLastSample() || this.periodDurationUs == C.TIME_UNSET) {
            return true;
        }
        return this.periodDurationUs - (decoderInputBuffer.timeUs - getOutputStreamOffsetUs()) <= 100000;
    }

    private boolean isBufferBeforeStartTime(DecoderInputBuffer decoderInputBuffer) {
        return decoderInputBuffer.timeUs < getLastResetPositionUs();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected void onOutputFormatChanged(Format format, MediaFormat mediaFormat) {
        int integer;
        int integer2;
        int i;
        int i2;
        MediaCodecAdapter codec = getCodec();
        if (codec != null) {
            codec.setVideoScalingMode(this.scalingMode);
        }
        if (this.tunneling) {
            i2 = format.width;
            i = format.height;
        } else {
            Assertions.checkNotNull(mediaFormat);
            boolean z = mediaFormat.containsKey(KEY_CROP_RIGHT) && mediaFormat.containsKey(KEY_CROP_LEFT) && mediaFormat.containsKey(KEY_CROP_BOTTOM) && mediaFormat.containsKey(KEY_CROP_TOP);
            if (z) {
                integer = (mediaFormat.getInteger(KEY_CROP_RIGHT) - mediaFormat.getInteger(KEY_CROP_LEFT)) + 1;
            } else {
                integer = mediaFormat.getInteger("width");
            }
            if (z) {
                integer2 = (mediaFormat.getInteger(KEY_CROP_BOTTOM) - mediaFormat.getInteger(KEY_CROP_TOP)) + 1;
            } else {
                integer2 = mediaFormat.getInteger("height");
            }
            int i3 = integer;
            i = integer2;
            i2 = i3;
        }
        float f = format.pixelWidthHeightRatio;
        if (format.rotationDegrees == 90 || format.rotationDegrees == 270) {
            f = 1.0f / f;
            int i4 = i;
            i = i2;
            i2 = i4;
        }
        this.decodedVideoSize = new VideoSize(i2, i, f);
        VideoSink videoSink = this.videoSink;
        if (videoSink != null && this.pendingVideoSinkInputStreamChange) {
            changeVideoSinkInputStream(videoSink, 1, format.buildUpon().setWidth(i2).setHeight(i).setPixelWidthHeightRatio(f).build());
        } else {
            this.videoFrameReleaseControl.setFrameRate(format.frameRate);
        }
        this.pendingVideoSinkInputStreamChange = false;
    }

    protected void changeVideoSinkInputStream(VideoSink videoSink, int i, Format format) {
        List<Effect> list = this.videoEffects;
        if (list == null) {
            list = ImmutableList.of();
        }
        videoSink.onInputStreamChanged(i, format, list);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected void handleInputBufferSupplementalData(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
        if (this.codecHandlesHdr10PlusOutOfBandMetadata) {
            ByteBuffer byteBuffer = (ByteBuffer) Assertions.checkNotNull(decoderInputBuffer.supplementalData);
            if (byteBuffer.remaining() >= 7) {
                byte b = byteBuffer.get();
                short s = byteBuffer.getShort();
                short s2 = byteBuffer.getShort();
                byte b2 = byteBuffer.get();
                byte b3 = byteBuffer.get();
                byteBuffer.position(0);
                if (b == -75 && s == 60 && s2 == 1 && b2 == 4) {
                    if (b3 == 0 || b3 == 1) {
                        byte[] bArr = new byte[byteBuffer.remaining()];
                        byteBuffer.get(bArr);
                        byteBuffer.position(0);
                        setHdr10PlusInfoV29((MediaCodecAdapter) Assertions.checkNotNull(getCodec()), bArr);
                    }
                }
            }
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected boolean processOutputBuffer(long j, long j2, final MediaCodecAdapter mediaCodecAdapter, ByteBuffer byteBuffer, final int i, int i2, int i3, long j3, boolean z, boolean z2, Format format) throws ExoPlaybackException {
        Assertions.checkNotNull(mediaCodecAdapter);
        final long outputStreamOffsetUs = j3 - getOutputStreamOffsetUs();
        updateDroppedBufferCountersWithInputBuffers(j3);
        if (this.videoSink != null) {
            if (z && !z2) {
                skipOutputBuffer(mediaCodecAdapter, i, outputStreamOffsetUs);
                return true;
            }
            return this.videoSink.handleInputFrame(getBufferTimestampAdjustmentUs() + j3, z2, new VideoSink.VideoFrameHandler() { // from class: androidx.media3.exoplayer.video.MediaCodecVideoRenderer.2
                @Override // androidx.media3.exoplayer.video.VideoSink.VideoFrameHandler
                public void render(long j4) {
                    MediaCodecVideoRenderer.this.renderOutputBuffer(mediaCodecAdapter, i, outputStreamOffsetUs, j4);
                }

                @Override // androidx.media3.exoplayer.video.VideoSink.VideoFrameHandler
                public void skip() {
                    MediaCodecVideoRenderer.this.skipOutputBuffer(mediaCodecAdapter, i, outputStreamOffsetUs);
                }
            });
        }
        int frameReleaseAction = this.videoFrameReleaseControl.getFrameReleaseAction(j3, j, j2, getOutputStreamStartPositionUs(), z, z2, this.videoFrameReleaseInfo);
        if (frameReleaseAction == 0) {
            long nanoTime = getClock().nanoTime();
            notifyFrameMetadataListener(outputStreamOffsetUs, nanoTime, format);
            renderOutputBuffer(mediaCodecAdapter, i, outputStreamOffsetUs, nanoTime);
            updateVideoFrameProcessingOffsetCounters(this.videoFrameReleaseInfo.getEarlyUs());
            return true;
        } else if (frameReleaseAction == 1) {
            releaseFrame((MediaCodecAdapter) Assertions.checkStateNotNull(mediaCodecAdapter), i, outputStreamOffsetUs, format);
            return true;
        } else if (frameReleaseAction == 2) {
            dropOutputBuffer(mediaCodecAdapter, i, outputStreamOffsetUs);
            updateVideoFrameProcessingOffsetCounters(this.videoFrameReleaseInfo.getEarlyUs());
            return true;
        } else if (frameReleaseAction == 3) {
            skipOutputBuffer(mediaCodecAdapter, i, outputStreamOffsetUs);
            updateVideoFrameProcessingOffsetCounters(this.videoFrameReleaseInfo.getEarlyUs());
            return true;
        } else if (frameReleaseAction == 4 || frameReleaseAction == 5) {
            return false;
        } else {
            throw new IllegalStateException(String.valueOf(frameReleaseAction));
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected void renderToEndOfStream() {
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            videoSink.signalEndOfCurrentInputStream();
        }
    }

    protected long getBufferTimestampAdjustmentUs() {
        return -this.startPositionUs;
    }

    private void releaseFrame(MediaCodecAdapter mediaCodecAdapter, int i, long j, Format format) {
        MediaCodecVideoRenderer mediaCodecVideoRenderer;
        long releaseTimeNs = this.videoFrameReleaseInfo.getReleaseTimeNs();
        long earlyUs = this.videoFrameReleaseInfo.getEarlyUs();
        if (shouldSkipBuffersWithIdenticalReleaseTime() && releaseTimeNs == this.lastFrameReleaseTimeNs) {
            skipOutputBuffer(mediaCodecAdapter, i, j);
            mediaCodecVideoRenderer = this;
        } else {
            mediaCodecVideoRenderer = this;
            mediaCodecVideoRenderer.notifyFrameMetadataListener(j, releaseTimeNs, format);
            mediaCodecVideoRenderer.renderOutputBufferV21(mediaCodecAdapter, i, j, releaseTimeNs);
            releaseTimeNs = releaseTimeNs;
        }
        updateVideoFrameProcessingOffsetCounters(earlyUs);
        mediaCodecVideoRenderer.lastFrameReleaseTimeNs = releaseTimeNs;
    }

    private void notifyFrameMetadataListener(long j, long j2, Format format) {
        VideoFrameMetadataListener videoFrameMetadataListener = this.frameMetadataListener;
        if (videoFrameMetadataListener != null) {
            videoFrameMetadataListener.onVideoFrameAboutToBeRendered(j, j2, format, getCodecOutputMediaFormat());
        }
    }

    protected void onProcessedTunneledBuffer(long j) throws ExoPlaybackException {
        updateOutputFormatForTime(j);
        maybeNotifyVideoSizeChanged(this.decodedVideoSize);
        this.decoderCounters.renderedOutputBufferCount++;
        maybeNotifyRenderedFirstFrame();
        onProcessedOutputBuffer(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onProcessedTunneledEndOfStream() {
        setPendingOutputEndOfStream();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected void onProcessedOutputBuffer(long j) {
        super.onProcessedOutputBuffer(j);
        if (this.tunneling) {
            return;
        }
        this.buffersInCodecCount--;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected void onProcessedStreamChange() {
        super.onProcessedStreamChange();
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            videoSink.signalEndOfCurrentInputStream();
            this.videoSink.setStreamTimestampInfo(getOutputStreamStartPositionUs(), getBufferTimestampAdjustmentUs());
        } else {
            this.videoFrameReleaseControl.onProcessedStreamChange();
        }
        this.pendingVideoSinkInputStreamChange = true;
        maybeSetupTunnelingForFirstFrame();
    }

    protected void skipOutputBuffer(MediaCodecAdapter mediaCodecAdapter, int i, long j) {
        TraceUtil.beginSection("skipVideoBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i, false);
        TraceUtil.endSection();
        this.decoderCounters.skippedOutputBufferCount++;
    }

    protected void dropOutputBuffer(MediaCodecAdapter mediaCodecAdapter, int i, long j) {
        TraceUtil.beginSection("dropVideoBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i, false);
        TraceUtil.endSection();
        updateDroppedBufferCounters(0, 1);
    }

    protected boolean maybeDropBuffersToKeyframe(long j, boolean z) throws ExoPlaybackException {
        int skipSource = skipSource(j);
        if (skipSource == 0) {
            return false;
        }
        if (z) {
            this.decoderCounters.skippedInputBufferCount += skipSource;
            this.decoderCounters.skippedOutputBufferCount += this.buffersInCodecCount;
            this.decoderCounters.skippedInputBufferCount += this.droppedDecoderInputBufferTimestamps.size();
        } else {
            this.decoderCounters.droppedToKeyframeCount++;
            updateDroppedBufferCounters(skipSource + this.droppedDecoderInputBufferTimestamps.size(), this.buffersInCodecCount);
        }
        flushOrReinitializeCodec();
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            videoSink.flush(false);
        }
        return true;
    }

    protected void updateDroppedBufferCounters(int i, int i2) {
        this.decoderCounters.droppedInputBufferCount += i;
        int i3 = i + i2;
        this.decoderCounters.droppedBufferCount += i3;
        this.droppedFrames += i3;
        this.consecutiveDroppedFrameCount += i3;
        this.decoderCounters.maxConsecutiveDroppedBufferCount = Math.max(this.consecutiveDroppedFrameCount, this.decoderCounters.maxConsecutiveDroppedBufferCount);
        int i4 = this.maxDroppedFramesToNotify;
        if (i4 <= 0 || this.droppedFrames < i4) {
            return;
        }
        maybeNotifyDroppedFrames();
    }

    private void updateDroppedBufferCountersWithInputBuffers(long j) {
        int i = 0;
        while (true) {
            Long peek = this.droppedDecoderInputBufferTimestamps.peek();
            if (peek == null || peek.longValue() >= j) {
                break;
            }
            i++;
            this.droppedDecoderInputBufferTimestamps.poll();
        }
        updateDroppedBufferCounters(i, 0);
    }

    protected void updateVideoFrameProcessingOffsetCounters(long j) {
        this.decoderCounters.addVideoFrameProcessingOffset(j);
        this.totalVideoFrameProcessingOffsetUs += j;
        this.videoFrameProcessingOffsetCount++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void renderOutputBuffer(MediaCodecAdapter mediaCodecAdapter, int i, long j, long j2) {
        renderOutputBufferV21(mediaCodecAdapter, i, j, j2);
    }

    @Deprecated
    protected void renderOutputBuffer(MediaCodecAdapter mediaCodecAdapter, int i, long j) {
        TraceUtil.beginSection("releaseOutputBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i, true);
        TraceUtil.endSection();
        this.decoderCounters.renderedOutputBufferCount++;
        this.consecutiveDroppedFrameCount = 0;
        if (this.videoSink == null) {
            maybeNotifyVideoSizeChanged(this.decodedVideoSize);
            maybeNotifyRenderedFirstFrame();
        }
    }

    protected void renderOutputBufferV21(MediaCodecAdapter mediaCodecAdapter, int i, long j, long j2) {
        TraceUtil.beginSection("releaseOutputBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i, j2);
        TraceUtil.endSection();
        this.decoderCounters.renderedOutputBufferCount++;
        this.consecutiveDroppedFrameCount = 0;
        if (this.videoSink == null) {
            maybeNotifyVideoSizeChanged(this.decodedVideoSize);
            maybeNotifyRenderedFirstFrame();
        }
    }

    private boolean hasSurfaceForCodec(MediaCodecInfo mediaCodecInfo) {
        if (this.videoSink == null) {
            Surface surface = this.displaySurface;
            return (surface != null && surface.isValid()) || shouldUseDetachedSurface(mediaCodecInfo) || shouldUsePlaceholderSurface(mediaCodecInfo);
        }
        return true;
    }

    private Surface getSurfaceForCodec(MediaCodecInfo mediaCodecInfo) {
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            return videoSink.getInputSurface();
        }
        Surface surface = this.displaySurface;
        if (surface != null) {
            return surface;
        }
        if (shouldUseDetachedSurface(mediaCodecInfo)) {
            return null;
        }
        Assertions.checkState(shouldUsePlaceholderSurface(mediaCodecInfo));
        PlaceholderSurface placeholderSurface = this.placeholderSurface;
        if (placeholderSurface != null && placeholderSurface.secure != mediaCodecInfo.secure) {
            releasePlaceholderSurface();
        }
        if (this.placeholderSurface == null) {
            this.placeholderSurface = PlaceholderSurface.newInstance(this.context, mediaCodecInfo.secure);
        }
        return this.placeholderSurface;
    }

    protected boolean shouldUseDetachedSurface(MediaCodecInfo mediaCodecInfo) {
        return Util.SDK_INT >= 35 && mediaCodecInfo.detachedSurfaceSupported;
    }

    protected boolean shouldUsePlaceholderSurface(MediaCodecInfo mediaCodecInfo) {
        if (Util.SDK_INT < 23 || this.tunneling || codecNeedsSetOutputSurfaceWorkaround(mediaCodecInfo.name)) {
            return false;
        }
        return !mediaCodecInfo.secure || PlaceholderSurface.isSecureSupported(this.context);
    }

    private void releasePlaceholderSurface() {
        PlaceholderSurface placeholderSurface = this.placeholderSurface;
        if (placeholderSurface != null) {
            placeholderSurface.release();
            this.placeholderSurface = null;
        }
    }

    private void maybeSetupTunnelingForFirstFrame() {
        MediaCodecAdapter codec;
        if (!this.tunneling || Util.SDK_INT < 23 || (codec = getCodec()) == null) {
            return;
        }
        this.tunnelingOnFrameRenderedListener = new OnFrameRenderedListenerV23(codec);
        if (Util.SDK_INT >= 33) {
            Bundle bundle = new Bundle();
            bundle.putInt("tunnel-peek", 1);
            codec.setParameters(bundle);
        }
    }

    private void updateCodecImportance() {
        MediaCodecAdapter codec = getCodec();
        if (codec != null && Util.SDK_INT >= 35) {
            Bundle bundle = new Bundle();
            bundle.putInt("importance", Math.max(0, -this.rendererPriority));
            codec.setParameters(bundle);
        }
    }

    private void maybeNotifyRenderedFirstFrame() {
        if (!this.videoFrameReleaseControl.onFrameReleasedIsFirstFrame() || this.displaySurface == null) {
            return;
        }
        notifyRenderedFirstFrame();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresNonNull({"displaySurface"})
    public void notifyRenderedFirstFrame() {
        this.eventDispatcher.renderedFirstFrame(this.displaySurface);
        this.haveReportedFirstFrameRenderedForCurrentSurface = true;
    }

    private void maybeRenotifyRenderedFirstFrame() {
        Surface surface = this.displaySurface;
        if (surface == null || !this.haveReportedFirstFrameRenderedForCurrentSurface) {
            return;
        }
        this.eventDispatcher.renderedFirstFrame(surface);
    }

    private void maybeNotifyVideoSizeChanged(VideoSize videoSize) {
        if (videoSize.equals(VideoSize.UNKNOWN) || videoSize.equals(this.reportedVideoSize)) {
            return;
        }
        this.reportedVideoSize = videoSize;
        this.eventDispatcher.videoSizeChanged(videoSize);
    }

    private void maybeRenotifyVideoSizeChanged() {
        VideoSize videoSize = this.reportedVideoSize;
        if (videoSize != null) {
            this.eventDispatcher.videoSizeChanged(videoSize);
        }
    }

    private void maybeNotifyDroppedFrames() {
        if (this.droppedFrames > 0) {
            long elapsedRealtime = getClock().elapsedRealtime();
            this.eventDispatcher.droppedFrames(this.droppedFrames, elapsedRealtime - this.droppedFrameAccumulationStartTimeMs);
            this.droppedFrames = 0;
            this.droppedFrameAccumulationStartTimeMs = elapsedRealtime;
        }
    }

    private void maybeNotifyVideoFrameProcessingOffset() {
        int i = this.videoFrameProcessingOffsetCount;
        if (i != 0) {
            this.eventDispatcher.reportVideoFrameProcessingOffset(this.totalVideoFrameProcessingOffsetUs, i);
            this.totalVideoFrameProcessingOffsetUs = 0L;
            this.videoFrameProcessingOffsetCount = 0;
        }
    }

    private static void setHdr10PlusInfoV29(MediaCodecAdapter mediaCodecAdapter, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("hdr10-plus-info", bArr);
        mediaCodecAdapter.setParameters(bundle);
    }

    private void setOutputSurface(MediaCodecAdapter mediaCodecAdapter, Surface surface) {
        if (Util.SDK_INT >= 23 && surface != null) {
            setOutputSurfaceV23(mediaCodecAdapter, surface);
        } else if (Util.SDK_INT >= 35) {
            detachOutputSurfaceV35(mediaCodecAdapter);
        } else {
            throw new IllegalStateException();
        }
    }

    protected void setOutputSurfaceV23(MediaCodecAdapter mediaCodecAdapter, Surface surface) {
        mediaCodecAdapter.setOutputSurface(surface);
    }

    protected void detachOutputSurfaceV35(MediaCodecAdapter mediaCodecAdapter) {
        mediaCodecAdapter.detachOutputSurface();
    }

    protected MediaFormat getMediaFormat(Format format, String str, CodecMaxValues codecMaxValues, float f, boolean z, int i) {
        Pair<Integer, Integer> codecProfileAndLevel;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("width", format.width);
        mediaFormat.setInteger("height", format.height);
        MediaFormatUtil.setCsdBuffers(mediaFormat, format.initializationData);
        MediaFormatUtil.maybeSetFloat(mediaFormat, "frame-rate", format.frameRate);
        MediaFormatUtil.maybeSetInteger(mediaFormat, "rotation-degrees", format.rotationDegrees);
        MediaFormatUtil.maybeSetColorInfo(mediaFormat, format.colorInfo);
        if (MimeTypes.VIDEO_DOLBY_VISION.equals(format.sampleMimeType) && (codecProfileAndLevel = MediaCodecUtil.getCodecProfileAndLevel(format)) != null) {
            MediaFormatUtil.maybeSetInteger(mediaFormat, Scopes.PROFILE, ((Integer) codecProfileAndLevel.first).intValue());
        }
        mediaFormat.setInteger("max-width", codecMaxValues.width);
        mediaFormat.setInteger("max-height", codecMaxValues.height);
        MediaFormatUtil.maybeSetInteger(mediaFormat, "max-input-size", codecMaxValues.inputSize);
        if (Util.SDK_INT >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f != -1.0f) {
                mediaFormat.setFloat("operating-rate", f);
            }
        }
        if (z) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (i != 0) {
            mediaFormat.setFeatureEnabled("tunneled-playback", true);
            mediaFormat.setInteger("audio-session-id", i);
        }
        if (Util.SDK_INT >= 35) {
            mediaFormat.setInteger("importance", Math.max(0, -this.rendererPriority));
        }
        return mediaFormat;
    }

    protected CodecMaxValues getCodecMaxValues(MediaCodecInfo mediaCodecInfo, Format format, Format[] formatArr) {
        int codecMaxInputSize;
        int i = format.width;
        int i2 = format.height;
        int maxInputSize = getMaxInputSize(mediaCodecInfo, format);
        if (formatArr.length == 1) {
            if (maxInputSize != -1 && (codecMaxInputSize = getCodecMaxInputSize(mediaCodecInfo, format)) != -1) {
                maxInputSize = Math.min((int) (maxInputSize * INITIAL_FORMAT_MAX_INPUT_SIZE_SCALE_FACTOR), codecMaxInputSize);
            }
            return new CodecMaxValues(i, i2, maxInputSize);
        }
        int length = formatArr.length;
        boolean z = false;
        for (int i3 = 0; i3 < length; i3++) {
            Format format2 = formatArr[i3];
            if (format.colorInfo != null && format2.colorInfo == null) {
                format2 = format2.buildUpon().setColorInfo(format.colorInfo).build();
            }
            if (mediaCodecInfo.canReuseCodec(format, format2).result != 0) {
                z |= format2.width == -1 || format2.height == -1;
                i = Math.max(i, format2.width);
                i2 = Math.max(i2, format2.height);
                maxInputSize = Math.max(maxInputSize, getMaxInputSize(mediaCodecInfo, format2));
            }
        }
        if (z) {
            Log.w(TAG, "Resolutions unknown. Codec max resolution: " + i + "x" + i2);
            Point codecMaxSize = getCodecMaxSize(mediaCodecInfo, format);
            if (codecMaxSize != null) {
                i = Math.max(i, codecMaxSize.x);
                i2 = Math.max(i2, codecMaxSize.y);
                maxInputSize = Math.max(maxInputSize, getCodecMaxInputSize(mediaCodecInfo, format.buildUpon().setWidth(i).setHeight(i2).build()));
                Log.w(TAG, "Codec max resolution adjusted to: " + i + "x" + i2);
            }
        }
        return new CodecMaxValues(i, i2, maxInputSize);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected MediaCodecDecoderException createDecoderException(Throwable th, MediaCodecInfo mediaCodecInfo) {
        return new MediaCodecVideoDecoderException(th, mediaCodecInfo, this.displaySurface);
    }

    private static Point getCodecMaxSize(MediaCodecInfo mediaCodecInfo, Format format) {
        int[] iArr;
        boolean z = format.height > format.width;
        int i = z ? format.height : format.width;
        int i2 = z ? format.width : format.height;
        float f = i2 / i;
        for (int i3 : STANDARD_LONG_EDGE_VIDEO_PX) {
            int i4 = (int) (i3 * f);
            if (i3 <= i || i4 <= i2) {
                break;
            }
            int i5 = z ? i4 : i3;
            if (!z) {
                i3 = i4;
            }
            Point alignVideoSizeV21 = mediaCodecInfo.alignVideoSizeV21(i5, i3);
            float f2 = format.frameRate;
            if (alignVideoSizeV21 != null && mediaCodecInfo.isVideoSizeAndRateSupportedV21(alignVideoSizeV21.x, alignVideoSizeV21.y, f2)) {
                return alignVideoSizeV21;
            }
        }
        return null;
    }

    protected static int getMaxInputSize(MediaCodecInfo mediaCodecInfo, Format format) {
        if (format.maxInputSize != -1) {
            int size = format.initializationData.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                i += format.initializationData.get(i2).length;
            }
            return format.maxInputSize + i;
        }
        return getCodecMaxInputSize(mediaCodecInfo, format);
    }

    private static boolean deviceNeedsNoPostProcessWorkaround() {
        return "NVIDIA".equals(Build.MANUFACTURER);
    }

    protected boolean codecNeedsSetOutputSurfaceWorkaround(String str) {
        if (str.startsWith("OMX.google")) {
            return false;
        }
        synchronized (MediaCodecVideoRenderer.class) {
            if (!evaluatedDeviceNeedsSetOutputSurfaceWorkaround) {
                deviceNeedsSetOutputSurfaceWorkaround = evaluateDeviceNeedsSetOutputSurfaceWorkaround();
                evaluatedDeviceNeedsSetOutputSurfaceWorkaround = true;
            }
        }
        return deviceNeedsSetOutputSurfaceWorkaround;
    }

    protected Surface getSurface() {
        return this.displaySurface;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public static final class CodecMaxValues {
        public final int height;
        public final int inputSize;
        public final int width;

        public CodecMaxValues(int i, int i2, int i3) {
            this.width = i;
            this.height = i2;
            this.inputSize = i3;
        }
    }

    private static int getMaxSampleSize(int i, int i2) {
        return (i * 3) / (i2 * 2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:621:0x084d, code lost:
        if (r0.equals("PGN528") == false) goto L46;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean evaluateDeviceNeedsSetOutputSurfaceWorkaround() {
        boolean z;
        boolean z2;
        char c = 7;
        if (Util.SDK_INT <= 28) {
            String str = Build.DEVICE;
            str.hashCode();
            switch (str.hashCode()) {
                case -1339091551:
                    if (str.equals("dangal")) {
                        z2 = false;
                        break;
                    }
                    z2 = true;
                    break;
                case -1220081023:
                    if (str.equals("dangalFHD")) {
                        z2 = true;
                        break;
                    }
                    z2 = true;
                    break;
                case -1220066608:
                    if (str.equals("dangalUHD")) {
                        z2 = true;
                        break;
                    }
                    z2 = true;
                    break;
                case -1012436106:
                    if (str.equals("oneday")) {
                        z2 = true;
                        break;
                    }
                    z2 = true;
                    break;
                case -760312546:
                    if (str.equals("aquaman")) {
                        z2 = true;
                        break;
                    }
                    z2 = true;
                    break;
                case -64886864:
                    if (str.equals("magnolia")) {
                        z2 = true;
                        break;
                    }
                    z2 = true;
                    break;
                case 3415681:
                    if (str.equals("once")) {
                        z2 = true;
                        break;
                    }
                    z2 = true;
                    break;
                case 825323514:
                    if (str.equals("machuca")) {
                        z2 = true;
                        break;
                    }
                    z2 = true;
                    break;
                default:
                    z2 = true;
                    break;
            }
            switch (z2) {
                case false:
                case true:
                case true:
                case true:
                case true:
                case true:
                case true:
                case true:
                    return true;
            }
        }
        if (Util.SDK_INT > 27 || !"HWEML".equals(Build.DEVICE)) {
            String str2 = Build.MODEL;
            str2.hashCode();
            switch (str2.hashCode()) {
                case -349662828:
                    if (str2.equals("AFTJMST12")) {
                        z = false;
                        break;
                    }
                    z = true;
                    break;
                case -321033677:
                    if (str2.equals("AFTKMST12")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 2006354:
                    if (str2.equals("AFTA")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 2006367:
                    if (str2.equals("AFTN")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 2006371:
                    if (str2.equals("AFTR")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 1785421873:
                    if (str2.equals("AFTEU011")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 1785421876:
                    if (str2.equals("AFTEU014")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 1798172390:
                    if (str2.equals("AFTSO001")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 2119412532:
                    if (str2.equals("AFTEUFF014")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                default:
                    z = true;
                    break;
            }
            switch (z) {
                case false:
                case true:
                case true:
                case true:
                case true:
                case true:
                case true:
                case true:
                case true:
                    return true;
                default:
                    if (Util.SDK_INT <= 26) {
                        String str3 = Build.DEVICE;
                        str3.hashCode();
                        switch (str3.hashCode()) {
                            case -2144781245:
                                if (str3.equals("GIONEE_SWW1609")) {
                                    c = 0;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -2144781185:
                                if (str3.equals("GIONEE_SWW1627")) {
                                    c = 1;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -2144781160:
                                if (str3.equals("GIONEE_SWW1631")) {
                                    c = 2;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -2097309513:
                                if (str3.equals("K50a40")) {
                                    c = 3;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -2022874474:
                                if (str3.equals("CP8676_I02")) {
                                    c = 4;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1978993182:
                                if (str3.equals("NX541J")) {
                                    c = 5;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1978990237:
                                if (str3.equals("NX573J")) {
                                    c = 6;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1936688988:
                                break;
                            case -1936688066:
                                if (str3.equals("PGN610")) {
                                    c = '\b';
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1936688065:
                                if (str3.equals("PGN611")) {
                                    c = '\t';
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1931988508:
                                if (str3.equals("AquaPowerM")) {
                                    c = '\n';
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1885099851:
                                if (str3.equals("RAIJIN")) {
                                    c = 11;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1696512866:
                                if (str3.equals("XT1663")) {
                                    c = '\f';
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1680025915:
                                if (str3.equals("ComioS1")) {
                                    c = '\r';
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1615810839:
                                if (str3.equals("Phantom6")) {
                                    c = 14;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1600724499:
                                if (str3.equals("pacificrim")) {
                                    c = 15;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1554255044:
                                if (str3.equals("vernee_M5")) {
                                    c = 16;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1481772737:
                                if (str3.equals("panell_dl")) {
                                    c = 17;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1481772730:
                                if (str3.equals("panell_ds")) {
                                    c = 18;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1481772729:
                                if (str3.equals("panell_dt")) {
                                    c = 19;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1320080169:
                                if (str3.equals("GiONEE_GBL7319")) {
                                    c = 20;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1217592143:
                                if (str3.equals("BRAVIA_ATV2")) {
                                    c = 21;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1180384755:
                                if (str3.equals("iris60")) {
                                    c = 22;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1139198265:
                                if (str3.equals("Slate_Pro")) {
                                    c = 23;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1052835013:
                                if (str3.equals("namath")) {
                                    c = 24;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -993250464:
                                if (str3.equals("A10-70F")) {
                                    c = 25;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -993250458:
                                if (str3.equals("A10-70L")) {
                                    c = 26;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -965403638:
                                if (str3.equals("s905x018")) {
                                    c = 27;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -958336948:
                                if (str3.equals("ELUGA_Ray_X")) {
                                    c = 28;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -879245230:
                                if (str3.equals("tcl_eu")) {
                                    c = 29;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -842500323:
                                if (str3.equals("nicklaus_f")) {
                                    c = 30;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -821392978:
                                if (str3.equals("A7000-a")) {
                                    c = 31;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -797483286:
                                if (str3.equals("SVP-DTV15")) {
                                    c = ' ';
                                    break;
                                }
                                c = 65535;
                                break;
                            case -794946968:
                                if (str3.equals("watson")) {
                                    c = '!';
                                    break;
                                }
                                c = 65535;
                                break;
                            case -788334647:
                                if (str3.equals("whyred")) {
                                    c = '\"';
                                    break;
                                }
                                c = 65535;
                                break;
                            case -782144577:
                                if (str3.equals("OnePlus5T")) {
                                    c = '#';
                                    break;
                                }
                                c = 65535;
                                break;
                            case -575125681:
                                if (str3.equals("GiONEE_CBL7513")) {
                                    c = Typography.dollar;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -521118391:
                                if (str3.equals("GIONEE_GBL7360")) {
                                    c = '%';
                                    break;
                                }
                                c = 65535;
                                break;
                            case -430914369:
                                if (str3.equals("Pixi4-7_3G")) {
                                    c = Typography.amp;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -290434366:
                                if (str3.equals("taido_row")) {
                                    c = '\'';
                                    break;
                                }
                                c = 65535;
                                break;
                            case -282781963:
                                if (str3.equals("BLACK-1X")) {
                                    c = '(';
                                    break;
                                }
                                c = 65535;
                                break;
                            case -277133239:
                                if (str3.equals("Z12_PRO")) {
                                    c = ')';
                                    break;
                                }
                                c = 65535;
                                break;
                            case -173639913:
                                if (str3.equals("ELUGA_A3_Pro")) {
                                    c = '*';
                                    break;
                                }
                                c = 65535;
                                break;
                            case -56598463:
                                if (str3.equals("woods_fn")) {
                                    c = '+';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 2126:
                                if (str3.equals("C1")) {
                                    c = AbstractJsonLexerKt.COMMA;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 2564:
                                if (str3.equals("Q5")) {
                                    c = '-';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 2715:
                                if (str3.equals("V1")) {
                                    c = '.';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 2719:
                                if (str3.equals("V5")) {
                                    c = '/';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 3091:
                                if (str3.equals("b5")) {
                                    c = '0';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 3483:
                                if (str3.equals("mh")) {
                                    c = '1';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 73405:
                                if (str3.equals("JGZ")) {
                                    c = '2';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 75537:
                                if (str3.equals("M04")) {
                                    c = '3';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 75739:
                                if (str3.equals("M5c")) {
                                    c = '4';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 76779:
                                if (str3.equals("MX6")) {
                                    c = '5';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 78669:
                                if (str3.equals("P85")) {
                                    c = '6';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 79305:
                                if (str3.equals("PLE")) {
                                    c = '7';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 80618:
                                if (str3.equals("QX1")) {
                                    c = '8';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 88274:
                                if (str3.equals("Z80")) {
                                    c = '9';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 98846:
                                if (str3.equals("cv1")) {
                                    c = AbstractJsonLexerKt.COLON;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 98848:
                                if (str3.equals("cv3")) {
                                    c = ';';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 99329:
                                if (str3.equals("deb")) {
                                    c = Typography.less;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 101481:
                                if (str3.equals("flo")) {
                                    c = '=';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1513190:
                                if (str3.equals("1601")) {
                                    c = Typography.greater;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1514184:
                                if (str3.equals("1713")) {
                                    c = '?';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1514185:
                                if (str3.equals("1714")) {
                                    c = '@';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 2133089:
                                if (str3.equals("F01H")) {
                                    c = 'A';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 2133091:
                                if (str3.equals("F01J")) {
                                    c = 'B';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 2133120:
                                if (str3.equals("F02H")) {
                                    c = 'C';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 2133151:
                                if (str3.equals("F03H")) {
                                    c = 'D';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 2133182:
                                if (str3.equals("F04H")) {
                                    c = 'E';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 2133184:
                                if (str3.equals("F04J")) {
                                    c = 'F';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 2436959:
                                if (str3.equals("P681")) {
                                    c = 'G';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 2463773:
                                if (str3.equals("Q350")) {
                                    c = 'H';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 2464648:
                                if (str3.equals("Q427")) {
                                    c = 'I';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 2689555:
                                if (str3.equals("XE2X")) {
                                    c = 'J';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 3154429:
                                if (str3.equals("fugu")) {
                                    c = 'K';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 3284551:
                                if (str3.equals("kate")) {
                                    c = 'L';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 3351335:
                                if (str3.equals("mido")) {
                                    c = 'M';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 3386211:
                                if (str3.equals("p212")) {
                                    c = 'N';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 41325051:
                                if (str3.equals("MEIZU_M5")) {
                                    c = 'O';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 51349633:
                                if (str3.equals("601LV")) {
                                    c = 'P';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 51350594:
                                if (str3.equals("602LV")) {
                                    c = 'Q';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 55178625:
                                if (str3.equals("Aura_Note_2")) {
                                    c = 'R';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 61542055:
                                if (str3.equals("A1601")) {
                                    c = 'S';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 65355429:
                                if (str3.equals("E5643")) {
                                    c = 'T';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 66214468:
                                if (str3.equals("F3111")) {
                                    c = 'U';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 66214470:
                                if (str3.equals("F3113")) {
                                    c = 'V';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 66214473:
                                if (str3.equals("F3116")) {
                                    c = 'W';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 66215429:
                                if (str3.equals("F3211")) {
                                    c = 'X';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 66215431:
                                if (str3.equals("F3213")) {
                                    c = 'Y';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 66215433:
                                if (str3.equals("F3215")) {
                                    c = 'Z';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 66216390:
                                if (str3.equals("F3311")) {
                                    c = AbstractJsonLexerKt.BEGIN_LIST;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 76402249:
                                if (str3.equals("PRO7S")) {
                                    c = AbstractJsonLexerKt.STRING_ESC;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 76404105:
                                if (str3.equals("Q4260")) {
                                    c = AbstractJsonLexerKt.END_LIST;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 76404911:
                                if (str3.equals("Q4310")) {
                                    c = '^';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 80963634:
                                if (str3.equals("V23GB")) {
                                    c = '_';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 82882791:
                                if (str3.equals("X3_HK")) {
                                    c = '`';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 98715550:
                                if (str3.equals("i9031")) {
                                    c = 'a';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 101370885:
                                if (str3.equals("l5460")) {
                                    c = 'b';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 102844228:
                                if (str3.equals("le_x6")) {
                                    c = 'c';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 165221241:
                                if (str3.equals("A2016a40")) {
                                    c = 'd';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 182191441:
                                if (str3.equals("CPY83_I00")) {
                                    c = 'e';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 245388979:
                                if (str3.equals("marino_f")) {
                                    c = 'f';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 287431619:
                                if (str3.equals("griffin")) {
                                    c = 'g';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 307593612:
                                if (str3.equals("A7010a48")) {
                                    c = 'h';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 308517133:
                                if (str3.equals("A7020a48")) {
                                    c = 'i';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 316215098:
                                if (str3.equals("TB3-730F")) {
                                    c = 'j';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 316215116:
                                if (str3.equals("TB3-730X")) {
                                    c = 'k';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 316246811:
                                if (str3.equals("TB3-850F")) {
                                    c = 'l';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 316246818:
                                if (str3.equals("TB3-850M")) {
                                    c = 'm';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 407160593:
                                if (str3.equals("Pixi5-10_4G")) {
                                    c = 'n';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 507412548:
                                if (str3.equals("QM16XE_U")) {
                                    c = 'o';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 793982701:
                                if (str3.equals("GIONEE_WBL5708")) {
                                    c = 'p';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 794038622:
                                if (str3.equals("GIONEE_WBL7365")) {
                                    c = 'q';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 794040393:
                                if (str3.equals("GIONEE_WBL7519")) {
                                    c = 'r';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 835649806:
                                if (str3.equals("manning")) {
                                    c = 's';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 917340916:
                                if (str3.equals("A7000plus")) {
                                    c = 't';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 958008161:
                                if (str3.equals("j2xlteins")) {
                                    c = AbstractJsonLexerKt.UNICODE_ESC;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1060579533:
                                if (str3.equals("panell_d")) {
                                    c = 'v';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1150207623:
                                if (str3.equals("LS-5017")) {
                                    c = 'w';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1176899427:
                                if (str3.equals("itel_S41")) {
                                    c = 'x';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1280332038:
                                if (str3.equals("hwALE-H")) {
                                    c = 'y';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1306947716:
                                if (str3.equals("EverStar_S")) {
                                    c = 'z';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1349174697:
                                if (str3.equals("htc_e56ml_dtul")) {
                                    c = AbstractJsonLexerKt.BEGIN_OBJ;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1522194893:
                                if (str3.equals("woods_f")) {
                                    c = '|';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1691543273:
                                if (str3.equals("CPH1609")) {
                                    c = AbstractJsonLexerKt.END_OBJ;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1691544261:
                                if (str3.equals("CPH1715")) {
                                    c = '~';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1709443163:
                                if (str3.equals("iball8735_9806")) {
                                    c = Ascii.MAX;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1865889110:
                                if (str3.equals("santoni")) {
                                    c = 128;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1906253259:
                                if (str3.equals("PB2-670M")) {
                                    c = 129;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1977196784:
                                if (str3.equals("Infinix-X572")) {
                                    c = 130;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 2006372676:
                                if (str3.equals("BRAVIA_ATV3_4K")) {
                                    c = 131;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 2019281702:
                                if (str3.equals("DM-01K")) {
                                    c = 132;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 2029784656:
                                if (str3.equals("HWBLN-H")) {
                                    c = 133;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 2030379515:
                                if (str3.equals("HWCAM-H")) {
                                    c = 134;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 2033393791:
                                if (str3.equals("ASUS_X00AD_2")) {
                                    c = 135;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 2047190025:
                                if (str3.equals("ELUGA_Note")) {
                                    c = 136;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 2047252157:
                                if (str3.equals("ELUGA_Prim")) {
                                    c = 137;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 2048319463:
                                if (str3.equals("HWVNS-H")) {
                                    c = 138;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 2048855701:
                                if (str3.equals("HWWAS-H")) {
                                    c = 139;
                                    break;
                                }
                                c = 65535;
                                break;
                            default:
                                c = 65535;
                                break;
                        }
                        switch (c) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case '\b':
                            case '\t':
                            case '\n':
                            case 11:
                            case '\f':
                            case '\r':
                            case 14:
                            case 15:
                            case 16:
                            case 17:
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case ' ':
                            case '!':
                            case '\"':
                            case '#':
                            case '$':
                            case '%':
                            case '&':
                            case '\'':
                            case '(':
                            case ')':
                            case '*':
                            case '+':
                            case ',':
                            case '-':
                            case '.':
                            case '/':
                            case '0':
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                            case '2':
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                            case '8':
                            case '9':
                            case ':':
                            case ';':
                            case '<':
                            case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                            case '>':
                            case '?':
                            case '@':
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                            case 'C':
                            case 'D':
                            case 'E':
                            case 'F':
                            case TsExtractor.TS_SYNC_BYTE /* 71 */:
                            case 'H':
                            case 'I':
                            case 'J':
                            case 'K':
                            case 'L':
                            case 'M':
                            case MdtaMetadataEntry.TYPE_INDICATOR_UNSIGNED_INT64 /* 78 */:
                            case 'O':
                            case 'P':
                            case 'Q':
                            case 'R':
                            case 'S':
                            case 'T':
                            case 'U':
                            case 'V':
                            case 'W':
                            case 'X':
                            case TsExtractor.TS_STREAM_TYPE_DVBSUBS /* 89 */:
                            case 'Z':
                            case '[':
                            case '\\':
                            case ']':
                            case '^':
                            case '_':
                            case '`':
                            case 'a':
                            case 'b':
                            case 'c':
                            case 'd':
                            case 'e':
                            case 'f':
                            case 'g':
                            case 'h':
                            case 'i':
                            case 'j':
                            case 'k':
                            case 'l':
                            case 'm':
                            case 'n':
                            case 'o':
                            case 'p':
                            case 'q':
                            case 'r':
                            case BuildConfig.API_LEVEL /* 115 */:
                            case AppInfoTableDecoder.APPLICATION_INFORMATION_TABLE_ID /* 116 */:
                            case 'u':
                            case 'v':
                            case 'w':
                            case MenuKt.InTransitionDuration /* 120 */:
                            case 'y':
                            case 'z':
                            case '{':
                            case '|':
                            case '}':
                            case WebSocketProtocol.PAYLOAD_SHORT /* 126 */:
                            case 127:
                            case 128:
                            case TsExtractor.TS_STREAM_TYPE_AC3 /* 129 */:
                            case TsExtractor.TS_STREAM_TYPE_HDMV_DTS /* 130 */:
                            case 131:
                            case 132:
                            case 133:
                            case TsExtractor.TS_STREAM_TYPE_SPLICE_INFO /* 134 */:
                            case TsExtractor.TS_STREAM_TYPE_E_AC3 /* 135 */:
                            case TsExtractor.TS_STREAM_TYPE_DTS_HD /* 136 */:
                            case 137:
                            case TsExtractor.TS_STREAM_TYPE_DTS /* 138 */:
                            case TsExtractor.TS_STREAM_TYPE_DTS_UHD /* 139 */:
                                break;
                            default:
                                String str4 = Build.MODEL;
                                str4.hashCode();
                                if (!str4.equals("JSN-L21")) {
                                }
                                break;
                        }
                        return true;
                    }
                    return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class OnFrameRenderedListenerV23 implements MediaCodecAdapter.OnFrameRenderedListener, Handler.Callback {
        private static final int HANDLE_FRAME_RENDERED = 0;
        private final Handler handler;

        public OnFrameRenderedListenerV23(MediaCodecAdapter mediaCodecAdapter) {
            Handler createHandlerForCurrentLooper = Util.createHandlerForCurrentLooper(this);
            this.handler = createHandlerForCurrentLooper;
            mediaCodecAdapter.setOnFrameRenderedListener(this, createHandlerForCurrentLooper);
        }

        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter.OnFrameRenderedListener
        public void onFrameRendered(MediaCodecAdapter mediaCodecAdapter, long j, long j2) {
            if (Util.SDK_INT < 30) {
                this.handler.sendMessageAtFrontOfQueue(Message.obtain(this.handler, 0, (int) (j >> 32), (int) j));
                return;
            }
            handleFrameRendered(j);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            handleFrameRendered(Util.toLong(message.arg1, message.arg2));
            return true;
        }

        private void handleFrameRendered(long j) {
            if (this != MediaCodecVideoRenderer.this.tunnelingOnFrameRenderedListener || MediaCodecVideoRenderer.this.getCodec() == null) {
                return;
            }
            if (j == Long.MAX_VALUE) {
                MediaCodecVideoRenderer.this.onProcessedTunneledEndOfStream();
                return;
            }
            try {
                MediaCodecVideoRenderer.this.onProcessedTunneledBuffer(j);
            } catch (ExoPlaybackException e) {
                MediaCodecVideoRenderer.this.setPendingPlaybackException(e);
            }
        }
    }
}
