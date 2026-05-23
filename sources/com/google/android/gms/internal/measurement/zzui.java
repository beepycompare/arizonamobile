package com.google.android.gms.internal.measurement;

import android.net.Uri;
import com.google.common.base.Optional;
import com.google.common.util.concurrent.AsyncCallable;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.ExecutionSequencer;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzui implements zzuv {
    private final String zza;
    private final ListenableFuture zzb;
    private final zztv zzc;
    private final Executor zzd;
    private final zzru zze;
    private final Optional zzf;
    private final zzwb zzg;
    private final Object zzh = new Object();
    private final ExecutionSequencer zzi = ExecutionSequencer.create();
    private ListenableFuture zzj = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzui(String str, ListenableFuture listenableFuture, zztv zztvVar, Executor executor, zzru zzruVar, Optional optional, zzwb zzwbVar) {
        this.zza = str;
        this.zzb = Futures.nonCancellationPropagating(listenableFuture);
        this.zzc = zztvVar;
        this.zzd = MoreExecutors.newSequentialExecutor(executor);
        this.zze = zzruVar;
        this.zzf = optional;
        this.zzg = zzwbVar;
    }

    public static zzuw zza() {
        return zztx.zzc();
    }

    private final Object zzm(Uri uri) throws IOException {
        try {
            try {
                zzwb zzwbVar = this.zzg;
                String str = this.zza;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 5);
                sb.append("Read ");
                sb.append(str);
                zzwi zza = zzwbVar.zza(sb.toString(), zzxd.I_HAVE_PERMISSION_TO_USE_RESTRICTED_APIS);
                try {
                    InputStream inputStream = (InputStream) this.zze.zza(uri, zzst.zzb());
                    zztv zztvVar = this.zzc;
                    zzafc zzafcVar = (zzafc) ((zzve) zztvVar).zzb().zzcj().zza(inputStream, ((zzve) zztvVar).zzc());
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    zza.close();
                    return zzafcVar;
                } catch (Throwable th) {
                    try {
                        zza.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException e) {
                throw zzux.zza(this.zze, uri, e, this.zza);
            }
        } catch (FileNotFoundException e2) {
            if (!this.zze.zzc(uri)) {
                return this.zzc.zza();
            }
            throw e2;
        }
    }

    private final void zzn(Uri uri, Object obj) throws IOException {
        Uri zza = zzuz.zza(uri, ".tmp");
        try {
            zzwb zzwbVar = this.zzg;
            String str = this.zza;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 6);
            sb.append("Write ");
            sb.append(str);
            zzwi zza2 = zzwbVar.zza(sb.toString(), zzxd.I_HAVE_PERMISSION_TO_USE_RESTRICTED_APIS);
            zzse zzseVar = new zzse();
            try {
                zzru zzruVar = this.zze;
                zzsw zzb = zzsw.zzb();
                zzb.zzc(zzseVar);
                OutputStream outputStream = (OutputStream) zzruVar.zza(zza, zzb);
                try {
                    ((zzafc) obj).zzce(outputStream);
                    zzseVar.zzc();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    zza2.close();
                    this.zze.zzd(zza, uri);
                } catch (Throwable th) {
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (IOException e) {
                throw zzux.zza(this.zze, uri, e, this.zza);
            }
        } catch (IOException e2) {
            zzru zzruVar2 = this.zze;
            if (zzruVar2.zzc(zza)) {
                try {
                    zzruVar2.zzb(zza);
                } catch (IOException e3) {
                    e2.addSuppressed(e3);
                }
            }
            throw e2;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzuv
    public final ListenableFuture zzb(final AsyncFunction asyncFunction, final Executor executor, zzuu zzuuVar) {
        final ListenableFuture listenableFuture;
        synchronized (this.zzh) {
            ListenableFuture listenableFuture2 = this.zzj;
            if (listenableFuture2 != null && listenableFuture2.isDone()) {
                try {
                    Futures.getDone(this.zzj);
                } catch (ExecutionException unused) {
                    this.zzj = null;
                }
            }
            if (this.zzj == null) {
                this.zzj = Futures.nonCancellationPropagating(this.zzi.submitAsync(zzxa.zzb(new AsyncCallable() { // from class: com.google.android.gms.internal.measurement.zzub
                    @Override // com.google.common.util.concurrent.AsyncCallable
                    public final /* synthetic */ ListenableFuture call() {
                        return zzui.this.zzf();
                    }
                }), this.zzd));
            }
            listenableFuture = this.zzj;
        }
        return this.zzi.submitAsync(zzxa.zzb(new AsyncCallable() { // from class: com.google.android.gms.internal.measurement.zztz
            @Override // com.google.common.util.concurrent.AsyncCallable
            public final /* synthetic */ ListenableFuture call() {
                final zzui zzuiVar = zzui.this;
                final ListenableFuture transformAsync = Futures.transformAsync(listenableFuture, new AsyncFunction() { // from class: com.google.android.gms.internal.measurement.zzua
                    @Override // com.google.common.util.concurrent.AsyncFunction
                    public final /* synthetic */ ListenableFuture apply(Object obj) {
                        return zzui.this.zze(obj);
                    }
                }, MoreExecutors.directExecutor());
                final ListenableFuture transformAsync2 = Futures.transformAsync(transformAsync, asyncFunction, executor);
                return Futures.transformAsync(transformAsync2, zzxa.zzc(new AsyncFunction() { // from class: com.google.android.gms.internal.measurement.zzuc
                    @Override // com.google.common.util.concurrent.AsyncFunction
                    public final /* synthetic */ ListenableFuture apply(Object obj) {
                        return zzui.this.zzg(transformAsync, transformAsync2, obj);
                    }
                }), MoreExecutors.directExecutor());
            }
        }), MoreExecutors.directExecutor());
    }

    @Override // com.google.android.gms.internal.measurement.zzuv
    public final String zzc() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzd() {
        return Futures.nonCancellationPropagating(Futures.transformAsync(this.zzb, zzxa.zzc(new AsyncFunction() { // from class: com.google.android.gms.internal.measurement.zzug
            @Override // com.google.common.util.concurrent.AsyncFunction
            public final /* synthetic */ ListenableFuture apply(Object obj) {
                return zzui.this.zzk((Uri) obj);
            }
        }), this.zzd));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zze(Object obj) {
        ListenableFuture listenableFuture;
        synchronized (this.zzh) {
            listenableFuture = this.zzj;
        }
        return listenableFuture;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzf() {
        try {
            return Futures.immediateFuture(zzm((Uri) Futures.getDone(this.zzb)));
        } catch (IOException e) {
            zzty zztyVar = new zzty(this, null);
            Optional optional = this.zzf;
            if (!optional.isPresent()) {
                return Futures.immediateFailedFuture(e);
            }
            if (!(e instanceof zzsg) && !(e.getCause() instanceof zzsg)) {
                return Futures.transformAsync(((zztf) optional.get()).zza(e, zztyVar), zzxa.zzc(new AsyncFunction() { // from class: com.google.android.gms.internal.measurement.zzue
                    @Override // com.google.common.util.concurrent.AsyncFunction
                    public final /* synthetic */ ListenableFuture apply(Object obj) {
                        return zzui.this.zzi((Void) obj);
                    }
                }), this.zzd);
            }
            return Futures.immediateFailedFuture(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzg(ListenableFuture listenableFuture, final ListenableFuture listenableFuture2, Object obj) {
        if (!Futures.getDone(listenableFuture).equals(Futures.getDone(listenableFuture2))) {
            ListenableFuture transformAsync = Futures.transformAsync(listenableFuture2, zzxa.zzc(new AsyncFunction() { // from class: com.google.android.gms.internal.measurement.zzud
                @Override // com.google.common.util.concurrent.AsyncFunction
                public final /* synthetic */ ListenableFuture apply(Object obj2) {
                    return zzui.this.zzh(listenableFuture2, obj2);
                }
            }), this.zzd);
            synchronized (this.zzh) {
            }
            return transformAsync;
        }
        return Futures.immediateFuture(obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzh(ListenableFuture listenableFuture, Object obj) {
        zzn((Uri) Futures.getDone(this.zzb), obj);
        synchronized (this.zzh) {
            this.zzj = listenableFuture;
        }
        return Futures.immediateFuture(obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzi(Void r1) {
        return Futures.immediateFuture(zzm((Uri) Futures.getDone(this.zzb)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzj(Object obj) {
        zzn((Uri) Futures.getDone(this.zzb), obj);
        return Futures.immediateVoidFuture();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzk(Uri uri) {
        Uri zza = zzuz.zza(uri, ".bak");
        try {
            zzru zzruVar = this.zze;
            if (zzruVar.zzc(zza)) {
                zzruVar.zzd(zza, uri);
            }
            return Futures.immediateVoidFuture();
        } catch (IOException e) {
            return Futures.immediateFailedFuture(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzl(ListenableFuture listenableFuture) {
        return Futures.transformAsync(listenableFuture, zzxa.zzc(new AsyncFunction() { // from class: com.google.android.gms.internal.measurement.zzuf
            @Override // com.google.common.util.concurrent.AsyncFunction
            public final /* synthetic */ ListenableFuture apply(Object obj) {
                return zzui.this.zzj(obj);
            }
        }), this.zzd);
    }
}
