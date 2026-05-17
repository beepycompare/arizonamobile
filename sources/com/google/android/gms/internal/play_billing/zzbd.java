package com.google.android.gms.internal.play_billing;

import android.os.SystemClock;
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes4.dex */
public final class zzbd {
    private static final zzbo zza;

    static {
        zzbo zzbcVar;
        try {
            SystemClock.elapsedRealtimeNanos();
            zzbcVar = new zzbb();
        } catch (Throwable unused) {
            SystemClock.elapsedRealtime();
            zzbcVar = new zzbc();
        }
        zza = zzbcVar;
    }

    public static zzbo zza() {
        return zza;
    }
}
