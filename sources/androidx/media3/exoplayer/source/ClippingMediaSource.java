package androidx.media3.exoplayer.source;

import androidx.media3.common.C;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.upstream.Allocator;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class ClippingMediaSource extends WrappingMediaSource {
    private final boolean allowDynamicClippingUpdates;
    private final boolean allowUnseekableMedia;
    private IllegalClippingException clippingError;
    private ClippingTimeline clippingTimeline;
    private final boolean enableInitialDiscontinuity;
    private final long endUs;
    private final ArrayList<ClippingMediaPeriod> mediaPeriods;
    private long periodEndUs;
    private long periodStartUs;
    private final boolean relativeToDefaultPosition;
    private final long startUs;
    private final Timeline.Window window;

    /* loaded from: classes2.dex */
    public static final class Builder {
        private boolean allowDynamicClippingUpdates;
        private boolean allowUnseekableMedia;
        private boolean buildCalled;
        private boolean enableInitialDiscontinuity = true;
        private long endPositionUs = Long.MIN_VALUE;
        private final MediaSource mediaSource;
        private boolean relativeToDefaultPosition;
        private long startPositionUs;

        public Builder(MediaSource mediaSource) {
            this.mediaSource = (MediaSource) Assertions.checkNotNull(mediaSource);
        }

        public Builder setStartPositionMs(long j) {
            return setStartPositionUs(Util.msToUs(j));
        }

        public Builder setStartPositionUs(long j) {
            Assertions.checkArgument(j >= 0);
            Assertions.checkState(!this.buildCalled);
            this.startPositionUs = j;
            return this;
        }

        public Builder setEndPositionMs(long j) {
            return setEndPositionUs(Util.msToUs(j));
        }

        public Builder setEndPositionUs(long j) {
            Assertions.checkState(!this.buildCalled);
            this.endPositionUs = j;
            return this;
        }

        public Builder setEnableInitialDiscontinuity(boolean z) {
            Assertions.checkState(!this.buildCalled);
            this.enableInitialDiscontinuity = z;
            return this;
        }

        public Builder setAllowDynamicClippingUpdates(boolean z) {
            Assertions.checkState(!this.buildCalled);
            this.allowDynamicClippingUpdates = z;
            return this;
        }

        public Builder setRelativeToDefaultPosition(boolean z) {
            Assertions.checkState(!this.buildCalled);
            this.relativeToDefaultPosition = z;
            return this;
        }

        public Builder setAllowUnseekableMedia(boolean z) {
            Assertions.checkState(!this.buildCalled);
            this.allowUnseekableMedia = z;
            return this;
        }

        public ClippingMediaSource build() {
            this.buildCalled = true;
            return new ClippingMediaSource(this);
        }
    }

    /* loaded from: classes2.dex */
    public static final class IllegalClippingException extends IOException {
        public static final int REASON_INVALID_PERIOD_COUNT = 0;
        public static final int REASON_NOT_SEEKABLE_TO_START = 1;
        public static final int REASON_START_EXCEEDS_END = 2;
        public final int reason;

        @Target({ElementType.TYPE_USE})
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes2.dex */
        public @interface Reason {
        }

        public IllegalClippingException(int i) {
            this(i, C.TIME_UNSET, C.TIME_UNSET);
        }

        public IllegalClippingException(int i, long j, long j2) {
            super("Illegal clipping: " + getReasonDescription(i, j, j2));
            this.reason = i;
        }

        private static String getReasonDescription(int i, long j, long j2) {
            if (i != 0) {
                boolean z = true;
                if (i != 1) {
                    if (i == 2) {
                        Assertions.checkState((j == C.TIME_UNSET || j2 == C.TIME_UNSET) ? false : false);
                        return "start exceeds end. Start time: " + j + ", End time: " + j2;
                    }
                    return "unknown";
                }
                return "not seekable to start";
            }
            return "invalid period count";
        }
    }

    @Deprecated
    public ClippingMediaSource(MediaSource mediaSource, long j, long j2) {
        this(new Builder(mediaSource).setStartPositionUs(j).setEndPositionUs(j2));
    }

    @Deprecated
    public ClippingMediaSource(MediaSource mediaSource, long j) {
        this(new Builder(mediaSource).setEndPositionUs(j).setRelativeToDefaultPosition(true));
    }

    @Deprecated
    public ClippingMediaSource(MediaSource mediaSource, long j, long j2, boolean z, boolean z2, boolean z3) {
        this(new Builder(mediaSource).setStartPositionUs(j).setEndPositionUs(j2).setEnableInitialDiscontinuity(z).setAllowDynamicClippingUpdates(z2).setRelativeToDefaultPosition(z3));
    }

    private ClippingMediaSource(Builder builder) {
        super(builder.mediaSource);
        this.startUs = builder.startPositionUs;
        this.endUs = builder.endPositionUs;
        this.enableInitialDiscontinuity = builder.enableInitialDiscontinuity;
        this.allowDynamicClippingUpdates = builder.allowDynamicClippingUpdates;
        this.relativeToDefaultPosition = builder.relativeToDefaultPosition;
        this.allowUnseekableMedia = builder.allowUnseekableMedia;
        this.mediaPeriods = new ArrayList<>();
        this.window = new Timeline.Window();
    }

    @Override // androidx.media3.exoplayer.source.WrappingMediaSource, androidx.media3.exoplayer.source.MediaSource
    public boolean canUpdateMediaItem(MediaItem mediaItem) {
        return getMediaItem().clippingConfiguration.equals(mediaItem.clippingConfiguration) && this.mediaSource.canUpdateMediaItem(mediaItem);
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource, androidx.media3.exoplayer.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        IllegalClippingException illegalClippingException = this.clippingError;
        if (illegalClippingException != null) {
            throw illegalClippingException;
        }
        super.maybeThrowSourceInfoRefreshError();
    }

    @Override // androidx.media3.exoplayer.source.WrappingMediaSource, androidx.media3.exoplayer.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j) {
        ClippingMediaPeriod clippingMediaPeriod = new ClippingMediaPeriod(this.mediaSource.createPeriod(mediaPeriodId, allocator, j), this.enableInitialDiscontinuity, this.periodStartUs, this.periodEndUs);
        this.mediaPeriods.add(clippingMediaPeriod);
        return clippingMediaPeriod;
    }

    @Override // androidx.media3.exoplayer.source.WrappingMediaSource, androidx.media3.exoplayer.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        Assertions.checkState(this.mediaPeriods.remove(mediaPeriod));
        this.mediaSource.releasePeriod(((ClippingMediaPeriod) mediaPeriod).mediaPeriod);
        if (!this.mediaPeriods.isEmpty() || this.allowDynamicClippingUpdates) {
            return;
        }
        refreshClippedTimeline(((ClippingTimeline) Assertions.checkNotNull(this.clippingTimeline)).timeline);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.source.CompositeMediaSource, androidx.media3.exoplayer.source.BaseMediaSource
    public void releaseSourceInternal() {
        super.releaseSourceInternal();
        this.clippingError = null;
        this.clippingTimeline = null;
    }

    @Override // androidx.media3.exoplayer.source.WrappingMediaSource
    protected void onChildSourceInfoRefreshed(Timeline timeline) {
        if (this.clippingError != null) {
            return;
        }
        refreshClippedTimeline(timeline);
    }

    private void refreshClippedTimeline(Timeline timeline) {
        long j;
        timeline.getWindow(0, this.window);
        long positionInFirstPeriodUs = this.window.getPositionInFirstPeriodUs();
        if (this.clippingTimeline == null || this.mediaPeriods.isEmpty() || this.allowDynamicClippingUpdates) {
            j = this.startUs;
            long j2 = this.endUs;
            if (this.relativeToDefaultPosition) {
                long defaultPositionUs = this.window.getDefaultPositionUs();
                j += defaultPositionUs;
                j2 += defaultPositionUs;
            }
            this.periodStartUs = positionInFirstPeriodUs + j;
            this.periodEndUs = this.endUs != Long.MIN_VALUE ? positionInFirstPeriodUs + j2 : Long.MIN_VALUE;
            int size = this.mediaPeriods.size();
            for (int i = 0; i < size; i++) {
                this.mediaPeriods.get(i).updateClipping(this.periodStartUs, this.periodEndUs);
            }
            r6 = j2;
        } else {
            j = this.periodStartUs - positionInFirstPeriodUs;
            if (this.endUs != Long.MIN_VALUE) {
                r6 = this.periodEndUs - positionInFirstPeriodUs;
            }
        }
        try {
            ClippingTimeline clippingTimeline = new ClippingTimeline(timeline, j, r6, this.allowUnseekableMedia);
            this.clippingTimeline = clippingTimeline;
            refreshSourceInfo(clippingTimeline);
        } catch (IllegalClippingException e) {
            this.clippingError = e;
            for (int i2 = 0; i2 < this.mediaPeriods.size(); i2++) {
                this.mediaPeriods.get(i2).setClippingError(this.clippingError);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class ClippingTimeline extends ForwardingTimeline {
        private final long durationUs;
        private final long endUs;
        private final boolean isDynamic;
        private final long startUs;

        public ClippingTimeline(Timeline timeline, long j, long j2, boolean z) throws IllegalClippingException {
            super(timeline);
            int i = (j2 > Long.MIN_VALUE ? 1 : (j2 == Long.MIN_VALUE ? 0 : -1));
            if (i != 0 && j2 < j) {
                throw new IllegalClippingException(2, j, j2);
            }
            boolean z2 = false;
            if (timeline.getPeriodCount() != 1) {
                throw new IllegalClippingException(0);
            }
            Timeline.Window window = timeline.getWindow(0, new Timeline.Window());
            long max = Math.max(0L, j);
            if (!z && !window.isPlaceholder && max != 0 && !window.isSeekable) {
                throw new IllegalClippingException(1);
            }
            long max2 = i == 0 ? window.durationUs : Math.max(0L, j2);
            if (window.durationUs != C.TIME_UNSET) {
                max2 = max2 > window.durationUs ? window.durationUs : max2;
                if (max > max2) {
                    max = max2;
                }
            }
            this.startUs = max;
            this.endUs = max2;
            int i2 = (max2 > C.TIME_UNSET ? 1 : (max2 == C.TIME_UNSET ? 0 : -1));
            this.durationUs = i2 == 0 ? -9223372036854775807L : max2 - max;
            if (window.isDynamic && (i2 == 0 || (window.durationUs != C.TIME_UNSET && max2 == window.durationUs))) {
                z2 = true;
            }
            this.isDynamic = z2;
        }

        @Override // androidx.media3.exoplayer.source.ForwardingTimeline, androidx.media3.common.Timeline
        public Timeline.Window getWindow(int i, Timeline.Window window, long j) {
            this.timeline.getWindow(0, window, 0L);
            window.positionInFirstPeriodUs += this.startUs;
            window.durationUs = this.durationUs;
            window.isDynamic = this.isDynamic;
            if (window.defaultPositionUs != C.TIME_UNSET) {
                window.defaultPositionUs = Math.max(window.defaultPositionUs, this.startUs);
                int i2 = (this.endUs > C.TIME_UNSET ? 1 : (this.endUs == C.TIME_UNSET ? 0 : -1));
                long j2 = window.defaultPositionUs;
                if (i2 != 0) {
                    j2 = Math.min(j2, this.endUs);
                }
                window.defaultPositionUs = j2;
                window.defaultPositionUs -= this.startUs;
            }
            long usToMs = Util.usToMs(this.startUs);
            if (window.presentationStartTimeMs != C.TIME_UNSET) {
                window.presentationStartTimeMs += usToMs;
            }
            if (window.windowStartTimeMs != C.TIME_UNSET) {
                window.windowStartTimeMs += usToMs;
            }
            return window;
        }

        @Override // androidx.media3.exoplayer.source.ForwardingTimeline, androidx.media3.common.Timeline
        public Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
            this.timeline.getPeriod(0, period, z);
            long positionInWindowUs = period.getPositionInWindowUs() - this.startUs;
            long j = this.durationUs;
            long j2 = C.TIME_UNSET;
            if (j != C.TIME_UNSET) {
                j2 = j - positionInWindowUs;
            }
            return period.set(period.id, period.uid, 0, j2, positionInWindowUs);
        }
    }
}
