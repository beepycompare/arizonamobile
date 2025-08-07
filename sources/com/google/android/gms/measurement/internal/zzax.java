package com.google.android.gms.measurement.internal;

import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.0.0 */
/* loaded from: classes3.dex */
final class zzax implements Runnable {
    final /* synthetic */ zzjg zza;
    final /* synthetic */ zzay zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzax(zzay zzayVar, zzjg zzjgVar) {
        this.zza = zzjgVar;
        Objects.requireNonNull(zzayVar);
        this.zzb = zzayVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjg zzjgVar = this.zza;
        zzjgVar.zzaU();
        if (zzae.zza()) {
            zzjgVar.zzaW().zzj(this);
            return;
        }
        zzay zzayVar = this.zzb;
        boolean zzc = zzayVar.zzc();
        zzayVar.zze(0L);
        if (zzc) {
            zzayVar.zza();
        }
    }
}
