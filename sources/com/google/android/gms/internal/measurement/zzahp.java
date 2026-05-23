package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzahp implements zzaho {
    @Deprecated
    public static final zzom zza;
    @Deprecated
    public static final zzom zzb;
    @Deprecated
    public static final zzom zzc;

    static {
        zzog zzc2 = zzagr.zzc();
        zza = zzc2.zza("measurement.audience.refresh_event_count_filters_timestamp", false);
        zzb = zzc2.zza("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false);
        zzc = zzc2.zza("measurement.audience.use_bundle_timestamp_for_event_count_filters", false);
    }

    @Override // com.google.android.gms.internal.measurement.zzaho
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzaho
    public final boolean zzb() {
        return ((Boolean) zza.get()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzaho
    public final boolean zzc() {
        return ((Boolean) zzb.get()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzaho
    public final boolean zzd() {
        return ((Boolean) zzc.get()).booleanValue();
    }
}
