package com.google.android.gms.internal.measurement;

import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzqv extends zzadu implements zzafd {
    private static final zzqv zzj;
    private static volatile zzafj zzk;
    private int zzb;
    private long zzh;
    private String zze = "";
    private zzacr zzf = zzacr.zza;
    private String zzg = "";
    private zzaef zzi = zzcy();

    static {
        zzqv zzqvVar = new zzqv();
        zzj = zzqvVar;
        zzadu.zzcs(zzqv.class, zzqvVar);
    }

    private zzqv() {
    }

    public static zzqu zzh() {
        return (zzqu) zzj.zzcn();
    }

    public static zzqv zzi() {
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

    public final List zze() {
        return this.zzi;
    }

    public final int zzf() {
        return this.zzi.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzj(String str) {
        str.getClass();
        this.zzb |= 1;
        this.zze = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzk(zzacr zzacrVar) {
        zzacrVar.getClass();
        this.zzb |= 2;
        this.zzf = zzacrVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzl(String str) {
        str.getClass();
        this.zzb |= 4;
        this.zzg = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzm(long j) {
        this.zzb |= 8;
        this.zzh = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzn(zzqx zzqxVar) {
        zzqxVar.getClass();
        zzaef zzaefVar = this.zzi;
        if (!zzaefVar.zza()) {
            this.zzi = zzadu.zzcz(zzaefVar);
        }
        this.zzi.add(zzqxVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzadu
    public final Object zzg(int i, Object obj, Object obj2) {
        zzafj zzafjVar;
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 == 2) {
                return zzct(zzj, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဈ\u0000\u0002ည\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005\u001b", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", zzqx.class});
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 != 5) {
                        if (i2 == 6) {
                            zzafj zzafjVar2 = zzk;
                            if (zzafjVar2 == null) {
                                synchronized (zzqv.class) {
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
                return new zzqu(null);
            } else {
                return new zzqv();
            }
        }
        return (byte) 1;
    }
}
