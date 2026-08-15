package io.appmetrica.analytics.impl;

import android.os.Handler;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
/* renamed from: io.appmetrica.analytics.impl.db  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC0195db {
    C0653v4 a();

    void a(AppMetricaConfig appMetricaConfig, InterfaceC0556rb interfaceC0556rb);

    Handler b();

    C0237f2 c();

    Mb d();

    ICommonExecutor getDefaultExecutor();
}
