package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.0.0 */
/* loaded from: classes4.dex */
final class zznb implements Runnable {
    final /* synthetic */ zznf zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zznb(zznf zznfVar) {
        Objects.requireNonNull(zznfVar);
        this.zza = zznfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zznl zznlVar = this.zza.zza;
        zzic zzicVar = zznlVar.zzu;
        Context zzaY = zzicVar.zzaY();
        zzicVar.zzaU();
        zznlVar.zzW(new ComponentName(zzaY, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
