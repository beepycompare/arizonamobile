package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzain implements zzaim {
    @Deprecated
    public static final zzom zza;
    @Deprecated
    public static final zzom zzb;

    static {
        zzog zzc = zzagr.zzc();
        zza = zzc.zza("measurement.experiment.enable_passthrough_experiment_reporting", true);
        zzb = zzc.zza("measurement.experiment.enable_phenotype_experiment_reporting", true);
    }

    @Override // com.google.android.gms.internal.measurement.zzaim
    public final boolean zza() {
        return ((Boolean) zza.get()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzaim
    public final boolean zzb() {
        return ((Boolean) zzb.get()).booleanValue();
    }
}
