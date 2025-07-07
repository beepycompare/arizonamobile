package androidx.media3.container;

import androidx.media3.common.ColorInfo;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.Log;
import com.google.common.base.Ascii;
import com.google.common.collect.ImmutableList;
import com.google.common.math.DoubleMath;
import java.lang.reflect.Array;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
/* loaded from: classes2.dex */
public final class NalUnitUtil {
    public static final int EXTENDED_SAR = 255;
    public static final int H264_NAL_UNIT_TYPE_AUD = 9;
    public static final int H264_NAL_UNIT_TYPE_IDR = 5;
    public static final int H264_NAL_UNIT_TYPE_NON_IDR = 1;
    public static final int H264_NAL_UNIT_TYPE_PARTITION_A = 2;
    public static final int H264_NAL_UNIT_TYPE_PPS = 8;
    public static final int H264_NAL_UNIT_TYPE_PREFIX = 14;
    public static final int H264_NAL_UNIT_TYPE_SEI = 6;
    public static final int H264_NAL_UNIT_TYPE_SPS = 7;
    public static final int H264_NAL_UNIT_TYPE_UNSPECIFIED = 24;
    public static final int H265_NAL_UNIT_TYPE_AUD = 35;
    public static final int H265_NAL_UNIT_TYPE_BLA_W_LP = 16;
    public static final int H265_NAL_UNIT_TYPE_CRA = 21;
    public static final int H265_NAL_UNIT_TYPE_PPS = 34;
    public static final int H265_NAL_UNIT_TYPE_PREFIX_SEI = 39;
    public static final int H265_NAL_UNIT_TYPE_RASL_R = 9;
    public static final int H265_NAL_UNIT_TYPE_SPS = 33;
    public static final int H265_NAL_UNIT_TYPE_SUFFIX_SEI = 40;
    public static final int H265_NAL_UNIT_TYPE_UNSPECIFIED = 48;
    public static final int H265_NAL_UNIT_TYPE_VPS = 32;
    private static final int INVALID_ID = -1;
    @Deprecated
    public static final int NAL_UNIT_TYPE_AUD = 9;
    @Deprecated
    public static final int NAL_UNIT_TYPE_IDR = 5;
    @Deprecated
    public static final int NAL_UNIT_TYPE_NON_IDR = 1;
    @Deprecated
    public static final int NAL_UNIT_TYPE_PARTITION_A = 2;
    @Deprecated
    public static final int NAL_UNIT_TYPE_PPS = 8;
    @Deprecated
    public static final int NAL_UNIT_TYPE_PREFIX = 14;
    @Deprecated
    public static final int NAL_UNIT_TYPE_SEI = 6;
    @Deprecated
    public static final int NAL_UNIT_TYPE_SPS = 7;
    private static final String TAG = "NalUnitUtil";
    public static final byte[] NAL_START_CODE = {0, 0, 0, 1};
    public static final float[] ASPECT_RATIO_IDC_VALUES = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    private static final Object scratchEscapePositionsLock = new Object();
    private static int[] scratchEscapePositions = new int[10];

    private static int applyConformanceWindowToHeight(int i, int i2, int i3, int i4) {
        return i - ((i2 == 1 ? 2 : 1) * (i3 + i4));
    }

    private static int applyConformanceWindowToWidth(int i, int i2, int i3, int i4) {
        int i5 = 2;
        if (i2 != 1 && i2 != 2) {
            i5 = 1;
        }
        return i - (i5 * (i3 + i4));
    }

    public static boolean isH264NalUnitDependedOn(byte b) {
        if (((b & 96) >> 5) != 0) {
            return true;
        }
        int i = b & Ascii.US;
        return (i == 1 || i == 9 || i == 14) ? false : true;
    }

    /* loaded from: classes2.dex */
    public static final class SpsData {
        public final int bitDepthChromaMinus8;
        public final int bitDepthLumaMinus8;
        public final int colorRange;
        public final int colorSpace;
        public final int colorTransfer;
        public final int constraintsFlagsAndReservedZero2Bits;
        public final boolean deltaPicOrderAlwaysZeroFlag;
        public final boolean frameMbsOnlyFlag;
        public final int frameNumLength;
        public final int height;
        public final int levelIdc;
        public final int maxNumRefFrames;
        public final int maxNumReorderFrames;
        public final int picOrderCntLsbLength;
        public final int picOrderCountType;
        public final float pixelWidthHeightRatio;
        public final int profileIdc;
        public final boolean separateColorPlaneFlag;
        public final int seqParameterSetId;
        public final int width;

        public SpsData(int i, int i2, int i3, int i4, int i5, int i6, int i7, float f, int i8, int i9, boolean z, boolean z2, int i10, int i11, int i12, boolean z3, int i13, int i14, int i15, int i16) {
            this.profileIdc = i;
            this.constraintsFlagsAndReservedZero2Bits = i2;
            this.levelIdc = i3;
            this.seqParameterSetId = i4;
            this.maxNumRefFrames = i5;
            this.width = i6;
            this.height = i7;
            this.pixelWidthHeightRatio = f;
            this.bitDepthLumaMinus8 = i8;
            this.bitDepthChromaMinus8 = i9;
            this.separateColorPlaneFlag = z;
            this.frameMbsOnlyFlag = z2;
            this.frameNumLength = i10;
            this.picOrderCountType = i11;
            this.picOrderCntLsbLength = i12;
            this.deltaPicOrderAlwaysZeroFlag = z3;
            this.colorSpace = i13;
            this.colorRange = i14;
            this.colorTransfer = i15;
            this.maxNumReorderFrames = i16;
        }
    }

    /* loaded from: classes2.dex */
    public static final class H265NalHeader {
        public final int layerId;
        public final int nalUnitType;
        public final int temporalId;

        public H265NalHeader(int i, int i2, int i3) {
            this.nalUnitType = i;
            this.layerId = i2;
            this.temporalId = i3;
        }
    }

    /* loaded from: classes2.dex */
    public static final class H265LayerInfo {
        public final int layerIdInVps;
        public final int viewId;

        public H265LayerInfo(int i, int i2) {
            this.layerIdInVps = i;
            this.viewId = i2;
        }
    }

    /* loaded from: classes2.dex */
    public static final class H265ProfileTierLevel {
        public final int[] constraintBytes;
        public final int generalLevelIdc;
        public final int generalProfileCompatibilityFlags;
        public final int generalProfileIdc;
        public final int generalProfileSpace;
        public final boolean generalTierFlag;

        public H265ProfileTierLevel(int i, boolean z, int i2, int i3, int[] iArr, int i4) {
            this.generalProfileSpace = i;
            this.generalTierFlag = z;
            this.generalProfileIdc = i2;
            this.generalProfileCompatibilityFlags = i3;
            this.constraintBytes = iArr;
            this.generalLevelIdc = i4;
        }
    }

    /* loaded from: classes2.dex */
    public static final class H265ProfileTierLevelsAndIndices {
        public final int[] indices;
        public final ImmutableList<H265ProfileTierLevel> profileTierLevels;

        public H265ProfileTierLevelsAndIndices(List<H265ProfileTierLevel> list, int[] iArr) {
            this.profileTierLevels = ImmutableList.copyOf((Collection) list);
            this.indices = iArr;
        }
    }

    /* loaded from: classes2.dex */
    public static final class H265RepFormat {
        public final int bitDepthChromaMinus8;
        public final int bitDepthLumaMinus8;
        public final int chromaFormatIdc;
        public final int height;
        public final int width;

        public H265RepFormat(int i, int i2, int i3, int i4, int i5) {
            this.chromaFormatIdc = i;
            this.bitDepthLumaMinus8 = i2;
            this.bitDepthChromaMinus8 = i3;
            this.width = i4;
            this.height = i5;
        }
    }

    /* loaded from: classes2.dex */
    public static final class H265RepFormatsAndIndices {
        public final int[] indices;
        public final ImmutableList<H265RepFormat> repFormats;

        public H265RepFormatsAndIndices(List<H265RepFormat> list, int[] iArr) {
            this.repFormats = ImmutableList.copyOf((Collection) list);
            this.indices = iArr;
        }
    }

    /* loaded from: classes2.dex */
    public static final class H265VideoSignalInfo {
        public final int colorRange;
        public final int colorSpace;
        public final int colorTransfer;

        public H265VideoSignalInfo(int i, int i2, int i3) {
            this.colorSpace = i;
            this.colorRange = i2;
            this.colorTransfer = i3;
        }
    }

    /* loaded from: classes2.dex */
    public static final class H265VideoSignalInfosAndIndices {
        public final int[] indices;
        public final ImmutableList<H265VideoSignalInfo> videoSignalInfos;

        public H265VideoSignalInfosAndIndices(List<H265VideoSignalInfo> list, int[] iArr) {
            this.videoSignalInfos = ImmutableList.copyOf((Collection) list);
            this.indices = iArr;
        }
    }

    /* loaded from: classes2.dex */
    public static final class H265VpsData {
        public final ImmutableList<H265LayerInfo> layerInfos;
        public final H265NalHeader nalHeader;
        public final H265ProfileTierLevelsAndIndices profileTierLevelsAndIndices;
        public final H265RepFormatsAndIndices repFormatsAndIndices;
        public final H265VideoSignalInfosAndIndices videoSignalInfosAndIndices;

        public H265VpsData(H265NalHeader h265NalHeader, List<H265LayerInfo> list, H265ProfileTierLevelsAndIndices h265ProfileTierLevelsAndIndices, H265RepFormatsAndIndices h265RepFormatsAndIndices, H265VideoSignalInfosAndIndices h265VideoSignalInfosAndIndices) {
            this.nalHeader = h265NalHeader;
            this.layerInfos = list != null ? ImmutableList.copyOf((Collection) list) : ImmutableList.of();
            this.profileTierLevelsAndIndices = h265ProfileTierLevelsAndIndices;
            this.repFormatsAndIndices = h265RepFormatsAndIndices;
            this.videoSignalInfosAndIndices = h265VideoSignalInfosAndIndices;
        }
    }

    /* loaded from: classes2.dex */
    public static final class H265SpsData {
        public final int bitDepthChromaMinus8;
        public final int bitDepthLumaMinus8;
        public final int chromaFormatIdc;
        public final int colorRange;
        public final int colorSpace;
        public final int colorTransfer;
        public final int height;
        public final int maxNumReorderPics;
        public final int maxSubLayersMinus1;
        public final H265NalHeader nalHeader;
        public final float pixelWidthHeightRatio;
        public final H265ProfileTierLevel profileTierLevel;
        public final int seqParameterSetId;
        public final int width;

        public H265SpsData(H265NalHeader h265NalHeader, int i, H265ProfileTierLevel h265ProfileTierLevel, int i2, int i3, int i4, int i5, int i6, int i7, float f, int i8, int i9, int i10, int i11) {
            this.nalHeader = h265NalHeader;
            this.maxSubLayersMinus1 = i;
            this.profileTierLevel = h265ProfileTierLevel;
            this.chromaFormatIdc = i2;
            this.bitDepthLumaMinus8 = i3;
            this.bitDepthChromaMinus8 = i4;
            this.seqParameterSetId = i5;
            this.width = i6;
            this.height = i7;
            this.pixelWidthHeightRatio = f;
            this.maxNumReorderPics = i8;
            this.colorSpace = i9;
            this.colorRange = i10;
            this.colorTransfer = i11;
        }
    }

    /* loaded from: classes2.dex */
    public static final class PpsData {
        public final boolean bottomFieldPicOrderInFramePresentFlag;
        public final int picParameterSetId;
        public final int seqParameterSetId;

        public PpsData(int i, int i2, boolean z) {
            this.picParameterSetId = i;
            this.seqParameterSetId = i2;
            this.bottomFieldPicOrderInFramePresentFlag = z;
        }
    }

    /* loaded from: classes2.dex */
    public static final class H265Sei3dRefDisplayInfoData {
        public final int exponentRefDisplayWidth;
        public final int exponentRefViewingDist;
        public final int leftViewId;
        public final int mantissaRefDisplayWidth;
        public final int mantissaRefViewingDist;
        public final int numRefDisplays;
        public final int precRefDisplayWidth;
        public final int precRefViewingDist;
        public final int rightViewId;

        public H265Sei3dRefDisplayInfoData(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            this.precRefDisplayWidth = i;
            this.precRefViewingDist = i2;
            this.numRefDisplays = i3;
            this.leftViewId = i4;
            this.rightViewId = i5;
            this.exponentRefDisplayWidth = i6;
            this.mantissaRefDisplayWidth = i7;
            this.exponentRefViewingDist = i8;
            this.mantissaRefViewingDist = i9;
        }
    }

    public static int unescapeStream(byte[] bArr, int i) {
        int i2;
        synchronized (scratchEscapePositionsLock) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < i) {
                try {
                    i3 = findNextUnescapeIndex(bArr, i3, i);
                    if (i3 < i) {
                        int[] iArr = scratchEscapePositions;
                        if (iArr.length <= i4) {
                            scratchEscapePositions = Arrays.copyOf(iArr, iArr.length * 2);
                        }
                        scratchEscapePositions[i4] = i3;
                        i3 += 3;
                        i4++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            i2 = i - i4;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < i4; i7++) {
                int i8 = scratchEscapePositions[i7] - i6;
                System.arraycopy(bArr, i6, bArr, i5, i8);
                int i9 = i5 + i8;
                int i10 = i9 + 1;
                bArr[i9] = 0;
                i5 = i9 + 2;
                bArr[i10] = 0;
                i6 += i8 + 3;
            }
            System.arraycopy(bArr, i6, bArr, i5, i2 - i5);
        }
        return i2;
    }

    public static void discardToSps(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i + 1;
            if (i3 < position) {
                int i4 = byteBuffer.get(i) & 255;
                if (i2 == 3) {
                    if (i4 == 1 && (byteBuffer.get(i3) & Ascii.US) == 7) {
                        ByteBuffer duplicate = byteBuffer.duplicate();
                        duplicate.position(i - 3);
                        duplicate.limit(position);
                        byteBuffer.position(0);
                        byteBuffer.put(duplicate);
                        return;
                    }
                } else if (i4 == 0) {
                    i2++;
                }
                if (i4 != 0) {
                    i2 = 0;
                }
                i = i3;
            } else {
                byteBuffer.clear();
                return;
            }
        }
    }

    @Deprecated
    public static boolean isNalUnitSei(String str, byte b) {
        return (MimeTypes.VIDEO_H264.equals(str) && (b & Ascii.US) == 6) || (MimeTypes.VIDEO_H265.equals(str) && ((b & 126) >> 1) == 39);
    }

    public static boolean isNalUnitSei(Format format, byte b) {
        return ((Objects.equals(format.sampleMimeType, MimeTypes.VIDEO_H264) || MimeTypes.containsCodecsCorrespondingToMimeType(format.codecs, MimeTypes.VIDEO_H264)) && (b & Ascii.US) == 6) || ((Objects.equals(format.sampleMimeType, MimeTypes.VIDEO_H265) || MimeTypes.containsCodecsCorrespondingToMimeType(format.codecs, MimeTypes.VIDEO_H265)) && ((b & 126) >> 1) == 39);
    }

    public static int getNalUnitType(byte[] bArr, int i) {
        return bArr[i + 3] & Ascii.US;
    }

    public static int numberOfBytesInNalUnitHeader(Format format) {
        if (Objects.equals(format.sampleMimeType, MimeTypes.VIDEO_H264)) {
            return 1;
        }
        return (Objects.equals(format.sampleMimeType, MimeTypes.VIDEO_H265) || MimeTypes.containsCodecsCorrespondingToMimeType(format.codecs, MimeTypes.VIDEO_H265)) ? 2 : 0;
    }

    public static boolean isDependedOn(byte[] bArr, int i, int i2, Format format) {
        if (Objects.equals(format.sampleMimeType, MimeTypes.VIDEO_H264)) {
            return isH264NalUnitDependedOn(bArr[i]);
        }
        if (Objects.equals(format.sampleMimeType, MimeTypes.VIDEO_H265)) {
            return isH265NalUnitDependedOn(bArr, i, i2, format);
        }
        return true;
    }

    private static boolean isH265NalUnitDependedOn(byte[] bArr, int i, int i2, Format format) {
        H265NalHeader parseH265NalHeader = parseH265NalHeader(new ParsableNalUnitBitArray(bArr, i, i2 + i));
        if (parseH265NalHeader.nalUnitType == 35) {
            return false;
        }
        return (parseH265NalHeader.nalUnitType <= 14 && parseH265NalHeader.nalUnitType % 2 == 0 && parseH265NalHeader.temporalId == format.maxSubLayers - 1) ? false : true;
    }

    public static int getH265NalUnitType(byte[] bArr, int i) {
        return (bArr[i + 3] & 126) >> 1;
    }

    public static SpsData parseSpsNalUnit(byte[] bArr, int i, int i2) {
        return parseSpsNalUnitPayload(bArr, i + 1, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x021a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static SpsData parseSpsNalUnitPayload(byte[] bArr, int i, int i2) {
        int readUnsignedExpGolombCodedInt;
        boolean readBit;
        int readUnsignedExpGolombCodedInt2;
        int i3;
        int i4;
        int i5;
        int i6;
        boolean z;
        int i7;
        int i8;
        int i9;
        int i10;
        float f;
        int i11;
        int i12;
        int i13;
        boolean z2;
        int i14;
        int i15;
        int i16;
        boolean readBit2;
        boolean readBit3;
        int i17;
        int i18;
        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, i, i2);
        int readBits = parsableNalUnitBitArray.readBits(8);
        int readBits2 = parsableNalUnitBitArray.readBits(8);
        int readBits3 = parsableNalUnitBitArray.readBits(8);
        int readUnsignedExpGolombCodedInt3 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        if (readBits == 100 || readBits == 110 || readBits == 122 || readBits == 244 || readBits == 44 || readBits == 83 || readBits == 86 || readBits == 118 || readBits == 128 || readBits == 138) {
            readUnsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            readBit = readUnsignedExpGolombCodedInt == 3 ? parsableNalUnitBitArray.readBit() : false;
            readUnsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int readUnsignedExpGolombCodedInt4 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.skipBit();
            if (parsableNalUnitBitArray.readBit()) {
                int i19 = readUnsignedExpGolombCodedInt != 3 ? 8 : 12;
                i3 = 16;
                int i20 = 0;
                while (i20 < i19) {
                    if (parsableNalUnitBitArray.readBit()) {
                        skipScalingList(parsableNalUnitBitArray, i20 < 6 ? 16 : 64);
                    }
                    i20++;
                }
            } else {
                i3 = 16;
            }
            i4 = readUnsignedExpGolombCodedInt4;
        } else {
            readUnsignedExpGolombCodedInt = 1;
            i3 = 16;
            i4 = 0;
            readBit = false;
            readUnsignedExpGolombCodedInt2 = 0;
        }
        int readUnsignedExpGolombCodedInt5 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 4;
        int readUnsignedExpGolombCodedInt6 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        if (readUnsignedExpGolombCodedInt6 == 0) {
            i7 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 4;
            i5 = readBits;
            i6 = readUnsignedExpGolombCodedInt6;
            z = false;
        } else {
            if (readUnsignedExpGolombCodedInt6 == 1) {
                boolean readBit4 = parsableNalUnitBitArray.readBit();
                parsableNalUnitBitArray.readSignedExpGolombCodedInt();
                parsableNalUnitBitArray.readSignedExpGolombCodedInt();
                i5 = readBits;
                long readUnsignedExpGolombCodedInt7 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                i6 = readUnsignedExpGolombCodedInt6;
                for (int i21 = 0; i21 < readUnsignedExpGolombCodedInt7; i21++) {
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                }
                z = readBit4;
            } else {
                i5 = readBits;
                i6 = readUnsignedExpGolombCodedInt6;
                z = false;
            }
            i7 = 0;
        }
        int readUnsignedExpGolombCodedInt8 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.skipBit();
        int readUnsignedExpGolombCodedInt9 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1;
        boolean readBit5 = parsableNalUnitBitArray.readBit();
        int readUnsignedExpGolombCodedInt10 = (2 - (readBit5 ? 1 : 0)) * (parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1);
        if (!readBit5) {
            parsableNalUnitBitArray.skipBit();
        }
        parsableNalUnitBitArray.skipBit();
        int i22 = readUnsignedExpGolombCodedInt9 * 16;
        int i23 = readUnsignedExpGolombCodedInt10 * 16;
        if (parsableNalUnitBitArray.readBit()) {
            int readUnsignedExpGolombCodedInt11 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int readUnsignedExpGolombCodedInt12 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int readUnsignedExpGolombCodedInt13 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int readUnsignedExpGolombCodedInt14 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            if (readUnsignedExpGolombCodedInt == 0) {
                i18 = 2 - (readBit5 ? 1 : 0);
                i17 = 1;
            } else {
                i17 = readUnsignedExpGolombCodedInt == 3 ? 1 : 2;
                i18 = (readUnsignedExpGolombCodedInt == 1 ? 2 : 1) * (2 - (readBit5 ? 1 : 0));
            }
            i22 -= (readUnsignedExpGolombCodedInt11 + readUnsignedExpGolombCodedInt12) * i17;
            i23 -= (readUnsignedExpGolombCodedInt13 + readUnsignedExpGolombCodedInt14) * i18;
        }
        int i24 = i22;
        int i25 = i5;
        int i26 = ((i25 == 44 || i25 == 86 || i25 == 100 || i25 == 110 || i25 == 122 || i25 == 244) && (readBits2 & 16) != 0) ? 0 : i3;
        float f2 = 1.0f;
        if (parsableNalUnitBitArray.readBit()) {
            if (parsableNalUnitBitArray.readBit()) {
                int readBits4 = parsableNalUnitBitArray.readBits(8);
                if (readBits4 == 255) {
                    int i27 = i3;
                    int readBits5 = parsableNalUnitBitArray.readBits(i27);
                    int readBits6 = parsableNalUnitBitArray.readBits(i27);
                    if (readBits5 != 0 && readBits6 != 0) {
                        f2 = readBits5 / readBits6;
                    }
                } else {
                    float[] fArr = ASPECT_RATIO_IDC_VALUES;
                    if (readBits4 < fArr.length) {
                        f2 = fArr[readBits4];
                    } else {
                        Log.w(TAG, "Unexpected aspect_ratio_idc value: " + readBits4);
                    }
                }
            }
            if (parsableNalUnitBitArray.readBit()) {
                parsableNalUnitBitArray.skipBit();
            }
            if (parsableNalUnitBitArray.readBit()) {
                parsableNalUnitBitArray.skipBits(3);
                i15 = parsableNalUnitBitArray.readBit() ? 1 : 2;
                if (parsableNalUnitBitArray.readBit()) {
                    int readBits7 = parsableNalUnitBitArray.readBits(8);
                    int readBits8 = parsableNalUnitBitArray.readBits(8);
                    parsableNalUnitBitArray.skipBits(8);
                    int isoColorPrimariesToColorSpace = ColorInfo.isoColorPrimariesToColorSpace(readBits7);
                    int isoTransferCharacteristicsToColorTransfer = ColorInfo.isoTransferCharacteristicsToColorTransfer(readBits8);
                    i16 = isoColorPrimariesToColorSpace;
                    i14 = isoTransferCharacteristicsToColorTransfer;
                    if (parsableNalUnitBitArray.readBit()) {
                        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    }
                    if (parsableNalUnitBitArray.readBit()) {
                        parsableNalUnitBitArray.skipBits(65);
                    }
                    readBit2 = parsableNalUnitBitArray.readBit();
                    if (readBit2) {
                        skipHrdParameters(parsableNalUnitBitArray);
                    }
                    readBit3 = parsableNalUnitBitArray.readBit();
                    if (readBit3) {
                        skipHrdParameters(parsableNalUnitBitArray);
                    }
                    if (!readBit2 || readBit3) {
                        parsableNalUnitBitArray.skipBit();
                    }
                    parsableNalUnitBitArray.skipBit();
                    if (parsableNalUnitBitArray.readBit()) {
                        parsableNalUnitBitArray.skipBit();
                        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                        i26 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    }
                    i13 = i14;
                    i12 = i15;
                    i8 = i26;
                    i9 = readUnsignedExpGolombCodedInt2;
                    i10 = i7;
                    f = f2;
                    z2 = z;
                    i11 = i16;
                } else {
                    i14 = -1;
                }
            } else {
                i14 = -1;
                i15 = -1;
            }
            i16 = -1;
            if (parsableNalUnitBitArray.readBit()) {
            }
            if (parsableNalUnitBitArray.readBit()) {
            }
            readBit2 = parsableNalUnitBitArray.readBit();
            if (readBit2) {
            }
            readBit3 = parsableNalUnitBitArray.readBit();
            if (readBit3) {
            }
            if (!readBit2) {
            }
            parsableNalUnitBitArray.skipBit();
            parsableNalUnitBitArray.skipBit();
            if (parsableNalUnitBitArray.readBit()) {
            }
            i13 = i14;
            i12 = i15;
            i8 = i26;
            i9 = readUnsignedExpGolombCodedInt2;
            i10 = i7;
            f = f2;
            z2 = z;
            i11 = i16;
        } else {
            i8 = i26;
            i9 = readUnsignedExpGolombCodedInt2;
            i10 = i7;
            f = 1.0f;
            i11 = -1;
            i12 = -1;
            i13 = -1;
            z2 = z;
        }
        return new SpsData(i25, readBits2, readBits3, readUnsignedExpGolombCodedInt3, readUnsignedExpGolombCodedInt8, i24, i23, f, i9, i4, readBit, readBit5, readUnsignedExpGolombCodedInt5, i6, i10, z2, i11, i12, i13, i8);
    }

    public static H265VpsData parseH265VpsNalUnit(byte[] bArr, int i, int i2) {
        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, i, i2);
        return parseH265VpsNalUnitPayload(parsableNalUnitBitArray, parseH265NalHeader(parsableNalUnitBitArray));
    }

    private static H265NalHeader parseH265NalHeader(ParsableNalUnitBitArray parsableNalUnitBitArray) {
        parsableNalUnitBitArray.skipBit();
        return new H265NalHeader(parsableNalUnitBitArray.readBits(6), parsableNalUnitBitArray.readBits(6), parsableNalUnitBitArray.readBits(3) - 1);
    }

    private static H265VpsData parseH265VpsNalUnitPayload(ParsableNalUnitBitArray parsableNalUnitBitArray, H265NalHeader h265NalHeader) {
        int[] iArr;
        int i;
        int i2;
        int[] iArr2;
        H265VideoSignalInfosAndIndices h265VideoSignalInfosAndIndices;
        int i3;
        int i4;
        int i5;
        boolean[][] zArr;
        ImmutableList immutableList;
        int i6;
        boolean[][] zArr2;
        int[] iArr3;
        int i7;
        int i8;
        int i9;
        parsableNalUnitBitArray.skipBits(4);
        boolean readBit = parsableNalUnitBitArray.readBit();
        boolean readBit2 = parsableNalUnitBitArray.readBit();
        int readBits = parsableNalUnitBitArray.readBits(6);
        int i10 = readBits + 1;
        int readBits2 = parsableNalUnitBitArray.readBits(3);
        parsableNalUnitBitArray.skipBits(17);
        H265ProfileTierLevel parseH265ProfileTierLevel = parseH265ProfileTierLevel(parsableNalUnitBitArray, true, readBits2, null);
        for (int i11 = parsableNalUnitBitArray.readBit() ? 0 : readBits2; i11 <= readBits2; i11++) {
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        }
        int readBits3 = parsableNalUnitBitArray.readBits(6);
        int readUnsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1;
        H265ProfileTierLevelsAndIndices h265ProfileTierLevelsAndIndices = new H265ProfileTierLevelsAndIndices(ImmutableList.of(parseH265ProfileTierLevel), new int[1]);
        Object[] objArr = (i10 < 2 || readUnsignedExpGolombCodedInt < 2) ? null : 1;
        Object[] objArr2 = (readBit && readBit2) ? 1 : null;
        int i12 = readBits3 + 1;
        Object[] objArr3 = i12 >= i10 ? 1 : null;
        if (objArr == null || objArr2 == null || objArr3 == null) {
            return new H265VpsData(h265NalHeader, null, h265ProfileTierLevelsAndIndices, null, null);
        }
        int[][] iArr4 = (int[][]) Array.newInstance(Integer.TYPE, readUnsignedExpGolombCodedInt, i12);
        int[] iArr5 = new int[readUnsignedExpGolombCodedInt];
        int i13 = 1;
        int[] iArr6 = new int[readUnsignedExpGolombCodedInt];
        iArr4[0][0] = 0;
        iArr5[0] = 1;
        iArr6[0] = 0;
        for (int i14 = 1; i14 < readUnsignedExpGolombCodedInt; i14++) {
            int i15 = 0;
            for (int i16 = 0; i16 <= readBits3; i16++) {
                if (parsableNalUnitBitArray.readBit()) {
                    iArr4[i14][i15] = i16;
                    iArr6[i14] = i16;
                    i15++;
                }
                iArr5[i14] = i15;
            }
        }
        if (parsableNalUnitBitArray.readBit()) {
            parsableNalUnitBitArray.skipBits(64);
            if (parsableNalUnitBitArray.readBit()) {
                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            }
            int readUnsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int i17 = 0;
            while (i17 < readUnsignedExpGolombCodedInt2) {
                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                skipH265HrdParameters(parsableNalUnitBitArray, i17 == 0 || parsableNalUnitBitArray.readBit(), readBits2);
                i17++;
            }
        }
        if (!parsableNalUnitBitArray.readBit()) {
            return new H265VpsData(h265NalHeader, null, h265ProfileTierLevelsAndIndices, null, null);
        }
        parsableNalUnitBitArray.byteAlign();
        H265ProfileTierLevel parseH265ProfileTierLevel2 = parseH265ProfileTierLevel(parsableNalUnitBitArray, false, readBits2, parseH265ProfileTierLevel);
        boolean readBit3 = parsableNalUnitBitArray.readBit();
        int i18 = 6;
        boolean[] zArr3 = new boolean[16];
        int i19 = 0;
        for (int i20 = 0; i20 < 16; i20++) {
            boolean readBit4 = parsableNalUnitBitArray.readBit();
            zArr3[i20] = readBit4;
            if (readBit4) {
                i19++;
            }
        }
        if (i19 == 0 || !zArr3[1]) {
            return new H265VpsData(h265NalHeader, null, h265ProfileTierLevelsAndIndices, null, null);
        }
        int[] iArr7 = new int[i19];
        for (int i21 = 0; i21 < i19 - (readBit3 ? 1 : 0); i21++) {
            iArr7[i21] = parsableNalUnitBitArray.readBits(3);
        }
        int[] iArr8 = new int[i19 + 1];
        if (readBit3) {
            int i22 = 1;
            while (i22 < i19) {
                int[] iArr9 = iArr8;
                for (int i23 = 0; i23 < i22; i23++) {
                    iArr9[i22] = iArr9[i22] + iArr7[i23] + 1;
                }
                i22++;
                iArr8 = iArr9;
            }
            iArr = iArr8;
            iArr[i19] = 6;
        } else {
            iArr = iArr8;
        }
        int[][] iArr10 = (int[][]) Array.newInstance(Integer.TYPE, i10, i19);
        int[] iArr11 = new int[i10];
        iArr11[0] = 0;
        boolean readBit5 = parsableNalUnitBitArray.readBit();
        int i24 = 1;
        while (i24 < i10) {
            if (readBit5) {
                i8 = i24;
                iArr11[i8] = parsableNalUnitBitArray.readBits(i18);
            } else {
                i8 = i24;
                iArr11[i8] = i8;
            }
            if (readBit3) {
                for (int i25 = 0; i25 < i19; i25++) {
                    iArr10[i8][i25] = (iArr11[i8] & ((1 << iArr[i9]) - 1)) >> iArr[i25];
                }
            } else {
                int i26 = 0;
                while (i26 < i19) {
                    int i27 = i26;
                    iArr10[i8][i27] = parsableNalUnitBitArray.readBits(iArr7[i26] + 1);
                    i26 = i27 + 1;
                }
            }
            i24 = i8 + 1;
            i18 = 6;
        }
        int[] iArr12 = new int[i12];
        int i28 = 1;
        int i29 = 0;
        while (i29 < i10) {
            iArr12[iArr11[i29]] = -1;
            int[] iArr13 = iArr12;
            int i30 = 0;
            int i31 = 0;
            while (i30 < 16) {
                if (zArr3[i30]) {
                    if (i30 == i13) {
                        iArr13[iArr11[i29]] = iArr10[i29][i31];
                    }
                    i31++;
                }
                i30++;
                i13 = 1;
            }
            if (i29 > 0) {
                int i32 = 0;
                while (true) {
                    if (i32 >= i29) {
                        i28++;
                        break;
                    }
                    int i33 = i32;
                    if (iArr13[iArr11[i29]] == iArr13[iArr11[i32]]) {
                        break;
                    }
                    i32 = i33 + 1;
                }
            }
            i29++;
            iArr12 = iArr13;
            i13 = 1;
        }
        int[] iArr14 = iArr12;
        int readBits4 = parsableNalUnitBitArray.readBits(4);
        if (i28 < 2 || readBits4 == 0) {
            return new H265VpsData(h265NalHeader, null, h265ProfileTierLevelsAndIndices, null, null);
        }
        int[] iArr15 = new int[i28];
        for (int i34 = 0; i34 < i28; i34++) {
            iArr15[i34] = parsableNalUnitBitArray.readBits(readBits4);
        }
        int[] iArr16 = new int[i12];
        int i35 = 0;
        while (i35 < i10) {
            int[] iArr17 = iArr16;
            iArr17[Math.min(iArr11[i35], readBits3)] = i35;
            i35++;
            iArr16 = iArr17;
        }
        int[] iArr18 = iArr16;
        ImmutableList.Builder builder = ImmutableList.builder();
        int i36 = 0;
        while (i36 <= readBits3) {
            int i37 = i28;
            int[] iArr19 = iArr15;
            int min = Math.min(iArr14[i36], i37 - 1);
            builder.add((ImmutableList.Builder) new H265LayerInfo(iArr18[i36], min >= 0 ? iArr19[min] : -1));
            i36++;
            i28 = i37;
            iArr15 = iArr19;
            iArr6 = iArr6;
        }
        int[] iArr20 = iArr6;
        ImmutableList build = builder.build();
        if (((H265LayerInfo) build.get(0)).viewId == -1) {
            return new H265VpsData(h265NalHeader, null, h265ProfileTierLevelsAndIndices, null, null);
        }
        int i38 = 1;
        while (true) {
            if (i38 > readBits3) {
                i = -1;
                i2 = -1;
                break;
            }
            i = -1;
            if (((H265LayerInfo) build.get(i38)).viewId != -1) {
                i2 = i38;
                break;
            }
            i38++;
        }
        if (i2 == i) {
            return new H265VpsData(h265NalHeader, null, h265ProfileTierLevelsAndIndices, null, null);
        }
        boolean[][] zArr4 = (boolean[][]) Array.newInstance(Boolean.TYPE, i10, i10);
        boolean[][] zArr5 = (boolean[][]) Array.newInstance(Boolean.TYPE, i10, i10);
        for (int i39 = 1; i39 < i10; i39++) {
            for (int i40 = 0; i40 < i39; i40++) {
                boolean[] zArr6 = zArr4[i39];
                boolean[] zArr7 = zArr5[i39];
                boolean readBit6 = parsableNalUnitBitArray.readBit();
                zArr7[i40] = readBit6;
                zArr6[i40] = readBit6;
            }
        }
        for (int i41 = 1; i41 < i10; i41++) {
            int i42 = 0;
            while (i42 < readBits) {
                boolean[][] zArr8 = zArr5;
                int i43 = 0;
                while (true) {
                    if (i43 < i41) {
                        boolean[] zArr9 = zArr8[i41];
                        if (zArr9[i43] && zArr8[i43][i42]) {
                            zArr9[i42] = true;
                            break;
                        }
                        i43++;
                    }
                }
                i42++;
                zArr5 = zArr8;
            }
        }
        boolean[][] zArr10 = zArr5;
        int[] iArr21 = new int[i12];
        for (int i44 = 0; i44 < i10; i44++) {
            int i45 = 0;
            for (int i46 = 0; i46 < i44; i46++) {
                i45 += zArr4[i44][i46] ? 1 : 0;
            }
            iArr21[iArr11[i44]] = i45;
        }
        int i47 = 0;
        for (int i48 = 0; i48 < i10; i48++) {
            if (iArr21[iArr11[i48]] == 0) {
                i47++;
            }
        }
        if (i47 > 1) {
            return new H265VpsData(h265NalHeader, null, h265ProfileTierLevelsAndIndices, null, null);
        }
        int[] iArr22 = new int[i10];
        int[] iArr23 = new int[readUnsignedExpGolombCodedInt];
        if (parsableNalUnitBitArray.readBit()) {
            iArr2 = iArr21;
            int i49 = 0;
            while (i49 < i10) {
                int i50 = i49;
                iArr22[i50] = parsableNalUnitBitArray.readBits(3);
                i49 = i50 + 1;
            }
        } else {
            iArr2 = iArr21;
            Arrays.fill(iArr22, 0, i10, readBits2);
        }
        int i51 = 0;
        while (i51 < readUnsignedExpGolombCodedInt) {
            int i52 = i51;
            int[] iArr24 = iArr11;
            int[] iArr25 = iArr22;
            int i53 = 0;
            for (int i54 = 0; i54 < iArr5[i52]; i54++) {
                i53 = Math.max(i53, iArr25[((H265LayerInfo) build.get(iArr4[i52][i54])).layerIdInVps]);
            }
            iArr23[i52] = i53 + 1;
            i51 = i52 + 1;
            iArr11 = iArr24;
            iArr22 = iArr25;
        }
        int[] iArr26 = iArr11;
        if (parsableNalUnitBitArray.readBit()) {
            int i55 = 0;
            while (i55 < readBits) {
                int i56 = i55 + 1;
                int i57 = i56;
                while (i57 < i10) {
                    if (zArr4[i57][i55]) {
                        i7 = i55;
                        parsableNalUnitBitArray.skipBits(3);
                    } else {
                        i7 = i55;
                    }
                    i57++;
                    i55 = i7;
                }
                i55 = i56;
            }
        }
        parsableNalUnitBitArray.skipBit();
        int readUnsignedExpGolombCodedInt3 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1;
        ImmutableList.Builder builder2 = ImmutableList.builder();
        builder2.add((ImmutableList.Builder) parseH265ProfileTierLevel);
        if (readUnsignedExpGolombCodedInt3 > 1) {
            builder2.add((ImmutableList.Builder) parseH265ProfileTierLevel2);
            for (int i58 = 2; i58 < readUnsignedExpGolombCodedInt3; i58++) {
                parseH265ProfileTierLevel2 = parseH265ProfileTierLevel(parsableNalUnitBitArray, parsableNalUnitBitArray.readBit(), readBits2, parseH265ProfileTierLevel2);
                builder2.add((ImmutableList.Builder) parseH265ProfileTierLevel2);
            }
        }
        ImmutableList build2 = builder2.build();
        int readUnsignedExpGolombCodedInt4 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + readUnsignedExpGolombCodedInt;
        if (readUnsignedExpGolombCodedInt4 > readUnsignedExpGolombCodedInt) {
            return new H265VpsData(h265NalHeader, null, h265ProfileTierLevelsAndIndices, null, null);
        }
        int readBits5 = parsableNalUnitBitArray.readBits(2);
        boolean[][] zArr11 = (boolean[][]) Array.newInstance(Boolean.TYPE, readUnsignedExpGolombCodedInt4, i12);
        int[] iArr27 = new int[readUnsignedExpGolombCodedInt4];
        int i59 = 0;
        int[] iArr28 = new int[readUnsignedExpGolombCodedInt4];
        int i60 = 0;
        while (i60 < readUnsignedExpGolombCodedInt) {
            iArr27[i60] = i59;
            iArr28[i60] = iArr20[i60];
            if (readBits5 == 0) {
                i6 = i60;
                zArr2 = zArr11;
                immutableList = build2;
                iArr3 = iArr27;
                Arrays.fill(zArr11[i6], i59, iArr5[i6], true);
                iArr3[i6] = iArr5[i6];
            } else {
                immutableList = build2;
                i6 = i60;
                zArr2 = zArr11;
                iArr3 = iArr27;
                if (readBits5 == 1) {
                    int i61 = iArr20[i6];
                    for (int i62 = 0; i62 < iArr5[i6]; i62++) {
                        zArr2[i6][i62] = iArr4[i6][i62] == i61;
                    }
                    iArr3[i6] = 1;
                } else {
                    i59 = 0;
                    zArr2[0][0] = true;
                    iArr3[0] = 1;
                    i60 = i6 + 1;
                    zArr11 = zArr2;
                    iArr27 = iArr3;
                    build2 = immutableList;
                }
            }
            i59 = 0;
            i60 = i6 + 1;
            zArr11 = zArr2;
            iArr27 = iArr3;
            build2 = immutableList;
        }
        ImmutableList immutableList2 = build2;
        boolean[][] zArr12 = zArr11;
        int[] iArr29 = iArr27;
        int[] iArr30 = new int[i12];
        int i63 = 2;
        int[] iArr31 = new int[2];
        iArr31[1] = i12;
        iArr31[i59] = readUnsignedExpGolombCodedInt4;
        boolean[][] zArr13 = (boolean[][]) Array.newInstance(Boolean.TYPE, iArr31);
        int i64 = 1;
        int i65 = 0;
        while (i64 < readUnsignedExpGolombCodedInt4) {
            int i66 = readBits5;
            if (readBits5 == i63) {
                for (int i67 = 0; i67 < iArr5[i64]; i67++) {
                    zArr12[i64][i67] = parsableNalUnitBitArray.readBit();
                    int i68 = iArr29[i64];
                    boolean z = zArr12[i64][i67];
                    iArr29[i64] = i68 + (z ? 1 : 0);
                    if (z) {
                        iArr28[i64] = iArr4[i64][i67];
                    }
                }
            }
            if (i65 == 0) {
                i3 = 0;
                if (iArr4[i64][0] == 0 && zArr12[i64][0]) {
                    for (int i69 = 1; i69 < iArr5[i64]; i69++) {
                        if (iArr4[i64][i69] == i2 && zArr12[i64][i2]) {
                            i65 = i64;
                        }
                    }
                }
            } else {
                i3 = 0;
            }
            int i70 = i3;
            while (i70 < iArr5[i64]) {
                if (readUnsignedExpGolombCodedInt3 > 1) {
                    zArr13[i64][i70] = zArr12[i64][i70];
                    zArr = zArr4;
                    i4 = readUnsignedExpGolombCodedInt3;
                    int log2 = DoubleMath.log2(readUnsignedExpGolombCodedInt3, RoundingMode.CEILING);
                    if (!zArr13[i64][i70]) {
                        int i71 = ((H265LayerInfo) build.get(iArr4[i64][i70])).layerIdInVps;
                        int i72 = i3;
                        while (i72 < i70) {
                            i5 = i2;
                            if (zArr10[i71][((H265LayerInfo) build.get(iArr4[i64][i72])).layerIdInVps]) {
                                zArr13[i64][i70] = true;
                                break;
                            }
                            i72++;
                            i2 = i5;
                        }
                    }
                    i5 = i2;
                    if (zArr13[i64][i70]) {
                        if (i65 > 0 && i64 == i65) {
                            iArr30[i70] = parsableNalUnitBitArray.readBits(log2);
                        } else {
                            parsableNalUnitBitArray.skipBits(log2);
                        }
                    }
                } else {
                    i4 = readUnsignedExpGolombCodedInt3;
                    i5 = i2;
                    zArr = zArr4;
                }
                i70++;
                zArr4 = zArr;
                readUnsignedExpGolombCodedInt3 = i4;
                i2 = i5;
            }
            int i73 = readUnsignedExpGolombCodedInt3;
            int i74 = i2;
            boolean[][] zArr14 = zArr4;
            if (iArr29[i64] == 1 && iArr2[iArr28[i64]] > 0) {
                parsableNalUnitBitArray.skipBit();
            }
            i64++;
            readBits5 = i66;
            zArr4 = zArr14;
            readUnsignedExpGolombCodedInt3 = i73;
            i2 = i74;
            i63 = 2;
        }
        boolean[][] zArr15 = zArr4;
        if (i65 == 0) {
            return new H265VpsData(h265NalHeader, null, h265ProfileTierLevelsAndIndices, null, null);
        }
        H265RepFormatsAndIndices parseH265RepFormatsAndIndices = parseH265RepFormatsAndIndices(parsableNalUnitBitArray, i10);
        parsableNalUnitBitArray.skipBits(2);
        for (int i75 = 1; i75 < i10; i75++) {
            if (iArr2[iArr26[i75]] == 0) {
                parsableNalUnitBitArray.skipBit();
            }
        }
        skipH265DpbSize(parsableNalUnitBitArray, readUnsignedExpGolombCodedInt4, iArr23, iArr5, zArr13);
        skipToH265VuiPresentFlagAfterDpbSize(parsableNalUnitBitArray, i10, zArr15);
        if (parsableNalUnitBitArray.readBit()) {
            parsableNalUnitBitArray.byteAlign();
            h265VideoSignalInfosAndIndices = parseH265VideoSignalInfosAndIndices(parsableNalUnitBitArray, i10, readUnsignedExpGolombCodedInt, iArr23);
        } else {
            h265VideoSignalInfosAndIndices = null;
        }
        return new H265VpsData(h265NalHeader, build, new H265ProfileTierLevelsAndIndices(immutableList2, iArr30), parseH265RepFormatsAndIndices, h265VideoSignalInfosAndIndices);
    }

    public static H265SpsData parseH265SpsNalUnit(byte[] bArr, int i, int i2, H265VpsData h265VpsData) {
        return parseH265SpsNalUnitPayload(bArr, i + 2, i2, parseH265NalHeader(new ParsableNalUnitBitArray(bArr, i, i2)), h265VpsData);
    }

    public static H265SpsData parseH265SpsNalUnitPayload(byte[] bArr, int i, int i2, H265NalHeader h265NalHeader, H265VpsData h265VpsData) {
        int i3;
        int readUnsignedExpGolombCodedInt;
        int i4;
        int i5;
        int readUnsignedExpGolombCodedInt2;
        int readUnsignedExpGolombCodedInt3;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, i, i2);
        parsableNalUnitBitArray.skipBits(4);
        int readBits = parsableNalUnitBitArray.readBits(3);
        boolean z = h265NalHeader.layerId != 0 && readBits == 7;
        int i17 = (h265VpsData == null || h265VpsData.layerInfos.isEmpty()) ? 0 : h265VpsData.layerInfos.get(Math.min(h265NalHeader.layerId, h265VpsData.layerInfos.size() - 1)).layerIdInVps;
        H265ProfileTierLevel h265ProfileTierLevel = null;
        if (!z) {
            parsableNalUnitBitArray.skipBit();
            h265ProfileTierLevel = parseH265ProfileTierLevel(parsableNalUnitBitArray, true, readBits, null);
        } else if (h265VpsData != null && h265VpsData.profileTierLevelsAndIndices.profileTierLevels.size() > (i3 = h265VpsData.profileTierLevelsAndIndices.indices[i17])) {
            h265ProfileTierLevel = h265VpsData.profileTierLevelsAndIndices.profileTierLevels.get(i3);
        }
        int readUnsignedExpGolombCodedInt4 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        if (z) {
            int readBits2 = parsableNalUnitBitArray.readBit() ? parsableNalUnitBitArray.readBits(8) : -1;
            if (h265VpsData != null && h265VpsData.repFormatsAndIndices != null) {
                if (readBits2 == -1) {
                    readBits2 = h265VpsData.repFormatsAndIndices.indices[i17];
                }
                if (readBits2 != -1 && h265VpsData.repFormatsAndIndices.repFormats.size() > readBits2) {
                    H265RepFormat h265RepFormat = h265VpsData.repFormatsAndIndices.repFormats.get(readBits2);
                    readUnsignedExpGolombCodedInt = h265RepFormat.chromaFormatIdc;
                    i4 = h265RepFormat.width;
                    i5 = h265RepFormat.height;
                    readUnsignedExpGolombCodedInt2 = h265RepFormat.bitDepthLumaMinus8;
                    readUnsignedExpGolombCodedInt3 = h265RepFormat.bitDepthChromaMinus8;
                }
            }
            i5 = 0;
            readUnsignedExpGolombCodedInt2 = 0;
            readUnsignedExpGolombCodedInt3 = 0;
            readUnsignedExpGolombCodedInt = 0;
            i4 = 0;
        } else {
            readUnsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            if (readUnsignedExpGolombCodedInt == 3) {
                parsableNalUnitBitArray.skipBit();
            }
            int readUnsignedExpGolombCodedInt5 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int readUnsignedExpGolombCodedInt6 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            if (parsableNalUnitBitArray.readBit()) {
                int readUnsignedExpGolombCodedInt7 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                int readUnsignedExpGolombCodedInt8 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                int readUnsignedExpGolombCodedInt9 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                int readUnsignedExpGolombCodedInt10 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                i4 = applyConformanceWindowToWidth(readUnsignedExpGolombCodedInt5, readUnsignedExpGolombCodedInt, readUnsignedExpGolombCodedInt7, readUnsignedExpGolombCodedInt8);
                i5 = applyConformanceWindowToHeight(readUnsignedExpGolombCodedInt6, readUnsignedExpGolombCodedInt, readUnsignedExpGolombCodedInt9, readUnsignedExpGolombCodedInt10);
            } else {
                i4 = readUnsignedExpGolombCodedInt5;
                i5 = readUnsignedExpGolombCodedInt6;
            }
            readUnsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            readUnsignedExpGolombCodedInt3 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        }
        int readUnsignedExpGolombCodedInt11 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        if (z) {
            i6 = -1;
        } else {
            i6 = -1;
            for (int i18 = parsableNalUnitBitArray.readBit() ? 0 : readBits; i18 <= readBits; i18++) {
                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                i6 = Math.max(parsableNalUnitBitArray.readUnsignedExpGolombCodedInt(), i6);
                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            }
        }
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        if (parsableNalUnitBitArray.readBit()) {
            if (z ? parsableNalUnitBitArray.readBit() : false) {
                parsableNalUnitBitArray.skipBits(6);
            } else if (parsableNalUnitBitArray.readBit()) {
                skipH265ScalingList(parsableNalUnitBitArray);
            }
        }
        int i19 = 2;
        parsableNalUnitBitArray.skipBits(2);
        if (parsableNalUnitBitArray.readBit()) {
            parsableNalUnitBitArray.skipBits(8);
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.skipBit();
        }
        skipH265ShortTermReferencePictureSets(parsableNalUnitBitArray);
        if (parsableNalUnitBitArray.readBit()) {
            int readUnsignedExpGolombCodedInt12 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int i20 = 0;
            while (i20 < readUnsignedExpGolombCodedInt12) {
                parsableNalUnitBitArray.skipBits(readUnsignedExpGolombCodedInt11 + 5);
                i20++;
                i19 = 2;
            }
        }
        parsableNalUnitBitArray.skipBits(i19);
        float f = 1.0f;
        if (parsableNalUnitBitArray.readBit()) {
            if (parsableNalUnitBitArray.readBit()) {
                int readBits3 = parsableNalUnitBitArray.readBits(8);
                if (readBits3 == 255) {
                    int readBits4 = parsableNalUnitBitArray.readBits(16);
                    int readBits5 = parsableNalUnitBitArray.readBits(16);
                    if (readBits4 != 0 && readBits5 != 0) {
                        f = readBits4 / readBits5;
                    }
                } else {
                    float[] fArr = ASPECT_RATIO_IDC_VALUES;
                    if (readBits3 < fArr.length) {
                        f = fArr[readBits3];
                    } else {
                        Log.w(TAG, "Unexpected aspect_ratio_idc value: " + readBits3);
                    }
                }
            }
            if (parsableNalUnitBitArray.readBit()) {
                parsableNalUnitBitArray.skipBit();
            }
            if (parsableNalUnitBitArray.readBit()) {
                parsableNalUnitBitArray.skipBits(3);
                i13 = parsableNalUnitBitArray.readBit() ? 1 : 2;
                if (parsableNalUnitBitArray.readBit()) {
                    int readBits6 = parsableNalUnitBitArray.readBits(8);
                    int readBits7 = parsableNalUnitBitArray.readBits(8);
                    parsableNalUnitBitArray.skipBits(8);
                    i15 = ColorInfo.isoColorPrimariesToColorSpace(readBits6);
                    i16 = ColorInfo.isoTransferCharacteristicsToColorTransfer(readBits7);
                    i10 = i15;
                }
                i16 = -1;
                i10 = -1;
            } else if (h265VpsData == null || h265VpsData.videoSignalInfosAndIndices == null || h265VpsData.videoSignalInfosAndIndices.videoSignalInfos.size() <= (i14 = h265VpsData.videoSignalInfosAndIndices.indices[i17])) {
                i13 = -1;
                i16 = -1;
                i10 = -1;
            } else {
                H265VideoSignalInfo h265VideoSignalInfo = h265VpsData.videoSignalInfosAndIndices.videoSignalInfos.get(i14);
                i15 = h265VideoSignalInfo.colorSpace;
                int i21 = h265VideoSignalInfo.colorRange;
                i16 = h265VideoSignalInfo.colorTransfer;
                i13 = i21;
                i10 = i15;
            }
            if (parsableNalUnitBitArray.readBit()) {
                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            }
            parsableNalUnitBitArray.skipBit();
            if (parsableNalUnitBitArray.readBit()) {
                i5 *= 2;
            }
            int i22 = readUnsignedExpGolombCodedInt3;
            i11 = i13;
            i8 = i22;
            i7 = readBits;
            i9 = readUnsignedExpGolombCodedInt;
            i12 = i16;
        } else {
            i7 = readBits;
            i8 = readUnsignedExpGolombCodedInt3;
            i9 = readUnsignedExpGolombCodedInt;
            i10 = -1;
            i11 = -1;
            i12 = -1;
        }
        return new H265SpsData(h265NalHeader, i7, h265ProfileTierLevel, i9, readUnsignedExpGolombCodedInt2, i8, readUnsignedExpGolombCodedInt4, i4, i5, f, i6, i10, i11, i12);
    }

    public static PpsData parsePpsNalUnit(byte[] bArr, int i, int i2) {
        return parsePpsNalUnitPayload(bArr, i + 1, i2);
    }

    public static PpsData parsePpsNalUnitPayload(byte[] bArr, int i, int i2) {
        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, i, i2);
        int readUnsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        int readUnsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.skipBit();
        return new PpsData(readUnsignedExpGolombCodedInt, readUnsignedExpGolombCodedInt2, parsableNalUnitBitArray.readBit());
    }

    public static H265Sei3dRefDisplayInfoData parseH265Sei3dRefDisplayInfo(byte[] bArr, int i, int i2) {
        byte b;
        int max;
        int max2;
        int i3 = i + 2;
        while (true) {
            i2--;
            b = bArr[i2];
            if (b != 0 || i2 <= i3) {
                break;
            }
        }
        if (b != 0 && i2 > i3) {
            ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, i3, i2 + 1);
            while (parsableNalUnitBitArray.canReadBits(16)) {
                int readBits = parsableNalUnitBitArray.readBits(8);
                int i4 = 0;
                while (readBits == 255) {
                    i4 += 255;
                    readBits = parsableNalUnitBitArray.readBits(8);
                }
                int i5 = i4 + readBits;
                int readBits2 = parsableNalUnitBitArray.readBits(8);
                int i6 = 0;
                while (readBits2 == 255) {
                    i6 += 255;
                    readBits2 = parsableNalUnitBitArray.readBits(8);
                }
                int i7 = i6 + readBits2;
                if (i7 == 0 || !parsableNalUnitBitArray.canReadBits(i7)) {
                    break;
                } else if (i5 == 176) {
                    int readUnsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    boolean readBit = parsableNalUnitBitArray.readBit();
                    int readUnsignedExpGolombCodedInt2 = readBit ? parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() : 0;
                    int readUnsignedExpGolombCodedInt3 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    int i8 = -1;
                    int i9 = -1;
                    int i10 = -1;
                    int i11 = -1;
                    int i12 = -1;
                    int i13 = -1;
                    for (int i14 = 0; i14 <= readUnsignedExpGolombCodedInt3; i14++) {
                        i8 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                        i9 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                        i10 = parsableNalUnitBitArray.readBits(6);
                        if (i10 == 63) {
                            return null;
                        }
                        if (i10 == 0) {
                            max = Math.max(0, readUnsignedExpGolombCodedInt - 30);
                        } else {
                            max = Math.max(0, (i10 + readUnsignedExpGolombCodedInt) - 31);
                        }
                        i11 = parsableNalUnitBitArray.readBits(max);
                        if (readBit) {
                            int readBits3 = parsableNalUnitBitArray.readBits(6);
                            if (readBits3 == 63) {
                                return null;
                            }
                            if (readBits3 == 0) {
                                max2 = Math.max(0, readUnsignedExpGolombCodedInt2 - 30);
                            } else {
                                max2 = Math.max(0, (readBits3 + readUnsignedExpGolombCodedInt2) - 31);
                            }
                            i12 = readBits3;
                            i13 = parsableNalUnitBitArray.readBits(max2);
                        }
                        if (parsableNalUnitBitArray.readBit()) {
                            parsableNalUnitBitArray.skipBits(10);
                        }
                    }
                    return new H265Sei3dRefDisplayInfoData(readUnsignedExpGolombCodedInt, readUnsignedExpGolombCodedInt2, readUnsignedExpGolombCodedInt3 + 1, i8, i9, i10, i11, i12, i13);
                }
            }
        }
        return null;
    }

    public static int findNalUnit(byte[] bArr, int i, int i2, boolean[] zArr) {
        int i3 = i2 - i;
        Assertions.checkState(i3 >= 0);
        if (i3 == 0) {
            return i2;
        }
        if (zArr[0]) {
            clearPrefixFlags(zArr);
            return i - 3;
        } else if (i3 > 1 && zArr[1] && bArr[i] == 1) {
            clearPrefixFlags(zArr);
            return i - 2;
        } else if (i3 > 2 && zArr[2] && bArr[i] == 0 && bArr[i + 1] == 1) {
            clearPrefixFlags(zArr);
            return i - 1;
        } else {
            int i4 = i2 - 1;
            int i5 = i + 2;
            while (i5 < i4) {
                byte b = bArr[i5];
                if ((b & 254) == 0) {
                    int i6 = i5 - 2;
                    if (bArr[i6] == 0 && bArr[i5 - 1] == 0 && b == 1) {
                        clearPrefixFlags(zArr);
                        return i6;
                    }
                    i5 -= 2;
                }
                i5 += 3;
            }
            zArr[0] = i3 <= 2 ? !(i3 != 2 ? !(zArr[1] && bArr[i4] == 1) : !(zArr[2] && bArr[i2 + (-2)] == 0 && bArr[i4] == 1)) : bArr[i2 + (-3)] == 0 && bArr[i2 + (-2)] == 0 && bArr[i4] == 1;
            zArr[1] = i3 <= 1 ? zArr[2] && bArr[i4] == 0 : bArr[i2 + (-2)] == 0 && bArr[i4] == 0;
            zArr[2] = bArr[i4] == 0;
            return i2;
        }
    }

    public static void clearPrefixFlags(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static String getH265BaseLayerCodecsString(List<byte[]> list) {
        for (int i = 0; i < list.size(); i++) {
            byte[] bArr = list.get(i);
            int length = bArr.length;
            if (length > 3) {
                ImmutableList<Integer> findNalUnitPositions = findNalUnitPositions(bArr);
                for (int i2 = 0; i2 < findNalUnitPositions.size(); i2++) {
                    if (findNalUnitPositions.get(i2).intValue() + 3 < length) {
                        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, findNalUnitPositions.get(i2).intValue() + 3, length);
                        H265NalHeader parseH265NalHeader = parseH265NalHeader(parsableNalUnitBitArray);
                        if (parseH265NalHeader.nalUnitType == 33 && parseH265NalHeader.layerId == 0) {
                            return createCodecStringFromH265SpsPalyoad(parsableNalUnitBitArray);
                        }
                    }
                }
                continue;
            }
        }
        return null;
    }

    private static ImmutableList<Integer> findNalUnitPositions(byte[] bArr) {
        boolean[] zArr = new boolean[3];
        ImmutableList.Builder builder = ImmutableList.builder();
        int i = 0;
        while (i < bArr.length) {
            int findNalUnit = findNalUnit(bArr, i, bArr.length, zArr);
            if (findNalUnit != bArr.length) {
                builder.add((ImmutableList.Builder) Integer.valueOf(findNalUnit));
            }
            i = findNalUnit + 3;
        }
        return builder.build();
    }

    private static String createCodecStringFromH265SpsPalyoad(ParsableNalUnitBitArray parsableNalUnitBitArray) {
        parsableNalUnitBitArray.skipBits(4);
        int readBits = parsableNalUnitBitArray.readBits(3);
        parsableNalUnitBitArray.skipBit();
        H265ProfileTierLevel parseH265ProfileTierLevel = parseH265ProfileTierLevel(parsableNalUnitBitArray, true, readBits, null);
        return CodecSpecificDataUtil.buildHevcCodecString(parseH265ProfileTierLevel.generalProfileSpace, parseH265ProfileTierLevel.generalTierFlag, parseH265ProfileTierLevel.generalProfileIdc, parseH265ProfileTierLevel.generalProfileCompatibilityFlags, parseH265ProfileTierLevel.constraintBytes, parseH265ProfileTierLevel.generalLevelIdc);
    }

    private static int findNextUnescapeIndex(byte[] bArr, int i, int i2) {
        while (i < i2 - 2) {
            if (bArr[i] == 0 && bArr[i + 1] == 0 && bArr[i + 2] == 3) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    private static void skipH265HrdParameters(ParsableNalUnitBitArray parsableNalUnitBitArray, boolean z, int i) {
        int i2;
        int i3;
        boolean z2;
        boolean readBit;
        if (z) {
            boolean readBit2 = parsableNalUnitBitArray.readBit();
            boolean readBit3 = parsableNalUnitBitArray.readBit();
            if (readBit2 || readBit3) {
                z2 = parsableNalUnitBitArray.readBit();
                if (z2) {
                    parsableNalUnitBitArray.skipBits(19);
                }
                parsableNalUnitBitArray.skipBits(8);
                if (z2) {
                    parsableNalUnitBitArray.skipBits(4);
                }
                parsableNalUnitBitArray.skipBits(15);
                i3 = readBit3;
                i2 = readBit2;
            } else {
                z2 = false;
                i3 = readBit3;
                i2 = readBit2;
            }
        } else {
            i2 = 0;
            i3 = 0;
            z2 = false;
        }
        for (int i4 = 0; i4 <= i; i4++) {
            boolean readBit4 = parsableNalUnitBitArray.readBit();
            if (!readBit4) {
                readBit4 = parsableNalUnitBitArray.readBit();
            }
            if (readBit4) {
                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                readBit = false;
            } else {
                readBit = parsableNalUnitBitArray.readBit();
            }
            int readUnsignedExpGolombCodedInt = !readBit ? parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() : 0;
            int i5 = i2 + i3;
            for (int i6 = 0; i6 < i5; i6++) {
                for (int i7 = 0; i7 <= readUnsignedExpGolombCodedInt; i7++) {
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    if (z2) {
                        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    }
                    parsableNalUnitBitArray.skipBit();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static H265ProfileTierLevel parseH265ProfileTierLevel(ParsableNalUnitBitArray parsableNalUnitBitArray, boolean z, int i, H265ProfileTierLevel h265ProfileTierLevel) {
        int[] iArr;
        int i2;
        boolean z2;
        int i3;
        int i4;
        boolean z3;
        int i5;
        int i6;
        int[] iArr2 = new int[6];
        if (z) {
            int readBits = parsableNalUnitBitArray.readBits(2);
            z3 = parsableNalUnitBitArray.readBit();
            i5 = parsableNalUnitBitArray.readBits(5);
            i6 = 0;
            for (int i7 = 0; i7 < 32; i7++) {
                if (parsableNalUnitBitArray.readBit()) {
                    i6 |= 1 << i7;
                }
            }
            for (int i8 = 0; i8 < 6; i8++) {
                iArr2[i8] = parsableNalUnitBitArray.readBits(8);
            }
            i2 = readBits;
        } else if (h265ProfileTierLevel != null) {
            int i9 = h265ProfileTierLevel.generalProfileSpace;
            z3 = h265ProfileTierLevel.generalTierFlag;
            i5 = h265ProfileTierLevel.generalProfileIdc;
            i6 = h265ProfileTierLevel.generalProfileCompatibilityFlags;
            iArr2 = h265ProfileTierLevel.constraintBytes;
            i2 = i9;
        } else {
            iArr = iArr2;
            i2 = 0;
            z2 = false;
            i3 = 0;
            i4 = 0;
            int readBits2 = parsableNalUnitBitArray.readBits(8);
            int i10 = 0;
            for (int i11 = 0; i11 < i; i11++) {
                if (parsableNalUnitBitArray.readBit()) {
                    i10 += 88;
                }
                if (parsableNalUnitBitArray.readBit()) {
                    i10 += 8;
                }
            }
            parsableNalUnitBitArray.skipBits(i10);
            if (i > 0) {
                parsableNalUnitBitArray.skipBits((8 - i) * 2);
            }
            return new H265ProfileTierLevel(i2, z2, i3, i4, iArr, readBits2);
        }
        iArr = iArr2;
        z2 = z3;
        i3 = i5;
        i4 = i6;
        int readBits22 = parsableNalUnitBitArray.readBits(8);
        int i102 = 0;
        while (i11 < i) {
        }
        parsableNalUnitBitArray.skipBits(i102);
        if (i > 0) {
        }
        return new H265ProfileTierLevel(i2, z2, i3, i4, iArr, readBits22);
    }

    private static H265RepFormatsAndIndices parseH265RepFormatsAndIndices(ParsableNalUnitBitArray parsableNalUnitBitArray, int i) {
        int readUnsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        int i2 = readUnsignedExpGolombCodedInt + 1;
        ImmutableList.Builder builderWithExpectedSize = ImmutableList.builderWithExpectedSize(i2);
        int[] iArr = new int[i];
        for (int i3 = 0; i3 < i2; i3++) {
            builderWithExpectedSize.add((ImmutableList.Builder) parseH265RepFormat(parsableNalUnitBitArray));
        }
        int i4 = 1;
        if (i2 <= 1 || !parsableNalUnitBitArray.readBit()) {
            while (i4 < i) {
                iArr[i4] = Math.min(i4, readUnsignedExpGolombCodedInt);
                i4++;
            }
        } else {
            int log2 = DoubleMath.log2(i2, RoundingMode.CEILING);
            while (i4 < i) {
                iArr[i4] = parsableNalUnitBitArray.readBits(log2);
                i4++;
            }
        }
        return new H265RepFormatsAndIndices(builderWithExpectedSize.build(), iArr);
    }

    private static H265RepFormat parseH265RepFormat(ParsableNalUnitBitArray parsableNalUnitBitArray) {
        int i;
        int i2;
        int i3;
        int readBits = parsableNalUnitBitArray.readBits(16);
        int readBits2 = parsableNalUnitBitArray.readBits(16);
        if (parsableNalUnitBitArray.readBit()) {
            int readBits3 = parsableNalUnitBitArray.readBits(2);
            if (readBits3 == 3) {
                parsableNalUnitBitArray.skipBit();
            }
            int readBits4 = parsableNalUnitBitArray.readBits(4);
            i3 = parsableNalUnitBitArray.readBits(4);
            i2 = readBits4;
            i = readBits3;
        } else {
            i = 0;
            i2 = 0;
            i3 = 0;
        }
        if (parsableNalUnitBitArray.readBit()) {
            int readUnsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int readUnsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int readUnsignedExpGolombCodedInt3 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int readUnsignedExpGolombCodedInt4 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            readBits = applyConformanceWindowToWidth(readBits, i, readUnsignedExpGolombCodedInt, readUnsignedExpGolombCodedInt2);
            readBits2 = applyConformanceWindowToHeight(readBits2, i, readUnsignedExpGolombCodedInt3, readUnsignedExpGolombCodedInt4);
        }
        return new H265RepFormat(i, i2, i3, readBits, readBits2);
    }

    private static void skipH265DpbSize(ParsableNalUnitBitArray parsableNalUnitBitArray, int i, int[] iArr, int[] iArr2, boolean[][] zArr) {
        boolean z;
        for (int i2 = 1; i2 < i; i2++) {
            boolean readBit = parsableNalUnitBitArray.readBit();
            int i3 = 0;
            while (i3 < iArr[i2]) {
                if (i3 <= 0 || !readBit) {
                    z = i3 == 0;
                } else {
                    z = parsableNalUnitBitArray.readBit();
                }
                if (z) {
                    for (int i4 = 0; i4 < iArr2[i2]; i4++) {
                        if (zArr[i2][i4]) {
                            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                        }
                    }
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                }
                i3++;
            }
        }
    }

    private static void skipToH265VuiPresentFlagAfterDpbSize(ParsableNalUnitBitArray parsableNalUnitBitArray, int i, boolean[][] zArr) {
        int readUnsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 2;
        if (parsableNalUnitBitArray.readBit()) {
            parsableNalUnitBitArray.skipBits(readUnsignedExpGolombCodedInt);
        } else {
            for (int i2 = 1; i2 < i; i2++) {
                for (int i3 = 0; i3 < i2; i3++) {
                    if (zArr[i2][i3]) {
                        parsableNalUnitBitArray.skipBits(readUnsignedExpGolombCodedInt);
                    }
                }
            }
        }
        int readUnsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        for (int i4 = 1; i4 <= readUnsignedExpGolombCodedInt2; i4++) {
            parsableNalUnitBitArray.skipBits(8);
        }
    }

    private static H265VideoSignalInfosAndIndices parseH265VideoSignalInfosAndIndices(ParsableNalUnitBitArray parsableNalUnitBitArray, int i, int i2, int[] iArr) {
        if (!parsableNalUnitBitArray.readBit() ? parsableNalUnitBitArray.readBit() : true) {
            parsableNalUnitBitArray.skipBit();
        }
        boolean readBit = parsableNalUnitBitArray.readBit();
        boolean readBit2 = parsableNalUnitBitArray.readBit();
        if (readBit || readBit2) {
            for (int i3 = 0; i3 < i2; i3++) {
                for (int i4 = 0; i4 < iArr[i3]; i4++) {
                    boolean readBit3 = readBit ? parsableNalUnitBitArray.readBit() : false;
                    boolean readBit4 = readBit2 ? parsableNalUnitBitArray.readBit() : false;
                    if (readBit3) {
                        parsableNalUnitBitArray.skipBits(32);
                    }
                    if (readBit4) {
                        parsableNalUnitBitArray.skipBits(18);
                    }
                }
            }
        }
        boolean readBit5 = parsableNalUnitBitArray.readBit();
        int readBits = readBit5 ? parsableNalUnitBitArray.readBits(4) + 1 : i;
        ImmutableList.Builder builderWithExpectedSize = ImmutableList.builderWithExpectedSize(readBits);
        int[] iArr2 = new int[i];
        for (int i5 = 0; i5 < readBits; i5++) {
            builderWithExpectedSize.add((ImmutableList.Builder) parseH265VideoSignalInfo(parsableNalUnitBitArray));
        }
        if (readBit5 && readBits > 1) {
            for (int i6 = 0; i6 < i; i6++) {
                iArr2[i6] = parsableNalUnitBitArray.readBits(4);
            }
        }
        return new H265VideoSignalInfosAndIndices(builderWithExpectedSize.build(), iArr2);
    }

    private static H265VideoSignalInfo parseH265VideoSignalInfo(ParsableNalUnitBitArray parsableNalUnitBitArray) {
        parsableNalUnitBitArray.skipBits(3);
        int i = parsableNalUnitBitArray.readBit() ? 1 : 2;
        int isoColorPrimariesToColorSpace = ColorInfo.isoColorPrimariesToColorSpace(parsableNalUnitBitArray.readBits(8));
        int isoTransferCharacteristicsToColorTransfer = ColorInfo.isoTransferCharacteristicsToColorTransfer(parsableNalUnitBitArray.readBits(8));
        parsableNalUnitBitArray.skipBits(8);
        return new H265VideoSignalInfo(isoColorPrimariesToColorSpace, i, isoTransferCharacteristicsToColorTransfer);
    }

    private static void skipScalingList(ParsableNalUnitBitArray parsableNalUnitBitArray, int i) {
        int i2 = 8;
        int i3 = 8;
        for (int i4 = 0; i4 < i; i4++) {
            if (i2 != 0) {
                i2 = ((parsableNalUnitBitArray.readSignedExpGolombCodedInt() + i3) + 256) % 256;
            }
            if (i2 != 0) {
                i3 = i2;
            }
        }
    }

    private static void skipHrdParameters(ParsableNalUnitBitArray parsableNalUnitBitArray) {
        int readUnsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1;
        parsableNalUnitBitArray.skipBits(8);
        for (int i = 0; i < readUnsignedExpGolombCodedInt; i++) {
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.skipBit();
        }
        parsableNalUnitBitArray.skipBits(20);
    }

    private static void skipH265ScalingList(ParsableNalUnitBitArray parsableNalUnitBitArray) {
        for (int i = 0; i < 4; i++) {
            int i2 = 0;
            while (i2 < 6) {
                int i3 = 1;
                if (!parsableNalUnitBitArray.readBit()) {
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                } else {
                    int min = Math.min(64, 1 << ((i << 1) + 4));
                    if (i > 1) {
                        parsableNalUnitBitArray.readSignedExpGolombCodedInt();
                    }
                    for (int i4 = 0; i4 < min; i4++) {
                        parsableNalUnitBitArray.readSignedExpGolombCodedInt();
                    }
                }
                if (i == 3) {
                    i3 = 3;
                }
                i2 += i3;
            }
        }
    }

    private static void skipH265ShortTermReferencePictureSets(ParsableNalUnitBitArray parsableNalUnitBitArray) {
        int readUnsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        int[] iArr = new int[0];
        int[] iArr2 = new int[0];
        int i = -1;
        int i2 = -1;
        for (int i3 = 0; i3 < readUnsignedExpGolombCodedInt; i3++) {
            if (i3 != 0 && parsableNalUnitBitArray.readBit()) {
                int i4 = i + i2;
                int readUnsignedExpGolombCodedInt2 = (1 - ((parsableNalUnitBitArray.readBit() ? 1 : 0) * 2)) * (parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1);
                int i5 = i4 + 1;
                boolean[] zArr = new boolean[i5];
                for (int i6 = 0; i6 <= i4; i6++) {
                    if (!parsableNalUnitBitArray.readBit()) {
                        zArr[i6] = parsableNalUnitBitArray.readBit();
                    } else {
                        zArr[i6] = true;
                    }
                }
                int[] iArr3 = new int[i5];
                int[] iArr4 = new int[i5];
                int i7 = 0;
                for (int i8 = i2 - 1; i8 >= 0; i8--) {
                    int i9 = iArr2[i8] + readUnsignedExpGolombCodedInt2;
                    if (i9 < 0 && zArr[i + i8]) {
                        iArr3[i7] = i9;
                        i7++;
                    }
                }
                if (readUnsignedExpGolombCodedInt2 < 0 && zArr[i4]) {
                    iArr3[i7] = readUnsignedExpGolombCodedInt2;
                    i7++;
                }
                for (int i10 = 0; i10 < i; i10++) {
                    int i11 = iArr[i10] + readUnsignedExpGolombCodedInt2;
                    if (i11 < 0 && zArr[i10]) {
                        iArr3[i7] = i11;
                        i7++;
                    }
                }
                int[] copyOf = Arrays.copyOf(iArr3, i7);
                int i12 = 0;
                for (int i13 = i - 1; i13 >= 0; i13--) {
                    int i14 = iArr[i13] + readUnsignedExpGolombCodedInt2;
                    if (i14 > 0 && zArr[i13]) {
                        iArr4[i12] = i14;
                        i12++;
                    }
                }
                if (readUnsignedExpGolombCodedInt2 > 0 && zArr[i4]) {
                    iArr4[i12] = readUnsignedExpGolombCodedInt2;
                    i12++;
                }
                for (int i15 = 0; i15 < i2; i15++) {
                    int i16 = iArr2[i15] + readUnsignedExpGolombCodedInt2;
                    if (i16 > 0 && zArr[i + i15]) {
                        iArr4[i12] = i16;
                        i12++;
                    }
                }
                iArr2 = Arrays.copyOf(iArr4, i12);
                iArr = copyOf;
                i = i7;
                i2 = i12;
            } else {
                int readUnsignedExpGolombCodedInt3 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                int readUnsignedExpGolombCodedInt4 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                int[] iArr5 = new int[readUnsignedExpGolombCodedInt3];
                int i17 = 0;
                while (i17 < readUnsignedExpGolombCodedInt3) {
                    iArr5[i17] = (i17 > 0 ? iArr5[i17 - 1] : 0) - (parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1);
                    parsableNalUnitBitArray.skipBit();
                    i17++;
                }
                int[] iArr6 = new int[readUnsignedExpGolombCodedInt4];
                int i18 = 0;
                while (i18 < readUnsignedExpGolombCodedInt4) {
                    iArr6[i18] = (i18 > 0 ? iArr6[i18 - 1] : 0) + parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1;
                    parsableNalUnitBitArray.skipBit();
                    i18++;
                }
                i = readUnsignedExpGolombCodedInt3;
                iArr = iArr5;
                i2 = readUnsignedExpGolombCodedInt4;
                iArr2 = iArr6;
            }
        }
    }

    private NalUnitUtil() {
    }
}
