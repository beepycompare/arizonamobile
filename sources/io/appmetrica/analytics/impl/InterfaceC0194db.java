package io.appmetrica.analytics.impl;

import android.os.Handler;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
/* renamed from: io.appmetrica.analytics.impl.db  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC0194db {
    C0652v4 a();

    void a(AppMetricaConfig appMetricaConfig, InterfaceC0555rb interfaceC0555rb);

    Handler b();

    C0236f2 c();

    Mb d();

    ICommonExecutor getDefaultExecutor();
}
