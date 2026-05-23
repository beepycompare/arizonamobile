package com.google.android.gms.common.api.internal;

import android.os.SystemClock;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.RootTelemetryConfigManager;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@18.9.0 */
/* loaded from: classes4.dex */
public final class zaby implements OnCompleteListener {
    private final GoogleApiManager zaa;
    private final int zab;
    private final ApiKey zac;
    private final long zad;
    private final long zae;

    zaby(GoogleApiManager googleApiManager, int i, ApiKey apiKey, long j, long j2, String str, String str2) {
        this.zaa = googleApiManager;
        this.zab = i;
        this.zac = apiKey;
        this.zad = j;
        this.zae = j2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zaby zaa(GoogleApiManager googleApiManager, int i, ApiKey apiKey) {
        boolean z;
        if (googleApiManager.zam()) {
            RootTelemetryConfiguration config = RootTelemetryConfigManager.getInstance().getConfig();
            if (config == null) {
                z = true;
            } else if (!config.getMethodInvocationTelemetryEnabled()) {
                return null;
            } else {
                z = config.getMethodTimingTelemetryEnabled();
                zabk zag = googleApiManager.zag(apiKey);
                if (zag != null) {
                    if (!(zag.zaf() instanceof BaseGmsClient)) {
                        return null;
                    }
                    BaseGmsClient baseGmsClient = (BaseGmsClient) zag.zaf();
                    if (baseGmsClient.hasConnectionInfo() && !baseGmsClient.isConnecting()) {
                        ConnectionTelemetryConfiguration zab = zab(zag, baseGmsClient, i);
                        if (zab == null) {
                            return null;
                        }
                        zag.zas();
                        z = zab.getMethodTimingTelemetryEnabled();
                    }
                }
            }
            return new zaby(googleApiManager, i, apiKey, z ? System.currentTimeMillis() : 0L, z ? SystemClock.elapsedRealtime() : 0L, null, null);
        }
        return null;
    }

    private static ConnectionTelemetryConfiguration zab(zabk zabkVar, BaseGmsClient baseGmsClient, int i) {
        int[] methodInvocationMethodKeyAllowlist;
        int[] methodInvocationMethodKeyDisallowlist;
        ConnectionTelemetryConfiguration telemetryConfiguration = baseGmsClient.getTelemetryConfiguration();
        if (telemetryConfiguration == null || !telemetryConfiguration.getMethodInvocationTelemetryEnabled() || ((methodInvocationMethodKeyAllowlist = telemetryConfiguration.getMethodInvocationMethodKeyAllowlist()) != null ? !ArrayUtils.contains(methodInvocationMethodKeyAllowlist, i) : !((methodInvocationMethodKeyDisallowlist = telemetryConfiguration.getMethodInvocationMethodKeyDisallowlist()) == null || !ArrayUtils.contains(methodInvocationMethodKeyDisallowlist, i))) || zabkVar.zar() >= telemetryConfiguration.getMaxMethodInvocationsLogged()) {
            return null;
        }
        return telemetryConfiguration;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        zabk zag;
        long j;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        long j2;
        long j3;
        GoogleApiManager googleApiManager = this.zaa;
        if (googleApiManager.zam()) {
            RootTelemetryConfiguration config = RootTelemetryConfigManager.getInstance().getConfig();
            if ((config == null || config.getMethodInvocationTelemetryEnabled()) && (zag = googleApiManager.zag(this.zac)) != null && (zag.zaf() instanceof BaseGmsClient)) {
                BaseGmsClient baseGmsClient = (BaseGmsClient) zag.zaf();
                long j4 = this.zad;
                int i7 = (j4 > 0L ? 1 : (j4 == 0L ? 0 : -1));
                boolean z = true;
                boolean z2 = i7 > 0;
                int gCoreServiceId = baseGmsClient.getGCoreServiceId();
                if (config != null) {
                    z2 &= config.getMethodTimingTelemetryEnabled();
                    int batchPeriodMillis = config.getBatchPeriodMillis();
                    int maxMethodInvocationsInBatch = config.getMaxMethodInvocationsInBatch();
                    i = config.getVersion();
                    if (!baseGmsClient.hasConnectionInfo() || baseGmsClient.isConnecting()) {
                        j = j4;
                        i3 = batchPeriodMillis;
                    } else {
                        ConnectionTelemetryConfiguration zab = zab(zag, baseGmsClient, this.zab);
                        if (zab == null) {
                            return;
                        }
                        if (!zab.getMethodTimingTelemetryEnabled() || i7 <= 0) {
                            z = false;
                        }
                        maxMethodInvocationsInBatch = zab.getMaxMethodInvocationsLogged();
                        z2 = z;
                        i3 = batchPeriodMillis;
                        j = j4;
                    }
                    i2 = maxMethodInvocationsInBatch;
                } else {
                    j = j4;
                    i = 0;
                    i2 = 100;
                    i3 = 5000;
                }
                int i8 = -1;
                if (task.isSuccessful()) {
                    i6 = 0;
                    i5 = 0;
                } else if (task.isCanceled()) {
                    i5 = -1;
                    i6 = 100;
                } else {
                    Exception exception = task.getException();
                    if (exception instanceof ApiException) {
                        Status status = ((ApiException) exception).getStatus();
                        i4 = status.getStatusCode();
                        ConnectionResult connectionResult = status.getConnectionResult();
                        if (connectionResult != null) {
                            i5 = connectionResult.getErrorCode();
                            i6 = i4;
                        }
                    } else {
                        i4 = 101;
                    }
                    i5 = -1;
                    i6 = i4;
                }
                if (z2) {
                    long j5 = this.zae;
                    long currentTimeMillis = System.currentTimeMillis();
                    i8 = (int) (SystemClock.elapsedRealtime() - j5);
                    j2 = j;
                    j3 = currentTimeMillis;
                } else {
                    j2 = 0;
                    j3 = 0;
                }
                googleApiManager.zar(new MethodInvocation(this.zab, i6, i5, j2, j3, null, null, gCoreServiceId, i8), i, i3, i2);
            }
        }
    }
}
