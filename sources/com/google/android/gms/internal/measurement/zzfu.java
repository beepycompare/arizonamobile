package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzfu extends zzadu implements zzafd {
    private static final zzfu zzh;
    private static volatile zzafj zzi;
    private int zzb;
    private int zze;
    private int zzf;
    private int zzg;

    static {
        zzfu zzfuVar = new zzfu();
        zzh = zzfuVar;
        zzadu.zzcs(zzfu.class, zzfuVar);
    }

    private zzfu() {
    }

    public final int zzb() {
        int zza = zzga.zza(this.zze);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    public final int zzc() {
        int zza = zzfy.zza(this.zzf);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    public final int zzd() {
        int zza = zzge.zza(this.zzg);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzadu
    public final Object zzg(int i, Object obj, Object obj2) {
        zzafj zzafjVar;
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 == 2) {
                return zzct(zzh, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003᠌\u0002", new Object[]{"zzb", "zze", zzfz.zza, "zzf", zzfx.zza, "zzg", zzgd.zza});
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 != 5) {
                        if (i2 == 6) {
                            zzafj zzafjVar2 = zzi;
                            if (zzafjVar2 == null) {
                                synchronized (zzfu.class) {
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
                return new zzft(null);
            } else {
                return new zzfu();
            }
        }
        return (byte) 1;
    }
}
