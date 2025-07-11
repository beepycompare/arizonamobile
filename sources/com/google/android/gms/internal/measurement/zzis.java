package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzis extends zzme implements zznm {
    private static final zzis zzg;
    private int zzb;
    private int zzd;
    private int zze;
    private int zzf;

    static {
        zzis zzisVar = new zzis();
        zzg = zzisVar;
        zzme.zzcp(zzis.class, zzisVar);
    }

    private zzis() {
    }

    public static zzil zzb() {
        return (zzil) zzg.zzck();
    }

    public static zzis zzc() {
        return zzg;
    }

    public final zzin zza() {
        zzin zzb = zzin.zzb(this.zze);
        return zzb == null ? zzin.CLIENT_UPLOAD_ELIGIBILITY_UNKNOWN : zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zzin zzinVar) {
        this.zze = zzinVar.zza();
        this.zzb |= 2;
    }

    public final int zzf() {
        int zza = zzir.zza(this.zzd);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    public final int zzg() {
        int zza = zzip.zza(this.zzf);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzh(int i) {
        this.zzd = i - 1;
        this.zzb |= 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzi(int i) {
        this.zzf = i - 1;
        this.zzb |= 4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 == 2) {
                return zzcq(zzg, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003᠌\u0002", new Object[]{"zzb", "zzd", zziq.zza, "zze", zzim.zza, "zzf", zzio.zza});
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 == 5) {
                        return zzg;
                    }
                    throw null;
                }
                return new zzil(null);
            } else {
                return new zzis();
            }
        }
        return (byte) 1;
    }
}
