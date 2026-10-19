package kotlinx.metadata.internal.metadata.jvm.deserialization;

import java.util.ArrayList;
/* loaded from: classes5.dex */
public class BitEncoding {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final boolean FORCE_8TO7_ENCODING;
    private static final char _8TO7_MODE_MARKER = 65535;

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str = (i == 1 || i == 3 || i == 6 || i == 8 || i == 10 || i == 12 || i == 14) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 1 || i == 3 || i == 6 || i == 8 || i == 10 || i == 12 || i == 14) ? 2 : 3];
        if (i == 1 || i == 3 || i == 6 || i == 8 || i == 10 || i == 12 || i == 14) {
            objArr[0] = "kotlinx/metadata/internal/metadata/jvm/deserialization/BitEncoding";
        } else {
            objArr[0] = "data";
        }
        if (i == 1) {
            objArr[1] = "encodeBytes";
        } else if (i == 3) {
            objArr[1] = "encode8to7";
        } else if (i == 6) {
            objArr[1] = "splitBytesToStringArray";
        } else if (i == 8) {
            objArr[1] = "decodeBytes";
        } else if (i == 10) {
            objArr[1] = "dropMarker";
        } else if (i == 12) {
            objArr[1] = "combineStringArrayIntoBytes";
        } else if (i != 14) {
            objArr[1] = "kotlinx/metadata/internal/metadata/jvm/deserialization/BitEncoding";
        } else {
            objArr[1] = "decode7to8";
        }
        switch (i) {
            case 1:
            case 3:
            case 6:
            case 8:
            case 10:
            case 12:
            case 14:
                break;
            case 2:
                objArr[2] = "encode8to7";
                break;
            case 4:
                objArr[2] = "addModuloByte";
                break;
            case 5:
                objArr[2] = "splitBytesToStringArray";
                break;
            case 7:
                objArr[2] = "decodeBytes";
                break;
            case 9:
                objArr[2] = "dropMarker";
                break;
            case 11:
                objArr[2] = "combineStringArrayIntoBytes";
                break;
            case 13:
                objArr[2] = "decode7to8";
                break;
            default:
                objArr[2] = "encodeBytes";
                break;
        }
        String format = String.format(str, objArr);
        if (i != 1 && i != 3 && i != 6 && i != 8 && i != 10 && i != 12 && i != 14) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    static {
        String str;
        try {
            str = System.getProperty("kotlin.jvm.serialization.use8to7");
        } catch (SecurityException unused) {
            str = null;
        }
        FORCE_8TO7_ENCODING = "true".equals(str);
    }

    private BitEncoding() {
    }

    public static String[] encodeBytes(byte[] bArr) {
        if (bArr == null) {
            $$$reportNull$$$0(0);
        }
        if (!FORCE_8TO7_ENCODING) {
            String[] bytesToStrings = UtfEncodingKt.bytesToStrings(bArr);
            if (bytesToStrings == null) {
                $$$reportNull$$$0(1);
            }
            return bytesToStrings;
        }
        byte[] encode8to7 = encode8to7(bArr);
        addModuloByte(encode8to7, 1);
        return splitBytesToStringArray(encode8to7);
    }

    private static byte[] encode8to7(byte[] bArr) {
        int i;
        if (bArr == null) {
            $$$reportNull$$$0(2);
        }
        int length = ((bArr.length * 8) + 6) / 7;
        byte[] bArr2 = new byte[length];
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            i = length - 1;
            if (i2 >= i) {
                break;
            }
            if (i3 == 0) {
                bArr2[i2] = (byte) (bArr[i4] & Byte.MAX_VALUE);
                i3 = 7;
            } else {
                int i5 = (i3 + 7) & 7;
                i4++;
                bArr2[i2] = (byte) (((bArr[i4] & 255) >>> i3) + ((bArr[i4] & ((1 << i5) - 1)) << (8 - i3)));
                i3 = i5;
            }
            i2++;
        }
        if (length > 0) {
            bArr2[i] = (byte) ((bArr[i4] & 255) >>> i3);
        }
        return bArr2;
    }

    private static void addModuloByte(byte[] bArr, int i) {
        if (bArr == null) {
            $$$reportNull$$$0(4);
        }
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i2] = (byte) ((bArr[i2] + i) & 127);
        }
    }

    private static String[] splitBytesToStringArray(byte[] bArr) {
        if (bArr == null) {
            $$$reportNull$$$0(5);
        }
        ArrayList arrayList = new ArrayList();
        int length = bArr.length;
        int i = 2;
        int i2 = 0;
        boolean z = false;
        for (int i3 = 0; i3 < length; i3++) {
            if (i >= 65534) {
                String str = new String(bArr, i2, i3 - i2);
                if (!z) {
                    arrayList.add("\uffff".concat(str));
                    z = true;
                } else {
                    arrayList.add(str);
                }
                i = 0;
                i2 = i3;
            }
            i = bArr[i3] == 0 ? i + 2 : i + 1;
        }
        if (i >= 0) {
            arrayList.add(new String(bArr, i2, bArr.length - i2));
        }
        String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        if (strArr == null) {
            $$$reportNull$$$0(6);
        }
        return strArr;
    }

    public static byte[] decodeBytes(String[] strArr) {
        if (strArr == null) {
            $$$reportNull$$$0(7);
        }
        if (strArr.length > 0 && !strArr[0].isEmpty()) {
            char charAt = strArr[0].charAt(0);
            if (charAt == 0) {
                byte[] stringsToBytes = UtfEncodingKt.stringsToBytes(dropMarker(strArr));
                if (stringsToBytes == null) {
                    $$$reportNull$$$0(8);
                }
                return stringsToBytes;
            } else if (charAt == 65535) {
                strArr = dropMarker(strArr);
            }
        }
        byte[] combineStringArrayIntoBytes = combineStringArrayIntoBytes(strArr);
        addModuloByte(combineStringArrayIntoBytes, 127);
        return decode7to8(combineStringArrayIntoBytes);
    }

    private static String[] dropMarker(String[] strArr) {
        if (strArr == null) {
            $$$reportNull$$$0(9);
        }
        String[] strArr2 = (String[]) strArr.clone();
        strArr2[0] = strArr2[0].substring(1);
        if (strArr2 == null) {
            $$$reportNull$$$0(10);
        }
        return strArr2;
    }

    private static byte[] combineStringArrayIntoBytes(String[] strArr) {
        if (strArr == null) {
            $$$reportNull$$$0(11);
        }
        int i = 0;
        for (String str : strArr) {
            i += str.length();
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (String str2 : strArr) {
            int length = str2.length();
            int i3 = 0;
            while (i3 < length) {
                bArr[i2] = (byte) str2.charAt(i3);
                i3++;
                i2++;
            }
        }
        return bArr;
    }

    private static byte[] decode7to8(byte[] bArr) {
        if (bArr == null) {
            $$$reportNull$$$0(13);
        }
        int length = (bArr.length * 7) / 8;
        byte[] bArr2 = new byte[length];
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = i + 1;
            int i5 = i2 + 1;
            bArr2[i3] = (byte) (((bArr[i] & 255) >>> i2) + ((bArr[i4] & ((1 << i5) - 1)) << (7 - i2)));
            if (i2 == 6) {
                i += 2;
                i2 = 0;
            } else {
                i = i4;
                i2 = i5;
            }
        }
        return bArr2;
    }
}
