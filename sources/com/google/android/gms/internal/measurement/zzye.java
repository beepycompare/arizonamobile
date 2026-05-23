package com.google.android.gms.internal.measurement;

import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
final class zzye implements Runnable {
    final /* synthetic */ zzyd zza;
    final /* synthetic */ zzyf zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzye(zzyf zzyfVar, zzyd zzydVar) {
        this.zza = zzydVar;
        Objects.requireNonNull(zzyfVar);
        this.zzb = zzyfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzc().remove(this.zza);
    }
}
