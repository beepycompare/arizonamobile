package androidx.media3.exoplayer;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaCodec;
import android.media.MediaDataSource;
import android.media.MediaFormat;
import android.media.metrics.LogSessionId;
import android.net.Uri;
import android.os.PersistableBundle;
import android.util.SparseArray;
import androidx.media3.common.C;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.MediaFormatUtil;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSourceUtil;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.DefaultDataSource;
import androidx.media3.datasource.FileDescriptorDataSource;
import androidx.media3.datasource.MediaDataSourceAdapter;
import androidx.media3.decoder.CryptoInfo;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;
import androidx.media3.exoplayer.source.SampleQueue;
import androidx.media3.exoplayer.source.UnrecognizedInputFormatException;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.DefaultAllocator;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.extractor.DefaultExtractorsFactory;
import androidx.media3.extractor.DiscardingTrackOutput;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SeekPoint;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.mp4.Mp4Extractor;
import androidx.media3.extractor.mp4.PsshAtomUtil;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
/* loaded from: classes2.dex */
public final class MediaExtractorCompat {
    private static final long DEFAULT_LAST_SAMPLE_DURATION_US = 10000;
    public static final int SEEK_TO_CLOSEST_SYNC = 2;
    public static final int SEEK_TO_NEXT_SYNC = 1;
    public static final int SEEK_TO_PREVIOUS_SYNC = 0;
    private static final String TAG = "MediaExtractorCompat";
    private final Allocator allocator;
    private DataSource currentDataSource;
    private Extractor currentExtractor;
    private ExtractorInput currentExtractorInput;
    private final DataSource.Factory dataSourceFactory;
    private final ExtractorsFactory extractorsFactory;
    private final FormatHolder formatHolder;
    private boolean hasBeenPrepared;
    private Map<String, String> httpRequestHeaders;
    private LogSessionId logSessionId;
    private long offsetInCurrentFile;
    private SeekPoint pendingSeek;
    private final PositionHolder positionHolder;
    private final DecoderInputBuffer sampleHolderWithBufferReplacementDisabled;
    private final DecoderInputBuffer sampleHolderWithBufferReplacementEnabled;
    private final SampleMetadataQueue sampleMetadataQueue;
    private final SparseArray<MediaExtractorSampleQueue> sampleQueues;
    private SeekMap seekMap;
    private final Set<Integer> selectedTrackIndices;
    private final ArrayList<MediaExtractorTrack> tracks;
    private boolean tracksEnded;
    private int upstreamFormatsCount;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface SeekMode {
    }

    public MediaExtractorCompat(Context context) {
        this(new DefaultExtractorsFactory(), new DefaultDataSource.Factory(context));
    }

    public MediaExtractorCompat(ExtractorsFactory extractorsFactory, DataSource.Factory factory) {
        this.extractorsFactory = extractorsFactory;
        this.dataSourceFactory = factory;
        this.positionHolder = new PositionHolder();
        this.allocator = new DefaultAllocator(true, 65536);
        this.tracks = new ArrayList<>();
        this.sampleQueues = new SparseArray<>();
        this.sampleMetadataQueue = new SampleMetadataQueue();
        this.formatHolder = new FormatHolder();
        this.sampleHolderWithBufferReplacementDisabled = DecoderInputBuffer.newNoDataInstance();
        this.sampleHolderWithBufferReplacementEnabled = new DecoderInputBuffer(2);
        this.selectedTrackIndices = new HashSet();
    }

    public void setDataSource(Uri uri, long j) throws IOException {
        prepareDataSource(this.dataSourceFactory.createDataSource(), buildDataSpec(uri, j));
    }

    public void setDataSource(AssetFileDescriptor assetFileDescriptor) throws IOException {
        if (assetFileDescriptor.getDeclaredLength() == -1) {
            setDataSource(assetFileDescriptor.getFileDescriptor());
        } else {
            setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getDeclaredLength());
        }
    }

    public void setDataSource(FileDescriptor fileDescriptor) throws IOException {
        setDataSource(fileDescriptor, 0L, -1L);
    }

    public void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IOException {
        prepareDataSource(new FileDescriptorDataSource(fileDescriptor, j, j2), buildDataSpec(Uri.EMPTY, 0L));
    }

    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException {
        AssetFileDescriptor openAssetFileDescriptor;
        String scheme = uri.getScheme();
        String path = uri.getPath();
        if ((scheme == null || scheme.equals("file")) && path != null) {
            setDataSource(path);
            return;
        }
        try {
            openAssetFileDescriptor = context.getContentResolver().openAssetFileDescriptor(uri, "r");
        } catch (FileNotFoundException | SecurityException unused) {
        }
        if (openAssetFileDescriptor != null) {
            setDataSource(openAssetFileDescriptor);
            if (openAssetFileDescriptor != null) {
                openAssetFileDescriptor.close();
                return;
            }
            return;
        }
        if (openAssetFileDescriptor != null) {
            openAssetFileDescriptor.close();
        }
        setDataSource(uri.toString(), map);
    }

    public void setDataSource(String str) throws IOException {
        setDataSource(str, (Map<String, String>) null);
    }

    public void setDataSource(String str, Map<String, String> map) throws IOException {
        this.httpRequestHeaders = map;
        prepareDataSource(this.dataSourceFactory.createDataSource(), buildDataSpec(Uri.parse(str), 0L));
    }

    public void setDataSource(MediaDataSource mediaDataSource) throws IOException {
        prepareDataSource(new MediaDataSourceAdapter(mediaDataSource, false), buildDataSpec(Uri.EMPTY, 0L));
    }

    private void prepareDataSource(DataSource dataSource, DataSpec dataSpec) throws IOException {
        int i;
        String str;
        Assertions.checkState(!this.hasBeenPrepared);
        this.hasBeenPrepared = true;
        this.offsetInCurrentFile = dataSpec.position;
        this.currentDataSource = dataSource;
        ExtractorInput defaultExtractorInput = new DefaultExtractorInput(this.currentDataSource, 0L, dataSource.open(dataSpec));
        Extractor selectExtractor = selectExtractor(defaultExtractorInput);
        Throwable e = null;
        selectExtractor.init(new ExtractorOutputImpl());
        boolean z = true;
        while (z) {
            try {
                i = selectExtractor.read(defaultExtractorInput, this.positionHolder);
            } catch (Exception | OutOfMemoryError e2) {
                e = e2;
                i = -1;
            }
            boolean z2 = !this.tracksEnded || this.upstreamFormatsCount < this.sampleQueues.size() || this.seekMap == null;
            if (e != null || (z2 && i == -1)) {
                release();
                if (e != null) {
                    str = "Exception encountered while parsing input media.";
                } else {
                    str = "Reached end of input before preparation completed.";
                }
                throw ParserException.createForMalformedContainer(str, e);
            }
            if (i == 1) {
                defaultExtractorInput = reopenCurrentDataSource(this.positionHolder.position);
            }
            z = z2;
        }
        this.currentExtractorInput = defaultExtractorInput;
        this.currentExtractor = selectExtractor;
    }

    public void release() {
        for (int i = 0; i < this.sampleQueues.size(); i++) {
            this.sampleQueues.valueAt(i).release();
        }
        this.sampleQueues.clear();
        Extractor extractor = this.currentExtractor;
        if (extractor != null) {
            extractor.release();
            this.currentExtractor = null;
        }
        this.currentExtractorInput = null;
        this.pendingSeek = null;
        DataSourceUtil.closeQuietly(this.currentDataSource);
        this.currentDataSource = null;
    }

    public int getTrackCount() {
        return this.tracks.size();
    }

    public MediaFormat getTrackFormat(int i) {
        MediaExtractorTrack mediaExtractorTrack = this.tracks.get(i);
        MediaFormat createDownstreamMediaFormat = mediaExtractorTrack.createDownstreamMediaFormat(this.formatHolder, this.sampleHolderWithBufferReplacementDisabled);
        long j = mediaExtractorTrack.sampleQueue.trackDurationUs;
        if (j != C.TIME_UNSET) {
            createDownstreamMediaFormat.setLong("durationUs", j);
            return createDownstreamMediaFormat;
        }
        SeekMap seekMap = this.seekMap;
        if (seekMap != null && seekMap.getDurationUs() != C.TIME_UNSET) {
            createDownstreamMediaFormat.setLong("durationUs", this.seekMap.getDurationUs());
        }
        return createDownstreamMediaFormat;
    }

    public void selectTrack(int i) {
        this.selectedTrackIndices.add(Integer.valueOf(i));
    }

    public void unselectTrack(int i) {
        this.selectedTrackIndices.remove(Integer.valueOf(i));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007a A[LOOP:0: B:24:0x0072->B:26:0x007a, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void seekTo(long j, int i) {
        SeekMap.SeekPoints seekPoints;
        SeekPoint seekPoint;
        int i2;
        if (this.seekMap == null) {
            return;
        }
        if (this.selectedTrackIndices.size() == 1) {
            Extractor extractor = this.currentExtractor;
            if (extractor instanceof Mp4Extractor) {
                seekPoints = ((Mp4Extractor) extractor).getSeekPoints(j, this.tracks.get(this.selectedTrackIndices.iterator().next().intValue()).getIdOfBackingTrack());
                if (i != 0) {
                    seekPoint = seekPoints.first;
                } else if (i == 1) {
                    seekPoint = seekPoints.second;
                } else if (i == 2) {
                    if (Math.abs(j - seekPoints.second.timeUs) < Math.abs(j - seekPoints.first.timeUs)) {
                        seekPoint = seekPoints.second;
                    } else {
                        seekPoint = seekPoints.first;
                    }
                } else {
                    throw new IllegalArgumentException();
                }
                this.sampleMetadataQueue.clear();
                for (i2 = 0; i2 < this.sampleQueues.size(); i2++) {
                    this.sampleQueues.valueAt(i2).reset();
                }
                this.pendingSeek = seekPoint;
            }
        }
        seekPoints = this.seekMap.getSeekPoints(j);
        if (i != 0) {
        }
        this.sampleMetadataQueue.clear();
        while (i2 < this.sampleQueues.size()) {
        }
        this.pendingSeek = seekPoint;
    }

    public boolean advance() {
        if (advanceToSampleOrEndOfInput()) {
            skipOneSample();
            return advanceToSampleOrEndOfInput();
        }
        return false;
    }

    public int readSampleData(ByteBuffer byteBuffer, int i) {
        if (advanceToSampleOrEndOfInput()) {
            byteBuffer.position(i);
            byteBuffer.limit(byteBuffer.capacity());
            this.sampleHolderWithBufferReplacementDisabled.data = byteBuffer;
            peekNextSelectedTrackSample(this.sampleHolderWithBufferReplacementDisabled);
            byteBuffer.flip();
            byteBuffer.position(i);
            this.sampleHolderWithBufferReplacementDisabled.data = null;
            return byteBuffer.remaining();
        }
        return -1;
    }

    public int getSampleTrackIndex() {
        if (advanceToSampleOrEndOfInput()) {
            return this.sampleMetadataQueue.peekFirst().trackIndex;
        }
        return -1;
    }

    public long getSampleSize() {
        if (advanceToSampleOrEndOfInput()) {
            peekNextSelectedTrackSample(this.sampleHolderWithBufferReplacementEnabled);
            ByteBuffer byteBuffer = (ByteBuffer) Assertions.checkNotNull(this.sampleHolderWithBufferReplacementEnabled.data);
            int position = byteBuffer.position();
            byteBuffer.position(0);
            return position;
        }
        return -1L;
    }

    public long getSampleTime() {
        if (advanceToSampleOrEndOfInput()) {
            return this.sampleMetadataQueue.peekFirst().timeUs;
        }
        return -1L;
    }

    public int getSampleFlags() {
        if (advanceToSampleOrEndOfInput()) {
            return this.sampleMetadataQueue.peekFirst().flags;
        }
        return -1;
    }

    public boolean getSampleCryptoInfo(MediaCodec.CryptoInfo cryptoInfo) {
        if (advanceToSampleOrEndOfInput() && (this.sampleMetadataQueue.peekFirst().flags & 2) != 0) {
            peekNextSelectedTrackSample(this.sampleHolderWithBufferReplacementEnabled);
            populatePlatformCryptoInfoParameters(cryptoInfo);
            return true;
        }
        return false;
    }

    private void populatePlatformCryptoInfoParameters(MediaCodec.CryptoInfo cryptoInfo) {
        MediaCodec.CryptoInfo frameworkCryptoInfo = ((CryptoInfo) Assertions.checkNotNull(this.sampleHolderWithBufferReplacementEnabled.cryptoInfo)).getFrameworkCryptoInfo();
        cryptoInfo.numSubSamples = frameworkCryptoInfo.numSubSamples;
        cryptoInfo.numBytesOfClearData = frameworkCryptoInfo.numBytesOfClearData;
        cryptoInfo.numBytesOfEncryptedData = frameworkCryptoInfo.numBytesOfEncryptedData;
        cryptoInfo.key = frameworkCryptoInfo.key;
        cryptoInfo.iv = frameworkCryptoInfo.iv;
        cryptoInfo.mode = frameworkCryptoInfo.mode;
    }

    public void setLogSessionId(LogSessionId logSessionId) {
        if (logSessionId.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
            return;
        }
        this.logSessionId = logSessionId;
    }

    public LogSessionId getLogSessionId() {
        LogSessionId logSessionId = this.logSessionId;
        return logSessionId != null ? logSessionId : LogSessionId.LOG_SESSION_ID_NONE;
    }

    public DrmInitData getDrmInitData() {
        for (int i = 0; i < this.tracks.size(); i++) {
            Format format = this.tracks.get(i).getFormat(this.formatHolder, this.sampleHolderWithBufferReplacementDisabled);
            if (format.drmInitData != null) {
                return format.drmInitData;
            }
        }
        return null;
    }

    public long getCachedDuration() {
        if (advanceToSampleOrEndOfInput()) {
            long j = Long.MIN_VALUE;
            long j2 = Long.MIN_VALUE;
            for (int i = 0; i < this.tracks.size(); i++) {
                MediaExtractorSampleQueue mediaExtractorSampleQueue = this.tracks.get(i).sampleQueue;
                j2 = Math.max(j2, mediaExtractorSampleQueue.getLargestReadTimestampUs());
                j = Math.max(j, mediaExtractorSampleQueue.getLargestQueuedTimestampUs());
            }
            Assertions.checkState(j != Long.MIN_VALUE);
            if (j2 == j) {
                return 0L;
            }
            return (j - (j2 != Long.MIN_VALUE ? j2 : 0L)) + 10000;
        }
        return 0L;
    }

    public boolean hasCacheReachedEndOfStream() {
        return getCachedDuration() == 0;
    }

    public PersistableBundle getMetrics() {
        PersistableBundle persistableBundle = new PersistableBundle();
        Extractor extractor = this.currentExtractor;
        if (extractor != null) {
            persistableBundle.putString("android.media.mediaextractor.fmt", extractor.getUnderlyingImplementation().getClass().getSimpleName());
        }
        if (!this.tracks.isEmpty()) {
            Format format = this.tracks.get(0).getFormat(this.formatHolder, this.sampleHolderWithBufferReplacementDisabled);
            if (format.containerMimeType != null) {
                persistableBundle.putString("android.media.mediaextractor.mime", format.containerMimeType);
            }
        }
        persistableBundle.putInt("android.media.mediaextractor.ntrk", this.tracks.size());
        return persistableBundle;
    }

    public Map<UUID, byte[]> getPsshInfo() {
        PsshAtomUtil.PsshAtom parsePsshAtom;
        DrmInitData drmInitData = getDrmInitData();
        if (drmInitData == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < drmInitData.schemeDataCount; i++) {
            DrmInitData.SchemeData schemeData = drmInitData.get(i);
            if (schemeData.data != null && (parsePsshAtom = PsshAtomUtil.parsePsshAtom(schemeData.data)) != null) {
                hashMap.put(parsePsshAtom.uuid, parsePsshAtom.schemeData);
            }
        }
        if (hashMap.isEmpty()) {
            return null;
        }
        return hashMap;
    }

    public Allocator getAllocator() {
        return this.allocator;
    }

    private void peekNextSelectedTrackSample(DecoderInputBuffer decoderInputBuffer) {
        MediaExtractorSampleQueue mediaExtractorSampleQueue = this.tracks.get(((SampleMetadataQueue.SampleMetadata) Assertions.checkNotNull(this.sampleMetadataQueue.peekFirst())).trackIndex).sampleQueue;
        int read = mediaExtractorSampleQueue.read(this.formatHolder, decoderInputBuffer, 1, false);
        if (read == -5) {
            read = mediaExtractorSampleQueue.read(this.formatHolder, decoderInputBuffer, 1, false);
        }
        this.formatHolder.clear();
        Assertions.checkState(read == -4);
    }

    private Extractor selectExtractor(ExtractorInput extractorInput) throws IOException {
        Extractor extractor;
        Extractor[] createExtractors = this.extractorsFactory.createExtractors();
        int length = createExtractors.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                extractor = null;
                break;
            }
            extractor = createExtractors[i];
            try {
            } catch (EOFException unused) {
            } catch (Throwable th) {
                extractorInput.resetPeekPosition();
                throw th;
            }
            if (extractor.sniff(extractorInput)) {
                extractorInput.resetPeekPosition();
                break;
            }
            extractorInput.resetPeekPosition();
            i++;
        }
        if (extractor != null) {
            return extractor;
        }
        throw new UnrecognizedInputFormatException("None of the available extractors (" + Joiner.on(", ").join(Lists.transform(ImmutableList.copyOf(createExtractors), new Function() { // from class: androidx.media3.exoplayer.MediaExtractorCompat$$ExternalSyntheticLambda0
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                String simpleName;
                simpleName = ((Extractor) obj).getUnderlyingImplementation().getClass().getSimpleName();
                return simpleName;
            }
        })) + ") could read the stream.", (Uri) Assertions.checkNotNull(((DataSource) Assertions.checkNotNull(this.currentDataSource)).getUri()), ImmutableList.of());
    }

    @EnsuresNonNullIf(expression = {"sampleMetadataQueue.peekFirst()"}, result = true)
    private boolean advanceToSampleOrEndOfInput() {
        int read;
        try {
            maybeResolvePendingSeek();
            boolean z = false;
            while (true) {
                if (this.sampleMetadataQueue.isEmpty()) {
                    if (z) {
                        return false;
                    }
                    try {
                        read = ((Extractor) Assertions.checkNotNull(this.currentExtractor)).read((ExtractorInput) Assertions.checkNotNull(this.currentExtractorInput), this.positionHolder);
                    } catch (Exception | OutOfMemoryError e) {
                        Log.w(TAG, "Treating exception as the end of input.", e);
                    }
                    if (read == -1) {
                        z = true;
                    } else if (read == 1) {
                        this.currentExtractorInput = reopenCurrentDataSource(this.positionHolder.position);
                    }
                } else if (this.selectedTrackIndices.contains(Integer.valueOf(((SampleMetadataQueue.SampleMetadata) Assertions.checkNotNull(this.sampleMetadataQueue.peekFirst())).trackIndex))) {
                    return true;
                } else {
                    skipOneSample();
                }
            }
        } catch (IOException e2) {
            Log.w(TAG, "Treating exception as the end of input.", e2);
            return false;
        }
    }

    private void skipOneSample() {
        MediaExtractorTrack mediaExtractorTrack = this.tracks.get(this.sampleMetadataQueue.removeFirst().trackIndex);
        if (mediaExtractorTrack.isCompatibilityTrack) {
            return;
        }
        mediaExtractorTrack.discardFrontSample();
    }

    private ExtractorInput reopenCurrentDataSource(long j) throws IOException {
        DataSource dataSource = (DataSource) Assertions.checkNotNull(this.currentDataSource);
        DataSourceUtil.closeQuietly(dataSource);
        long open = dataSource.open(buildDataSpec((Uri) Assertions.checkNotNull(dataSource.getUri()), this.offsetInCurrentFile + j));
        if (open != -1) {
            open += j;
        }
        return new DefaultExtractorInput(dataSource, j, open);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSampleQueueFormatInitialized(MediaExtractorSampleQueue mediaExtractorSampleQueue, Format format) {
        this.upstreamFormatsCount++;
        mediaExtractorSampleQueue.setMainTrackIndex(this.tracks.size());
        this.tracks.add(new MediaExtractorTrack(mediaExtractorSampleQueue, false, null));
        String alternativeCodecMimeType = MediaCodecUtil.getAlternativeCodecMimeType(format);
        if (alternativeCodecMimeType != null) {
            mediaExtractorSampleQueue.setCompatibilityTrackIndex(this.tracks.size());
            this.tracks.add(new MediaExtractorTrack(mediaExtractorSampleQueue, true, alternativeCodecMimeType));
        }
    }

    private void maybeResolvePendingSeek() throws IOException {
        SeekPoint seekPoint = this.pendingSeek;
        if (seekPoint == null) {
            return;
        }
        SeekPoint seekPoint2 = (SeekPoint) Assertions.checkNotNull(seekPoint);
        ((Extractor) Assertions.checkNotNull(this.currentExtractor)).seek(seekPoint2.position, seekPoint2.timeUs);
        this.currentExtractorInput = reopenCurrentDataSource(seekPoint2.position);
        this.pendingSeek = null;
    }

    private DataSpec buildDataSpec(Uri uri, long j) {
        DataSpec.Builder flags = new DataSpec.Builder().setUri(uri).setPosition(j).setFlags(6);
        Map<String, String> map = this.httpRequestHeaders;
        if (map != null) {
            flags.setHttpRequestHeaders(map);
        }
        return flags.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class ExtractorOutputImpl implements ExtractorOutput {
        private ExtractorOutputImpl() {
        }

        @Override // androidx.media3.extractor.ExtractorOutput
        public TrackOutput track(int i, int i2) {
            MediaExtractorSampleQueue mediaExtractorSampleQueue = (MediaExtractorSampleQueue) MediaExtractorCompat.this.sampleQueues.get(i);
            if (mediaExtractorSampleQueue != null) {
                return mediaExtractorSampleQueue;
            }
            if (MediaExtractorCompat.this.tracksEnded) {
                return new DiscardingTrackOutput();
            }
            MediaExtractorCompat mediaExtractorCompat = MediaExtractorCompat.this;
            MediaExtractorSampleQueue mediaExtractorSampleQueue2 = new MediaExtractorSampleQueue(mediaExtractorCompat.allocator, i);
            MediaExtractorCompat.this.sampleQueues.put(i, mediaExtractorSampleQueue2);
            return mediaExtractorSampleQueue2;
        }

        @Override // androidx.media3.extractor.ExtractorOutput
        public void endTracks() {
            MediaExtractorCompat.this.tracksEnded = true;
        }

        @Override // androidx.media3.extractor.ExtractorOutput
        public void seekMap(SeekMap seekMap) {
            MediaExtractorCompat.this.seekMap = seekMap;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class MediaExtractorTrack {
        public final String compatibilityTrackMimeType;
        public final boolean isCompatibilityTrack;
        public final MediaExtractorSampleQueue sampleQueue;

        private MediaExtractorTrack(MediaExtractorSampleQueue mediaExtractorSampleQueue, boolean z, String str) {
            this.sampleQueue = mediaExtractorSampleQueue;
            this.isCompatibilityTrack = z;
            this.compatibilityTrackMimeType = str;
        }

        public MediaFormat createDownstreamMediaFormat(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer) {
            MediaFormat createMediaFormatFromFormat = MediaFormatUtil.createMediaFormatFromFormat(getFormat(formatHolder, decoderInputBuffer));
            if (this.compatibilityTrackMimeType != null) {
                if (Util.SDK_INT >= 29) {
                    createMediaFormatFromFormat.removeKey("codecs-string");
                }
                createMediaFormatFromFormat.setString("mime", this.compatibilityTrackMimeType);
            }
            return createMediaFormatFromFormat;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Format getFormat(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer) {
            formatHolder.clear();
            this.sampleQueue.read(formatHolder, decoderInputBuffer, 2, false);
            Format format = (Format) Assertions.checkNotNull(formatHolder.format);
            formatHolder.clear();
            return format;
        }

        public void discardFrontSample() {
            this.sampleQueue.skip(1);
            this.sampleQueue.discardToRead();
        }

        public int getIdOfBackingTrack() {
            return this.sampleQueue.trackId;
        }

        public String toString() {
            return String.format("MediaExtractorSampleQueue: %s, isCompatibilityTrack: %s, compatibilityTrackMimeType: %s", this.sampleQueue, Boolean.valueOf(this.isCompatibilityTrack), this.compatibilityTrackMimeType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class MediaExtractorSampleQueue extends SampleQueue {
        private int compatibilityTrackIndex;
        private int mainTrackIndex;
        public long trackDurationUs;
        public final int trackId;

        public MediaExtractorSampleQueue(Allocator allocator, int i) {
            super(allocator, null, null);
            this.trackId = i;
            this.trackDurationUs = C.TIME_UNSET;
            this.mainTrackIndex = -1;
            this.compatibilityTrackIndex = -1;
        }

        public void setMainTrackIndex(int i) {
            this.mainTrackIndex = i;
        }

        public void setCompatibilityTrackIndex(int i) {
            this.compatibilityTrackIndex = i;
        }

        @Override // androidx.media3.extractor.TrackOutput
        public void durationUs(long j) {
            this.trackDurationUs = j;
            super.durationUs(j);
        }

        @Override // androidx.media3.exoplayer.source.SampleQueue
        public Format getAdjustedUpstreamFormat(Format format) {
            if (getUpstreamFormat() == null) {
                MediaExtractorCompat.this.onSampleQueueFormatInitialized(this, format);
            }
            return super.getAdjustedUpstreamFormat(format);
        }

        @Override // androidx.media3.exoplayer.source.SampleQueue, androidx.media3.extractor.TrackOutput
        public void sampleMetadata(long j, int i, int i2, int i3, TrackOutput.CryptoData cryptoData) {
            int i4 = i & (-536870913);
            Assertions.checkState(this.mainTrackIndex != -1);
            int writeIndex = getWriteIndex();
            super.sampleMetadata(j, i4, i2, i3, cryptoData);
            if (getWriteIndex() == writeIndex + 1) {
                queueSampleMetadata(j, i4);
            }
        }

        public String toString() {
            return String.format("trackId: %s, mainTrackIndex: %s, compatibilityTrackIndex: %s", Integer.valueOf(this.trackId), Integer.valueOf(this.mainTrackIndex), Integer.valueOf(this.compatibilityTrackIndex));
        }

        private void queueSampleMetadata(long j, int i) {
            int i2 = ((1073741824 & i) != 0 ? 2 : 0) | ((i & 1) != 0 ? 1 : 0);
            if (this.compatibilityTrackIndex != -1) {
                MediaExtractorCompat.this.sampleMetadataQueue.addLast(j, i2, this.compatibilityTrackIndex);
            }
            MediaExtractorCompat.this.sampleMetadataQueue.addLast(j, i2, this.mainTrackIndex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class SampleMetadataQueue {
        private final ArrayDeque<SampleMetadata> sampleMetadataPool = new ArrayDeque<>();
        private final ArrayDeque<SampleMetadata> sampleMetadataQueue = new ArrayDeque<>();

        public void addLast(long j, int i, int i2) {
            this.sampleMetadataQueue.addLast(obtainSampleMetadata(j, i, i2));
        }

        public SampleMetadata removeFirst() {
            SampleMetadata removeFirst = this.sampleMetadataQueue.removeFirst();
            this.sampleMetadataPool.push(removeFirst);
            return removeFirst;
        }

        public SampleMetadata peekFirst() {
            return this.sampleMetadataQueue.peekFirst();
        }

        public void clear() {
            Iterator<SampleMetadata> it = this.sampleMetadataQueue.iterator();
            while (it.hasNext()) {
                this.sampleMetadataPool.push(it.next());
            }
            this.sampleMetadataQueue.clear();
        }

        public boolean isEmpty() {
            return this.sampleMetadataQueue.isEmpty();
        }

        private SampleMetadata obtainSampleMetadata(long j, int i, int i2) {
            SampleMetadata pop;
            if (this.sampleMetadataPool.isEmpty()) {
                pop = new SampleMetadata(j, i, i2);
            } else {
                pop = this.sampleMetadataPool.pop();
            }
            pop.set(j, i, i2);
            return pop;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public static final class SampleMetadata {
            public int flags;
            public long timeUs;
            public int trackIndex;

            public SampleMetadata(long j, int i, int i2) {
                set(j, i, i2);
            }

            public void set(long j, int i, int i2) {
                this.timeUs = j;
                this.flags = i;
                this.trackIndex = i2;
            }
        }
    }
}
