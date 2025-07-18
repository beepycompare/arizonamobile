package androidx.media3.exoplayer.source;

import android.os.Looper;
import androidx.media3.common.C;
import androidx.media3.common.DataReader;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
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
import java.io.IOException;
import java.util.Objects;
/* loaded from: classes2.dex */
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
    private boolean allSamplesAreSyncSamples = true;

    /* loaded from: classes2.dex */
    public interface UpstreamFormatChangedListener {
        void onUpstreamFormatChanged(Format format);
    }

    public static SampleQueue createWithoutDrm(Allocator allocator) {
        return new SampleQueue(allocator, null, null);
    }

    public static SampleQueue createWithDrm(Allocator allocator, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        return new SampleQueue(allocator, (DrmSessionManager) Assertions.checkNotNull(drmSessionManager), (DrmSessionEventListener.EventDispatcher) Assertions.checkNotNull(eventDispatcher));
    }

    @Deprecated
    public static SampleQueue createWithDrm(Allocator allocator, Looper looper, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        drmSessionManager.setPlayer(looper, PlayerId.UNSET);
        return new SampleQueue(allocator, (DrmSessionManager) Assertions.checkNotNull(drmSessionManager), (DrmSessionEventListener.EventDispatcher) Assertions.checkNotNull(eventDispatcher));
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
            this.allSamplesAreSyncSamples = true;
        }
    }

    public final void setStartTimeUs(long j) {
        this.startTimeUs = j;
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
        Assertions.checkArgument(j > getLargestReadTimestampUs());
        discardUpstreamSamples(this.absoluteFirstIndex + countUnreadSamplesBefore(j));
    }

    public void preRelease() {
        discardToEnd();
        releaseDrmSessionReferences();
    }

    public void maybeThrowError() throws IOException {
        DrmSession drmSession = this.currentDrmSession;
        if (drmSession != null && drmSession.getState() == 1) {
            throw ((DrmSession.DrmSessionException) Assertions.checkNotNull(this.currentDrmSession.getError()));
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
        boolean z2 = true;
        if (!hasNextSample()) {
            if (!z && !this.isLastSampleQueued && ((format = this.upstreamFormat) == null || format == this.downstreamFormat)) {
                z2 = false;
            }
            return z2;
        } else if (this.sharedSampleMetadata.get(getReadIndex()).format != this.downstreamFormat) {
            return true;
        } else {
            return mayReadSample(getRelativeIndex(this.readPosition));
        }
    }

    public int read(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i, boolean z) {
        int peekSampleMetadata = peekSampleMetadata(formatHolder, decoderInputBuffer, (i & 2) != 0, z, this.extrasHolder);
        if (peekSampleMetadata == -4 && !decoderInputBuffer.isEndOfStream()) {
            boolean z2 = (i & 1) != 0;
            if ((i & 4) == 0) {
                if (z2) {
                    this.sampleDataQueue.peekToBuffer(decoderInputBuffer, this.extrasHolder);
                } else {
                    this.sampleDataQueue.readToBuffer(decoderInputBuffer, this.extrasHolder);
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
            this.startTimeUs = Long.MIN_VALUE;
            this.readPosition = i - i2;
            return true;
        }
        return false;
    }

    public final synchronized boolean seekTo(long j, boolean z) {
        SampleQueue sampleQueue;
        long j2;
        int findSampleBefore;
        try {
            try {
                rewind();
                int relativeIndex = getRelativeIndex(this.readPosition);
                if (hasNextSample() && j >= this.timesUs[relativeIndex] && (j <= this.largestQueuedTimestampUs || z)) {
                    if (this.allSamplesAreSyncSamples) {
                        sampleQueue = this;
                        j2 = j;
                        findSampleBefore = sampleQueue.findSampleAfter(relativeIndex, this.length - this.readPosition, j2, z);
                    } else {
                        sampleQueue = this;
                        j2 = j;
                        findSampleBefore = sampleQueue.findSampleBefore(relativeIndex, sampleQueue.length - sampleQueue.readPosition, j2, true);
                    }
                    if (findSampleBefore == -1) {
                        return false;
                    }
                    sampleQueue.startTimeUs = j2;
                    sampleQueue.readPosition += findSampleBefore;
                    return true;
                }
                return false;
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final synchronized int getSkipCount(long j, boolean z) {
        Throwable th;
        try {
            try {
                int relativeIndex = getRelativeIndex(this.readPosition);
                if (hasNextSample() && j >= this.timesUs[relativeIndex]) {
                    if (j > this.largestQueuedTimestampUs && z) {
                        try {
                            return this.length - this.readPosition;
                        } catch (Throwable th2) {
                            th = th2;
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
                    Assertions.checkArgument(z);
                    this.readPosition += i;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        z = false;
        Assertions.checkArgument(z);
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
            format((Format) Assertions.checkStateNotNull(this.unadjustedUpstreamFormat));
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
        if (this.allSamplesAreSyncSamples) {
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

    private synchronized int peekSampleMetadata(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z, boolean z2, SampleExtrasHolder sampleExtrasHolder) {
        decoderInputBuffer.waitingForKeys = false;
        if (!hasNextSample()) {
            if (!z2 && !this.isLastSampleQueued) {
                Format format = this.upstreamFormat;
                if (format == null || (!z && format == this.downstreamFormat)) {
                    return -3;
                }
                onFormatResult((Format) Assertions.checkNotNull(format), formatHolder);
                return -5;
            }
            decoderInputBuffer.setFlags(4);
            decoderInputBuffer.timeUs = Long.MIN_VALUE;
            return -4;
        }
        Format format2 = this.sharedSampleMetadata.get(getReadIndex()).format;
        if (!z && format2 == this.downstreamFormat) {
            int relativeIndex = getRelativeIndex(this.readPosition);
            if (!mayReadSample(relativeIndex)) {
                decoderInputBuffer.waitingForKeys = true;
                return -3;
            }
            decoderInputBuffer.setFlags(this.flags[relativeIndex]);
            if (this.readPosition == this.length - 1 && (z2 || this.isLastSampleQueued)) {
                decoderInputBuffer.addFlag(C.BUFFER_FLAG_LAST_SAMPLE);
            }
            decoderInputBuffer.timeUs = this.timesUs[relativeIndex];
            sampleExtrasHolder.size = this.sizes[relativeIndex];
            sampleExtrasHolder.offset = this.offsets[relativeIndex];
            sampleExtrasHolder.cryptoData = this.cryptoDatas[relativeIndex];
            return -4;
        }
        onFormatResult(format2, formatHolder);
        return -5;
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
        this.allSamplesAreSyncSamples &= MimeTypes.allSamplesAreSyncSamples(this.upstreamFormat.sampleMimeType, this.upstreamFormat.codecs);
        this.loggedUnexpectedNonSyncSample = false;
        return true;
    }

    private synchronized long discardSampleMetadataTo(long j, boolean z, boolean z2) {
        Throwable th;
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
            Assertions.checkArgument(this.offsets[relativeIndex] + ((long) this.sizes[relativeIndex]) <= j2);
        }
        this.isLastSampleQueued = (536870912 & i) != 0;
        this.largestQueuedTimestampUs = Math.max(this.largestQueuedTimestampUs, j);
        int relativeIndex2 = getRelativeIndex(this.length);
        this.timesUs[relativeIndex2] = j;
        this.offsets[relativeIndex2] = j2;
        this.sizes[relativeIndex2] = i2;
        this.flags[relativeIndex2] = i;
        this.cryptoDatas[relativeIndex2] = cryptoData;
        this.sourceIds[relativeIndex2] = this.upstreamSourceId;
        if (this.sharedSampleMetadata.isEmpty() || !this.sharedSampleMetadata.getEndValue().format.equals(this.upstreamFormat)) {
            Format format = (Format) Assertions.checkNotNull(this.upstreamFormat);
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
        Assertions.checkArgument(writeIndex >= 0 && writeIndex <= this.length - this.readPosition);
        int i2 = this.length - writeIndex;
        this.length = i2;
        this.largestQueuedTimestampUs = Math.max(this.largestDiscardedTimestampUs, getLargestTimestamp(i2));
        if (writeIndex == 0 && this.isLastSampleQueued) {
            z = true;
        }
        this.isLastSampleQueued = z;
        this.sharedSampleMetadata.discardFrom(i);
        int i3 = this.length;
        if (i3 != 0) {
            return this.offsets[getRelativeIndex(i3 - 1)] + this.sizes[relativeIndex];
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class SampleExtrasHolder {
        public TrackOutput.CryptoData cryptoData;
        public long offset;
        public int size;

        SampleExtrasHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class SharedSampleMetadata {
        public final DrmSessionManager.DrmSessionReference drmSessionReference;
        public final Format format;

        private SharedSampleMetadata(Format format, DrmSessionManager.DrmSessionReference drmSessionReference) {
            this.format = format;
            this.drmSessionReference = drmSessionReference;
        }
    }
}
