package io.appmetrica.analytics.impl;

import android.os.Handler;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
/* renamed from: io.appmetrica.analytics.impl.t0  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0585t0 implements Ia {

    /* renamed from: a  reason: collision with root package name */
    public final Handler f1121a;
    public final IHandlerExecutor b;
    public final C0390l4 c;

    public C0585t0() {
        IHandlerExecutor a2 = C0338j4.l().g().a();
        this.b = a2;
        this.f1121a = a2.getHandler();
        this.c = new C0390l4();
    }

    @Override // io.appmetrica.analytics.impl.Ia
    public final void a(AppMetricaConfig appMetricaConfig, InterfaceC0113ab interfaceC0113ab) {
    }

    @Override // io.appmetrica.analytics.impl.Ia
    public final Handler b() {
        return this.f1121a;
    }

    @Override // io.appmetrica.analytics.impl.Ia
    public final C0130b2 c() {
        return new C0130b2();
    }

    @Override // io.appmetrica.analytics.impl.Ia
    public final C0546rb d() {
        return new C0546rb();
    }

    @Override // io.appmetrica.analytics.impl.Ia
    public final ICommonExecutor getDefaultExecutor() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.impl.Ia
    public final C0390l4 a() {
        return this.c;
    }
}
