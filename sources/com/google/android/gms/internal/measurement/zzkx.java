package com.google.android.gms.internal.measurement;

import com.google.common.base.Ascii;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@23.0.0 */
/* loaded from: classes4.dex */
public final class zzkx {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzb = 100;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(byte[] bArr, int i, zzkw zzkwVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b >= 0) {
            zzkwVar.zza = b;
            return i2;
        }
        return zzb(b, bArr, i2, zzkwVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i, byte[] bArr, int i2, zzkw zzkwVar) {
        byte b = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & 127;
        if (b >= 0) {
            zzkwVar.zza = i4 | (b << 7);
            return i3;
        }
        int i5 = i4 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            zzkwVar.zza = i5 | (b2 << Ascii.SO);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzkwVar.zza = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzkwVar.zza = i9 | (b4 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzkwVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(byte[] bArr, int i, zzkw zzkwVar) {
        byte b;
        long j = bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            zzkwVar.zzb = j;
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
        zzkwVar.zzb = j2;
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
    public static int zzf(byte[] bArr, int i, zzkw zzkwVar) throws zzmr {
        int i2;
        int zza2 = zza(bArr, i, zzkwVar);
        int i3 = zzkwVar.zza;
        if (i3 >= 0) {
            if (i3 == 0) {
                zzkwVar.zzc = "";
                return zza2;
            }
            int i4 = zzos.zza;
            int length = bArr.length;
            if ((((length - zza2) - i3) | zza2 | i3) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(zza2), Integer.valueOf(i3)));
            }
            int i5 = zza2 + i3;
            char[] cArr = new char[i3];
            int i6 = 0;
            while (zza2 < i5) {
                byte b = bArr[zza2];
                if (!zzoq.zza(b)) {
                    break;
                }
                zza2++;
                cArr[i6] = (char) b;
                i6++;
            }
            int i7 = i6;
            while (zza2 < i5) {
                int i8 = zza2 + 1;
                byte b2 = bArr[zza2];
                if (zzoq.zza(b2)) {
                    cArr[i7] = (char) b2;
                    i7++;
                    zza2 = i8;
                    while (zza2 < i5) {
                        byte b3 = bArr[zza2];
                        if (zzoq.zza(b3)) {
                            zza2++;
                            cArr[i7] = (char) b3;
                            i7++;
                        }
                    }
                } else {
                    if (b2 < -32) {
                        if (i8 < i5) {
                            i2 = i7 + 1;
                            zza2 += 2;
                            zzoq.zzb(b2, bArr[i8], cArr, i7);
                        } else {
                            throw new zzmr("Protocol message had invalid UTF-8.");
                        }
                    } else if (b2 < -16) {
                        if (i8 < i5 - 1) {
                            i2 = i7 + 1;
                            int i9 = zza2 + 2;
                            zza2 += 3;
                            zzoq.zzc(b2, bArr[i8], bArr[i9], cArr, i7);
                        } else {
                            throw new zzmr("Protocol message had invalid UTF-8.");
                        }
                    } else if (i8 < i5 - 2) {
                        int i10 = zza2 + 3;
                        zza2 += 4;
                        zzoq.zzd(b2, bArr[i8], bArr[zza2 + 2], bArr[i10], cArr, i7);
                        i7 += 2;
                    } else {
                        throw new zzmr("Protocol message had invalid UTF-8.");
                    }
                    i7 = i2;
                }
            }
            zzkwVar.zzc = new String(cArr, 0, i7);
            return i5;
        }
        throw new zzmr("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(byte[] bArr, int i, zzkw zzkwVar) throws zzmr {
        int zza2 = zza(bArr, i, zzkwVar);
        int i2 = zzkwVar.zza;
        if (i2 < 0) {
            throw new zzmr("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i2 <= bArr.length - zza2) {
            if (i2 == 0) {
                zzkwVar.zzc = zzlh.zzb;
                return zza2;
            }
            zzkwVar.zzc = zzlh.zzh(bArr, zza2, i2);
            return zza2 + i2;
        }
        throw new zzmr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(zznx zznxVar, byte[] bArr, int i, int i2, zzkw zzkwVar) throws IOException {
        Object zza2 = zznxVar.zza();
        int zzj = zzj(zza2, zznxVar, bArr, i, i2, zzkwVar);
        zznxVar.zzj(zza2);
        zzkwVar.zzc = zza2;
        return zzj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(zznx zznxVar, byte[] bArr, int i, int i2, int i3, zzkw zzkwVar) throws IOException {
        Object zza2 = zznxVar.zza();
        int zzk = zzk(zza2, zznxVar, bArr, i, i2, i3, zzkwVar);
        zznxVar.zzj(zza2);
        zzkwVar.zzc = zza2;
        return zzk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(Object obj, zznx zznxVar, byte[] bArr, int i, int i2, zzkw zzkwVar) throws IOException {
        int i3 = i + 1;
        int i4 = bArr[i];
        if (i4 < 0) {
            i3 = zzb(i4, bArr, i3, zzkwVar);
            i4 = zzkwVar.zza;
        }
        int i5 = i3;
        if (i4 < 0 || i4 > i2 - i5) {
            throw new zzmr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i6 = zzkwVar.zze + 1;
        zzkwVar.zze = i6;
        zzq(i6);
        int i7 = i5 + i4;
        zznxVar.zzi(obj, bArr, i5, i7, zzkwVar);
        zzkwVar.zze--;
        zzkwVar.zzc = obj;
        return i7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzk(Object obj, zznx zznxVar, byte[] bArr, int i, int i2, int i3, zzkw zzkwVar) throws IOException {
        int i4 = zzkwVar.zze + 1;
        zzkwVar.zze = i4;
        zzq(i4);
        int zzh = ((zznp) zznxVar).zzh(obj, bArr, i, i2, i3, zzkwVar);
        zzkwVar.zze--;
        zzkwVar.zzc = obj;
        return zzh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzl(int i, byte[] bArr, int i2, int i3, zzmo zzmoVar, zzkw zzkwVar) {
        zzmg zzmgVar = (zzmg) zzmoVar;
        int zza2 = zza(bArr, i2, zzkwVar);
        zzmgVar.zzh(zzkwVar.zza);
        while (zza2 < i3) {
            int zza3 = zza(bArr, zza2, zzkwVar);
            if (i != zzkwVar.zza) {
                break;
            }
            zza2 = zza(bArr, zza3, zzkwVar);
            zzmgVar.zzh(zzkwVar.zza);
        }
        return zza2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzm(byte[] bArr, int i, zzmo zzmoVar, zzkw zzkwVar) throws IOException {
        zzmg zzmgVar = (zzmg) zzmoVar;
        int zza2 = zza(bArr, i, zzkwVar);
        int i2 = zzkwVar.zza + zza2;
        while (zza2 < i2) {
            zza2 = zza(bArr, zza2, zzkwVar);
            zzmgVar.zzh(zzkwVar.zza);
        }
        if (zza2 == i2) {
            return zza2;
        }
        throw new zzmr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzn(zznx zznxVar, int i, byte[] bArr, int i2, int i3, zzmo zzmoVar, zzkw zzkwVar) throws IOException {
        int zzh = zzh(zznxVar, bArr, i2, i3, zzkwVar);
        zzmoVar.add(zzkwVar.zzc);
        while (zzh < i3) {
            int zza2 = zza(bArr, zzh, zzkwVar);
            if (i != zzkwVar.zza) {
                break;
            }
            zzh = zzh(zznxVar, bArr, zza2, i3, zzkwVar);
            zzmoVar.add(zzkwVar.zzc);
        }
        return zzh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzo(int i, byte[] bArr, int i2, int i3, zzoj zzojVar, zzkw zzkwVar) throws zzmr {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int zzc = zzc(bArr, i2, zzkwVar);
                zzojVar.zzk(i, Long.valueOf(zzkwVar.zzb));
                return zzc;
            } else if (i4 == 1) {
                zzojVar.zzk(i, Long.valueOf(zze(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int zza2 = zza(bArr, i2, zzkwVar);
                int i5 = zzkwVar.zza;
                if (i5 < 0) {
                    throw new zzmr("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                }
                if (i5 <= bArr.length - zza2) {
                    if (i5 == 0) {
                        zzojVar.zzk(i, zzlh.zzb);
                    } else {
                        zzojVar.zzk(i, zzlh.zzh(bArr, zza2, i5));
                    }
                    return zza2 + i5;
                }
                throw new zzmr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            } else if (i4 != 3) {
                if (i4 != 5) {
                    throw new zzmr("Protocol message contained an invalid tag (zero).");
                }
                zzojVar.zzk(i, Integer.valueOf(zzd(bArr, i2)));
                return i2 + 4;
            } else {
                int i6 = (i & (-8)) | 4;
                zzoj zzb2 = zzoj.zzb();
                int i7 = zzkwVar.zze + 1;
                zzkwVar.zze = i7;
                zzq(i7);
                int i8 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int zza3 = zza(bArr, i2, zzkwVar);
                    int i9 = zzkwVar.zza;
                    if (i9 == i6) {
                        i8 = i9;
                        i2 = zza3;
                        break;
                    }
                    i2 = zzo(i9, bArr, zza3, i3, zzb2, zzkwVar);
                    i8 = i9;
                }
                zzkwVar.zze--;
                if (i2 > i3 || i8 != i6) {
                    throw new zzmr("Failed to parse the message.");
                }
                zzojVar.zzk(i, zzb2);
                return i2;
            }
        }
        throw new zzmr("Protocol message contained an invalid tag (zero).");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzp(int i, byte[] bArr, int i2, int i3, zzkw zzkwVar) throws zzmr {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            if (i4 == 5) {
                                return i2 + 4;
                            }
                            throw new zzmr("Protocol message contained an invalid tag (zero).");
                        }
                        int i5 = (i & (-8)) | 4;
                        int i6 = 0;
                        while (i2 < i3) {
                            i2 = zza(bArr, i2, zzkwVar);
                            i6 = zzkwVar.zza;
                            if (i6 == i5) {
                                break;
                            }
                            i2 = zzp(i6, bArr, i2, i3, zzkwVar);
                        }
                        if (i2 > i3 || i6 != i5) {
                            throw new zzmr("Failed to parse the message.");
                        }
                        return i2;
                    }
                    return zza(bArr, i2, zzkwVar) + zzkwVar.zza;
                }
                return i2 + 8;
            }
            return zzc(bArr, i2, zzkwVar);
        }
        throw new zzmr("Protocol message contained an invalid tag (zero).");
    }

    private static void zzq(int i) throws zzmr {
        if (i >= zzb) {
            throw new zzmr("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }
}
