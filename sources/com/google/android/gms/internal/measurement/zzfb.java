package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzfb extends zzadu implements zzafd {
    private static final zzfb zzi;
    private static volatile zzafj zzj;
    private int zzb;
    private boolean zzf;
    private long zzh;
    private String zze = "";
    private String zzg = "";

    static {
        zzfb zzfbVar = new zzfb();
        zzi = zzfbVar;
        zzadu.zzcs(zzfb.class, zzfbVar);
    }

    private zzfb() {
    }

    public static zzfa zza() {
        return (zzfa) zzi.zzcn();
    }

    public final /* synthetic */ void zzb(String str) {
        this.zzb |= 1;
        this.zze = str;
    }

    public final /* synthetic */ void zzc(boolean z) {
        this.zzb |= 2;
        this.zzf = true;
    }

    public final /* synthetic */ void zzd(String str) {
        str.getClass();
        this.zzb |= 4;
        this.zzg = str;
    }

    public final /* synthetic */ void zze(long j) {
        this.zzb |= 8;
        this.zzh = j;
    }

    @Override // com.google.android.gms.internal.measurement.zzadu
    public final Object zzg(int i, Object obj, Object obj2) {
        zzafj zzafjVar;
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 == 2) {
                return zzct(zzi, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004ဂ\u0003", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh"});
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 != 5) {
                        if (i2 == 6) {
                            zzafj zzafjVar2 = zzj;
                            if (zzafjVar2 == null) {
                                synchronized (zzfb.class) {
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
                return new zzfa(null);
            } else {
                return new zzfb();
            }
        }
        return (byte) 1;
    }
}
