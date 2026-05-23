package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzgn extends zzadu implements zzafd {
    private static final zzgn zze;
    private static volatile zzafj zzf;
    private zzaef zzb = zzcy();

    static {
        zzgn zzgnVar = new zzgn();
        zze = zzgnVar;
        zzadu.zzcs(zzgn.class, zzgnVar);
    }

    private zzgn() {
    }

    @Override // com.google.android.gms.internal.measurement.zzadu
    public final Object zzg(int i, Object obj, Object obj2) {
        zzafj zzafjVar;
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 == 2) {
                return zzct(zze, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"zzb"});
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 != 5) {
                        if (i2 == 6) {
                            zzafj zzafjVar2 = zzf;
                            if (zzafjVar2 == null) {
                                synchronized (zzgn.class) {
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
                return new zzgm(null);
            } else {
                return new zzgn();
            }
        }
        return (byte) 1;
    }
}
