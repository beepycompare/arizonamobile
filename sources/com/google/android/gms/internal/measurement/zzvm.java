package com.google.android.gms.internal.measurement;

import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import com.google.common.util.concurrent.AsyncCallable;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzvm {
    private final zzvg zza;
    private final AtomicLong zzb = new AtomicLong(zzi(Integer.MIN_VALUE, Integer.MIN_VALUE));
    private final AtomicReference zzc = new AtomicReference(null);
    private final AtomicReference zzd = new AtomicReference(null);
    private final Executor zze = MoreExecutors.newSequentialExecutor(MoreExecutors.directExecutor());
    private final SettableFuture zzf;

    public zzvm(AsyncCallable asyncCallable, Executor executor) {
        SettableFuture create = SettableFuture.create();
        this.zzf = create;
        zzvg zzvgVar = new zzvg(asyncCallable, executor);
        this.zza = zzvgVar;
        create.addListener(zzvgVar, MoreExecutors.directExecutor());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzh */
    public final ListenableFuture zzd(int i) {
        AtomicReference atomicReference;
        zzvl zzvlVar;
        Executor zzb;
        AtomicLong atomicLong = this.zzb;
        if (((int) (atomicLong.get() >>> 32)) > i) {
            return Futures.immediateCancelledFuture();
        }
        zzvl zzvlVar2 = new zzvl(i);
        do {
            atomicReference = this.zzc;
            zzvlVar = (zzvl) atomicReference.get();
            if (zzvlVar != null && zzvlVar.zza() > i) {
                return Futures.immediateCancelledFuture();
            }
        } while (!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, zzvlVar, zzvlVar2));
        if (((int) (atomicLong.get() >>> 32)) > i) {
            zzvlVar2.cancel(true);
            MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, zzvlVar2, null);
            return zzvlVar2;
        }
        zzvg zzvgVar = this.zza;
        AsyncCallable zza = zzvgVar.zza();
        if (zza == null || (zzb = zzvgVar.zzb()) == null) {
            zzvlVar2.setFuture(this.zzf);
            return zzvlVar2;
        }
        zzvlVar2.setFuture(Futures.submitAsync(zzxa.zzb(zza), zzb));
        return zzvlVar2;
    }

    private static long zzi(int i, int i2) {
        return (i2 & 4294967295L) | (i << 32);
    }

    public final ListenableFuture zza() {
        AtomicLong atomicLong;
        long j;
        final int i;
        ListenableFuture catchingAsync;
        SettableFuture settableFuture = this.zzf;
        if (settableFuture.isDone()) {
            return settableFuture;
        }
        do {
            atomicLong = this.zzb;
            j = atomicLong.get();
            i = (int) (j >>> 32);
        } while (!atomicLong.compareAndSet(j, zzi(i, ((int) j) + 1)));
        AtomicReference atomicReference = this.zzd;
        final SettableFuture create = SettableFuture.create();
        ListenableFuture listenableFuture = (ListenableFuture) atomicReference.getAndSet(create);
        if (listenableFuture == null) {
            catchingAsync = Futures.submitAsync(zzxa.zzb(new AsyncCallable() { // from class: com.google.android.gms.internal.measurement.zzvi
                @Override // com.google.common.util.concurrent.AsyncCallable
                public final /* synthetic */ ListenableFuture call() {
                    return zzvm.this.zzd(i);
                }
            }), MoreExecutors.directExecutor());
        } else {
            catchingAsync = Futures.catchingAsync(listenableFuture, Throwable.class, zzxa.zzc(new AsyncFunction() { // from class: com.google.android.gms.internal.measurement.zzvh
                @Override // com.google.common.util.concurrent.AsyncFunction
                public final /* synthetic */ ListenableFuture apply(Object obj) {
                    return zzvm.this.zzc(i, (Throwable) obj);
                }
            }), this.zze);
        }
        create.setFuture(catchingAsync);
        final zzvk zzvkVar = new zzvk(this, i, null);
        create.addListener(new Runnable() { // from class: com.google.android.gms.internal.measurement.zzvj
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzvm.this.zzb(create, zzvkVar);
            }
        }, MoreExecutors.directExecutor());
        return zzvkVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(SettableFuture settableFuture, zzvk zzvkVar) {
        try {
            Object done = Futures.getDone(settableFuture);
            SettableFuture settableFuture2 = this.zzf;
            settableFuture2.set(done);
            zzvkVar.setFuture(settableFuture2);
        } catch (Throwable unused) {
            zzvkVar.setFuture(settableFuture);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzc(int i, Throwable th) {
        return zzd(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ boolean zze() {
        AtomicLong atomicLong;
        long j;
        int i;
        int i2;
        boolean z;
        do {
            atomicLong = this.zzb;
            j = atomicLong.get();
            i = (int) j;
            long j2 = j >>> 32;
            if (i == Integer.MIN_VALUE) {
                StringBuilder sb = new StringBuilder(String.valueOf(j).length() + 13);
                sb.append("Refcount is: ");
                sb.append(j);
                throw new AssertionError(sb.toString());
            }
            i2 = (int) j2;
            z = i == -2147483647;
            if (z) {
                i2++;
            }
        } while (!atomicLong.compareAndSet(j, zzi(i2, i - 1)));
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzvg zzf() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ AtomicReference zzg() {
        return this.zzc;
    }
}
