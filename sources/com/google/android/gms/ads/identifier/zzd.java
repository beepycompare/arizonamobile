package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.TelemetryLogging;
import com.google.android.gms.common.internal.TelemetryLoggingClient;
import com.google.android.gms.common.internal.TelemetryLoggingOptions;
import com.google.android.gms.tasks.OnFailureListener;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;
/* compiled from: com.google.android.gms:play-services-ads-identifier@@18.3.0 */
/* loaded from: classes4.dex */
public final class zzd {
    private static volatile zzd zza;
    private static final Object zzc = new Object();
    private final TelemetryLoggingClient zzb;
    private final AtomicLong zzd = new AtomicLong(-1);

    private zzd(Context context, String str) {
        this.zzb = TelemetryLogging.getClient(context, TelemetryLoggingOptions.builder().setApi("ads_identifier:api").build());
    }

    public static zzd zza(Context context) {
        if (zza == null) {
            synchronized (zzc) {
                if (zza == null) {
                    zza = new zzd(context, "ads_identifier:api");
                }
            }
        }
        return zza;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0043, code lost:
        if ((r2 - r0.get()) > 1800000) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void zzb(int i, int i2, long j, long j2, int i3) {
        AtomicLong atomicLong = this.zzd;
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        long j3 = atomicLong.get();
        StringBuilder sb = new StringBuilder(String.valueOf(j3).length() + 14);
        sb.append("shouldSendLog ");
        sb.append(j3);
        Log.i("AdvertisingIdClient", sb.toString());
        if (atomicLong.get() != -1) {
        }
        TelemetryLoggingClient telemetryLoggingClient = this.zzb;
        if (telemetryLoggingClient == null) {
            return;
        }
        telemetryLoggingClient.log(new TelemetryData(0, Arrays.asList(new MethodInvocation(35401, i2, 0, j, j2, null, null, 0, i3)))).addOnFailureListener(new OnFailureListener() { // from class: com.google.android.gms.ads.identifier.zzc
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final /* synthetic */ void onFailure(Exception exc) {
                zzd.this.zzc(elapsedRealtime, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(long j, Exception exc) {
        ConnectionResult connectionResult;
        String message = exc.getMessage();
        String.valueOf(message);
        Log.i("AdvertisingIdClient", "getting error as ".concat(String.valueOf(message)));
        if ((exc instanceof ApiException) && (connectionResult = ((ApiException) exc).getStatus().getConnectionResult()) != null && connectionResult.getErrorCode() == 24) {
            this.zzd.set(j);
        }
    }
}
