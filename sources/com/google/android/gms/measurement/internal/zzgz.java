package com.google.android.gms.measurement.internal;

import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
final class zzgz implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzha zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgz(zzha zzhaVar, boolean z) {
        this.zza = z;
        Objects.requireNonNull(zzhaVar);
        this.zzb = zzhaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzc().zzar(this.zza);
    }
}
