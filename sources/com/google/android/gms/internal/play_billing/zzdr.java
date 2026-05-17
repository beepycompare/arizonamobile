package com.google.android.gms.internal.play_billing;
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes4.dex */
public final class zzdr extends zzfu implements zzhc {
    private static final zzdr zzb;
    private int zzd;
    private zzeb zze;
    private zzeb zzf;
    private int zzg;

    static {
        zzdr zzdrVar = new zzdr();
        zzb = zzdrVar;
        zzfu.zzB(zzdr.class, zzdrVar);
    }

    private zzdr() {
    }

    public static zzdq zza() {
        return (zzdq) zzb.zzp();
    }

    public static /* synthetic */ void zzc(zzdr zzdrVar, zzeb zzebVar) {
        zzebVar.getClass();
        zzdrVar.zze = zzebVar;
        zzdrVar.zzd |= 1;
    }

    public static /* synthetic */ void zze(zzdr zzdrVar, zzeb zzebVar) {
        zzebVar.getClass();
        zzdrVar.zzf = zzebVar;
        zzdrVar.zzd |= 2;
    }

    public static /* synthetic */ void zzf(zzdr zzdrVar, int i) {
        zzdrVar.zzg = i - 1;
        zzdrVar.zzd |= 4;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfu
    public final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 == 2) {
                return zzy(zzb, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003᠌\u0002", new Object[]{"zzd", "zze", "zzf", "zzg", zzee.zza()});
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 == 5) {
                        return zzb;
                    }
                    throw null;
                }
                return new zzdq(null);
            } else {
                return new zzdr();
            }
        }
        return (byte) 1;
    }
}
