package com.google.android.gms.internal.play_billing;
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes4.dex */
public final class zzkc extends zzfu implements zzhc {
    private static final zzkc zzb;
    private int zzd;
    private int zze;
    private String zzf = "";

    static {
        zzkc zzkcVar = new zzkc();
        zzb = zzkcVar;
        zzfu.zzB(zzkc.class, zzkcVar);
    }

    private zzkc() {
    }

    @Override // com.google.android.gms.internal.play_billing.zzfu
    public final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 == 2) {
                return zzy(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", zzkb.zza, "zzf"});
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 == 5) {
                        return zzb;
                    }
                    throw null;
                }
                return new zzka(null);
            } else {
                return new zzkc();
            }
        }
        return (byte) 1;
    }
}
