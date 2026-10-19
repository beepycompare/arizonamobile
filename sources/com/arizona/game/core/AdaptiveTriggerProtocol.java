package com.arizona.game.core;

import com.google.common.base.Ascii;
import java.util.Arrays;
/* loaded from: classes3.dex */
final class AdaptiveTriggerProtocol {
    static final int FEEDBACK_MODE = 33;
    static final int[] OFF = {5, 0, 0, 0, 5, 0, 0, 0};
    static final int OFF_MODE = 5;
    static final int SIZE = 48;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean dualSense(int i, int i2) {
        if (i == 1356) {
            return i2 == 3302 || i2 == 3570;
        }
        return false;
    }

    static boolean dualShock4(int i, int i2) {
        if (i == 1356) {
            return i2 == 1476 || i2 == 2508;
        }
        return false;
    }

    AdaptiveTriggerProtocol() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean supported(int i, int i2) {
        return dualSense(i, i2) || dualShock4(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] report(int[] iArr) {
        byte[] bArr = new byte[48];
        bArr[0] = 2;
        bArr[1] = Ascii.FF;
        channel(bArr, 22, iArr, 0);
        channel(bArr, 11, iArr, 4);
        return bArr;
    }

    private static void channel(byte[] bArr, int i, int[] iArr, int i2) {
        int i3 = iArr[i2];
        bArr[i] = (byte) i3;
        if (i3 != 33) {
            for (int i4 = 1; i4 <= 3; i4++) {
                bArr[i + i4] = (byte) iArr[i2 + i4];
            }
            return;
        }
        int i5 = iArr[i2 + 1];
        int i6 = iArr[i2 + 2];
        if (i5 < 0 || i5 > 9 || i6 < 1 || i6 > 8 || iArr[i2 + 3] != 0) {
            return;
        }
        long j = 0;
        int i7 = 0;
        while (i5 < 10) {
            i7 |= 1 << i5;
            j |= (i6 - 1) << (i5 * 3);
            i5++;
        }
        bArr[i + 1] = (byte) i7;
        bArr[i + 2] = (byte) (i7 >> 8);
        for (int i8 = 0; i8 < 4; i8++) {
            bArr[i + 3 + i8] = (byte) (j >> (i8 * 8));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean safe(byte[] bArr) {
        if (bArr.length == 48) {
            if (bArr[0] == 2 && bArr[1] == 12) {
                for (int i = 2; i < 48; i++) {
                    if ((i < 11 || i > 32) && bArr[i] != 0) {
                        return false;
                    }
                }
                if (safeChannel(bArr, 11) && safeChannel(bArr, 22)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean safeChannel(byte[] bArr, int i) {
        int i2 = bArr[i] & 255;
        if (i2 == 33) {
            for (int i3 = 7; i3 <= 10; i3++) {
                if (bArr[i + i3] != 0) {
                    return false;
                }
            }
            int i4 = (bArr[i + 1] & 255) | ((bArr[i + 2] & 255) << 8);
            long j = 0;
            for (int i5 = 0; i5 < 4; i5++) {
                j |= (bArr[(i + 3) + i5] & 255) << (i5 * 8);
            }
            if (i4 != 0 && (i4 & (-1024)) == 0 && (j >>> 30) == 0) {
                for (int i6 = 0; i6 < 10; i6++) {
                    if (((1 << i6) & i4) == 0 && ((j >> (i6 * 3)) & 7) != 0) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        for (int i7 = 4; i7 <= 10; i7++) {
            if (bArr[i + i7] != 0) {
                return false;
            }
        }
        int i8 = bArr[i + 1] & 255;
        int i9 = bArr[i + 2] & 255;
        int i10 = bArr[i + 3] & 255;
        return (i2 == 5 && i8 == 0 && i9 == 0 && i10 == 0) || (i2 == 2 && i8 < i9 && i10 > 0) || (i2 == 6 && i8 > 0 && i9 > 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] expireRecoil(byte[] bArr, long j, long j2) {
        if (bArr[11] == 6) {
            if (j2 == 0 || j - j2 >= 0) {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[11] = 5;
                Arrays.fill(bArr2, 12, 22, (byte) 0);
                return bArr2;
            }
            return bArr;
        }
        return bArr;
    }
}
