package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzgq extends zzmd implements zzni {
    private static final zzgq zzb;
    private zzmj zzd = zzmd.zzcn();

    static {
        zzgq zzgqVar = new zzgq();
        zzb = zzgqVar;
        zzmd.zzct(zzgq.class, zzgqVar);
    }

    private zzgq() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzmd
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 == 2) {
                return zzcq(zzb, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"zzd"});
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 == 5) {
                        return zzb;
                    }
                    throw null;
                }
                return new zzgp(null);
            } else {
                return new zzgq();
            }
        }
        return (byte) 1;
    }
}
