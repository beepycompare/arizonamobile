package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzjl;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement-api@@22.5.0 */
/* loaded from: classes4.dex */
final class zzd implements AppMeasurementSdk.OnEventListener {
    final /* synthetic */ zze zza;

    public zzd(zze zzeVar) {
        Objects.requireNonNull(zzeVar);
        this.zza = zzeVar;
    }

    @Override // com.google.android.gms.measurement.api.AppMeasurementSdk.OnEventListener, com.google.android.gms.measurement.internal.zzjp
    public final void onEvent(String str, String str2, Bundle bundle, long j) {
        zze zzeVar = this.zza;
        if (zzeVar.zza.contains(str2)) {
            Bundle bundle2 = new Bundle();
            int i = zzc.zza;
            String zza = zzjl.zza(str2);
            if (zza != null) {
                str2 = zza;
            }
            bundle2.putString("events", str2);
            zzeVar.zzd().onMessageTriggered(2, bundle2);
        }
    }
}
