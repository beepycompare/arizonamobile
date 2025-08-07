package com.google.android.gms.measurement.internal;

import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzov implements Runnable {
    final /* synthetic */ zzph zza;
    final /* synthetic */ zzpg zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzov(zzpg zzpgVar, zzph zzphVar) {
        this.zza = zzphVar;
        Objects.requireNonNull(zzpgVar);
        this.zzb = zzpgVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzpg zzpgVar = this.zzb;
        zzpgVar.zzau(this.zza);
        zzpgVar.zzc();
    }
}
