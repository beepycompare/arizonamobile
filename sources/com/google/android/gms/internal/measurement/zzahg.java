package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzahg implements zzahf {
    @Deprecated
    public static final zzom zza;
    @Deprecated
    public static final zzom zzb;
    @Deprecated
    public static final zzom zzc;

    static {
        zzog zzc2 = zzagr.zzc();
        zza = zzc2.zzd("45761323", "");
        zzb = zzc2.zzd("45762029", "");
        zzc = zzc2.zzd("45762030", "");
    }

    @Override // com.google.android.gms.internal.measurement.zzahf
    public final String zza() {
        return (String) zza.get();
    }

    @Override // com.google.android.gms.internal.measurement.zzahf
    public final String zzb() {
        return (String) zzb.get();
    }

    @Override // com.google.android.gms.internal.measurement.zzahf
    public final String zzc() {
        return (String) zzc.get();
    }
}
