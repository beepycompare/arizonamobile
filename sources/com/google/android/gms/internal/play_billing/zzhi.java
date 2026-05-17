package com.google.android.gms.internal.play_billing;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes4.dex */
public final class zzhi {
    private static final zzhi zza = new zzhi();
    private final ConcurrentMap zzc = new ConcurrentHashMap();
    private final zzhm zzb = new zzgs();

    private zzhi() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzhi zza() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzhl zzb(Class cls) {
        byte[] bArr = zzga.zzb;
        if (cls != null) {
            ConcurrentMap concurrentMap = this.zzc;
            zzhl zzhlVar = (zzhl) concurrentMap.get(cls);
            if (zzhlVar == null) {
                zzhl zza2 = this.zzb.zza(cls);
                zzhl zzhlVar2 = (zzhl) concurrentMap.putIfAbsent(cls, zza2);
                return zzhlVar2 != null ? zzhlVar2 : zza2;
            }
            return zzhlVar;
        }
        throw new NullPointerException("messageType");
    }
}
