package io.appmetrica.analytics.internal;

import android.os.Bundle;
import io.appmetrica.analytics.impl.InterfaceC0701x1;
import io.appmetrica.analytics.internal.IAppMetricaService;
/* loaded from: classes4.dex */
public final class a extends IAppMetricaService.Stub {
    @Override // io.appmetrica.analytics.internal.IAppMetricaService
    public final void pauseUserSession(Bundle bundle) {
        InterfaceC0701x1 interfaceC0701x1;
        interfaceC0701x1 = AppMetricaService.c;
        interfaceC0701x1.pauseUserSession(bundle);
    }

    @Override // io.appmetrica.analytics.internal.IAppMetricaService
    public final void reportData(int i, Bundle bundle) {
        InterfaceC0701x1 interfaceC0701x1;
        interfaceC0701x1 = AppMetricaService.c;
        interfaceC0701x1.reportData(i, bundle);
    }

    @Override // io.appmetrica.analytics.internal.IAppMetricaService
    public final void resumeUserSession(Bundle bundle) {
        InterfaceC0701x1 interfaceC0701x1;
        interfaceC0701x1 = AppMetricaService.c;
        interfaceC0701x1.resumeUserSession(bundle);
    }
}
