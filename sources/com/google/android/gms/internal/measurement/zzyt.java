package com.google.android.gms.internal.measurement;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
final class zzyt extends zzyq {
    private static final zzyf zzb = new zzyr();
    private static final ThreadLocal zze = new zzys();
    final AtomicInteger zza = new AtomicInteger();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzyq zza(zzzj zzzjVar, zzyd zzydVar) {
        int i;
        Integer num = (Integer) zzzjVar.zzd(zzxx.zzc);
        if (num == null || num.intValue() <= 0) {
            return null;
        }
        zzyt zzytVar = (zzyt) zzb.zzb(zzydVar, zzzjVar);
        if (((Random) zze.get()).nextInt(num.intValue()) == 0) {
            i = zzytVar.zza.incrementAndGet();
        } else {
            i = zzytVar.zza.get();
        }
        return i > 0 ? zzytVar : zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzyq
    public final void zzb() {
        this.zza.decrementAndGet();
    }
}
