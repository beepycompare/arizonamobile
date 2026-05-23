package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzaha implements zzagz {
    @Deprecated
    public static final zzom zza;
    @Deprecated
    public static final zzom zzb;

    static {
        zzog zzc = zzagr.zzc();
        zza = zzc.zza("measurement.set_default_event_parameters.fix_app_update_logging", true);
        zzb = zzc.zza("measurement.set_default_event_parameters.fix_service_request_ordering", false);
    }

    @Override // com.google.android.gms.internal.measurement.zzagz
    public final boolean zza() {
        return ((Boolean) zza.get()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagz
    public final boolean zzb() {
        return ((Boolean) zzb.get()).booleanValue();
    }
}
