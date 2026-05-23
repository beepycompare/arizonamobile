package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzhl extends zzadu implements zzafd {
    private static final zzhl zzg;
    private static volatile zzafj zzh;
    private int zzb;
    private int zze;
    private int zzf;

    static {
        zzhl zzhlVar = new zzhl();
        zzg = zzhlVar;
        zzadu.zzcs(zzhl.class, zzhlVar);
    }

    private zzhl() {
    }

    public static zzhk zza() {
        return (zzhk) zzg.zzcn();
    }

    public final int zzc() {
        int zza = zzhj.zza(this.zze);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    public final int zzd() {
        int zza = zzhn.zza(this.zzf);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    public final /* synthetic */ void zze(int i) {
        this.zze = i - 1;
        this.zzb |= 1;
    }

    public final /* synthetic */ void zzf(int i) {
        this.zzf = i - 1;
        this.zzb |= 2;
    }

    @Override // com.google.android.gms.internal.measurement.zzadu
    public final Object zzg(int i, Object obj, Object obj2) {
        zzafj zzafjVar;
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 == 2) {
                return zzct(zzg, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zzb", "zze", zzhi.zza, "zzf", zzhm.zza});
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 != 5) {
                        if (i2 == 6) {
                            zzafj zzafjVar2 = zzh;
                            if (zzafjVar2 == null) {
                                synchronized (zzhl.class) {
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
                return new zzhk(null);
            } else {
                return new zzhl();
            }
        }
        return (byte) 1;
    }
}
