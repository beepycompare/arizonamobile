package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzhq extends zzadu implements zzafd {
    private static final zzhq zzg;
    private static volatile zzafj zzh;
    private int zzb;
    private int zze;
    private long zzf;

    static {
        zzhq zzhqVar = new zzhq();
        zzg = zzhqVar;
        zzadu.zzcs(zzhq.class, zzhqVar);
    }

    private zzhq() {
    }

    public static zzhp zze() {
        return (zzhp) zzg.zzcn();
    }

    public final boolean zza() {
        return (this.zzb & 1) != 0;
    }

    public final int zzb() {
        return this.zze;
    }

    public final boolean zzc() {
        return (this.zzb & 2) != 0;
    }

    public final long zzd() {
        return this.zzf;
    }

    public final /* synthetic */ void zzf(int i) {
        this.zzb |= 1;
        this.zze = i;
    }

    public final /* synthetic */ void zzh(long j) {
        this.zzb |= 2;
        this.zzf = j;
    }

    @Override // com.google.android.gms.internal.measurement.zzadu
    public final Object zzg(int i, Object obj, Object obj2) {
        zzafj zzafjVar;
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 == 2) {
                return zzct(zzg, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဂ\u0001", new Object[]{"zzb", "zze", "zzf"});
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 != 5) {
                        if (i2 == 6) {
                            zzafj zzafjVar2 = zzh;
                            if (zzafjVar2 == null) {
                                synchronized (zzhq.class) {
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
                return new zzhp(null);
            } else {
                return new zzhq();
            }
        }
        return (byte) 1;
    }
}
