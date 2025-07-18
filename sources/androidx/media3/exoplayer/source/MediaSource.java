package androidx.media3.exoplayer.source;

import android.os.Handler;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.DrmSessionManagerProvider;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.extractor.text.SubtitleParser;
import java.io.IOException;
/* loaded from: classes2.dex */
public interface MediaSource {

    /* loaded from: classes2.dex */
    public interface Factory {
        public static final Factory UNSUPPORTED = MediaSourceFactory.UNSUPPORTED;

        MediaSource createMediaSource(MediaItem mediaItem);

        @Deprecated
        default Factory experimentalParseSubtitlesDuringExtraction(boolean z) {
            return this;
        }

        default Factory experimentalSetCodecsToParseWithinGopSampleDependencies(int i) {
            return this;
        }

        int[] getSupportedTypes();

        default Factory setCmcdConfigurationFactory(CmcdConfiguration.Factory factory) {
            return this;
        }

        Factory setDrmSessionManagerProvider(DrmSessionManagerProvider drmSessionManagerProvider);

        Factory setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy);

        default Factory setSubtitleParserFactory(SubtitleParser.Factory factory) {
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public interface MediaSourceCaller {
        void onSourceInfoRefreshed(MediaSource mediaSource, Timeline timeline);
    }

    void addDrmEventListener(Handler handler, DrmSessionEventListener drmSessionEventListener);

    void addEventListener(Handler handler, MediaSourceEventListener mediaSourceEventListener);

    default boolean canUpdateMediaItem(MediaItem mediaItem) {
        return false;
    }

    MediaPeriod createPeriod(MediaPeriodId mediaPeriodId, Allocator allocator, long j);

    void disable(MediaSourceCaller mediaSourceCaller);

    void enable(MediaSourceCaller mediaSourceCaller);

    default Timeline getInitialTimeline() {
        return null;
    }

    MediaItem getMediaItem();

    default boolean isSingleWindow() {
        return true;
    }

    void maybeThrowSourceInfoRefreshError() throws IOException;

    void prepareSource(MediaSourceCaller mediaSourceCaller, TransferListener transferListener, PlayerId playerId);

    void releasePeriod(MediaPeriod mediaPeriod);

    void releaseSource(MediaSourceCaller mediaSourceCaller);

    void removeDrmEventListener(DrmSessionEventListener drmSessionEventListener);

    void removeEventListener(MediaSourceEventListener mediaSourceEventListener);

    default void updateMediaItem(MediaItem mediaItem) {
    }

    /* loaded from: classes2.dex */
    public static final class MediaPeriodId {
        public final int adGroupIndex;
        public final int adIndexInAdGroup;
        public final int nextAdGroupIndex;
        public final Object periodUid;
        public final long windowSequenceNumber;

        public MediaPeriodId(Object obj) {
            this(obj, -1L);
        }

        public MediaPeriodId(Object obj, long j) {
            this(obj, -1, -1, j, -1);
        }

        public MediaPeriodId(Object obj, long j, int i) {
            this(obj, -1, -1, j, i);
        }

        public MediaPeriodId(Object obj, int i, int i2, long j) {
            this(obj, i, i2, j, -1);
        }

        private MediaPeriodId(Object obj, int i, int i2, long j, int i3) {
            this.periodUid = obj;
            this.adGroupIndex = i;
            this.adIndexInAdGroup = i2;
            this.windowSequenceNumber = j;
            this.nextAdGroupIndex = i3;
        }

        public MediaPeriodId copyWithPeriodUid(Object obj) {
            return this.periodUid.equals(obj) ? this : new MediaPeriodId(obj, this.adGroupIndex, this.adIndexInAdGroup, this.windowSequenceNumber, this.nextAdGroupIndex);
        }

        public MediaPeriodId copyWithWindowSequenceNumber(long j) {
            return this.windowSequenceNumber == j ? this : new MediaPeriodId(this.periodUid, this.adGroupIndex, this.adIndexInAdGroup, j, this.nextAdGroupIndex);
        }

        public boolean isAd() {
            return this.adGroupIndex != -1;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MediaPeriodId) {
                MediaPeriodId mediaPeriodId = (MediaPeriodId) obj;
                return this.periodUid.equals(mediaPeriodId.periodUid) && this.adGroupIndex == mediaPeriodId.adGroupIndex && this.adIndexInAdGroup == mediaPeriodId.adIndexInAdGroup && this.windowSequenceNumber == mediaPeriodId.windowSequenceNumber && this.nextAdGroupIndex == mediaPeriodId.nextAdGroupIndex;
            }
            return false;
        }

        public int hashCode() {
            return ((((((((527 + this.periodUid.hashCode()) * 31) + this.adGroupIndex) * 31) + this.adIndexInAdGroup) * 31) + ((int) this.windowSequenceNumber)) * 31) + this.nextAdGroupIndex;
        }
    }

    @Deprecated
    default void prepareSource(MediaSourceCaller mediaSourceCaller, TransferListener transferListener) {
        prepareSource(mediaSourceCaller, transferListener, PlayerId.UNSET);
    }
}
