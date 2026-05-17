package com.google.android.gms.internal.play_billing;
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes4.dex */
public final class zziq extends zzfu implements zzhc {
    private static final zziq zzb;
    private int zzd = 0;
    private Object zze;

    static {
        zziq zziqVar = new zziq();
        zzb = zziqVar;
        zzfu.zzB(zziq.class, zziqVar);
    }

    private zziq() {
    }

    public static zzio zza() {
        return (zzio) zzb.zzp();
    }

    public static zziq zzc() {
        return zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zze(zziq zziqVar, String str) {
        str.getClass();
        zziqVar.zzd = 3;
        zziqVar.zze = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.play_billing.zzfu
    public final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 == 2) {
                return new zzhk(zzb, "\u0000\u0006\u0001\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001?\u0000\u00023\u0000\u0003Ȼ\u0000\u0004:\u0000\u0005<\u0000\u0006<\u0000", new Object[]{"zze", "zzd", zzhx.class, zzgo.class});
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 == 5) {
                        return zzb;
                    }
                    throw null;
                }
                return new zzio(null);
            } else {
                return new zziq();
            }
        }
        return (byte) 1;
    }
}
