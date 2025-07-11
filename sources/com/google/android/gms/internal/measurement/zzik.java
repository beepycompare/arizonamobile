package com.google.android.gms.internal.measurement;

import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzik extends zzme implements zznm {
    private static final zzik zzf;
    private int zzb;
    private int zzd;
    private zzmm zze = zzct();

    static {
        zzik zzikVar = new zzik();
        zzf = zzikVar;
        zzme.zzcp(zzik.class, zzikVar);
    }

    private zzik() {
    }

    public static zzij zzf() {
        return (zzij) zzf.zzck();
    }

    public final boolean zza() {
        return (this.zzb & 1) != 0;
    }

    public final int zzb() {
        return this.zzd;
    }

    public final List zzc() {
        return this.zze;
    }

    public final int zzd() {
        return this.zze.size();
    }

    public final long zze(int i) {
        return this.zze.zzc(i);
    }

    public final /* synthetic */ void zzg(int i) {
        this.zzb |= 1;
        this.zzd = i;
    }

    public final /* synthetic */ void zzh(Iterable iterable) {
        zzmm zzmmVar = this.zze;
        if (!zzmmVar.zza()) {
            this.zze = zzme.zzcu(zzmmVar);
        }
        zzkr.zzce(iterable, this.zze);
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 == 2) {
                return zzcq(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001င\u0000\u0002\u0014", new Object[]{"zzb", "zzd", "zze"});
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 == 5) {
                        return zzf;
                    }
                    throw null;
                }
                return new zzij(null);
            } else {
                return new zzik();
            }
        }
        return (byte) 1;
    }
}
