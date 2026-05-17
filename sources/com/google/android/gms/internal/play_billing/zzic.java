package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.util.Arrays;
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes4.dex */
public final class zzic {
    private static final zzic zza = new zzic(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzic() {
        this(0, new int[8], new Object[8], true);
    }

    private zzic(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzic zzc() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzic zze(zzic zzicVar, zzic zzicVar2) {
        int i = zzicVar.zzb + zzicVar2.zzb;
        int[] copyOf = Arrays.copyOf(zzicVar.zzc, i);
        System.arraycopy(zzicVar2.zzc, 0, copyOf, zzicVar.zzb, zzicVar2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzicVar.zzd, i);
        System.arraycopy(zzicVar2.zzd, 0, copyOf2, zzicVar.zzb, zzicVar2.zzb);
        return new zzic(i, copyOf, copyOf2, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzic zzf() {
        return new zzic(0, new int[8], new Object[8], true);
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
        if (obj != null && (obj instanceof zzic)) {
            zzic zzicVar = (zzic) obj;
            int i = this.zzb;
            if (i == zzicVar.zzb) {
                int[] iArr = this.zzc;
                int[] iArr2 = zzicVar.zzc;
                int i2 = 0;
                while (true) {
                    if (i2 >= i) {
                        Object[] objArr = this.zzd;
                        Object[] objArr2 = zzicVar.zzd;
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

    public final int zza() {
        int zzy;
        int zzz;
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
                        i = zzfc.zzy(i6 << 3) + 8;
                    } else if (i7 == 2) {
                        int zzy2 = zzfc.zzy(i6 << 3);
                        int zze = ((zzev) this.zzd[i4]).zze();
                        i = zzy2 + zzfc.zzy(zze) + zze;
                    } else if (i7 == 3) {
                        int zzy3 = zzfc.zzy(i6 << 3);
                        zzy = zzy3 + zzy3;
                        zzz = ((zzic) this.zzd[i4]).zza();
                    } else if (i7 == 5) {
                        ((Integer) this.zzd[i4]).intValue();
                        i = zzfc.zzy(i6 << 3) + 4;
                    } else {
                        throw new IllegalStateException(new zzgb("Protocol message tag had invalid wire type."));
                    }
                    i3 += i;
                } else {
                    int i8 = i6 << 3;
                    long longValue = ((Long) this.zzd[i4]).longValue();
                    zzy = zzfc.zzy(i8);
                    zzz = zzfc.zzz(longValue);
                }
                i = zzy + zzz;
                i3 += i;
            }
            this.zze = i3;
            return i3;
        }
        return i2;
    }

    public final int zzb() {
        int i = this.zze;
        if (i == -1) {
            int i2 = 0;
            for (int i3 = 0; i3 < this.zzb; i3++) {
                int zzy = zzfc.zzy(8);
                int zzy2 = zzfc.zzy(16) + zzfc.zzy(this.zzc[i3] >>> 3);
                int zzy3 = zzfc.zzy(24);
                int zze = ((zzev) this.zzd[i3]).zze();
                i2 += zzy + zzy + zzy2 + zzy3 + zzfc.zzy(zze) + zze;
            }
            this.zze = i2;
            return i2;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzic zzd(zzic zzicVar) {
        if (zzicVar.equals(zza)) {
            return this;
        }
        zzg();
        int i = this.zzb + zzicVar.zzb;
        zzm(i);
        System.arraycopy(zzicVar.zzc, 0, this.zzc, this.zzb, zzicVar.zzb);
        System.arraycopy(zzicVar.zzd, 0, this.zzd, this.zzb, zzicVar.zzb);
        this.zzb = i;
        return this;
    }

    final void zzg() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzh() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzi(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzhd.zzb(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzj(int i, Object obj) {
        zzg();
        zzm(this.zzb + 1);
        int[] iArr = this.zzc;
        int i2 = this.zzb;
        iArr[i2] = i;
        this.zzd[i2] = obj;
        this.zzb = i2 + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzk(zzit zzitVar) throws IOException {
        for (int i = 0; i < this.zzb; i++) {
            zzitVar.zzx(this.zzc[i] >>> 3, this.zzd[i]);
        }
    }

    public final void zzl(zzit zzitVar) throws IOException {
        if (this.zzb != 0) {
            for (int i = 0; i < this.zzb; i++) {
                int i2 = this.zzc[i];
                Object obj = this.zzd[i];
                int i3 = i2 & 7;
                int i4 = i2 >>> 3;
                if (i3 == 0) {
                    zzitVar.zzt(i4, ((Long) obj).longValue());
                } else if (i3 == 1) {
                    zzitVar.zzm(i4, ((Long) obj).longValue());
                } else if (i3 == 2) {
                    zzitVar.zzd(i4, (zzev) obj);
                } else if (i3 == 3) {
                    zzitVar.zzG(i4);
                    ((zzic) obj).zzl(zzitVar);
                    zzitVar.zzh(i4);
                } else if (i3 == 5) {
                    zzitVar.zzk(i4, ((Integer) obj).intValue());
                } else {
                    throw new RuntimeException(new zzgb("Protocol message tag had invalid wire type."));
                }
            }
        }
    }
}
