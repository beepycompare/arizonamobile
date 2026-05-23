package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzld {
    private static final ConcurrentMap zza = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza() {
        Iterator it = zza.values().iterator();
        if (it.hasNext()) {
            zzld zzldVar = (zzld) it.next();
            throw null;
        }
    }
}
