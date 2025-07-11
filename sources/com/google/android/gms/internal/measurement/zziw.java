package com.google.android.gms.internal.measurement;

import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
public final class zziw extends zzme implements zznm {
    private static final zziw zzd;
    private zzmn zzb = zzcv();

    static {
        zziw zziwVar = new zziw();
        zzd = zziwVar;
        zzme.zzcp(zziw.class, zziwVar);
    }

    private zziw() {
    }

    public static zziw zzc() {
        return zzd;
    }

    public final List zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zzb.size();
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 == 2) {
                return zzcq(zzd, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzb", zziy.class});
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 == 5) {
                        return zzd;
                    }
                    throw null;
                }
                return new zziv(null);
            } else {
                return new zziw();
            }
        }
        return (byte) 1;
    }
}
