package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement-sdk@@22.5.0 */
/* loaded from: classes3.dex */
final class zzq implements zzjp {
    public final com.google.android.gms.internal.measurement.zzda zza;
    final /* synthetic */ AppMeasurementDynamiteService zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzq(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzda zzdaVar) {
        Objects.requireNonNull(appMeasurementDynamiteService);
        this.zzb = appMeasurementDynamiteService;
        this.zza = zzdaVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzjp
    public final void onEvent(String str, String str2, Bundle bundle, long j) {
        try {
            this.zza.zze(str, str2, bundle, j);
        } catch (RemoteException e) {
            zzib zzibVar = this.zzb.zza;
            if (zzibVar != null) {
                zzibVar.zzaV().zze().zzb("Event listener threw exception", e);
            }
        }
    }
}
