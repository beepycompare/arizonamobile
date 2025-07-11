package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzhg extends zzme implements zznm {
    private static final zzhg zzh;
    private int zzb;
    private int zzd;
    private zzii zze;
    private zzii zzf;
    private boolean zzg;

    static {
        zzhg zzhgVar = new zzhg();
        zzh = zzhgVar;
        zzme.zzcp(zzhg.class, zzhgVar);
    }

    private zzhg() {
    }

    public static zzhf zzh() {
        return (zzhf) zzh.zzck();
    }

    public final boolean zza() {
        return (this.zzb & 1) != 0;
    }

    public final int zzb() {
        return this.zzd;
    }

    public final zzii zzc() {
        zzii zziiVar = this.zze;
        return zziiVar == null ? zzii.zzj() : zziiVar;
    }

    public final boolean zzd() {
        return (this.zzb & 4) != 0;
    }

    public final zzii zze() {
        zzii zziiVar = this.zzf;
        return zziiVar == null ? zzii.zzj() : zziiVar;
    }

    public final boolean zzf() {
        return (this.zzb & 8) != 0;
    }

    public final boolean zzg() {
        return this.zzg;
    }

    public final /* synthetic */ void zzi(int i) {
        this.zzb |= 1;
        this.zzd = i;
    }

    public final /* synthetic */ void zzj(zzii zziiVar) {
        zziiVar.getClass();
        this.zze = zziiVar;
        this.zzb |= 2;
    }

    public final /* synthetic */ void zzk(zzii zziiVar) {
        this.zzf = zziiVar;
        this.zzb |= 4;
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 == 2) {
                return zzcq(zzh, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဇ\u0003", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg"});
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 == 5) {
                        return zzh;
                    }
                    throw null;
                }
                return new zzhf(null);
            } else {
                return new zzhg();
            }
        }
        return (byte) 1;
    }

    public final /* synthetic */ void zzm(boolean z) {
        this.zzb |= 8;
        this.zzg = z;
    }
}
