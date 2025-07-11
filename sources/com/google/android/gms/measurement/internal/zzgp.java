package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.TelemetryLogging;
import com.google.android.gms.common.internal.TelemetryLoggingClient;
import com.google.android.gms.common.internal.TelemetryLoggingOptions;
import com.google.android.gms.tasks.OnFailureListener;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzgp {
    private static zzgp zza;
    private final zzib zzb;
    private final TelemetryLoggingClient zzc;
    private final AtomicLong zzd = new AtomicLong(-1);

    private zzgp(Context context, zzib zzibVar) {
        this.zzc = TelemetryLogging.getClient(context, TelemetryLoggingOptions.builder().setApi("measurement:api").build());
        this.zzb = zzibVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzgp zza(zzib zzibVar) {
        if (zza == null) {
            zza = new zzgp(zzibVar.zzaY(), zzibVar);
        }
        return zza;
    }

    public final synchronized void zzb(int i, int i2, long j, long j2, int i3) {
        final long elapsedRealtime = this.zzb.zzaZ().elapsedRealtime();
        AtomicLong atomicLong = this.zzd;
        if (atomicLong.get() != -1 && elapsedRealtime - atomicLong.get() <= 1800000) {
            return;
        }
        this.zzc.log(new TelemetryData(0, Arrays.asList(new MethodInvocation(36301, i2, 0, j, j2, null, null, 0, i3)))).addOnFailureListener(new OnFailureListener() { // from class: com.google.android.gms.measurement.internal.zzgo
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final /* synthetic */ void onFailure(Exception exc) {
                zzgp.this.zzc(elapsedRealtime, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(long j, Exception exc) {
        this.zzd.set(j);
    }
}
