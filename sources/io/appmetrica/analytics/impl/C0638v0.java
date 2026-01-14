package io.appmetrica.analytics.impl;

import android.os.Handler;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
/* renamed from: io.appmetrica.analytics.impl.v0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0638v0 implements Ba {

    /* renamed from: a  reason: collision with root package name */
    public final Handler f1266a;
    public final IHandlerExecutor b;
    public final C0213e4 c;

    public C0638v0() {
        IHandlerExecutor a2 = C0136b4.l().g().a();
        this.b = a2;
        this.f1266a = a2.getHandler();
        this.c = new C0213e4();
    }

    @Override // io.appmetrica.analytics.impl.Ba
    public final void a(AppMetricaConfig appMetricaConfig, Ta ta) {
    }

    @Override // io.appmetrica.analytics.impl.Ba
    public final Handler b() {
        return this.f1266a;
    }

    @Override // io.appmetrica.analytics.impl.Ba
    public final S1 c() {
        return new S1();
    }

    @Override // io.appmetrica.analytics.impl.Ba
    public final C0375kb d() {
        return new C0375kb();
    }

    @Override // io.appmetrica.analytics.impl.Ba
    public final ICommonExecutor getDefaultExecutor() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.impl.Ba
    public final C0213e4 a() {
        return this.c;
    }
}
