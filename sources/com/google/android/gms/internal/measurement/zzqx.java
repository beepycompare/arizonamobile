package com.google.android.gms.internal.measurement;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzqx extends zzadu implements zzafd {
    private static final zzqx zzh;
    private static volatile zzafj zzi;
    private int zzb;
    private Object zzf;
    private int zze = 0;
    private String zzg = "";

    static {
        zzqx zzqxVar = new zzqx();
        zzh = zzqxVar;
        zzadu.zzcs(zzqx.class, zzqxVar);
    }

    private zzqx() {
    }

    public static zzqw zzh() {
        return (zzqw) zzh.zzcn();
    }

    public final String zza() {
        return this.zzg;
    }

    public final long zzb() {
        if (this.zze == 2) {
            return ((Long) this.zzf).longValue();
        }
        return 0L;
    }

    public final boolean zzc() {
        if (this.zze == 3) {
            return ((Boolean) this.zzf).booleanValue();
        }
        return false;
    }

    public final double zzd() {
        return this.zze == 4 ? ((Double) this.zzf).doubleValue() : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    public final String zze() {
        return this.zze == 5 ? (String) this.zzf : "";
    }

    public final zzacr zzf() {
        return this.zze == 6 ? (zzacr) this.zzf : zzacr.zza;
    }

    public final /* synthetic */ void zzi(String str) {
        str.getClass();
        this.zzb |= 1;
        this.zzg = str;
    }

    public final /* synthetic */ void zzj(long j) {
        this.zze = 2;
        this.zzf = Long.valueOf(j);
    }

    public final /* synthetic */ void zzk(boolean z) {
        this.zze = 3;
        this.zzf = Boolean.valueOf(z);
    }

    public final /* synthetic */ void zzl(double d) {
        this.zze = 4;
        this.zzf = Double.valueOf(d);
    }

    public final /* synthetic */ void zzm(String str) {
        str.getClass();
        this.zze = 5;
        this.zzf = str;
    }

    public final /* synthetic */ void zzn(zzacr zzacrVar) {
        zzacrVar.getClass();
        this.zze = 6;
        this.zzf = zzacrVar;
    }

    public final int zzp() {
        int i = this.zze;
        if (i != 0) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            return i != 6 ? 0 : 5;
                        }
                        return 4;
                    }
                    return 3;
                }
                return 2;
            }
            return 1;
        }
        return 6;
    }

    @Override // com.google.android.gms.internal.measurement.zzadu
    public final Object zzg(int i, Object obj, Object obj2) {
        zzafj zzafjVar;
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 == 2) {
                return zzct(zzh, "\u0004\u0006\u0001\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဈ\u0000\u00025\u0000\u0003:\u0000\u00043\u0000\u0005;\u0000\u0006=\u0000", new Object[]{"zzf", "zze", "zzb", "zzg"});
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 != 5) {
                        if (i2 == 6) {
                            zzafj zzafjVar2 = zzi;
                            if (zzafjVar2 == null) {
                                synchronized (zzqx.class) {
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
                return new zzqw(null);
            } else {
                return new zzqx();
            }
        }
        return (byte) 1;
    }
}
