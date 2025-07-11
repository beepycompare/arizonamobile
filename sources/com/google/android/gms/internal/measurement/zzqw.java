package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzqw implements zzqv {
    public static final zzkl zza;

    static {
        zzkf zzb = new zzkf(zzka.zza("com.google.android.gms.measurement")).zza().zzb();
        zza = zzb.zzd("measurement.session_stitching_token_enabled", false);
        zzb.zzd("measurement.link_sst_to_sid", true);
    }

    @Override // com.google.android.gms.internal.measurement.zzqv
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzqv
    public final boolean zzb() {
        return ((Boolean) zza.zzd()).booleanValue();
    }
}
