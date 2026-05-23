package com.google.android.gms.internal.measurement;

import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzfd extends zzadu implements zzafd {
    private static final zzfd zzj;
    private static volatile zzafj zzk;
    private int zzb;
    private int zze;
    private zzaef zzf = zzcy();
    private zzaef zzg = zzcy();
    private boolean zzh;
    private boolean zzi;

    static {
        zzfd zzfdVar = new zzfd();
        zzj = zzfdVar;
        zzadu.zzcs(zzfd.class, zzfdVar);
    }

    private zzfd() {
    }

    public final boolean zza() {
        return (this.zzb & 1) != 0;
    }

    public final int zzb() {
        return this.zze;
    }

    public final List zzc() {
        return this.zzf;
    }

    public final int zzd() {
        return this.zzf.size();
    }

    public final zzfn zze(int i) {
        return (zzfn) this.zzf.get(i);
    }

    public final List zzf() {
        return this.zzg;
    }

    public final int zzh() {
        return this.zzg.size();
    }

    public final zzff zzi(int i) {
        return (zzff) this.zzg.get(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzj(int i, zzfn zzfnVar) {
        zzfnVar.getClass();
        zzaef zzaefVar = this.zzf;
        if (!zzaefVar.zza()) {
            this.zzf = zzadu.zzcz(zzaefVar);
        }
        this.zzf.set(i, zzfnVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzk(int i, zzff zzffVar) {
        zzffVar.getClass();
        zzaef zzaefVar = this.zzg;
        if (!zzaefVar.zza()) {
            this.zzg = zzadu.zzcz(zzaefVar);
        }
        this.zzg.set(i, zzffVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzadu
    public final Object zzg(int i, Object obj, Object obj2) {
        zzafj zzafjVar;
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 == 2) {
                return zzct(zzj, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဇ\u0001\u0005ဇ\u0002", new Object[]{"zzb", "zze", "zzf", zzfn.class, "zzg", zzff.class, "zzh", "zzi"});
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 != 5) {
                        if (i2 == 6) {
                            zzafj zzafjVar2 = zzk;
                            if (zzafjVar2 == null) {
                                synchronized (zzfd.class) {
                                    zzafjVar = zzk;
                                    if (zzafjVar == null) {
                                        zzafjVar = new zzadq(zzj);
                                        zzk = zzafjVar;
                                    }
                                }
                                return zzafjVar;
                            }
                            return zzafjVar2;
                        }
                        throw null;
                    }
                    return zzj;
                }
                return new zzfc(null);
            } else {
                return new zzfd();
            }
        }
        return (byte) 1;
    }
}
