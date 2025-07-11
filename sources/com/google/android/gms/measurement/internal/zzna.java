package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
final class zzna implements Runnable {
    final /* synthetic */ zzne zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzna(zzne zzneVar) {
        Objects.requireNonNull(zzneVar);
        this.zza = zzneVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zznk zznkVar = this.zza.zza;
        zzib zzibVar = zznkVar.zzu;
        Context zzaY = zzibVar.zzaY();
        zzibVar.zzaU();
        zznkVar.zzW(new ComponentName(zzaY, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
