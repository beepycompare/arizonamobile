package com.google.android.gms.internal.measurement;

import java.util.Map;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zznu extends zzadu implements zzafd {
    private static final zznu zze;
    private static volatile zzafj zzf;
    private zzaew zzb = zzaew.zza();

    static {
        zznu zznuVar = new zznu();
        zze = zznuVar;
        zzadu.zzcs(zznu.class, zznuVar);
    }

    private zznu() {
    }

    public static zznu zzb() {
        return zze;
    }

    public final zznr zza(String str, zznr zznrVar) {
        str.getClass();
        zznr zznrVar2 = (zznr) this.zzb.get(str);
        return zznrVar2 != null ? zznrVar2 : zznrVar;
    }

    public final /* synthetic */ Map zzc() {
        if (!this.zzb.zze()) {
            this.zzb = this.zzb.zzc();
        }
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.measurement.zzadu
    public final Object zzg(int i, Object obj, Object obj2) {
        zzafj zzafjVar;
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 == 2) {
                return zzct(zze, "\u0004\u0001\u0000\u0000\u0002\u0002\u0001\u0001\u0000\u0000\u00022", new Object[]{"zzb", zzns.zza});
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 != 5) {
                        if (i2 == 6) {
                            zzafj zzafjVar2 = zzf;
                            if (zzafjVar2 == null) {
                                synchronized (zznu.class) {
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
                return new zznt(null);
            } else {
                return new zznu();
            }
        }
        return (byte) 1;
    }
}
