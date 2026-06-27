package com.google.android.billing;

import com.google.common.base.Ascii;
import okio.Utf8;
/* loaded from: classes3.dex */
public class Base64 {
    static final /* synthetic */ boolean $assertionsDisabled = true;
    public static final boolean DECODE = false;
    public static final boolean ENCODE = true;
    private static final byte EQUALS_SIGN = 61;
    private static final byte EQUALS_SIGN_ENC = -1;
    private static final byte NEW_LINE = 10;
    private static final byte[] ALPHABET = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] WEBSAFE_ALPHABET = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private static final byte WHITE_SPACE_ENC = -5;
    private static final byte[] DECODABET = {-9, -9, -9, -9, -9, -9, -9, -9, -9, WHITE_SPACE_ENC, WHITE_SPACE_ENC, -9, -9, WHITE_SPACE_ENC, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, WHITE_SPACE_ENC, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, Utf8.REPLACEMENT_BYTE, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Ascii.VT, Ascii.FF, Ascii.CR, Ascii.SO, Ascii.SI, Ascii.DLE, 17, Ascii.DC2, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM, -9, -9, -9, -9, -9, -9, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9};
    private static final byte[] WEBSAFE_DECODABET = {-9, -9, -9, -9, -9, -9, -9, -9, -9, WHITE_SPACE_ENC, WHITE_SPACE_ENC, -9, -9, WHITE_SPACE_ENC, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, WHITE_SPACE_ENC, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Ascii.VT, Ascii.FF, Ascii.CR, Ascii.SO, Ascii.SI, Ascii.DLE, 17, Ascii.DC2, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM, -9, -9, -9, -9, Utf8.REPLACEMENT_BYTE, -9, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9};

    private Base64() {
    }

    public static byte[] decode(String str) throws Base64DecoderException {
        byte[] bytes = str.getBytes();
        return decode(bytes, 0, bytes.length);
    }

    public static byte[] decode(byte[] bArr) throws Base64DecoderException {
        return decode(bArr, 0, bArr.length);
    }

    public static byte[] decode(byte[] bArr, int i, int i2) throws Base64DecoderException {
        return decode(bArr, i, i2, DECODABET);
    }

    public static byte[] decode(byte[] bArr, int i, int i2, byte[] bArr2) throws Base64DecoderException {
        int i3;
        byte[] bArr3 = new byte[((i2 * 3) / 4) + 2];
        byte[] bArr4 = new byte[4];
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (i4 >= i2) {
                break;
            }
            byte b = (byte) (bArr[i4 + i] & Byte.MAX_VALUE);
            byte b2 = bArr2[b];
            if (b2 < -5) {
                throw new Base64DecoderException("Bad Base64 input character at " + i4 + ": " + ((int) bArr[i3]) + "(decimal)");
            }
            if (b2 >= -1) {
                if (b == 61) {
                    int i7 = i2 - i4;
                    byte b3 = (byte) (bArr[(i2 - 1) + i] & Byte.MAX_VALUE);
                    if (i6 == 0 || i6 == 1) {
                        throw new Base64DecoderException("invalid padding byte '=' at byte offset " + i4);
                    }
                    if ((i6 == 3 && i7 > 2) || (i6 == 4 && i7 > 1)) {
                        throw new Base64DecoderException("padding byte '=' falsely signals end of encoded value at offset " + i4);
                    }
                    if (b3 != 61 && b3 != 10) {
                        throw new Base64DecoderException("encoded value has invalid trailing byte");
                    }
                } else {
                    int i8 = i6 + 1;
                    bArr4[i6] = b;
                    if (i8 == 4) {
                        i5 += decode4to3(bArr4, 0, bArr3, i5, bArr2);
                        i6 = 0;
                    } else {
                        i6 = i8;
                    }
                }
            }
            i4++;
        }
        if (i6 != 0) {
            if (i6 == 1) {
                throw new Base64DecoderException("single trailing character at offset " + (i2 - 1));
            }
            bArr4[i6] = 61;
            i5 += decode4to3(bArr4, 0, bArr3, i5, bArr2);
        }
        byte[] bArr5 = new byte[i5];
        System.arraycopy(bArr3, 0, bArr5, 0, i5);
        return bArr5;
    }

    private static int decode4to3(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3) {
        byte b = bArr[i + 2];
        if (b == 61) {
            bArr2[i2] = (byte) ((((bArr3[bArr[i + 1]] << Ascii.CAN) >>> 12) | ((bArr3[bArr[i]] << Ascii.CAN) >>> 6)) >>> 16);
            return 1;
        }
        byte b2 = bArr[i + 3];
        if (b2 == 61) {
            int i3 = ((bArr3[bArr[i + 1]] << Ascii.CAN) >>> 12) | ((bArr3[bArr[i]] << Ascii.CAN) >>> 6) | ((bArr3[b] << Ascii.CAN) >>> 18);
            bArr2[i2] = (byte) (i3 >>> 16);
            bArr2[i2 + 1] = (byte) (i3 >>> 8);
            return 2;
        }
        int i4 = ((bArr3[bArr[i + 1]] << Ascii.CAN) >>> 12) | ((bArr3[bArr[i]] << Ascii.CAN) >>> 6) | ((bArr3[b] << Ascii.CAN) >>> 18) | ((bArr3[b2] << Ascii.CAN) >>> 24);
        bArr2[i2] = (byte) (i4 >> 16);
        bArr2[i2 + 1] = (byte) (i4 >> 8);
        bArr2[i2 + 2] = (byte) i4;
        return 3;
    }

    public static byte[] decodeWebSafe(String str) throws Base64DecoderException {
        byte[] bytes = str.getBytes();
        return decodeWebSafe(bytes, 0, bytes.length);
    }

    public static byte[] decodeWebSafe(byte[] bArr) throws Base64DecoderException {
        return decodeWebSafe(bArr, 0, bArr.length);
    }

    public static byte[] decodeWebSafe(byte[] bArr, int i, int i2) throws Base64DecoderException {
        return decode(bArr, i, i2, WEBSAFE_DECODABET);
    }

    public static String encode(byte[] bArr) {
        return encode(bArr, 0, bArr.length, ALPHABET, true);
    }

    public static String encode(byte[] bArr, int i, int i2, byte[] bArr2, boolean z) {
        byte[] encode = encode(bArr, i, i2, bArr2, Integer.MAX_VALUE);
        int length = encode.length;
        while (!z && length > 0) {
            int i3 = length - 1;
            if (encode[i3] != 61) {
                break;
            }
            length = i3;
        }
        return new String(encode, 0, length);
    }

    public static byte[] encode(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int i4 = ((i2 + 2) / 3) * 4;
        int i5 = (i4 / i3) + i4;
        byte[] bArr3 = new byte[i5];
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i6 < i2 - 2) {
            int i9 = ((bArr[i6 + i] << Ascii.CAN) >>> 8) | ((bArr[(i6 + 1) + i] << Ascii.CAN) >>> 16) | ((bArr[(i6 + 2) + i] << Ascii.CAN) >>> 24);
            bArr3[i7] = bArr2[i9 >>> 18];
            int i10 = i7 + 1;
            bArr3[i10] = bArr2[(i9 >>> 12) & 63];
            bArr3[i7 + 2] = bArr2[(i9 >>> 6) & 63];
            bArr3[i7 + 3] = bArr2[i9 & 63];
            i8 += 4;
            if (i8 == i3) {
                bArr3[i7 + 4] = 10;
                i8 = 0;
                i7 = i10;
            }
            i6 += 3;
            i7 += 4;
        }
        if (i6 < i2) {
            encode3to4(bArr, i6 + i, i2 - i6, bArr3, i7, bArr2);
            if (i8 + 4 == i3) {
                bArr3[i7 + 4] = 10;
                i7++;
            }
            i7 += 4;
        }
        if ($assertionsDisabled || i7 == i5) {
            return bArr3;
        }
        throw new AssertionError();
    }

    private static byte[] encode3to4(byte[] bArr, int i, int i2, byte[] bArr2, int i3, byte[] bArr3) {
        int i4 = i2 > 0 ? (bArr[i] << Ascii.CAN) >>> 8 : 0;
        int i5 = (i2 > 1 ? (bArr[i + 1] << Ascii.CAN) >>> 16 : 0) | i4 | (i2 > 2 ? (bArr[i + 2] << Ascii.CAN) >>> 24 : 0);
        if (i2 == 1) {
            bArr2[i3] = bArr3[i5 >>> 18];
            bArr2[i3 + 1] = bArr3[(i5 >>> 12) & 63];
            bArr2[i3 + 2] = 61;
            bArr2[i3 + 3] = 61;
            return bArr2;
        } else if (i2 == 2) {
            bArr2[i3] = bArr3[i5 >>> 18];
            bArr2[i3 + 1] = bArr3[(i5 >>> 12) & 63];
            bArr2[i3 + 2] = bArr3[(i5 >>> 6) & 63];
            bArr2[i3 + 3] = 61;
            return bArr2;
        } else if (i2 != 3) {
            return bArr2;
        } else {
            bArr2[i3] = bArr3[i5 >>> 18];
            bArr2[i3 + 1] = bArr3[(i5 >>> 12) & 63];
            bArr2[i3 + 2] = bArr3[(i5 >>> 6) & 63];
            bArr2[i3 + 3] = bArr3[i5 & 63];
            return bArr2;
        }
    }

    public static String encodeWebSafe(byte[] bArr, boolean z) {
        return encode(bArr, 0, bArr.length, WEBSAFE_ALPHABET, z);
    }
}
