package com.google.android.gms.tasks;
/* compiled from: com.google.android.gms:play-services-tasks@@18.1.0 */
/* loaded from: classes3.dex */
final class zzg implements Runnable {
    final /* synthetic */ zzh zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzg(zzh zzhVar) {
        this.zza = zzhVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        OnCanceledListener onCanceledListener;
        OnCanceledListener onCanceledListener2;
        obj = this.zza.zzb;
        synchronized (obj) {
            zzh zzhVar = this.zza;
            onCanceledListener = zzhVar.zzc;
            if (onCanceledListener != null) {
                onCanceledListener2 = zzhVar.zzc;
                onCanceledListener2.onCanceled();
            }
        }
    }
}
