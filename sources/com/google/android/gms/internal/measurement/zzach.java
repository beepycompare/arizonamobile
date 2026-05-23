package com.google.android.gms.internal.measurement;

import com.google.common.base.Ascii;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzach {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzb = 100;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(byte[] bArr, int i, zzacg zzacgVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b >= 0) {
            zzacgVar.zza = b;
            return i2;
        }
        return zzb(b, bArr, i2, zzacgVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i, byte[] bArr, int i2, zzacg zzacgVar) {
        byte b = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & 127;
        if (b >= 0) {
            zzacgVar.zza = i4 | (b << 7);
            return i3;
        }
        int i5 = i4 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            zzacgVar.zza = i5 | (b2 << Ascii.SO);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzacgVar.zza = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzacgVar.zza = i9 | (b4 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzacgVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(byte[] bArr, int i, zzacg zzacgVar) {
        byte b;
        long j = bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            zzacgVar.zzb = j;
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
        zzacgVar.zzb = j2;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(byte[] bArr, int i) {
        int i2 = (bArr[i + 1] & 255) << 8;
        return ((bArr[i + 3] & 255) << 24) | i2 | (bArr[i] & 255) | ((bArr[i + 2] & 255) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zze(byte[] bArr, int i) {
        return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48) | ((bArr[i + 7] & 255) << 56);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(byte[] bArr, int i, zzacg zzacgVar) throws zzaeh {
        int zza2 = zza(bArr, i, zzacgVar);
        int i2 = zzacgVar.zza;
        if (i2 >= 0) {
            if (i2 == 0) {
                zzacgVar.zzc = "";
                return zza2;
            }
            zzacgVar.zzc = zzagl.zzd(bArr, zza2, i2);
            return zza2 + i2;
        }
        throw new zzaeh("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(byte[] bArr, int i, zzacg zzacgVar) throws zzaeh {
        int zza2 = zza(bArr, i, zzacgVar);
        int i2 = zzacgVar.zza;
        if (i2 < 0) {
            throw new zzaeh("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i2 <= bArr.length - zza2) {
            if (i2 == 0) {
                zzacgVar.zzc = zzacr.zza;
                return zza2;
            }
            zzacgVar.zzc = zzacr.zzj(bArr, zza2, i2);
            return zza2 + i2;
        }
        throw new zzaeh("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(zzafp zzafpVar, byte[] bArr, int i, int i2, zzacg zzacgVar) throws IOException {
        Object zza2 = zzafpVar.zza();
        int zzj = zzj(zza2, zzafpVar, bArr, i, i2, zzacgVar);
        zzafpVar.zzk(zza2);
        zzacgVar.zzc = zza2;
        return zzj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(zzafp zzafpVar, byte[] bArr, int i, int i2, int i3, zzacg zzacgVar) throws IOException {
        Object zza2 = zzafpVar.zza();
        int zzk = zzk(zza2, zzafpVar, bArr, i, i2, i3, zzacgVar);
        zzafpVar.zzk(zza2);
        zzacgVar.zzc = zza2;
        return zzk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(Object obj, zzafp zzafpVar, byte[] bArr, int i, int i2, zzacg zzacgVar) throws IOException {
        int i3 = i + 1;
        int i4 = bArr[i];
        if (i4 < 0) {
            i3 = zzb(i4, bArr, i3, zzacgVar);
            i4 = zzacgVar.zza;
        }
        int i5 = i3;
        if (i4 < 0 || i4 > i2 - i5) {
            throw new zzaeh("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i6 = zzacgVar.zze + 1;
        zzacgVar.zze = i6;
        zzq(i6);
        int i7 = i5 + i4;
        zzafpVar.zzj(obj, bArr, i5, i7, zzacgVar);
        zzacgVar.zze--;
        zzacgVar.zzc = obj;
        return i7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzk(Object obj, zzafp zzafpVar, byte[] bArr, int i, int i2, int i3, zzacg zzacgVar) throws IOException {
        int i4 = zzacgVar.zze + 1;
        zzacgVar.zze = i4;
        zzq(i4);
        int zzi = ((zzaff) zzafpVar).zzi(obj, bArr, i, i2, i3, zzacgVar);
        zzacgVar.zze--;
        zzacgVar.zzc = obj;
        return zzi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzl(int i, byte[] bArr, int i2, int i3, zzaef zzaefVar, zzacg zzacgVar) {
        zzadv zzadvVar = (zzadv) zzaefVar;
        int zza2 = zza(bArr, i2, zzacgVar);
        zzadvVar.zzh(zzacgVar.zza);
        while (zza2 < i3) {
            int zza3 = zza(bArr, zza2, zzacgVar);
            if (i != zzacgVar.zza) {
                break;
            }
            zza2 = zza(bArr, zza3, zzacgVar);
            zzadvVar.zzh(zzacgVar.zza);
        }
        return zza2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzm(byte[] bArr, int i, zzaef zzaefVar, zzacg zzacgVar) throws IOException {
        zzadv zzadvVar = (zzadv) zzaefVar;
        int zza2 = zza(bArr, i, zzacgVar);
        int i2 = zzacgVar.zza + zza2;
        while (zza2 < i2) {
            zza2 = zza(bArr, zza2, zzacgVar);
            zzadvVar.zzh(zzacgVar.zza);
        }
        if (zza2 == i2) {
            return zza2;
        }
        throw new zzaeh("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzn(zzafp zzafpVar, int i, byte[] bArr, int i2, int i3, zzaef zzaefVar, zzacg zzacgVar) throws IOException {
        int zzh = zzh(zzafpVar, bArr, i2, i3, zzacgVar);
        zzaefVar.add(zzacgVar.zzc);
        while (zzh < i3) {
            int zza2 = zza(bArr, zzh, zzacgVar);
            if (i != zzacgVar.zza) {
                break;
            }
            zzh = zzh(zzafpVar, bArr, zza2, i3, zzacgVar);
            zzaefVar.add(zzacgVar.zzc);
        }
        return zzh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzo(int i, byte[] bArr, int i2, int i3, zzaga zzagaVar, zzacg zzacgVar) throws zzaeh {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int zzc = zzc(bArr, i2, zzacgVar);
                zzagaVar.zzk(i, Long.valueOf(zzacgVar.zzb));
                return zzc;
            } else if (i4 == 1) {
                zzagaVar.zzk(i, Long.valueOf(zze(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int zza2 = zza(bArr, i2, zzacgVar);
                int i5 = zzacgVar.zza;
                if (i5 < 0) {
                    throw new zzaeh("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                }
                if (i5 <= bArr.length - zza2) {
                    if (i5 == 0) {
                        zzagaVar.zzk(i, zzacr.zza);
                    } else {
                        zzagaVar.zzk(i, zzacr.zzj(bArr, zza2, i5));
                    }
                    return zza2 + i5;
                }
                throw new zzaeh("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            } else if (i4 != 3) {
                if (i4 != 5) {
                    throw new zzaeh("Protocol message contained an invalid tag (zero).");
                }
                zzagaVar.zzk(i, Integer.valueOf(zzd(bArr, i2)));
                return i2 + 4;
            } else {
                int i6 = (i & (-8)) | 4;
                zzaga zzb2 = zzaga.zzb();
                int i7 = zzacgVar.zze + 1;
                zzacgVar.zze = i7;
                zzq(i7);
                int i8 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int zza3 = zza(bArr, i2, zzacgVar);
                    int i9 = zzacgVar.zza;
                    if (i9 == i6) {
                        i8 = i9;
                        i2 = zza3;
                        break;
                    }
                    i2 = zzo(i9, bArr, zza3, i3, zzb2, zzacgVar);
                    i8 = i9;
                }
                zzacgVar.zze--;
                if (i2 > i3 || i8 != i6) {
                    throw new zzaeh("Failed to parse the message.");
                }
                zzagaVar.zzk(i, zzb2);
                return i2;
            }
        }
        throw new zzaeh("Protocol message contained an invalid tag (zero).");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzp(int i, byte[] bArr, int i2, int i3, zzacg zzacgVar) throws zzaeh {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            if (i4 == 5) {
                                return i2 + 4;
                            }
                            throw new zzaeh("Protocol message contained an invalid tag (zero).");
                        }
                        int i5 = (i & (-8)) | 4;
                        int i6 = 0;
                        while (i2 < i3) {
                            i2 = zza(bArr, i2, zzacgVar);
                            i6 = zzacgVar.zza;
                            if (i6 == i5) {
                                break;
                            }
                            i2 = zzp(i6, bArr, i2, i3, zzacgVar);
                        }
                        if (i2 > i3 || i6 != i5) {
                            throw new zzaeh("Failed to parse the message.");
                        }
                        return i2;
                    }
                    return zza(bArr, i2, zzacgVar) + zzacgVar.zza;
                }
                return i2 + 8;
            }
            return zzc(bArr, i2, zzacgVar);
        }
        throw new zzaeh("Protocol message contained an invalid tag (zero).");
    }

    private static void zzq(int i) throws zzaeh {
        if (i >= zzb) {
            throw new zzaeh("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }
}
