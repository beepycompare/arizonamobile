package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zznk extends zzadu implements zzafd {
    private static final zznk zzo;
    private static volatile zzafj zzp;
    private int zzb;
    private boolean zzf;
    private zznm zzk;
    private boolean zzl;
    private boolean zzm;
    private zznf zzn;
    private zzacr zze = zzacr.zza;
    private String zzg = "";
    private zzaef zzh = zzcy();
    private zzaef zzi = zzcy();
    private zzaeb zzj = zzcv();

    static {
        zznk zznkVar = new zznk();
        zzo = zznkVar;
        zzadu.zzcs(zznk.class, zznkVar);
    }

    private zznk() {
    }

    public static zznk zza() {
        return zzo;
    }

    @Override // com.google.android.gms.internal.measurement.zzadu
    public final Object zzg(int i, Object obj, Object obj2) {
        zzafj zzafjVar;
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 == 2) {
                return zzct(zzo, "\u0004\n\u0000\u0001\u0001\f\n\u0000\u0003\u0000\u0001ည\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004\u001a\u0005\u001a\u0007ࠬ\bဉ\u0003\nဇ\u0004\u000bဇ\u0005\fဉ\u0006", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", zzabz.zzc(), "zzk", "zzl", "zzm", "zzn"});
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 != 5) {
                        if (i2 == 6) {
                            zzafj zzafjVar2 = zzp;
                            if (zzafjVar2 == null) {
                                synchronized (zznk.class) {
                                    zzafjVar = zzp;
                                    if (zzafjVar == null) {
                                        zzafjVar = new zzadq(zzo);
                                        zzp = zzafjVar;
                                    }
                                }
                                return zzafjVar;
                            }
                            return zzafjVar2;
                        }
                        throw null;
                    }
                    return zzo;
                }
                return new zznj(null);
            } else {
                return new zznk();
            }
        }
        return (byte) 1;
    }
}
