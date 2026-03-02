package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-tasks@@18.4.0 */
/* loaded from: classes4.dex */
final class zzk implements Runnable {
    final /* synthetic */ Task zza;
    final /* synthetic */ zzl zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzk(zzl zzlVar, Task task) {
        this.zza = task;
        Objects.requireNonNull(zzlVar);
        this.zzb = zzlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzl zzlVar = this.zzb;
        synchronized (zzlVar.zzc()) {
            if (zzlVar.zzd() != null) {
                zzlVar.zzd().onFailure((Exception) Preconditions.checkNotNull(this.zza.getException()));
            }
        }
    }
}
