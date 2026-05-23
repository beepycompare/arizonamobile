package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzis extends zzadu implements zzafd {
    private static final zzis zzh;
    private static volatile zzafj zzi;
    private int zzb;
    private int zze;
    private int zzf;
    private int zzg;

    static {
        zzis zzisVar = new zzis();
        zzh = zzisVar;
        zzadu.zzcs(zzis.class, zzisVar);
    }

    private zzis() {
    }

    public static zzil zzb() {
        return (zzil) zzh.zzcn();
    }

    public static zzis zzc() {
        return zzh;
    }

    public final zzin zza() {
        zzin zzb = zzin.zzb(this.zzf);
        return zzb == null ? zzin.CLIENT_UPLOAD_ELIGIBILITY_UNKNOWN : zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zzin zzinVar) {
        this.zzf = zzinVar.zza();
        this.zzb |= 2;
    }

    public final int zzf() {
        int zza = zzir.zza(this.zze);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    public final int zzh() {
        int zza = zzip.zza(this.zzg);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzi(int i) {
        this.zze = i - 1;
        this.zzb |= 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzj(int i) {
        this.zzg = i - 1;
        this.zzb |= 4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzadu
    public final Object zzg(int i, Object obj, Object obj2) {
        zzafj zzafjVar;
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 == 2) {
                return zzct(zzh, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003᠌\u0002", new Object[]{"zzb", "zze", zziq.zza, "zzf", zzim.zza, "zzg", zzio.zza});
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 != 5) {
                        if (i2 == 6) {
                            zzafj zzafjVar2 = zzi;
                            if (zzafjVar2 == null) {
                                synchronized (zzis.class) {
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
                return new zzil(null);
            } else {
                return new zzis();
            }
        }
        return (byte) 1;
    }
}
