package com.google.android.gms.internal.measurement;

import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzhs extends zzme implements zznm {
    private static final zzhs zzi;
    private int zzb;
    private zzmn zzd = zzcv();
    private String zze = "";
    private long zzf;
    private long zzg;
    private int zzh;

    static {
        zzhs zzhsVar = new zzhs();
        zzi = zzhsVar;
        zzme.zzcp(zzhs.class, zzhsVar);
    }

    private zzhs() {
    }

    public static zzhr zzk() {
        return (zzhr) zzi.zzck();
    }

    private final void zzv() {
        zzmn zzmnVar = this.zzd;
        if (zzmnVar.zza()) {
            return;
        }
        this.zzd = zzme.zzcw(zzmnVar);
    }

    public final List zza() {
        return this.zzd;
    }

    public final int zzb() {
        return this.zzd.size();
    }

    public final zzhw zzc(int i) {
        return (zzhw) this.zzd.get(i);
    }

    public final String zzd() {
        return this.zze;
    }

    public final boolean zze() {
        return (this.zzb & 2) != 0;
    }

    public final long zzf() {
        return this.zzf;
    }

    public final boolean zzg() {
        return (this.zzb & 4) != 0;
    }

    public final long zzh() {
        return this.zzg;
    }

    public final boolean zzi() {
        return (this.zzb & 8) != 0;
    }

    public final int zzj() {
        return this.zzh;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 == 2) {
                return zzcq(zzi, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000\u0003ဂ\u0001\u0004ဂ\u0002\u0005င\u0003", new Object[]{"zzb", "zzd", zzhw.class, "zze", "zzf", "zzg", "zzh"});
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 == 5) {
                        return zzi;
                    }
                    throw null;
                }
                return new zzhr(null);
            } else {
                return new zzhs();
            }
        }
        return (byte) 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzm(int i, zzhw zzhwVar) {
        zzhwVar.getClass();
        zzv();
        this.zzd.set(i, zzhwVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzn(zzhw zzhwVar) {
        zzhwVar.getClass();
        zzv();
        this.zzd.add(zzhwVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(Iterable iterable) {
        zzv();
        zzkr.zzce(iterable, this.zzd);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzp() {
        this.zzd = zzcv();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzq(int i) {
        zzv();
        this.zzd.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzr(String str) {
        str.getClass();
        this.zzb |= 1;
        this.zze = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzs(long j) {
        this.zzb |= 2;
        this.zzf = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzt(long j) {
        this.zzb |= 4;
        this.zzg = j;
    }
}
