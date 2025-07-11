package com.google.android.gms.measurement.internal;

import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzou implements Runnable {
    final /* synthetic */ zzpg zza;
    final /* synthetic */ zzpf zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzou(zzpf zzpfVar, zzpg zzpgVar) {
        this.zza = zzpgVar;
        Objects.requireNonNull(zzpfVar);
        this.zzb = zzpfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzpf zzpfVar = this.zzb;
        zzpfVar.zzat(this.zza);
        zzpfVar.zzc();
    }
}
