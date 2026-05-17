package com.google.android.gms.internal.play_billing;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes4.dex */
final class zzcw implements Runnable {
    final Future zza;
    final zzcv zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcw(Future future, zzcv zzcvVar) {
        this.zza = future;
        this.zzb = zzcvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        Throwable zza;
        Future future = this.zza;
        if (!(future instanceof zzdi) || (zza = zzdj.zza((zzdi) future)) == null) {
            try {
                if (future.isDone()) {
                    boolean z = false;
                    while (true) {
                        try {
                            obj = future.get();
                            break;
                        } catch (InterruptedException unused) {
                            z = true;
                        } catch (Throwable th) {
                            if (z) {
                                Thread.currentThread().interrupt();
                            }
                            throw th;
                        }
                    }
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                    this.zzb.zzb(obj);
                    return;
                }
                throw new IllegalStateException(zzbm.zzb("Future was expected to be done: %s", future));
            } catch (ExecutionException e) {
                this.zzb.zza(e.getCause());
                return;
            } catch (Throwable th2) {
                this.zzb.zza(th2);
                return;
            }
        }
        this.zzb.zza(zza);
    }

    public final String toString() {
        zzbf zza = zzbh.zza(this);
        zza.zza(this.zzb);
        return zza.toString();
    }
}
