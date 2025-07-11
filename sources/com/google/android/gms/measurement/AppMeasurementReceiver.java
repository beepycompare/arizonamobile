package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.zzhk;
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
public final class AppMeasurementReceiver extends WakefulBroadcastReceiver implements zzhk.zza {
    private zzhk zza;

    public BroadcastReceiver.PendingResult doGoAsync() {
        return goAsync();
    }

    @Override // com.google.android.gms.measurement.internal.zzhk.zza
    public void doStartService(Context context, Intent intent) {
        startWakefulService(context, intent);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.zza == null) {
            this.zza = new zzhk(this);
        }
        this.zza.zza(context, intent);
    }
}
