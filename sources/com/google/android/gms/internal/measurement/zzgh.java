package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzgh extends zzadu implements zzafd {
    private static final zzgh zzh;
    private static volatile zzafj zzi;
    private int zzb;
    private String zze = "";
    private zzaef zzf = zzcy();
    private boolean zzg;

    static {
        zzgh zzghVar = new zzgh();
        zzh = zzghVar;
        zzadu.zzcs(zzgh.class, zzghVar);
    }

    private zzgh() {
    }

    public final String zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.measurement.zzadu
    public final Object zzg(int i, Object obj, Object obj2) {
        zzafj zzafjVar;
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 == 2) {
                return zzct(zzh, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b\u0003ဇ\u0001", new Object[]{"zzb", "zze", "zzf", zzgr.class, "zzg"});
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 != 5) {
                        if (i2 == 6) {
                            zzafj zzafjVar2 = zzi;
                            if (zzafjVar2 == null) {
                                synchronized (zzgh.class) {
                                    zzafjVar = zzi;
                                    if (zzafjVar == null) {
                                        zzafjVar = new zzadq(zzh);
                                        zzi = zzafjVar;
                                    }
                                }
                                return zzafjVar;
                            }
                            return zzafjVar2;
                        }
                        throw null;
                    }
                    return zzh;
                }
                return new zzgg(null);
            } else {
                return new zzgh();
            }
        }
        return (byte) 1;
    }
}
