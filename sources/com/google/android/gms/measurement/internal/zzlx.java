package com.google.android.gms.measurement.internal;

import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzlx implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzma zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlx(zzma zzmaVar, long j) {
        this.zza = j;
        Objects.requireNonNull(zzmaVar);
        this.zzb = zzmaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzma zzmaVar = this.zzb;
        zzmaVar.zzu.zzw().zzc(this.zza);
        zzmaVar.zza = null;
    }
}
