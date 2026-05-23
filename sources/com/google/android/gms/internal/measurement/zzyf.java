package com.google.android.gms.internal.measurement;

import java.util.concurrent.ConcurrentHashMap;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public abstract class zzyf {
    private final ConcurrentHashMap zza = new ConcurrentHashMap();

    protected abstract Object zza();

    public final Object zzb(zzyd zzydVar, zzzj zzzjVar) {
        ConcurrentHashMap concurrentHashMap = this.zza;
        Object obj = concurrentHashMap.get(zzydVar);
        if (obj != null) {
            return obj;
        }
        Object zza = zza();
        Object putIfAbsent = concurrentHashMap.putIfAbsent(zzydVar, zza);
        if (putIfAbsent == null) {
            int zza2 = zzzjVar.zza();
            zzye zzyeVar = null;
            for (int i = 0; i < zza2; i++) {
                if (zzxx.zzf.equals(zzzjVar.zzb(i))) {
                    Object zzc = zzzjVar.zzc(i);
                    if (zzc instanceof zzyj) {
                        if (zzyeVar == null) {
                            zzyeVar = new zzye(this, zzydVar);
                        }
                        ((zzyj) zzc).zza();
                    }
                }
            }
            return zza;
        }
        return putIfAbsent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ ConcurrentHashMap zzc() {
        return this.zza;
    }
}
