package io.appmetrica.analytics.impl;

import android.os.Handler;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
/* renamed from: io.appmetrica.analytics.impl.q0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0521q0 implements Wa {

    /* renamed from: a  reason: collision with root package name */
    public final Handler f1010a;
    public final IHandlerExecutor b;
    public final C0749z4 c;

    public C0521q0() {
        IHandlerExecutor a2 = C0699x4.l().g().a();
        this.b = a2;
        this.f1010a = a2.getHandler();
        this.c = new C0749z4();
    }

    @Override // io.appmetrica.analytics.impl.Wa
    public final void a(AppMetricaConfig appMetricaConfig, InterfaceC0482ob interfaceC0482ob) {
    }

    @Override // io.appmetrica.analytics.impl.Wa
    public final Handler b() {
        return this.f1010a;
    }

    @Override // io.appmetrica.analytics.impl.Wa
    public final Y1 c() {
        return new Y1();
    }

    @Override // io.appmetrica.analytics.impl.Wa
    public final Fb d() {
        return new Fb();
    }

    @Override // io.appmetrica.analytics.impl.Wa
    public final ICommonExecutor getDefaultExecutor() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.impl.Wa
    public final C0749z4 a() {
        return this.c;
    }
}
