package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzpd implements zzpc {
    public static final zzkl zza;

    static {
        zzkf zzb = new zzkf(zzka.zza("com.google.android.gms.measurement")).zza().zzb();
        zzb.zzd("measurement.client.3p_consent_state_v1", true);
        zza = zzb.zzc("measurement.service.storage_consent_support_version", 203600L);
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zza() {
        return ((Long) zza.zzd()).longValue();
    }
}
