package com.google.android.gms.measurement.internal;

import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement-sdk@@22.5.0 */
/* loaded from: classes3.dex */
final class zzk implements Runnable {
    final /* synthetic */ com.google.android.gms.internal.measurement.zzcu zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ AppMeasurementDynamiteService zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzk(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzcu zzcuVar, String str, String str2, boolean z) {
        this.zza = zzcuVar;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = z;
        Objects.requireNonNull(appMeasurementDynamiteService);
        this.zze = appMeasurementDynamiteService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zze.zza.zzt().zzu(this.zza, this.zzb, this.zzc, this.zzd);
    }
}
