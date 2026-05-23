package com.google.android.gms.internal.measurement;

import java.util.concurrent.ConcurrentHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzafl {
    private static final zzafl zza = new zzafl();
    private final ConcurrentHashMap zzc = new ConcurrentHashMap();
    private final zzaet zzb = new zzaet();

    private zzafl() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzafl zza() {
        return zza;
    }

    private <T> zzafp<T> zzc(Class<T> cls) {
        ConcurrentHashMap concurrentHashMap = this.zzc;
        zzafp<T> zza2 = this.zzb.zza(cls);
        zzafp<T> zzafpVar = (zzafp) concurrentHashMap.putIfAbsent(cls, zza2);
        return zzafpVar != null ? zzafpVar : zza2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzafp zzb(Class cls) {
        Object obj = this.zzc.get(cls);
        if (obj == null) {
            return zzc(cls);
        }
        return (zzafp) obj;
    }
}
