package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzhu extends zzadu implements zzafd {
    private static final zzhu zzg;
    private static volatile zzafj zzh;
    private int zzb;
    private String zze = "";
    private long zzf;

    static {
        zzhu zzhuVar = new zzhu();
        zzg = zzhuVar;
        zzadu.zzcs(zzhu.class, zzhuVar);
    }

    private zzhu() {
    }

    public static zzht zza() {
        return (zzht) zzg.zzcn();
    }

    public final /* synthetic */ void zzb(String str) {
        str.getClass();
        this.zzb |= 1;
        this.zze = str;
    }

    public final /* synthetic */ void zzc(long j) {
        this.zzb |= 2;
        this.zzf = j;
    }

    @Override // com.google.android.gms.internal.measurement.zzadu
    public final Object zzg(int i, Object obj, Object obj2) {
        zzafj zzafjVar;
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 == 2) {
                return zzct(zzg, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001", new Object[]{"zzb", "zze", "zzf"});
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 != 5) {
                        if (i2 == 6) {
                            zzafj zzafjVar2 = zzh;
                            if (zzafjVar2 == null) {
                                synchronized (zzhu.class) {
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
                return new zzht(null);
            } else {
                return new zzhu();
            }
        }
        return (byte) 1;
    }
}
