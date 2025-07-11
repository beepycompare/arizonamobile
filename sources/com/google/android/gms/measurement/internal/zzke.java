package com.google.android.gms.measurement.internal;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzke implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzli zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzke(zzli zzliVar, AtomicReference atomicReference, boolean z) {
        this.zza = atomicReference;
        this.zzb = z;
        Objects.requireNonNull(zzliVar);
        this.zzc = zzliVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zzu.zzt().zzv(this.zza, this.zzb);
    }
}
