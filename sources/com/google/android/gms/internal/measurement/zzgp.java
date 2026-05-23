package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzgp extends zzadu implements zzafd {
    private static final zzgp zzj;
    private static volatile zzafj zzk;
    private int zzb;
    private int zze = 14;
    private int zzf = 11;
    private int zzg = 60;
    private int zzh = 13;
    private int zzi = 11;

    static {
        zzgp zzgpVar = new zzgp();
        zzj = zzgpVar;
        zzadu.zzcs(zzgp.class, zzgpVar);
    }

    private zzgp() {
    }

    @Override // com.google.android.gms.internal.measurement.zzadu
    public final Object zzg(int i, Object obj, Object obj2) {
        zzafj zzafjVar;
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 == 2) {
                return zzct(zzj, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi"});
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 != 5) {
                        if (i2 == 6) {
                            zzafj zzafjVar2 = zzk;
                            if (zzafjVar2 == null) {
                                synchronized (zzgp.class) {
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
                return new zzgo(null);
            } else {
                return new zzgp();
            }
        }
        return (byte) 1;
    }
}
