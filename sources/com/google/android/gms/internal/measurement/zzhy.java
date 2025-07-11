package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzhy extends zzme implements zznm {
    private static final zzhy zzg;
    private int zzb;
    private String zzd = "";
    private String zze = "";
    private zzhc zzf;

    static {
        zzhy zzhyVar = new zzhy();
        zzg = zzhyVar;
        zzme.zzcp(zzhy.class, zzhyVar);
    }

    private zzhy() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 == 2) {
                return zzcq(zzg, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဉ\u0002", new Object[]{"zzb", "zzd", "zze", "zzf"});
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 == 5) {
                        return zzg;
                    }
                    throw null;
                }
                return new zzhx(null);
            } else {
                return new zzhy();
            }
        }
        return (byte) 1;
    }
}
