package io.appmetrica.analytics.internal;

import android.os.Bundle;
import io.appmetrica.analytics.impl.A1;
import io.appmetrica.analytics.internal.IAppMetricaService;
/* loaded from: classes3.dex */
public final class a extends IAppMetricaService.Stub {
    @Override // io.appmetrica.analytics.internal.IAppMetricaService
    public final void pauseUserSession(Bundle bundle) {
        A1 a1;
        a1 = AppMetricaService.c;
        a1.pauseUserSession(bundle);
    }

    @Override // io.appmetrica.analytics.internal.IAppMetricaService
    public final void reportData(int i, Bundle bundle) {
        A1 a1;
        a1 = AppMetricaService.c;
        a1.reportData(i, bundle);
    }

    @Override // io.appmetrica.analytics.internal.IAppMetricaService
    public final void resumeUserSession(Bundle bundle) {
        A1 a1;
        a1 = AppMetricaService.c;
        a1.resumeUserSession(bundle);
    }
}
