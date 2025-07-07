package androidx.media3.exoplayer;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.HandlerWrapper;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.TraceUtil;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSourceException;
import androidx.media3.exoplayer.AudioFocusManager;
import androidx.media3.exoplayer.DefaultMediaClock;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.LoadControl;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.MediaPeriodHolder;
import androidx.media3.exoplayer.MediaSourceList;
import androidx.media3.exoplayer.PlayerMessage;
import androidx.media3.exoplayer.Renderer;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.analytics.AnalyticsCollector;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.source.BehindLiveWindowException;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.ShuffleOrder;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.trackselection.TrackSelector;
import androidx.media3.exoplayer.trackselection.TrackSelectorResult;
import androidx.media3.exoplayer.upstream.BandwidthMeter;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public final class ExoPlayerImplInternal implements Handler.Callback, MediaPeriod.Callback, TrackSelector.InvalidationListener, MediaSourceList.MediaSourceListInfoRefreshListener, DefaultMediaClock.PlaybackParametersListener, PlayerMessage.Sender, AudioFocusManager.PlayerControl {
    private static final long BUFFERING_MAXIMUM_INTERVAL_MS = Util.usToMs(Renderer.DEFAULT_DURATION_TO_PROGRESS_US);
    private static final int MSG_ADD_MEDIA_SOURCES = 18;
    private static final int MSG_ATTEMPT_RENDERER_ERROR_RECOVERY = 25;
    private static final int MSG_AUDIO_FOCUS_PLAYER_COMMAND = 33;
    private static final int MSG_AUDIO_FOCUS_VOLUME_MULTIPLIER = 34;
    private static final int MSG_DO_SOME_WORK = 2;
    private static final int MSG_MOVE_MEDIA_SOURCES = 19;
    private static final int MSG_PERIOD_PREPARED = 8;
    private static final int MSG_PLAYBACK_PARAMETERS_CHANGED_INTERNAL = 16;
    private static final int MSG_PLAYLIST_UPDATE_REQUESTED = 22;
    private static final int MSG_PREPARE = 29;
    private static final int MSG_RELEASE = 7;
    private static final int MSG_REMOVE_MEDIA_SOURCES = 20;
    private static final int MSG_RENDERER_CAPABILITIES_CHANGED = 26;
    private static final int MSG_SEEK_TO = 3;
    private static final int MSG_SEND_MESSAGE = 14;
    private static final int MSG_SEND_MESSAGE_TO_TARGET_THREAD = 15;
    private static final int MSG_SET_AUDIO_ATTRIBUTES = 31;
    private static final int MSG_SET_FOREGROUND_MODE = 13;
    private static final int MSG_SET_MEDIA_SOURCES = 17;
    private static final int MSG_SET_PAUSE_AT_END_OF_WINDOW = 23;
    private static final int MSG_SET_PLAYBACK_PARAMETERS = 4;
    private static final int MSG_SET_PLAY_WHEN_READY = 1;
    private static final int MSG_SET_PRELOAD_CONFIGURATION = 28;
    private static final int MSG_SET_REPEAT_MODE = 11;
    private static final int MSG_SET_SEEK_PARAMETERS = 5;
    private static final int MSG_SET_SHUFFLE_ENABLED = 12;
    private static final int MSG_SET_SHUFFLE_ORDER = 21;
    private static final int MSG_SET_VIDEO_OUTPUT = 30;
    private static final int MSG_SET_VOLUME = 32;
    private static final int MSG_SOURCE_CONTINUE_LOADING_REQUESTED = 9;
    private static final int MSG_STOP = 6;
    private static final int MSG_TRACK_SELECTION_INVALIDATED = 10;
    private static final int MSG_UPDATE_MEDIA_SOURCES_WITH_MEDIA_ITEMS = 27;
    private static final long PLAYBACK_BUFFER_EMPTY_THRESHOLD_US = 500000;
    private static final long PLAYBACK_STUCK_AFTER_MS = 4000;
    private static final long READY_MAXIMUM_INTERVAL_MS = 1000;
    private static final String TAG = "ExoPlayerImplInternal";
    private final AnalyticsCollector analyticsCollector;
    private final HandlerWrapper applicationLooperHandler;
    private final AudioFocusManager audioFocusManager;
    private final long backBufferDurationUs;
    private final BandwidthMeter bandwidthMeter;
    private final Clock clock;
    private boolean deliverPendingMessageAtStartPositionRequired;
    private final boolean dynamicSchedulingEnabled;
    private final TrackSelectorResult emptyTrackSelectorResult;
    private int enabledRendererCount;
    private boolean foregroundMode;
    private final HandlerWrapper handler;
    private final boolean hasSecondaryRenderers;
    private boolean isPrewarmingDisabledUntilNextTransition;
    private boolean isRebuffering;
    private final LivePlaybackSpeedControl livePlaybackSpeedControl;
    private final LoadControl loadControl;
    private final DefaultMediaClock mediaClock;
    private final MediaSourceList mediaSourceList;
    private int nextPendingMessageIndexHint;
    private boolean offloadSchedulingEnabled;
    private boolean pauseAtEndOfWindow;
    private SeekPosition pendingInitialSeekPosition;
    private final ArrayList<PendingMessageInfo> pendingMessages;
    private boolean pendingPauseAtEndOfPeriod;
    private ExoPlaybackException pendingRecoverableRendererError;
    private final Timeline.Period period;
    private PlaybackInfo playbackInfo;
    private PlaybackInfoUpdate playbackInfoUpdate;
    private final PlaybackInfoUpdateListener playbackInfoUpdateListener;
    private final Looper playbackLooper;
    private final PlaybackLooperProvider playbackLooperProvider;
    private final PlayerId playerId;
    private ExoPlayer.PreloadConfiguration preloadConfiguration;
    private final MediaPeriodQueue queue;
    private final long releaseTimeoutMs;
    private boolean released;
    private final RendererCapabilities[] rendererCapabilities;
    private long rendererPositionElapsedRealtimeUs;
    private long rendererPositionUs;
    private final boolean[] rendererReportedReady;
    private final RendererHolder[] renderers;
    private int repeatMode;
    private boolean requestForRendererSleep;
    private final boolean retainBackBufferFromKeyframe;
    private SeekParameters seekParameters;
    private long setForegroundModeTimeoutMs;
    private boolean shouldContinueLoading;
    private boolean shuffleModeEnabled;
    private final TrackSelector trackSelector;
    private final Timeline.Window window;
    private long prewarmingMediaPeriodDiscontinuity = C.TIME_UNSET;
    private float volume = 1.0f;
    private long playbackMaybeBecameStuckAtMs = C.TIME_UNSET;
    private long lastRebufferRealtimeMs = C.TIME_UNSET;
    private Timeline lastPreloadPoolInvalidationTimeline = Timeline.EMPTY;

    /* loaded from: classes2.dex */
    public interface PlaybackInfoUpdateListener {
        void onPlaybackInfoUpdate(PlaybackInfoUpdate playbackInfoUpdate);
    }

    private static int updatePlayWhenReadyChangeReason(int i, int i2) {
        if (i == -1) {
            return 2;
        }
        if (i2 == 2) {
            return 1;
        }
        return i2;
    }

    private static int updatePlaybackSuppressionReason(int i, int i2) {
        if (i == 0) {
            return 1;
        }
        if (i2 == 1) {
            return 0;
        }
        return i2;
    }

    /* loaded from: classes2.dex */
    public static final class PlaybackInfoUpdate {
        public int discontinuityReason;
        private boolean hasPendingChange;
        public int operationAcks;
        public PlaybackInfo playbackInfo;
        public boolean positionDiscontinuity;

        public PlaybackInfoUpdate(PlaybackInfo playbackInfo) {
            this.playbackInfo = playbackInfo;
        }

        public void incrementPendingOperationAcks(int i) {
            this.hasPendingChange |= i > 0;
            this.operationAcks += i;
        }

        public void setPlaybackInfo(PlaybackInfo playbackInfo) {
            this.hasPendingChange |= this.playbackInfo != playbackInfo;
            this.playbackInfo = playbackInfo;
        }

        public void setPositionDiscontinuity(int i) {
            if (this.positionDiscontinuity && this.discontinuityReason != 5) {
                Assertions.checkArgument(i == 5);
                return;
            }
            this.hasPendingChange = true;
            this.positionDiscontinuity = true;
            this.discontinuityReason = i;
        }
    }

    public ExoPlayerImplInternal(Context context, Renderer[] rendererArr, Renderer[] rendererArr2, TrackSelector trackSelector, TrackSelectorResult trackSelectorResult, LoadControl loadControl, BandwidthMeter bandwidthMeter, int i, boolean z, AnalyticsCollector analyticsCollector, SeekParameters seekParameters, LivePlaybackSpeedControl livePlaybackSpeedControl, long j, boolean z2, boolean z3, Looper looper, Clock clock, PlaybackInfoUpdateListener playbackInfoUpdateListener, PlayerId playerId, PlaybackLooperProvider playbackLooperProvider, ExoPlayer.PreloadConfiguration preloadConfiguration) {
        this.playbackInfoUpdateListener = playbackInfoUpdateListener;
        this.trackSelector = trackSelector;
        this.emptyTrackSelectorResult = trackSelectorResult;
        this.loadControl = loadControl;
        this.bandwidthMeter = bandwidthMeter;
        this.repeatMode = i;
        this.shuffleModeEnabled = z;
        this.seekParameters = seekParameters;
        this.livePlaybackSpeedControl = livePlaybackSpeedControl;
        this.releaseTimeoutMs = j;
        this.setForegroundModeTimeoutMs = j;
        this.pauseAtEndOfWindow = z2;
        this.dynamicSchedulingEnabled = z3;
        this.clock = clock;
        this.playerId = playerId;
        this.preloadConfiguration = preloadConfiguration;
        this.analyticsCollector = analyticsCollector;
        this.backBufferDurationUs = loadControl.getBackBufferDurationUs(playerId);
        this.retainBackBufferFromKeyframe = loadControl.retainBackBufferFromKeyframe(playerId);
        this.playbackInfo = PlaybackInfo.createDummy(trackSelectorResult);
        this.playbackInfoUpdate = new PlaybackInfoUpdate(this.playbackInfo);
        this.rendererCapabilities = new RendererCapabilities[rendererArr.length];
        this.rendererReportedReady = new boolean[rendererArr.length];
        RendererCapabilities.Listener rendererCapabilitiesListener = trackSelector.getRendererCapabilitiesListener();
        this.renderers = new RendererHolder[rendererArr.length];
        boolean z4 = false;
        for (int i2 = 0; i2 < rendererArr.length; i2++) {
            rendererArr[i2].init(i2, playerId, clock);
            this.rendererCapabilities[i2] = rendererArr[i2].getCapabilities();
            if (rendererCapabilitiesListener != null) {
                this.rendererCapabilities[i2].setListener(rendererCapabilitiesListener);
            }
            Renderer renderer = rendererArr2[i2];
            if (renderer != null) {
                renderer.init(rendererArr.length + i2, playerId, clock);
                z4 = true;
            }
            this.renderers[i2] = new RendererHolder(rendererArr[i2], rendererArr2[i2], i2);
        }
        this.hasSecondaryRenderers = z4;
        this.mediaClock = new DefaultMediaClock(this, clock);
        this.pendingMessages = new ArrayList<>();
        this.window = new Timeline.Window();
        this.period = new Timeline.Period();
        trackSelector.init(this, bandwidthMeter);
        this.deliverPendingMessageAtStartPositionRequired = true;
        HandlerWrapper createHandler = clock.createHandler(looper, null);
        this.applicationLooperHandler = createHandler;
        this.queue = new MediaPeriodQueue(analyticsCollector, createHandler, new MediaPeriodHolder.Factory() { // from class: androidx.media3.exoplayer.ExoPlayerImplInternal$$ExternalSyntheticLambda2
            @Override // androidx.media3.exoplayer.MediaPeriodHolder.Factory
            public final MediaPeriodHolder create(MediaPeriodInfo mediaPeriodInfo, long j2) {
                MediaPeriodHolder createMediaPeriodHolder;
                createMediaPeriodHolder = ExoPlayerImplInternal.this.createMediaPeriodHolder(mediaPeriodInfo, j2);
                return createMediaPeriodHolder;
            }
        }, preloadConfiguration);
        this.mediaSourceList = new MediaSourceList(this, analyticsCollector, createHandler, playerId);
        PlaybackLooperProvider playbackLooperProvider2 = playbackLooperProvider == null ? new PlaybackLooperProvider() : playbackLooperProvider;
        this.playbackLooperProvider = playbackLooperProvider2;
        Looper obtainLooper = playbackLooperProvider2.obtainLooper();
        this.playbackLooper = obtainLooper;
        this.handler = clock.createHandler(obtainLooper, this);
        this.audioFocusManager = new AudioFocusManager(context, obtainLooper, this);
    }

    public MediaPeriodHolder createMediaPeriodHolder(MediaPeriodInfo mediaPeriodInfo, long j) {
        return new MediaPeriodHolder(this.rendererCapabilities, j, this.trackSelector, this.loadControl.getAllocator(), this.mediaSourceList, mediaPeriodInfo, this.emptyTrackSelectorResult, this.preloadConfiguration.targetPreloadDurationUs);
    }

    public void experimentalSetForegroundModeTimeoutMs(long j) {
        this.setForegroundModeTimeoutMs = j;
    }

    public void prepare() {
        this.handler.obtainMessage(29).sendToTarget();
    }

    public void setPlayWhenReady(boolean z, int i, int i2) {
        this.handler.obtainMessage(1, z ? 1 : 0, i | (i2 << 4)).sendToTarget();
    }

    public void setPauseAtEndOfWindow(boolean z) {
        this.handler.obtainMessage(23, z ? 1 : 0, 0).sendToTarget();
    }

    public void setRepeatMode(int i) {
        this.handler.obtainMessage(11, i, 0).sendToTarget();
    }

    public void setShuffleModeEnabled(boolean z) {
        this.handler.obtainMessage(12, z ? 1 : 0, 0).sendToTarget();
    }

    public void setPreloadConfiguration(ExoPlayer.PreloadConfiguration preloadConfiguration) {
        this.handler.obtainMessage(28, preloadConfiguration).sendToTarget();
    }

    public void seekTo(Timeline timeline, int i, long j) {
        this.handler.obtainMessage(3, new SeekPosition(timeline, i, j)).sendToTarget();
    }

    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        this.handler.obtainMessage(4, playbackParameters).sendToTarget();
    }

    public void setSeekParameters(SeekParameters seekParameters) {
        this.handler.obtainMessage(5, seekParameters).sendToTarget();
    }

    public void stop() {
        this.handler.obtainMessage(6).sendToTarget();
    }

    public void setMediaSources(List<MediaSourceList.MediaSourceHolder> list, int i, long j, ShuffleOrder shuffleOrder) {
        this.handler.obtainMessage(17, new MediaSourceListUpdateMessage(list, shuffleOrder, i, j)).sendToTarget();
    }

    public void addMediaSources(int i, List<MediaSourceList.MediaSourceHolder> list, ShuffleOrder shuffleOrder) {
        this.handler.obtainMessage(18, i, 0, new MediaSourceListUpdateMessage(list, shuffleOrder, -1, C.TIME_UNSET)).sendToTarget();
    }

    public void removeMediaSources(int i, int i2, ShuffleOrder shuffleOrder) {
        this.handler.obtainMessage(20, i, i2, shuffleOrder).sendToTarget();
    }

    public void moveMediaSources(int i, int i2, int i3, ShuffleOrder shuffleOrder) {
        this.handler.obtainMessage(19, new MoveMediaItemsMessage(i, i2, i3, shuffleOrder)).sendToTarget();
    }

    public void setShuffleOrder(ShuffleOrder shuffleOrder) {
        this.handler.obtainMessage(21, shuffleOrder).sendToTarget();
    }

    public void updateMediaSourcesWithMediaItems(int i, int i2, List<MediaItem> list) {
        this.handler.obtainMessage(27, i, i2, list).sendToTarget();
    }

    public void setAudioAttributes(AudioAttributes audioAttributes, boolean z) {
        this.handler.obtainMessage(31, z ? 1 : 0, 0, audioAttributes).sendToTarget();
    }

    public void setVolume(float f) {
        this.handler.obtainMessage(32, Float.valueOf(f)).sendToTarget();
    }

    private void handleAudioFocusPlayerCommandInternal(int i) throws ExoPlaybackException {
        updatePlayWhenReadyWithAudioFocus(this.playbackInfo.playWhenReady, i, this.playbackInfo.playbackSuppressionReason, this.playbackInfo.playWhenReadyChangeReason);
    }

    private void handleAudioFocusVolumeMultiplierChange() throws ExoPlaybackException {
        setVolumeInternal(this.volume);
    }

    @Override // androidx.media3.exoplayer.PlayerMessage.Sender
    public synchronized void sendMessage(PlayerMessage playerMessage) {
        if (!this.released && this.playbackLooper.getThread().isAlive()) {
            this.handler.obtainMessage(14, playerMessage).sendToTarget();
            return;
        }
        Log.w(TAG, "Ignoring messages sent after release.");
        playerMessage.markAsProcessed(false);
    }

    public synchronized boolean setForegroundMode(boolean z) {
        if (!this.released && this.playbackLooper.getThread().isAlive()) {
            if (z) {
                this.handler.obtainMessage(13, 1, 0).sendToTarget();
                return true;
            }
            AtomicBoolean atomicBoolean = new AtomicBoolean();
            this.handler.obtainMessage(13, 0, 0, atomicBoolean).sendToTarget();
            Objects.requireNonNull(atomicBoolean);
            waitUninterruptibly(new ExoPlayerImplInternal$$ExternalSyntheticLambda3(atomicBoolean), this.setForegroundModeTimeoutMs);
            return atomicBoolean.get();
        }
        return true;
    }

    public synchronized boolean setVideoOutput(Object obj, long j) {
        if (!this.released && this.playbackLooper.getThread().isAlive()) {
            AtomicBoolean atomicBoolean = new AtomicBoolean();
            this.handler.obtainMessage(30, new Pair(obj, atomicBoolean)).sendToTarget();
            if (j != C.TIME_UNSET) {
                Objects.requireNonNull(atomicBoolean);
                waitUninterruptibly(new ExoPlayerImplInternal$$ExternalSyntheticLambda3(atomicBoolean), j);
                return atomicBoolean.get();
            }
            return true;
        }
        return true;
    }

    public synchronized boolean release() {
        if (!this.released && this.playbackLooper.getThread().isAlive()) {
            this.handler.sendEmptyMessage(7);
            waitUninterruptibly(new Supplier() { // from class: androidx.media3.exoplayer.ExoPlayerImplInternal$$ExternalSyntheticLambda0
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExoPlayerImplInternal.this.m7324lambda$release$0$androidxmedia3exoplayerExoPlayerImplInternal();
                }
            }, this.releaseTimeoutMs);
            return this.released;
        }
        return true;
    }

    /* renamed from: lambda$release$0$androidx-media3-exoplayer-ExoPlayerImplInternal */
    public /* synthetic */ Boolean m7324lambda$release$0$androidxmedia3exoplayerExoPlayerImplInternal() {
        return Boolean.valueOf(this.released);
    }

    public Looper getPlaybackLooper() {
        return this.playbackLooper;
    }

    @Override // androidx.media3.exoplayer.MediaSourceList.MediaSourceListInfoRefreshListener
    public void onPlaylistUpdateRequested() {
        this.handler.removeMessages(2);
        this.handler.sendEmptyMessage(22);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod.Callback
    public void onPrepared(MediaPeriod mediaPeriod) {
        this.handler.obtainMessage(8, mediaPeriod).sendToTarget();
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader.Callback
    public void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
        this.handler.obtainMessage(9, mediaPeriod).sendToTarget();
    }

    @Override // androidx.media3.exoplayer.trackselection.TrackSelector.InvalidationListener
    public void onTrackSelectionsInvalidated() {
        this.handler.sendEmptyMessage(10);
    }

    @Override // androidx.media3.exoplayer.trackselection.TrackSelector.InvalidationListener
    public void onRendererCapabilitiesChanged(Renderer renderer) {
        this.handler.sendEmptyMessage(26);
    }

    @Override // androidx.media3.exoplayer.DefaultMediaClock.PlaybackParametersListener
    public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        this.handler.obtainMessage(16, playbackParameters).sendToTarget();
    }

    @Override // androidx.media3.exoplayer.AudioFocusManager.PlayerControl
    public void setVolumeMultiplier(float f) {
        this.handler.sendEmptyMessage(34);
    }

    @Override // androidx.media3.exoplayer.AudioFocusManager.PlayerControl
    public void executePlayerCommand(int i) {
        this.handler.obtainMessage(33, i, 0).sendToTarget();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        MediaPeriodHolder readingPeriod;
        MediaSource.MediaPeriodId mediaPeriodId;
        int i = 1000;
        try {
            switch (message.what) {
                case 1:
                    setPlayWhenReadyInternal(message.arg1 != 0, message.arg2 >> 4, true, message.arg2 & 15);
                    break;
                case 2:
                    doSomeWork();
                    break;
                case 3:
                    seekToInternal((SeekPosition) message.obj);
                    break;
                case 4:
                    setPlaybackParametersInternal((PlaybackParameters) message.obj);
                    break;
                case 5:
                    setSeekParametersInternal((SeekParameters) message.obj);
                    break;
                case 6:
                    stopInternal(false, true);
                    break;
                case 7:
                    releaseInternal();
                    return true;
                case 8:
                    handlePeriodPrepared((MediaPeriod) message.obj);
                    break;
                case 9:
                    handleContinueLoadingRequested((MediaPeriod) message.obj);
                    break;
                case 10:
                    reselectTracksInternal();
                    break;
                case 11:
                    setRepeatModeInternal(message.arg1);
                    break;
                case 12:
                    setShuffleModeEnabledInternal(message.arg1 != 0);
                    break;
                case 13:
                    setForegroundModeInternal(message.arg1 != 0, (AtomicBoolean) message.obj);
                    break;
                case 14:
                    sendMessageInternal((PlayerMessage) message.obj);
                    break;
                case 15:
                    sendMessageToTargetThread((PlayerMessage) message.obj);
                    break;
                case 16:
                    handlePlaybackParameters((PlaybackParameters) message.obj, false);
                    break;
                case 17:
                    setMediaItemsInternal((MediaSourceListUpdateMessage) message.obj);
                    break;
                case 18:
                    addMediaItemsInternal((MediaSourceListUpdateMessage) message.obj, message.arg1);
                    break;
                case 19:
                    moveMediaItemsInternal((MoveMediaItemsMessage) message.obj);
                    break;
                case 20:
                    removeMediaItemsInternal(message.arg1, message.arg2, (ShuffleOrder) message.obj);
                    break;
                case 21:
                    setShuffleOrderInternal((ShuffleOrder) message.obj);
                    break;
                case 22:
                    mediaSourceListUpdateRequestedInternal();
                    break;
                case 23:
                    setPauseAtEndOfWindowInternal(message.arg1 != 0);
                    break;
                case 24:
                default:
                    return false;
                case 25:
                    attemptRendererErrorRecovery();
                    break;
                case 26:
                    reselectTracksInternalAndSeek();
                    break;
                case 27:
                    updateMediaSourcesWithMediaItemsInternal(message.arg1, message.arg2, (List) message.obj);
                    break;
                case 28:
                    setPreloadConfigurationInternal((ExoPlayer.PreloadConfiguration) message.obj);
                    break;
                case 29:
                    prepareInternal();
                    break;
                case 30:
                    Pair pair = (Pair) message.obj;
                    setVideoOutputInternal(pair.first, (AtomicBoolean) pair.second);
                    break;
                case 31:
                    setAudioAttributesInternal((AudioAttributes) message.obj, message.arg1 != 0);
                    break;
                case 32:
                    setVolumeInternal(((Float) message.obj).floatValue());
                    break;
                case 33:
                    handleAudioFocusPlayerCommandInternal(message.arg1);
                    break;
                case 34:
                    handleAudioFocusVolumeMultiplierChange();
                    break;
            }
        } catch (ParserException e) {
            if (e.dataType == 1) {
                i = e.contentIsMalformed ? PlaybackException.ERROR_CODE_PARSING_CONTAINER_MALFORMED : PlaybackException.ERROR_CODE_PARSING_CONTAINER_UNSUPPORTED;
            } else if (e.dataType == 4) {
                i = e.contentIsMalformed ? PlaybackException.ERROR_CODE_PARSING_MANIFEST_MALFORMED : PlaybackException.ERROR_CODE_PARSING_MANIFEST_UNSUPPORTED;
            }
            handleIoException(e, i);
        } catch (DataSourceException e2) {
            handleIoException(e2, e2.reason);
        } catch (ExoPlaybackException e3) {
            e = e3;
            if (e.type == 1 && (readingPeriod = this.queue.getReadingPeriod()) != null) {
                if (this.renderers[e.rendererIndex % this.renderers.length].isRendererPrewarming(e.rendererIndex) && readingPeriod.getNext() != null) {
                    mediaPeriodId = readingPeriod.getNext().info.id;
                } else {
                    mediaPeriodId = readingPeriod.info.id;
                }
                e = e.copyWithMediaPeriodId(mediaPeriodId);
            }
            if (e.type == 1 && this.renderers[e.rendererIndex % this.renderers.length].isRendererPrewarming(e.rendererIndex)) {
                this.isPrewarmingDisabledUntilNextTransition = true;
                disableAndResetPrewarmingRenderers();
                MediaPeriodHolder prewarmingPeriod = this.queue.getPrewarmingPeriod();
                MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
                if (this.queue.getPlayingPeriod() != prewarmingPeriod) {
                    while (playingPeriod != null && playingPeriod.getNext() != prewarmingPeriod) {
                        playingPeriod = playingPeriod.getNext();
                    }
                }
                this.queue.removeAfter(playingPeriod);
                if (this.playbackInfo.playbackState != 4) {
                    maybeContinueLoading();
                    this.handler.sendEmptyMessage(2);
                }
            } else {
                ExoPlaybackException exoPlaybackException = this.pendingRecoverableRendererError;
                if (exoPlaybackException != null) {
                    exoPlaybackException.addSuppressed(e);
                    e = this.pendingRecoverableRendererError;
                }
                if (e.type == 1 && this.queue.getPlayingPeriod() != this.queue.getReadingPeriod()) {
                    while (this.queue.getPlayingPeriod() != this.queue.getReadingPeriod()) {
                        this.queue.advancePlayingPeriod();
                    }
                    MediaPeriodHolder mediaPeriodHolder = (MediaPeriodHolder) Assertions.checkNotNull(this.queue.getPlayingPeriod());
                    maybeNotifyPlaybackInfoChanged();
                    this.playbackInfo = handlePositionDiscontinuity(mediaPeriodHolder.info.id, mediaPeriodHolder.info.startPositionUs, mediaPeriodHolder.info.requestedContentPositionUs, mediaPeriodHolder.info.startPositionUs, true, 0);
                }
                if (e.isRecoverable && (this.pendingRecoverableRendererError == null || e.errorCode == 5004 || e.errorCode == 5003)) {
                    Log.w(TAG, "Recoverable renderer error", e);
                    if (this.pendingRecoverableRendererError == null) {
                        this.pendingRecoverableRendererError = e;
                    }
                    HandlerWrapper handlerWrapper = this.handler;
                    handlerWrapper.sendMessageAtFrontOfQueue(handlerWrapper.obtainMessage(25, e));
                } else {
                    Log.e(TAG, "Playback error", e);
                    stopInternal(true, false);
                    this.playbackInfo = this.playbackInfo.copyWithPlaybackError(e);
                }
            }
        } catch (DrmSession.DrmSessionException e4) {
            handleIoException(e4, e4.errorCode);
        } catch (BehindLiveWindowException e5) {
            handleIoException(e5, 1002);
        } catch (IOException e6) {
            handleIoException(e6, 2000);
        } catch (RuntimeException e7) {
            ExoPlaybackException createForUnexpected = ExoPlaybackException.createForUnexpected(e7, ((e7 instanceof IllegalStateException) || (e7 instanceof IllegalArgumentException)) ? 1004 : 1004);
            Log.e(TAG, "Playback error", createForUnexpected);
            stopInternal(true, false);
            this.playbackInfo = this.playbackInfo.copyWithPlaybackError(createForUnexpected);
        }
        maybeNotifyPlaybackInfoChanged();
        return true;
    }

    private void handleIoException(IOException iOException, int i) {
        ExoPlaybackException createForSource = ExoPlaybackException.createForSource(iOException, i);
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        if (playingPeriod != null) {
            createForSource = createForSource.copyWithMediaPeriodId(playingPeriod.info.id);
        }
        Log.e(TAG, "Playback error", createForSource);
        stopInternal(false, false);
        this.playbackInfo = this.playbackInfo.copyWithPlaybackError(createForSource);
    }

    private synchronized void waitUninterruptibly(Supplier<Boolean> supplier, long j) {
        long elapsedRealtime = this.clock.elapsedRealtime() + j;
        boolean z = false;
        while (!supplier.get().booleanValue() && j > 0) {
            try {
                this.clock.onThreadBlocked();
                wait(j);
            } catch (InterruptedException unused) {
                z = true;
            }
            j = elapsedRealtime - this.clock.elapsedRealtime();
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    private void setState(int i) {
        if (this.playbackInfo.playbackState != i) {
            if (i != 2) {
                this.playbackMaybeBecameStuckAtMs = C.TIME_UNSET;
            }
            this.playbackInfo = this.playbackInfo.copyWithPlaybackState(i);
        }
    }

    private void maybeNotifyPlaybackInfoChanged() {
        this.playbackInfoUpdate.setPlaybackInfo(this.playbackInfo);
        if (this.playbackInfoUpdate.hasPendingChange) {
            this.playbackInfoUpdateListener.onPlaybackInfoUpdate(this.playbackInfoUpdate);
            this.playbackInfoUpdate = new PlaybackInfoUpdate(this.playbackInfo);
        }
    }

    private void prepareInternal() throws ExoPlaybackException {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        resetInternal(false, false, false, true);
        this.loadControl.onPrepared(this.playerId);
        setState(this.playbackInfo.timeline.isEmpty() ? 4 : 2);
        updatePlayWhenReadyWithAudioFocus();
        this.mediaSourceList.prepare(this.bandwidthMeter.getTransferListener());
        this.handler.sendEmptyMessage(2);
    }

    private void setMediaItemsInternal(MediaSourceListUpdateMessage mediaSourceListUpdateMessage) throws ExoPlaybackException {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        if (mediaSourceListUpdateMessage.windowIndex != -1) {
            this.pendingInitialSeekPosition = new SeekPosition(new PlaylistTimeline(mediaSourceListUpdateMessage.mediaSourceHolders, mediaSourceListUpdateMessage.shuffleOrder), mediaSourceListUpdateMessage.windowIndex, mediaSourceListUpdateMessage.positionUs);
        }
        handleMediaSourceListInfoRefreshed(this.mediaSourceList.setMediaSources(mediaSourceListUpdateMessage.mediaSourceHolders, mediaSourceListUpdateMessage.shuffleOrder), false);
    }

    private void addMediaItemsInternal(MediaSourceListUpdateMessage mediaSourceListUpdateMessage, int i) throws ExoPlaybackException {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        MediaSourceList mediaSourceList = this.mediaSourceList;
        if (i == -1) {
            i = mediaSourceList.getSize();
        }
        handleMediaSourceListInfoRefreshed(mediaSourceList.addMediaSources(i, mediaSourceListUpdateMessage.mediaSourceHolders, mediaSourceListUpdateMessage.shuffleOrder), false);
    }

    private void moveMediaItemsInternal(MoveMediaItemsMessage moveMediaItemsMessage) throws ExoPlaybackException {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        handleMediaSourceListInfoRefreshed(this.mediaSourceList.moveMediaSourceRange(moveMediaItemsMessage.fromIndex, moveMediaItemsMessage.toIndex, moveMediaItemsMessage.newFromIndex, moveMediaItemsMessage.shuffleOrder), false);
    }

    private void removeMediaItemsInternal(int i, int i2, ShuffleOrder shuffleOrder) throws ExoPlaybackException {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        handleMediaSourceListInfoRefreshed(this.mediaSourceList.removeMediaSourceRange(i, i2, shuffleOrder), false);
    }

    private void mediaSourceListUpdateRequestedInternal() throws ExoPlaybackException {
        handleMediaSourceListInfoRefreshed(this.mediaSourceList.createTimeline(), true);
    }

    private void setShuffleOrderInternal(ShuffleOrder shuffleOrder) throws ExoPlaybackException {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        handleMediaSourceListInfoRefreshed(this.mediaSourceList.setShuffleOrder(shuffleOrder), false);
    }

    private void updateMediaSourcesWithMediaItemsInternal(int i, int i2, List<MediaItem> list) throws ExoPlaybackException {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        handleMediaSourceListInfoRefreshed(this.mediaSourceList.updateMediaSourcesWithMediaItems(i, i2, list), false);
    }

    private void setAudioAttributesInternal(AudioAttributes audioAttributes, boolean z) throws ExoPlaybackException {
        this.trackSelector.setAudioAttributes(audioAttributes);
        AudioFocusManager audioFocusManager = this.audioFocusManager;
        if (!z) {
            audioAttributes = null;
        }
        audioFocusManager.setAudioAttributes(audioAttributes);
        updatePlayWhenReadyWithAudioFocus();
    }

    private void setVolumeInternal(float f) throws ExoPlaybackException {
        this.volume = f;
        float volumeMultiplier = f * this.audioFocusManager.getVolumeMultiplier();
        for (RendererHolder rendererHolder : this.renderers) {
            rendererHolder.setVolume(volumeMultiplier);
        }
    }

    private void notifyTrackSelectionPlayWhenReadyChanged(boolean z) {
        ExoTrackSelection[] exoTrackSelectionArr;
        for (MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod(); playingPeriod != null; playingPeriod = playingPeriod.getNext()) {
            for (ExoTrackSelection exoTrackSelection : playingPeriod.getTrackSelectorResult().selections) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.onPlayWhenReadyChanged(z);
                }
            }
        }
    }

    private void setPlayWhenReadyInternal(boolean z, int i, boolean z2, int i2) throws ExoPlaybackException {
        this.playbackInfoUpdate.incrementPendingOperationAcks(z2 ? 1 : 0);
        updatePlayWhenReadyWithAudioFocus(z, i, i2);
    }

    private void updatePlayWhenReadyWithAudioFocus() throws ExoPlaybackException {
        updatePlayWhenReadyWithAudioFocus(this.playbackInfo.playWhenReady, this.playbackInfo.playbackSuppressionReason, this.playbackInfo.playWhenReadyChangeReason);
    }

    private void updatePlayWhenReadyWithAudioFocus(boolean z, int i, int i2) throws ExoPlaybackException {
        updatePlayWhenReadyWithAudioFocus(z, this.audioFocusManager.updateAudioFocus(z, this.playbackInfo.playbackState), i, i2);
    }

    private void updatePlayWhenReadyWithAudioFocus(boolean z, int i, int i2, int i3) throws ExoPlaybackException {
        boolean z2 = z && i != -1;
        int updatePlayWhenReadyChangeReason = updatePlayWhenReadyChangeReason(i, i3);
        int updatePlaybackSuppressionReason = updatePlaybackSuppressionReason(i, i2);
        if (this.playbackInfo.playWhenReady == z2 && this.playbackInfo.playbackSuppressionReason == updatePlaybackSuppressionReason && this.playbackInfo.playWhenReadyChangeReason == updatePlayWhenReadyChangeReason) {
            return;
        }
        this.playbackInfo = this.playbackInfo.copyWithPlayWhenReady(z2, updatePlayWhenReadyChangeReason, updatePlaybackSuppressionReason);
        updateRebufferingState(false, false);
        notifyTrackSelectionPlayWhenReadyChanged(z2);
        if (!shouldPlayWhenReady()) {
            stopRenderers();
            updatePlaybackPositions();
            this.queue.reevaluateBuffer(this.rendererPositionUs);
        } else if (this.playbackInfo.playbackState == 3) {
            this.mediaClock.start();
            startRenderers();
            this.handler.sendEmptyMessage(2);
        } else if (this.playbackInfo.playbackState == 2) {
            this.handler.sendEmptyMessage(2);
        }
    }

    private void setPauseAtEndOfWindowInternal(boolean z) throws ExoPlaybackException {
        this.pauseAtEndOfWindow = z;
        resetPendingPauseAtEndOfPeriod();
        if (!this.pendingPauseAtEndOfPeriod || this.queue.getReadingPeriod() == this.queue.getPlayingPeriod()) {
            return;
        }
        seekToCurrentPosition(true);
        handleLoadingMediaPeriodChanged(false);
    }

    private void setOffloadSchedulingEnabled(boolean z) {
        if (z == this.offloadSchedulingEnabled) {
            return;
        }
        this.offloadSchedulingEnabled = z;
        if (z || !this.playbackInfo.sleepingForOffload) {
            return;
        }
        this.handler.sendEmptyMessage(2);
    }

    private void setRepeatModeInternal(int i) throws ExoPlaybackException {
        this.repeatMode = i;
        int updateRepeatMode = this.queue.updateRepeatMode(this.playbackInfo.timeline, i);
        if ((updateRepeatMode & 1) != 0) {
            seekToCurrentPosition(true);
        } else if ((updateRepeatMode & 2) != 0) {
            disableAndResetPrewarmingRenderers();
        }
        handleLoadingMediaPeriodChanged(false);
    }

    private void setShuffleModeEnabledInternal(boolean z) throws ExoPlaybackException {
        this.shuffleModeEnabled = z;
        int updateShuffleModeEnabled = this.queue.updateShuffleModeEnabled(this.playbackInfo.timeline, z);
        if ((updateShuffleModeEnabled & 1) != 0) {
            seekToCurrentPosition(true);
        } else if ((updateShuffleModeEnabled & 2) != 0) {
            disableAndResetPrewarmingRenderers();
        }
        handleLoadingMediaPeriodChanged(false);
    }

    private void setPreloadConfigurationInternal(ExoPlayer.PreloadConfiguration preloadConfiguration) {
        this.preloadConfiguration = preloadConfiguration;
        this.queue.updatePreloadConfiguration(this.playbackInfo.timeline, preloadConfiguration);
    }

    private void seekToCurrentPosition(boolean z) throws ExoPlaybackException {
        MediaSource.MediaPeriodId mediaPeriodId = this.queue.getPlayingPeriod().info.id;
        long seekToPeriodPosition = seekToPeriodPosition(mediaPeriodId, this.playbackInfo.positionUs, true, false);
        if (seekToPeriodPosition != this.playbackInfo.positionUs) {
            this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId, seekToPeriodPosition, this.playbackInfo.requestedContentPositionUs, this.playbackInfo.discontinuityStartPositionUs, z, 5);
        }
    }

    private void startRenderers() throws ExoPlaybackException {
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        if (playingPeriod == null) {
            return;
        }
        TrackSelectorResult trackSelectorResult = playingPeriod.getTrackSelectorResult();
        for (int i = 0; i < this.renderers.length; i++) {
            if (trackSelectorResult.isRendererEnabled(i)) {
                this.renderers[i].start();
            }
        }
    }

    private void stopRenderers() throws ExoPlaybackException {
        this.mediaClock.stop();
        for (RendererHolder rendererHolder : this.renderers) {
            rendererHolder.stop();
        }
    }

    private void attemptRendererErrorRecovery() throws ExoPlaybackException {
        reselectTracksInternalAndSeek();
    }

    private void updatePlaybackPositions() throws ExoPlaybackException {
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        if (playingPeriod == null) {
            return;
        }
        long readDiscontinuity = playingPeriod.prepared ? playingPeriod.mediaPeriod.readDiscontinuity() : -9223372036854775807L;
        if (readDiscontinuity != C.TIME_UNSET) {
            if (!playingPeriod.isFullyBuffered()) {
                this.queue.removeAfter(playingPeriod);
                handleLoadingMediaPeriodChanged(false);
                maybeContinueLoading();
            }
            resetRendererPosition(readDiscontinuity);
            if (readDiscontinuity != this.playbackInfo.positionUs) {
                long j = readDiscontinuity;
                this.playbackInfo = handlePositionDiscontinuity(this.playbackInfo.periodId, j, this.playbackInfo.requestedContentPositionUs, j, true, 5);
            }
        } else {
            long syncAndGetPositionUs = this.mediaClock.syncAndGetPositionUs(playingPeriod != this.queue.getReadingPeriod());
            this.rendererPositionUs = syncAndGetPositionUs;
            long periodTime = playingPeriod.toPeriodTime(syncAndGetPositionUs);
            maybeTriggerPendingMessages(this.playbackInfo.positionUs, periodTime);
            if (this.mediaClock.hasSkippedSilenceSinceLastCall()) {
                this.playbackInfo = handlePositionDiscontinuity(this.playbackInfo.periodId, periodTime, this.playbackInfo.requestedContentPositionUs, periodTime, !this.playbackInfoUpdate.positionDiscontinuity, 6);
            } else {
                this.playbackInfo.updatePositionUs(periodTime);
            }
        }
        this.playbackInfo.bufferedPositionUs = this.queue.getLoadingPeriod().getBufferedPositionUs();
        this.playbackInfo.totalBufferedDurationUs = getTotalBufferedDurationUs();
        if (this.playbackInfo.playWhenReady && this.playbackInfo.playbackState == 3 && shouldUseLivePlaybackSpeedControl(this.playbackInfo.timeline, this.playbackInfo.periodId) && this.playbackInfo.playbackParameters.speed == 1.0f) {
            float adjustedPlaybackSpeed = this.livePlaybackSpeedControl.getAdjustedPlaybackSpeed(getCurrentLiveOffsetUs(), this.playbackInfo.totalBufferedDurationUs);
            if (this.mediaClock.getPlaybackParameters().speed != adjustedPlaybackSpeed) {
                setMediaClockPlaybackParameters(this.playbackInfo.playbackParameters.withSpeed(adjustedPlaybackSpeed));
                handlePlaybackParameters(this.playbackInfo.playbackParameters, this.mediaClock.getPlaybackParameters().speed, false, false);
            }
        }
    }

    private void setMediaClockPlaybackParameters(PlaybackParameters playbackParameters) {
        this.handler.removeMessages(16);
        this.mediaClock.setPlaybackParameters(playbackParameters);
    }

    private void notifyTrackSelectionRebuffer() {
        ExoTrackSelection[] exoTrackSelectionArr;
        for (MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod(); playingPeriod != null; playingPeriod = playingPeriod.getNext()) {
            for (ExoTrackSelection exoTrackSelection : playingPeriod.getTrackSelectorResult().selections) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.onRebuffer();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:182:0x00b1, code lost:
        if (r11 <= r17.playbackInfo.positionUs) goto L129;
     */
    /* JADX WARN: Removed duplicated region for block: B:214:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x01bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void doSomeWork() throws ExoPlaybackException, IOException {
        boolean z;
        boolean z2;
        long j;
        boolean z3;
        long uptimeMillis = this.clock.uptimeMillis();
        this.handler.removeMessages(2);
        updatePeriods();
        boolean z4 = true;
        if (this.playbackInfo.playbackState == 1 || this.playbackInfo.playbackState == 4) {
            return;
        }
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        if (playingPeriod == null) {
            scheduleNextWork(uptimeMillis);
            return;
        }
        TraceUtil.beginSection("doSomeWork");
        updatePlaybackPositions();
        if (playingPeriod.prepared) {
            this.rendererPositionElapsedRealtimeUs = Util.msToUs(this.clock.elapsedRealtime());
            playingPeriod.mediaPeriod.discardBuffer(this.playbackInfo.positionUs - this.backBufferDurationUs, this.retainBackBufferFromKeyframe);
            z = true;
            z2 = true;
            int i = 0;
            while (true) {
                RendererHolder[] rendererHolderArr = this.renderers;
                if (i >= rendererHolderArr.length) {
                    break;
                }
                RendererHolder rendererHolder = rendererHolderArr[i];
                if (rendererHolder.getEnabledRendererCount() == 0) {
                    maybeTriggerOnRendererReadyChanged(i, false);
                } else {
                    rendererHolder.render(this.rendererPositionUs, this.rendererPositionElapsedRealtimeUs);
                    z = z && rendererHolder.isEnded();
                    boolean allowsPlayback = rendererHolder.allowsPlayback(playingPeriod);
                    maybeTriggerOnRendererReadyChanged(i, allowsPlayback);
                    z2 = z2 && allowsPlayback;
                    if (!allowsPlayback) {
                        maybeThrowRendererStreamError(i);
                    }
                }
                i++;
            }
        } else {
            playingPeriod.mediaPeriod.maybeThrowPrepareError();
            z = true;
            z2 = true;
        }
        long j2 = playingPeriod.info.durationUs;
        if (z && playingPeriod.prepared) {
            if (j2 != C.TIME_UNSET) {
                j = -9223372036854775807L;
            } else {
                j = -9223372036854775807L;
            }
            z3 = true;
            if (z3 && this.pendingPauseAtEndOfPeriod) {
                this.pendingPauseAtEndOfPeriod = false;
                setPlayWhenReadyInternal(false, this.playbackInfo.playbackSuppressionReason, false, 5);
            }
            if (!z3 && playingPeriod.info.isFinal) {
                setState(4);
                stopRenderers();
            } else if (this.playbackInfo.playbackState != 2 && shouldTransitionToReadyState(z2)) {
                setState(3);
                this.pendingRecoverableRendererError = null;
                if (shouldPlayWhenReady()) {
                    updateRebufferingState(false, false);
                    this.mediaClock.start();
                    startRenderers();
                }
            } else if (this.playbackInfo.playbackState == 3 && (this.enabledRendererCount != 0 ? !z2 : !isTimelineReady())) {
                updateRebufferingState(shouldPlayWhenReady(), false);
                setState(2);
                if (this.isRebuffering) {
                    notifyTrackSelectionRebuffer();
                    this.livePlaybackSpeedControl.notifyRebuffer();
                }
                stopRenderers();
            }
            if (this.playbackInfo.playbackState == 2) {
                int i2 = 0;
                while (true) {
                    RendererHolder[] rendererHolderArr2 = this.renderers;
                    if (i2 >= rendererHolderArr2.length) {
                        break;
                    }
                    if (rendererHolderArr2[i2].isReadingFromPeriod(playingPeriod)) {
                        maybeThrowRendererStreamError(i2);
                    }
                    i2++;
                }
                if (!this.playbackInfo.isLoading && this.playbackInfo.totalBufferedDurationUs < PLAYBACK_BUFFER_EMPTY_THRESHOLD_US && isLoadingPossible(this.queue.getLoadingPeriod()) && shouldPlayWhenReady()) {
                    if (this.playbackMaybeBecameStuckAtMs == j) {
                        this.playbackMaybeBecameStuckAtMs = this.clock.elapsedRealtime();
                    } else if (this.clock.elapsedRealtime() - this.playbackMaybeBecameStuckAtMs >= PLAYBACK_STUCK_AFTER_MS) {
                        throw new IllegalStateException("Playback stuck buffering and not loading");
                    }
                    boolean z5 = !shouldPlayWhenReady() && this.playbackInfo.playbackState == 3;
                    if (this.offloadSchedulingEnabled || !this.requestForRendererSleep || !z5) {
                        z4 = false;
                    }
                    if (this.playbackInfo.sleepingForOffload != z4) {
                        this.playbackInfo = this.playbackInfo.copyWithSleepingForOffload(z4);
                    }
                    this.requestForRendererSleep = false;
                    if (!z4 && this.playbackInfo.playbackState != 4 && (z5 || this.playbackInfo.playbackState == 2 || (this.playbackInfo.playbackState == 3 && this.enabledRendererCount != 0))) {
                        scheduleNextWork(uptimeMillis);
                    }
                    TraceUtil.endSection();
                }
            }
            this.playbackMaybeBecameStuckAtMs = j;
            if (shouldPlayWhenReady()) {
            }
            if (this.offloadSchedulingEnabled) {
            }
            z4 = false;
            if (this.playbackInfo.sleepingForOffload != z4) {
            }
            this.requestForRendererSleep = false;
            if (!z4) {
                scheduleNextWork(uptimeMillis);
            }
            TraceUtil.endSection();
        }
        j = -9223372036854775807L;
        z3 = false;
        if (z3) {
            this.pendingPauseAtEndOfPeriod = false;
            setPlayWhenReadyInternal(false, this.playbackInfo.playbackSuppressionReason, false, 5);
        }
        if (!z3) {
        }
        if (this.playbackInfo.playbackState != 2) {
        }
        if (this.playbackInfo.playbackState == 3) {
            updateRebufferingState(shouldPlayWhenReady(), false);
            setState(2);
            if (this.isRebuffering) {
            }
            stopRenderers();
        }
        if (this.playbackInfo.playbackState == 2) {
        }
        this.playbackMaybeBecameStuckAtMs = j;
        if (shouldPlayWhenReady()) {
        }
        if (this.offloadSchedulingEnabled) {
        }
        z4 = false;
        if (this.playbackInfo.sleepingForOffload != z4) {
        }
        this.requestForRendererSleep = false;
        if (!z4) {
        }
        TraceUtil.endSection();
    }

    private void maybeTriggerOnRendererReadyChanged(final int i, final boolean z) {
        boolean[] zArr = this.rendererReportedReady;
        if (zArr[i] != z) {
            zArr[i] = z;
            this.applicationLooperHandler.post(new Runnable() { // from class: androidx.media3.exoplayer.ExoPlayerImplInternal$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    ExoPlayerImplInternal.this.m7323x6a39ddd9(i, z);
                }
            });
        }
    }

    /* renamed from: lambda$maybeTriggerOnRendererReadyChanged$1$androidx-media3-exoplayer-ExoPlayerImplInternal */
    public /* synthetic */ void m7323x6a39ddd9(int i, boolean z) {
        this.analyticsCollector.onRendererReadyChanged(i, this.renderers[i].getTrackType(), z);
    }

    private long getCurrentLiveOffsetUs() {
        return getLiveOffsetUs(this.playbackInfo.timeline, this.playbackInfo.periodId.periodUid, this.playbackInfo.positionUs);
    }

    private long getLiveOffsetUs(Timeline timeline, Object obj, long j) {
        timeline.getWindow(timeline.getPeriodByUid(obj, this.period).windowIndex, this.window);
        return (this.window.windowStartTimeMs != C.TIME_UNSET && this.window.isLive() && this.window.isDynamic) ? Util.msToUs(this.window.getCurrentUnixTimeMs() - this.window.windowStartTimeMs) - (j + this.period.getPositionInWindowUs()) : C.TIME_UNSET;
    }

    private boolean shouldUseLivePlaybackSpeedControl(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId) {
        if (!mediaPeriodId.isAd() && !timeline.isEmpty()) {
            timeline.getWindow(timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period).windowIndex, this.window);
            if (this.window.isLive() && this.window.isDynamic && this.window.windowStartTimeMs != C.TIME_UNSET) {
                return true;
            }
        }
        return false;
    }

    private void scheduleNextWork(long j) {
        long j2 = (this.playbackInfo.playbackState != 3 || (!this.dynamicSchedulingEnabled && shouldPlayWhenReady())) ? BUFFERING_MAXIMUM_INTERVAL_MS : 1000L;
        if (this.dynamicSchedulingEnabled && shouldPlayWhenReady()) {
            for (RendererHolder rendererHolder : this.renderers) {
                j2 = Math.min(j2, Util.usToMs(rendererHolder.getMinDurationToProgressUs(this.rendererPositionUs, this.rendererPositionElapsedRealtimeUs)));
            }
            MediaPeriodHolder next = this.queue.getPlayingPeriod() != null ? this.queue.getPlayingPeriod().getNext() : null;
            if (next != null && ((float) this.rendererPositionUs) + (((float) Util.msToUs(j2)) * this.playbackInfo.playbackParameters.speed) >= ((float) next.getStartPositionRendererTime())) {
                j2 = Math.min(j2, BUFFERING_MAXIMUM_INTERVAL_MS);
            }
        }
        this.handler.sendEmptyMessageAtTime(2, j + j2);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:20|(7:(9:52|53|(1:82)(1:59)|60|61|62|63|(7:65|66|(3:71|72|73)|68|69|11|12)|78)(1:22)|35|36|37|10|11|12)|23|24|(1:26)(1:48)|27|28|(1:30)|31|32|33|34) */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x00f9, code lost:
        if (r1.playbackInfo.playbackState == 3) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x0153, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x0154, code lost:
        r2 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x0157, code lost:
        r0 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:129:0x00a1 A[Catch: all -> 0x015a, TryCatch #4 {all -> 0x015a, blocks: (B:127:0x0097, B:129:0x00a1, B:132:0x00a7, B:134:0x00ad, B:135:0x00b0, B:137:0x00b8, B:141:0x00ca, B:145:0x00d2), top: B:205:0x0097 }] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x00a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void seekToInternal(SeekPosition seekPosition) throws ExoPlaybackException {
        long longValue;
        MediaSource.MediaPeriodId resolveMediaPeriodIdForAdsAfterPeriodPositionChange;
        long j;
        boolean z;
        long j2;
        boolean z2;
        MediaSource.MediaPeriodId mediaPeriodId;
        long j3;
        MediaSource.MediaPeriodId mediaPeriodId2;
        long adjustedSeekPositionUs;
        int i;
        long j4;
        MediaSource.MediaPeriodId mediaPeriodId3;
        long j5;
        long seekToPeriodPosition;
        long j6;
        MediaSource.MediaPeriodId mediaPeriodId4;
        ExoPlayerImplInternal exoPlayerImplInternal = this;
        exoPlayerImplInternal.playbackInfoUpdate.incrementPendingOperationAcks(1);
        Pair<Object, Long> resolveSeekPositionUs = resolveSeekPositionUs(exoPlayerImplInternal.playbackInfo.timeline, seekPosition, true, exoPlayerImplInternal.repeatMode, exoPlayerImplInternal.shuffleModeEnabled, exoPlayerImplInternal.window, exoPlayerImplInternal.period);
        try {
            if (resolveSeekPositionUs == null) {
                Pair<MediaSource.MediaPeriodId, Long> placeholderFirstMediaPeriodPositionUs = exoPlayerImplInternal.getPlaceholderFirstMediaPeriodPositionUs(exoPlayerImplInternal.playbackInfo.timeline);
                resolveMediaPeriodIdForAdsAfterPeriodPositionChange = (MediaSource.MediaPeriodId) placeholderFirstMediaPeriodPositionUs.first;
                longValue = ((Long) placeholderFirstMediaPeriodPositionUs.second).longValue();
                z = !exoPlayerImplInternal.playbackInfo.timeline.isEmpty();
                j2 = -9223372036854775807L;
            } else {
                Object obj = resolveSeekPositionUs.first;
                longValue = ((Long) resolveSeekPositionUs.second).longValue();
                long j7 = seekPosition.windowPositionUs == C.TIME_UNSET ? -9223372036854775807L : longValue;
                resolveMediaPeriodIdForAdsAfterPeriodPositionChange = exoPlayerImplInternal.queue.resolveMediaPeriodIdForAdsAfterPeriodPositionChange(exoPlayerImplInternal.playbackInfo.timeline, obj, longValue);
                if (resolveMediaPeriodIdForAdsAfterPeriodPositionChange.isAd()) {
                    exoPlayerImplInternal.playbackInfo.timeline.getPeriodByUid(resolveMediaPeriodIdForAdsAfterPeriodPositionChange.periodUid, exoPlayerImplInternal.period);
                    longValue = exoPlayerImplInternal.period.getFirstAdIndexToPlay(resolveMediaPeriodIdForAdsAfterPeriodPositionChange.adGroupIndex) == resolveMediaPeriodIdForAdsAfterPeriodPositionChange.adIndexInAdGroup ? exoPlayerImplInternal.period.getAdResumePositionUs() : 0L;
                    z = true;
                    j2 = j7;
                } else {
                    j = 0;
                    z = seekPosition.windowPositionUs == C.TIME_UNSET;
                    j2 = j7;
                    if (!exoPlayerImplInternal.playbackInfo.timeline.isEmpty()) {
                        exoPlayerImplInternal.pendingInitialSeekPosition = seekPosition;
                    } else if (resolveSeekPositionUs == null) {
                        if (exoPlayerImplInternal.playbackInfo.playbackState != 1) {
                            exoPlayerImplInternal.setState(4);
                        }
                        exoPlayerImplInternal.resetInternal(false, true, false, true);
                    } else {
                        try {
                            if (resolveMediaPeriodIdForAdsAfterPeriodPositionChange.equals(exoPlayerImplInternal.playbackInfo.periodId)) {
                                try {
                                    MediaPeriodHolder playingPeriod = exoPlayerImplInternal.queue.getPlayingPeriod();
                                    adjustedSeekPositionUs = (playingPeriod == null || !playingPeriod.prepared || longValue == j) ? longValue : playingPeriod.mediaPeriod.getAdjustedSeekPositionUs(longValue, exoPlayerImplInternal.seekParameters);
                                    mediaPeriodId2 = resolveMediaPeriodIdForAdsAfterPeriodPositionChange;
                                    try {
                                        if (Util.usToMs(adjustedSeekPositionUs) == Util.usToMs(exoPlayerImplInternal.playbackInfo.positionUs)) {
                                            if (exoPlayerImplInternal.playbackInfo.playbackState != 2) {
                                                try {
                                                } catch (Throwable th) {
                                                    th = th;
                                                    mediaPeriodId = mediaPeriodId2;
                                                    z2 = z;
                                                    j3 = longValue;
                                                    exoPlayerImplInternal.playbackInfo = exoPlayerImplInternal.handlePositionDiscontinuity(mediaPeriodId, j3, j2, j3, z2, 2);
                                                    throw th;
                                                }
                                            }
                                            long j8 = exoPlayerImplInternal.playbackInfo.positionUs;
                                            i = 2;
                                            z2 = z;
                                            j4 = j8;
                                            mediaPeriodId3 = mediaPeriodId2;
                                            j5 = j8;
                                            exoPlayerImplInternal.playbackInfo = exoPlayerImplInternal.handlePositionDiscontinuity(mediaPeriodId3, j5, j2, j4, z2, i);
                                            return;
                                        }
                                        z2 = z;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        z2 = z;
                                        mediaPeriodId = mediaPeriodId2;
                                        j3 = longValue;
                                        exoPlayerImplInternal.playbackInfo = exoPlayerImplInternal.handlePositionDiscontinuity(mediaPeriodId, j3, j2, j3, z2, 2);
                                        throw th;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    z2 = z;
                                    mediaPeriodId2 = resolveMediaPeriodIdForAdsAfterPeriodPositionChange;
                                }
                            } else {
                                z2 = z;
                                mediaPeriodId2 = resolveMediaPeriodIdForAdsAfterPeriodPositionChange;
                                adjustedSeekPositionUs = longValue;
                            }
                            exoPlayerImplInternal.updatePlaybackSpeedSettingsForNewPeriod(exoPlayerImplInternal.playbackInfo.timeline, mediaPeriodId4, exoPlayerImplInternal.playbackInfo.timeline, exoPlayerImplInternal.playbackInfo.periodId, j6, true);
                            mediaPeriodId3 = mediaPeriodId4;
                            j2 = j6;
                            j5 = seekToPeriodPosition;
                            i = 2;
                            j4 = j5;
                            exoPlayerImplInternal = this;
                            exoPlayerImplInternal.playbackInfo = exoPlayerImplInternal.handlePositionDiscontinuity(mediaPeriodId3, j5, j2, j4, z2, i);
                            return;
                        } catch (Throwable th4) {
                            th = th4;
                            mediaPeriodId = mediaPeriodId4;
                            j2 = j6;
                            j3 = seekToPeriodPosition;
                            exoPlayerImplInternal.playbackInfo = exoPlayerImplInternal.handlePositionDiscontinuity(mediaPeriodId, j3, j2, j3, z2, 2);
                            throw th;
                        }
                        seekToPeriodPosition = exoPlayerImplInternal.seekToPeriodPosition(mediaPeriodId2, adjustedSeekPositionUs, exoPlayerImplInternal.playbackInfo.playbackState == 4);
                        z2 |= longValue != seekToPeriodPosition;
                        j6 = j2;
                        mediaPeriodId4 = mediaPeriodId2;
                    }
                    z2 = z;
                    mediaPeriodId3 = resolveMediaPeriodIdForAdsAfterPeriodPositionChange;
                    j5 = longValue;
                    i = 2;
                    j4 = j5;
                    exoPlayerImplInternal = this;
                    exoPlayerImplInternal.playbackInfo = exoPlayerImplInternal.handlePositionDiscontinuity(mediaPeriodId3, j5, j2, j4, z2, i);
                    return;
                }
            }
            if (!exoPlayerImplInternal.playbackInfo.timeline.isEmpty()) {
            }
            z2 = z;
            mediaPeriodId3 = resolveMediaPeriodIdForAdsAfterPeriodPositionChange;
            j5 = longValue;
            i = 2;
            j4 = j5;
            exoPlayerImplInternal = this;
            exoPlayerImplInternal.playbackInfo = exoPlayerImplInternal.handlePositionDiscontinuity(mediaPeriodId3, j5, j2, j4, z2, i);
            return;
        } catch (Throwable th5) {
            th = th5;
            z2 = z;
            mediaPeriodId = resolveMediaPeriodIdForAdsAfterPeriodPositionChange;
        }
        j = 0;
    }

    private long seekToPeriodPosition(MediaSource.MediaPeriodId mediaPeriodId, long j, boolean z) throws ExoPlaybackException {
        return seekToPeriodPosition(mediaPeriodId, j, this.queue.getPlayingPeriod() != this.queue.getReadingPeriod(), z);
    }

    private long seekToPeriodPosition(MediaSource.MediaPeriodId mediaPeriodId, long j, boolean z, boolean z2) throws ExoPlaybackException {
        stopRenderers();
        updateRebufferingState(false, true);
        if (z2 || this.playbackInfo.playbackState == 3) {
            setState(2);
        }
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        MediaPeriodHolder mediaPeriodHolder = playingPeriod;
        while (mediaPeriodHolder != null && !mediaPeriodId.equals(mediaPeriodHolder.info.id)) {
            mediaPeriodHolder = mediaPeriodHolder.getNext();
        }
        if (z || playingPeriod != mediaPeriodHolder || (mediaPeriodHolder != null && mediaPeriodHolder.toRendererTime(j) < 0)) {
            disableRenderers();
            if (mediaPeriodHolder != null) {
                while (this.queue.getPlayingPeriod() != mediaPeriodHolder) {
                    this.queue.advancePlayingPeriod();
                }
                this.queue.removeAfter(mediaPeriodHolder);
                mediaPeriodHolder.setRendererOffset(MediaPeriodQueue.INITIAL_RENDERER_POSITION_OFFSET_US);
                enableRenderers();
                mediaPeriodHolder.allRenderersInCorrectState = true;
            }
        }
        disableAndResetPrewarmingRenderers();
        if (mediaPeriodHolder != null) {
            this.queue.removeAfter(mediaPeriodHolder);
            if (!mediaPeriodHolder.prepared) {
                mediaPeriodHolder.info = mediaPeriodHolder.info.copyWithStartPositionUs(j);
            } else if (mediaPeriodHolder.hasEnabledTracks) {
                long seekToUs = mediaPeriodHolder.mediaPeriod.seekToUs(j);
                mediaPeriodHolder.mediaPeriod.discardBuffer(seekToUs - this.backBufferDurationUs, this.retainBackBufferFromKeyframe);
                j = seekToUs;
            }
            resetRendererPosition(j);
            maybeContinueLoading();
        } else {
            this.queue.clear();
            resetRendererPosition(j);
        }
        handleLoadingMediaPeriodChanged(false);
        this.handler.sendEmptyMessage(2);
        return j;
    }

    private void resetRendererPosition(long j) throws ExoPlaybackException {
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        long rendererTime = playingPeriod == null ? j + MediaPeriodQueue.INITIAL_RENDERER_POSITION_OFFSET_US : playingPeriod.toRendererTime(j);
        this.rendererPositionUs = rendererTime;
        this.mediaClock.resetPosition(rendererTime);
        for (RendererHolder rendererHolder : this.renderers) {
            rendererHolder.resetPosition(playingPeriod, this.rendererPositionUs);
        }
        notifyTrackSelectionDiscontinuity();
    }

    private void setPlaybackParametersInternal(PlaybackParameters playbackParameters) throws ExoPlaybackException {
        setMediaClockPlaybackParameters(playbackParameters);
        handlePlaybackParameters(this.mediaClock.getPlaybackParameters(), true);
    }

    private void setSeekParametersInternal(SeekParameters seekParameters) {
        this.seekParameters = seekParameters;
    }

    private void setForegroundModeInternal(boolean z, AtomicBoolean atomicBoolean) {
        if (this.foregroundMode != z) {
            this.foregroundMode = z;
            if (!z) {
                for (RendererHolder rendererHolder : this.renderers) {
                    rendererHolder.reset();
                }
            }
        }
        if (atomicBoolean != null) {
            synchronized (this) {
                atomicBoolean.set(true);
                notifyAll();
            }
        }
    }

    private void setVideoOutputInternal(Object obj, AtomicBoolean atomicBoolean) throws ExoPlaybackException {
        for (RendererHolder rendererHolder : this.renderers) {
            rendererHolder.setVideoOutput(obj);
        }
        if (this.playbackInfo.playbackState == 3 || this.playbackInfo.playbackState == 2) {
            this.handler.sendEmptyMessage(2);
        }
        if (atomicBoolean != null) {
            synchronized (this) {
                atomicBoolean.set(true);
                notifyAll();
            }
        }
    }

    private void stopInternal(boolean z, boolean z2) {
        resetInternal(z || !this.foregroundMode, false, true, false);
        this.playbackInfoUpdate.incrementPendingOperationAcks(z2 ? 1 : 0);
        this.loadControl.onStopped(this.playerId);
        this.audioFocusManager.updateAudioFocus(this.playbackInfo.playWhenReady, 1);
        setState(1);
    }

    private void releaseInternal() {
        try {
            resetInternal(true, false, true, false);
            releaseRenderers();
            this.loadControl.onReleased(this.playerId);
            this.audioFocusManager.release();
            this.trackSelector.release();
            setState(1);
            this.playbackLooperProvider.releaseLooper();
            synchronized (this) {
                this.released = true;
                notifyAll();
            }
        } catch (Throwable th) {
            this.playbackLooperProvider.releaseLooper();
            synchronized (this) {
                this.released = true;
                notifyAll();
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:137:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void resetInternal(boolean z, boolean z2, boolean z3, boolean z4) {
        long j;
        Timeline timeline;
        MediaSource.MediaPeriodId mediaPeriodId;
        Timeline timeline2;
        this.handler.removeMessages(2);
        this.pendingRecoverableRendererError = null;
        boolean z5 = true;
        updateRebufferingState(false, true);
        this.mediaClock.stop();
        this.rendererPositionUs = MediaPeriodQueue.INITIAL_RENDERER_POSITION_OFFSET_US;
        try {
            disableRenderers();
        } catch (ExoPlaybackException | RuntimeException e) {
            Log.e(TAG, "Disable failed.", e);
        }
        if (z) {
            for (RendererHolder rendererHolder : this.renderers) {
                try {
                    rendererHolder.reset();
                } catch (RuntimeException e2) {
                    Log.e(TAG, "Reset failed.", e2);
                }
            }
        }
        this.enabledRendererCount = 0;
        MediaSource.MediaPeriodId mediaPeriodId2 = this.playbackInfo.periodId;
        long j2 = this.playbackInfo.positionUs;
        if (this.playbackInfo.periodId.isAd() || isUsingPlaceholderPeriod(this.playbackInfo, this.period)) {
            j = this.playbackInfo.requestedContentPositionUs;
        } else {
            j = this.playbackInfo.positionUs;
        }
        if (z2) {
            this.pendingInitialSeekPosition = null;
            Pair<MediaSource.MediaPeriodId, Long> placeholderFirstMediaPeriodPositionUs = getPlaceholderFirstMediaPeriodPositionUs(this.playbackInfo.timeline);
            MediaSource.MediaPeriodId mediaPeriodId3 = (MediaSource.MediaPeriodId) placeholderFirstMediaPeriodPositionUs.first;
            j2 = ((Long) placeholderFirstMediaPeriodPositionUs.second).longValue();
            boolean equals = mediaPeriodId3.equals(this.playbackInfo.periodId);
            j = C.TIME_UNSET;
            if (equals) {
                mediaPeriodId2 = mediaPeriodId3;
            } else {
                mediaPeriodId2 = mediaPeriodId3;
                long j3 = j2;
                long j4 = j;
                this.queue.clear();
                this.shouldContinueLoading = false;
                timeline = this.playbackInfo.timeline;
                if (z3 && (timeline instanceof PlaylistTimeline)) {
                    timeline = ((PlaylistTimeline) this.playbackInfo.timeline).copyWithPlaceholderTimeline(this.mediaSourceList.getShuffleOrder());
                    if (mediaPeriodId2.adGroupIndex != -1) {
                        timeline.getPeriodByUid(mediaPeriodId2.periodUid, this.period);
                        if (timeline.getWindow(this.period.windowIndex, this.window).isLive()) {
                            timeline2 = timeline;
                            mediaPeriodId = new MediaSource.MediaPeriodId(mediaPeriodId2.periodUid, mediaPeriodId2.windowSequenceNumber);
                            this.playbackInfo = new PlaybackInfo(timeline2, mediaPeriodId, j4, j3, this.playbackInfo.playbackState, z4 ? null : this.playbackInfo.playbackError, false, z5 ? TrackGroupArray.EMPTY : this.playbackInfo.trackGroups, z5 ? this.emptyTrackSelectorResult : this.playbackInfo.trackSelectorResult, z5 ? ImmutableList.of() : this.playbackInfo.staticMetadata, mediaPeriodId, this.playbackInfo.playWhenReady, this.playbackInfo.playWhenReadyChangeReason, this.playbackInfo.playbackSuppressionReason, this.playbackInfo.playbackParameters, j3, 0L, j3, 0L, false);
                            if (z3) {
                                this.queue.releasePreloadPool();
                                this.mediaSourceList.release();
                                return;
                            }
                            return;
                        }
                    }
                }
                mediaPeriodId = mediaPeriodId2;
                timeline2 = timeline;
                this.playbackInfo = new PlaybackInfo(timeline2, mediaPeriodId, j4, j3, this.playbackInfo.playbackState, z4 ? null : this.playbackInfo.playbackError, false, z5 ? TrackGroupArray.EMPTY : this.playbackInfo.trackGroups, z5 ? this.emptyTrackSelectorResult : this.playbackInfo.trackSelectorResult, z5 ? ImmutableList.of() : this.playbackInfo.staticMetadata, mediaPeriodId, this.playbackInfo.playWhenReady, this.playbackInfo.playWhenReadyChangeReason, this.playbackInfo.playbackSuppressionReason, this.playbackInfo.playbackParameters, j3, 0L, j3, 0L, false);
                if (z3) {
                }
            }
        }
        z5 = false;
        long j32 = j2;
        long j42 = j;
        this.queue.clear();
        this.shouldContinueLoading = false;
        timeline = this.playbackInfo.timeline;
        if (z3) {
            timeline = ((PlaylistTimeline) this.playbackInfo.timeline).copyWithPlaceholderTimeline(this.mediaSourceList.getShuffleOrder());
            if (mediaPeriodId2.adGroupIndex != -1) {
            }
        }
        mediaPeriodId = mediaPeriodId2;
        timeline2 = timeline;
        this.playbackInfo = new PlaybackInfo(timeline2, mediaPeriodId, j42, j32, this.playbackInfo.playbackState, z4 ? null : this.playbackInfo.playbackError, false, z5 ? TrackGroupArray.EMPTY : this.playbackInfo.trackGroups, z5 ? this.emptyTrackSelectorResult : this.playbackInfo.trackSelectorResult, z5 ? ImmutableList.of() : this.playbackInfo.staticMetadata, mediaPeriodId, this.playbackInfo.playWhenReady, this.playbackInfo.playWhenReadyChangeReason, this.playbackInfo.playbackSuppressionReason, this.playbackInfo.playbackParameters, j32, 0L, j32, 0L, false);
        if (z3) {
        }
    }

    private Pair<MediaSource.MediaPeriodId, Long> getPlaceholderFirstMediaPeriodPositionUs(Timeline timeline) {
        if (timeline.isEmpty()) {
            return Pair.create(PlaybackInfo.getDummyPeriodForEmptyTimeline(), 0L);
        }
        Pair<Object, Long> periodPositionUs = timeline.getPeriodPositionUs(this.window, this.period, timeline.getFirstWindowIndex(this.shuffleModeEnabled), C.TIME_UNSET);
        MediaSource.MediaPeriodId resolveMediaPeriodIdForAdsAfterPeriodPositionChange = this.queue.resolveMediaPeriodIdForAdsAfterPeriodPositionChange(timeline, periodPositionUs.first, 0L);
        long longValue = ((Long) periodPositionUs.second).longValue();
        if (resolveMediaPeriodIdForAdsAfterPeriodPositionChange.isAd()) {
            timeline.getPeriodByUid(resolveMediaPeriodIdForAdsAfterPeriodPositionChange.periodUid, this.period);
            longValue = resolveMediaPeriodIdForAdsAfterPeriodPositionChange.adIndexInAdGroup == this.period.getFirstAdIndexToPlay(resolveMediaPeriodIdForAdsAfterPeriodPositionChange.adGroupIndex) ? this.period.getAdResumePositionUs() : 0L;
        }
        return Pair.create(resolveMediaPeriodIdForAdsAfterPeriodPositionChange, Long.valueOf(longValue));
    }

    private void sendMessageInternal(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (playerMessage.getPositionMs() == C.TIME_UNSET) {
            sendMessageToTarget(playerMessage);
        } else if (this.playbackInfo.timeline.isEmpty()) {
            this.pendingMessages.add(new PendingMessageInfo(playerMessage));
        } else {
            PendingMessageInfo pendingMessageInfo = new PendingMessageInfo(playerMessage);
            if (resolvePendingMessagePosition(pendingMessageInfo, this.playbackInfo.timeline, this.playbackInfo.timeline, this.repeatMode, this.shuffleModeEnabled, this.window, this.period)) {
                this.pendingMessages.add(pendingMessageInfo);
                Collections.sort(this.pendingMessages);
                return;
            }
            playerMessage.markAsProcessed(false);
        }
    }

    private void sendMessageToTarget(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (playerMessage.getLooper() == this.playbackLooper) {
            deliverMessage(playerMessage);
            if (this.playbackInfo.playbackState == 3 || this.playbackInfo.playbackState == 2) {
                this.handler.sendEmptyMessage(2);
                return;
            }
            return;
        }
        this.handler.obtainMessage(15, playerMessage).sendToTarget();
    }

    private void sendMessageToTargetThread(final PlayerMessage playerMessage) {
        Looper looper = playerMessage.getLooper();
        if (!looper.getThread().isAlive()) {
            Log.w("TAG", "Trying to send message on a dead thread.");
            playerMessage.markAsProcessed(false);
            return;
        }
        this.clock.createHandler(looper, null).post(new Runnable() { // from class: androidx.media3.exoplayer.ExoPlayerImplInternal$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                ExoPlayerImplInternal.this.m7325x7ddc96d2(playerMessage);
            }
        });
    }

    /* renamed from: lambda$sendMessageToTargetThread$2$androidx-media3-exoplayer-ExoPlayerImplInternal */
    public /* synthetic */ void m7325x7ddc96d2(PlayerMessage playerMessage) {
        try {
            deliverMessage(playerMessage);
        } catch (ExoPlaybackException e) {
            Log.e(TAG, "Unexpected error delivering message on external thread.", e);
            throw new RuntimeException(e);
        }
    }

    private void deliverMessage(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (playerMessage.isCanceled()) {
            return;
        }
        try {
            playerMessage.getTarget().handleMessage(playerMessage.getType(), playerMessage.getPayload());
        } finally {
            playerMessage.markAsProcessed(true);
        }
    }

    private void resolvePendingMessagePositions(Timeline timeline, Timeline timeline2) {
        if (timeline.isEmpty() && timeline2.isEmpty()) {
            return;
        }
        int size = this.pendingMessages.size() - 1;
        while (size >= 0) {
            Timeline timeline3 = timeline;
            Timeline timeline4 = timeline2;
            if (!resolvePendingMessagePosition(this.pendingMessages.get(size), timeline3, timeline4, this.repeatMode, this.shuffleModeEnabled, this.window, this.period)) {
                this.pendingMessages.get(size).message.markAsProcessed(false);
                this.pendingMessages.remove(size);
            }
            size--;
            timeline = timeline3;
            timeline2 = timeline4;
        }
        Collections.sort(this.pendingMessages);
    }

    /* JADX WARN: Removed duplicated region for block: B:140:0x009b A[LOOP:1: B:129:0x007d->B:140:0x009b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x007c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x00e9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x00e0 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:128:0x007c -> B:129:0x007d). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void maybeTriggerPendingMessages(long j, long j2) throws ExoPlaybackException {
        PendingMessageInfo pendingMessageInfo;
        if (this.pendingMessages.isEmpty() || this.playbackInfo.periodId.isAd()) {
            return;
        }
        if (this.deliverPendingMessageAtStartPositionRequired) {
            j--;
            this.deliverPendingMessageAtStartPositionRequired = false;
        }
        int indexOfPeriod = this.playbackInfo.timeline.getIndexOfPeriod(this.playbackInfo.periodId.periodUid);
        int min = Math.min(this.nextPendingMessageIndexHint, this.pendingMessages.size());
        PendingMessageInfo pendingMessageInfo2 = min > 0 ? this.pendingMessages.get(min - 1) : null;
        while (pendingMessageInfo2 != null && (pendingMessageInfo2.resolvedPeriodIndex > indexOfPeriod || (pendingMessageInfo2.resolvedPeriodIndex == indexOfPeriod && pendingMessageInfo2.resolvedPeriodTimeUs > j))) {
            int i = min - 1;
            pendingMessageInfo2 = i > 0 ? this.pendingMessages.get(min - 2) : null;
            min = i;
        }
        if (min < this.pendingMessages.size()) {
            pendingMessageInfo = this.pendingMessages.get(min);
            while (pendingMessageInfo != null && pendingMessageInfo.resolvedPeriodUid != null && (pendingMessageInfo.resolvedPeriodIndex < indexOfPeriod || (pendingMessageInfo.resolvedPeriodIndex == indexOfPeriod && pendingMessageInfo.resolvedPeriodTimeUs <= j))) {
                min++;
                if (min >= this.pendingMessages.size()) {
                    pendingMessageInfo = this.pendingMessages.get(min);
                }
            }
            while (pendingMessageInfo != null && pendingMessageInfo.resolvedPeriodUid != null && pendingMessageInfo.resolvedPeriodIndex == indexOfPeriod && pendingMessageInfo.resolvedPeriodTimeUs > j && pendingMessageInfo.resolvedPeriodTimeUs <= j2) {
                try {
                    sendMessageToTarget(pendingMessageInfo.message);
                    if (!pendingMessageInfo.message.getDeleteAfterDelivery() || pendingMessageInfo.message.isCanceled()) {
                        this.pendingMessages.remove(min);
                    } else {
                        min++;
                    }
                    pendingMessageInfo = min >= this.pendingMessages.size() ? this.pendingMessages.get(min) : null;
                } catch (Throwable th) {
                    if (pendingMessageInfo.message.getDeleteAfterDelivery() || pendingMessageInfo.message.isCanceled()) {
                        this.pendingMessages.remove(min);
                    }
                    throw th;
                }
            }
            this.nextPendingMessageIndexHint = min;
        }
        pendingMessageInfo = null;
        while (pendingMessageInfo != null) {
            min++;
            if (min >= this.pendingMessages.size()) {
            }
        }
        while (pendingMessageInfo != null) {
            sendMessageToTarget(pendingMessageInfo.message);
            if (pendingMessageInfo.message.getDeleteAfterDelivery()) {
            }
            this.pendingMessages.remove(min);
            if (min >= this.pendingMessages.size()) {
            }
        }
        this.nextPendingMessageIndexHint = min;
    }

    private void disableRenderers() throws ExoPlaybackException {
        for (int i = 0; i < this.renderers.length; i++) {
            disableRenderer(i);
        }
        this.prewarmingMediaPeriodDiscontinuity = C.TIME_UNSET;
    }

    private void disableRenderer(int i) throws ExoPlaybackException {
        int enabledRendererCount = this.renderers[i].getEnabledRendererCount();
        this.renderers[i].disable(this.mediaClock);
        maybeTriggerOnRendererReadyChanged(i, false);
        this.enabledRendererCount -= enabledRendererCount;
    }

    private void disableAndResetPrewarmingRenderers() {
        RendererHolder[] rendererHolderArr;
        if (this.hasSecondaryRenderers && areRenderersPrewarming()) {
            for (RendererHolder rendererHolder : this.renderers) {
                int enabledRendererCount = rendererHolder.getEnabledRendererCount();
                rendererHolder.disablePrewarming(this.mediaClock);
                this.enabledRendererCount -= enabledRendererCount - rendererHolder.getEnabledRendererCount();
            }
            this.prewarmingMediaPeriodDiscontinuity = C.TIME_UNSET;
        }
    }

    private void reselectTracksInternalAndSeek() throws ExoPlaybackException {
        reselectTracksInternal();
        seekToCurrentPosition(true);
    }

    private void reselectTracksInternal() throws ExoPlaybackException {
        float f = this.mediaClock.getPlaybackParameters().speed;
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        TrackSelectorResult trackSelectorResult = null;
        boolean z = true;
        for (MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod(); playingPeriod != null && playingPeriod.prepared; playingPeriod = playingPeriod.getNext()) {
            TrackSelectorResult selectTracks = playingPeriod.selectTracks(f, this.playbackInfo.timeline, this.playbackInfo.playWhenReady);
            if (playingPeriod == this.queue.getPlayingPeriod()) {
                trackSelectorResult = selectTracks;
            }
            if (selectTracks.isEquivalent(playingPeriod.getTrackSelectorResult())) {
                if (playingPeriod == readingPeriod) {
                    z = false;
                }
            } else {
                if (z) {
                    MediaPeriodHolder playingPeriod2 = this.queue.getPlayingPeriod();
                    boolean z2 = (this.queue.removeAfter(playingPeriod2) & 1) != 0;
                    boolean[] zArr = new boolean[this.renderers.length];
                    long applyTrackSelection = playingPeriod2.applyTrackSelection((TrackSelectorResult) Assertions.checkNotNull(trackSelectorResult), this.playbackInfo.positionUs, z2, zArr);
                    boolean z3 = (this.playbackInfo.playbackState == 4 || applyTrackSelection == this.playbackInfo.positionUs) ? false : true;
                    this.playbackInfo = handlePositionDiscontinuity(this.playbackInfo.periodId, applyTrackSelection, this.playbackInfo.requestedContentPositionUs, this.playbackInfo.discontinuityStartPositionUs, z3, 5);
                    if (z3) {
                        resetRendererPosition(applyTrackSelection);
                    }
                    disableAndResetPrewarmingRenderers();
                    boolean[] zArr2 = new boolean[this.renderers.length];
                    int i = 0;
                    while (true) {
                        RendererHolder[] rendererHolderArr = this.renderers;
                        if (i >= rendererHolderArr.length) {
                            break;
                        }
                        int enabledRendererCount = rendererHolderArr[i].getEnabledRendererCount();
                        zArr2[i] = this.renderers[i].isRendererEnabled();
                        this.renderers[i].maybeDisableOrResetPosition(playingPeriod2.sampleStreams[i], this.mediaClock, this.rendererPositionUs, zArr[i]);
                        if (enabledRendererCount - this.renderers[i].getEnabledRendererCount() > 0) {
                            maybeTriggerOnRendererReadyChanged(i, false);
                        }
                        this.enabledRendererCount -= enabledRendererCount - this.renderers[i].getEnabledRendererCount();
                        i++;
                    }
                    enableRenderers(zArr2, this.rendererPositionUs);
                    playingPeriod2.allRenderersInCorrectState = true;
                } else {
                    this.queue.removeAfter(playingPeriod);
                    if (playingPeriod.prepared) {
                        long max = Math.max(playingPeriod.info.startPositionUs, playingPeriod.toPeriodTime(this.rendererPositionUs));
                        if (this.hasSecondaryRenderers && areRenderersPrewarming() && this.queue.getPrewarmingPeriod() == playingPeriod) {
                            disableAndResetPrewarmingRenderers();
                        }
                        playingPeriod.applyTrackSelection(selectTracks, max, false);
                    }
                }
                handleLoadingMediaPeriodChanged(true);
                if (this.playbackInfo.playbackState != 4) {
                    maybeContinueLoading();
                    updatePlaybackPositions();
                    this.handler.sendEmptyMessage(2);
                    return;
                }
                return;
            }
        }
    }

    private void updateTrackSelectionPlaybackSpeed(float f) {
        ExoTrackSelection[] exoTrackSelectionArr;
        for (MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod(); playingPeriod != null; playingPeriod = playingPeriod.getNext()) {
            for (ExoTrackSelection exoTrackSelection : playingPeriod.getTrackSelectorResult().selections) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.onPlaybackSpeed(f);
                }
            }
        }
    }

    private void notifyTrackSelectionDiscontinuity() {
        ExoTrackSelection[] exoTrackSelectionArr;
        for (MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod(); playingPeriod != null; playingPeriod = playingPeriod.getNext()) {
            for (ExoTrackSelection exoTrackSelection : playingPeriod.getTrackSelectorResult().selections) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.onDiscontinuity();
                }
            }
        }
    }

    private boolean shouldTransitionToReadyState(boolean z) {
        if (this.enabledRendererCount == 0) {
            return isTimelineReady();
        }
        boolean z2 = false;
        if (z) {
            if (this.playbackInfo.isLoading) {
                MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
                long targetLiveOffsetUs = shouldUseLivePlaybackSpeedControl(this.playbackInfo.timeline, playingPeriod.info.id) ? this.livePlaybackSpeedControl.getTargetLiveOffsetUs() : C.TIME_UNSET;
                MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
                boolean z3 = loadingPeriod.isFullyBuffered() && loadingPeriod.info.isFinal;
                if (loadingPeriod.info.id.isAd() && !loadingPeriod.prepared) {
                    z2 = true;
                }
                if (z3 || z2) {
                    return true;
                }
                return this.loadControl.shouldStartPlayback(new LoadControl.Parameters(this.playerId, this.playbackInfo.timeline, playingPeriod.info.id, playingPeriod.toPeriodTime(this.rendererPositionUs), getTotalBufferedDurationUs(loadingPeriod.getBufferedPositionUs()), this.mediaClock.getPlaybackParameters().speed, this.playbackInfo.playWhenReady, this.isRebuffering, targetLiveOffsetUs, this.lastRebufferRealtimeMs));
            }
            return true;
        }
        return false;
    }

    private boolean isTimelineReady() {
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        long j = playingPeriod.info.durationUs;
        if (playingPeriod.prepared) {
            return j == C.TIME_UNSET || this.playbackInfo.positionUs < j || !shouldPlayWhenReady();
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:235:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x01ea A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:252:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0230  */
    /* JADX WARN: Type inference failed for: r12v0, types: [long] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleMediaSourceListInfoRefreshed(Timeline timeline, boolean z) throws ExoPlaybackException {
        Timeline timeline2;
        MediaSource.MediaPeriodId mediaPeriodId;
        boolean z2;
        int i;
        long j;
        boolean z3;
        int i2;
        boolean z4;
        long j2;
        long maxRendererReadPositionUs;
        int i3;
        boolean z5;
        Timeline timeline3 = timeline;
        PositionUpdateForPlaylistChange resolvePositionForPlaylistChange = resolvePositionForPlaylistChange(timeline3, this.playbackInfo, this.pendingInitialSeekPosition, this.queue, this.repeatMode, this.shuffleModeEnabled, this.window, this.period);
        MediaSource.MediaPeriodId mediaPeriodId2 = resolvePositionForPlaylistChange.periodId;
        ?? r12 = resolvePositionForPlaylistChange.requestedContentPositionUs;
        boolean z6 = resolvePositionForPlaylistChange.forceBufferingState;
        long j3 = resolvePositionForPlaylistChange.periodPositionUs;
        boolean z7 = (this.playbackInfo.periodId.equals(mediaPeriodId2) && j3 == this.playbackInfo.positionUs) ? false : true;
        try {
            if (resolvePositionForPlaylistChange.endPlayback) {
                if (this.playbackInfo.playbackState != 1) {
                    setState(4);
                }
                resetInternal(false, false, false, true);
            }
            for (RendererHolder rendererHolder : this.renderers) {
                try {
                    rendererHolder.setTimeline(timeline3);
                } catch (Throwable th) {
                    th = th;
                    timeline2 = timeline3;
                    mediaPeriodId = mediaPeriodId2;
                    i = 4;
                    j = r12;
                    z3 = false;
                    z2 = true;
                    i2 = -1;
                    z4 = z3;
                    MediaSource.MediaPeriodId mediaPeriodId3 = mediaPeriodId;
                    updatePlaybackSpeedSettingsForNewPeriod(timeline2, mediaPeriodId3, this.playbackInfo.timeline, this.playbackInfo.periodId, !resolvePositionForPlaylistChange.setTargetLiveOffset ? j3 : -9223372036854775807L, false);
                    if (!z7 || j != this.playbackInfo.requestedContentPositionUs) {
                        Object obj = this.playbackInfo.periodId.periodUid;
                        Timeline timeline4 = this.playbackInfo.timeline;
                        this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId3, j3, j, this.playbackInfo.discontinuityStartPositionUs, (z7 || !z || timeline4.isEmpty() || timeline4.getPeriodByUid(obj, this.period).isPlaceholder) ? z4 : z2, timeline2.getIndexOfPeriod(obj) != i2 ? i : 3);
                    }
                    resetPendingPauseAtEndOfPeriod();
                    resolvePendingMessagePositions(timeline2, this.playbackInfo.timeline);
                    this.playbackInfo = this.playbackInfo.copyWithTimeline(timeline2);
                    if (!timeline2.isEmpty()) {
                        this.pendingInitialSeekPosition = null;
                    }
                    handleLoadingMediaPeriodChanged(z4);
                    this.handler.sendEmptyMessage(2);
                    throw th;
                }
            }
            try {
                if (z7) {
                    i3 = 2;
                    i = 4;
                    j = r12;
                    z5 = false;
                    z5 = false;
                    z2 = true;
                    i2 = -1;
                    if (!timeline3.isEmpty()) {
                        for (MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod(); playingPeriod != null; playingPeriod = playingPeriod.getNext()) {
                            if (playingPeriod.info.id.equals(mediaPeriodId2)) {
                                playingPeriod.info = this.queue.getUpdatedMediaPeriodInfo(timeline3, playingPeriod.info);
                                playingPeriod.updateClipping();
                            }
                        }
                        j3 = seekToPeriodPosition(mediaPeriodId2, j3, z6);
                    }
                } else {
                    try {
                        j2 = 0;
                        maxRendererReadPositionUs = this.queue.getReadingPeriod() == null ? 0L : getMaxRendererReadPositionUs(this.queue.getReadingPeriod());
                        if (areRenderersPrewarming() && this.queue.getPrewarmingPeriod() != null) {
                            j2 = getMaxRendererReadPositionUs(this.queue.getPrewarmingPeriod());
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    try {
                        try {
                            i3 = 2;
                            z2 = true;
                            i = 4;
                            j = r12;
                            r12 = 0;
                            z5 = false;
                            z5 = false;
                            z5 = false;
                            i2 = -1;
                            try {
                                int updateQueuedPeriods = this.queue.updateQueuedPeriods(timeline, this.rendererPositionUs, maxRendererReadPositionUs, j2);
                                timeline3 = timeline;
                                if ((updateQueuedPeriods & 1) != 0) {
                                    seekToCurrentPosition(false);
                                } else if ((updateQueuedPeriods & 2) != 0) {
                                    disableAndResetPrewarmingRenderers();
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                timeline3 = timeline;
                                timeline2 = timeline3;
                                mediaPeriodId = mediaPeriodId2;
                                z4 = r12;
                                MediaSource.MediaPeriodId mediaPeriodId32 = mediaPeriodId;
                                updatePlaybackSpeedSettingsForNewPeriod(timeline2, mediaPeriodId32, this.playbackInfo.timeline, this.playbackInfo.periodId, !resolvePositionForPlaylistChange.setTargetLiveOffset ? j3 : -9223372036854775807L, false);
                                if (!z7) {
                                }
                                Object obj2 = this.playbackInfo.periodId.periodUid;
                                Timeline timeline42 = this.playbackInfo.timeline;
                                if (z7) {
                                }
                                this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId32, j3, j, this.playbackInfo.discontinuityStartPositionUs, (z7 || !z || timeline42.isEmpty() || timeline42.getPeriodByUid(obj2, this.period).isPlaceholder) ? z4 : z2, timeline2.getIndexOfPeriod(obj2) != i2 ? i : 3);
                                resetPendingPauseAtEndOfPeriod();
                                resolvePendingMessagePositions(timeline2, this.playbackInfo.timeline);
                                this.playbackInfo = this.playbackInfo.copyWithTimeline(timeline2);
                                if (!timeline2.isEmpty()) {
                                }
                                handleLoadingMediaPeriodChanged(z4);
                                this.handler.sendEmptyMessage(2);
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            timeline3 = timeline;
                            i = 4;
                            j = r12;
                            r12 = 0;
                            z2 = true;
                            i2 = -1;
                            timeline2 = timeline3;
                            mediaPeriodId = mediaPeriodId2;
                            z4 = r12;
                            MediaSource.MediaPeriodId mediaPeriodId322 = mediaPeriodId;
                            updatePlaybackSpeedSettingsForNewPeriod(timeline2, mediaPeriodId322, this.playbackInfo.timeline, this.playbackInfo.periodId, !resolvePositionForPlaylistChange.setTargetLiveOffset ? j3 : -9223372036854775807L, false);
                            if (!z7) {
                            }
                            Object obj22 = this.playbackInfo.periodId.periodUid;
                            Timeline timeline422 = this.playbackInfo.timeline;
                            if (z7) {
                            }
                            this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId322, j3, j, this.playbackInfo.discontinuityStartPositionUs, (z7 || !z || timeline422.isEmpty() || timeline422.getPeriodByUid(obj22, this.period).isPlaceholder) ? z4 : z2, timeline2.getIndexOfPeriod(obj22) != i2 ? i : 3);
                            resetPendingPauseAtEndOfPeriod();
                            resolvePendingMessagePositions(timeline2, this.playbackInfo.timeline);
                            this.playbackInfo = this.playbackInfo.copyWithTimeline(timeline2);
                            if (!timeline2.isEmpty()) {
                            }
                            handleLoadingMediaPeriodChanged(z4);
                            this.handler.sendEmptyMessage(2);
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        timeline3 = timeline;
                        i = 4;
                        j = r12;
                        r12 = 0;
                        z2 = true;
                        i2 = -1;
                        timeline2 = timeline3;
                        mediaPeriodId = mediaPeriodId2;
                        z4 = r12;
                        MediaSource.MediaPeriodId mediaPeriodId3222 = mediaPeriodId;
                        updatePlaybackSpeedSettingsForNewPeriod(timeline2, mediaPeriodId3222, this.playbackInfo.timeline, this.playbackInfo.periodId, !resolvePositionForPlaylistChange.setTargetLiveOffset ? j3 : -9223372036854775807L, false);
                        if (!z7) {
                        }
                        Object obj222 = this.playbackInfo.periodId.periodUid;
                        Timeline timeline4222 = this.playbackInfo.timeline;
                        if (z7) {
                        }
                        this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId3222, j3, j, this.playbackInfo.discontinuityStartPositionUs, (z7 || !z || timeline4222.isEmpty() || timeline4222.getPeriodByUid(obj222, this.period).isPlaceholder) ? z4 : z2, timeline2.getIndexOfPeriod(obj222) != i2 ? i : 3);
                        resetPendingPauseAtEndOfPeriod();
                        resolvePendingMessagePositions(timeline2, this.playbackInfo.timeline);
                        this.playbackInfo = this.playbackInfo.copyWithTimeline(timeline2);
                        if (!timeline2.isEmpty()) {
                        }
                        handleLoadingMediaPeriodChanged(z4);
                        this.handler.sendEmptyMessage(2);
                        throw th;
                    }
                }
                updatePlaybackSpeedSettingsForNewPeriod(timeline3, mediaPeriodId2, this.playbackInfo.timeline, this.playbackInfo.periodId, resolvePositionForPlaylistChange.setTargetLiveOffset ? j3 : -9223372036854775807L, false);
                Timeline timeline5 = timeline3;
                if (z7 || j != this.playbackInfo.requestedContentPositionUs) {
                    Object obj3 = this.playbackInfo.periodId.periodUid;
                    Timeline timeline6 = this.playbackInfo.timeline;
                    this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId2, j3, j, this.playbackInfo.discontinuityStartPositionUs, (!z7 || !z || timeline6.isEmpty() || timeline6.getPeriodByUid(obj3, this.period).isPlaceholder) ? z5 : z2, timeline5.getIndexOfPeriod(obj3) == i2 ? i : 3);
                }
                resetPendingPauseAtEndOfPeriod();
                resolvePendingMessagePositions(timeline5, this.playbackInfo.timeline);
                this.playbackInfo = this.playbackInfo.copyWithTimeline(timeline5);
                if (!timeline5.isEmpty()) {
                    this.pendingInitialSeekPosition = null;
                }
                handleLoadingMediaPeriodChanged(z5);
                this.handler.sendEmptyMessage(i3);
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Throwable th7) {
            th = th7;
            timeline2 = timeline3;
            mediaPeriodId = mediaPeriodId2;
            z2 = true;
            i = 4;
            j = r12;
            z3 = false;
        }
    }

    private void updatePlaybackSpeedSettingsForNewPeriod(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline2, MediaSource.MediaPeriodId mediaPeriodId2, long j, boolean z) throws ExoPlaybackException {
        if (!shouldUseLivePlaybackSpeedControl(timeline, mediaPeriodId)) {
            PlaybackParameters playbackParameters = mediaPeriodId.isAd() ? PlaybackParameters.DEFAULT : this.playbackInfo.playbackParameters;
            if (this.mediaClock.getPlaybackParameters().equals(playbackParameters)) {
                return;
            }
            setMediaClockPlaybackParameters(playbackParameters);
            handlePlaybackParameters(this.playbackInfo.playbackParameters, playbackParameters.speed, false, false);
            return;
        }
        timeline.getWindow(timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period).windowIndex, this.window);
        this.livePlaybackSpeedControl.setLiveConfiguration((MediaItem.LiveConfiguration) Util.castNonNull(this.window.liveConfiguration));
        if (j != C.TIME_UNSET) {
            this.livePlaybackSpeedControl.setTargetLiveOffsetOverrideUs(getLiveOffsetUs(timeline, mediaPeriodId.periodUid, j));
            return;
        }
        if (!Objects.equals(!timeline2.isEmpty() ? timeline2.getWindow(timeline2.getPeriodByUid(mediaPeriodId2.periodUid, this.period).windowIndex, this.window).uid : null, this.window.uid) || z) {
            this.livePlaybackSpeedControl.setTargetLiveOffsetOverrideUs(C.TIME_UNSET);
        }
    }

    private long getMaxRendererReadPositionUs(MediaPeriodHolder mediaPeriodHolder) {
        if (mediaPeriodHolder == null) {
            return 0L;
        }
        long rendererOffset = mediaPeriodHolder.getRendererOffset();
        if (!mediaPeriodHolder.prepared) {
            return rendererOffset;
        }
        int i = 0;
        while (true) {
            RendererHolder[] rendererHolderArr = this.renderers;
            if (i >= rendererHolderArr.length) {
                return rendererOffset;
            }
            if (rendererHolderArr[i].isReadingFromPeriod(mediaPeriodHolder)) {
                long readingPositionUs = this.renderers[i].getReadingPositionUs(mediaPeriodHolder);
                if (readingPositionUs == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                rendererOffset = Math.max(readingPositionUs, rendererOffset);
            }
            i++;
        }
    }

    private void updatePeriods() throws ExoPlaybackException {
        if (this.playbackInfo.timeline.isEmpty() || !this.mediaSourceList.isPrepared()) {
            return;
        }
        boolean maybeUpdateLoadingPeriod = maybeUpdateLoadingPeriod();
        maybeUpdatePrewarmingPeriod();
        maybeUpdateReadingPeriod();
        maybeUpdateReadingRenderers();
        maybeUpdatePlayingPeriod();
        maybeUpdatePreloadPeriods(maybeUpdateLoadingPeriod);
    }

    private boolean maybeUpdateLoadingPeriod() throws ExoPlaybackException {
        MediaPeriodInfo nextMediaPeriodInfo;
        this.queue.reevaluateBuffer(this.rendererPositionUs);
        boolean z = false;
        if (this.queue.shouldLoadNextMediaPeriod() && (nextMediaPeriodInfo = this.queue.getNextMediaPeriodInfo(this.rendererPositionUs, this.playbackInfo)) != null) {
            MediaPeriodHolder enqueueNextMediaPeriodHolder = this.queue.enqueueNextMediaPeriodHolder(nextMediaPeriodInfo);
            if (!enqueueNextMediaPeriodHolder.prepareCalled) {
                enqueueNextMediaPeriodHolder.prepare(this, nextMediaPeriodInfo.startPositionUs);
            } else if (enqueueNextMediaPeriodHolder.prepared) {
                this.handler.obtainMessage(8, enqueueNextMediaPeriodHolder.mediaPeriod).sendToTarget();
            }
            if (this.queue.getPlayingPeriod() == enqueueNextMediaPeriodHolder) {
                resetRendererPosition(nextMediaPeriodInfo.startPositionUs);
            }
            handleLoadingMediaPeriodChanged(false);
            z = true;
        }
        if (this.shouldContinueLoading) {
            this.shouldContinueLoading = isLoadingPossible(this.queue.getLoadingPeriod());
            updateIsLoading();
            return z;
        }
        maybeContinueLoading();
        return z;
    }

    private void maybeUpdatePrewarmingPeriod() throws ExoPlaybackException {
        MediaPeriodHolder prewarmingPeriod;
        if (this.pendingPauseAtEndOfPeriod || !this.hasSecondaryRenderers || this.isPrewarmingDisabledUntilNextTransition || areRenderersPrewarming() || (prewarmingPeriod = this.queue.getPrewarmingPeriod()) == null || prewarmingPeriod != this.queue.getReadingPeriod() || prewarmingPeriod.getNext() == null || !prewarmingPeriod.getNext().prepared) {
            return;
        }
        this.queue.advancePrewarmingPeriod();
        maybePrewarmRenderers();
    }

    private void maybePrewarmRenderers() throws ExoPlaybackException {
        MediaPeriodHolder prewarmingPeriod = this.queue.getPrewarmingPeriod();
        if (prewarmingPeriod == null) {
            return;
        }
        TrackSelectorResult trackSelectorResult = prewarmingPeriod.getTrackSelectorResult();
        for (int i = 0; i < this.renderers.length; i++) {
            if (trackSelectorResult.isRendererEnabled(i) && this.renderers[i].hasSecondary() && !this.renderers[i].isPrewarming()) {
                this.renderers[i].startPrewarming();
                enableRenderer(prewarmingPeriod, i, false, prewarmingPeriod.getStartPositionRendererTime());
            }
        }
        if (areRenderersPrewarming()) {
            this.prewarmingMediaPeriodDiscontinuity = prewarmingPeriod.mediaPeriod.readDiscontinuity();
            if (prewarmingPeriod.isFullyBuffered()) {
                return;
            }
            this.queue.removeAfter(prewarmingPeriod);
            handleLoadingMediaPeriodChanged(false);
            maybeContinueLoading();
        }
    }

    private void maybeUpdateReadingPeriod() throws ExoPlaybackException {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        if (readingPeriod == null) {
            return;
        }
        int i = 0;
        if (readingPeriod.getNext() == null || this.pendingPauseAtEndOfPeriod) {
            if (readingPeriod.info.isFinal || this.pendingPauseAtEndOfPeriod) {
                RendererHolder[] rendererHolderArr = this.renderers;
                int length = rendererHolderArr.length;
                while (i < length) {
                    RendererHolder rendererHolder = rendererHolderArr[i];
                    if (rendererHolder.isReadingFromPeriod(readingPeriod) && rendererHolder.hasReadPeriodToEnd(readingPeriod)) {
                        rendererHolder.setCurrentStreamFinal(readingPeriod, (readingPeriod.info.durationUs == C.TIME_UNSET || readingPeriod.info.durationUs == Long.MIN_VALUE) ? -9223372036854775807L : readingPeriod.getRendererOffset() + readingPeriod.info.durationUs);
                    }
                    i++;
                }
            }
        } else if (hasReadingPeriodFinishedReading()) {
            if (areRenderersPrewarming() && this.queue.getPrewarmingPeriod() == this.queue.getReadingPeriod()) {
                return;
            }
            if (readingPeriod.getNext().prepared || this.rendererPositionUs >= readingPeriod.getNext().getStartPositionRendererTime()) {
                TrackSelectorResult trackSelectorResult = readingPeriod.getTrackSelectorResult();
                MediaPeriodHolder advanceReadingPeriod = this.queue.advanceReadingPeriod();
                TrackSelectorResult trackSelectorResult2 = advanceReadingPeriod.getTrackSelectorResult();
                updatePlaybackSpeedSettingsForNewPeriod(this.playbackInfo.timeline, advanceReadingPeriod.info.id, this.playbackInfo.timeline, readingPeriod.info.id, C.TIME_UNSET, false);
                if (advanceReadingPeriod.prepared && ((this.hasSecondaryRenderers && this.prewarmingMediaPeriodDiscontinuity != C.TIME_UNSET) || advanceReadingPeriod.mediaPeriod.readDiscontinuity() != C.TIME_UNSET)) {
                    this.prewarmingMediaPeriodDiscontinuity = C.TIME_UNSET;
                    boolean z = this.hasSecondaryRenderers && !this.isPrewarmingDisabledUntilNextTransition;
                    if (z) {
                        int i2 = 0;
                        while (true) {
                            if (i2 >= this.renderers.length) {
                                break;
                            } else if (trackSelectorResult2.isRendererEnabled(i2) && !MimeTypes.allSamplesAreSyncSamples(trackSelectorResult2.selections[i2].getSelectedFormat().sampleMimeType, trackSelectorResult2.selections[i2].getSelectedFormat().codecs) && !this.renderers[i2].isPrewarming()) {
                                z = false;
                                break;
                            } else {
                                i2++;
                            }
                        }
                    }
                    if (!z) {
                        setAllNonPrewarmingRendererStreamsFinal(advanceReadingPeriod.getStartPositionRendererTime());
                        if (advanceReadingPeriod.isFullyBuffered()) {
                            return;
                        }
                        this.queue.removeAfter(advanceReadingPeriod);
                        handleLoadingMediaPeriodChanged(false);
                        maybeContinueLoading();
                        return;
                    }
                }
                RendererHolder[] rendererHolderArr2 = this.renderers;
                int length2 = rendererHolderArr2.length;
                while (i < length2) {
                    rendererHolderArr2[i].maybeSetOldStreamToFinal(trackSelectorResult, trackSelectorResult2, advanceReadingPeriod.getStartPositionRendererTime());
                    i++;
                }
            }
        }
    }

    private void maybeUpdateReadingRenderers() throws ExoPlaybackException {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        if (readingPeriod == null || this.queue.getPlayingPeriod() == readingPeriod || readingPeriod.allRenderersInCorrectState || !updateRenderersForTransition()) {
            return;
        }
        this.queue.getReadingPeriod().allRenderersInCorrectState = true;
    }

    private boolean updateRenderersForTransition() throws ExoPlaybackException {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        TrackSelectorResult trackSelectorResult = readingPeriod.getTrackSelectorResult();
        boolean z = true;
        int i = 0;
        while (true) {
            RendererHolder[] rendererHolderArr = this.renderers;
            if (i >= rendererHolderArr.length) {
                break;
            }
            int enabledRendererCount = rendererHolderArr[i].getEnabledRendererCount();
            int replaceStreamsOrDisableRendererForTransition = this.renderers[i].replaceStreamsOrDisableRendererForTransition(readingPeriod, trackSelectorResult, this.mediaClock);
            if ((replaceStreamsOrDisableRendererForTransition & 2) != 0 && this.offloadSchedulingEnabled) {
                setOffloadSchedulingEnabled(false);
            }
            this.enabledRendererCount -= enabledRendererCount - this.renderers[i].getEnabledRendererCount();
            z &= (replaceStreamsOrDisableRendererForTransition & 1) != 0;
            i++;
        }
        if (z) {
            for (int i2 = 0; i2 < this.renderers.length; i2++) {
                if (trackSelectorResult.isRendererEnabled(i2) && !this.renderers[i2].isReadingFromPeriod(readingPeriod)) {
                    enableRenderer(readingPeriod, i2, false, readingPeriod.getStartPositionRendererTime());
                }
            }
        }
        return z;
    }

    private void maybeUpdatePreloadPeriods(boolean z) {
        if (this.preloadConfiguration.targetPreloadDurationUs == C.TIME_UNSET) {
            return;
        }
        if (z || !this.playbackInfo.timeline.equals(this.lastPreloadPoolInvalidationTimeline)) {
            this.lastPreloadPoolInvalidationTimeline = this.playbackInfo.timeline;
            this.queue.invalidatePreloadPool(this.playbackInfo.timeline);
        }
        maybeContinuePreloading();
    }

    private void maybeContinuePreloading() {
        this.queue.maybeUpdatePreloadMediaPeriodHolder();
        MediaPeriodHolder preloadingPeriod = this.queue.getPreloadingPeriod();
        if (preloadingPeriod != null) {
            if ((!preloadingPeriod.prepareCalled || preloadingPeriod.prepared) && !preloadingPeriod.mediaPeriod.isLoading()) {
                if (this.loadControl.shouldContinuePreloading(this.playbackInfo.timeline, preloadingPeriod.info.id, preloadingPeriod.prepared ? preloadingPeriod.mediaPeriod.getBufferedPositionUs() : 0L)) {
                    if (!preloadingPeriod.prepareCalled) {
                        preloadingPeriod.prepare(this, preloadingPeriod.info.startPositionUs);
                    } else {
                        preloadingPeriod.continueLoading(new LoadingInfo.Builder().setPlaybackPositionUs(preloadingPeriod.toPeriodTime(this.rendererPositionUs)).setPlaybackSpeed(this.mediaClock.getPlaybackParameters().speed).setLastRebufferRealtimeMs(this.lastRebufferRealtimeMs).build());
                    }
                }
            }
        }
    }

    private void maybeUpdatePlayingPeriod() throws ExoPlaybackException {
        boolean z = false;
        while (shouldAdvancePlayingPeriod()) {
            if (z) {
                maybeNotifyPlaybackInfoChanged();
            }
            this.isPrewarmingDisabledUntilNextTransition = false;
            MediaPeriodHolder mediaPeriodHolder = (MediaPeriodHolder) Assertions.checkNotNull(this.queue.advancePlayingPeriod());
            this.playbackInfo = handlePositionDiscontinuity(mediaPeriodHolder.info.id, mediaPeriodHolder.info.startPositionUs, mediaPeriodHolder.info.requestedContentPositionUs, mediaPeriodHolder.info.startPositionUs, !(this.playbackInfo.periodId.periodUid.equals(mediaPeriodHolder.info.id.periodUid) && this.playbackInfo.periodId.adGroupIndex == -1 && mediaPeriodHolder.info.id.adGroupIndex == -1 && this.playbackInfo.periodId.nextAdGroupIndex != mediaPeriodHolder.info.id.nextAdGroupIndex), 0);
            resetPendingPauseAtEndOfPeriod();
            updatePlaybackPositions();
            if (areRenderersPrewarming() && mediaPeriodHolder == this.queue.getPrewarmingPeriod()) {
                maybeHandlePrewarmingTransition();
            }
            if (this.playbackInfo.playbackState == 3) {
                startRenderers();
            }
            allowRenderersToRenderStartOfStreams();
            z = true;
        }
    }

    private void maybeHandlePrewarmingTransition() throws ExoPlaybackException {
        for (RendererHolder rendererHolder : this.renderers) {
            rendererHolder.maybeHandlePrewarmingTransition();
        }
    }

    private void maybeUpdateOffloadScheduling() {
        MediaPeriodHolder playingPeriod;
        boolean z;
        if (this.queue.getPlayingPeriod() == this.queue.getReadingPeriod() && (playingPeriod = this.queue.getPlayingPeriod()) != null) {
            TrackSelectorResult trackSelectorResult = playingPeriod.getTrackSelectorResult();
            boolean z2 = false;
            int i = 0;
            boolean z3 = false;
            while (true) {
                if (i >= this.renderers.length) {
                    z = true;
                    break;
                }
                if (trackSelectorResult.isRendererEnabled(i)) {
                    if (this.renderers[i].getTrackType() != 1) {
                        z = false;
                        break;
                    } else if (trackSelectorResult.rendererConfigurations[i].offloadModePreferred != 0) {
                        z3 = true;
                    }
                }
                i++;
            }
            if (z3 && z) {
                z2 = true;
            }
            setOffloadSchedulingEnabled(z2);
        }
    }

    private void allowRenderersToRenderStartOfStreams() {
        TrackSelectorResult trackSelectorResult = this.queue.getPlayingPeriod().getTrackSelectorResult();
        for (int i = 0; i < this.renderers.length; i++) {
            if (trackSelectorResult.isRendererEnabled(i)) {
                this.renderers[i].enableMayRenderStartOfStream();
            }
        }
    }

    private void resetPendingPauseAtEndOfPeriod() {
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        this.pendingPauseAtEndOfPeriod = playingPeriod != null && playingPeriod.info.isLastInTimelineWindow && this.pauseAtEndOfWindow;
    }

    private boolean shouldAdvancePlayingPeriod() {
        MediaPeriodHolder playingPeriod;
        MediaPeriodHolder next;
        return shouldPlayWhenReady() && !this.pendingPauseAtEndOfPeriod && (playingPeriod = this.queue.getPlayingPeriod()) != null && (next = playingPeriod.getNext()) != null && this.rendererPositionUs >= next.getStartPositionRendererTime() && next.allRenderersInCorrectState;
    }

    private boolean hasReadingPeriodFinishedReading() {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        if (!readingPeriod.prepared) {
            return false;
        }
        int i = 0;
        while (true) {
            RendererHolder[] rendererHolderArr = this.renderers;
            if (i >= rendererHolderArr.length) {
                return true;
            }
            if (!rendererHolderArr[i].hasFinishedReadingFromPeriod(readingPeriod)) {
                return false;
            }
            i++;
        }
    }

    private void setAllNonPrewarmingRendererStreamsFinal(long j) {
        for (RendererHolder rendererHolder : this.renderers) {
            rendererHolder.setAllNonPrewarmingRendererStreamsFinal(j);
        }
    }

    private void handlePeriodPrepared(MediaPeriod mediaPeriod) throws ExoPlaybackException {
        if (this.queue.isLoading(mediaPeriod)) {
            handleLoadingPeriodPrepared((MediaPeriodHolder) Assertions.checkNotNull(this.queue.getLoadingPeriod()));
            return;
        }
        MediaPeriodHolder preloadHolderByMediaPeriod = this.queue.getPreloadHolderByMediaPeriod(mediaPeriod);
        if (preloadHolderByMediaPeriod != null) {
            Assertions.checkState(!preloadHolderByMediaPeriod.prepared);
            preloadHolderByMediaPeriod.handlePrepared(this.mediaClock.getPlaybackParameters().speed, this.playbackInfo.timeline, this.playbackInfo.playWhenReady);
            if (this.queue.isPreloading(mediaPeriod)) {
                maybeContinuePreloading();
            }
        }
    }

    private void handleLoadingPeriodPrepared(MediaPeriodHolder mediaPeriodHolder) throws ExoPlaybackException {
        if (!mediaPeriodHolder.prepared) {
            mediaPeriodHolder.handlePrepared(this.mediaClock.getPlaybackParameters().speed, this.playbackInfo.timeline, this.playbackInfo.playWhenReady);
        }
        updateLoadControlTrackSelection(mediaPeriodHolder.info.id, mediaPeriodHolder.getTrackGroups(), mediaPeriodHolder.getTrackSelectorResult());
        if (mediaPeriodHolder == this.queue.getPlayingPeriod()) {
            resetRendererPosition(mediaPeriodHolder.info.startPositionUs);
            enableRenderers();
            mediaPeriodHolder.allRenderersInCorrectState = true;
            this.playbackInfo = handlePositionDiscontinuity(this.playbackInfo.periodId, mediaPeriodHolder.info.startPositionUs, this.playbackInfo.requestedContentPositionUs, mediaPeriodHolder.info.startPositionUs, false, 5);
        }
        maybeContinueLoading();
    }

    private void handleContinueLoadingRequested(MediaPeriod mediaPeriod) {
        if (this.queue.isLoading(mediaPeriod)) {
            this.queue.reevaluateBuffer(this.rendererPositionUs);
            maybeContinueLoading();
        } else if (this.queue.isPreloading(mediaPeriod)) {
            maybeContinuePreloading();
        }
    }

    private void handlePlaybackParameters(PlaybackParameters playbackParameters, boolean z) throws ExoPlaybackException {
        handlePlaybackParameters(playbackParameters, playbackParameters.speed, true, z);
    }

    private void handlePlaybackParameters(PlaybackParameters playbackParameters, float f, boolean z, boolean z2) throws ExoPlaybackException {
        if (z) {
            if (z2) {
                this.playbackInfoUpdate.incrementPendingOperationAcks(1);
            }
            this.playbackInfo = this.playbackInfo.copyWithPlaybackParameters(playbackParameters);
        }
        updateTrackSelectionPlaybackSpeed(playbackParameters.speed);
        for (RendererHolder rendererHolder : this.renderers) {
            rendererHolder.setPlaybackSpeed(f, playbackParameters.speed);
        }
    }

    private void maybeContinueLoading() {
        boolean shouldContinueLoading = shouldContinueLoading();
        this.shouldContinueLoading = shouldContinueLoading;
        if (shouldContinueLoading) {
            MediaPeriodHolder mediaPeriodHolder = (MediaPeriodHolder) Assertions.checkNotNull(this.queue.getLoadingPeriod());
            mediaPeriodHolder.continueLoading(new LoadingInfo.Builder().setPlaybackPositionUs(mediaPeriodHolder.toPeriodTime(this.rendererPositionUs)).setPlaybackSpeed(this.mediaClock.getPlaybackParameters().speed).setLastRebufferRealtimeMs(this.lastRebufferRealtimeMs).build());
        }
        updateIsLoading();
    }

    private boolean shouldContinueLoading() {
        long periodTime;
        if (isLoadingPossible(this.queue.getLoadingPeriod())) {
            MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
            long totalBufferedDurationUs = getTotalBufferedDurationUs(loadingPeriod.getNextLoadPositionUs());
            if (loadingPeriod == this.queue.getPlayingPeriod()) {
                periodTime = loadingPeriod.toPeriodTime(this.rendererPositionUs);
            } else {
                periodTime = loadingPeriod.toPeriodTime(this.rendererPositionUs) - loadingPeriod.info.startPositionUs;
            }
            LoadControl.Parameters parameters = new LoadControl.Parameters(this.playerId, this.playbackInfo.timeline, loadingPeriod.info.id, periodTime, totalBufferedDurationUs, this.mediaClock.getPlaybackParameters().speed, this.playbackInfo.playWhenReady, this.isRebuffering, shouldUseLivePlaybackSpeedControl(this.playbackInfo.timeline, loadingPeriod.info.id) ? this.livePlaybackSpeedControl.getTargetLiveOffsetUs() : C.TIME_UNSET, this.lastRebufferRealtimeMs);
            boolean shouldContinueLoading = this.loadControl.shouldContinueLoading(parameters);
            MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
            if (shouldContinueLoading || !playingPeriod.prepared || totalBufferedDurationUs >= PLAYBACK_BUFFER_EMPTY_THRESHOLD_US) {
                return shouldContinueLoading;
            }
            if (this.backBufferDurationUs > 0 || this.retainBackBufferFromKeyframe) {
                playingPeriod.mediaPeriod.discardBuffer(this.playbackInfo.positionUs, false);
                return this.loadControl.shouldContinueLoading(parameters);
            }
            return shouldContinueLoading;
        }
        return false;
    }

    private boolean isLoadingPossible(MediaPeriodHolder mediaPeriodHolder) {
        return (mediaPeriodHolder == null || mediaPeriodHolder.hasLoadingError() || mediaPeriodHolder.getNextLoadPositionUs() == Long.MIN_VALUE) ? false : true;
    }

    private void updateIsLoading() {
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        boolean z = this.shouldContinueLoading || (loadingPeriod != null && loadingPeriod.mediaPeriod.isLoading());
        if (z != this.playbackInfo.isLoading) {
            this.playbackInfo = this.playbackInfo.copyWithIsLoading(z);
        }
    }

    private PlaybackInfo handlePositionDiscontinuity(MediaSource.MediaPeriodId mediaPeriodId, long j, long j2, long j3, boolean z, int i) {
        TrackGroupArray trackGroupArray;
        TrackSelectorResult trackSelectorResult;
        List list;
        TrackGroupArray trackGroups;
        TrackSelectorResult trackSelectorResult2;
        this.deliverPendingMessageAtStartPositionRequired = (!this.deliverPendingMessageAtStartPositionRequired && j == this.playbackInfo.positionUs && mediaPeriodId.equals(this.playbackInfo.periodId)) ? false : true;
        resetPendingPauseAtEndOfPeriod();
        TrackGroupArray trackGroupArray2 = this.playbackInfo.trackGroups;
        TrackSelectorResult trackSelectorResult3 = this.playbackInfo.trackSelectorResult;
        List list2 = this.playbackInfo.staticMetadata;
        if (this.mediaSourceList.isPrepared()) {
            MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
            if (playingPeriod == null) {
                trackGroups = TrackGroupArray.EMPTY;
            } else {
                trackGroups = playingPeriod.getTrackGroups();
            }
            if (playingPeriod == null) {
                trackSelectorResult2 = this.emptyTrackSelectorResult;
            } else {
                trackSelectorResult2 = playingPeriod.getTrackSelectorResult();
            }
            List extractMetadataFromTrackSelectionArray = extractMetadataFromTrackSelectionArray(trackSelectorResult2.selections);
            if (playingPeriod != null && playingPeriod.info.requestedContentPositionUs != j2) {
                playingPeriod.info = playingPeriod.info.copyWithRequestedContentPositionUs(j2);
            }
            maybeUpdateOffloadScheduling();
            trackGroupArray = trackGroups;
            trackSelectorResult = trackSelectorResult2;
            list = extractMetadataFromTrackSelectionArray;
        } else {
            if (!mediaPeriodId.equals(this.playbackInfo.periodId)) {
                trackGroupArray2 = TrackGroupArray.EMPTY;
                trackSelectorResult3 = this.emptyTrackSelectorResult;
                list2 = ImmutableList.of();
            }
            trackGroupArray = trackGroupArray2;
            trackSelectorResult = trackSelectorResult3;
            list = list2;
        }
        if (z) {
            this.playbackInfoUpdate.setPositionDiscontinuity(i);
        }
        return this.playbackInfo.copyWithNewPosition(mediaPeriodId, j, j2, j3, getTotalBufferedDurationUs(), trackGroupArray, trackSelectorResult, list);
    }

    private ImmutableList<Metadata> extractMetadataFromTrackSelectionArray(ExoTrackSelection[] exoTrackSelectionArr) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        boolean z = false;
        for (ExoTrackSelection exoTrackSelection : exoTrackSelectionArr) {
            if (exoTrackSelection != null) {
                Format format = exoTrackSelection.getFormat(0);
                if (format.metadata == null) {
                    builder.add((ImmutableList.Builder) new Metadata(new Metadata.Entry[0]));
                } else {
                    builder.add((ImmutableList.Builder) format.metadata);
                    z = true;
                }
            }
        }
        return z ? builder.build() : ImmutableList.of();
    }

    private void enableRenderers() throws ExoPlaybackException {
        enableRenderers(new boolean[this.renderers.length], this.queue.getReadingPeriod().getStartPositionRendererTime());
    }

    private void enableRenderers(boolean[] zArr, long j) throws ExoPlaybackException {
        long j2;
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        TrackSelectorResult trackSelectorResult = readingPeriod.getTrackSelectorResult();
        for (int i = 0; i < this.renderers.length; i++) {
            if (!trackSelectorResult.isRendererEnabled(i)) {
                this.renderers[i].reset();
            }
        }
        int i2 = 0;
        while (i2 < this.renderers.length) {
            if (!trackSelectorResult.isRendererEnabled(i2) || this.renderers[i2].isReadingFromPeriod(readingPeriod)) {
                j2 = j;
            } else {
                j2 = j;
                enableRenderer(readingPeriod, i2, zArr[i2], j2);
            }
            i2++;
            j = j2;
        }
    }

    private void enableRenderer(MediaPeriodHolder mediaPeriodHolder, int i, boolean z, long j) throws ExoPlaybackException {
        RendererHolder rendererHolder = this.renderers[i];
        if (rendererHolder.isRendererEnabled()) {
            return;
        }
        boolean z2 = mediaPeriodHolder == this.queue.getPlayingPeriod();
        TrackSelectorResult trackSelectorResult = mediaPeriodHolder.getTrackSelectorResult();
        RendererConfiguration rendererConfiguration = trackSelectorResult.rendererConfigurations[i];
        ExoTrackSelection exoTrackSelection = trackSelectorResult.selections[i];
        boolean z3 = shouldPlayWhenReady() && this.playbackInfo.playbackState == 3;
        boolean z4 = !z && z3;
        this.enabledRendererCount++;
        rendererHolder.enable(rendererConfiguration, exoTrackSelection, mediaPeriodHolder.sampleStreams[i], this.rendererPositionUs, z4, z2, j, mediaPeriodHolder.getRendererOffset(), mediaPeriodHolder.info.id, this.mediaClock);
        rendererHolder.handleMessage(11, new Renderer.WakeupListener() { // from class: androidx.media3.exoplayer.ExoPlayerImplInternal.1
            {
                ExoPlayerImplInternal.this = this;
            }

            @Override // androidx.media3.exoplayer.Renderer.WakeupListener
            public void onSleep() {
                ExoPlayerImplInternal.this.requestForRendererSleep = true;
            }

            @Override // androidx.media3.exoplayer.Renderer.WakeupListener
            public void onWakeup() {
                if (ExoPlayerImplInternal.this.dynamicSchedulingEnabled || ExoPlayerImplInternal.this.offloadSchedulingEnabled) {
                    ExoPlayerImplInternal.this.handler.sendEmptyMessage(2);
                }
            }
        }, mediaPeriodHolder);
        if (z3 && z2) {
            rendererHolder.start();
        }
    }

    private void releaseRenderers() {
        for (int i = 0; i < this.renderers.length; i++) {
            this.rendererCapabilities[i].clearListener();
            this.renderers[i].release();
        }
    }

    private void handleLoadingMediaPeriodChanged(boolean z) {
        long bufferedPositionUs;
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        MediaSource.MediaPeriodId mediaPeriodId = loadingPeriod == null ? this.playbackInfo.periodId : loadingPeriod.info.id;
        boolean equals = this.playbackInfo.loadingMediaPeriodId.equals(mediaPeriodId);
        if (!equals) {
            this.playbackInfo = this.playbackInfo.copyWithLoadingMediaPeriodId(mediaPeriodId);
        }
        PlaybackInfo playbackInfo = this.playbackInfo;
        if (loadingPeriod == null) {
            bufferedPositionUs = playbackInfo.positionUs;
        } else {
            bufferedPositionUs = loadingPeriod.getBufferedPositionUs();
        }
        playbackInfo.bufferedPositionUs = bufferedPositionUs;
        this.playbackInfo.totalBufferedDurationUs = getTotalBufferedDurationUs();
        if ((!equals || z) && loadingPeriod != null && loadingPeriod.prepared) {
            updateLoadControlTrackSelection(loadingPeriod.info.id, loadingPeriod.getTrackGroups(), loadingPeriod.getTrackSelectorResult());
        }
    }

    private long getTotalBufferedDurationUs() {
        return getTotalBufferedDurationUs(this.playbackInfo.bufferedPositionUs);
    }

    private long getTotalBufferedDurationUs(long j) {
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        if (loadingPeriod == null) {
            return 0L;
        }
        return Math.max(0L, j - loadingPeriod.toPeriodTime(this.rendererPositionUs));
    }

    private void updateLoadControlTrackSelection(MediaSource.MediaPeriodId mediaPeriodId, TrackGroupArray trackGroupArray, TrackSelectorResult trackSelectorResult) {
        long periodTime;
        MediaPeriodHolder mediaPeriodHolder = (MediaPeriodHolder) Assertions.checkNotNull(this.queue.getLoadingPeriod());
        if (mediaPeriodHolder == this.queue.getPlayingPeriod()) {
            periodTime = mediaPeriodHolder.toPeriodTime(this.rendererPositionUs);
        } else {
            periodTime = mediaPeriodHolder.toPeriodTime(this.rendererPositionUs) - mediaPeriodHolder.info.startPositionUs;
        }
        this.loadControl.onTracksSelected(new LoadControl.Parameters(this.playerId, this.playbackInfo.timeline, mediaPeriodId, periodTime, getTotalBufferedDurationUs(mediaPeriodHolder.getBufferedPositionUs()), this.mediaClock.getPlaybackParameters().speed, this.playbackInfo.playWhenReady, this.isRebuffering, shouldUseLivePlaybackSpeedControl(this.playbackInfo.timeline, mediaPeriodHolder.info.id) ? this.livePlaybackSpeedControl.getTargetLiveOffsetUs() : C.TIME_UNSET, this.lastRebufferRealtimeMs), trackGroupArray, trackSelectorResult.selections);
    }

    private boolean shouldPlayWhenReady() {
        return this.playbackInfo.playWhenReady && this.playbackInfo.playbackSuppressionReason == 0;
    }

    private void maybeThrowRendererStreamError(int i) throws IOException, ExoPlaybackException {
        RendererHolder rendererHolder = this.renderers[i];
        try {
            rendererHolder.maybeThrowStreamError((MediaPeriodHolder) Assertions.checkNotNull(this.queue.getPlayingPeriod()));
        } catch (IOException | RuntimeException e) {
            int trackType = rendererHolder.getTrackType();
            if (trackType == 3 || trackType == 5) {
                TrackSelectorResult trackSelectorResult = this.queue.getPlayingPeriod().getTrackSelectorResult();
                Log.e(TAG, "Disabling track due to error: " + Format.toLogString(trackSelectorResult.selections[i].getSelectedFormat()), e);
                TrackSelectorResult trackSelectorResult2 = new TrackSelectorResult((RendererConfiguration[]) trackSelectorResult.rendererConfigurations.clone(), (ExoTrackSelection[]) trackSelectorResult.selections.clone(), trackSelectorResult.tracks, trackSelectorResult.info);
                trackSelectorResult2.rendererConfigurations[i] = null;
                trackSelectorResult2.selections[i] = null;
                disableRenderer(i);
                this.queue.getPlayingPeriod().applyTrackSelection(trackSelectorResult2, this.playbackInfo.positionUs, false);
                return;
            }
            throw e;
        }
    }

    private boolean areRenderersPrewarming() {
        if (this.hasSecondaryRenderers) {
            for (RendererHolder rendererHolder : this.renderers) {
                if (rendererHolder.isPrewarming()) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private static PositionUpdateForPlaylistChange resolvePositionForPlaylistChange(Timeline timeline, PlaybackInfo playbackInfo, SeekPosition seekPosition, MediaPeriodQueue mediaPeriodQueue, int i, boolean z, Timeline.Window window, Timeline.Period period) {
        long j;
        int i2;
        long j2;
        long j3;
        int i3;
        long j4;
        boolean z2;
        boolean z3;
        boolean z4;
        int i4;
        boolean z5;
        Timeline timeline2;
        Timeline.Period period2;
        long j5;
        long longValue;
        int i5;
        boolean z6;
        boolean z7;
        boolean z8;
        if (timeline.isEmpty()) {
            return new PositionUpdateForPlaylistChange(PlaybackInfo.getDummyPeriodForEmptyTimeline(), 0L, C.TIME_UNSET, false, true, false);
        }
        MediaSource.MediaPeriodId mediaPeriodId = playbackInfo.periodId;
        Object obj = mediaPeriodId.periodUid;
        boolean isUsingPlaceholderPeriod = isUsingPlaceholderPeriod(playbackInfo, period);
        if (playbackInfo.periodId.isAd() || isUsingPlaceholderPeriod) {
            j = playbackInfo.requestedContentPositionUs;
        } else {
            j = playbackInfo.positionUs;
        }
        long j6 = j;
        boolean z9 = true;
        if (seekPosition != null) {
            i2 = -1;
            j2 = C.TIME_UNSET;
            Pair<Object, Long> resolveSeekPositionUs = resolveSeekPositionUs(timeline, seekPosition, true, i, z, window, period);
            if (resolveSeekPositionUs == null) {
                i5 = timeline.getFirstWindowIndex(z);
                longValue = j6;
                z6 = false;
                z7 = false;
                z8 = true;
            } else {
                if (seekPosition.windowPositionUs == C.TIME_UNSET) {
                    i5 = timeline.getPeriodByUid(resolveSeekPositionUs.first, period).windowIndex;
                    longValue = j6;
                    z6 = false;
                } else {
                    obj = resolveSeekPositionUs.first;
                    longValue = ((Long) resolveSeekPositionUs.second).longValue();
                    i5 = -1;
                    z6 = true;
                }
                z7 = playbackInfo.playbackState == 4;
                z8 = false;
            }
            i3 = i5;
            j3 = longValue;
            z4 = z6;
            z2 = z7;
            z3 = z8;
        } else {
            i2 = -1;
            j2 = C.TIME_UNSET;
            if (playbackInfo.timeline.isEmpty()) {
                i3 = timeline.getFirstWindowIndex(z);
            } else if (timeline.getIndexOfPeriod(obj) == -1) {
                int resolveSubsequentPeriod = resolveSubsequentPeriod(window, period, i, z, obj, playbackInfo.timeline, timeline);
                if (resolveSubsequentPeriod == -1) {
                    i4 = timeline.getFirstWindowIndex(z);
                    z5 = true;
                } else {
                    i4 = resolveSubsequentPeriod;
                    z5 = false;
                }
                i3 = i4;
                obj = obj;
                j3 = j6;
                z3 = z5;
                z2 = false;
                z4 = false;
            } else if (j6 == C.TIME_UNSET) {
                i3 = timeline.getPeriodByUid(obj, period).windowIndex;
                obj = obj;
            } else if (isUsingPlaceholderPeriod) {
                playbackInfo.timeline.getPeriodByUid(mediaPeriodId.periodUid, period);
                if (playbackInfo.timeline.getWindow(period.windowIndex, window).firstPeriodIndex == playbackInfo.timeline.getIndexOfPeriod(mediaPeriodId.periodUid)) {
                    Pair<Object, Long> periodPositionUs = timeline.getPeriodPositionUs(window, period, timeline.getPeriodByUid(obj, period).windowIndex, period.getPositionInWindowUs() + j6);
                    obj = periodPositionUs.first;
                    j4 = ((Long) periodPositionUs.second).longValue();
                } else {
                    obj = obj;
                    j4 = j6;
                }
                j3 = j4;
                i3 = -1;
                z2 = false;
                z3 = false;
                z4 = true;
            } else {
                obj = obj;
                j3 = j6;
                i3 = -1;
                z2 = false;
                z3 = false;
                z4 = false;
            }
            j3 = j6;
            z2 = false;
            z3 = false;
            z4 = false;
        }
        if (i3 != i2) {
            period2 = period;
            Pair<Object, Long> periodPositionUs2 = timeline.getPeriodPositionUs(window, period2, i3, C.TIME_UNSET);
            timeline2 = timeline;
            obj = periodPositionUs2.first;
            j3 = ((Long) periodPositionUs2.second).longValue();
            j5 = j2;
        } else {
            timeline2 = timeline;
            period2 = period;
            j5 = j3;
        }
        MediaSource.MediaPeriodId resolveMediaPeriodIdForAdsAfterPeriodPositionChange = mediaPeriodQueue.resolveMediaPeriodIdForAdsAfterPeriodPositionChange(timeline2, obj, j3);
        boolean z10 = resolveMediaPeriodIdForAdsAfterPeriodPositionChange.nextAdGroupIndex == i2 || (mediaPeriodId.nextAdGroupIndex != i2 && resolveMediaPeriodIdForAdsAfterPeriodPositionChange.nextAdGroupIndex >= mediaPeriodId.nextAdGroupIndex);
        if (!mediaPeriodId.periodUid.equals(obj) || mediaPeriodId.isAd() || resolveMediaPeriodIdForAdsAfterPeriodPositionChange.isAd() || !z10) {
            z9 = false;
        }
        long j7 = j5;
        MediaSource.MediaPeriodId mediaPeriodId2 = resolveMediaPeriodIdForAdsAfterPeriodPositionChange;
        boolean isIgnorableServerSideAdInsertionPeriodChange = isIgnorableServerSideAdInsertionPeriodChange(isUsingPlaceholderPeriod, mediaPeriodId, j6, mediaPeriodId2, timeline2.getPeriodByUid(obj, period2), j7);
        if (z9 || isIgnorableServerSideAdInsertionPeriodChange) {
            mediaPeriodId2 = mediaPeriodId;
        }
        if (mediaPeriodId2.isAd()) {
            if (mediaPeriodId2.equals(mediaPeriodId)) {
                j3 = playbackInfo.positionUs;
            } else {
                timeline2.getPeriodByUid(mediaPeriodId2.periodUid, period2);
                j3 = mediaPeriodId2.adIndexInAdGroup == period2.getFirstAdIndexToPlay(mediaPeriodId2.adGroupIndex) ? period2.getAdResumePositionUs() : 0L;
            }
        }
        return new PositionUpdateForPlaylistChange(mediaPeriodId2, j3, j7, z2, z3, z4);
    }

    private static boolean isIgnorableServerSideAdInsertionPeriodChange(boolean z, MediaSource.MediaPeriodId mediaPeriodId, long j, MediaSource.MediaPeriodId mediaPeriodId2, Timeline.Period period, long j2) {
        if (!z && j == j2 && mediaPeriodId.periodUid.equals(mediaPeriodId2.periodUid)) {
            if (mediaPeriodId.isAd() && period.isServerSideInsertedAdGroup(mediaPeriodId.adGroupIndex)) {
                return (period.getAdState(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup) == 4 || period.getAdState(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup) == 2) ? false : true;
            } else if (mediaPeriodId2.isAd() && period.isServerSideInsertedAdGroup(mediaPeriodId2.adGroupIndex)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isUsingPlaceholderPeriod(PlaybackInfo playbackInfo, Timeline.Period period) {
        MediaSource.MediaPeriodId mediaPeriodId = playbackInfo.periodId;
        Timeline timeline = playbackInfo.timeline;
        return timeline.isEmpty() || timeline.getPeriodByUid(mediaPeriodId.periodUid, period).isPlaceholder;
    }

    private void updateRebufferingState(boolean z, boolean z2) {
        this.isRebuffering = z;
        this.lastRebufferRealtimeMs = (!z || z2) ? C.TIME_UNSET : this.clock.elapsedRealtime();
    }

    private static boolean resolvePendingMessagePosition(PendingMessageInfo pendingMessageInfo, Timeline timeline, Timeline timeline2, int i, boolean z, Timeline.Window window, Timeline.Period period) {
        if (pendingMessageInfo.resolvedPeriodUid == null) {
            Pair<Object, Long> resolveSeekPositionUs = resolveSeekPositionUs(timeline, new SeekPosition(pendingMessageInfo.message.getTimeline(), pendingMessageInfo.message.getMediaItemIndex(), pendingMessageInfo.message.getPositionMs() == Long.MIN_VALUE ? C.TIME_UNSET : Util.msToUs(pendingMessageInfo.message.getPositionMs())), false, i, z, window, period);
            if (resolveSeekPositionUs == null) {
                return false;
            }
            pendingMessageInfo.setResolvedPosition(timeline.getIndexOfPeriod(resolveSeekPositionUs.first), ((Long) resolveSeekPositionUs.second).longValue(), resolveSeekPositionUs.first);
            if (pendingMessageInfo.message.getPositionMs() == Long.MIN_VALUE) {
                resolvePendingMessageEndOfStreamPosition(timeline, pendingMessageInfo, window, period);
            }
            return true;
        }
        int indexOfPeriod = timeline.getIndexOfPeriod(pendingMessageInfo.resolvedPeriodUid);
        if (indexOfPeriod == -1) {
            return false;
        }
        if (pendingMessageInfo.message.getPositionMs() == Long.MIN_VALUE) {
            resolvePendingMessageEndOfStreamPosition(timeline, pendingMessageInfo, window, period);
            return true;
        }
        pendingMessageInfo.resolvedPeriodIndex = indexOfPeriod;
        timeline2.getPeriodByUid(pendingMessageInfo.resolvedPeriodUid, period);
        if (period.isPlaceholder && timeline2.getWindow(period.windowIndex, window).firstPeriodIndex == timeline2.getIndexOfPeriod(pendingMessageInfo.resolvedPeriodUid)) {
            Pair<Object, Long> periodPositionUs = timeline.getPeriodPositionUs(window, period, timeline.getPeriodByUid(pendingMessageInfo.resolvedPeriodUid, period).windowIndex, pendingMessageInfo.resolvedPeriodTimeUs + period.getPositionInWindowUs());
            pendingMessageInfo.setResolvedPosition(timeline.getIndexOfPeriod(periodPositionUs.first), ((Long) periodPositionUs.second).longValue(), periodPositionUs.first);
        }
        return true;
    }

    private static void resolvePendingMessageEndOfStreamPosition(Timeline timeline, PendingMessageInfo pendingMessageInfo, Timeline.Window window, Timeline.Period period) {
        int i = timeline.getWindow(timeline.getPeriodByUid(pendingMessageInfo.resolvedPeriodUid, period).windowIndex, window).lastPeriodIndex;
        pendingMessageInfo.setResolvedPosition(i, period.durationUs != C.TIME_UNSET ? period.durationUs - 1 : Long.MAX_VALUE, timeline.getPeriod(i, period, true).uid);
    }

    private static Pair<Object, Long> resolveSeekPositionUs(Timeline timeline, SeekPosition seekPosition, boolean z, int i, boolean z2, Timeline.Window window, Timeline.Period period) {
        Pair<Object, Long> periodPositionUs;
        Timeline timeline2;
        int resolveSubsequentPeriod;
        Timeline timeline3 = seekPosition.timeline;
        if (timeline.isEmpty()) {
            return null;
        }
        if (timeline3.isEmpty()) {
            timeline3 = timeline;
        }
        try {
            periodPositionUs = timeline3.getPeriodPositionUs(window, period, seekPosition.windowIndex, seekPosition.windowPositionUs);
            timeline2 = timeline3;
        } catch (IndexOutOfBoundsException unused) {
        }
        if (!timeline.equals(timeline2)) {
            if (timeline.getIndexOfPeriod(periodPositionUs.first) == -1) {
                if (z && (resolveSubsequentPeriod = resolveSubsequentPeriod(window, period, i, z2, periodPositionUs.first, timeline2, timeline)) != -1) {
                    return timeline.getPeriodPositionUs(window, period, resolveSubsequentPeriod, C.TIME_UNSET);
                }
                return null;
            } else if (timeline2.getPeriodByUid(periodPositionUs.first, period).isPlaceholder && timeline2.getWindow(period.windowIndex, window).firstPeriodIndex == timeline2.getIndexOfPeriod(periodPositionUs.first)) {
                return timeline.getPeriodPositionUs(window, period, timeline.getPeriodByUid(periodPositionUs.first, period).windowIndex, seekPosition.windowPositionUs);
            }
        }
        return periodPositionUs;
    }

    public static int resolveSubsequentPeriod(Timeline.Window window, Timeline.Period period, int i, boolean z, Object obj, Timeline timeline, Timeline timeline2) {
        Timeline.Period period2;
        Object obj2 = timeline.getWindow(timeline.getPeriodByUid(obj, period).windowIndex, window).uid;
        int i2 = 0;
        for (int i3 = 0; i3 < timeline2.getWindowCount(); i3++) {
            if (timeline2.getWindow(i3, window).uid.equals(obj2)) {
                return i3;
            }
        }
        int indexOfPeriod = timeline.getIndexOfPeriod(obj);
        int periodCount = timeline.getPeriodCount();
        int i4 = indexOfPeriod;
        int i5 = -1;
        while (i2 < periodCount && i5 == -1) {
            Timeline.Window window2 = window;
            period2 = period;
            int i6 = i;
            boolean z2 = z;
            Timeline timeline3 = timeline;
            i4 = timeline3.getNextPeriodIndex(i4, period2, window2, i6, z2);
            if (i4 == -1) {
                break;
            }
            i5 = timeline2.getIndexOfPeriod(timeline3.getUidOfPeriod(i4));
            i2++;
            timeline = timeline3;
            period = period2;
            window = window2;
            i = i6;
            z = z2;
        }
        period2 = period;
        if (i5 == -1) {
            return -1;
        }
        return timeline2.getPeriod(i5, period2).windowIndex;
    }

    /* loaded from: classes2.dex */
    public static final class SeekPosition {
        public final Timeline timeline;
        public final int windowIndex;
        public final long windowPositionUs;

        public SeekPosition(Timeline timeline, int i, long j) {
            this.timeline = timeline;
            this.windowIndex = i;
            this.windowPositionUs = j;
        }
    }

    /* loaded from: classes2.dex */
    public static final class PositionUpdateForPlaylistChange {
        public final boolean endPlayback;
        public final boolean forceBufferingState;
        public final MediaSource.MediaPeriodId periodId;
        public final long periodPositionUs;
        public final long requestedContentPositionUs;
        public final boolean setTargetLiveOffset;

        public PositionUpdateForPlaylistChange(MediaSource.MediaPeriodId mediaPeriodId, long j, long j2, boolean z, boolean z2, boolean z3) {
            this.periodId = mediaPeriodId;
            this.periodPositionUs = j;
            this.requestedContentPositionUs = j2;
            this.forceBufferingState = z;
            this.endPlayback = z2;
            this.setTargetLiveOffset = z3;
        }
    }

    /* loaded from: classes2.dex */
    public static final class PendingMessageInfo implements Comparable<PendingMessageInfo> {
        public final PlayerMessage message;
        public int resolvedPeriodIndex;
        public long resolvedPeriodTimeUs;
        public Object resolvedPeriodUid;

        public PendingMessageInfo(PlayerMessage playerMessage) {
            this.message = playerMessage;
        }

        public void setResolvedPosition(int i, long j, Object obj) {
            this.resolvedPeriodIndex = i;
            this.resolvedPeriodTimeUs = j;
            this.resolvedPeriodUid = obj;
        }

        @Override // java.lang.Comparable
        public int compareTo(PendingMessageInfo pendingMessageInfo) {
            Object obj = this.resolvedPeriodUid;
            if ((obj == null) != (pendingMessageInfo.resolvedPeriodUid == null)) {
                return obj != null ? -1 : 1;
            } else if (obj == null) {
                return 0;
            } else {
                int i = this.resolvedPeriodIndex - pendingMessageInfo.resolvedPeriodIndex;
                return i != 0 ? i : Util.compareLong(this.resolvedPeriodTimeUs, pendingMessageInfo.resolvedPeriodTimeUs);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class MediaSourceListUpdateMessage {
        private final List<MediaSourceList.MediaSourceHolder> mediaSourceHolders;
        private final long positionUs;
        private final ShuffleOrder shuffleOrder;
        private final int windowIndex;

        private MediaSourceListUpdateMessage(List<MediaSourceList.MediaSourceHolder> list, ShuffleOrder shuffleOrder, int i, long j) {
            this.mediaSourceHolders = list;
            this.shuffleOrder = shuffleOrder;
            this.windowIndex = i;
            this.positionUs = j;
        }
    }

    /* loaded from: classes2.dex */
    public static class MoveMediaItemsMessage {
        public final int fromIndex;
        public final int newFromIndex;
        public final ShuffleOrder shuffleOrder;
        public final int toIndex;

        public MoveMediaItemsMessage(int i, int i2, int i3, ShuffleOrder shuffleOrder) {
            this.fromIndex = i;
            this.toIndex = i2;
            this.newFromIndex = i3;
            this.shuffleOrder = shuffleOrder;
        }
    }
}
