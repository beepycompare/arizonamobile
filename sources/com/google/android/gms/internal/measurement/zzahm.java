package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzahm implements zzahl {
    @Deprecated
    public static final zzom zza;
    @Deprecated
    public static final zzom zzb;

    static {
        zzog zzc = zzagr.zzc();
        zza = zzc.zza("measurement.service.store_null_safelist", true);
        zzb = zzc.zza("measurement.service.store_safelist", true);
    }

    @Override // com.google.android.gms.internal.measurement.zzahl
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzahl
    public final boolean zzb() {
        return ((Boolean) zza.get()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzahl
    public final boolean zzc() {
        return ((Boolean) zzb.get()).booleanValue();
    }
}
