package com.google.android.gms.internal.measurement;

import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement@@23.0.0 */
/* loaded from: classes4.dex */
public final class zzja extends zzmf implements zznn {
    private static final zzja zzf;
    private int zzb;
    private zzmo zzd = zzcv();
    private zziw zze;

    static {
        zzja zzjaVar = new zzja();
        zzf = zzjaVar;
        zzmf.zzcp(zzja.class, zzjaVar);
    }

    private zzja() {
    }

    public final List zza() {
        return this.zzd;
    }

    public final zziw zzb() {
        zziw zziwVar = this.zze;
        return zziwVar == null ? zziw.zzc() : zziwVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 == 2) {
                return zzcq(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"zzb", "zzd", zzje.class, "zze"});
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 == 5) {
                        return zzf;
                    }
                    throw null;
                }
                return new zziz(null);
            } else {
                return new zzja();
            }
        }
        return (byte) 1;
    }
}
