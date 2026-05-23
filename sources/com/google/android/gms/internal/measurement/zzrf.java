package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.FluentFuture;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import java.io.IOException;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzrf {
    private static final Object zza = new Object();
    private static final Object zzb = new Object();
    private final Context zzc;
    private final Supplier zzd;
    private final Supplier zze;
    private final Supplier zzf;
    private final Supplier zzg;
    private final Supplier zzh;
    private final Uri zzi;
    private volatile zzni zzj;
    private final Uri zzk;
    private volatile zznk zzl;

    public zzrf(Context context, final Supplier supplier, Supplier supplier2, Supplier supplier3) {
        this.zzc = context;
        this.zze = supplier;
        this.zzd = supplier3;
        this.zzf = supplier2;
        zzrz zza2 = zzsa.zza(context);
        zza2.zzb("phenotype_storage_info");
        zza2.zzc("storage-info.pb");
        this.zzi = zza2.zzd();
        zzrz zza3 = zzsa.zza(context);
        zza3.zzb("phenotype_storage_info");
        zza3.zzc("device-encrypted-storage-info.pb");
        if (zzky.zza()) {
            zza3.zza();
        }
        this.zzk = zza3.zzd();
        this.zzg = Suppliers.memoize(new Supplier() { // from class: com.google.android.gms.internal.measurement.zzre
            @Override // com.google.common.base.Supplier
            public final /* synthetic */ Object get() {
                return zzrf.this.zzd();
            }
        });
        this.zzh = Suppliers.memoize(new Supplier() { // from class: com.google.android.gms.internal.measurement.zzqy
            @Override // com.google.common.base.Supplier
            public final /* synthetic */ Object get() {
                return ((ListeningScheduledExecutorService) Preconditions.checkNotNull((ListeningScheduledExecutorService) Supplier.this.get())).schedule((Callable) zzrd.zza, 10000L, TimeUnit.MILLISECONDS);
            }
        });
    }

    private final zzni zzg() {
        zzni zzniVar;
        zzni zzniVar2 = this.zzj;
        if (zzniVar2 == null) {
            synchronized (zza) {
                zzniVar = this.zzj;
                if (zzniVar == null) {
                    zzniVar = zzni.zzp();
                    if (zzky.zzc(this.zzc)) {
                        zzss zzb2 = zzss.zzb(zzniVar);
                        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
                        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().build());
                        try {
                            zzni zzniVar3 = (zzni) ((zzru) this.zzf.get()).zza(this.zzi, zzb2);
                            StrictMode.setThreadPolicy(threadPolicy);
                            zzniVar = zzniVar3;
                        } catch (IOException unused) {
                            StrictMode.setThreadPolicy(threadPolicy);
                        } catch (Throwable th) {
                            StrictMode.setThreadPolicy(threadPolicy);
                            throw th;
                        }
                        this.zzj = zzniVar;
                    }
                }
            }
            return zzniVar;
        }
        return zzniVar2;
    }

    public final ListenableFuture zza() {
        if (!zzky.zzb(this.zzc) && zzg().zze() + TimeUnit.HOURS.toMillis(24L) < System.currentTimeMillis()) {
            return FluentFuture.from(Futures.nonCancellationPropagating((ListenableFuture) this.zzh.get())).transformAsync(new AsyncFunction() { // from class: com.google.android.gms.internal.measurement.zzrc
                @Override // com.google.common.util.concurrent.AsyncFunction
                public final /* synthetic */ ListenableFuture apply(Object obj) {
                    return zzrf.this.zzf((Void) obj);
                }
            }, (ListeningScheduledExecutorService) Preconditions.checkNotNull((ListeningScheduledExecutorService) this.zze.get()));
        }
        return Futures.immediateVoidFuture();
    }

    public final boolean zzb(boolean z, zzabz zzabzVar) {
        zzni zzg = zzg();
        return zzg.zzc() && zzg.zzi().contains(zzabzVar);
    }

    public final zzqn zzc(boolean z) {
        String str;
        zzni zzg = zzg();
        boolean zzc = zzg.zzc();
        ImmutableList copyOf = ImmutableList.copyOf((Collection) zzg.zzi());
        zzacr zzb2 = zzg.zzb();
        String zzd = zzg.zzd();
        ImmutableList copyOf2 = ImmutableList.copyOf((Collection) zzg.zzf());
        ImmutableList copyOf3 = ImmutableList.copyOf((Collection) zzg.zzh());
        if (zzg.zzj() && zzg.zzk().zzb() == Build.VERSION.SDK_INT) {
            str = zzg.zzk().zza();
        } else {
            str = "";
        }
        return new zzqn(zzc, copyOf, zzb2, zzd, str, copyOf2, copyOf3, zzg.zza(), zzg.zzm(), zzg.zzl(), zzg.zzn());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzd() {
        ListeningScheduledExecutorService listeningScheduledExecutorService = (ListeningScheduledExecutorService) Preconditions.checkNotNull((ListeningScheduledExecutorService) this.zze.get());
        final FluentFuture transform = FluentFuture.from(((zzmj) Preconditions.checkNotNull((zzmj) this.zzd.get())).zzd()).catching(zzmk.class, zzqz.zza, listeningScheduledExecutorService).transform(new Function() { // from class: com.google.android.gms.internal.measurement.zzra
            @Override // com.google.common.base.Function
            public final /* synthetic */ Object apply(Object obj) {
                zzrf.this.zze((zzno) obj);
                return null;
            }
        }, listeningScheduledExecutorService);
        transform.addListener(new Runnable() { // from class: com.google.android.gms.internal.measurement.zzrb
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                try {
                    Futures.getDone(ListenableFuture.this);
                } catch (Exception e) {
                    if (Log.isLoggable("StorageInfoHandler", 3)) {
                        Log.d("StorageInfoHandler", "Failed to get storage info from GMS", e);
                    }
                }
            }
        }, listeningScheduledExecutorService);
        return transform;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Void zze(zzno zznoVar) {
        zzse zzseVar = new zzse();
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskWrites().build());
        try {
            try {
                synchronized (zza) {
                    Uri uri = this.zzi;
                    zzsv zzb2 = zzsv.zzb(zznoVar.zza());
                    zzb2.zzc(zzseVar);
                    ((zzru) this.zzf.get()).zza(uri, zzb2);
                    this.zzj = zznoVar.zza();
                }
                synchronized (zzb) {
                    Uri uri2 = this.zzk;
                    zzsv zzb3 = zzsv.zzb(zznoVar.zzb());
                    zzb3.zzc(zzseVar);
                    ((zzru) this.zzf.get()).zza(uri2, zzb3);
                    this.zzl = zznoVar.zzb();
                }
                StrictMode.setThreadPolicy(threadPolicy);
                return null;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(threadPolicy);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzf(Void r1) {
        return Futures.nonCancellationPropagating((ListenableFuture) this.zzg.get());
    }
}
