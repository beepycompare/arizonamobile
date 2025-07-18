package androidx.media3.extractor;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.container.NalUnitUtil;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class AvcConfig {
    public final int bitdepthChroma;
    public final int bitdepthLuma;
    public final String codecs;
    public final int colorRange;
    public final int colorSpace;
    public final int colorTransfer;
    public final int height;
    public final List<byte[]> initializationData;
    public final int maxNumReorderFrames;
    public final int nalUnitLengthFieldLength;
    public final float pixelWidthHeightRatio;
    public final int width;

    public static AvcConfig parse(ParsableByteArray parsableByteArray) throws ParserException {
        String str;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        float f;
        int i7;
        int i8;
        try {
            parsableByteArray.skipBytes(4);
            int readUnsignedByte = (parsableByteArray.readUnsignedByte() & 3) + 1;
            if (readUnsignedByte == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int readUnsignedByte2 = parsableByteArray.readUnsignedByte() & 31;
            for (int i9 = 0; i9 < readUnsignedByte2; i9++) {
                arrayList.add(buildNalUnitForChild(parsableByteArray));
            }
            int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
            for (int i10 = 0; i10 < readUnsignedByte3; i10++) {
                arrayList.add(buildNalUnitForChild(parsableByteArray));
            }
            if (readUnsignedByte2 > 0) {
                NalUnitUtil.SpsData parseSpsNalUnit = NalUnitUtil.parseSpsNalUnit((byte[]) arrayList.get(0), NalUnitUtil.NAL_START_CODE.length, ((byte[]) arrayList.get(0)).length);
                int i11 = parseSpsNalUnit.width;
                int i12 = parseSpsNalUnit.height;
                int i13 = parseSpsNalUnit.colorSpace;
                int i14 = parseSpsNalUnit.colorRange;
                int i15 = parseSpsNalUnit.colorTransfer;
                int i16 = parseSpsNalUnit.maxNumReorderFrames;
                float f2 = parseSpsNalUnit.pixelWidthHeightRatio;
                str = CodecSpecificDataUtil.buildAvcCodecString(parseSpsNalUnit.profileIdc, parseSpsNalUnit.constraintsFlagsAndReservedZero2Bits, parseSpsNalUnit.levelIdc);
                i5 = i15;
                i6 = i16;
                f = f2;
                i4 = parseSpsNalUnit.bitDepthChromaMinus8 + 8;
                i7 = i13;
                i8 = i14;
                i = i11;
                i2 = i12;
                i3 = parseSpsNalUnit.bitDepthLumaMinus8 + 8;
            } else {
                str = null;
                i = -1;
                i2 = -1;
                i3 = -1;
                i4 = -1;
                i5 = -1;
                i6 = 16;
                f = 1.0f;
                i7 = -1;
                i8 = -1;
            }
            return new AvcConfig(arrayList, readUnsignedByte, i, i2, i3, i4, i7, i8, i5, i6, f, str);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw ParserException.createForMalformedContainer("Error parsing AVC config", e);
        }
    }

    private AvcConfig(List<byte[]> list, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, float f, String str) {
        this.initializationData = list;
        this.nalUnitLengthFieldLength = i;
        this.width = i2;
        this.height = i3;
        this.bitdepthLuma = i4;
        this.bitdepthChroma = i5;
        this.colorSpace = i6;
        this.colorRange = i7;
        this.colorTransfer = i8;
        this.maxNumReorderFrames = i9;
        this.pixelWidthHeightRatio = f;
        this.codecs = str;
    }

    private static byte[] buildNalUnitForChild(ParsableByteArray parsableByteArray) {
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        int position = parsableByteArray.getPosition();
        parsableByteArray.skipBytes(readUnsignedShort);
        return CodecSpecificDataUtil.buildNalUnit(parsableByteArray.getData(), position, readUnsignedShort);
    }
}
