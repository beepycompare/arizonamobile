package io.appmetrica.analytics.impl;

import android.os.Handler;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
/* loaded from: classes4.dex */
public interface Ua {
    C0746z4 a();

    void a(AppMetricaConfig appMetricaConfig, InterfaceC0429mb interfaceC0429mb);

    Handler b();

    Y1 c();

    Db d();

    ICommonExecutor getDefaultExecutor();
}
