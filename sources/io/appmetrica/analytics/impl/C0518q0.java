package io.appmetrica.analytics.impl;

import android.os.Handler;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
/* renamed from: io.appmetrica.analytics.impl.q0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0518q0 implements Ya {

    /* renamed from: a  reason: collision with root package name */
    public final Handler f1018a;
    public final IHandlerExecutor b;
    public final C0746z4 c;

    public C0518q0() {
        IHandlerExecutor a2 = C0696x4.l().g().a();
        this.b = a2;
        this.f1018a = a2.getHandler();
        this.c = new C0746z4();
    }

    @Override // io.appmetrica.analytics.impl.Ya
    public final void a(AppMetricaConfig appMetricaConfig, InterfaceC0529qb interfaceC0529qb) {
    }

    @Override // io.appmetrica.analytics.impl.Ya
    public final Handler b() {
        return this.f1018a;
    }

    @Override // io.appmetrica.analytics.impl.Ya
    public final Y1 c() {
        return new Y1();
    }

    @Override // io.appmetrica.analytics.impl.Ya
    public final Hb d() {
        return new Hb();
    }

    @Override // io.appmetrica.analytics.impl.Ya
    public final ICommonExecutor getDefaultExecutor() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.impl.Ya
    public final C0746z4 a() {
        return this.c;
    }
}
