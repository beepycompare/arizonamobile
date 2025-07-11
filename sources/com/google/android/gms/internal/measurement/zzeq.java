package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.5.0 */
/* loaded from: classes3.dex */
abstract class zzeq implements Runnable {
    final long zzh;
    final long zzi;
    final boolean zzj;
    final /* synthetic */ zzfb zzk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeq(zzfb zzfbVar, boolean z) {
        Objects.requireNonNull(zzfbVar);
        this.zzk = zzfbVar;
        this.zzh = zzfbVar.zza.currentTimeMillis();
        this.zzi = zzfbVar.zza.elapsedRealtime();
        this.zzj = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzk.zzP()) {
            zzb();
            return;
        }
        try {
            zza();
        } catch (Exception e) {
            this.zzk.zzN(e, false, this.zzj);
            zzb();
        }
    }

    abstract void zza() throws RemoteException;

    protected void zzb() {
    }
}
