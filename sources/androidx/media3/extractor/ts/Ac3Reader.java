package androidx.media3.extractor.ts;

import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.Ac3Util;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;
import com.google.common.base.Ascii;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
/* loaded from: classes2.dex */
public final class Ac3Reader implements ElementaryStreamReader {
    private static final int HEADER_SIZE = 128;
    private static final int STATE_FINDING_SYNC = 0;
    private static final int STATE_READING_HEADER = 1;
    private static final int STATE_READING_SAMPLE = 2;
    private int bytesRead;
    private final String containerMimeType;
    private Format format;
    private String formatId;
    private final ParsableBitArray headerScratchBits;
    private final ParsableByteArray headerScratchBytes;
    private final String language;
    private boolean lastByteWas0B;
    private TrackOutput output;
    private final int roleFlags;
    private long sampleDurationUs;
    private int sampleSize;
    private int state;
    private long timeUs;

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void packetFinished(boolean z) {
    }

    public Ac3Reader(String str) {
        this(null, 0, str);
    }

    public Ac3Reader(String str, int i, String str2) {
        ParsableBitArray parsableBitArray = new ParsableBitArray(new byte[128]);
        this.headerScratchBits = parsableBitArray;
        this.headerScratchBytes = new ParsableByteArray(parsableBitArray.data);
        this.state = 0;
        this.timeUs = C.TIME_UNSET;
        this.language = str;
        this.roleFlags = i;
        this.containerMimeType = str2;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void seek() {
        this.state = 0;
        this.bytesRead = 0;
        this.lastByteWas0B = false;
        this.timeUs = C.TIME_UNSET;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.formatId = trackIdGenerator.getFormatId();
        this.output = extractorOutput.track(trackIdGenerator.getTrackId(), 1);
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void packetStarted(long j, int i) {
        this.timeUs = j;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void consume(ParsableByteArray parsableByteArray) {
        Assertions.checkStateNotNull(this.output);
        while (parsableByteArray.bytesLeft() > 0) {
            int i = this.state;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        int min = Math.min(parsableByteArray.bytesLeft(), this.sampleSize - this.bytesRead);
                        this.output.sampleData(parsableByteArray, min);
                        int i2 = this.bytesRead + min;
                        this.bytesRead = i2;
                        if (i2 == this.sampleSize) {
                            Assertions.checkState(this.timeUs != C.TIME_UNSET);
                            this.output.sampleMetadata(this.timeUs, 1, this.sampleSize, 0, null);
                            this.timeUs += this.sampleDurationUs;
                            this.state = 0;
                        }
                    }
                } else if (continueRead(parsableByteArray, this.headerScratchBytes.getData(), 128)) {
                    parseHeader();
                    this.headerScratchBytes.setPosition(0);
                    this.output.sampleData(this.headerScratchBytes, 128);
                    this.state = 2;
                }
            } else if (skipToNextSync(parsableByteArray)) {
                this.state = 1;
                this.headerScratchBytes.getData()[0] = Ascii.VT;
                this.headerScratchBytes.getData()[1] = 119;
                this.bytesRead = 2;
            }
        }
    }

    private boolean continueRead(ParsableByteArray parsableByteArray, byte[] bArr, int i) {
        int min = Math.min(parsableByteArray.bytesLeft(), i - this.bytesRead);
        parsableByteArray.readBytes(bArr, this.bytesRead, min);
        int i2 = this.bytesRead + min;
        this.bytesRead = i2;
        return i2 == i;
    }

    private boolean skipToNextSync(ParsableByteArray parsableByteArray) {
        while (true) {
            if (parsableByteArray.bytesLeft() <= 0) {
                return false;
            }
            if (!this.lastByteWas0B) {
                this.lastByteWas0B = parsableByteArray.readUnsignedByte() == 11;
            } else {
                int readUnsignedByte = parsableByteArray.readUnsignedByte();
                if (readUnsignedByte == 119) {
                    this.lastByteWas0B = false;
                    return true;
                }
                this.lastByteWas0B = readUnsignedByte == 11;
            }
        }
    }

    @RequiresNonNull({"output"})
    private void parseHeader() {
        this.headerScratchBits.setPosition(0);
        Ac3Util.SyncFrameInfo parseAc3SyncframeInfo = Ac3Util.parseAc3SyncframeInfo(this.headerScratchBits);
        if (this.format == null || parseAc3SyncframeInfo.channelCount != this.format.channelCount || parseAc3SyncframeInfo.sampleRate != this.format.sampleRate || !Objects.equals(parseAc3SyncframeInfo.mimeType, this.format.sampleMimeType)) {
            Format.Builder peakBitrate = new Format.Builder().setId(this.formatId).setContainerMimeType(this.containerMimeType).setSampleMimeType(parseAc3SyncframeInfo.mimeType).setChannelCount(parseAc3SyncframeInfo.channelCount).setSampleRate(parseAc3SyncframeInfo.sampleRate).setLanguage(this.language).setRoleFlags(this.roleFlags).setPeakBitrate(parseAc3SyncframeInfo.bitrate);
            if (MimeTypes.AUDIO_AC3.equals(parseAc3SyncframeInfo.mimeType)) {
                peakBitrate.setAverageBitrate(parseAc3SyncframeInfo.bitrate);
            }
            Format build = peakBitrate.build();
            this.format = build;
            this.output.format(build);
        }
        this.sampleSize = parseAc3SyncframeInfo.frameSize;
        this.sampleDurationUs = (parseAc3SyncframeInfo.sampleCount * 1000000) / this.format.sampleRate;
    }
}
