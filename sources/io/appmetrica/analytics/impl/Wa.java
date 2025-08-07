package io.appmetrica.analytics.impl;

import android.os.Handler;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
/* loaded from: classes4.dex */
public interface Wa {
    C0749z4 a();

    void a(AppMetricaConfig appMetricaConfig, InterfaceC0482ob interfaceC0482ob);

    Handler b();

    Y1 c();

    Fb d();

    ICommonExecutor getDefaultExecutor();
}
