package com.google.android.gms.internal.measurement;

import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzik extends zzadu implements zzafd {
    private static final zzik zzg;
    private static volatile zzafj zzh;
    private int zzb;
    private int zze;
    private zzaee zzf = zzcw();

    static {
        zzik zzikVar = new zzik();
        zzg = zzikVar;
        zzadu.zzcs(zzik.class, zzikVar);
    }

    private zzik() {
    }

    public static zzij zzf() {
        return (zzij) zzg.zzcn();
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

    public final long zze(int i) {
        return this.zzf.zzc(i);
    }

    public final /* synthetic */ void zzh(int i) {
        this.zzb |= 1;
        this.zze = i;
    }

    public final /* synthetic */ void zzi(Iterable iterable) {
        zzaee zzaeeVar = this.zzf;
        if (!zzaeeVar.zza()) {
            this.zzf = zzadu.zzcx(zzaeeVar);
        }
        zzacb.zzcg(iterable, this.zzf);
    }

    @Override // com.google.android.gms.internal.measurement.zzadu
    public final Object zzg(int i, Object obj, Object obj2) {
        zzafj zzafjVar;
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 == 2) {
                return zzct(zzg, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001င\u0000\u0002\u0014", new Object[]{"zzb", "zze", "zzf"});
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 != 5) {
                        if (i2 == 6) {
                            zzafj zzafjVar2 = zzh;
                            if (zzafjVar2 == null) {
                                synchronized (zzik.class) {
                                    zzafjVar = zzh;
                                    if (zzafjVar == null) {
                                        zzafjVar = new zzadq(zzg);
                                        zzh = zzafjVar;
                                    }
                                }
                                return zzafjVar;
                            }
                            return zzafjVar2;
                        }
                        throw null;
                    }
                    return zzg;
                }
                return new zzij(null);
            } else {
                return new zzik();
            }
        }
        return (byte) 1;
    }
}
