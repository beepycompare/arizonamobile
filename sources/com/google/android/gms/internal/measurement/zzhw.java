package com.google.android.gms.internal.measurement;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzhw extends zzme implements zznm {
    private static final zzhw zzj;
    private int zzb;
    private long zzf;
    private float zzg;
    private double zzh;
    private String zzd = "";
    private String zze = "";
    private zzmn zzi = zzcv();

    static {
        zzhw zzhwVar = new zzhw();
        zzj = zzhwVar;
        zzme.zzcp(zzhw.class, zzhwVar);
    }

    private zzhw() {
    }

    public static zzhv zzn() {
        return (zzhv) zzj.zzck();
    }

    private final void zzz() {
        zzmn zzmnVar = this.zzi;
        if (zzmnVar.zza()) {
            return;
        }
        this.zzi = zzme.zzcw(zzmnVar);
    }

    public final boolean zza() {
        return (this.zzb & 1) != 0;
    }

    public final String zzb() {
        return this.zzd;
    }

    public final boolean zzc() {
        return (this.zzb & 2) != 0;
    }

    public final String zzd() {
        return this.zze;
    }

    public final boolean zze() {
        return (this.zzb & 4) != 0;
    }

    public final long zzf() {
        return this.zzf;
    }

    public final boolean zzg() {
        return (this.zzb & 8) != 0;
    }

    public final float zzh() {
        return this.zzg;
    }

    public final boolean zzi() {
        return (this.zzb & 16) != 0;
    }

    public final double zzj() {
        return this.zzh;
    }

    public final List zzk() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 == 2) {
                return zzcq(zzj, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ခ\u0003\u0005က\u0004\u0006\u001b", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", zzhw.class});
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 == 5) {
                        return zzj;
                    }
                    throw null;
                }
                return new zzhv(null);
            } else {
                return new zzhw();
            }
        }
        return (byte) 1;
    }

    public final int zzm() {
        return this.zzi.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(String str) {
        str.getClass();
        this.zzb |= 1;
        this.zzd = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzp(String str) {
        str.getClass();
        this.zzb |= 2;
        this.zze = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzq() {
        this.zzb &= -3;
        this.zze = zzj.zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzr(long j) {
        this.zzb |= 4;
        this.zzf = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzs() {
        this.zzb &= -5;
        this.zzf = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzt(double d) {
        this.zzb |= 16;
        this.zzh = d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzu() {
        this.zzb &= -17;
        this.zzh = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzv(zzhw zzhwVar) {
        zzhwVar.getClass();
        zzz();
        this.zzi.add(zzhwVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzw(Iterable iterable) {
        zzz();
        zzkr.zzce(iterable, this.zzi);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzx() {
        this.zzi = zzcv();
    }
}
