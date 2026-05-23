package com.google.android.gms.internal.measurement;

import com.google.common.base.Function;
import com.google.common.base.Stopwatch;
import com.google.common.util.concurrent.AsyncCallable;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.ExecutionSequencer;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public class zzut {
    private final String zza;
    private final ListenableFuture zzb;
    private final zzuv zzc;
    private final zzvm zze;
    private final zzvm zzf = new zzvm(new zzul(this, null), MoreExecutors.directExecutor());
    private final Object zzg = new Object();
    private List zzi = new ArrayList();
    private final ExecutionSequencer zzd = ExecutionSequencer.create();
    private final zzwb zzh = zzwb.zzb();

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzut(zzuv zzuvVar, zzvc zzvcVar, ListenableFuture listenableFuture, boolean z, String str) {
        this.zzc = zzuvVar;
        this.zzb = listenableFuture;
        this.zza = zzuvVar.zzc();
        final zzui zzuiVar = (zzui) zzuvVar;
        this.zze = new zzvm(new AsyncCallable() { // from class: com.google.android.gms.internal.measurement.zzuh
            @Override // com.google.common.util.concurrent.AsyncCallable
            public final /* synthetic */ ListenableFuture call() {
                return zzui.this.zzd();
            }
        }, MoreExecutors.directExecutor());
        zza(new AsyncFunction() { // from class: com.google.android.gms.internal.measurement.zzuq
            @Override // com.google.common.util.concurrent.AsyncFunction
            public final /* synthetic */ ListenableFuture apply(Object obj) {
                return zzut.this.zzc((zzth) obj);
            }
        });
    }

    public final void zza(AsyncFunction asyncFunction) {
        synchronized (this.zzg) {
            this.zzi.add(asyncFunction);
        }
    }

    public final ListenableFuture zzb(final Function function, final Executor executor) {
        final AsyncFunction zzc = zzxa.zzc(new AsyncFunction() { // from class: com.google.android.gms.internal.measurement.zzuo
            @Override // com.google.common.util.concurrent.AsyncFunction
            public final /* synthetic */ ListenableFuture apply(Object obj) {
                return Futures.immediateFuture(Function.this.apply(obj));
            }
        });
        Stopwatch.createStarted(zzxh.zza());
        String str = this.zza;
        String.valueOf(str);
        zzwi zza = this.zzh.zza("Update ".concat(String.valueOf(str)), zzxd.I_HAVE_PERMISSION_TO_USE_RESTRICTED_APIS);
        try {
            final ListenableFuture zza2 = this.zzf.zza();
            ExecutionSequencer executionSequencer = this.zzd;
            executionSequencer.submitAsync(new AsyncCallable() { // from class: com.google.android.gms.internal.measurement.zzum
                @Override // com.google.common.util.concurrent.AsyncCallable
                public final /* synthetic */ ListenableFuture call() {
                    return ListenableFuture.this;
                }
            }, MoreExecutors.directExecutor());
            ListenableFuture submitAsync = executionSequencer.submitAsync(zzxa.zzb(new AsyncCallable() { // from class: com.google.android.gms.internal.measurement.zzun
                @Override // com.google.common.util.concurrent.AsyncCallable
                public final /* synthetic */ ListenableFuture call() {
                    final zzut zzutVar = zzut.this;
                    final AsyncFunction asyncFunction = zzc;
                    final Executor executor2 = executor;
                    return Futures.transformAsync(zza2, zzxa.zzc(new AsyncFunction() { // from class: com.google.android.gms.internal.measurement.zzup
                        @Override // com.google.common.util.concurrent.AsyncFunction
                        public final /* synthetic */ ListenableFuture apply(Object obj) {
                            return zzut.this.zzd(asyncFunction, executor2, obj);
                        }
                    }), MoreExecutors.directExecutor());
                }
            }), MoreExecutors.directExecutor());
            Futures.propagateCancellation(submitAsync, zza2);
            Futures.nonCancellationPropagating(this.zzb);
            ListenableFuture zza3 = zzuy.zza(submitAsync);
            zza.zza(zza3);
            zza.close();
            return zza3;
        } catch (Throwable th) {
            try {
                zza.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzc(zzth zzthVar) {
        return this.zze.zza();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzd(AsyncFunction asyncFunction, Executor executor, Object obj) {
        return this.zzc.zzb(asyncFunction, executor, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ String zze() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzuv zzf() {
        return this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzvm zzg() {
        return this.zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Object zzh() {
        return this.zzg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzwb zzi() {
        return this.zzh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ List zzj() {
        return this.zzi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzk(List list) {
        this.zzi = list;
    }
}
