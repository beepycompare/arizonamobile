package com.google.android.gms.measurement.internal;

import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzjy implements Runnable {
    final /* synthetic */ zzli zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjy(zzli zzliVar) {
        Objects.requireNonNull(zzliVar);
        this.zza = zzliVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzb.zza();
    }
}
