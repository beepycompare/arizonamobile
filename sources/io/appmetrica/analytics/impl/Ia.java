package io.appmetrica.analytics.impl;

import android.os.Handler;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
/* loaded from: classes5.dex */
public interface Ia {
    C0390l4 a();

    void a(AppMetricaConfig appMetricaConfig, InterfaceC0113ab interfaceC0113ab);

    Handler b();

    C0130b2 c();

    C0546rb d();

    ICommonExecutor getDefaultExecutor();
}
