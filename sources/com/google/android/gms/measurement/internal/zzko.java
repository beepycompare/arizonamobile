package com.google.android.gms.measurement.internal;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzko implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ zzli zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzko(zzli zzliVar, AtomicReference atomicReference) {
        this.zza = atomicReference;
        Objects.requireNonNull(zzliVar);
        this.zzb = zzliVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference = this.zza;
        synchronized (atomicReference) {
            zzli zzliVar = this.zzb;
            atomicReference.set(Long.valueOf(zzliVar.zzu.zzc().zzl(zzliVar.zzu.zzv().zzj(), zzfx.zzac)));
            this.zza.notify();
        }
    }
}
