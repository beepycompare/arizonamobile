package com.google.android.gms.internal.measurement;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AsyncCallable;
import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
final class zzvg implements Runnable {
    private AsyncCallable zza;
    private Executor zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzvg(AsyncCallable asyncCallable, Executor executor) {
        this.zza = (AsyncCallable) Preconditions.checkNotNull(asyncCallable);
        this.zzb = (Executor) Preconditions.checkNotNull(executor);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza = null;
        this.zzb = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ AsyncCallable zza() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Executor zzb() {
        return this.zzb;
    }
}
