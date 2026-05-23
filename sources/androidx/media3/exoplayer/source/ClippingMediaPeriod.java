package androidx.media3.exoplayer.source;

import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.StreamKey;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.source.ClippingMediaSource;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.util.List;
/* loaded from: classes3.dex */
public final class ClippingMediaPeriod implements MediaPeriod, MediaPeriod.Callback {
    private MediaPeriod.Callback callback;
    private ClippingMediaSource.IllegalClippingException clippingError;
    private final boolean enableClippingInMediaPeriod;
    long endUs;
    private boolean isPeriodClippingEndPosition;
    private long lastReportedDiscontinuityUs;
    public final MediaPeriod mediaPeriod;
    private long pendingInitialDiscontinuityPositionUs;
    private ClippingSampleStream[] sampleStreams;
    long startUs;

    public ClippingMediaPeriod(MediaPeriod mediaPeriod, boolean z, long j, long j2) {
        this(mediaPeriod, z, j, j2, false);
    }

    public ClippingMediaPeriod(MediaPeriod mediaPeriod, boolean z, long j, long j2, boolean z2) {
        this.mediaPeriod = mediaPeriod;
        this.sampleStreams = new ClippingSampleStream[0];
        this.pendingInitialDiscontinuityPositionUs = z ? j : -9223372036854775807L;
        this.lastReportedDiscontinuityUs = C.TIME_UNSET;
        this.enableClippingInMediaPeriod = z2;
        updateClipping(j, j2);
    }

    public void updateClipping(long j, long j2) {
        this.startUs = j;
        this.endUs = j2;
        if (this.enableClippingInMediaPeriod) {
            long endPositionUs = this.mediaPeriod.setEndPositionUs(j2);
            Preconditions.checkState(endPositionUs == Long.MIN_VALUE || endPositionUs == j2, "Period updating end positions not supported, %s!=%s", endPositionUs, j2);
            this.isPeriodClippingEndPosition = endPositionUs == j2;
        }
    }

    public void setClippingError(ClippingMediaSource.IllegalClippingException illegalClippingException) {
        this.clippingError = illegalClippingException;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public void prepare(MediaPeriod.Callback callback, long j) {
        this.callback = callback;
        this.mediaPeriod.prepare(this, j);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public void maybeThrowPrepareError() throws IOException {
        ClippingMediaSource.IllegalClippingException illegalClippingException = this.clippingError;
        if (illegalClippingException != null) {
            throw illegalClippingException;
        }
        this.mediaPeriod.maybeThrowPrepareError();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public List<StreamKey> getStreamKeys(List<ExoTrackSelection> list) {
        return this.mediaPeriod.getStreamKeys(list);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public TrackGroupArray getTrackGroups() {
        return this.mediaPeriod.getTrackGroups();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public long selectTracks(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        this.sampleStreams = new ClippingSampleStream[sampleStreamArr.length];
        SampleStream[] sampleStreamArr2 = new SampleStream[sampleStreamArr.length];
        int i = 0;
        while (true) {
            SampleStream sampleStream = null;
            if (i >= sampleStreamArr.length) {
                break;
            }
            ClippingSampleStream[] clippingSampleStreamArr = this.sampleStreams;
            ClippingSampleStream clippingSampleStream = (ClippingSampleStream) sampleStreamArr[i];
            clippingSampleStreamArr[i] = clippingSampleStream;
            if (clippingSampleStream != null) {
                sampleStream = clippingSampleStream.childStream;
            }
            sampleStreamArr2[i] = sampleStream;
            i++;
        }
        long selectTracks = this.mediaPeriod.selectTracks(exoTrackSelectionArr, zArr, sampleStreamArr2, zArr2, j);
        long enforceClippingRange = enforceClippingRange(selectTracks, j, this.endUs);
        this.pendingInitialDiscontinuityPositionUs = (isPendingInitialDiscontinuity() && shouldKeepInitialDiscontinuity(selectTracks, j, exoTrackSelectionArr)) ? enforceClippingRange : C.TIME_UNSET;
        for (int i2 = 0; i2 < sampleStreamArr.length; i2++) {
            SampleStream sampleStream2 = sampleStreamArr2[i2];
            ClippingSampleStream[] clippingSampleStreamArr2 = this.sampleStreams;
            if (sampleStream2 == null) {
                clippingSampleStreamArr2[i2] = null;
            } else {
                ClippingSampleStream clippingSampleStream2 = clippingSampleStreamArr2[i2];
                if (clippingSampleStream2 == null || clippingSampleStream2.childStream != sampleStreamArr2[i2]) {
                    this.sampleStreams[i2] = new ClippingSampleStream(sampleStreamArr2[i2]);
                }
            }
            sampleStreamArr[i2] = this.sampleStreams[i2];
        }
        return enforceClippingRange;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public void discardBuffer(long j, boolean z) {
        this.mediaPeriod.discardBuffer(j, z);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public void reevaluateBuffer(long j) {
        this.mediaPeriod.reevaluateBuffer(j);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public long readDiscontinuity() {
        if (isPendingInitialDiscontinuity()) {
            long j = this.pendingInitialDiscontinuityPositionUs;
            this.pendingInitialDiscontinuityPositionUs = C.TIME_UNSET;
            this.lastReportedDiscontinuityUs = j;
            long readDiscontinuity = readDiscontinuity();
            return readDiscontinuity != C.TIME_UNSET ? readDiscontinuity : j;
        }
        long readDiscontinuity2 = this.mediaPeriod.readDiscontinuity();
        if (readDiscontinuity2 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        long enforceClippingRange = enforceClippingRange(readDiscontinuity2, this.startUs, this.endUs);
        if (enforceClippingRange == this.lastReportedDiscontinuityUs) {
            return C.TIME_UNSET;
        }
        this.lastReportedDiscontinuityUs = enforceClippingRange;
        return enforceClippingRange;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public long getBufferedPositionUs() {
        long bufferedPositionUs = this.mediaPeriod.getBufferedPositionUs();
        if (!this.isPeriodClippingEndPosition) {
            if (bufferedPositionUs != Long.MIN_VALUE) {
                long j = this.endUs;
                if (j == Long.MIN_VALUE || bufferedPositionUs < j) {
                }
            }
            return Long.MIN_VALUE;
        }
        long j2 = this.endUs;
        if (j2 != Long.MIN_VALUE && bufferedPositionUs != Long.MIN_VALUE) {
            return Math.min(j2, bufferedPositionUs);
        }
        return bufferedPositionUs;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public long seekToUs(long j) {
        ClippingSampleStream[] clippingSampleStreamArr;
        this.pendingInitialDiscontinuityPositionUs = C.TIME_UNSET;
        for (ClippingSampleStream clippingSampleStream : this.sampleStreams) {
            if (clippingSampleStream != null) {
                clippingSampleStream.clearSentEos();
            }
        }
        return enforceClippingRange(this.mediaPeriod.seekToUs(j), this.startUs, this.endUs);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
        long j2 = this.startUs;
        if (j == j2) {
            return j2;
        }
        return this.mediaPeriod.getAdjustedSeekPositionUs(j, clipSeekParameters(j, seekParameters));
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        long nextLoadPositionUs = this.mediaPeriod.getNextLoadPositionUs();
        if (!this.isPeriodClippingEndPosition) {
            if (nextLoadPositionUs != Long.MIN_VALUE) {
                long j = this.endUs;
                if (j == Long.MIN_VALUE || nextLoadPositionUs < j) {
                }
            }
            return Long.MIN_VALUE;
        }
        long j2 = this.endUs;
        if (j2 != Long.MIN_VALUE && nextLoadPositionUs != Long.MIN_VALUE) {
            return Math.min(j2, nextLoadPositionUs);
        }
        return nextLoadPositionUs;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public boolean continueLoading(LoadingInfo loadingInfo) {
        return this.mediaPeriod.continueLoading(loadingInfo);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public boolean isLoading() {
        return this.mediaPeriod.isLoading();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod.Callback
    public void onPrepared(MediaPeriod mediaPeriod) {
        if (this.clippingError != null) {
            return;
        }
        ((MediaPeriod.Callback) Preconditions.checkNotNull(this.callback)).onPrepared(this);
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader.Callback
    public void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
        ((MediaPeriod.Callback) Preconditions.checkNotNull(this.callback)).onContinueLoadingRequested(this);
    }

    boolean isPendingInitialDiscontinuity() {
        return this.pendingInitialDiscontinuityPositionUs != C.TIME_UNSET;
    }

    private SeekParameters clipSeekParameters(long j, SeekParameters seekParameters) {
        long constrainValue = Util.constrainValue(seekParameters.toleranceBeforeUs, 0L, j - this.startUs);
        long j2 = seekParameters.toleranceAfterUs;
        long j3 = this.endUs;
        long constrainValue2 = Util.constrainValue(j2, 0L, j3 == Long.MIN_VALUE ? Long.MAX_VALUE : j3 - j);
        return (constrainValue == seekParameters.toleranceBeforeUs && constrainValue2 == seekParameters.toleranceAfterUs) ? seekParameters : new SeekParameters(constrainValue, constrainValue2);
    }

    private static boolean shouldKeepInitialDiscontinuity(long j, long j2, ExoTrackSelection[] exoTrackSelectionArr) {
        if (j < j2) {
            return true;
        }
        if (j != 0) {
            for (ExoTrackSelection exoTrackSelection : exoTrackSelectionArr) {
                if (exoTrackSelection != null) {
                    Format selectedFormat = exoTrackSelection.getSelectedFormat();
                    if (!MimeTypes.allSamplesAreSyncSamples(selectedFormat.sampleMimeType, selectedFormat.codecs)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static long enforceClippingRange(long j, long j2, long j3) {
        long max = Math.max(j, j2);
        return j3 != Long.MIN_VALUE ? Math.min(max, j3) : max;
    }

    /* loaded from: classes3.dex */
    private final class ClippingSampleStream implements SampleStream {
        public final SampleStream childStream;
        private boolean sentEos;

        public ClippingSampleStream(SampleStream sampleStream) {
            this.childStream = sampleStream;
        }

        public void clearSentEos() {
            this.sentEos = false;
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public boolean isReady() {
            return !ClippingMediaPeriod.this.isPendingInitialDiscontinuity() && this.childStream.isReady();
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public void maybeThrowError() throws IOException {
            this.childStream.maybeThrowError();
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x007e, code lost:
            if (r19.timeUs < r17.this$0.endUs) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x008b, code lost:
            if (r19.waitingForKeys == false) goto L29;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x008d, code lost:
            r19.clear();
            r19.setFlags(4);
            r17.sentEos = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0096, code lost:
            return r4;
         */
        @Override // androidx.media3.exoplayer.source.SampleStream
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i) {
            int i2;
            long j;
            if (ClippingMediaPeriod.this.isPendingInitialDiscontinuity()) {
                return -3;
            }
            if (ClippingMediaPeriod.this.isPeriodClippingEndPosition) {
                int readData = this.childStream.readData(formatHolder, decoderInputBuffer, i);
                if (readData == -5) {
                    ClippingMediaPeriod.updateDecoderDelayPaddingForClipping(formatHolder, ClippingMediaPeriod.this.startUs, ClippingMediaPeriod.this.endUs);
                    return -5;
                }
                return readData;
            } else if (this.sentEos) {
                decoderInputBuffer.setFlags(4);
                return -4;
            } else {
                long bufferedPositionUs = ClippingMediaPeriod.this.getBufferedPositionUs();
                int readData2 = this.childStream.readData(formatHolder, decoderInputBuffer, i);
                if (ClippingMediaPeriod.this.lastReportedDiscontinuityUs != C.TIME_UNSET && readData2 != -3) {
                    ClippingMediaPeriod.this.lastReportedDiscontinuityUs = C.TIME_UNSET;
                }
                ClippingMediaPeriod clippingMediaPeriod = ClippingMediaPeriod.this;
                if (readData2 == -5) {
                    ClippingMediaPeriod.updateDecoderDelayPaddingForClipping(formatHolder, clippingMediaPeriod.startUs, ClippingMediaPeriod.this.endUs);
                    return -5;
                }
                if (clippingMediaPeriod.endUs != Long.MIN_VALUE) {
                    if (readData2 == -4) {
                        i2 = -4;
                        j = bufferedPositionUs;
                    } else {
                        i2 = -4;
                        j = bufferedPositionUs;
                    }
                    if (readData2 == -3) {
                        if (j == Long.MIN_VALUE) {
                        }
                    }
                }
                return readData2;
            }
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public int skipData(long j) {
            if (ClippingMediaPeriod.this.isPendingInitialDiscontinuity()) {
                return -3;
            }
            return this.childStream.skipData(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void updateDecoderDelayPaddingForClipping(FormatHolder formatHolder, long j, long j2) {
        Format format = (Format) Preconditions.checkNotNull(formatHolder.format);
        if (format.encoderDelay == 0 && format.encoderPadding == 0) {
            return;
        }
        formatHolder.format = format.buildUpon().setEncoderDelay(j != 0 ? 0 : format.encoderDelay).setEncoderPadding(j2 == Long.MIN_VALUE ? format.encoderPadding : 0).build();
    }
}
