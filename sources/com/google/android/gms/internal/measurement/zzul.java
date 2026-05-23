package com.google.android.gms.internal.measurement;

import com.google.common.util.concurrent.AsyncCallable;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzul implements AsyncCallable {
    final /* synthetic */ zzut zza;
    private List zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzul(zzut zzutVar, byte[] bArr) {
        Objects.requireNonNull(zzutVar);
        this.zza = zzutVar;
    }

    @Override // com.google.common.util.concurrent.AsyncCallable
    public final ListenableFuture call() throws Exception {
        zzut zzutVar = this.zza;
        String zze = zzutVar.zze();
        String.valueOf(zze);
        zzwi zza = zzutVar.zzi().zza("Initialize ".concat(String.valueOf(zze)), zzxd.I_HAVE_PERMISSION_TO_USE_RESTRICTED_APIS);
        try {
            synchronized (zzutVar.zzh()) {
                if (this.zzb == null) {
                    this.zzb = zzutVar.zzj();
                    zzutVar.zzk(Collections.emptyList());
                }
            }
            ArrayList arrayList = new ArrayList(this.zzb.size());
            zzus zzusVar = new zzus(this.zza, null);
            for (AsyncFunction asyncFunction : this.zzb) {
                try {
                    arrayList.add(asyncFunction.apply(zzusVar));
                } catch (Exception e) {
                    arrayList.add(Futures.immediateFailedFuture(e));
                }
            }
            ListenableFuture call = Futures.whenAllSucceed(arrayList).call(new Callable() { // from class: com.google.android.gms.internal.measurement.zzuk
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Object call() {
                    zzul.this.zza();
                    return null;
                }
            }, MoreExecutors.directExecutor());
            zza.zza(call);
            zza.close();
            return call;
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
    public final /* synthetic */ Object zza() {
        synchronized (this.zza.zzh()) {
            this.zzb = null;
        }
        return null;
    }
}
