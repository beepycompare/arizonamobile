package com.google.android.gms.internal.measurement;

import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzff extends zzadu implements zzafd {
    private static final zzff zzm;
    private static volatile zzafj zzn;
    private int zzb;
    private int zze;
    private String zzf = "";
    private zzaef zzg = zzcy();
    private boolean zzh;
    private zzfl zzi;
    private boolean zzj;
    private boolean zzk;
    private boolean zzl;

    static {
        zzff zzffVar = new zzff();
        zzm = zzffVar;
        zzadu.zzcs(zzff.class, zzffVar);
    }

    private zzff() {
    }

    public static zzfe zzn() {
        return (zzfe) zzm.zzcn();
    }

    public final boolean zza() {
        return (this.zzb & 1) != 0;
    }

    public final int zzb() {
        return this.zze;
    }

    public final String zzc() {
        return this.zzf;
    }

    public final List zzd() {
        return this.zzg;
    }

    public final int zze() {
        return this.zzg.size();
    }

    public final zzfh zzf(int i) {
        return (zzfh) this.zzg.get(i);
    }

    public final boolean zzh() {
        return (this.zzb & 8) != 0;
    }

    public final zzfl zzi() {
        zzfl zzflVar = this.zzi;
        return zzflVar == null ? zzfl.zzk() : zzflVar;
    }

    public final boolean zzj() {
        return this.zzj;
    }

    public final boolean zzk() {
        return this.zzk;
    }

    public final boolean zzl() {
        return (this.zzb & 64) != 0;
    }

    public final boolean zzm() {
        return this.zzl;
    }

    public final /* synthetic */ void zzo(String str) {
        this.zzb |= 2;
        this.zzf = str;
    }

    public final /* synthetic */ void zzp(int i, zzfh zzfhVar) {
        zzfhVar.getClass();
        zzaef zzaefVar = this.zzg;
        if (!zzaefVar.zza()) {
            this.zzg = zzadu.zzcz(zzaefVar);
        }
        this.zzg.set(i, zzfhVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzadu
    public final Object zzg(int i, Object obj, Object obj2) {
        zzafj zzafjVar;
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 == 2) {
                return zzct(zzm, "\u0004\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u001b\u0004ဇ\u0002\u0005ဉ\u0003\u0006ဇ\u0004\u0007ဇ\u0005\bဇ\u0006", new Object[]{"zzb", "zze", "zzf", "zzg", zzfh.class, "zzh", "zzi", "zzj", "zzk", "zzl"});
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 != 5) {
                        if (i2 == 6) {
                            zzafj zzafjVar2 = zzn;
                            if (zzafjVar2 == null) {
                                synchronized (zzff.class) {
                                    zzafjVar = zzn;
                                    if (zzafjVar == null) {
                                        zzafjVar = new zzadq(zzm);
                                        zzn = zzafjVar;
                                    }
                                }
                                return zzafjVar;
                            }
                            return zzafjVar2;
                        }
                        throw null;
                    }
                    return zzm;
                }
                return new zzfe(null);
            } else {
                return new zzff();
            }
        }
        return (byte) 1;
    }
}
