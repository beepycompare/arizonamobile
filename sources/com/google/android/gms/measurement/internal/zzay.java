package com.google.android.gms.measurement.internal;

import android.os.Handler;
import com.google.android.gms.common.internal.Preconditions;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public abstract class zzay {
    private static volatile Handler zzb;
    private final zzjf zza;
    private final Runnable zzc;
    private volatile long zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzay(zzjf zzjfVar) {
        Preconditions.checkNotNull(zzjfVar);
        this.zza = zzjfVar;
        this.zzc = new zzax(this, zzjfVar);
    }

    private final Handler zzf() {
        Handler handler;
        if (zzb != null) {
            return zzb;
        }
        synchronized (zzay.class) {
            if (zzb == null) {
                zzb = new com.google.android.gms.internal.measurement.zzcn(this.zza.zzaY().getMainLooper());
            }
            handler = zzb;
        }
        return handler;
    }

    public abstract void zza();

    public final void zzb(long j) {
        zzd();
        if (j >= 0) {
            zzjf zzjfVar = this.zza;
            this.zzd = zzjfVar.zzaZ().currentTimeMillis();
            if (zzf().postDelayed(this.zzc, j)) {
                return;
            }
            zzjfVar.zzaV().zzb().zzb("Failed to schedule delayed post. time", Long.valueOf(j));
        }
    }

    public final boolean zzc() {
        return this.zzd != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzd() {
        this.zzd = 0L;
        zzf().removeCallbacks(this.zzc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zze(long j) {
        this.zzd = 0L;
    }
}
