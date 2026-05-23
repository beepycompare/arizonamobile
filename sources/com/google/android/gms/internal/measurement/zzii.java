package com.google.android.gms.internal.measurement;

import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzii extends zzadu implements zzafd {
    private static final zzii zzh;
    private static volatile zzafj zzi;
    private zzaee zzb = zzcw();
    private zzaee zze = zzcw();
    private zzaef zzf = zzcy();
    private zzaef zzg = zzcy();

    static {
        zzii zziiVar = new zzii();
        zzh = zziiVar;
        zzadu.zzcs(zzii.class, zziiVar);
    }

    private zzii() {
    }

    public static zzih zzj() {
        return (zzih) zzh.zzcn();
    }

    public static zzii zzk() {
        return zzh;
    }

    public final List zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zzb.size();
    }

    public final List zzc() {
        return this.zze;
    }

    public final int zzd() {
        return this.zze.size();
    }

    public final List zze() {
        return this.zzf;
    }

    public final int zzf() {
        return this.zzf.size();
    }

    public final List zzh() {
        return this.zzg;
    }

    public final int zzi() {
        return this.zzg.size();
    }

    public final /* synthetic */ void zzl(Iterable iterable) {
        zzaee zzaeeVar = this.zzb;
        if (!zzaeeVar.zza()) {
            this.zzb = zzadu.zzcx(zzaeeVar);
        }
        zzacb.zzcg(iterable, this.zzb);
    }

    public final /* synthetic */ void zzm() {
        this.zzb = zzcw();
    }

    public final /* synthetic */ void zzn(Iterable iterable) {
        zzaee zzaeeVar = this.zze;
        if (!zzaeeVar.zza()) {
            this.zze = zzadu.zzcx(zzaeeVar);
        }
        zzacb.zzcg(iterable, this.zze);
    }

    public final /* synthetic */ void zzo() {
        this.zze = zzcw();
    }

    public final /* synthetic */ void zzp(Iterable iterable) {
        zzaef zzaefVar = this.zzf;
        if (!zzaefVar.zza()) {
            this.zzf = zzadu.zzcz(zzaefVar);
        }
        zzacb.zzcg(iterable, this.zzf);
    }

    public final /* synthetic */ void zzq() {
        this.zzf = zzcy();
    }

    public final /* synthetic */ void zzr(Iterable iterable) {
        zzaef zzaefVar = this.zzg;
        if (!zzaefVar.zza()) {
            this.zzg = zzadu.zzcz(zzaefVar);
        }
        zzacb.zzcg(iterable, this.zzg);
    }

    public final /* synthetic */ void zzs() {
        this.zzg = zzcy();
    }

    @Override // com.google.android.gms.internal.measurement.zzadu
    public final Object zzg(int i, Object obj, Object obj2) {
        zzafj zzafjVar;
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 == 2) {
                return zzct(zzh, "\u0004\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", new Object[]{"zzb", "zze", "zzf", zzhq.class, "zzg", zzik.class});
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 != 5) {
                        if (i2 == 6) {
                            zzafj zzafjVar2 = zzi;
                            if (zzafjVar2 == null) {
                                synchronized (zzii.class) {
                                    zzafjVar = zzi;
                                    if (zzafjVar == null) {
                                        zzafjVar = new zzadq(zzh);
                                        zzi = zzafjVar;
                                    }
                                }
                                return zzafjVar;
                            }
                            return zzafjVar2;
                        }
                        throw null;
                    }
                    return zzh;
                }
                return new zzih(null);
            } else {
                return new zzii();
            }
        }
        return (byte) 1;
    }
}
