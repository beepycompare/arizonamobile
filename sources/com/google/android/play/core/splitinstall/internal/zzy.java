package com.google.android.play.core.splitinstall.internal;

import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.atomic.AtomicInteger;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
/* loaded from: classes4.dex */
public final class zzy extends zzv {
    final /* synthetic */ TaskCompletionSource zza;
    final /* synthetic */ zzv zzb;
    final /* synthetic */ zzaf zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzy(zzaf zzafVar, TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2, zzv zzvVar) {
        super(taskCompletionSource);
        this.zzc = zzafVar;
        this.zza = taskCompletionSource2;
        this.zzb = zzvVar;
    }

    @Override // com.google.android.play.core.splitinstall.internal.zzv
    public final void zzc() {
        Object obj;
        AtomicInteger atomicInteger;
        zzu zzuVar;
        obj = this.zzc.zzg;
        synchronized (obj) {
            zzaf.zzn(this.zzc, this.zza);
            atomicInteger = this.zzc.zzl;
            if (atomicInteger.getAndIncrement() > 0) {
                zzuVar = this.zzc.zzc;
                zzuVar.zzd("Already connected to the service.", new Object[0]);
            }
            zzaf.zzp(this.zzc, this.zzb);
        }
    }
}
