package androidx.media3.extractor;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.container.NalUnitUtil;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes3.dex */
public final class VvcConfig {
    public final int bitdepthLuma;
    public final String codecs;
    public final List<byte[]> initializationData;
    public final int nalUnitLengthFieldLength;

    public static VvcConfig parse(ParsableByteArray parsableByteArray) throws ParserException {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        try {
            if (parsableByteArray.readInt() != 0) {
                throw ParserException.createForMalformedContainer("Unsupported VVC version", null);
            }
            int readUnsignedByte = parsableByteArray.readUnsignedByte();
            int i6 = 1;
            int i7 = ((readUnsignedByte >> 1) & 3) + 1;
            String str = "L";
            if ((readUnsignedByte & 1) != 0) {
                parsableByteArray.skipBytes(1);
                int readUnsignedByte2 = (parsableByteArray.readUnsignedByte() >> 4) & 7;
                i = (parsableByteArray.readUnsignedByte() >> 5) & 7;
                int readUnsignedByte3 = parsableByteArray.readUnsignedByte() & 63;
                int readUnsignedByte4 = parsableByteArray.readUnsignedByte();
                i3 = (readUnsignedByte4 >> 1) & 127;
                if ((readUnsignedByte4 & 1) != 0) {
                    str = "H";
                }
                i2 = parsableByteArray.readUnsignedByte();
                parsableByteArray.skipBytes(readUnsignedByte3);
                if (readUnsignedByte2 > 1) {
                    int readUnsignedByte5 = parsableByteArray.readUnsignedByte();
                    for (int i8 = 0; i8 < readUnsignedByte2 - 1; i8++) {
                        if (((readUnsignedByte5 >> (7 - i8)) & 1) != 0) {
                            parsableByteArray.skipBytes(1);
                        }
                    }
                }
                parsableByteArray.skipBytes(parsableByteArray.readUnsignedByte() * 4);
                parsableByteArray.skipBytes(6);
            } else {
                i = 0;
                i2 = 0;
                i3 = 0;
            }
            int readUnsignedByte6 = parsableByteArray.readUnsignedByte();
            int position = parsableByteArray.getPosition();
            int i9 = 0;
            int i10 = 0;
            while (true) {
                i4 = 12;
                i5 = 13;
                if (i9 >= readUnsignedByte6) {
                    break;
                }
                int readUnsignedByte7 = parsableByteArray.readUnsignedByte() & 31;
                int readUnsignedShort = (readUnsignedByte7 == 13 || readUnsignedByte7 == 12) ? 1 : parsableByteArray.readUnsignedShort();
                for (int i11 = 0; i11 < readUnsignedShort; i11++) {
                    int readUnsignedShort2 = parsableByteArray.readUnsignedShort();
                    i10 += readUnsignedShort2 + 4;
                    parsableByteArray.skipBytes(readUnsignedShort2);
                }
                i9++;
            }
            parsableByteArray.setPosition(position);
            byte[] bArr = new byte[i10];
            int i12 = 0;
            int i13 = 0;
            while (i12 < readUnsignedByte6) {
                int readUnsignedByte8 = parsableByteArray.readUnsignedByte() & 31;
                int readUnsignedShort3 = (readUnsignedByte8 == i5 || readUnsignedByte8 == i4) ? i6 : parsableByteArray.readUnsignedShort();
                for (int i14 = 0; i14 < readUnsignedShort3; i14++) {
                    int readUnsignedShort4 = parsableByteArray.readUnsignedShort();
                    System.arraycopy(NalUnitUtil.NAL_START_CODE, 0, bArr, i13, 4);
                    int i15 = i13 + 4;
                    parsableByteArray.readBytes(bArr, i15, readUnsignedShort4);
                    i13 = i15 + readUnsignedShort4;
                }
                i12++;
                i6 = 1;
                i4 = 12;
                i5 = 13;
            }
            return new VvcConfig(ImmutableList.of(bArr), i7, String.format(Locale.US, "vvc1.%d.%s%d", Integer.valueOf(i3), str, Integer.valueOf(i2)), i + 8);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw ParserException.createForMalformedContainer("Error parsing VVC configuration", e);
        }
    }

    private VvcConfig(List<byte[]> list, int i, String str, int i2) {
        this.initializationData = list;
        this.nalUnitLengthFieldLength = i;
        this.codecs = str;
        this.bitdepthLuma = i2;
    }
}
