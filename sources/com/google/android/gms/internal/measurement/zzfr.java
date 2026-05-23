package com.google.android.gms.internal.measurement;

import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzfr extends zzadu implements zzafd {
    private static final zzfr zzi;
    private static volatile zzafj zzj;
    private int zzb;
    private int zze;
    private boolean zzg;
    private String zzf = "";
    private zzaef zzh = zzcy();

    static {
        zzfr zzfrVar = new zzfr();
        zzi = zzfrVar;
        zzadu.zzcs(zzfr.class, zzfrVar);
    }

    private zzfr() {
    }

    public static zzfr zzi() {
        return zzi;
    }

    public final boolean zza() {
        return (this.zzb & 1) != 0;
    }

    public final boolean zzb() {
        return (this.zzb & 2) != 0;
    }

    public final String zzc() {
        return this.zzf;
    }

    public final boolean zzd() {
        return (this.zzb & 4) != 0;
    }

    public final boolean zze() {
        return this.zzg;
    }

    public final List zzf() {
        return this.zzh;
    }

    public final int zzh() {
        return this.zzh.size();
    }

    public final int zzk() {
        int zza = zzfq.zza(this.zze);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzadu
    public final Object zzg(int i, Object obj, Object obj2) {
        zzafj zzafjVar;
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 == 2) {
                return zzct(zzi, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004\u001a", new Object[]{"zzb", "zze", zzfp.zza, "zzf", "zzg", "zzh"});
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 != 5) {
                        if (i2 == 6) {
                            zzafj zzafjVar2 = zzj;
                            if (zzafjVar2 == null) {
                                synchronized (zzfr.class) {
                                    zzafjVar = zzj;
                                    if (zzafjVar == null) {
                                        zzafjVar = new zzadq(zzi);
                                        zzj = zzafjVar;
                                    }
                                }
                                return zzafjVar;
                            }
                            return zzafjVar2;
                        }
                        throw null;
                    }
                    return zzi;
                }
                return new zzfo(null);
            } else {
                return new zzfr();
            }
        }
        return (byte) 1;
    }
}
