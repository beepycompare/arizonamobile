package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzgn extends zzme implements zznm {
    private static final zzgn zzd;
    private zzmn zzb = zzme.zzcv();

    static {
        zzgn zzgnVar = new zzgn();
        zzd = zzgnVar;
        zzme.zzcp(zzgn.class, zzgnVar);
    }

    private zzgn() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 == 2) {
                return zzcq(zzd, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"zzb"});
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 == 5) {
                        return zzd;
                    }
                    throw null;
                }
                return new zzgm(null);
            } else {
                return new zzgn();
            }
        }
        return (byte) 1;
    }
}
