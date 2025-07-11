package com.google.android.gms.measurement.internal;

import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
final class zznn implements Runnable {
    final /* synthetic */ zzpf zza;
    final /* synthetic */ Runnable zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zznn(zzns zznsVar, zzpf zzpfVar, Runnable runnable) {
        this.zza = zzpfVar;
        this.zzb = runnable;
        Objects.requireNonNull(zznsVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzpf zzpfVar = this.zza;
        zzpfVar.zzY();
        zzpfVar.zzX(this.zzb);
        zzpfVar.zzM();
    }
}
