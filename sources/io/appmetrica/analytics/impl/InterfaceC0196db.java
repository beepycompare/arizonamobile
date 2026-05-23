package io.appmetrica.analytics.impl;

import android.os.Handler;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
/* renamed from: io.appmetrica.analytics.impl.db  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC0196db {
    C0654v4 a();

    void a(AppMetricaConfig appMetricaConfig, InterfaceC0557rb interfaceC0557rb);

    Handler b();

    C0238f2 c();

    Mb d();

    ICommonExecutor getDefaultExecutor();
}
