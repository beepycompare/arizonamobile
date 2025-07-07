package androidx.media3.exoplayer.source.preload;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.media3.common.C;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.DefaultRendererCapabilitiesList;
import androidx.media3.exoplayer.DefaultRenderersFactory;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.ExoPlayer$Builder$$ExternalSyntheticLambda17;
import androidx.media3.exoplayer.LoadControl;
import androidx.media3.exoplayer.PlaybackLooperProvider;
import androidx.media3.exoplayer.RendererCapabilitiesList;
import androidx.media3.exoplayer.RenderersFactory;
import androidx.media3.exoplayer.source.DefaultMediaSourceFactory;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.preload.BasePreloadManager;
import androidx.media3.exoplayer.source.preload.DefaultPreloadManager;
import androidx.media3.exoplayer.source.preload.PreloadMediaSource;
import androidx.media3.exoplayer.source.preload.TargetPreloadStatusControl;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.exoplayer.trackselection.TrackSelector;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.BandwidthMeter;
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter;
import com.google.common.base.Predicate;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Comparator;
/* loaded from: classes2.dex */
public final class DefaultPreloadManager extends BasePreloadManager<Integer> {
    private final boolean deprecatedConstructorCalled;
    private final Handler preloadHandler;
    private final PlaybackLooperProvider preloadLooperProvider;
    private final PreloadMediaSource.Factory preloadMediaSourceFactory;
    private final RendererCapabilitiesList rendererCapabilitiesList;
    private final TrackSelector trackSelector;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$new$0() {
    }

    /* loaded from: classes2.dex */
    public static final class Builder extends BasePreloadManager.BuilderBase<Integer> {
        private Supplier<BandwidthMeter> bandwidthMeterSupplier;
        private boolean buildCalled;
        private boolean buildExoPlayerCalled;
        private final Context context;
        private Supplier<LoadControl> loadControlSupplier;
        private PlaybackLooperProvider preloadLooperProvider;
        private Supplier<RenderersFactory> renderersFactorySupplier;
        private TrackSelector.Factory trackSelectorFactory;

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ BandwidthMeter lambda$setBandwidthMeter$6(BandwidthMeter bandwidthMeter) {
            return bandwidthMeter;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ LoadControl lambda$setLoadControl$5(LoadControl loadControl) {
            return loadControl;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ MediaSource.Factory lambda$setMediaSourceFactory$3(MediaSource.Factory factory) {
            return factory;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ RenderersFactory lambda$setRenderersFactory$4(RenderersFactory renderersFactory) {
            return renderersFactory;
        }

        public Builder(final Context context, TargetPreloadStatusControl<Integer> targetPreloadStatusControl) {
            super(new RankingDataComparator(), targetPreloadStatusControl, Suppliers.memoize(new Supplier() { // from class: androidx.media3.exoplayer.source.preload.DefaultPreloadManager$Builder$$ExternalSyntheticLambda3
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return DefaultPreloadManager.Builder.lambda$new$0(context);
                }
            }));
            this.context = context;
            this.preloadLooperProvider = new PlaybackLooperProvider();
            this.trackSelectorFactory = new TrackSelector.Factory() { // from class: androidx.media3.exoplayer.source.preload.DefaultPreloadManager$Builder$$ExternalSyntheticLambda4
                @Override // androidx.media3.exoplayer.trackselection.TrackSelector.Factory
                public final TrackSelector createTrackSelector(Context context2) {
                    return new DefaultTrackSelector(context2);
                }
            };
            this.bandwidthMeterSupplier = new Supplier() { // from class: androidx.media3.exoplayer.source.preload.DefaultPreloadManager$Builder$$ExternalSyntheticLambda5
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    BandwidthMeter singletonInstance;
                    singletonInstance = DefaultBandwidthMeter.getSingletonInstance(context);
                    return singletonInstance;
                }
            };
            this.renderersFactorySupplier = Suppliers.memoize(new Supplier() { // from class: androidx.media3.exoplayer.source.preload.DefaultPreloadManager$Builder$$ExternalSyntheticLambda6
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return DefaultPreloadManager.Builder.lambda$new$2(context);
                }
            });
            this.loadControlSupplier = Suppliers.memoize(new ExoPlayer$Builder$$ExternalSyntheticLambda17());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ MediaSource.Factory lambda$new$0(Context context) {
            return new DefaultMediaSourceFactory(context);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ RenderersFactory lambda$new$2(Context context) {
            return new DefaultRenderersFactory(context);
        }

        public Builder setMediaSourceFactory(final MediaSource.Factory factory) {
            Assertions.checkState((this.buildCalled || this.buildExoPlayerCalled) ? false : true);
            this.mediaSourceFactorySupplier = new Supplier() { // from class: androidx.media3.exoplayer.source.preload.DefaultPreloadManager$Builder$$ExternalSyntheticLambda7
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return DefaultPreloadManager.Builder.lambda$setMediaSourceFactory$3(MediaSource.Factory.this);
                }
            };
            return this;
        }

        public Builder setRenderersFactory(final RenderersFactory renderersFactory) {
            Assertions.checkState((this.buildCalled || this.buildExoPlayerCalled) ? false : true);
            this.renderersFactorySupplier = new Supplier() { // from class: androidx.media3.exoplayer.source.preload.DefaultPreloadManager$Builder$$ExternalSyntheticLambda1
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return DefaultPreloadManager.Builder.lambda$setRenderersFactory$4(RenderersFactory.this);
                }
            };
            return this;
        }

        public Builder setTrackSelectorFactory(TrackSelector.Factory factory) {
            Assertions.checkState((this.buildCalled || this.buildExoPlayerCalled) ? false : true);
            this.trackSelectorFactory = factory;
            return this;
        }

        public Builder setLoadControl(final LoadControl loadControl) {
            Assertions.checkState((this.buildCalled || this.buildExoPlayerCalled) ? false : true);
            this.loadControlSupplier = new Supplier() { // from class: androidx.media3.exoplayer.source.preload.DefaultPreloadManager$Builder$$ExternalSyntheticLambda0
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return DefaultPreloadManager.Builder.lambda$setLoadControl$5(LoadControl.this);
                }
            };
            return this;
        }

        public Builder setBandwidthMeter(final BandwidthMeter bandwidthMeter) {
            Assertions.checkState((this.buildCalled || this.buildExoPlayerCalled) ? false : true);
            this.bandwidthMeterSupplier = new Supplier() { // from class: androidx.media3.exoplayer.source.preload.DefaultPreloadManager$Builder$$ExternalSyntheticLambda2
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return DefaultPreloadManager.Builder.lambda$setBandwidthMeter$6(BandwidthMeter.this);
                }
            };
            return this;
        }

        public Builder setPreloadLooper(Looper looper) {
            Assertions.checkState((this.buildCalled || this.buildExoPlayerCalled) ? false : true);
            this.preloadLooperProvider = new PlaybackLooperProvider(looper);
            return this;
        }

        public ExoPlayer buildExoPlayer() {
            return buildExoPlayer(new ExoPlayer.Builder(this.context));
        }

        public ExoPlayer buildExoPlayer(ExoPlayer.Builder builder) {
            this.buildExoPlayerCalled = true;
            return builder.setMediaSourceFactory(this.mediaSourceFactorySupplier.get()).setBandwidthMeter(this.bandwidthMeterSupplier.get()).setRenderersFactory(this.renderersFactorySupplier.get()).setLoadControl(this.loadControlSupplier.get()).setPlaybackLooperProvider(this.preloadLooperProvider).setTrackSelector(this.trackSelectorFactory.createTrackSelector(this.context)).build();
        }

        @Override // androidx.media3.exoplayer.source.preload.BasePreloadManager.BuilderBase
        public BasePreloadManager<Integer> build() {
            Assertions.checkState(!this.buildCalled);
            this.buildCalled = true;
            return new DefaultPreloadManager(this);
        }
    }

    /* loaded from: classes2.dex */
    public static class Status implements TargetPreloadStatusControl.PreloadStatus {
        public static final int STAGE_LOADED_FOR_DURATION_MS = 2;
        public static final int STAGE_SOURCE_PREPARED = 0;
        public static final int STAGE_TRACKS_SELECTED = 1;
        private final int stage;
        private final long value;

        @Target({ElementType.TYPE_USE})
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes2.dex */
        public @interface Stage {
        }

        public Status(int i, long j) {
            this.stage = i;
            this.value = j;
        }

        public Status(int i) {
            this(i, C.TIME_UNSET);
        }

        @Override // androidx.media3.exoplayer.source.preload.TargetPreloadStatusControl.PreloadStatus
        public int getStage() {
            return this.stage;
        }

        @Override // androidx.media3.exoplayer.source.preload.TargetPreloadStatusControl.PreloadStatus
        public long getValue() {
            return this.value;
        }
    }

    private DefaultPreloadManager(Builder builder) {
        super(new RankingDataComparator(), builder.targetPreloadStatusControl, builder.mediaSourceFactorySupplier.get());
        DefaultRendererCapabilitiesList createRendererCapabilitiesList = new DefaultRendererCapabilitiesList.Factory((RenderersFactory) builder.renderersFactorySupplier.get()).createRendererCapabilitiesList();
        this.rendererCapabilitiesList = createRendererCapabilitiesList;
        PlaybackLooperProvider playbackLooperProvider = builder.preloadLooperProvider;
        this.preloadLooperProvider = playbackLooperProvider;
        TrackSelector createTrackSelector = builder.trackSelectorFactory.createTrackSelector(builder.context);
        this.trackSelector = createTrackSelector;
        BandwidthMeter bandwidthMeter = (BandwidthMeter) builder.bandwidthMeterSupplier.get();
        createTrackSelector.init(new TrackSelector.InvalidationListener() { // from class: androidx.media3.exoplayer.source.preload.DefaultPreloadManager$$ExternalSyntheticLambda1
            @Override // androidx.media3.exoplayer.trackselection.TrackSelector.InvalidationListener
            public final void onTrackSelectionsInvalidated() {
                DefaultPreloadManager.lambda$new$0();
            }
        }, bandwidthMeter);
        Looper obtainLooper = playbackLooperProvider.obtainLooper();
        this.preloadMediaSourceFactory = new PreloadMediaSource.Factory(builder.mediaSourceFactorySupplier.get(), new SourcePreloadControl(), createTrackSelector, bandwidthMeter, createRendererCapabilitiesList.getRendererCapabilities(), ((LoadControl) builder.loadControlSupplier.get()).getAllocator(), obtainLooper);
        this.preloadHandler = Util.createHandler(obtainLooper, null);
        this.deprecatedConstructorCalled = false;
    }

    @Deprecated
    public DefaultPreloadManager(TargetPreloadStatusControl<Integer> targetPreloadStatusControl, MediaSource.Factory factory, TrackSelector trackSelector, BandwidthMeter bandwidthMeter, RendererCapabilitiesList.Factory factory2, Allocator allocator, Looper looper) {
        super(new RankingDataComparator(), targetPreloadStatusControl, factory);
        RendererCapabilitiesList createRendererCapabilitiesList = factory2.createRendererCapabilitiesList();
        this.rendererCapabilitiesList = createRendererCapabilitiesList;
        PlaybackLooperProvider playbackLooperProvider = new PlaybackLooperProvider(looper);
        this.preloadLooperProvider = playbackLooperProvider;
        this.trackSelector = trackSelector;
        Looper obtainLooper = playbackLooperProvider.obtainLooper();
        this.preloadMediaSourceFactory = new PreloadMediaSource.Factory(factory, new SourcePreloadControl(), trackSelector, bandwidthMeter, createRendererCapabilitiesList.getRendererCapabilities(), allocator, obtainLooper);
        this.preloadHandler = Util.createHandler(obtainLooper, null);
        this.deprecatedConstructorCalled = true;
    }

    public void setCurrentPlayingIndex(int i) {
        ((RankingDataComparator) this.rankingDataComparator).currentPlayingIndex = i;
    }

    @Override // androidx.media3.exoplayer.source.preload.BasePreloadManager
    public MediaSource createMediaSourceForPreloading(MediaSource mediaSource) {
        return this.preloadMediaSourceFactory.createMediaSource(mediaSource);
    }

    @Override // androidx.media3.exoplayer.source.preload.BasePreloadManager
    protected void preloadSourceInternal(MediaSource mediaSource, long j) {
        Assertions.checkArgument(mediaSource instanceof PreloadMediaSource);
        ((PreloadMediaSource) mediaSource).preload(j);
    }

    @Override // androidx.media3.exoplayer.source.preload.BasePreloadManager
    protected void clearSourceInternal(MediaSource mediaSource) {
        Assertions.checkArgument(mediaSource instanceof PreloadMediaSource);
        ((PreloadMediaSource) mediaSource).clear();
    }

    @Override // androidx.media3.exoplayer.source.preload.BasePreloadManager
    protected void releaseSourceInternal(MediaSource mediaSource) {
        Assertions.checkArgument(mediaSource instanceof PreloadMediaSource);
        ((PreloadMediaSource) mediaSource).releasePreloadMediaSource();
    }

    @Override // androidx.media3.exoplayer.source.preload.BasePreloadManager
    protected void releaseInternal() {
        this.preloadHandler.post(new Runnable() { // from class: androidx.media3.exoplayer.source.preload.DefaultPreloadManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DefaultPreloadManager.this.m7425xafd85f69();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$releaseInternal$1$androidx-media3-exoplayer-source-preload-DefaultPreloadManager  reason: not valid java name */
    public /* synthetic */ void m7425xafd85f69() {
        this.rendererCapabilitiesList.release();
        if (!this.deprecatedConstructorCalled) {
            this.trackSelector.release();
        }
        this.preloadLooperProvider.releaseLooper();
    }

    /* loaded from: classes2.dex */
    private static final class RankingDataComparator implements Comparator<Integer> {
        public int currentPlayingIndex = -1;

        @Override // java.util.Comparator
        public int compare(Integer num, Integer num2) {
            return Integer.compare(Math.abs(num.intValue() - this.currentPlayingIndex), Math.abs(num2.intValue() - this.currentPlayingIndex));
        }
    }

    /* loaded from: classes2.dex */
    private final class SourcePreloadControl implements PreloadMediaSource.PreloadControl {
        private SourcePreloadControl() {
        }

        @Override // androidx.media3.exoplayer.source.preload.PreloadMediaSource.PreloadControl
        public boolean onSourcePrepared(PreloadMediaSource preloadMediaSource) {
            return continueOrCompletePreloading(preloadMediaSource, new Predicate() { // from class: androidx.media3.exoplayer.source.preload.DefaultPreloadManager$SourcePreloadControl$$ExternalSyntheticLambda1
                @Override // com.google.common.base.Predicate
                public final boolean apply(Object obj) {
                    return DefaultPreloadManager.SourcePreloadControl.lambda$onSourcePrepared$0((DefaultPreloadManager.Status) obj);
                }
            }, true);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ boolean lambda$onSourcePrepared$0(Status status) {
            return status.getStage() > 0;
        }

        @Override // androidx.media3.exoplayer.source.preload.PreloadMediaSource.PreloadControl
        public boolean onTracksSelected(PreloadMediaSource preloadMediaSource) {
            return continueOrCompletePreloading(preloadMediaSource, new Predicate() { // from class: androidx.media3.exoplayer.source.preload.DefaultPreloadManager$SourcePreloadControl$$ExternalSyntheticLambda0
                @Override // com.google.common.base.Predicate
                public final boolean apply(Object obj) {
                    return DefaultPreloadManager.SourcePreloadControl.lambda$onTracksSelected$1((DefaultPreloadManager.Status) obj);
                }
            }, false);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ boolean lambda$onTracksSelected$1(Status status) {
            return status.getStage() > 1;
        }

        @Override // androidx.media3.exoplayer.source.preload.PreloadMediaSource.PreloadControl
        public boolean onContinueLoadingRequested(PreloadMediaSource preloadMediaSource, final long j) {
            return continueOrCompletePreloading(preloadMediaSource, new Predicate() { // from class: androidx.media3.exoplayer.source.preload.DefaultPreloadManager$SourcePreloadControl$$ExternalSyntheticLambda2
                @Override // com.google.common.base.Predicate
                public final boolean apply(Object obj) {
                    return DefaultPreloadManager.SourcePreloadControl.lambda$onContinueLoadingRequested$2(j, (DefaultPreloadManager.Status) obj);
                }
            }, false);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ boolean lambda$onContinueLoadingRequested$2(long j, Status status) {
            return status.getStage() == 2 && status.getValue() > Util.usToMs(j);
        }

        @Override // androidx.media3.exoplayer.source.preload.PreloadMediaSource.PreloadControl
        public void onUsedByPlayer(PreloadMediaSource preloadMediaSource) {
            DefaultPreloadManager.this.onPreloadSkipped(preloadMediaSource);
        }

        @Override // androidx.media3.exoplayer.source.preload.PreloadMediaSource.PreloadControl
        public void onLoadedToTheEndOfSource(PreloadMediaSource preloadMediaSource) {
            DefaultPreloadManager.this.onPreloadCompleted(preloadMediaSource);
        }

        @Override // androidx.media3.exoplayer.source.preload.PreloadMediaSource.PreloadControl
        public void onPreloadError(PreloadException preloadException, PreloadMediaSource preloadMediaSource) {
            DefaultPreloadManager.this.onPreloadError(preloadException, preloadMediaSource);
        }

        private boolean continueOrCompletePreloading(PreloadMediaSource preloadMediaSource, Predicate<Status> predicate, boolean z) {
            TargetPreloadStatusControl.PreloadStatus targetPreloadStatus = DefaultPreloadManager.this.getTargetPreloadStatus(preloadMediaSource);
            if (targetPreloadStatus != null) {
                if (predicate.apply((Status) Assertions.checkNotNull((Status) targetPreloadStatus))) {
                    return true;
                }
                if (z) {
                    DefaultPreloadManager.this.clearSourceInternal(preloadMediaSource);
                }
                DefaultPreloadManager.this.onPreloadCompleted(preloadMediaSource);
                return false;
            }
            DefaultPreloadManager.this.onPreloadSkipped(preloadMediaSource);
            return false;
        }
    }
}
