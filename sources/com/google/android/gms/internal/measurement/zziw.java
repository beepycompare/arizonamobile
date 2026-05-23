package com.google.android.gms.internal.measurement;

import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* loaded from: classes4.dex */
public final class zziw extends zzadu implements zzafd {
    private static final zziw zze;
    private static volatile zzafj zzf;
    private zzaef zzb = zzcy();

    static {
        zziw zziwVar = new zziw();
        zze = zziwVar;
        zzadu.zzcs(zziw.class, zziwVar);
    }

    private zziw() {
    }

    public static zziw zzc() {
        return zze;
    }

    public final List zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zzb.size();
    }

    @Override // com.google.android.gms.internal.measurement.zzadu
    public final Object zzg(int i, Object obj, Object obj2) {
        zzafj zzafjVar;
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 == 2) {
                return zzct(zze, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzb", zziy.class});
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 != 5) {
                        if (i2 == 6) {
                            zzafj zzafjVar2 = zzf;
                            if (zzafjVar2 == null) {
                                synchronized (zziw.class) {
                                    zzafjVar = zzf;
                                    if (zzafjVar == null) {
                                        zzafjVar = new zzadq(zze);
                                        zzf = zzafjVar;
                                    }
                                }
                                return zzafjVar;
                            }
                            return zzafjVar2;
                        }
                        throw null;
                    }
                    return zze;
                }
                return new zziv(null);
            } else {
                return new zziw();
            }
        }
        return (byte) 1;
    }
}
