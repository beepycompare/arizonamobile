package com.google.android.gms.internal.measurement;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzmi extends zzadu implements zzafd {
    private static final zzmi zzh;
    private static volatile zzafj zzi;
    private int zzb;
    private Object zzf;
    private int zze = 0;
    private String zzg = "";

    static {
        zzmi zzmiVar = new zzmi();
        zzh = zzmiVar;
        zzadu.zzcs(zzmi.class, zzmiVar);
    }

    private zzmi() {
    }

    public static zzmh zzh() {
        return (zzmh) zzh.zzcn();
    }

    public static zzmi zzi() {
        return zzh;
    }

    public final String zza() {
        return this.zzg;
    }

    public final long zzb() {
        if (this.zze == 1) {
            return ((Long) this.zzf).longValue();
        }
        return 0L;
    }

    public final boolean zzc() {
        if (this.zze == 2) {
            return ((Boolean) this.zzf).booleanValue();
        }
        return false;
    }

    public final double zzd() {
        return this.zze == 3 ? ((Double) this.zzf).doubleValue() : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    public final String zze() {
        return this.zze == 4 ? (String) this.zzf : "";
    }

    public final zzacr zzf() {
        return this.zze == 5 ? (zzacr) this.zzf : zzacr.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzj(String str) {
        str.getClass();
        this.zzb |= 1;
        this.zzg = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzk(long j) {
        this.zze = 1;
        this.zzf = Long.valueOf(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzl(boolean z) {
        this.zze = 2;
        this.zzf = Boolean.valueOf(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzm(double d) {
        this.zze = 3;
        this.zzf = Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzn(String str) {
        str.getClass();
        this.zze = 4;
        this.zzf = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(zzacr zzacrVar) {
        zzacrVar.getClass();
        this.zze = 5;
        this.zzf = zzacrVar;
    }

    public final int zzq() {
        int i = this.zze;
        if (i != 0) {
            int i2 = 1;
            if (i != 1) {
                i2 = 2;
                if (i != 2) {
                    i2 = 3;
                    if (i != 3) {
                        i2 = 4;
                        if (i != 4) {
                            i2 = 5;
                            if (i != 5) {
                                return 0;
                            }
                        }
                    }
                }
            }
            return i2;
        }
        return 6;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzadu
    public final Object zzg(int i, Object obj, Object obj2) {
        zzafj zzafjVar;
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 == 2) {
                return zzct(zzh, "\u0004\u0006\u0001\u0001\u0001\n\u0006\u0000\u0000\u0000\u00018\u0000\u0002:\u0000\u00033\u0000\u0004;\u0000\u0005=\u0000\nဈ\u0000", new Object[]{"zzf", "zze", "zzb", "zzg"});
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 != 5) {
                        if (i2 == 6) {
                            zzafj zzafjVar2 = zzi;
                            if (zzafjVar2 == null) {
                                synchronized (zzmi.class) {
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
                return new zzmh(null);
            } else {
                return new zzmi();
            }
        }
        return (byte) 1;
    }
}
