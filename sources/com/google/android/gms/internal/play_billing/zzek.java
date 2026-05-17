package com.google.android.gms.internal.play_billing;

import com.google.common.base.Ascii;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes4.dex */
public final class zzek {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzb = 100;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(byte[] bArr, int i, zzej zzejVar) throws zzgc {
        int zzi = zzi(bArr, i, zzejVar);
        int i2 = zzejVar.zza;
        if (i2 < 0) {
            throw new zzgc("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i2 <= bArr.length - zzi) {
            if (i2 == 0) {
                zzejVar.zzc = zzev.zza;
                return zzi;
            }
            zzejVar.zzc = zzev.zzk(bArr, zzi, i2);
            return zzi + i2;
        }
        throw new zzgc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(byte[] bArr, int i) {
        int i2 = (bArr[i + 1] & 255) << 8;
        return ((bArr[i + 3] & 255) << 24) | i2 | (bArr[i] & 255) | ((bArr[i + 2] & 255) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(zzhl zzhlVar, byte[] bArr, int i, int i2, int i3, zzej zzejVar) throws IOException {
        Object zze = zzhlVar.zze();
        int zzm = zzm(zze, zzhlVar, bArr, i, i2, i3, zzejVar);
        zzhlVar.zzf(zze);
        zzejVar.zzc = zze;
        return zzm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(zzhl zzhlVar, byte[] bArr, int i, int i2, zzej zzejVar) throws IOException {
        Object zze = zzhlVar.zze();
        int zzn = zzn(zze, zzhlVar, bArr, i, i2, zzejVar);
        zzhlVar.zzf(zze);
        zzejVar.zzc = zze;
        return zzn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(zzhl zzhlVar, int i, byte[] bArr, int i2, int i3, zzfz zzfzVar, zzej zzejVar) throws IOException {
        int zzd = zzd(zzhlVar, bArr, i2, i3, zzejVar);
        zzfzVar.add(zzejVar.zzc);
        while (zzd < i3) {
            int zzi = zzi(bArr, zzd, zzejVar);
            if (i != zzejVar.zza) {
                break;
            }
            zzd = zzd(zzhlVar, bArr, zzi, i3, zzejVar);
            zzfzVar.add(zzejVar.zzc);
        }
        return zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(byte[] bArr, int i, zzfz zzfzVar, zzej zzejVar) throws IOException {
        zzfv zzfvVar = (zzfv) zzfzVar;
        int zzi = zzi(bArr, i, zzejVar);
        int i2 = zzejVar.zza + zzi;
        while (zzi < i2) {
            zzi = zzi(bArr, zzi, zzejVar);
            zzfvVar.zzg(zzejVar.zza);
        }
        if (zzi == i2) {
            return zzi;
        }
        throw new zzgc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(byte[] bArr, int i, zzej zzejVar) throws zzgc {
        int i2;
        int zzi = zzi(bArr, i, zzejVar);
        int i3 = zzejVar.zza;
        if (i3 >= 0) {
            if (i3 == 0) {
                zzejVar.zzc = "";
                return zzi;
            }
            int i4 = zzin.zza;
            int length = bArr.length;
            if ((((length - zzi) - i3) | zzi | i3) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(zzi), Integer.valueOf(i3)));
            }
            int i5 = zzi + i3;
            char[] cArr = new char[i3];
            int i6 = 0;
            while (zzi < i5) {
                byte b = bArr[zzi];
                if (!zzij.zzd(b)) {
                    break;
                }
                zzi++;
                cArr[i6] = (char) b;
                i6++;
            }
            int i7 = i6;
            while (zzi < i5) {
                int i8 = zzi + 1;
                byte b2 = bArr[zzi];
                if (zzij.zzd(b2)) {
                    cArr[i7] = (char) b2;
                    i7++;
                    zzi = i8;
                    while (zzi < i5) {
                        byte b3 = bArr[zzi];
                        if (zzij.zzd(b3)) {
                            zzi++;
                            cArr[i7] = (char) b3;
                            i7++;
                        }
                    }
                } else {
                    if (b2 < -32) {
                        if (i8 < i5) {
                            i2 = i7 + 1;
                            zzi += 2;
                            zzij.zzc(b2, bArr[i8], cArr, i7);
                        } else {
                            throw new zzgc("Protocol message had invalid UTF-8.");
                        }
                    } else if (b2 < -16) {
                        if (i8 < i5 - 1) {
                            i2 = i7 + 1;
                            int i9 = zzi + 2;
                            zzi += 3;
                            zzij.zzb(b2, bArr[i8], bArr[i9], cArr, i7);
                        } else {
                            throw new zzgc("Protocol message had invalid UTF-8.");
                        }
                    } else if (i8 < i5 - 2) {
                        int i10 = zzi + 3;
                        zzi += 4;
                        zzij.zza(b2, bArr[i8], bArr[zzi + 2], bArr[i10], cArr, i7);
                        i7 += 2;
                    } else {
                        throw new zzgc("Protocol message had invalid UTF-8.");
                    }
                    i7 = i2;
                }
            }
            zzejVar.zzc = new String(cArr, 0, i7);
            return i5;
        }
        throw new zzgc("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(int i, byte[] bArr, int i2, int i3, zzic zzicVar, zzej zzejVar) throws zzgc {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int zzl = zzl(bArr, i2, zzejVar);
                zzicVar.zzj(i, Long.valueOf(zzejVar.zzb));
                return zzl;
            } else if (i4 == 1) {
                zzicVar.zzj(i, Long.valueOf(zzp(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int zzi = zzi(bArr, i2, zzejVar);
                int i5 = zzejVar.zza;
                if (i5 < 0) {
                    throw new zzgc("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                }
                if (i5 <= bArr.length - zzi) {
                    if (i5 == 0) {
                        zzicVar.zzj(i, zzev.zza);
                    } else {
                        zzicVar.zzj(i, zzev.zzk(bArr, zzi, i5));
                    }
                    return zzi + i5;
                }
                throw new zzgc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            } else if (i4 != 3) {
                if (i4 != 5) {
                    throw new zzgc("Protocol message contained an invalid tag (zero).");
                }
                zzicVar.zzj(i, Integer.valueOf(zzb(bArr, i2)));
                return i2 + 4;
            } else {
                int i6 = (i & (-8)) | 4;
                zzic zzf = zzic.zzf();
                int i7 = zzejVar.zze + 1;
                zzejVar.zze = i7;
                zzq(i7);
                int i8 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int zzi2 = zzi(bArr, i2, zzejVar);
                    int i9 = zzejVar.zza;
                    if (i9 == i6) {
                        i8 = i9;
                        i2 = zzi2;
                        break;
                    }
                    i2 = zzh(i9, bArr, zzi2, i3, zzf, zzejVar);
                    i8 = i9;
                }
                zzejVar.zze--;
                if (i2 > i3 || i8 != i6) {
                    throw new zzgc("Failed to parse the message.");
                }
                zzicVar.zzj(i, zzf);
                return i2;
            }
        }
        throw new zzgc("Protocol message contained an invalid tag (zero).");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(byte[] bArr, int i, zzej zzejVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b >= 0) {
            zzejVar.zza = b;
            return i2;
        }
        return zzj(b, bArr, i2, zzejVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(int i, byte[] bArr, int i2, zzej zzejVar) {
        byte b = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & 127;
        if (b >= 0) {
            zzejVar.zza = i4 | (b << 7);
            return i3;
        }
        int i5 = i4 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            zzejVar.zza = i5 | (b2 << Ascii.SO);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzejVar.zza = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzejVar.zza = i9 | (b4 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzejVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzk(int i, byte[] bArr, int i2, int i3, zzfz zzfzVar, zzej zzejVar) {
        zzfv zzfvVar = (zzfv) zzfzVar;
        int zzi = zzi(bArr, i2, zzejVar);
        zzfvVar.zzg(zzejVar.zza);
        while (zzi < i3) {
            int zzi2 = zzi(bArr, zzi, zzejVar);
            if (i != zzejVar.zza) {
                break;
            }
            zzi = zzi(bArr, zzi2, zzejVar);
            zzfvVar.zzg(zzejVar.zza);
        }
        return zzi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzl(byte[] bArr, int i, zzej zzejVar) {
        byte b;
        long j = bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            zzejVar.zzb = j;
            return i2;
        }
        int i3 = i + 2;
        byte b2 = bArr[i2];
        long j2 = (j & 127) | ((b2 & Byte.MAX_VALUE) << 7);
        int i4 = 7;
        while (b2 < 0) {
            int i5 = i3 + 1;
            i4 += 7;
            j2 |= (b & Byte.MAX_VALUE) << i4;
            b2 = bArr[i3];
            i3 = i5;
        }
        zzejVar.zzb = j2;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzm(Object obj, zzhl zzhlVar, byte[] bArr, int i, int i2, int i3, zzej zzejVar) throws IOException {
        int i4 = zzejVar.zze + 1;
        zzejVar.zze = i4;
        zzq(i4);
        int zzc = ((zzhe) zzhlVar).zzc(obj, bArr, i, i2, i3, zzejVar);
        zzejVar.zze--;
        zzejVar.zzc = obj;
        return zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzn(Object obj, zzhl zzhlVar, byte[] bArr, int i, int i2, zzej zzejVar) throws IOException {
        int i3 = i + 1;
        int i4 = bArr[i];
        if (i4 < 0) {
            i3 = zzj(i4, bArr, i3, zzejVar);
            i4 = zzejVar.zza;
        }
        int i5 = i3;
        if (i4 < 0 || i4 > i2 - i5) {
            throw new zzgc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i6 = zzejVar.zze + 1;
        zzejVar.zze = i6;
        zzq(i6);
        int i7 = i5 + i4;
        zzhlVar.zzh(obj, bArr, i5, i7, zzejVar);
        zzejVar.zze--;
        zzejVar.zzc = obj;
        return i7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzo(int i, byte[] bArr, int i2, int i3, zzej zzejVar) throws zzgc {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            if (i4 == 5) {
                                return i2 + 4;
                            }
                            throw new zzgc("Protocol message contained an invalid tag (zero).");
                        }
                        int i5 = (i & (-8)) | 4;
                        int i6 = 0;
                        while (i2 < i3) {
                            i2 = zzi(bArr, i2, zzejVar);
                            i6 = zzejVar.zza;
                            if (i6 == i5) {
                                break;
                            }
                            i2 = zzo(i6, bArr, i2, i3, zzejVar);
                        }
                        if (i2 > i3 || i6 != i5) {
                            throw new zzgc("Failed to parse the message.");
                        }
                        return i2;
                    }
                    return zzi(bArr, i2, zzejVar) + zzejVar.zza;
                }
                return i2 + 8;
            }
            return zzl(bArr, i2, zzejVar);
        }
        throw new zzgc("Protocol message contained an invalid tag (zero).");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zzp(byte[] bArr, int i) {
        return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48) | ((bArr[i + 7] & 255) << 56);
    }

    private static void zzq(int i) throws zzgc {
        if (i >= zzb) {
            throw new zzgc("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }
}
