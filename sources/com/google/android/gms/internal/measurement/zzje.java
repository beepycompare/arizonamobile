package com.google.android.gms.internal.measurement;

import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzje extends zzadu implements zzafd {
    private static final zzje zzk;
    private static volatile zzafj zzl;
    private int zzb;
    private int zze;
    private zzaef zzf = zzcy();
    private String zzg = "";
    private String zzh = "";
    private boolean zzi;
    private double zzj;

    static {
        zzje zzjeVar = new zzje();
        zzk = zzjeVar;
        zzadu.zzcs(zzje.class, zzjeVar);
    }

    private zzje() {
    }

    public final List zza() {
        return this.zzf;
    }

    public final String zzb() {
        return this.zzg;
    }

    public final boolean zzc() {
        return (this.zzb & 4) != 0;
    }

    public final String zzd() {
        return this.zzh;
    }

    public final boolean zze() {
        return (this.zzb & 8) != 0;
    }

    public final boolean zzf() {
        return this.zzi;
    }

    public final boolean zzh() {
        return (this.zzb & 16) != 0;
    }

    public final double zzi() {
        return this.zzj;
    }

    public final int zzk() {
        int zza = zzjd.zza(this.zze);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzadu
    public final Object zzg(int i, Object obj, Object obj2) {
        zzafj zzafjVar;
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 == 2) {
                return zzct(zzk, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001᠌\u0000\u0002\u001b\u0003ဈ\u0001\u0004ဈ\u0002\u0005ဇ\u0003\u0006က\u0004", new Object[]{"zzb", "zze", zzjc.zza, "zzf", zzje.class, "zzg", "zzh", "zzi", "zzj"});
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 != 5) {
                        if (i2 == 6) {
                            zzafj zzafjVar2 = zzl;
                            if (zzafjVar2 == null) {
                                synchronized (zzje.class) {
                                    zzafjVar = zzl;
                                    if (zzafjVar == null) {
                                        zzafjVar = new zzadq(zzk);
                                        zzl = zzafjVar;
                                    }
                                }
                                return zzafjVar;
                            }
                            return zzafjVar2;
                        }
                        throw null;
                    }
                    return zzk;
                }
                return new zzjb(null);
            } else {
                return new zzje();
            }
        }
        return (byte) 1;
    }
}
