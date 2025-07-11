package com.google.android.gms.internal.measurement;

import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzho extends zzme implements zznm {
    private static final zzho zzd;
    private zzmn zzb = zzcv();

    static {
        zzho zzhoVar = new zzho();
        zzd = zzhoVar;
        zzme.zzcp(zzho.class, zzhoVar);
    }

    private zzho() {
    }

    public static zzhh zzb() {
        return (zzhh) zzd.zzck();
    }

    public static zzho zzc() {
        return zzd;
    }

    public final List zza() {
        return this.zzb;
    }

    public final /* synthetic */ void zzd(Iterable iterable) {
        zzmn zzmnVar = this.zzb;
        if (!zzmnVar.zza()) {
            this.zzb = zzme.zzcw(zzmnVar);
        }
        zzkr.zzce(iterable, this.zzb);
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 == 2) {
                return zzcq(zzd, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzb", zzhl.class});
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 == 5) {
                        return zzd;
                    }
                    throw null;
                }
                return new zzhh(null);
            } else {
                return new zzho();
            }
        }
        return (byte) 1;
    }
}
