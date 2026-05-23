package androidx.media3.exoplayer.source;

import android.os.Looper;
import androidx.media3.common.DataReader;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.source.SampleQueue;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.extractor.TrackOutput;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.util.Objects;
/* loaded from: classes3.dex */
public class SampleQueue implements TrackOutput {
    static final int SAMPLE_CAPACITY_INCREMENT = 1000;
    private static final String TAG = "SampleQueue";
    private int absoluteFirstIndex;
    private DrmSession currentDrmSession;
    private Format downstreamFormat;
    private final DrmSessionEventListener.EventDispatcher drmEventDispatcher;
    private final DrmSessionManager drmSessionManager;
    private boolean isLastSampleQueued;
    private int length;
    private boolean loggedUnexpectedNonSyncSample;
    private boolean pendingSplice;
    private int readPosition;
    private int relativeFirstIndex;
    private final SampleDataQueue sampleDataQueue;
    private long sampleOffsetUs;
    private Format unadjustedUpstreamFormat;
    private Format upstreamFormat;
    private boolean upstreamFormatAdjustmentRequired;
    private UpstreamFormatChangedListener upstreamFormatChangeListener;
    private long upstreamSourceId;
    private final SampleExtrasHolder extrasHolder = new SampleExtrasHolder();
    private int capacity = 1000;
    private long[] sourceIds = new long[1000];
    private long[] offsets = new long[1000];
    private long[] timesUs = new long[1000];
    private int[] flags = new int[1000];
    private int[] sizes = new int[1000];
    private TrackOutput.CryptoData[] cryptoDatas = new TrackOutput.CryptoData[1000];
    private final SpannedData<SharedSampleMetadata> sharedSampleMetadata = new SpannedData<>(new Consumer() { // from class: androidx.media3.exoplayer.source.SampleQueue$$ExternalSyntheticLambda0
        @Override // androidx.media3.common.util.Consumer
        public final void accept(Object obj) {
            ((SampleQueue.SharedSampleMetadata) obj).drmSessionReference.release();
        }
    });
    private long startTimeUs = Long.MIN_VALUE;
    private long largestDiscardedTimestampUs = Long.MIN_VALUE;
    private long largestQueuedTimestampUs = Long.MIN_VALUE;
    private boolean upstreamFormatRequired = true;
    private boolean upstreamKeyframeRequired = true;
    private boolean discardAllSamplesToStartTime = true;
    private long readEndTimeUs = Long.MIN_VALUE;
    private int readEndTimeAbsoluteIndex = -1;

    /* loaded from: classes3.dex */
    public interface UpstreamFormatChangedListener {
        void onUpstreamFormatChanged(Format format);
    }

    public static SampleQueue createWithoutDrm(Allocator allocator) {
        return new SampleQueue(allocator, null, null);
    }

    public static SampleQueue createWithDrm(Allocator allocator, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        return new SampleQueue(allocator, (DrmSessionManager) Preconditions.checkNotNull(drmSessionManager), (DrmSessionEventListener.EventDispatcher) Preconditions.checkNotNull(eventDispatcher));
    }

    @Deprecated
    public static SampleQueue createWithDrm(Allocator allocator, Looper looper, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        drmSessionManager.setPlayer(looper, PlayerId.UNSET);
        return new SampleQueue(allocator, (DrmSessionManager) Preconditions.checkNotNull(drmSessionManager), (DrmSessionEventListener.EventDispatcher) Preconditions.checkNotNull(eventDispatcher));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SampleQueue(Allocator allocator, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        this.drmSessionManager = drmSessionManager;
        this.drmEventDispatcher = eventDispatcher;
        this.sampleDataQueue = new SampleDataQueue(allocator);
    }

    public void release() {
        reset(true);
        releaseDrmSessionReferences();
    }

    public final void reset() {
        reset(false);
    }

    public void reset(boolean z) {
        this.sampleDataQueue.reset();
        this.length = 0;
        this.absoluteFirstIndex = 0;
        this.relativeFirstIndex = 0;
        this.readPosition = 0;
        this.readEndTimeAbsoluteIndex = -1;
        this.upstreamKeyframeRequired = true;
        this.startTimeUs = Long.MIN_VALUE;
        this.largestDiscardedTimestampUs = Long.MIN_VALUE;
        this.largestQueuedTimestampUs = Long.MIN_VALUE;
        this.isLastSampleQueued = false;
        this.sharedSampleMetadata.clear();
        if (z) {
            this.unadjustedUpstreamFormat = null;
            this.upstreamFormat = null;
            this.upstreamFormatRequired = true;
            this.discardAllSamplesToStartTime = true;
        }
    }

    public final void setStartTimeUs(long j) {
        this.startTimeUs = j;
    }

    public final synchronized void setReadEndTimeUs(long j) {
        Throwable th;
        SampleQueue sampleQueue;
        SampleQueue sampleQueue2;
        long j2;
        int i;
        try {
            try {
                if (j == this.readEndTimeUs) {
                    return;
                }
                int i2 = -1;
                if (j == Long.MIN_VALUE) {
                    try {
                        this.readEndTimeAbsoluteIndex = -1;
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        sampleQueue = this;
                        throw th;
                    }
                }
                if (j <= this.largestQueuedTimestampUs) {
                    sampleQueue2 = this;
                    j2 = j;
                    i = sampleQueue2.findSampleAfter(this.relativeFirstIndex, this.length, j2, false);
                } else {
                    sampleQueue2 = this;
                    j2 = j;
                    i = -1;
                }
                if (i != -1) {
                    i2 = sampleQueue2.absoluteFirstIndex + i;
                }
                sampleQueue2.readEndTimeAbsoluteIndex = i2;
                sampleQueue2.readEndTimeUs = j2;
            } catch (Throwable th3) {
                th = th3;
                sampleQueue = this;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public final void sourceId(long j) {
        this.upstreamSourceId = j;
    }

    public final void splice() {
        this.pendingSplice = true;
    }

    public final int getWriteIndex() {
        return this.absoluteFirstIndex + this.length;
    }

    public final void discardUpstreamSamples(int i) {
        this.sampleDataQueue.discardUpstreamSampleBytes(discardUpstreamSampleMetadata(i));
    }

    public final void discardUpstreamFrom(long j) {
        if (this.length == 0) {
            return;
        }
        Preconditions.checkArgument(j > getLargestReadTimestampUs());
        discardUpstreamSamples(this.absoluteFirstIndex + countUnreadSamplesBefore(j));
    }

    public void preRelease() {
        discardToEnd();
        releaseDrmSessionReferences();
    }

    public void maybeThrowError() throws IOException {
        DrmSession drmSession = this.currentDrmSession;
        if (drmSession != null && drmSession.getState() == 1) {
            throw ((DrmSession.DrmSessionException) Preconditions.checkNotNull(this.currentDrmSession.getError()));
        }
    }

    public final int getFirstIndex() {
        return this.absoluteFirstIndex;
    }

    public final int getReadIndex() {
        return this.absoluteFirstIndex + this.readPosition;
    }

    public final synchronized long peekSourceId() {
        return hasNextSample() ? this.sourceIds[getRelativeIndex(this.readPosition)] : this.upstreamSourceId;
    }

    public final synchronized Format getUpstreamFormat() {
        return this.upstreamFormatRequired ? null : this.upstreamFormat;
    }

    public final synchronized long getLargestQueuedTimestampUs() {
        return this.largestQueuedTimestampUs;
    }

    public final synchronized boolean hasQueuedTimestampsUpToReadEndTimeUs() {
        return this.readEndTimeAbsoluteIndex != -1;
    }

    public final synchronized long getLargestReadTimestampUs() {
        return Math.max(this.largestDiscardedTimestampUs, getLargestTimestamp(this.readPosition));
    }

    public final synchronized boolean isLastSampleQueued() {
        return this.isLastSampleQueued;
    }

    public final synchronized long getFirstTimestampUs() {
        return this.length == 0 ? Long.MIN_VALUE : this.timesUs[this.relativeFirstIndex];
    }

    public synchronized boolean isReady(boolean z) {
        Format format;
        int readIndex = getReadIndex();
        int i = this.readEndTimeAbsoluteIndex;
        boolean z2 = true;
        if (i == -1 || readIndex < i) {
            if (!hasNextSample()) {
                if (!z && !this.isLastSampleQueued && ((format = this.upstreamFormat) == null || format == this.downstreamFormat)) {
                    z2 = false;
                }
                return z2;
            } else if (this.sharedSampleMetadata.get(readIndex).format != this.downstreamFormat) {
                return true;
            } else {
                return mayReadSample(getRelativeIndex(this.readPosition));
            }
        }
        return true;
    }

    public int read(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i, boolean z) {
        int peekSampleMetadata = peekSampleMetadata(formatHolder, decoderInputBuffer, (i & 2) != 0, z, this.extrasHolder);
        if (peekSampleMetadata == -4 && !decoderInputBuffer.isEndOfStream()) {
            boolean z2 = (i & 1) != 0;
            if ((i & 4) == 0) {
                SampleDataQueue sampleDataQueue = this.sampleDataQueue;
                if (z2) {
                    sampleDataQueue.peekToBuffer(decoderInputBuffer, this.extrasHolder);
                } else {
                    sampleDataQueue.readToBuffer(decoderInputBuffer, this.extrasHolder);
                }
            }
            if (!z2) {
                this.readPosition++;
            }
        }
        return peekSampleMetadata;
    }

    public final synchronized boolean seekTo(int i) {
        rewind();
        int i2 = this.absoluteFirstIndex;
        if (i >= i2 && i <= this.length + i2) {
            int i3 = this.readEndTimeAbsoluteIndex;
            if (i3 == -1 || i < i3) {
                this.startTimeUs = Long.MIN_VALUE;
                this.readPosition = i - i2;
                return true;
            }
            return false;
        }
        return false;
    }

    public final synchronized boolean seekTo(long j, boolean z) {
        Throwable th;
        SampleQueue sampleQueue;
        Throwable th2;
        long j2;
        int findSampleAfter;
        SampleQueue sampleQueue2;
        try {
            try {
                rewind();
                int relativeIndex = getRelativeIndex(this.readPosition);
                long j3 = this.readEndTimeUs;
                int i = (j3 > Long.MIN_VALUE ? 1 : (j3 == Long.MIN_VALUE ? 0 : -1));
                long j4 = this.largestQueuedTimestampUs;
                if (i != 0) {
                    try {
                        j4 = Math.min(j4, j3);
                    } catch (Throwable th3) {
                        th = th3;
                        sampleQueue = this;
                        throw th;
                    }
                }
                if (hasNextSample() && j >= this.timesUs[relativeIndex] && (j <= j4 || z)) {
                    boolean z2 = this.discardAllSamplesToStartTime;
                    int i2 = this.length;
                    if (z2) {
                        try {
                            int i3 = i2 - this.readPosition;
                            sampleQueue = this;
                            j2 = j;
                            try {
                                findSampleAfter = sampleQueue.findSampleAfter(relativeIndex, i3, j2, z);
                                sampleQueue2 = sampleQueue;
                            } catch (Throwable th4) {
                                th2 = th4;
                                th = th2;
                                throw th;
                            }
                        } catch (Throwable th5) {
                            th2 = th5;
                            sampleQueue = this;
                        }
                    } else {
                        j2 = j;
                        try {
                            int i4 = i2 - this.readPosition;
                            sampleQueue2 = this;
                            findSampleAfter = sampleQueue2.findSampleBefore(relativeIndex, i4, j2, true);
                        } catch (Throwable th6) {
                            th = th6;
                            sampleQueue = this;
                            th = th;
                            throw th;
                        }
                    }
                    if (findSampleAfter == -1) {
                        return false;
                    }
                    sampleQueue2.startTimeUs = j2;
                    sampleQueue2.readPosition += findSampleAfter;
                    return true;
                }
            } catch (Throwable th7) {
                th = th7;
                sampleQueue = this;
            }
        } catch (Throwable th8) {
            th = th8;
        }
        return false;
    }

    public final synchronized int getSkipCount(long j, boolean z) {
        Throwable th;
        SampleQueue sampleQueue;
        try {
            try {
                int relativeIndex = getRelativeIndex(this.readPosition);
                if (hasNextSample() && j >= this.timesUs[relativeIndex]) {
                    if (j > this.largestQueuedTimestampUs && z) {
                        try {
                            return this.length - this.readPosition;
                        } catch (Throwable th2) {
                            th = th2;
                            sampleQueue = this;
                            throw th;
                        }
                    }
                    int findSampleBefore = findSampleBefore(relativeIndex, this.length - this.readPosition, j, true);
                    if (findSampleBefore == -1) {
                        return 0;
                    }
                    return findSampleBefore;
                }
                return 0;
            } catch (Throwable th3) {
                th = th3;
                sampleQueue = this;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public final synchronized void skip(int i) {
        boolean z;
        if (i >= 0) {
            try {
                if (this.readPosition + i <= this.length) {
                    z = true;
                    Preconditions.checkArgument(z);
                    this.readPosition += i;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        z = false;
        Preconditions.checkArgument(z);
        this.readPosition += i;
    }

    public final void discardTo(long j, boolean z, boolean z2) {
        this.sampleDataQueue.discardDownstreamTo(discardSampleMetadataTo(j, z, z2));
    }

    public final void discardToRead() {
        this.sampleDataQueue.discardDownstreamTo(discardSampleMetadataToRead());
    }

    public final void discardToEnd() {
        this.sampleDataQueue.discardDownstreamTo(discardSampleMetadataToEnd());
    }

    public final void setSampleOffsetUs(long j) {
        if (this.sampleOffsetUs != j) {
            this.sampleOffsetUs = j;
            invalidateUpstreamFormatAdjustment();
        }
    }

    public final void setUpstreamFormatChangeListener(UpstreamFormatChangedListener upstreamFormatChangedListener) {
        this.upstreamFormatChangeListener = upstreamFormatChangedListener;
    }

    @Override // androidx.media3.extractor.TrackOutput
    public final void format(Format format) {
        Format adjustedUpstreamFormat = getAdjustedUpstreamFormat(format);
        this.upstreamFormatAdjustmentRequired = false;
        this.unadjustedUpstreamFormat = format;
        boolean upstreamFormat = setUpstreamFormat(adjustedUpstreamFormat);
        UpstreamFormatChangedListener upstreamFormatChangedListener = this.upstreamFormatChangeListener;
        if (upstreamFormatChangedListener == null || !upstreamFormat) {
            return;
        }
        upstreamFormatChangedListener.onUpstreamFormatChanged(adjustedUpstreamFormat);
    }

    @Override // androidx.media3.extractor.TrackOutput
    public final int sampleData(DataReader dataReader, int i, boolean z, int i2) throws IOException {
        return this.sampleDataQueue.sampleData(dataReader, i, z);
    }

    @Override // androidx.media3.extractor.TrackOutput
    public final void sampleData(ParsableByteArray parsableByteArray, int i, int i2) {
        this.sampleDataQueue.sampleData(parsableByteArray, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0056  */
    @Override // androidx.media3.extractor.TrackOutput
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void sampleMetadata(long j, int i, int i2, int i3, TrackOutput.CryptoData cryptoData) {
        int i4;
        if (this.upstreamFormatAdjustmentRequired) {
            format((Format) Preconditions.checkNotNull(this.unadjustedUpstreamFormat));
        }
        int i5 = i & 1;
        boolean z = i5 != 0;
        if (this.upstreamKeyframeRequired) {
            if (!z) {
                return;
            }
            this.upstreamKeyframeRequired = false;
        }
        long j2 = this.sampleOffsetUs + j;
        if (this.discardAllSamplesToStartTime) {
            if (j2 < this.startTimeUs) {
                return;
            }
            if (i5 == 0) {
                if (!this.loggedUnexpectedNonSyncSample) {
                    Log.w(TAG, "Overriding unexpected non-sync sample for format: " + this.upstreamFormat);
                    this.loggedUnexpectedNonSyncSample = true;
                }
                i4 = i | 1;
                if (this.pendingSplice) {
                    if (!z || !attemptSplice(j2)) {
                        return;
                    }
                    this.pendingSplice = false;
                }
                commitSample(j2, i4, (this.sampleDataQueue.getTotalBytesWritten() - i2) - i3, i2, cryptoData);
            }
        }
        i4 = i;
        if (this.pendingSplice) {
        }
        commitSample(j2, i4, (this.sampleDataQueue.getTotalBytesWritten() - i2) - i3, i2, cryptoData);
    }

    protected final void invalidateUpstreamFormatAdjustment() {
        this.upstreamFormatAdjustmentRequired = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Format getAdjustedUpstreamFormat(Format format) {
        return (this.sampleOffsetUs == 0 || format.subsampleOffsetUs == Long.MAX_VALUE) ? format : format.buildUpon().setSubsampleOffsetUs(format.subsampleOffsetUs + this.sampleOffsetUs).build();
    }

    private synchronized void rewind() {
        this.readPosition = 0;
        this.sampleDataQueue.rewind();
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x007a, code lost:
        if (r7.isLastSampleQueued != false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x007c, code lost:
        if (r0 == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x007f, code lost:
        r9 = r7.upstreamFormat;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0081, code lost:
        if (r9 == null) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0083, code lost:
        if (r10 != false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0087, code lost:
        if (r9 == r7.downstreamFormat) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0089, code lost:
        onFormatResult((androidx.media3.common.Format) com.google.common.base.Preconditions.checkNotNull(r9), r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0093, code lost:
        return -5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0095, code lost:
        return -3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized int peekSampleMetadata(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z, boolean z2, SampleExtrasHolder sampleExtrasHolder) {
        boolean z3 = false;
        decoderInputBuffer.waitingForKeys = false;
        int readIndex = getReadIndex();
        int i = this.readEndTimeAbsoluteIndex;
        if (i != -1 && readIndex >= i) {
            z3 = true;
        }
        if (hasNextSample() && !z3) {
            Format format = this.sharedSampleMetadata.get(readIndex).format;
            if (!z && format == this.downstreamFormat) {
                int relativeIndex = getRelativeIndex(this.readPosition);
                if (!mayReadSample(relativeIndex)) {
                    decoderInputBuffer.waitingForKeys = true;
                    return -3;
                }
                decoderInputBuffer.setFlags(this.flags[relativeIndex]);
                if (this.readPosition == this.length - 1 && (z2 || this.isLastSampleQueued)) {
                    decoderInputBuffer.addFlag(536870912);
                }
                decoderInputBuffer.timeUs = this.timesUs[relativeIndex];
                sampleExtrasHolder.size = this.sizes[relativeIndex];
                sampleExtrasHolder.offset = this.offsets[relativeIndex];
                sampleExtrasHolder.cryptoData = this.cryptoDatas[relativeIndex];
                return -4;
            }
            onFormatResult(format, formatHolder);
            return -5;
        }
        decoderInputBuffer.setFlags(4);
        decoderInputBuffer.timeUs = Long.MIN_VALUE;
        return -4;
    }

    private synchronized boolean setUpstreamFormat(Format format) {
        this.upstreamFormatRequired = false;
        if (Objects.equals(format, this.upstreamFormat)) {
            return false;
        }
        if (!this.sharedSampleMetadata.isEmpty() && this.sharedSampleMetadata.getEndValue().format.equals(format)) {
            this.upstreamFormat = this.sharedSampleMetadata.getEndValue().format;
        } else {
            this.upstreamFormat = format;
        }
        this.discardAllSamplesToStartTime &= canDiscardAllSamplesToStartTime(this.upstreamFormat.sampleMimeType, this.upstreamFormat.codecs);
        this.loggedUnexpectedNonSyncSample = false;
        return true;
    }

    private synchronized long discardSampleMetadataTo(long j, boolean z, boolean z2) {
        Throwable th;
        SampleQueue sampleQueue;
        try {
            try {
                int i = this.length;
                if (i != 0) {
                    long[] jArr = this.timesUs;
                    int i2 = this.relativeFirstIndex;
                    if (j >= jArr[i2]) {
                        if (z2) {
                            try {
                                int i3 = this.readPosition;
                                if (i3 != i) {
                                    i = i3 + 1;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                sampleQueue = this;
                                throw th;
                            }
                        }
                        int findSampleBefore = findSampleBefore(i2, i, j, z);
                        if (findSampleBefore == -1) {
                            return -1L;
                        }
                        return discardSamples(findSampleBefore);
                    }
                }
                return -1L;
            } catch (Throwable th3) {
                th = th3;
                sampleQueue = this;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public synchronized long discardSampleMetadataToRead() {
        int i = this.readPosition;
        if (i == 0) {
            return -1L;
        }
        return discardSamples(i);
    }

    private synchronized long discardSampleMetadataToEnd() {
        int i = this.length;
        if (i == 0) {
            return -1L;
        }
        return discardSamples(i);
    }

    private void releaseDrmSessionReferences() {
        DrmSession drmSession = this.currentDrmSession;
        if (drmSession != null) {
            drmSession.release(this.drmEventDispatcher);
            this.currentDrmSession = null;
            this.downstreamFormat = null;
        }
    }

    private synchronized void commitSample(long j, int i, long j2, int i2, TrackOutput.CryptoData cryptoData) {
        DrmSessionManager.DrmSessionReference drmSessionReference;
        int i3 = this.length;
        if (i3 > 0) {
            int relativeIndex = getRelativeIndex(i3 - 1);
            Preconditions.checkArgument(this.offsets[relativeIndex] + ((long) this.sizes[relativeIndex]) <= j2);
        }
        this.isLastSampleQueued = (536870912 & i) != 0;
        this.largestQueuedTimestampUs = Math.max(this.largestQueuedTimestampUs, j);
        long j3 = this.readEndTimeUs;
        if (j3 != Long.MIN_VALUE && this.readEndTimeAbsoluteIndex == -1 && j >= j3) {
            this.readEndTimeAbsoluteIndex = this.absoluteFirstIndex + this.length;
        }
        int relativeIndex2 = getRelativeIndex(this.length);
        this.timesUs[relativeIndex2] = j;
        this.offsets[relativeIndex2] = j2;
        this.sizes[relativeIndex2] = i2;
        this.flags[relativeIndex2] = i;
        this.cryptoDatas[relativeIndex2] = cryptoData;
        this.sourceIds[relativeIndex2] = this.upstreamSourceId;
        if (this.sharedSampleMetadata.isEmpty() || !this.sharedSampleMetadata.getEndValue().format.equals(this.upstreamFormat)) {
            Format format = (Format) Preconditions.checkNotNull(this.upstreamFormat);
            DrmSessionManager drmSessionManager = this.drmSessionManager;
            if (drmSessionManager != null) {
                drmSessionReference = drmSessionManager.preacquireSession(this.drmEventDispatcher, format);
            } else {
                drmSessionReference = DrmSessionManager.DrmSessionReference.EMPTY;
            }
            this.sharedSampleMetadata.appendSpan(getWriteIndex(), new SharedSampleMetadata(format, drmSessionReference));
        }
        int i4 = this.length + 1;
        this.length = i4;
        int i5 = this.capacity;
        if (i4 == i5) {
            int i6 = i5 + 1000;
            long[] jArr = new long[i6];
            long[] jArr2 = new long[i6];
            long[] jArr3 = new long[i6];
            int[] iArr = new int[i6];
            int[] iArr2 = new int[i6];
            TrackOutput.CryptoData[] cryptoDataArr = new TrackOutput.CryptoData[i6];
            int i7 = this.relativeFirstIndex;
            int i8 = i5 - i7;
            System.arraycopy(this.offsets, i7, jArr2, 0, i8);
            System.arraycopy(this.timesUs, this.relativeFirstIndex, jArr3, 0, i8);
            System.arraycopy(this.flags, this.relativeFirstIndex, iArr, 0, i8);
            System.arraycopy(this.sizes, this.relativeFirstIndex, iArr2, 0, i8);
            System.arraycopy(this.cryptoDatas, this.relativeFirstIndex, cryptoDataArr, 0, i8);
            System.arraycopy(this.sourceIds, this.relativeFirstIndex, jArr, 0, i8);
            int i9 = this.relativeFirstIndex;
            System.arraycopy(this.offsets, 0, jArr2, i8, i9);
            System.arraycopy(this.timesUs, 0, jArr3, i8, i9);
            System.arraycopy(this.flags, 0, iArr, i8, i9);
            System.arraycopy(this.sizes, 0, iArr2, i8, i9);
            System.arraycopy(this.cryptoDatas, 0, cryptoDataArr, i8, i9);
            System.arraycopy(this.sourceIds, 0, jArr, i8, i9);
            this.offsets = jArr2;
            this.timesUs = jArr3;
            this.flags = iArr;
            this.sizes = iArr2;
            this.cryptoDatas = cryptoDataArr;
            this.sourceIds = jArr;
            this.relativeFirstIndex = 0;
            this.capacity = i6;
        }
    }

    private synchronized boolean attemptSplice(long j) {
        if (this.length == 0) {
            return j > this.largestDiscardedTimestampUs;
        } else if (getLargestReadTimestampUs() >= j) {
            return false;
        } else {
            discardUpstreamSampleMetadata(this.absoluteFirstIndex + countUnreadSamplesBefore(j));
            return true;
        }
    }

    private long discardUpstreamSampleMetadata(int i) {
        int relativeIndex;
        int writeIndex = getWriteIndex() - i;
        boolean z = false;
        Preconditions.checkArgument(writeIndex >= 0 && writeIndex <= this.length - this.readPosition);
        int i2 = this.length - writeIndex;
        this.length = i2;
        this.largestQueuedTimestampUs = Math.max(this.largestDiscardedTimestampUs, getLargestTimestamp(i2));
        if (writeIndex == 0 && this.isLastSampleQueued) {
            z = true;
        }
        this.isLastSampleQueued = z;
        int i3 = this.readEndTimeAbsoluteIndex;
        if (i3 != -1 && i < i3) {
            this.readEndTimeAbsoluteIndex = -1;
        }
        this.sharedSampleMetadata.discardFrom(i);
        int i4 = this.length;
        if (i4 != 0) {
            return this.offsets[getRelativeIndex(i4 - 1)] + this.sizes[relativeIndex];
        }
        return 0L;
    }

    private boolean hasNextSample() {
        return this.readPosition != this.length;
    }

    private void onFormatResult(Format format, FormatHolder formatHolder) {
        Format format2 = this.downstreamFormat;
        boolean z = format2 == null;
        DrmInitData drmInitData = format2 == null ? null : format2.drmInitData;
        this.downstreamFormat = format;
        DrmInitData drmInitData2 = format.drmInitData;
        DrmSessionManager drmSessionManager = this.drmSessionManager;
        formatHolder.format = drmSessionManager != null ? format.copyWithCryptoType(drmSessionManager.getCryptoType(format)) : format;
        formatHolder.drmSession = this.currentDrmSession;
        if (this.drmSessionManager == null) {
            return;
        }
        if (z || !Objects.equals(drmInitData, drmInitData2)) {
            DrmSession drmSession = this.currentDrmSession;
            DrmSession acquireSession = this.drmSessionManager.acquireSession(this.drmEventDispatcher, format);
            this.currentDrmSession = acquireSession;
            formatHolder.drmSession = acquireSession;
            if (drmSession != null) {
                drmSession.release(this.drmEventDispatcher);
            }
        }
    }

    private boolean mayReadSample(int i) {
        DrmSession drmSession = this.currentDrmSession;
        if (drmSession == null || drmSession.getState() == 4) {
            return true;
        }
        return (this.flags[i] & 1073741824) == 0 && this.currentDrmSession.playClearSamplesWithoutKeys();
    }

    private int findSampleBefore(int i, int i2, long j, boolean z) {
        int i3 = -1;
        for (int i4 = 0; i4 < i2; i4++) {
            long j2 = this.timesUs[i];
            if (j2 > j) {
                break;
            }
            if (!z || (this.flags[i] & 1) != 0) {
                if (j2 == j) {
                    return i4;
                }
                i3 = i4;
            }
            i++;
            if (i == this.capacity) {
                i = 0;
            }
        }
        return i3;
    }

    private int findSampleAfter(int i, int i2, long j, boolean z) {
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.timesUs[i] >= j) {
                return i3;
            }
            i++;
            if (i == this.capacity) {
                i = 0;
            }
        }
        if (z) {
            return i2;
        }
        return -1;
    }

    private int countUnreadSamplesBefore(long j) {
        int i = this.length;
        int relativeIndex = getRelativeIndex(i - 1);
        while (i > this.readPosition && this.timesUs[relativeIndex] >= j) {
            i--;
            relativeIndex--;
            if (relativeIndex == -1) {
                relativeIndex = this.capacity - 1;
            }
        }
        return i;
    }

    private long discardSamples(int i) {
        int i2;
        this.largestDiscardedTimestampUs = Math.max(this.largestDiscardedTimestampUs, getLargestTimestamp(i));
        this.length -= i;
        int i3 = this.absoluteFirstIndex + i;
        this.absoluteFirstIndex = i3;
        int i4 = this.relativeFirstIndex + i;
        this.relativeFirstIndex = i4;
        int i5 = this.capacity;
        if (i4 >= i5) {
            this.relativeFirstIndex = i4 - i5;
        }
        int i6 = this.readPosition - i;
        this.readPosition = i6;
        if (i6 < 0) {
            this.readPosition = 0;
        }
        this.sharedSampleMetadata.discardTo(i3);
        if (this.length == 0) {
            int i7 = this.relativeFirstIndex;
            if (i7 == 0) {
                i7 = this.capacity;
            }
            return this.offsets[i7 - 1] + this.sizes[i2];
        }
        return this.offsets[this.relativeFirstIndex];
    }

    private long getLargestTimestamp(int i) {
        long j = Long.MIN_VALUE;
        if (i == 0) {
            return Long.MIN_VALUE;
        }
        int relativeIndex = getRelativeIndex(i - 1);
        for (int i2 = 0; i2 < i; i2++) {
            j = Math.max(j, this.timesUs[relativeIndex]);
            if ((this.flags[relativeIndex] & 1) != 0) {
                return j;
            }
            relativeIndex--;
            if (relativeIndex == -1) {
                relativeIndex = this.capacity - 1;
            }
        }
        return j;
    }

    private int getRelativeIndex(int i) {
        int i2 = this.relativeFirstIndex + i;
        int i3 = this.capacity;
        return i2 < i3 ? i2 : i2 - i3;
    }

    private static boolean canDiscardAllSamplesToStartTime(String str, String str2) {
        return MimeTypes.getTrackType(str) == 1 && MimeTypes.allSamplesAreSyncSamples(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class SampleExtrasHolder {
        public TrackOutput.CryptoData cryptoData;
        public long offset;
        public int size;

        SampleExtrasHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class SharedSampleMetadata {
        public final DrmSessionManager.DrmSessionReference drmSessionReference;
        public final Format format;

        private SharedSampleMetadata(Format format, DrmSessionManager.DrmSessionReference drmSessionReference) {
            this.format = format;
            this.drmSessionReference = drmSessionReference;
        }
    }
}
