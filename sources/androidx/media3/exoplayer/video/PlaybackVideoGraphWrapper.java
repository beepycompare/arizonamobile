package androidx.media3.exoplayer.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.util.Pair;
import android.util.SparseArray;
import android.view.Surface;
import androidx.media3.common.C;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.DebugViewProvider;
import androidx.media3.common.Effect;
import androidx.media3.common.Format;
import androidx.media3.common.PreviewingVideoGraph;
import androidx.media3.common.SurfaceInfo;
import androidx.media3.common.VideoCompositorSettings;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.VideoFrameProcessor;
import androidx.media3.common.VideoGraph;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.HandlerWrapper;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.TimedValueQueue;
import androidx.media3.common.util.TimestampIterator;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.Renderer;
import androidx.media3.exoplayer.video.PlaybackVideoGraphWrapper;
import androidx.media3.exoplayer.video.VideoSink;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
/* loaded from: classes2.dex */
public final class PlaybackVideoGraphWrapper implements VideoSinkProvider, VideoGraph.Listener {
    private static final Executor NO_OP_EXECUTOR = new Executor() { // from class: androidx.media3.exoplayer.video.PlaybackVideoGraphWrapper$$ExternalSyntheticLambda2
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            PlaybackVideoGraphWrapper.lambda$static$0(runnable);
        }
    };
    private static final int PRIMARY_SEQUENCE_INDEX = 0;
    private static final int STATE_CREATED = 0;
    private static final int STATE_INITIALIZED = 1;
    private static final int STATE_RELEASED = 2;
    private long bufferTimestampAdjustmentUs;
    private final Clock clock;
    private final List<Effect> compositionEffects;
    private final VideoCompositorSettings compositorSettings;
    private final Context context;
    private Pair<Surface, Size> currentSurfaceAndSize;
    private final VideoSink defaultVideoSink;
    private long finalBufferPresentationTimeUs;
    private HandlerWrapper handler;
    private boolean hasSignaledEndOfCurrentInputStream;
    private final SparseArray<InputVideoSink> inputVideoSinks;
    private long lastOutputBufferPresentationTimeUs;
    private final CopyOnWriteArraySet<Listener> listeners;
    private long outputStreamStartPositionUs;
    private int pendingFlushCount;
    private final PreviewingVideoGraph.Factory previewingVideoGraphFactory;
    private int registeredVideoInputCount;
    private final boolean requestOpenGlToneMapping;
    private int state;
    private final TimedValueQueue<Long> streamStartPositionsUs;
    private int totalVideoInputCount;
    private final VideoSink.VideoFrameHandler videoFrameHandler;
    private PreviewingVideoGraph videoGraph;
    private Format videoGraphOutputFormat;
    private Renderer.WakeupListener wakeupListener;

    /* loaded from: classes2.dex */
    public interface Listener {
        void onError(PlaybackVideoGraphWrapper playbackVideoGraphWrapper, VideoFrameProcessingException videoFrameProcessingException);

        void onFirstFrameRendered(PlaybackVideoGraphWrapper playbackVideoGraphWrapper);

        void onFrameDropped(PlaybackVideoGraphWrapper playbackVideoGraphWrapper);

        void onVideoSizeChanged(PlaybackVideoGraphWrapper playbackVideoGraphWrapper, VideoSize videoSize);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$static$0(Runnable runnable) {
    }

    @Override // androidx.media3.common.VideoGraph.Listener
    public void onEnded(long j) {
    }

    /* loaded from: classes2.dex */
    public static final class Builder {
        private boolean built;
        private final Context context;
        private PreviewingVideoGraph.Factory previewingVideoGraphFactory;
        private boolean requestOpenGlToneMapping;
        private VideoFrameProcessor.Factory videoFrameProcessorFactory;
        private final VideoFrameReleaseControl videoFrameReleaseControl;
        private List<Effect> compositionEffects = ImmutableList.of();
        private VideoCompositorSettings compositorSettings = VideoCompositorSettings.DEFAULT;
        private Clock clock = Clock.DEFAULT;

        public Builder(Context context, VideoFrameReleaseControl videoFrameReleaseControl) {
            this.context = context.getApplicationContext();
            this.videoFrameReleaseControl = videoFrameReleaseControl;
        }

        public Builder setVideoFrameProcessorFactory(VideoFrameProcessor.Factory factory) {
            this.videoFrameProcessorFactory = factory;
            return this;
        }

        public Builder setPreviewingVideoGraphFactory(PreviewingVideoGraph.Factory factory) {
            this.previewingVideoGraphFactory = factory;
            return this;
        }

        public Builder setCompositionEffects(List<Effect> list) {
            this.compositionEffects = list;
            return this;
        }

        public Builder setCompositorSettings(VideoCompositorSettings videoCompositorSettings) {
            this.compositorSettings = videoCompositorSettings;
            return this;
        }

        public Builder setClock(Clock clock) {
            this.clock = clock;
            return this;
        }

        public Builder setRequestOpenGlToneMapping(boolean z) {
            this.requestOpenGlToneMapping = z;
            return this;
        }

        public PlaybackVideoGraphWrapper build() {
            Assertions.checkState(!this.built);
            if (this.previewingVideoGraphFactory == null) {
                if (this.videoFrameProcessorFactory == null) {
                    this.videoFrameProcessorFactory = new ReflectiveDefaultVideoFrameProcessorFactory();
                }
                this.previewingVideoGraphFactory = new ReflectivePreviewingSingleInputVideoGraphFactory(this.videoFrameProcessorFactory);
            }
            PlaybackVideoGraphWrapper playbackVideoGraphWrapper = new PlaybackVideoGraphWrapper(this);
            this.built = true;
            return playbackVideoGraphWrapper;
        }
    }

    private PlaybackVideoGraphWrapper(Builder builder) {
        this.context = builder.context;
        this.streamStartPositionsUs = new TimedValueQueue<>();
        this.previewingVideoGraphFactory = (PreviewingVideoGraph.Factory) Assertions.checkStateNotNull(builder.previewingVideoGraphFactory);
        this.inputVideoSinks = new SparseArray<>();
        this.compositionEffects = builder.compositionEffects;
        this.compositorSettings = builder.compositorSettings;
        Clock clock = builder.clock;
        this.clock = clock;
        this.defaultVideoSink = new DefaultVideoSink(builder.videoFrameReleaseControl, clock);
        this.videoFrameHandler = new VideoSink.VideoFrameHandler() { // from class: androidx.media3.exoplayer.video.PlaybackVideoGraphWrapper.1
            @Override // androidx.media3.exoplayer.video.VideoSink.VideoFrameHandler
            public void render(long j) {
                ((PreviewingVideoGraph) Assertions.checkStateNotNull(PlaybackVideoGraphWrapper.this.videoGraph)).renderOutputFrame(j);
            }

            @Override // androidx.media3.exoplayer.video.VideoSink.VideoFrameHandler
            public void skip() {
                ((PreviewingVideoGraph) Assertions.checkStateNotNull(PlaybackVideoGraphWrapper.this.videoGraph)).renderOutputFrame(-2L);
            }
        };
        this.listeners = new CopyOnWriteArraySet<>();
        this.requestOpenGlToneMapping = builder.requestOpenGlToneMapping;
        this.videoGraphOutputFormat = new Format.Builder().build();
        this.lastOutputBufferPresentationTimeUs = C.TIME_UNSET;
        this.finalBufferPresentationTimeUs = C.TIME_UNSET;
        this.totalVideoInputCount = -1;
        this.state = 0;
    }

    public void addListener(Listener listener) {
        this.listeners.add(listener);
    }

    public void removeListener(Listener listener) {
        this.listeners.remove(listener);
    }

    @Override // androidx.media3.exoplayer.video.VideoSinkProvider
    public VideoSink getSink(int i) {
        Assertions.checkState(!Util.contains(this.inputVideoSinks, i));
        InputVideoSink inputVideoSink = new InputVideoSink(this.context, i);
        addListener(inputVideoSink);
        this.inputVideoSinks.put(i, inputVideoSink);
        return inputVideoSink;
    }

    @Override // androidx.media3.exoplayer.video.VideoSinkProvider
    public void setOutputSurfaceInfo(Surface surface, Size size) {
        Pair<Surface, Size> pair = this.currentSurfaceAndSize;
        if (pair != null && ((Surface) pair.first).equals(surface) && ((Size) this.currentSurfaceAndSize.second).equals(size)) {
            return;
        }
        this.currentSurfaceAndSize = Pair.create(surface, size);
        maybeSetOutputSurfaceInfo(surface, size.getWidth(), size.getHeight());
    }

    @Override // androidx.media3.exoplayer.video.VideoSinkProvider
    public void clearOutputSurfaceInfo() {
        maybeSetOutputSurfaceInfo(null, Size.UNKNOWN.getWidth(), Size.UNKNOWN.getHeight());
        this.currentSurfaceAndSize = null;
    }

    @Override // androidx.media3.exoplayer.video.VideoSinkProvider
    public void release() {
        if (this.state == 2) {
            return;
        }
        HandlerWrapper handlerWrapper = this.handler;
        if (handlerWrapper != null) {
            handlerWrapper.removeCallbacksAndMessages(null);
        }
        PreviewingVideoGraph previewingVideoGraph = this.videoGraph;
        if (previewingVideoGraph != null) {
            previewingVideoGraph.release();
        }
        this.currentSurfaceAndSize = null;
        this.state = 2;
    }

    @Override // androidx.media3.common.VideoGraph.Listener
    public void onOutputSizeChanged(int i, int i2) {
        Format build = this.videoGraphOutputFormat.buildUpon().setWidth(i).setHeight(i2).build();
        this.videoGraphOutputFormat = build;
        this.defaultVideoSink.onInputStreamChanged(1, build, ImmutableList.of());
    }

    @Override // androidx.media3.common.VideoGraph.Listener
    public void onOutputFrameRateChanged(float f) {
        Format build = this.videoGraphOutputFormat.buildUpon().setFrameRate(f).build();
        this.videoGraphOutputFormat = build;
        this.defaultVideoSink.onInputStreamChanged(1, build, ImmutableList.of());
    }

    @Override // androidx.media3.common.VideoGraph.Listener
    public void onOutputFrameAvailableForRendering(long j) {
        if (this.pendingFlushCount > 0) {
            return;
        }
        Renderer.WakeupListener wakeupListener = this.wakeupListener;
        if (wakeupListener != null) {
            wakeupListener.onWakeup();
        }
        long j2 = j - this.bufferTimestampAdjustmentUs;
        this.lastOutputBufferPresentationTimeUs = j2;
        Long pollFloor = this.streamStartPositionsUs.pollFloor(j2);
        if (pollFloor != null && pollFloor.longValue() != this.outputStreamStartPositionUs) {
            this.defaultVideoSink.setStreamTimestampInfo(pollFloor.longValue(), this.bufferTimestampAdjustmentUs);
            this.outputStreamStartPositionUs = pollFloor.longValue();
        }
        long j3 = this.finalBufferPresentationTimeUs;
        boolean z = j3 != C.TIME_UNSET && j2 >= j3;
        this.defaultVideoSink.handleInputFrame(j, z, this.videoFrameHandler);
        if (z) {
            this.defaultVideoSink.signalEndOfCurrentInputStream();
            this.hasSignaledEndOfCurrentInputStream = true;
        }
    }

    @Override // androidx.media3.common.VideoGraph.Listener
    public void onError(VideoFrameProcessingException videoFrameProcessingException) {
        Iterator<Listener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onError(this, videoFrameProcessingException);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VideoFrameProcessor registerInput(Format format, int i) throws VideoSink.VideoSinkException {
        PlaybackVideoGraphWrapper playbackVideoGraphWrapper;
        PreviewingVideoGraph.Factory factory;
        Context context;
        DebugViewProvider debugViewProvider;
        final HandlerWrapper handlerWrapper;
        if (i == 0) {
            Assertions.checkState(this.state == 0);
            ColorInfo adjustedInputColorInfo = getAdjustedInputColorInfo(format.colorInfo);
            if (this.requestOpenGlToneMapping) {
                adjustedInputColorInfo = ColorInfo.SDR_BT709_LIMITED;
            } else if (adjustedInputColorInfo.colorTransfer == 7 && Util.SDK_INT < 34) {
                adjustedInputColorInfo = adjustedInputColorInfo.buildUpon().setColorTransfer(6).build();
            }
            ColorInfo colorInfo = adjustedInputColorInfo;
            this.handler = this.clock.createHandler((Looper) Assertions.checkStateNotNull(Looper.myLooper()), null);
            try {
                factory = this.previewingVideoGraphFactory;
                context = this.context;
                debugViewProvider = DebugViewProvider.NONE;
                handlerWrapper = this.handler;
                Objects.requireNonNull(handlerWrapper);
                playbackVideoGraphWrapper = this;
            } catch (VideoFrameProcessingException e) {
                e = e;
            }
            try {
                PreviewingVideoGraph create = factory.create(context, colorInfo, debugViewProvider, playbackVideoGraphWrapper, new Executor() { // from class: androidx.media3.exoplayer.video.PlaybackVideoGraphWrapper$$ExternalSyntheticLambda0
                    @Override // java.util.concurrent.Executor
                    public final void execute(Runnable runnable) {
                        HandlerWrapper.this.post(runnable);
                    }
                }, this.compositorSettings, this.compositionEffects, 0L);
                playbackVideoGraphWrapper.videoGraph = create;
                create.initialize();
                Pair<Surface, Size> pair = playbackVideoGraphWrapper.currentSurfaceAndSize;
                if (pair != null) {
                    Size size = (Size) playbackVideoGraphWrapper.currentSurfaceAndSize.second;
                    maybeSetOutputSurfaceInfo((Surface) pair.first, size.getWidth(), size.getHeight());
                }
                playbackVideoGraphWrapper.defaultVideoSink.initialize(format);
                playbackVideoGraphWrapper.state = 1;
            } catch (VideoFrameProcessingException e2) {
                e = e2;
                throw new VideoSink.VideoSinkException(e, format);
            }
        } else {
            playbackVideoGraphWrapper = this;
            if (!isInitialized()) {
                return null;
            }
        }
        try {
            ((PreviewingVideoGraph) Assertions.checkNotNull(playbackVideoGraphWrapper.videoGraph)).registerInput(i);
            playbackVideoGraphWrapper.registeredVideoInputCount++;
            VideoSink videoSink = playbackVideoGraphWrapper.defaultVideoSink;
            DefaultVideoSinkListener defaultVideoSinkListener = new DefaultVideoSinkListener();
            final HandlerWrapper handlerWrapper2 = (HandlerWrapper) Assertions.checkNotNull(playbackVideoGraphWrapper.handler);
            Objects.requireNonNull(handlerWrapper2);
            videoSink.setListener(defaultVideoSinkListener, new Executor() { // from class: androidx.media3.exoplayer.video.PlaybackVideoGraphWrapper$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Executor
                public final void execute(Runnable runnable) {
                    HandlerWrapper.this.post(runnable);
                }
            });
            return playbackVideoGraphWrapper.videoGraph.getProcessor(i);
        } catch (VideoFrameProcessingException e3) {
            throw new VideoSink.VideoSinkException(e3, format);
        }
    }

    private boolean isInitialized() {
        return this.state == 1;
    }

    public void setTotalVideoInputCount(int i) {
        this.totalVideoInputCount = i;
    }

    private void maybeSetOutputSurfaceInfo(Surface surface, int i, int i2) {
        PreviewingVideoGraph previewingVideoGraph = this.videoGraph;
        if (previewingVideoGraph == null) {
            return;
        }
        if (surface != null) {
            previewingVideoGraph.setOutputSurfaceInfo(new SurfaceInfo(surface, i, i2));
            this.defaultVideoSink.setOutputSurfaceInfo(surface, new Size(i, i2));
            return;
        }
        previewingVideoGraph.setOutputSurfaceInfo(null);
        this.defaultVideoSink.clearOutputSurfaceInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isReady(boolean z) {
        return this.defaultVideoSink.isReady(z && this.pendingFlushCount == 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isEnded() {
        return this.pendingFlushCount == 0 && this.hasSignaledEndOfCurrentInputStream && this.defaultVideoSink.isEnded();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(long j, long j2) throws VideoSink.VideoSinkException {
        this.defaultVideoSink.render(j, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void flush(boolean z) {
        if (isInitialized()) {
            this.pendingFlushCount++;
            this.defaultVideoSink.flush(z);
            while (this.streamStartPositionsUs.size() > 1) {
                this.streamStartPositionsUs.pollFirst();
            }
            if (this.streamStartPositionsUs.size() == 1) {
                this.defaultVideoSink.setStreamTimestampInfo(((Long) Assertions.checkNotNull(this.streamStartPositionsUs.pollFirst())).longValue(), this.bufferTimestampAdjustmentUs);
            }
            this.lastOutputBufferPresentationTimeUs = C.TIME_UNSET;
            this.finalBufferPresentationTimeUs = C.TIME_UNSET;
            this.hasSignaledEndOfCurrentInputStream = false;
            ((HandlerWrapper) Assertions.checkStateNotNull(this.handler)).post(new Runnable() { // from class: androidx.media3.exoplayer.video.PlaybackVideoGraphWrapper$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    PlaybackVideoGraphWrapper.this.m7440x92e2e5d9();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$flush$1$androidx-media3-exoplayer-video-PlaybackVideoGraphWrapper  reason: not valid java name */
    public /* synthetic */ void m7440x92e2e5d9() {
        this.pendingFlushCount--;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener) {
        this.defaultVideoSink.setVideoFrameMetadataListener(videoFrameMetadataListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlaybackSpeed(float f) {
        this.defaultVideoSink.setPlaybackSpeed(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBufferTimestampAdjustment(long j) {
        this.bufferTimestampAdjustmentUs = j;
        this.defaultVideoSink.setStreamTimestampInfo(this.outputStreamStartPositionUs, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shouldRenderToInputVideoSink() {
        int i = this.totalVideoInputCount;
        return i != -1 && i == this.registeredVideoInputCount;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ColorInfo getAdjustedInputColorInfo(ColorInfo colorInfo) {
        return (colorInfo == null || !colorInfo.isDataSpaceValid()) ? ColorInfo.SDR_BT709_LIMITED : colorInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class InputVideoSink implements VideoSink, Listener {
        private long inputBufferTimestampAdjustmentUs;
        private Format inputFormat;
        private final int inputIndex;
        private int inputType;
        private boolean signaledEndOfStream;
        private VideoFrameProcessor videoFrameProcessor;
        private final int videoFrameProcessorMaxPendingFrameCount;
        private ImmutableList<Effect> videoEffects = ImmutableList.of();
        private long lastBufferPresentationTimeUs = C.TIME_UNSET;
        private VideoSink.Listener listener = VideoSink.Listener.NO_OP;
        private Executor listenerExecutor = PlaybackVideoGraphWrapper.NO_OP_EXECUTOR;

        public InputVideoSink(Context context, int i) {
            this.inputIndex = i;
            this.videoFrameProcessorMaxPendingFrameCount = Util.getMaxPendingFramesCountForMediaCodecDecoders(context);
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void onRendererEnabled(boolean z) {
            PlaybackVideoGraphWrapper.this.defaultVideoSink.onRendererEnabled(z);
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void onRendererDisabled() {
            PlaybackVideoGraphWrapper.this.defaultVideoSink.onRendererDisabled();
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void onRendererStarted() {
            PlaybackVideoGraphWrapper.this.defaultVideoSink.onRendererStarted();
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void onRendererStopped() {
            PlaybackVideoGraphWrapper.this.defaultVideoSink.onRendererStopped();
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void setListener(VideoSink.Listener listener, Executor executor) {
            this.listener = listener;
            this.listenerExecutor = executor;
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public boolean initialize(Format format) throws VideoSink.VideoSinkException {
            Assertions.checkState(!isInitialized());
            VideoFrameProcessor registerInput = PlaybackVideoGraphWrapper.this.registerInput(format, this.inputIndex);
            this.videoFrameProcessor = registerInput;
            return registerInput != null;
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        @EnsuresNonNullIf(expression = {"videoFrameProcessor"}, result = true)
        public boolean isInitialized() {
            return this.videoFrameProcessor != null;
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void flush(boolean z) {
            if (isInitialized()) {
                this.videoFrameProcessor.flush();
            }
            this.lastBufferPresentationTimeUs = C.TIME_UNSET;
            PlaybackVideoGraphWrapper.this.flush(z);
            this.signaledEndOfStream = false;
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public boolean isReady(boolean z) {
            return PlaybackVideoGraphWrapper.this.isReady(z && isInitialized());
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void signalEndOfCurrentInputStream() {
            PlaybackVideoGraphWrapper.this.finalBufferPresentationTimeUs = this.lastBufferPresentationTimeUs;
            if (PlaybackVideoGraphWrapper.this.lastOutputBufferPresentationTimeUs >= PlaybackVideoGraphWrapper.this.finalBufferPresentationTimeUs) {
                PlaybackVideoGraphWrapper.this.defaultVideoSink.signalEndOfCurrentInputStream();
                PlaybackVideoGraphWrapper.this.hasSignaledEndOfCurrentInputStream = true;
            }
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void signalEndOfInput() {
            if (!this.signaledEndOfStream && isInitialized()) {
                this.videoFrameProcessor.signalEndOfInput();
                this.signaledEndOfStream = true;
            }
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public boolean isEnded() {
            return isInitialized() && PlaybackVideoGraphWrapper.this.isEnded();
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void onInputStreamChanged(int i, Format format, List<Effect> list) {
            Assertions.checkState(isInitialized());
            if (i != 1 && i != 2) {
                throw new UnsupportedOperationException("Unsupported input type " + i);
            }
            setPendingVideoEffects(list);
            this.inputType = i;
            this.inputFormat = format;
            PlaybackVideoGraphWrapper.this.finalBufferPresentationTimeUs = C.TIME_UNSET;
            PlaybackVideoGraphWrapper.this.hasSignaledEndOfCurrentInputStream = false;
            registerInputStream(format);
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public Surface getInputSurface() {
            Assertions.checkState(isInitialized());
            return ((VideoFrameProcessor) Assertions.checkStateNotNull(this.videoFrameProcessor)).getInputSurface();
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void setVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener) {
            PlaybackVideoGraphWrapper.this.setVideoFrameMetadataListener(videoFrameMetadataListener);
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void setPlaybackSpeed(float f) {
            PlaybackVideoGraphWrapper.this.setPlaybackSpeed(f);
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void setVideoEffects(List<Effect> list) {
            if (this.videoEffects.equals(list)) {
                return;
            }
            setPendingVideoEffects(list);
            Format format = this.inputFormat;
            if (format != null) {
                registerInputStream(format);
            }
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void setStreamTimestampInfo(long j, long j2) {
            TimedValueQueue timedValueQueue = PlaybackVideoGraphWrapper.this.streamStartPositionsUs;
            long j3 = this.lastBufferPresentationTimeUs;
            timedValueQueue.add(j3 == C.TIME_UNSET ? 0L : j3 + 1, Long.valueOf(j));
            this.inputBufferTimestampAdjustmentUs = j2;
            PlaybackVideoGraphWrapper.this.setBufferTimestampAdjustment(j2);
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void setOutputSurfaceInfo(Surface surface, Size size) {
            PlaybackVideoGraphWrapper.this.setOutputSurfaceInfo(surface, size);
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void clearOutputSurfaceInfo() {
            PlaybackVideoGraphWrapper.this.clearOutputSurfaceInfo();
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void setChangeFrameRateStrategy(int i) {
            PlaybackVideoGraphWrapper.this.defaultVideoSink.setChangeFrameRateStrategy(i);
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void enableMayRenderStartOfStream() {
            PlaybackVideoGraphWrapper.this.defaultVideoSink.enableMayRenderStartOfStream();
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public boolean handleInputFrame(long j, boolean z, VideoSink.VideoFrameHandler videoFrameHandler) {
            Assertions.checkState(isInitialized());
            if (PlaybackVideoGraphWrapper.this.shouldRenderToInputVideoSink() && ((VideoFrameProcessor) Assertions.checkStateNotNull(this.videoFrameProcessor)).getPendingInputFrameCount() < this.videoFrameProcessorMaxPendingFrameCount && ((VideoFrameProcessor) Assertions.checkStateNotNull(this.videoFrameProcessor)).registerInputFrame()) {
                this.lastBufferPresentationTimeUs = j - this.inputBufferTimestampAdjustmentUs;
                videoFrameHandler.render(j * 1000);
                return true;
            }
            return false;
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public boolean handleInputBitmap(Bitmap bitmap, TimestampIterator timestampIterator) {
            Assertions.checkState(isInitialized());
            if (PlaybackVideoGraphWrapper.this.shouldRenderToInputVideoSink() && ((VideoFrameProcessor) Assertions.checkNotNull(this.videoFrameProcessor)).queueInputBitmap(bitmap, timestampIterator)) {
                long lastTimestampUs = timestampIterator.getLastTimestampUs() - this.inputBufferTimestampAdjustmentUs;
                Assertions.checkState(lastTimestampUs != C.TIME_UNSET);
                this.lastBufferPresentationTimeUs = lastTimestampUs;
                return true;
            }
            return false;
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void render(long j, long j2) throws VideoSink.VideoSinkException {
            PlaybackVideoGraphWrapper.this.render(j, j2);
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void setWakeupListener(Renderer.WakeupListener wakeupListener) {
            PlaybackVideoGraphWrapper.this.wakeupListener = wakeupListener;
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void join(boolean z) {
            PlaybackVideoGraphWrapper.this.defaultVideoSink.join(z);
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void release() {
            PlaybackVideoGraphWrapper.this.release();
        }

        @Override // androidx.media3.exoplayer.video.PlaybackVideoGraphWrapper.Listener
        public void onFirstFrameRendered(PlaybackVideoGraphWrapper playbackVideoGraphWrapper) {
            final VideoSink.Listener listener = this.listener;
            this.listenerExecutor.execute(new Runnable() { // from class: androidx.media3.exoplayer.video.PlaybackVideoGraphWrapper$InputVideoSink$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    PlaybackVideoGraphWrapper.InputVideoSink.this.m7442x2299ee49(listener);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onFirstFrameRendered$0$androidx-media3-exoplayer-video-PlaybackVideoGraphWrapper$InputVideoSink  reason: not valid java name */
        public /* synthetic */ void m7442x2299ee49(VideoSink.Listener listener) {
            listener.onFirstFrameRendered(this);
        }

        @Override // androidx.media3.exoplayer.video.PlaybackVideoGraphWrapper.Listener
        public void onFrameDropped(PlaybackVideoGraphWrapper playbackVideoGraphWrapper) {
            final VideoSink.Listener listener = this.listener;
            this.listenerExecutor.execute(new Runnable() { // from class: androidx.media3.exoplayer.video.PlaybackVideoGraphWrapper$InputVideoSink$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    PlaybackVideoGraphWrapper.InputVideoSink.this.m7443x39948ea7(listener);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onFrameDropped$1$androidx-media3-exoplayer-video-PlaybackVideoGraphWrapper$InputVideoSink  reason: not valid java name */
        public /* synthetic */ void m7443x39948ea7(VideoSink.Listener listener) {
            listener.onFrameDropped((VideoSink) Assertions.checkStateNotNull(this));
        }

        @Override // androidx.media3.exoplayer.video.PlaybackVideoGraphWrapper.Listener
        public void onVideoSizeChanged(PlaybackVideoGraphWrapper playbackVideoGraphWrapper, final VideoSize videoSize) {
            final VideoSink.Listener listener = this.listener;
            this.listenerExecutor.execute(new Runnable() { // from class: androidx.media3.exoplayer.video.PlaybackVideoGraphWrapper$InputVideoSink$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    PlaybackVideoGraphWrapper.InputVideoSink.this.m7444x47b4e41(listener, videoSize);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onVideoSizeChanged$2$androidx-media3-exoplayer-video-PlaybackVideoGraphWrapper$InputVideoSink  reason: not valid java name */
        public /* synthetic */ void m7444x47b4e41(VideoSink.Listener listener, VideoSize videoSize) {
            listener.onVideoSizeChanged(this, videoSize);
        }

        @Override // androidx.media3.exoplayer.video.PlaybackVideoGraphWrapper.Listener
        public void onError(PlaybackVideoGraphWrapper playbackVideoGraphWrapper, final VideoFrameProcessingException videoFrameProcessingException) {
            final VideoSink.Listener listener = this.listener;
            this.listenerExecutor.execute(new Runnable() { // from class: androidx.media3.exoplayer.video.PlaybackVideoGraphWrapper$InputVideoSink$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    PlaybackVideoGraphWrapper.InputVideoSink.this.m7441x4b60f8c8(listener, videoFrameProcessingException);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onError$3$androidx-media3-exoplayer-video-PlaybackVideoGraphWrapper$InputVideoSink  reason: not valid java name */
        public /* synthetic */ void m7441x4b60f8c8(VideoSink.Listener listener, VideoFrameProcessingException videoFrameProcessingException) {
            listener.onError(this, new VideoSink.VideoSinkException(videoFrameProcessingException, (Format) Assertions.checkStateNotNull(this.inputFormat)));
        }

        private void setPendingVideoEffects(List<Effect> list) {
            if (PlaybackVideoGraphWrapper.this.previewingVideoGraphFactory.supportsMultipleInputs()) {
                this.videoEffects = ImmutableList.copyOf((Collection) list);
            } else {
                this.videoEffects = new ImmutableList.Builder().addAll((Iterable) list).addAll((Iterable) PlaybackVideoGraphWrapper.this.compositionEffects).build();
            }
        }

        private void registerInputStream(Format format) {
            ((VideoFrameProcessor) Assertions.checkStateNotNull(this.videoFrameProcessor)).registerInputStream(this.inputType, format.buildUpon().setColorInfo(PlaybackVideoGraphWrapper.getAdjustedInputColorInfo(format.colorInfo)).build(), this.videoEffects, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class DefaultVideoSinkListener implements VideoSink.Listener {
        private DefaultVideoSinkListener() {
        }

        @Override // androidx.media3.exoplayer.video.VideoSink.Listener
        public void onFirstFrameRendered(VideoSink videoSink) {
            Iterator it = PlaybackVideoGraphWrapper.this.listeners.iterator();
            while (it.hasNext()) {
                ((Listener) it.next()).onFirstFrameRendered(PlaybackVideoGraphWrapper.this);
            }
        }

        @Override // androidx.media3.exoplayer.video.VideoSink.Listener
        public void onFrameDropped(VideoSink videoSink) {
            Iterator it = PlaybackVideoGraphWrapper.this.listeners.iterator();
            while (it.hasNext()) {
                ((Listener) it.next()).onFrameDropped(PlaybackVideoGraphWrapper.this);
            }
        }

        @Override // androidx.media3.exoplayer.video.VideoSink.Listener
        public void onVideoSizeChanged(VideoSink videoSink, VideoSize videoSize) {
            Iterator it = PlaybackVideoGraphWrapper.this.listeners.iterator();
            while (it.hasNext()) {
                ((Listener) it.next()).onVideoSizeChanged(PlaybackVideoGraphWrapper.this, videoSize);
            }
        }

        @Override // androidx.media3.exoplayer.video.VideoSink.Listener
        public void onError(VideoSink videoSink, VideoSink.VideoSinkException videoSinkException) {
            Iterator it = PlaybackVideoGraphWrapper.this.listeners.iterator();
            while (it.hasNext()) {
                ((Listener) it.next()).onError(PlaybackVideoGraphWrapper.this, VideoFrameProcessingException.from(videoSinkException));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class ReflectivePreviewingSingleInputVideoGraphFactory implements PreviewingVideoGraph.Factory {
        private final VideoFrameProcessor.Factory videoFrameProcessorFactory;

        @Override // androidx.media3.common.PreviewingVideoGraph.Factory
        public boolean supportsMultipleInputs() {
            return false;
        }

        public ReflectivePreviewingSingleInputVideoGraphFactory(VideoFrameProcessor.Factory factory) {
            this.videoFrameProcessorFactory = factory;
        }

        @Override // androidx.media3.common.PreviewingVideoGraph.Factory
        public PreviewingVideoGraph create(Context context, ColorInfo colorInfo, DebugViewProvider debugViewProvider, VideoGraph.Listener listener, Executor executor, VideoCompositorSettings videoCompositorSettings, List<Effect> list, long j) throws VideoFrameProcessingException {
            try {
                return ((PreviewingVideoGraph.Factory) Class.forName("androidx.media3.effect.PreviewingSingleInputVideoGraph$Factory").getConstructor(VideoFrameProcessor.Factory.class).newInstance(this.videoFrameProcessorFactory)).create(context, colorInfo, debugViewProvider, listener, executor, videoCompositorSettings, list, j);
            } catch (Exception e) {
                throw VideoFrameProcessingException.from(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class ReflectiveDefaultVideoFrameProcessorFactory implements VideoFrameProcessor.Factory {
        private static final Supplier<VideoFrameProcessor.Factory> VIDEO_FRAME_PROCESSOR_FACTORY_SUPPLIER = Suppliers.memoize(new Supplier() { // from class: androidx.media3.exoplayer.video.PlaybackVideoGraphWrapper$ReflectiveDefaultVideoFrameProcessorFactory$$ExternalSyntheticLambda0
            @Override // com.google.common.base.Supplier
            public final Object get() {
                return PlaybackVideoGraphWrapper.ReflectiveDefaultVideoFrameProcessorFactory.lambda$static$0();
            }
        });

        private ReflectiveDefaultVideoFrameProcessorFactory() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ VideoFrameProcessor.Factory lambda$static$0() {
            try {
                Class<?> cls = Class.forName("androidx.media3.effect.DefaultVideoFrameProcessor$Factory$Builder");
                return (VideoFrameProcessor.Factory) Assertions.checkNotNull(cls.getMethod("build", new Class[0]).invoke(cls.getConstructor(new Class[0]).newInstance(new Object[0]), new Object[0]));
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }

        @Override // androidx.media3.common.VideoFrameProcessor.Factory
        public VideoFrameProcessor create(Context context, DebugViewProvider debugViewProvider, ColorInfo colorInfo, boolean z, Executor executor, VideoFrameProcessor.Listener listener) throws VideoFrameProcessingException {
            return VIDEO_FRAME_PROCESSOR_FACTORY_SUPPLIER.get().create(context, debugViewProvider, colorInfo, z, executor, listener);
        }
    }
}
