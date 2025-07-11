package io.appmetrica.analytics.impl;

import android.os.Handler;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
/* renamed from: io.appmetrica.analytics.impl.q0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0518q0 implements Ua {

    /* renamed from: a  reason: collision with root package name */
    public final Handler f998a;
    public final IHandlerExecutor b;
    public final C0746z4 c;

    public C0518q0() {
        IHandlerExecutor a2 = C0696x4.l().g().a();
        this.b = a2;
        this.f998a = a2.getHandler();
        this.c = new C0746z4();
    }

    @Override // io.appmetrica.analytics.impl.Ua
    public final void a(AppMetricaConfig appMetricaConfig, InterfaceC0429mb interfaceC0429mb) {
    }

    @Override // io.appmetrica.analytics.impl.Ua
    public final Handler b() {
        return this.f998a;
    }

    @Override // io.appmetrica.analytics.impl.Ua
    public final Y1 c() {
        return new Y1();
    }

    @Override // io.appmetrica.analytics.impl.Ua
    public final Db d() {
        return new Db();
    }

    @Override // io.appmetrica.analytics.impl.Ua
    public final ICommonExecutor getDefaultExecutor() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.impl.Ua
    public final C0746z4 a() {
        return this.c;
    }
}
