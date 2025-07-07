package com.google.android.play.core.splitinstall.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.IInterface;
import java.util.concurrent.atomic.AtomicInteger;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
/* loaded from: classes4.dex */
public final class zzz extends zzv {
    final /* synthetic */ zzaf zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzz(zzaf zzafVar) {
        this.zza = zzafVar;
    }

    @Override // com.google.android.play.core.splitinstall.internal.zzv
    public final void zzc() {
        Object obj;
        AtomicInteger atomicInteger;
        IInterface iInterface;
        zzu zzuVar;
        Context context;
        ServiceConnection serviceConnection;
        AtomicInteger atomicInteger2;
        zzu zzuVar2;
        obj = this.zza.zzg;
        synchronized (obj) {
            atomicInteger = this.zza.zzl;
            if (atomicInteger.get() > 0) {
                atomicInteger2 = this.zza.zzl;
                if (atomicInteger2.decrementAndGet() > 0) {
                    zzuVar2 = this.zza.zzc;
                    zzuVar2.zzd("Leaving the connection open for other ongoing calls.", new Object[0]);
                    return;
                }
            }
            zzaf zzafVar = this.zza;
            iInterface = zzafVar.zzn;
            if (iInterface != null) {
                zzuVar = zzafVar.zzc;
                zzuVar.zzd("Unbind from service.", new Object[0]);
                zzaf zzafVar2 = this.zza;
                context = zzafVar2.zzb;
                serviceConnection = zzafVar2.zzm;
                context.unbindService(serviceConnection);
                this.zza.zzh = false;
                this.zza.zzn = null;
                this.zza.zzm = null;
            }
            this.zza.zzw();
        }
    }
}
