package io.appmetrica.analytics.impl;

import android.os.Handler;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
/* renamed from: io.appmetrica.analytics.impl.x0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0701x0 implements InterfaceC0195db {

    /* renamed from: a  reason: collision with root package name */
    public final Handler f1274a;
    public final IHandlerExecutor b;
    public final C0653v4 c;

    public C0701x0() {
        IHandlerExecutor a2 = C0575s4.l().g().a();
        this.b = a2;
        this.f1274a = a2.getHandler();
        this.c = new C0653v4();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0195db
    public final void a(AppMetricaConfig appMetricaConfig, InterfaceC0556rb interfaceC0556rb) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0195db
    public final Handler b() {
        return this.f1274a;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0195db
    public final C0237f2 c() {
        return new C0237f2();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0195db
    public final Mb d() {
        return new Mb();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0195db
    public final ICommonExecutor getDefaultExecutor() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0195db
    public final C0653v4 a() {
        return this.c;
    }
}
