package io.appmetrica.analytics.impl;

import android.os.Handler;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
/* renamed from: io.appmetrica.analytics.impl.q0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0526q0 implements Ua {

    /* renamed from: a  reason: collision with root package name */
    public final Handler f997a;
    public final IHandlerExecutor b;
    public final C0754z4 c;

    public C0526q0() {
        IHandlerExecutor a2 = C0704x4.l().g().a();
        this.b = a2;
        this.f997a = a2.getHandler();
        this.c = new C0754z4();
    }

    @Override // io.appmetrica.analytics.impl.Ua
    public final void a(AppMetricaConfig appMetricaConfig, InterfaceC0437mb interfaceC0437mb) {
    }

    @Override // io.appmetrica.analytics.impl.Ua
    public final Handler b() {
        return this.f997a;
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
    public final C0754z4 a() {
        return this.c;
    }
}
