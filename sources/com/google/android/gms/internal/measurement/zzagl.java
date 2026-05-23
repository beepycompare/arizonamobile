package com.google.android.gms.internal.measurement;

import androidx.window.core.layout.WindowSizeClass;
import com.google.common.base.Ascii;
import java.nio.charset.StandardCharsets;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzagl {
    static {
        int i = zzacf.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zza(byte[] bArr, int i, int i2) {
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
                                    throw new zzagk(i2, length2);
                                }
                                i2++;
                            }
                        }
                        i2++;
                    }
                    i3 += i;
                } catch (zzagk unused) {
                    return str.getBytes(StandardCharsets.UTF_8).length;
                }
            }
        }
        if (i3 >= length) {
            return i3;
        }
        long j = i3 + 4294967296L;
        StringBuilder sb = new StringBuilder(String.valueOf(j).length() + 34);
        sb.append("UTF-8 length does not fit in int: ");
        sb.append(j);
        throw new IllegalArgumentException(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001e, code lost:
        return r12 + r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int zzc(String str, byte[] bArr, int i, int i2) {
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
                    return zzagj.zza(str, bArr, i, i2);
                } else if (charAt2 >= 55296 && charAt2 <= 57343 && ((i4 = i6 + 1) == str.length() || !Character.isSurrogatePair(charAt2, str.charAt(i4)))) {
                    return zzagj.zza(str, bArr, i, i2);
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
    public static String zzd(byte[] bArr, int i, int i2) throws zzaeh {
        int i3;
        if (i2 != 0) {
            int length = bArr.length;
            if ((((length - i) - i2) | i | i2) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(i), Integer.valueOf(i2)));
            }
            int i4 = i + i2;
            char[] cArr = new char[i2];
            int i5 = 0;
            while (i < i4) {
                byte b = bArr[i];
                if (!zzagh.zza(b)) {
                    break;
                }
                i++;
                cArr[i5] = (char) b;
                i5++;
            }
            int i6 = i5;
            while (i < i4) {
                int i7 = i + 1;
                byte b2 = bArr[i];
                if (zzagh.zza(b2)) {
                    cArr[i6] = (char) b2;
                    i6++;
                    i = i7;
                    while (i < i4) {
                        byte b3 = bArr[i];
                        if (zzagh.zza(b3)) {
                            i++;
                            cArr[i6] = (char) b3;
                            i6++;
                        }
                    }
                } else {
                    if (b2 < -32) {
                        if (i7 < i4) {
                            i3 = i6 + 1;
                            i += 2;
                            zzagh.zzb(b2, bArr[i7], cArr, i6);
                        } else {
                            throw new zzaeh("Protocol message had invalid UTF-8.");
                        }
                    } else if (b2 < -16) {
                        if (i7 < i4 - 1) {
                            i3 = i6 + 1;
                            int i8 = i + 2;
                            i += 3;
                            zzagh.zzc(b2, bArr[i7], bArr[i8], cArr, i6);
                        } else {
                            throw new zzaeh("Protocol message had invalid UTF-8.");
                        }
                    } else if (i7 < i4 - 2) {
                        int i9 = i + 3;
                        i += 4;
                        zzagh.zzd(b2, bArr[i7], bArr[i + 2], bArr[i9], cArr, i6);
                        i6 += 2;
                    } else {
                        throw new zzaeh("Protocol message had invalid UTF-8.");
                    }
                    i6 = i3;
                }
            }
            return new String(cArr, 0, i6);
        }
        return "";
    }
}
