package com.google.android.gms.measurement.internal;

import java.util.Objects;
import java.util.concurrent.Executor;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzju implements Executor {
    final /* synthetic */ zzli zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzju(zzli zzliVar) {
        Objects.requireNonNull(zzliVar);
        this.zza = zzliVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.zza.zzu.zzaW().zzj(runnable);
    }
}
