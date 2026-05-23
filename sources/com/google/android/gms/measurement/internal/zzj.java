package com.google.android.gms.measurement.internal;

import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement-sdk@@23.2.0 */
/* loaded from: classes4.dex */
final class zzj implements Runnable {
    final /* synthetic */ com.google.android.gms.internal.measurement.zzcs zza;
    final /* synthetic */ zzbh zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ AppMeasurementDynamiteService zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzj(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzcs zzcsVar, zzbh zzbhVar, String str) {
        this.zza = zzcsVar;
        this.zzb = zzbhVar;
        this.zzc = str;
        Objects.requireNonNull(appMeasurementDynamiteService);
        this.zzd = appMeasurementDynamiteService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzd.zza.zzt().zzN(this.zza, this.zzb, this.zzc);
    }
}
