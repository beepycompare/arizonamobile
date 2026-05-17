package io.appmetrica.analytics.impl;

import android.os.Handler;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
/* renamed from: io.appmetrica.analytics.impl.v0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0637v0 implements Ba {

    /* renamed from: a  reason: collision with root package name */
    public final Handler f1270a;
    public final IHandlerExecutor b;
    public final C0212e4 c;

    public C0637v0() {
        IHandlerExecutor a2 = C0135b4.l().g().a();
        this.b = a2;
        this.f1270a = a2.getHandler();
        this.c = new C0212e4();
    }

    @Override // io.appmetrica.analytics.impl.Ba
    public final void a(AppMetricaConfig appMetricaConfig, Ta ta) {
    }

    @Override // io.appmetrica.analytics.impl.Ba
    public final Handler b() {
        return this.f1270a;
    }

    @Override // io.appmetrica.analytics.impl.Ba
    public final S1 c() {
        return new S1();
    }

    @Override // io.appmetrica.analytics.impl.Ba
    public final C0374kb d() {
        return new C0374kb();
    }

    @Override // io.appmetrica.analytics.impl.Ba
    public final ICommonExecutor getDefaultExecutor() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.impl.Ba
    public final C0212e4 a() {
        return this.c;
    }
}
