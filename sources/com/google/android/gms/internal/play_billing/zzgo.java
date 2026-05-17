package com.google.android.gms.internal.play_billing;
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes4.dex */
public final class zzgo extends zzfu implements zzhc {
    private static final zzgo zzb;
    private zzfz zzd = zzhj.zze();

    static {
        zzgo zzgoVar = new zzgo();
        zzb = zzgoVar;
        zzfu.zzB(zzgo.class, zzgoVar);
    }

    private zzgo() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.play_billing.zzfu
    public final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 == 2) {
                return new zzhk(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zziq.class});
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 == 5) {
                        return zzb;
                    }
                    throw null;
                }
                return new zzgm(null);
            } else {
                return new zzgo();
            }
        }
        return (byte) 1;
    }
}
