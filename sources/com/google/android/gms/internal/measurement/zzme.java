package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzme extends zzadu implements zzafd {
    private static final zzme zzh;
    private static volatile zzafj zzi;
    private int zzb;
    private zzmd zzf;
    private String zze = "";
    private String zzg = "";

    static {
        zzme zzmeVar = new zzme();
        zzh = zzmeVar;
        zzadu.zzcs(zzme.class, zzmeVar);
    }

    private zzme() {
    }

    public static zzmb zzb() {
        return (zzmb) zzh.zzcn();
    }

    public final String zza() {
        return this.zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(String str) {
        str.getClass();
        this.zzb |= 1;
        this.zze = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zzmd zzmdVar) {
        zzmdVar.getClass();
        this.zzf = zzmdVar;
        this.zzb |= 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zze(String str) {
        str.getClass();
        this.zzb |= 4;
        this.zzg = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzadu
    public final Object zzg(int i, Object obj, Object obj2) {
        zzafj zzafjVar;
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 == 2) {
                return zzct(zzh, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဉ\u0001\u0003ဈ\u0002", new Object[]{"zzb", "zze", "zzf", "zzg"});
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 != 5) {
                        if (i2 == 6) {
                            zzafj zzafjVar2 = zzi;
                            if (zzafjVar2 == null) {
                                synchronized (zzme.class) {
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
                return new zzmb(null);
            } else {
                return new zzme();
            }
        }
        return (byte) 1;
    }
}
