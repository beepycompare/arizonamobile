package com.google.android.gms.internal.play_billing;
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes4.dex */
public final class zzji extends zzfu implements zzhc {
    private static final zzji zzb;

    static {
        zzji zzjiVar = new zzji();
        zzb = zzjiVar;
        zzfu.zzB(zzji.class, zzjiVar);
    }

    private zzji() {
    }

    public static zzji zzb() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfu
    protected final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 == 5) {
                            return zzb;
                        }
                        throw null;
                    }
                    return new zzjg(null);
                }
                return new zzji();
            }
            return zzy(zzb, "\u0004\u0000", null);
        }
        return (byte) 1;
    }
}
