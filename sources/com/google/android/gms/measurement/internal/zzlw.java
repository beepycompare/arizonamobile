package com.google.android.gms.measurement.internal;

import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzlw implements Runnable {
    final /* synthetic */ zzma zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlw(zzma zzmaVar) {
        Objects.requireNonNull(zzmaVar);
        this.zza = zzmaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzma zzmaVar = this.zza;
        zzmaVar.zza = zzmaVar.zzw();
    }
}
