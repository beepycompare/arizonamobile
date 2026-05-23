package com.google.android.gms.internal.measurement;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.ExecutionException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzpx {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(final ListenableFuture listenableFuture) {
        listenableFuture.addListener(new Runnable() { // from class: com.google.android.gms.internal.measurement.zzpw
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                try {
                    Futures.getDone(ListenableFuture.this);
                } catch (ExecutionException e) {
                    zzrn.zzb().post(new Runnable() { // from class: com.google.android.gms.internal.measurement.zzpv
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            throw new RuntimeException(e.getCause());
                        }
                    });
                }
            }
        }, MoreExecutors.directExecutor());
    }
}
