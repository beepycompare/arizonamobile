package com.google.android.gms.measurement.internal;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzme extends zzgf {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ zznk zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzme(zznk zznkVar, AtomicReference atomicReference) {
        this.zza = atomicReference;
        Objects.requireNonNull(zznkVar);
        this.zzb = zznkVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzgg
    public final void zze(zzop zzopVar) {
        AtomicReference atomicReference = this.zza;
        synchronized (atomicReference) {
            this.zzb.zzu.zzaV().zzk().zzb("[sgtm] Got upload batches from service. count", Integer.valueOf(zzopVar.zza.size()));
            atomicReference.set(zzopVar);
            atomicReference.notifyAll();
        }
    }
}
