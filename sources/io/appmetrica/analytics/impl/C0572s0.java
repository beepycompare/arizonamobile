package io.appmetrica.analytics.impl;

import android.os.Handler;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
/* renamed from: io.appmetrica.analytics.impl.s0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0572s0 implements InterfaceC0147bb {

    /* renamed from: a  reason: collision with root package name */
    public final Handler f1074a;
    public final IHandlerExecutor b;
    public final C4 c;

    public C0572s0() {
        IHandlerExecutor a2 = A4.l().g().a();
        this.b = a2;
        this.f1074a = a2.getHandler();
        this.c = new C4();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0147bb
    public final void a(AppMetricaConfig appMetricaConfig, InterfaceC0608tb interfaceC0608tb) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0147bb
    public final Handler b() {
        return this.f1074a;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0147bb
    public final C0112a2 c() {
        return new C0112a2();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0147bb
    public final Kb d() {
        return new Kb();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0147bb
    public final ICommonExecutor getDefaultExecutor() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0147bb
    public final C4 a() {
        return this.c;
    }
}
