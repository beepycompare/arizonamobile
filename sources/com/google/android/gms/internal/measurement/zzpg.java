package com.google.android.gms.internal.measurement;

import android.os.StrictMode;
import android.util.Log;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzpg {
    public static final /* synthetic */ int zzb = 0;
    private volatile zzqs zzd;
    private final zzlk zze;
    private final String zzf;
    private final String zzg;
    private final boolean zzh;
    private final ImmutableSet zzi;
    private final zzps zzj;
    private final zzqt zzk;
    private static final zzpe zzc = new zzpe(null);
    static final zzon zza = new zzon(zzox.zza, false, false, false, false, ImmutableSet.of());

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzpg(zzlk zzlkVar, zzon zzonVar, String str, byte[] bArr) {
        this.zze = zzlkVar;
        String zza2 = zzonVar.zza(zzlkVar.zzc());
        this.zzf = zza2;
        this.zzg = "";
        this.zzh = zzonVar.zzb();
        this.zzi = zzonVar.zzc();
        this.zzd = null;
        this.zzj = new zzps();
        this.zzk = new zzqt(zzlkVar, zza2, "", false);
    }

    public static zzpe zzd() {
        return zzc;
    }

    private final zzqs zzq() {
        zzqs zzqsVar;
        zzqs zzqsVar2 = this.zzd;
        if (zzqsVar2 == null) {
            synchronized (this) {
                zzqsVar = this.zzd;
                if (zzqsVar == null) {
                    StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
                    zzqs zza2 = this.zzk.zza();
                    StrictMode.setThreadPolicy(allowThreadDiskWrites);
                    if (!zza2.zzk()) {
                        zzlk zzlkVar = this.zze;
                        zzlkVar.zzd().zza();
                        if (this.zzh || this.zzk.zzb() || !zza2.zzd().isEmpty()) {
                            zzlkVar.zzg().execute(new Runnable() { // from class: com.google.android.gms.internal.measurement.zzoy
                                @Override // java.lang.Runnable
                                public final /* synthetic */ void run() {
                                    zzpg.this.zzf();
                                }
                            });
                            zzlkVar.zzk().zza(zza2.zze(), this.zzi, this.zzf);
                            if (!this.zzg.equals("")) {
                                zzlkVar.zzg().execute(new Runnable() { // from class: com.google.android.gms.internal.measurement.zzoq
                                    @Override // java.lang.Runnable
                                    public final /* synthetic */ void run() {
                                        zzpg.this.zzh();
                                    }
                                });
                            }
                            if (this.zzk.zzb()) {
                                zzlkVar.zzg().execute(new Runnable() { // from class: com.google.android.gms.internal.measurement.zzor
                                    @Override // java.lang.Runnable
                                    public final /* synthetic */ void run() {
                                        zzpg.this.zzi();
                                    }
                                });
                            }
                        } else {
                            zzlkVar.zzg().execute(new Runnable() { // from class: com.google.android.gms.internal.measurement.zzop
                                @Override // java.lang.Runnable
                                public final /* synthetic */ void run() {
                                    zzpg.this.zzg();
                                }
                            });
                            zzqsVar = zzqs.zzb(zzqv.zzi(), zza2);
                            if (this.zzh || !zzqsVar.zzj()) {
                                this.zzd = zzqsVar;
                            }
                        }
                    }
                    zzqsVar = zza2;
                    if (this.zzh) {
                    }
                    this.zzd = zzqsVar;
                }
            }
            return zzqsVar;
        }
        return zzqsVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzr */
    public final void zzg() {
        final zzqt zzqtVar = this.zzk;
        final ListenableFuture zzd = zzqtVar.zzd(this.zzg);
        Objects.requireNonNull(zzqtVar);
        AsyncFunction asyncFunction = new AsyncFunction() { // from class: com.google.android.gms.internal.measurement.zzpf
            @Override // com.google.common.util.concurrent.AsyncFunction
            public final /* synthetic */ ListenableFuture apply(Object obj) {
                return zzqt.this.zzc((zzqv) obj);
            }
        };
        zzlk zzlkVar = this.zze;
        Futures.transformAsync(zzd, asyncFunction, zzlkVar.zzg()).addListener(new Runnable() { // from class: com.google.android.gms.internal.measurement.zzov
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzpg.this.zzm(zzd);
            }
        }, zzlkVar.zzg());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004b A[Catch: CancellationException | ExecutionException -> 0x006b, ExecutionException -> 0x006d, TRY_LEAVE, TryCatch #3 {CancellationException | ExecutionException -> 0x006b, blocks: (B:2:0x0000, B:4:0x0018, B:12:0x0025, B:14:0x0033, B:16:0x003b, B:20:0x0047, B:22:0x004b, B:6:0x001c, B:8:0x001f, B:11:0x0024, B:18:0x003f, B:19:0x0046), top: B:34:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* renamed from: zzs */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ void zzm(ListenableFuture listenableFuture) {
        zzqs zzqsVar;
        try {
            zzqv zzqvVar = (zzqv) Futures.getDone(listenableFuture);
            zzqs zza2 = zzqs.zza(zzqvVar, new zzqr(6, 2));
            boolean z = this.zzh;
            Preconditions.checkNotNull(zza2);
            if (z || (zzqsVar = this.zzd) == null) {
                synchronized (this) {
                    if (!z && (zzqsVar = this.zzd) != null) {
                    }
                    this.zzd = zza2;
                    this.zzj.zzb();
                }
                if (this.zzh) {
                    return;
                }
                zzlk zzlkVar = this.zze;
                Futures.catching(zzlkVar.zzh().zzb(zzqvVar.zza()), Throwable.class, new Function() { // from class: com.google.android.gms.internal.measurement.zzow
                    @Override // com.google.common.base.Function
                    public final /* synthetic */ Object apply(Object obj) {
                        zzpg.this.zzn((Throwable) obj);
                        return null;
                    }
                }, zzlkVar.zzg());
                return;
            }
            if (!zzqsVar.zzf().equals(zza2.zzf())) {
                zzqm zzj = this.zze.zzj();
                if (zzj != null) {
                    zzj.zza();
                    return;
                }
                return;
            }
            if (this.zzh) {
            }
        } catch (CancellationException | ExecutionException e) {
            if (e.getCause() instanceof SecurityException) {
                return;
            }
            String str = this.zzf;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 64);
            sb.append("Unable to update local snapshot for ");
            sb.append(str);
            sb.append(", may result in stale flags.");
            Log.w("FlagStore", sb.toString(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object zza(String str, boolean z) {
        return zzq().zzf().get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzb() {
        return this.zzf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzps zzc() {
        return this.zzj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzf() {
        ListenableFuture zzb2;
        zzqs zzq = zzq();
        String zzd = zzq.zzd();
        zzlk zzlkVar = this.zze;
        zzqn zzc2 = zzlkVar.zzd().zzc(false);
        if (zzc2.zze()) {
            if (Strings.isNullOrEmpty(zzd) && !zzc2.zzd()) {
                return Futures.immediateVoidFuture();
            }
            zzmb zzb3 = zzme.zzb();
            zzb3.zzb(zzq.zzi());
            if (!Strings.isNullOrEmpty(zzd)) {
                zzb3.zza(zzd);
            }
            if (zzc2.zzd()) {
                zzb3.zzc(this.zzf);
            }
            zzb2 = zzlkVar.zzh().zzc((zzme) zzb3.zzbd());
        } else if (Strings.isNullOrEmpty(zzd)) {
            return Futures.immediateVoidFuture();
        } else {
            zzb2 = zzlkVar.zzh().zzb(zzd);
        }
        return Futures.catchingAsync(zzb2, zzmk.class, new AsyncFunction() { // from class: com.google.android.gms.internal.measurement.zzos
            @Override // com.google.common.util.concurrent.AsyncFunction
            public final /* synthetic */ ListenableFuture apply(Object obj) {
                return zzpg.this.zzj((zzmk) obj);
            }
        }, zzlkVar.zzg());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzh() {
        zzlk zzlkVar = this.zze;
        final ListenableFuture zza2 = zzpu.zza(zzlkVar, this.zzf, this.zzg);
        zza2.addListener(new Runnable() { // from class: com.google.android.gms.internal.measurement.zzot
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzpg.this.zzk(zza2);
            }
        }, zzlkVar.zzg());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzi() {
        this.zze.zzf().zza(zzabz.FILE, this.zzh, zzou.zza);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzj(zzmk zzmkVar) {
        int zza2 = zzmkVar.zza();
        if ((zza2 == 29501 || zza2 == 29537 || zza2 == 29538 || zza2 == 29539 || zza2 == 29540 || zza2 == 29541 || zza2 == 29542 || zza2 == 29543 || zza2 == 29544) && !this.zzk.zzb()) {
            zzg();
        }
        return Futures.immediateVoidFuture();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzk(ListenableFuture listenableFuture) {
        try {
            Futures.getDone(listenableFuture);
        } catch (Exception e) {
            String str = this.zzf;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 73);
            sb.append("Failed to store account on flag read for: ");
            sb.append(str);
            sb.append(" which may lead to stale flags.");
            Log.w("FlagStore", sb.toString(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Void zzn(Throwable th) {
        String str = this.zzf;
        String.valueOf(str);
        Log.w("FlagStore", "Failed to commit to updated flags for ".concat(String.valueOf(str)), th);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ boolean zzo() {
        if (this.zzh) {
            zzqs zzqsVar = this.zzd;
            if (zzqsVar != null) {
                if (zzqsVar.zzh() || zzqsVar.zzg() || this.zzk.zzb()) {
                    synchronized (this) {
                        zzqs zzqsVar2 = this.zzd;
                        if (zzqsVar2 != null && (zzqsVar2.zzh() || zzqsVar2.zzg() || this.zzk.zzb())) {
                            this.zzd = null;
                            this.zzj.zzb();
                        }
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return true;
    }

    final /* synthetic */ String zzp() {
        return this.zzf;
    }
}
