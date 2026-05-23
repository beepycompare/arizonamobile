package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.Preconditions;
/* compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzhl {
    private final zza zza;

    /* compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
    /* loaded from: classes4.dex */
    public interface zza {
        void doStartService(Context context, Intent intent);
    }

    public zzhl(zza zzaVar) {
        Preconditions.checkNotNull(zzaVar);
        this.zza = zzaVar;
    }

    public final void zza(Context context, Intent intent) {
        zzic zzy = zzic.zzy(context, null, null, null);
        zzgu zzaW = zzy.zzaW();
        if (intent == null) {
            zzaW.zze().zza("Receiver called with null intent");
            return;
        }
        zzy.zzaV();
        String action = intent.getAction();
        zzaW.zzk().zzb("Local receiver got", action);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(action)) {
            if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
                zzaW.zze().zza("Install Referrer Broadcasts are deprecated");
                return;
            }
            return;
        }
        Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
        className.setAction("com.google.android.gms.measurement.UPLOAD");
        zzaW.zzk().zza("Starting wakeful intent.");
        this.zza.doStartService(context, className);
    }
}
