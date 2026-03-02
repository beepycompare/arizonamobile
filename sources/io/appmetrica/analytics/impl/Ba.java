package io.appmetrica.analytics.impl;

import android.os.Handler;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
/* loaded from: classes5.dex */
public interface Ba {
    C0212e4 a();

    void a(AppMetricaConfig appMetricaConfig, Ta ta);

    Handler b();

    S1 c();

    C0374kb d();

    ICommonExecutor getDefaultExecutor();
}
