package com.google.android.gms.internal.play_billing;

import java.util.Map;
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes4.dex */
public final class zzhx extends zzfu implements zzhc {
    private static final zzhx zzb;
    private zzgv zzd = zzgv.zza();

    static {
        zzhx zzhxVar = new zzhx();
        zzb = zzhxVar;
        zzfu.zzB(zzhx.class, zzhxVar);
    }

    private zzhx() {
    }

    public static zzhu zza() {
        return (zzhu) zzb.zzp();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Map zzc(zzhx zzhxVar) {
        if (!zzhxVar.zzd.zze()) {
            zzhxVar.zzd = zzhxVar.zzd.zzb();
        }
        return zzhxVar.zzd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.play_billing.zzfu
    public final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 == 2) {
                return new zzhk(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"zzd", zzhv.zza});
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 == 5) {
                        return zzb;
                    }
                    throw null;
                }
                return new zzhu(null);
            } else {
                return new zzhx();
            }
        }
        return (byte) 1;
    }
}
