package com.google.android.gms.internal.measurement;

import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzja extends zzadu implements zzafd {
    private static final zzja zzg;
    private static volatile zzafj zzh;
    private int zzb;
    private zzaef zze = zzcy();
    private zziw zzf;

    static {
        zzja zzjaVar = new zzja();
        zzg = zzjaVar;
        zzadu.zzcs(zzja.class, zzjaVar);
    }

    private zzja() {
    }

    public final List zza() {
        return this.zze;
    }

    public final zziw zzb() {
        zziw zziwVar = this.zzf;
        return zziwVar == null ? zziw.zzc() : zziwVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzadu
    public final Object zzg(int i, Object obj, Object obj2) {
        zzafj zzafjVar;
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 == 2) {
                return zzct(zzg, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"zzb", "zze", zzje.class, "zzf"});
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 != 5) {
                        if (i2 == 6) {
                            zzafj zzafjVar2 = zzh;
                            if (zzafjVar2 == null) {
                                synchronized (zzja.class) {
                                    zzafjVar = zzh;
                                    if (zzafjVar == null) {
                                        zzafjVar = new zzadq(zzg);
                                        zzh = zzafjVar;
                                    }
                                }
                                return zzafjVar;
                            }
                            return zzafjVar2;
                        }
                        throw null;
                    }
                    return zzg;
                }
                return new zziz(null);
            } else {
                return new zzja();
            }
        }
        return (byte) 1;
    }
}
