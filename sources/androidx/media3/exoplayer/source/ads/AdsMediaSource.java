package androidx.media3.exoplayer.source.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.AdViewProvider;
import androidx.media3.common.C;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.source.CompositeMediaSource;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MaskingMediaPeriod;
import androidx.media3.exoplayer.source.MaskingMediaSource;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.ads.AdsLoader;
import androidx.media3.exoplayer.source.ads.AdsMediaSource;
import androidx.media3.exoplayer.upstream.Allocator;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
/* loaded from: classes2.dex */
public final class AdsMediaSource extends CompositeMediaSource<MediaSource.MediaPeriodId> {
    private static final MediaSource.MediaPeriodId CHILD_SOURCE_MEDIA_PERIOD_ID = new MediaSource.MediaPeriodId(new Object());
    private final MediaSource.Factory adMediaSourceFactory;
    private AdMediaSourceHolder[][] adMediaSourceHolders;
    private AdPlaybackState adPlaybackState;
    private final DataSpec adTagDataSpec;
    private final AdViewProvider adViewProvider;
    private final Object adsId;
    private final AdsLoader adsLoader;
    private ComponentListener componentListener;
    final MediaItem.DrmConfiguration contentDrmConfiguration;
    private final MaskingMediaSource contentMediaSource;
    private Timeline contentTimeline;
    private final Handler mainHandler;
    private final Timeline.Period period;

    /* loaded from: classes2.dex */
    public static final class AdLoadException extends IOException {
        public static final int TYPE_AD = 0;
        public static final int TYPE_AD_GROUP = 1;
        public static final int TYPE_ALL_ADS = 2;
        public static final int TYPE_UNEXPECTED = 3;
        public final int type;

        @Target({ElementType.TYPE_USE})
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes2.dex */
        public @interface Type {
        }

        public static AdLoadException createForAd(Exception exc) {
            return new AdLoadException(0, exc);
        }

        public static AdLoadException createForAdGroup(Exception exc, int i) {
            return new AdLoadException(1, new IOException("Failed to load ad group " + i, exc));
        }

        public static AdLoadException createForAllAds(Exception exc) {
            return new AdLoadException(2, exc);
        }

        public static AdLoadException createForUnexpected(RuntimeException runtimeException) {
            return new AdLoadException(3, runtimeException);
        }

        private AdLoadException(int i, Exception exc) {
            super(exc);
            this.type = i;
        }

        public RuntimeException getRuntimeExceptionForUnexpected() {
            Assertions.checkState(this.type == 3);
            return (RuntimeException) Assertions.checkNotNull(getCause());
        }
    }

    public AdsMediaSource(MediaSource mediaSource, DataSpec dataSpec, Object obj, MediaSource.Factory factory, AdsLoader adsLoader, AdViewProvider adViewProvider) {
        this(mediaSource, dataSpec, obj, factory, adsLoader, adViewProvider, true);
    }

    public AdsMediaSource(MediaSource mediaSource, DataSpec dataSpec, Object obj, MediaSource.Factory factory, AdsLoader adsLoader, AdViewProvider adViewProvider, boolean z) {
        this.contentMediaSource = new MaskingMediaSource(mediaSource, z);
        this.contentDrmConfiguration = ((MediaItem.LocalConfiguration) Assertions.checkNotNull(mediaSource.getMediaItem().localConfiguration)).drmConfiguration;
        this.adMediaSourceFactory = factory;
        this.adsLoader = adsLoader;
        this.adViewProvider = adViewProvider;
        this.adTagDataSpec = dataSpec;
        this.adsId = obj;
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.period = new Timeline.Period();
        this.adMediaSourceHolders = new AdMediaSourceHolder[0];
        adsLoader.setSupportedContentTypes(factory.getSupportedTypes());
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public MediaItem getMediaItem() {
        return this.contentMediaSource.getMediaItem();
    }

    public Object getAdsId() {
        return this.adsId;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public boolean canUpdateMediaItem(MediaItem mediaItem) {
        return Objects.equals(getAdsConfiguration(getMediaItem()), getAdsConfiguration(mediaItem)) && this.contentMediaSource.canUpdateMediaItem(mediaItem);
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public void updateMediaItem(MediaItem mediaItem) {
        this.contentMediaSource.updateMediaItem(mediaItem);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.source.CompositeMediaSource, androidx.media3.exoplayer.source.BaseMediaSource
    public void prepareSourceInternal(TransferListener transferListener) {
        super.prepareSourceInternal(transferListener);
        final ComponentListener componentListener = new ComponentListener();
        this.componentListener = componentListener;
        this.contentTimeline = this.contentMediaSource.getTimeline();
        prepareChildSource(CHILD_SOURCE_MEDIA_PERIOD_ID, this.contentMediaSource);
        this.mainHandler.post(new Runnable() { // from class: androidx.media3.exoplayer.source.ads.AdsMediaSource$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AdsMediaSource.this.m7416x9f9466de(componentListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$prepareSourceInternal$0$androidx-media3-exoplayer-source-ads-AdsMediaSource  reason: not valid java name */
    public /* synthetic */ void m7416x9f9466de(ComponentListener componentListener) {
        this.adsLoader.start(this, this.adTagDataSpec, this.adsId, this.adViewProvider, componentListener);
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j) {
        if (((AdPlaybackState) Assertions.checkNotNull(this.adPlaybackState)).adGroupCount > 0 && mediaPeriodId.isAd()) {
            int i = mediaPeriodId.adGroupIndex;
            int i2 = mediaPeriodId.adIndexInAdGroup;
            AdMediaSourceHolder[][] adMediaSourceHolderArr = this.adMediaSourceHolders;
            AdMediaSourceHolder[] adMediaSourceHolderArr2 = adMediaSourceHolderArr[i];
            if (adMediaSourceHolderArr2.length <= i2) {
                adMediaSourceHolderArr[i] = (AdMediaSourceHolder[]) Arrays.copyOf(adMediaSourceHolderArr2, i2 + 1);
            }
            AdMediaSourceHolder adMediaSourceHolder = this.adMediaSourceHolders[i][i2];
            if (adMediaSourceHolder == null) {
                adMediaSourceHolder = new AdMediaSourceHolder(mediaPeriodId);
                this.adMediaSourceHolders[i][i2] = adMediaSourceHolder;
                maybeUpdateAdMediaSources();
            }
            return adMediaSourceHolder.createMediaPeriod(mediaPeriodId, allocator, j);
        }
        MaskingMediaPeriod maskingMediaPeriod = new MaskingMediaPeriod(mediaPeriodId, allocator, j);
        maskingMediaPeriod.setMediaSource(this.contentMediaSource);
        maskingMediaPeriod.createPeriod(mediaPeriodId);
        return maskingMediaPeriod;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        MaskingMediaPeriod maskingMediaPeriod = (MaskingMediaPeriod) mediaPeriod;
        MediaSource.MediaPeriodId mediaPeriodId = maskingMediaPeriod.id;
        if (mediaPeriodId.isAd()) {
            AdMediaSourceHolder adMediaSourceHolder = (AdMediaSourceHolder) Assertions.checkNotNull(this.adMediaSourceHolders[mediaPeriodId.adGroupIndex][mediaPeriodId.adIndexInAdGroup]);
            adMediaSourceHolder.releaseMediaPeriod(maskingMediaPeriod);
            if (adMediaSourceHolder.isInactive()) {
                adMediaSourceHolder.release();
                this.adMediaSourceHolders[mediaPeriodId.adGroupIndex][mediaPeriodId.adIndexInAdGroup] = null;
                return;
            }
            return;
        }
        maskingMediaPeriod.releasePeriod();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.source.CompositeMediaSource, androidx.media3.exoplayer.source.BaseMediaSource
    public void releaseSourceInternal() {
        super.releaseSourceInternal();
        final ComponentListener componentListener = (ComponentListener) Assertions.checkNotNull(this.componentListener);
        this.componentListener = null;
        componentListener.stop();
        this.contentTimeline = null;
        this.adPlaybackState = null;
        this.adMediaSourceHolders = new AdMediaSourceHolder[0];
        this.mainHandler.post(new Runnable() { // from class: androidx.media3.exoplayer.source.ads.AdsMediaSource$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                AdsMediaSource.this.m7417x4d6cb35f(componentListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$releaseSourceInternal$1$androidx-media3-exoplayer-source-ads-AdsMediaSource  reason: not valid java name */
    public /* synthetic */ void m7417x4d6cb35f(ComponentListener componentListener) {
        this.adsLoader.stop(this, componentListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.source.CompositeMediaSource
    public void onChildSourceInfoRefreshed(MediaSource.MediaPeriodId mediaPeriodId, MediaSource mediaSource, final Timeline timeline) {
        if (mediaPeriodId.isAd()) {
            ((AdMediaSourceHolder) Assertions.checkNotNull(this.adMediaSourceHolders[mediaPeriodId.adGroupIndex][mediaPeriodId.adIndexInAdGroup])).handleSourceInfoRefresh(timeline);
        } else {
            Assertions.checkArgument(timeline.getPeriodCount() == 1);
            this.contentTimeline = timeline;
            this.mainHandler.post(new Runnable() { // from class: androidx.media3.exoplayer.source.ads.AdsMediaSource$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    AdsMediaSource.this.m7415xbe1bc96f(timeline);
                }
            });
        }
        maybeUpdateSourceInfo();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onChildSourceInfoRefreshed$2$androidx-media3-exoplayer-source-ads-AdsMediaSource  reason: not valid java name */
    public /* synthetic */ void m7415xbe1bc96f(Timeline timeline) {
        this.adsLoader.handleContentTimelineChanged(this, timeline);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.source.CompositeMediaSource
    public MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(MediaSource.MediaPeriodId mediaPeriodId, MediaSource.MediaPeriodId mediaPeriodId2) {
        return mediaPeriodId.isAd() ? mediaPeriodId : mediaPeriodId2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdPlaybackState(AdPlaybackState adPlaybackState) {
        AdPlaybackState adPlaybackState2 = this.adPlaybackState;
        if (adPlaybackState2 == null) {
            AdMediaSourceHolder[][] adMediaSourceHolderArr = new AdMediaSourceHolder[adPlaybackState.adGroupCount - (adPlaybackState.endsWithLivePostrollPlaceHolder() ? 1 : 0)];
            this.adMediaSourceHolders = adMediaSourceHolderArr;
            Arrays.fill(adMediaSourceHolderArr, new AdMediaSourceHolder[0]);
        } else {
            int checkValidAdPlaybackStateUpdate = checkValidAdPlaybackStateUpdate(adPlaybackState2, adPlaybackState);
            if (checkValidAdPlaybackStateUpdate > 0) {
                this.adMediaSourceHolders = growAdMediaSourceHolderGrid(this.adMediaSourceHolders, checkValidAdPlaybackStateUpdate);
            }
        }
        this.adPlaybackState = adPlaybackState;
        maybeUpdateAdMediaSources();
        maybeUpdateSourceInfo();
    }

    private static int checkValidAdPlaybackStateUpdate(AdPlaybackState adPlaybackState, AdPlaybackState adPlaybackState2) {
        Assertions.checkState(adPlaybackState.endsWithLivePostrollPlaceHolder() == adPlaybackState2.endsWithLivePostrollPlaceHolder());
        int i = adPlaybackState2.adGroupCount - adPlaybackState.adGroupCount;
        Assertions.checkState(i >= 0);
        int i2 = adPlaybackState2.removedAdGroupCount;
        while (i2 < adPlaybackState.adGroupCount) {
            AdPlaybackState.AdGroup adGroup = adPlaybackState.getAdGroup(i2);
            if (adGroup.isLivePostrollPlaceholder()) {
                Assertions.checkState(i2 == adPlaybackState.adGroupCount - 1);
                return i;
            }
            AdPlaybackState.AdGroup adGroup2 = adPlaybackState2.getAdGroup(i2);
            Assertions.checkState(adGroup.count <= adGroup2.count);
            Assertions.checkState(adGroup.timeUs == adGroup2.timeUs);
            for (int i3 = 0; i3 < adGroup.count; i3++) {
                if (adGroup.mediaItems[i3] != null) {
                    Assertions.checkState(adGroup.mediaItems[i3].equals(adGroup2.mediaItems[i3]));
                }
            }
            i2++;
        }
        return i;
    }

    private static AdMediaSourceHolder[][] growAdMediaSourceHolderGrid(AdMediaSourceHolder[][] adMediaSourceHolderArr, int i) {
        int length = adMediaSourceHolderArr.length + i;
        AdMediaSourceHolder[][] adMediaSourceHolderArr2 = new AdMediaSourceHolder[length];
        System.arraycopy(adMediaSourceHolderArr, 0, adMediaSourceHolderArr2, 0, adMediaSourceHolderArr.length);
        for (int length2 = adMediaSourceHolderArr.length; length2 < length; length2++) {
            adMediaSourceHolderArr2[length2] = new AdMediaSourceHolder[0];
        }
        return adMediaSourceHolderArr2;
    }

    private void maybeUpdateAdMediaSources() {
        MediaItem mediaItem;
        AdPlaybackState adPlaybackState = this.adPlaybackState;
        if (adPlaybackState == null) {
            return;
        }
        for (int i = 0; i < this.adMediaSourceHolders.length; i++) {
            int i2 = 0;
            while (true) {
                AdMediaSourceHolder[] adMediaSourceHolderArr = this.adMediaSourceHolders[i];
                if (i2 < adMediaSourceHolderArr.length) {
                    AdMediaSourceHolder adMediaSourceHolder = adMediaSourceHolderArr[i2];
                    AdPlaybackState.AdGroup adGroup = adPlaybackState.getAdGroup(i);
                    if (adMediaSourceHolder != null && !adMediaSourceHolder.hasMediaSource() && i2 < adGroup.mediaItems.length && (mediaItem = adGroup.mediaItems[i2]) != null) {
                        if (this.contentDrmConfiguration != null) {
                            mediaItem = mediaItem.buildUpon().setDrmConfiguration(this.contentDrmConfiguration).build();
                        }
                        adMediaSourceHolder.initializeWithMediaSource(this.adMediaSourceFactory.createMediaSource(mediaItem), mediaItem);
                    }
                    i2++;
                }
            }
        }
    }

    private void maybeUpdateSourceInfo() {
        Timeline timeline = this.contentTimeline;
        AdPlaybackState adPlaybackState = this.adPlaybackState;
        if (adPlaybackState == null || timeline == null) {
            return;
        }
        if (adPlaybackState.adGroupCount == 0) {
            refreshSourceInfo(timeline);
            return;
        }
        this.adPlaybackState = this.adPlaybackState.withAdDurationsUs(getAdDurationsUs());
        refreshSourceInfo(new SinglePeriodAdTimeline(timeline, this.adPlaybackState));
    }

    @RequiresNonNull({"adPlaybackState"})
    private long[][] getAdDurationsUs() {
        boolean endsWithLivePostrollPlaceHolder = ((AdPlaybackState) Assertions.checkNotNull(this.adPlaybackState)).endsWithLivePostrollPlaceHolder();
        int length = this.adMediaSourceHolders.length + (endsWithLivePostrollPlaceHolder ? 1 : 0);
        long[][] jArr = new long[length];
        int i = 0;
        while (true) {
            AdMediaSourceHolder[][] adMediaSourceHolderArr = this.adMediaSourceHolders;
            if (i >= adMediaSourceHolderArr.length) {
                break;
            }
            jArr[i] = new long[adMediaSourceHolderArr[i].length];
            int i2 = 0;
            while (true) {
                AdMediaSourceHolder[] adMediaSourceHolderArr2 = this.adMediaSourceHolders[i];
                if (i2 < adMediaSourceHolderArr2.length) {
                    AdMediaSourceHolder adMediaSourceHolder = adMediaSourceHolderArr2[i2];
                    jArr[i][i2] = adMediaSourceHolder == null ? C.TIME_UNSET : adMediaSourceHolder.getDurationUs();
                    i2++;
                }
            }
            i++;
        }
        if (endsWithLivePostrollPlaceHolder) {
            jArr[length - 1] = new long[0];
        }
        return jArr;
    }

    private static MediaItem.AdsConfiguration getAdsConfiguration(MediaItem mediaItem) {
        if (mediaItem.localConfiguration == null) {
            return null;
        }
        return mediaItem.localConfiguration.adsConfiguration;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class ComponentListener implements AdsLoader.EventListener {
        private final Handler playerHandler = Util.createHandlerForCurrentLooper();
        private volatile boolean stopped;

        public ComponentListener() {
        }

        public void stop() {
            this.stopped = true;
            this.playerHandler.removeCallbacksAndMessages(null);
        }

        @Override // androidx.media3.exoplayer.source.ads.AdsLoader.EventListener
        public void onAdPlaybackState(final AdPlaybackState adPlaybackState) {
            if (this.stopped) {
                return;
            }
            this.playerHandler.post(new Runnable() { // from class: androidx.media3.exoplayer.source.ads.AdsMediaSource$ComponentListener$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    AdsMediaSource.ComponentListener.this.m7420x6396e000(adPlaybackState);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onAdPlaybackState$0$androidx-media3-exoplayer-source-ads-AdsMediaSource$ComponentListener  reason: not valid java name */
        public /* synthetic */ void m7420x6396e000(AdPlaybackState adPlaybackState) {
            if (this.stopped) {
                return;
            }
            AdsMediaSource.this.onAdPlaybackState(adPlaybackState);
        }

        @Override // androidx.media3.exoplayer.source.ads.AdsLoader.EventListener
        public void onAdLoadError(AdLoadException adLoadException, DataSpec dataSpec) {
            if (this.stopped) {
                return;
            }
            AdsMediaSource.this.createEventDispatcher(null).loadError(new LoadEventInfo(LoadEventInfo.getNewId(), dataSpec, SystemClock.elapsedRealtime()), 6, (IOException) adLoadException, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class AdPrepareListener implements MaskingMediaPeriod.PrepareListener {
        private final MediaItem adMediaItem;

        public AdPrepareListener(MediaItem mediaItem) {
            this.adMediaItem = mediaItem;
        }

        @Override // androidx.media3.exoplayer.source.MaskingMediaPeriod.PrepareListener
        public void onPrepareComplete(final MediaSource.MediaPeriodId mediaPeriodId) {
            AdsMediaSource.this.mainHandler.post(new Runnable() { // from class: androidx.media3.exoplayer.source.ads.AdsMediaSource$AdPrepareListener$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    AdsMediaSource.AdPrepareListener.this.m7418x672fc1f4(mediaPeriodId);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onPrepareComplete$0$androidx-media3-exoplayer-source-ads-AdsMediaSource$AdPrepareListener  reason: not valid java name */
        public /* synthetic */ void m7418x672fc1f4(MediaSource.MediaPeriodId mediaPeriodId) {
            AdsMediaSource.this.adsLoader.handlePrepareComplete(AdsMediaSource.this, mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup);
        }

        @Override // androidx.media3.exoplayer.source.MaskingMediaPeriod.PrepareListener
        public void onPrepareError(final MediaSource.MediaPeriodId mediaPeriodId, final IOException iOException) {
            AdsMediaSource.this.createEventDispatcher(mediaPeriodId).loadError(new LoadEventInfo(LoadEventInfo.getNewId(), new DataSpec(((MediaItem.LocalConfiguration) Assertions.checkNotNull(this.adMediaItem.localConfiguration)).uri), SystemClock.elapsedRealtime()), 6, (IOException) AdLoadException.createForAd(iOException), true);
            AdsMediaSource.this.mainHandler.post(new Runnable() { // from class: androidx.media3.exoplayer.source.ads.AdsMediaSource$AdPrepareListener$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    AdsMediaSource.AdPrepareListener.this.m7419xa9898f8e(mediaPeriodId, iOException);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onPrepareError$1$androidx-media3-exoplayer-source-ads-AdsMediaSource$AdPrepareListener  reason: not valid java name */
        public /* synthetic */ void m7419xa9898f8e(MediaSource.MediaPeriodId mediaPeriodId, IOException iOException) {
            AdsMediaSource.this.adsLoader.handlePrepareError(AdsMediaSource.this, mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup, iOException);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class AdMediaSourceHolder {
        private final List<MaskingMediaPeriod> activeMediaPeriods = new ArrayList();
        private MediaItem adMediaItem;
        private MediaSource adMediaSource;
        private final MediaSource.MediaPeriodId id;
        private Timeline timeline;

        public AdMediaSourceHolder(MediaSource.MediaPeriodId mediaPeriodId) {
            this.id = mediaPeriodId;
        }

        public void initializeWithMediaSource(MediaSource mediaSource, MediaItem mediaItem) {
            this.adMediaSource = mediaSource;
            this.adMediaItem = mediaItem;
            for (int i = 0; i < this.activeMediaPeriods.size(); i++) {
                MaskingMediaPeriod maskingMediaPeriod = this.activeMediaPeriods.get(i);
                maskingMediaPeriod.setMediaSource(mediaSource);
                maskingMediaPeriod.setPrepareListener(new AdPrepareListener(mediaItem));
            }
            AdsMediaSource.this.prepareChildSource(this.id, mediaSource);
        }

        public MediaPeriod createMediaPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j) {
            MaskingMediaPeriod maskingMediaPeriod = new MaskingMediaPeriod(mediaPeriodId, allocator, j);
            this.activeMediaPeriods.add(maskingMediaPeriod);
            MediaSource mediaSource = this.adMediaSource;
            if (mediaSource != null) {
                maskingMediaPeriod.setMediaSource(mediaSource);
                maskingMediaPeriod.setPrepareListener(new AdPrepareListener((MediaItem) Assertions.checkNotNull(this.adMediaItem)));
            }
            Timeline timeline = this.timeline;
            if (timeline != null) {
                maskingMediaPeriod.createPeriod(new MediaSource.MediaPeriodId(timeline.getUidOfPeriod(0), mediaPeriodId.windowSequenceNumber));
            }
            return maskingMediaPeriod;
        }

        public void handleSourceInfoRefresh(Timeline timeline) {
            Assertions.checkArgument(timeline.getPeriodCount() == 1);
            if (this.timeline == null) {
                Object uidOfPeriod = timeline.getUidOfPeriod(0);
                for (int i = 0; i < this.activeMediaPeriods.size(); i++) {
                    MaskingMediaPeriod maskingMediaPeriod = this.activeMediaPeriods.get(i);
                    maskingMediaPeriod.createPeriod(new MediaSource.MediaPeriodId(uidOfPeriod, maskingMediaPeriod.id.windowSequenceNumber));
                }
            }
            this.timeline = timeline;
        }

        public long getDurationUs() {
            Timeline timeline = this.timeline;
            return timeline == null ? C.TIME_UNSET : timeline.getPeriod(0, AdsMediaSource.this.period).getDurationUs();
        }

        public void releaseMediaPeriod(MaskingMediaPeriod maskingMediaPeriod) {
            this.activeMediaPeriods.remove(maskingMediaPeriod);
            maskingMediaPeriod.releasePeriod();
        }

        public void release() {
            if (hasMediaSource()) {
                AdsMediaSource.this.releaseChildSource(this.id);
            }
        }

        public boolean hasMediaSource() {
            return this.adMediaSource != null;
        }

        public boolean isInactive() {
            return this.activeMediaPeriods.isEmpty();
        }
    }
}
