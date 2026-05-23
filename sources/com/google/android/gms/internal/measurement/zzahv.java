package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzahv implements zzahu {
    @Deprecated
    public static final zzom zza;
    @Deprecated
    public static final zzom zzb;

    static {
        zzog zzc = zzagr.zzc();
        zza = zzc.zza("45753512", false);
        zzb = zzc.zza("measurement.gbraid_campaign.stop_lgclid", false);
    }

    @Override // com.google.android.gms.internal.measurement.zzahu
    public final boolean zza() {
        return ((Boolean) zza.get()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzahu
    public final boolean zzb() {
        return ((Boolean) zzb.get()).booleanValue();
    }
}
