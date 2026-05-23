package androidx.media3.extractor.text;

import androidx.media3.common.C;
import androidx.media3.common.DataReader;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.text.SubtitleParser;
import com.google.common.base.Preconditions;
import java.io.EOFException;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class SubtitleTranscodingTrackOutput implements TrackOutput {
    private static final String TAG = "SubtitleTranscodingTO";
    private Format currentFormat;
    private SubtitleParser currentSubtitleParser;
    private final TrackOutput delegate;
    private boolean shouldSuppressParsingErrors;
    private final SubtitleParser.Factory subtitleParserFactory;
    private final CueEncoder cueEncoder = new CueEncoder();
    private int sampleDataStart = 0;
    private int sampleDataEnd = 0;
    private byte[] sampleData = Util.EMPTY_BYTE_ARRAY;
    private final ParsableByteArray parsableScratch = new ParsableByteArray();

    public SubtitleTranscodingTrackOutput(TrackOutput trackOutput, SubtitleParser.Factory factory) {
        this.delegate = trackOutput;
        this.subtitleParserFactory = factory;
    }

    public void resetSubtitleParser() {
        SubtitleParser subtitleParser = this.currentSubtitleParser;
        if (subtitleParser != null) {
            subtitleParser.reset();
        }
    }

    public void shouldSuppressParsingErrors(boolean z) {
        this.shouldSuppressParsingErrors = z;
    }

    @Override // androidx.media3.extractor.TrackOutput
    public void format(Format format) {
        Preconditions.checkNotNull(format.sampleMimeType);
        Preconditions.checkArgument(MimeTypes.getTrackType(format.sampleMimeType) == 3);
        if (!format.equals(this.currentFormat)) {
            this.currentFormat = format;
            this.currentSubtitleParser = this.subtitleParserFactory.supportsFormat(format) ? this.subtitleParserFactory.create(format) : null;
        }
        SubtitleParser subtitleParser = this.currentSubtitleParser;
        TrackOutput trackOutput = this.delegate;
        if (subtitleParser == null) {
            trackOutput.format(format);
        } else {
            trackOutput.format(format.buildUpon().setSampleMimeType(MimeTypes.APPLICATION_MEDIA3_CUES).setCodecs(format.sampleMimeType).setSubsampleOffsetUs(Long.MAX_VALUE).setCueReplacementBehavior(this.subtitleParserFactory.getCueReplacementBehavior(format)).build());
        }
    }

    @Override // androidx.media3.extractor.TrackOutput
    public int sampleData(DataReader dataReader, int i, boolean z, int i2) throws IOException {
        if (this.currentSubtitleParser == null) {
            return this.delegate.sampleData(dataReader, i, z, i2);
        }
        ensureSampleDataCapacity(i);
        int read = dataReader.read(this.sampleData, this.sampleDataEnd, i);
        if (read != -1) {
            this.sampleDataEnd += read;
            return read;
        } else if (z) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    @Override // androidx.media3.extractor.TrackOutput
    public void sampleData(ParsableByteArray parsableByteArray, int i, int i2) {
        if (this.currentSubtitleParser == null) {
            this.delegate.sampleData(parsableByteArray, i, i2);
            return;
        }
        ensureSampleDataCapacity(i);
        parsableByteArray.readBytes(this.sampleData, this.sampleDataEnd, i);
        this.sampleDataEnd += i;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    @Override // androidx.media3.extractor.TrackOutput
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void sampleMetadata(final long j, final int i, int i2, int i3, TrackOutput.CryptoData cryptoData) {
        int i4;
        int i5;
        if (this.currentSubtitleParser == null) {
            this.delegate.sampleMetadata(j, i, i2, i3, cryptoData);
            return;
        }
        Preconditions.checkArgument(cryptoData == null, "DRM on subtitles is not supported");
        int i6 = (this.sampleDataEnd - i3) - i2;
        try {
            i4 = i6;
            try {
                this.currentSubtitleParser.parse(this.sampleData, i4, i2, SubtitleParser.OutputOptions.allCues(), new Consumer() { // from class: androidx.media3.extractor.text.SubtitleTranscodingTrackOutput$$ExternalSyntheticLambda0
                    @Override // androidx.media3.common.util.Consumer
                    public final void accept(Object obj) {
                        SubtitleTranscodingTrackOutput.this.m8968xa18018cd(j, i, (CuesWithTiming) obj);
                    }
                });
            } catch (RuntimeException e) {
                e = e;
                RuntimeException runtimeException = e;
                if (this.shouldSuppressParsingErrors) {
                    Log.w(TAG, "Parsing subtitles failed, ignoring sample.", runtimeException);
                    i5 = i4 + i2;
                    this.sampleDataStart = i5;
                    if (i5 != this.sampleDataEnd) {
                    }
                } else {
                    throw runtimeException;
                }
            }
        } catch (RuntimeException e2) {
            e = e2;
            i4 = i6;
        }
        i5 = i4 + i2;
        this.sampleDataStart = i5;
        if (i5 != this.sampleDataEnd) {
            this.sampleDataStart = 0;
            this.sampleDataEnd = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: outputSample */
    public void m8968xa18018cd(CuesWithTiming cuesWithTiming, long j, int i) {
        Preconditions.checkNotNull(this.currentFormat);
        byte[] encode = this.cueEncoder.encode(cuesWithTiming.cues, cuesWithTiming.durationUs);
        this.parsableScratch.reset(encode);
        this.delegate.sampleData(this.parsableScratch, encode.length);
        int i2 = (cuesWithTiming.startTimeUs > C.TIME_UNSET ? 1 : (cuesWithTiming.startTimeUs == C.TIME_UNSET ? 0 : -1));
        Format format = this.currentFormat;
        if (i2 == 0) {
            Preconditions.checkState(format.subsampleOffsetUs == Long.MAX_VALUE);
        } else if (format.subsampleOffsetUs == Long.MAX_VALUE) {
            j += cuesWithTiming.startTimeUs;
        } else {
            j = cuesWithTiming.startTimeUs + this.currentFormat.subsampleOffsetUs;
        }
        this.delegate.sampleMetadata(j, i | 1, encode.length, 0, null);
    }

    private void ensureSampleDataCapacity(int i) {
        int length = this.sampleData.length;
        int i2 = this.sampleDataEnd;
        if (length - i2 >= i) {
            return;
        }
        int i3 = i2 - this.sampleDataStart;
        int max = Math.max(i3 * 2, i + i3);
        byte[] bArr = this.sampleData;
        byte[] bArr2 = max <= bArr.length ? bArr : new byte[max];
        System.arraycopy(bArr, this.sampleDataStart, bArr2, 0, i3);
        this.sampleDataStart = 0;
        this.sampleDataEnd = i3;
        this.sampleData = bArr2;
    }
}
