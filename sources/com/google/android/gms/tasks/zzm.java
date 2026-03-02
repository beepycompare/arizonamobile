package com.google.android.gms.tasks;

import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-tasks@@18.4.0 */
/* loaded from: classes4.dex */
final class zzm implements Runnable {
    final /* synthetic */ Task zza;
    final /* synthetic */ zzn zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzm(zzn zznVar, Task task) {
        this.zza = task;
        Objects.requireNonNull(zznVar);
        this.zzb = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzn zznVar = this.zzb;
        synchronized (zznVar.zzc()) {
            if (zznVar.zzd() != null) {
                zznVar.zzd().onSuccess(this.zza.getResult());
            }
        }
    }
}
