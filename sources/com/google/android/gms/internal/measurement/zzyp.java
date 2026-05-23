package com.google.android.gms.internal.measurement;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
final class zzyp {
    private static final zzyf zza = new zzyo();
    private final AtomicBoolean zzb = new AtomicBoolean();
    private final AtomicInteger zzc = new AtomicInteger();

    private zzyp() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(zzyq zzyqVar, zzyd zzydVar, zzzj zzzjVar) {
        zzyp zzypVar = (zzyp) zza.zzb(zzydVar, zzzjVar);
        int incrementAndGet = zzypVar.zzc.incrementAndGet();
        if (zzyqVar == zzyq.zzc || !zzypVar.zzb.compareAndSet(false, true)) {
            return -1;
        }
        try {
            zzyqVar.zzb();
            zzypVar.zzb.set(false);
            zzypVar.zzc.addAndGet(-incrementAndGet);
            return incrementAndGet - 1;
        } catch (Throwable th) {
            zzypVar.zzb.set(false);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzyp(byte[] bArr) {
    }
}
