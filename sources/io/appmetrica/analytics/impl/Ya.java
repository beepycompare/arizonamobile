package io.appmetrica.analytics.impl;

import android.os.Handler;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
/* loaded from: classes4.dex */
public interface Ya {
    C0746z4 a();

    void a(AppMetricaConfig appMetricaConfig, InterfaceC0529qb interfaceC0529qb);

    Handler b();

    Y1 c();

    Hb d();

    ICommonExecutor getDefaultExecutor();
}
