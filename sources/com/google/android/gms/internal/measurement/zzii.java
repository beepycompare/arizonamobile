package com.google.android.gms.internal.measurement;

import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzii extends zzme implements zznm {
    private static final zzii zzg;
    private zzmm zzb = zzct();
    private zzmm zzd = zzct();
    private zzmn zze = zzcv();
    private zzmn zzf = zzcv();

    static {
        zzii zziiVar = new zzii();
        zzg = zziiVar;
        zzme.zzcp(zzii.class, zziiVar);
    }

    private zzii() {
    }

    public static zzih zzi() {
        return (zzih) zzg.zzck();
    }

    public static zzii zzj() {
        return zzg;
    }

    public final List zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zzb.size();
    }

    public final List zzc() {
        return this.zzd;
    }

    public final int zzd() {
        return this.zzd.size();
    }

    public final List zze() {
        return this.zze;
    }

    public final int zzf() {
        return this.zze.size();
    }

    public final List zzg() {
        return this.zzf;
    }

    public final int zzh() {
        return this.zzf.size();
    }

    public final /* synthetic */ void zzk(Iterable iterable) {
        zzmm zzmmVar = this.zzb;
        if (!zzmmVar.zza()) {
            this.zzb = zzme.zzcu(zzmmVar);
        }
        zzkr.zzce(iterable, this.zzb);
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 == 2) {
                return zzcq(zzg, "\u0004\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", new Object[]{"zzb", "zzd", "zze", zzhq.class, "zzf", zzik.class});
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 == 5) {
                        return zzg;
                    }
                    throw null;
                }
                return new zzih(null);
            } else {
                return new zzii();
            }
        }
        return (byte) 1;
    }

    public final /* synthetic */ void zzm() {
        this.zzb = zzct();
    }

    public final /* synthetic */ void zzn(Iterable iterable) {
        zzmm zzmmVar = this.zzd;
        if (!zzmmVar.zza()) {
            this.zzd = zzme.zzcu(zzmmVar);
        }
        zzkr.zzce(iterable, this.zzd);
    }

    public final /* synthetic */ void zzo() {
        this.zzd = zzct();
    }

    public final /* synthetic */ void zzp(Iterable iterable) {
        zzmn zzmnVar = this.zze;
        if (!zzmnVar.zza()) {
            this.zze = zzme.zzcw(zzmnVar);
        }
        zzkr.zzce(iterable, this.zze);
    }

    public final /* synthetic */ void zzq() {
        this.zze = zzcv();
    }

    public final /* synthetic */ void zzr(Iterable iterable) {
        zzmn zzmnVar = this.zzf;
        if (!zzmnVar.zza()) {
            this.zzf = zzme.zzcw(zzmnVar);
        }
        zzkr.zzce(iterable, this.zzf);
    }

    public final /* synthetic */ void zzs() {
        this.zzf = zzcv();
    }
}
