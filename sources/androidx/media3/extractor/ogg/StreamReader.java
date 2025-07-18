package androidx.media3.extractor.ogg;

import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import java.io.IOException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class StreamReader {
    private static final int STATE_END_OF_INPUT = 3;
    private static final int STATE_READ_HEADERS = 0;
    private static final int STATE_READ_PAYLOAD = 2;
    private static final int STATE_SKIP_HEADERS = 1;
    private long currentGranule;
    private ExtractorOutput extractorOutput;
    private boolean formatSet;
    private long lengthOfReadPacket;
    private OggSeeker oggSeeker;
    private long payloadStartPosition;
    private int sampleRate;
    private boolean seekMapSet;
    private int state;
    private long targetGranule;
    private TrackOutput trackOutput;
    private final OggPacket oggPacket = new OggPacket();
    private SetupData setupData = new SetupData();

    protected abstract long preparePayload(ParsableByteArray parsableByteArray);

    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    protected abstract boolean readHeaders(ParsableByteArray parsableByteArray, long j, SetupData setupData) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class SetupData {
        Format format;
        OggSeeker oggSeeker;

        SetupData() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init(ExtractorOutput extractorOutput, TrackOutput trackOutput) {
        this.extractorOutput = extractorOutput;
        this.trackOutput = trackOutput;
        reset(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reset(boolean z) {
        if (z) {
            this.setupData = new SetupData();
            this.payloadStartPosition = 0L;
            this.state = 0;
        } else {
            this.state = 1;
        }
        this.targetGranule = -1L;
        this.currentGranule = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void seek(long j, long j2) {
        this.oggPacket.reset();
        if (j == 0) {
            reset(!this.seekMapSet);
        } else if (this.state != 0) {
            this.targetGranule = convertTimeToGranule(j2);
            ((OggSeeker) Util.castNonNull(this.oggSeeker)).startSeek(this.targetGranule);
            this.state = 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        assertInitialized();
        int i = this.state;
        if (i != 0) {
            if (i == 1) {
                extractorInput.skipFully((int) this.payloadStartPosition);
                this.state = 2;
                return 0;
            } else if (i == 2) {
                Util.castNonNull(this.oggSeeker);
                return readPayload(extractorInput, positionHolder);
            } else if (i == 3) {
                return -1;
            } else {
                throw new IllegalStateException();
            }
        }
        return readHeadersAndUpdateState(extractorInput);
    }

    @EnsuresNonNull({"trackOutput", "extractorOutput"})
    private void assertInitialized() {
        Assertions.checkStateNotNull(this.trackOutput);
        Util.castNonNull(this.extractorOutput);
    }

    @EnsuresNonNullIf(expression = {"setupData.format"}, result = true)
    private boolean readHeaders(ExtractorInput extractorInput) throws IOException {
        while (this.oggPacket.populate(extractorInput)) {
            this.lengthOfReadPacket = extractorInput.getPosition() - this.payloadStartPosition;
            if (!readHeaders(this.oggPacket.getPayload(), this.payloadStartPosition, this.setupData)) {
                return true;
            }
            this.payloadStartPosition = extractorInput.getPosition();
        }
        this.state = 3;
        return false;
    }

    @RequiresNonNull({"trackOutput"})
    private int readHeadersAndUpdateState(ExtractorInput extractorInput) throws IOException {
        if (readHeaders(extractorInput)) {
            this.sampleRate = this.setupData.format.sampleRate;
            if (!this.formatSet) {
                this.trackOutput.format(this.setupData.format);
                this.formatSet = true;
            }
            if (this.setupData.oggSeeker != null) {
                this.oggSeeker = this.setupData.oggSeeker;
            } else if (extractorInput.getLength() == -1) {
                this.oggSeeker = new UnseekableOggSeeker();
            } else {
                OggPageHeader pageHeader = this.oggPacket.getPageHeader();
                this.oggSeeker = new DefaultOggSeeker(this, this.payloadStartPosition, extractorInput.getLength(), pageHeader.headerSize + pageHeader.bodySize, pageHeader.granulePosition, (pageHeader.type & 4) != 0);
            }
            this.state = 2;
            this.oggPacket.trimPayload();
            return 0;
        }
        return -1;
    }

    @RequiresNonNull({"trackOutput", "oggSeeker", "extractorOutput"})
    private int readPayload(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        long read = this.oggSeeker.read(extractorInput);
        if (read >= 0) {
            positionHolder.position = read;
            return 1;
        }
        if (read < -1) {
            onSeekEnd(-(read + 2));
        }
        if (!this.seekMapSet) {
            SeekMap seekMap = (SeekMap) Assertions.checkStateNotNull(this.oggSeeker.createSeekMap());
            this.extractorOutput.seekMap(seekMap);
            this.trackOutput.durationUs(seekMap.getDurationUs());
            this.seekMapSet = true;
        }
        if (this.lengthOfReadPacket > 0 || this.oggPacket.populate(extractorInput)) {
            this.lengthOfReadPacket = 0L;
            ParsableByteArray payload = this.oggPacket.getPayload();
            long preparePayload = preparePayload(payload);
            if (preparePayload >= 0) {
                long j = this.currentGranule;
                if (j + preparePayload >= this.targetGranule) {
                    long convertGranuleToTime = convertGranuleToTime(j);
                    this.trackOutput.sampleData(payload, payload.limit());
                    this.trackOutput.sampleMetadata(convertGranuleToTime, 1, payload.limit(), 0, null);
                    this.targetGranule = -1L;
                }
            }
            this.currentGranule += preparePayload;
            return 0;
        }
        this.state = 3;
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long convertGranuleToTime(long j) {
        return (j * 1000000) / this.sampleRate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long convertTimeToGranule(long j) {
        return (this.sampleRate * j) / 1000000;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSeekEnd(long j) {
        this.currentGranule = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class UnseekableOggSeeker implements OggSeeker {
        @Override // androidx.media3.extractor.ogg.OggSeeker
        public long read(ExtractorInput extractorInput) {
            return -1L;
        }

        @Override // androidx.media3.extractor.ogg.OggSeeker
        public void startSeek(long j) {
        }

        private UnseekableOggSeeker() {
        }

        @Override // androidx.media3.extractor.ogg.OggSeeker
        public SeekMap createSeekMap() {
            return new SeekMap.Unseekable(C.TIME_UNSET);
        }
    }
}
