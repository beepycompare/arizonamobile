package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzqe implements zzqd {
    public static final zzkl zza;

    static {
        zzkf zzb = new zzkf(zzka.zza("com.google.android.gms.measurement")).zza().zzb();
        zzb.zzd("measurement.gmscore_feature_tracking", true);
        zza = zzb.zzd("measurement.gmscore_client_telemetry", false);
    }

    @Override // com.google.android.gms.internal.measurement.zzqd
    public final boolean zza() {
        return ((Boolean) zza.zzd()).booleanValue();
    }
}
