package androidx.media3.common;

import android.os.Bundle;
import androidx.media3.common.util.Util;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.dataflow.qual.Pure;
/* loaded from: classes2.dex */
public final class ColorInfo {
    public final int chromaBitdepth;
    public final int colorRange;
    public final int colorSpace;
    public final int colorTransfer;
    private int hashCode;
    public final byte[] hdrStaticInfo;
    public final int lumaBitdepth;
    public static final ColorInfo SDR_BT709_LIMITED = new Builder().setColorSpace(1).setColorRange(2).setColorTransfer(3).build();
    public static final ColorInfo SRGB_BT709_FULL = new Builder().setColorSpace(1).setColorRange(1).setColorTransfer(2).build();
    private static final String FIELD_COLOR_SPACE = Util.intToStringMaxRadix(0);
    private static final String FIELD_COLOR_RANGE = Util.intToStringMaxRadix(1);
    private static final String FIELD_COLOR_TRANSFER = Util.intToStringMaxRadix(2);
    private static final String FIELD_HDR_STATIC_INFO = Util.intToStringMaxRadix(3);
    private static final String FIELD_LUMA_BITDEPTH = Util.intToStringMaxRadix(4);
    private static final String FIELD_CHROMA_BITDEPTH = Util.intToStringMaxRadix(5);

    public static int colorSpaceToIsoColorPrimaries(int i) {
        if (i != 2) {
            return i != 6 ? 1 : 9;
        }
        return 5;
    }

    public static int colorSpaceToIsoMatrixCoefficients(int i) {
        if (i != 2) {
            return i != 6 ? 1 : 9;
        }
        return 6;
    }

    public static int colorTransferToIsoTransferCharacteristics(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 6) {
                    if (i != 7) {
                        return i != 10 ? 1 : 4;
                    }
                    return 18;
                }
                return 16;
            }
            return 13;
        }
        return 8;
    }

    @Pure
    public static int isoColorPrimariesToColorSpace(int i) {
        if (i != 1) {
            if (i != 9) {
                return (i == 4 || i == 5 || i == 6 || i == 7) ? 2 : -1;
            }
            return 6;
        }
        return 1;
    }

    @Pure
    public static int isoTransferCharacteristicsToColorTransfer(int i) {
        if (i != 1) {
            if (i != 4) {
                if (i != 13) {
                    if (i != 16) {
                        if (i != 18) {
                            return (i == 6 || i == 7) ? 3 : -1;
                        }
                        return 7;
                    }
                    return 6;
                }
                return 2;
            }
            return 10;
        }
        return 3;
    }

    /* loaded from: classes2.dex */
    public static final class Builder {
        private int chromaBitdepth;
        private int colorRange;
        private int colorSpace;
        private int colorTransfer;
        private byte[] hdrStaticInfo;
        private int lumaBitdepth;

        public Builder() {
            this.colorSpace = -1;
            this.colorRange = -1;
            this.colorTransfer = -1;
            this.lumaBitdepth = -1;
            this.chromaBitdepth = -1;
        }

        private Builder(ColorInfo colorInfo) {
            this.colorSpace = colorInfo.colorSpace;
            this.colorRange = colorInfo.colorRange;
            this.colorTransfer = colorInfo.colorTransfer;
            this.hdrStaticInfo = colorInfo.hdrStaticInfo;
            this.lumaBitdepth = colorInfo.lumaBitdepth;
            this.chromaBitdepth = colorInfo.chromaBitdepth;
        }

        public Builder setColorSpace(int i) {
            this.colorSpace = i;
            return this;
        }

        public Builder setColorRange(int i) {
            this.colorRange = i;
            return this;
        }

        public Builder setColorTransfer(int i) {
            this.colorTransfer = i;
            return this;
        }

        public Builder setHdrStaticInfo(byte[] bArr) {
            this.hdrStaticInfo = bArr;
            return this;
        }

        public Builder setLumaBitdepth(int i) {
            this.lumaBitdepth = i;
            return this;
        }

        public Builder setChromaBitdepth(int i) {
            this.chromaBitdepth = i;
            return this;
        }

        public ColorInfo build() {
            return new ColorInfo(this.colorSpace, this.colorRange, this.colorTransfer, this.hdrStaticInfo, this.lumaBitdepth, this.chromaBitdepth);
        }
    }

    @EnsuresNonNullIf(expression = {"#1"}, result = false)
    public static boolean isEquivalentToAssumedSdrDefault(ColorInfo colorInfo) {
        if (colorInfo == null) {
            return true;
        }
        int i = colorInfo.colorSpace;
        if (i == -1 || i == 1 || i == 2) {
            int i2 = colorInfo.colorRange;
            if (i2 == -1 || i2 == 2) {
                int i3 = colorInfo.colorTransfer;
                if ((i3 == -1 || i3 == 3) && colorInfo.hdrStaticInfo == null) {
                    int i4 = colorInfo.chromaBitdepth;
                    if (i4 == -1 || i4 == 8) {
                        int i5 = colorInfo.lumaBitdepth;
                        return i5 == -1 || i5 == 8;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public static boolean isTransferHdr(ColorInfo colorInfo) {
        if (colorInfo != null) {
            int i = colorInfo.colorTransfer;
            return i == 7 || i == 6;
        }
        return false;
    }

    private ColorInfo(int i, int i2, int i3, byte[] bArr, int i4, int i5) {
        this.colorSpace = i;
        this.colorRange = i2;
        this.colorTransfer = i3;
        this.hdrStaticInfo = bArr;
        this.lumaBitdepth = i4;
        this.chromaBitdepth = i5;
    }

    public Builder buildUpon() {
        return new Builder();
    }

    public boolean isValid() {
        return isBitdepthValid() || isDataSpaceValid();
    }

    public boolean isBitdepthValid() {
        return (this.lumaBitdepth == -1 || this.chromaBitdepth == -1) ? false : true;
    }

    public boolean isDataSpaceValid() {
        return (this.colorSpace == -1 || this.colorRange == -1 || this.colorTransfer == -1) ? false : true;
    }

    public String toLogString() {
        String str;
        if (isDataSpaceValid()) {
            str = Util.formatInvariant("%s/%s/%s", colorSpaceToString(this.colorSpace), colorRangeToString(this.colorRange), colorTransferToString(this.colorTransfer));
        } else {
            str = "NA/NA/NA";
        }
        return str + RemoteSettings.FORWARD_SLASH_STRING + (isBitdepthValid() ? this.lumaBitdepth + RemoteSettings.FORWARD_SLASH_STRING + this.chromaBitdepth : "NA/NA");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ColorInfo colorInfo = (ColorInfo) obj;
            if (this.colorSpace == colorInfo.colorSpace && this.colorRange == colorInfo.colorRange && this.colorTransfer == colorInfo.colorTransfer && Arrays.equals(this.hdrStaticInfo, colorInfo.hdrStaticInfo) && this.lumaBitdepth == colorInfo.lumaBitdepth && this.chromaBitdepth == colorInfo.chromaBitdepth) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = ((((((((((527 + this.colorSpace) * 31) + this.colorRange) * 31) + this.colorTransfer) * 31) + Arrays.hashCode(this.hdrStaticInfo)) * 31) + this.lumaBitdepth) * 31) + this.chromaBitdepth;
        }
        return this.hashCode;
    }

    public String toString() {
        return "ColorInfo(" + colorSpaceToString(this.colorSpace) + ", " + colorRangeToString(this.colorRange) + ", " + colorTransferToString(this.colorTransfer) + ", " + (this.hdrStaticInfo != null) + ", " + lumaBitdepthToString(this.lumaBitdepth) + ", " + chromaBitdepthToString(this.chromaBitdepth) + ")";
    }

    private static String lumaBitdepthToString(int i) {
        return i != -1 ? i + "bit Luma" : "NA";
    }

    private static String chromaBitdepthToString(int i) {
        return i != -1 ? i + "bit Chroma" : "NA";
    }

    private static String colorSpaceToString(int i) {
        if (i != -1) {
            if (i != 6) {
                if (i != 1) {
                    if (i == 2) {
                        return "BT601";
                    }
                    return "Undefined color space " + i;
                }
                return "BT709";
            }
            return "BT2020";
        }
        return "Unset color space";
    }

    private static String colorTransferToString(int i) {
        if (i != -1) {
            if (i != 10) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 6) {
                                if (i == 7) {
                                    return "HLG";
                                }
                                return "Undefined color transfer " + i;
                            }
                            return "ST2084 PQ";
                        }
                        return "SDR SMPTE 170M";
                    }
                    return "sRGB";
                }
                return "Linear";
            }
            return "Gamma 2.2";
        }
        return "Unset color transfer";
    }

    private static String colorRangeToString(int i) {
        if (i != -1) {
            if (i != 1) {
                if (i == 2) {
                    return "Limited range";
                }
                return "Undefined color range " + i;
            }
            return "Full range";
        }
        return "Unset color range";
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(FIELD_COLOR_SPACE, this.colorSpace);
        bundle.putInt(FIELD_COLOR_RANGE, this.colorRange);
        bundle.putInt(FIELD_COLOR_TRANSFER, this.colorTransfer);
        bundle.putByteArray(FIELD_HDR_STATIC_INFO, this.hdrStaticInfo);
        bundle.putInt(FIELD_LUMA_BITDEPTH, this.lumaBitdepth);
        bundle.putInt(FIELD_CHROMA_BITDEPTH, this.chromaBitdepth);
        return bundle;
    }

    public static ColorInfo fromBundle(Bundle bundle) {
        return new ColorInfo(bundle.getInt(FIELD_COLOR_SPACE, -1), bundle.getInt(FIELD_COLOR_RANGE, -1), bundle.getInt(FIELD_COLOR_TRANSFER, -1), bundle.getByteArray(FIELD_HDR_STATIC_INFO), bundle.getInt(FIELD_LUMA_BITDEPTH, -1), bundle.getInt(FIELD_CHROMA_BITDEPTH, -1));
    }
}
