package com.google.android.gms.internal.measurement;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzhw extends zzadu implements zzafd {
    private static final zzhw zzk;
    private static volatile zzafj zzl;
    private int zzb;
    private long zzg;
    private float zzh;
    private double zzi;
    private String zze = "";
    private String zzf = "";
    private zzaef zzj = zzcy();

    static {
        zzhw zzhwVar = new zzhw();
        zzk = zzhwVar;
        zzadu.zzcs(zzhw.class, zzhwVar);
    }

    private zzhw() {
    }

    public static zzhv zzn() {
        return (zzhv) zzk.zzcn();
    }

    private final void zzz() {
        zzaef zzaefVar = this.zzj;
        if (zzaefVar.zza()) {
            return;
        }
        this.zzj = zzadu.zzcz(zzaefVar);
    }

    public final boolean zza() {
        return (this.zzb & 1) != 0;
    }

    public final String zzb() {
        return this.zze;
    }

    public final boolean zzc() {
        return (this.zzb & 2) != 0;
    }

    public final String zzd() {
        return this.zzf;
    }

    public final boolean zze() {
        return (this.zzb & 4) != 0;
    }

    public final long zzf() {
        return this.zzg;
    }

    public final boolean zzh() {
        return (this.zzb & 8) != 0;
    }

    public final float zzi() {
        return this.zzh;
    }

    public final boolean zzj() {
        return (this.zzb & 16) != 0;
    }

    public final double zzk() {
        return this.zzi;
    }

    public final List zzl() {
        return this.zzj;
    }

    public final int zzm() {
        return this.zzj.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(String str) {
        str.getClass();
        this.zzb |= 1;
        this.zze = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzp(String str) {
        str.getClass();
        this.zzb |= 2;
        this.zzf = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzq() {
        this.zzb &= -3;
        this.zzf = zzk.zzf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzr(long j) {
        this.zzb |= 4;
        this.zzg = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzs() {
        this.zzb &= -5;
        this.zzg = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzt(double d) {
        this.zzb |= 16;
        this.zzi = d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzu() {
        this.zzb &= -17;
        this.zzi = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzv(zzhw zzhwVar) {
        zzhwVar.getClass();
        zzz();
        this.zzj.add(zzhwVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzw(Iterable iterable) {
        zzz();
        zzacb.zzcg(iterable, this.zzj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzx() {
        this.zzj = zzcy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzadu
    public final Object zzg(int i, Object obj, Object obj2) {
        zzafj zzafjVar;
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 == 2) {
                return zzct(zzk, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ခ\u0003\u0005က\u0004\u0006\u001b", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", zzhw.class});
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 != 5) {
                        if (i2 == 6) {
                            zzafj zzafjVar2 = zzl;
                            if (zzafjVar2 == null) {
                                synchronized (zzhw.class) {
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
                return new zzhv(null);
            } else {
                return new zzhw();
            }
        }
        return (byte) 1;
    }
}
