package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzig extends zzme implements zznm {
    private static final zzig zzf;
    private int zzb;
    private int zzd = 1;
    private zzmn zze = zzcv();

    static {
        zzig zzigVar = new zzig();
        zzf = zzigVar;
        zzme.zzcp(zzig.class, zzigVar);
    }

    private zzig() {
    }

    public static zzie zza() {
        return (zzie) zzf.zzck();
    }

    public final /* synthetic */ void zzb(zzhu zzhuVar) {
        zzhuVar.getClass();
        zzmn zzmnVar = this.zze;
        if (!zzmnVar.zza()) {
            this.zze = zzme.zzcw(zzmnVar);
        }
        this.zze.add(zzhuVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 == 2) {
                return zzcq(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001᠌\u0000\u0002\u001b", new Object[]{"zzb", "zzd", zzif.zza, "zze", zzhu.class});
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 == 5) {
                        return zzf;
                    }
                    throw null;
                }
                return new zzie(null);
            } else {
                return new zzig();
            }
        }
        return (byte) 1;
    }
}
