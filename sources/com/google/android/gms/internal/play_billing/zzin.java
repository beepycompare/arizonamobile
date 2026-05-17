package com.google.android.gms.internal.play_billing;

import androidx.window.core.layout.WindowSizeClass;
import com.google.common.base.Ascii;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes4.dex */
public final class zzin {
    public static final /* synthetic */ int zza = 0;

    static {
        try {
            if (System.getenv("PROTOBUF_DISABLE_UNSAFE_UTF8_PROCESSOR_FOR_TESTING") != null) {
                return;
            }
        } catch (SecurityException unused) {
        }
        if (zzii.zzx() && zzii.zzy()) {
            int i = zzei.zza;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001e, code lost:
        return r12 + r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int zza(String str, byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        int i5;
        char charAt;
        int length = str.length();
        int i6 = 0;
        while (true) {
            i3 = i + i2;
            if (i6 >= length || (i5 = i6 + i) >= i3 || (charAt = str.charAt(i6)) >= 128) {
                break;
            }
            bArr[i5] = (byte) charAt;
            i6++;
        }
        int i7 = i + i6;
        while (i6 < length) {
            char charAt2 = str.charAt(i6);
            if (charAt2 < 128 && i7 < i3) {
                bArr[i7] = (byte) charAt2;
                i7++;
            } else if (charAt2 < 2048 && i7 <= i3 - 2) {
                bArr[i7] = (byte) ((charAt2 >>> 6) | 960);
                bArr[i7 + 1] = (byte) ((charAt2 & '?') | 128);
                i7 += 2;
            } else if ((charAt2 >= 55296 && charAt2 <= 57343) || i7 > i3 - 3) {
                if (i7 <= i3 - 4) {
                    i6++;
                    if (i6 != str.length()) {
                        char charAt3 = str.charAt(i6);
                        if (Character.isSurrogatePair(charAt2, charAt3)) {
                            int i8 = i7 + 3;
                            int codePoint = Character.toCodePoint(charAt2, charAt3);
                            bArr[i7] = (byte) ((codePoint >>> 18) | 240);
                            bArr[i7 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                            bArr[i7 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                            i7 += 4;
                            bArr[i8] = (byte) ((codePoint & 63) | 128);
                        }
                    }
                    return zzil.zza(str, bArr, i, i2);
                } else if (charAt2 >= 55296 && charAt2 <= 57343 && ((i4 = i6 + 1) == str.length() || !Character.isSurrogatePair(charAt2, str.charAt(i4)))) {
                    return zzil.zza(str, bArr, i, i2);
                } else {
                    throw new ArrayIndexOutOfBoundsException("Not enough space in output buffer to encode UTF-8 string");
                }
            } else {
                bArr[i7] = (byte) ((charAt2 >>> '\f') | WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND);
                bArr[i7 + 1] = (byte) (((charAt2 >>> 6) & 63) | 128);
                bArr[i7 + 2] = (byte) ((charAt2 & '?') | 128);
                i7 += 3;
            }
            i6++;
        }
        return i7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(String str) {
        int length = str.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && str.charAt(i2) < 128) {
            i2++;
        }
        int i3 = length;
        while (true) {
            if (i2 >= length) {
                break;
            }
            char charAt = str.charAt(i2);
            if (charAt < 2048) {
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                try {
                    int length2 = str.length();
                    while (i2 < length2) {
                        char charAt2 = str.charAt(i2);
                        if (charAt2 < 2048) {
                            i += (127 - charAt2) >>> 31;
                        } else {
                            i += 2;
                            if (charAt2 >= 55296 && charAt2 <= 57343) {
                                if (Character.codePointAt(str, i2) < 65536) {
                                    throw new zzim(i2, length2);
                                }
                                i2++;
                            }
                        }
                        i2++;
                    }
                    i3 += i;
                } catch (zzim unused) {
                    return str.getBytes(zzga.zza).length;
                }
            }
        }
        if (i3 >= length) {
            return i3;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (i3 + 4294967296L));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzc(byte[] bArr, int i, int i2) {
        while (i < i2 && bArr[i] >= 0) {
            i++;
        }
        if (i >= i2) {
            return true;
        }
        while (i < i2) {
            int i3 = i + 1;
            byte b = bArr[i];
            if (b >= 0) {
                i = i3;
            } else if (b < -32) {
                if (i3 < i2 && b >= -62) {
                    i += 2;
                    if (bArr[i3] > -65) {
                    }
                }
                return false;
            } else if (b >= -16) {
                if (i3 >= i2 - 2) {
                    return false;
                }
                int i4 = i + 2;
                byte b2 = bArr[i3];
                if (b2 <= -65 && (((b << Ascii.FS) + (b2 + 112)) >> 30) == 0) {
                    int i5 = i + 3;
                    if (bArr[i4] <= -65) {
                        i += 4;
                        if (bArr[i5] > -65) {
                        }
                    }
                }
                return false;
            } else if (i3 >= i2 - 1) {
                return false;
            } else {
                int i6 = i + 2;
                byte b3 = bArr[i3];
                if (b3 > -65 || (b == -32 && b3 < -96)) {
                    return false;
                }
                if (b == -19 && b3 >= -96) {
                    return false;
                }
                i += 3;
                if (bArr[i6] > -65) {
                    return false;
                }
            }
        }
        return true;
    }
}
