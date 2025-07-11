package com.google.android.gms.internal.measurement;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.5.0 */
/* loaded from: classes3.dex */
public final class zznt {
    public static final /* synthetic */ int zza = 0;
    private static final zznt zzb = new zznt();
    private final ConcurrentMap zzd = new ConcurrentHashMap();
    private final zznx zzc = new zznc();

    private zznt() {
    }

    public static zznt zza() {
        return zzb;
    }

    public final zznw zzb(Class cls) {
        zzmo.zza(cls, "messageType");
        ConcurrentMap concurrentMap = this.zzd;
        zznw zznwVar = (zznw) concurrentMap.get(cls);
        if (zznwVar == null) {
            zznwVar = this.zzc.zza(cls);
            zzmo.zza(cls, "messageType");
            zznw zznwVar2 = (zznw) concurrentMap.putIfAbsent(cls, zznwVar);
            if (zznwVar2 != null) {
                return zznwVar2;
            }
        }
        return zznwVar;
    }
}
