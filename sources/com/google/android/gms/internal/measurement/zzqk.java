package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzqk implements zzqj {
    public static final zzkl zza;
    public static final zzkl zzb;
    public static final zzkl zzc;
    public static final zzkl zzd;
    public static final zzkl zze;
    public static final zzkl zzf;

    static {
        zzkf zzb2 = new zzkf(zzka.zza("com.google.android.gms.measurement")).zza().zzb();
        zza = zzb2.zzd("measurement.test.boolean_flag", false);
        zzb = zzb2.zzc("measurement.test.cached_long_flag", -1L);
        zzc = zzb2.zze("measurement.test.double_flag", -3.0d);
        zzd = zzb2.zzc("measurement.test.int_flag", -2L);
        zze = zzb2.zzc("measurement.test.long_flag", -1L);
        zzf = zzb2.zzf("measurement.test.string_flag", "---");
    }

    @Override // com.google.android.gms.internal.measurement.zzqj
    public final boolean zza() {
        return ((Boolean) zza.zzd()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzqj
    public final long zzb() {
        return ((Long) zzb.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzqj
    public final double zzc() {
        return ((Double) zzc.zzd()).doubleValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzqj
    public final long zzd() {
        return ((Long) zzd.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzqj
    public final long zze() {
        return ((Long) zze.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzqj
    public final String zzf() {
        return (String) zzf.zzd();
    }
}
