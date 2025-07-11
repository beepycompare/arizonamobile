package com.google.android.gms.measurement.internal;

import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement-sdk@@22.5.0 */
/* loaded from: classes3.dex */
final class zzl implements Runnable {
    final /* synthetic */ zzp zza;
    final /* synthetic */ AppMeasurementDynamiteService zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzl(AppMeasurementDynamiteService appMeasurementDynamiteService, zzp zzpVar) {
        this.zza = zzpVar;
        Objects.requireNonNull(appMeasurementDynamiteService);
        this.zzb = appMeasurementDynamiteService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzj().zzV(this.zza);
    }
}
