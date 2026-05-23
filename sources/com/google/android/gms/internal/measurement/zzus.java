package com.google.android.gms.internal.measurement;

import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.Objects;
import java.util.concurrent.Executor;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzus implements zzth {
    final /* synthetic */ zzut zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzus(zzut zzutVar, byte[] bArr) {
        Objects.requireNonNull(zzutVar);
        this.zza = zzutVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzth
    public final ListenableFuture zza(final AsyncFunction asyncFunction, final Executor executor) {
        return zzuy.zza(Futures.transformAsync(Futures.nonCancellationPropagating(this.zza.zzg().zza()), zzxa.zzc(new AsyncFunction() { // from class: com.google.android.gms.internal.measurement.zzur
            @Override // com.google.common.util.concurrent.AsyncFunction
            public final /* synthetic */ ListenableFuture apply(Object obj) {
                Void r3 = (Void) obj;
                return zzus.this.zza.zzf().zzb(asyncFunction, executor, null);
            }
        }), MoreExecutors.directExecutor()));
    }
}
