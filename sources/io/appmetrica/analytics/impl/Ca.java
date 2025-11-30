package io.appmetrica.analytics.impl;

import android.os.Handler;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
/* loaded from: classes5.dex */
public interface Ca {
    C0235f4 a();

    void a(AppMetricaConfig appMetricaConfig, Ua ua);

    Handler b();

    T1 c();

    C0397lb d();

    ICommonExecutor getDefaultExecutor();
}
