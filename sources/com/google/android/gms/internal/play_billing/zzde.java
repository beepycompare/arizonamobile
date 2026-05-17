package com.google.android.gms.internal.play_billing;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes4.dex */
public final class zzde implements Runnable {
    zzdh zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzde(zzdh zzdhVar) {
        this.zza = zzdhVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0008, code lost:
        r2 = r1.zzd;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        zzdc zzdcVar;
        ScheduledFuture scheduledFuture;
        zzdh zzdhVar = this.zza;
        if (zzdhVar == null || zzdcVar == null) {
            return;
        }
        this.zza = null;
        if (zzdcVar.isDone()) {
            zzdhVar.zzj(zzdcVar);
            return;
        }
        try {
            scheduledFuture = zzdhVar.zze;
            zzdhVar.zze = null;
            String str = "Timed out";
            if (scheduledFuture != null) {
                long abs = Math.abs(scheduledFuture.getDelay(TimeUnit.MILLISECONDS));
                if (abs > 10) {
                    str = "Timed out (timeout delayed by " + abs + " ms after scheduled time)";
                }
            }
            zzdhVar.zzi(new zzdf(str + ": " + zzdcVar.toString(), null));
        } finally {
            zzdcVar.cancel(true);
        }
    }
}
