package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzmq extends zzadu implements zzafd {
    private static final zzmq zzj;
    private static volatile zzafj zzk;
    private int zzb;
    private long zzh;
    private zzaew zzi = zzaew.zza();
    private String zze = "";
    private zzacr zzf = zzacr.zza;
    private String zzg = "";

    static {
        zzmq zzmqVar = new zzmq();
        zzj = zzmqVar;
        zzadu.zzcs(zzmq.class, zzmqVar);
    }

    private zzmq() {
    }

    public static zzmq zzh(zzacv zzacvVar, zzadf zzadfVar) throws IOException {
        return (zzmq) zzadu.zzcC(zzj, zzacvVar, zzadfVar);
    }

    public static zzmq zzi() {
        return zzj;
    }

    public final String zza() {
        return this.zze;
    }

    public final zzacr zzb() {
        return this.zzf;
    }

    public final String zzc() {
        return this.zzg;
    }

    public final long zzd() {
        return this.zzh;
    }

    public final int zze() {
        return this.zzi.size();
    }

    public final Map zzf() {
        return Collections.unmodifiableMap(this.zzi);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzadu
    public final Object zzg(int i, Object obj, Object obj2) {
        zzafj zzafjVar;
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 == 2) {
                return zzct(zzj, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0001\u0000\u0000\u0001ဈ\u0000\u0002ည\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u00052", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", zzmp.zza});
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 != 5) {
                        if (i2 == 6) {
                            zzafj zzafjVar2 = zzk;
                            if (zzafjVar2 == null) {
                                synchronized (zzmq.class) {
                                    zzafjVar = zzk;
                                    if (zzafjVar == null) {
                                        zzafjVar = new zzadq(zzj);
                                        zzk = zzafjVar;
                                    }
                                }
                                return zzafjVar;
                            }
                            return zzafjVar2;
                        }
                        throw null;
                    }
                    return zzj;
                }
                return new zzmo(null);
            } else {
                return new zzmq();
            }
        }
        return (byte) 1;
    }
}
