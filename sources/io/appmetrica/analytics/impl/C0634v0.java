package io.appmetrica.analytics.impl;

import android.os.Handler;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
/* renamed from: io.appmetrica.analytics.impl.v0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0634v0 implements Ca {

    /* renamed from: a  reason: collision with root package name */
    public final Handler f1240a;
    public final IHandlerExecutor b;
    public final C0234f4 c;

    public C0634v0() {
        IHandlerExecutor a2 = C0157c4.l().g().a();
        this.b = a2;
        this.f1240a = a2.getHandler();
        this.c = new C0234f4();
    }

    @Override // io.appmetrica.analytics.impl.Ca
    public final void a(AppMetricaConfig appMetricaConfig, Ua ua) {
    }

    @Override // io.appmetrica.analytics.impl.Ca
    public final Handler b() {
        return this.f1240a;
    }

    @Override // io.appmetrica.analytics.impl.Ca
    public final T1 c() {
        return new T1();
    }

    @Override // io.appmetrica.analytics.impl.Ca
    public final C0396lb d() {
        return new C0396lb();
    }

    @Override // io.appmetrica.analytics.impl.Ca
    public final ICommonExecutor getDefaultExecutor() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.impl.Ca
    public final C0234f4 a() {
        return this.c;
    }
}
