package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzmd extends zzgc {
    final /* synthetic */ AtomicReference zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmd(zznk zznkVar, AtomicReference atomicReference) {
        this.zza = atomicReference;
        Objects.requireNonNull(zznkVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzgd
    public final void zze(List list) {
        AtomicReference atomicReference = this.zza;
        synchronized (atomicReference) {
            atomicReference.set(list);
            atomicReference.notifyAll();
        }
    }
}
