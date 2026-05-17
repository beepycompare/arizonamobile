package com.google.android.gms.internal.play_billing;
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes4.dex */
public final class zzdt extends zzfu implements zzhc {
    private static final zzdt zzb;
    private zzfz zzd = zzv();

    static {
        zzdt zzdtVar = new zzdt();
        zzb = zzdtVar;
        zzfu.zzB(zzdt.class, zzdtVar);
    }

    private zzdt() {
    }

    public static zzds zza() {
        return (zzds) zzb.zzp();
    }

    public static /* synthetic */ void zzc(zzdt zzdtVar, Iterable iterable) {
        zzfz zzfzVar = zzdtVar.zzd;
        if (!zzfzVar.zzc()) {
            int size = zzfzVar.size();
            zzdtVar.zzd = zzfzVar.zzd(size + size);
        }
        zzeg.zzk(iterable, zzdtVar.zzd);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfu
    public final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 == 2) {
                return zzy(zzb, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzdr.class});
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 == 5) {
                        return zzb;
                    }
                    throw null;
                }
                return new zzds(null);
            } else {
                return new zzdt();
            }
        }
        return (byte) 1;
    }
}
