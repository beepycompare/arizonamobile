package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Arrays;
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzoi {
    private static final zzoi zza = new zzoi(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzoi() {
        this(0, new int[8], new Object[8], true);
    }

    private zzoi(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzoi zza() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzoi zzb() {
        return new zzoi(0, new int[8], new Object[8], true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzoi zzc(zzoi zzoiVar, zzoi zzoiVar2) {
        int i = zzoiVar.zzb + zzoiVar2.zzb;
        int[] copyOf = Arrays.copyOf(zzoiVar.zzc, i);
        System.arraycopy(zzoiVar2.zzc, 0, copyOf, zzoiVar.zzb, zzoiVar2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzoiVar.zzd, i);
        System.arraycopy(zzoiVar2.zzd, 0, copyOf2, zzoiVar.zzb, zzoiVar2.zzb);
        return new zzoi(i, copyOf, copyOf2, true);
    }

    private final void zzm(int i) {
        int[] iArr = this.zzc;
        if (i > iArr.length) {
            int i2 = this.zzb;
            int i3 = i2 + (i2 / 2);
            if (i3 >= i) {
                i = i3;
            }
            if (i < 8) {
                i = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i);
            this.zzd = Arrays.copyOf(this.zzd, i);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof zzoi)) {
            zzoi zzoiVar = (zzoi) obj;
            int i = this.zzb;
            if (i == zzoiVar.zzb) {
                int[] iArr = this.zzc;
                int[] iArr2 = zzoiVar.zzc;
                int i2 = 0;
                while (true) {
                    if (i2 >= i) {
                        Object[] objArr = this.zzd;
                        Object[] objArr2 = zzoiVar.zzd;
                        int i3 = this.zzb;
                        for (int i4 = 0; i4 < i3; i4++) {
                            if (objArr[i4].equals(objArr2[i4])) {
                            }
                        }
                        return true;
                    } else if (iArr[i2] != iArr2[i2]) {
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        int i2 = i + 527;
        int[] iArr = this.zzc;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = ((i2 * 31) + i4) * 31;
        Object[] objArr = this.zzd;
        int i7 = this.zzb;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    public final void zzd() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    final void zze() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzf(zzou zzouVar) throws IOException {
        for (int i = 0; i < this.zzb; i++) {
            zzouVar.zzv(this.zzc[i] >>> 3, this.zzd[i]);
        }
    }

    public final void zzg(zzou zzouVar) throws IOException {
        if (this.zzb != 0) {
            for (int i = 0; i < this.zzb; i++) {
                int i2 = this.zzc[i];
                Object obj = this.zzd[i];
                int i3 = i2 & 7;
                int i4 = i2 >>> 3;
                if (i3 == 0) {
                    zzouVar.zzc(i4, ((Long) obj).longValue());
                } else if (i3 == 1) {
                    zzouVar.zzj(i4, ((Long) obj).longValue());
                } else if (i3 == 2) {
                    zzouVar.zzn(i4, (zzlg) obj);
                } else if (i3 == 3) {
                    zzouVar.zzt(i4);
                    ((zzoi) obj).zzg(zzouVar);
                    zzouVar.zzu(i4);
                } else if (i3 == 5) {
                    zzouVar.zzk(i4, ((Integer) obj).intValue());
                } else {
                    throw new RuntimeException(new zzmp("Protocol message tag had invalid wire type."));
                }
            }
        }
    }

    public final int zzh() {
        int i = this.zze;
        if (i == -1) {
            int i2 = 0;
            for (int i3 = 0; i3 < this.zzb; i3++) {
                int zzz = zzll.zzz(8);
                int zzz2 = zzll.zzz(16) + zzll.zzz(this.zzc[i3] >>> 3);
                int zzz3 = zzll.zzz(24);
                int zzc = ((zzlg) this.zzd[i3]).zzc();
                i2 += zzz + zzz + zzz2 + zzz3 + zzll.zzz(zzc) + zzc;
            }
            this.zze = i2;
            return i2;
        }
        return i;
    }

    public final int zzi() {
        int zzz;
        int zzA;
        int i;
        int i2 = this.zze;
        if (i2 == -1) {
            int i3 = 0;
            for (int i4 = 0; i4 < this.zzb; i4++) {
                int i5 = this.zzc[i4];
                int i6 = i5 >>> 3;
                int i7 = i5 & 7;
                if (i7 != 0) {
                    if (i7 == 1) {
                        ((Long) this.zzd[i4]).longValue();
                        i = zzll.zzz(i6 << 3) + 8;
                    } else if (i7 == 2) {
                        int zzz2 = zzll.zzz(i6 << 3);
                        int zzc = ((zzlg) this.zzd[i4]).zzc();
                        i = zzz2 + zzll.zzz(zzc) + zzc;
                    } else if (i7 == 3) {
                        int zzz3 = zzll.zzz(i6 << 3);
                        zzz = zzz3 + zzz3;
                        zzA = ((zzoi) this.zzd[i4]).zzi();
                    } else if (i7 == 5) {
                        ((Integer) this.zzd[i4]).intValue();
                        i = zzll.zzz(i6 << 3) + 4;
                    } else {
                        throw new IllegalStateException(new zzmp("Protocol message tag had invalid wire type."));
                    }
                    i3 += i;
                } else {
                    int i8 = i6 << 3;
                    long longValue = ((Long) this.zzd[i4]).longValue();
                    zzz = zzll.zzz(i8);
                    zzA = zzll.zzA(longValue);
                }
                i = zzz + zzA;
                i3 += i;
            }
            this.zze = i3;
            return i3;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzj(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zznn.zzb(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzk(int i, Object obj) {
        zze();
        zzm(this.zzb + 1);
        int[] iArr = this.zzc;
        int i2 = this.zzb;
        iArr[i2] = i;
        this.zzd[i2] = obj;
        this.zzb = i2 + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzoi zzl(zzoi zzoiVar) {
        if (zzoiVar.equals(zza)) {
            return this;
        }
        zze();
        int i = this.zzb + zzoiVar.zzb;
        zzm(i);
        System.arraycopy(zzoiVar.zzc, 0, this.zzc, this.zzb, zzoiVar.zzb);
        System.arraycopy(zzoiVar.zzd, 0, this.zzd, this.zzb, zzoiVar.zzb);
        this.zzb = i;
        return this;
    }
}
