package io.appmetrica.analytics.impl;

import android.os.Handler;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
/* renamed from: io.appmetrica.analytics.impl.x0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0702x0 implements InterfaceC0196db {

    /* renamed from: a  reason: collision with root package name */
    public final Handler f1271a;
    public final IHandlerExecutor b;
    public final C0654v4 c;

    public C0702x0() {
        IHandlerExecutor a2 = C0576s4.l().g().a();
        this.b = a2;
        this.f1271a = a2.getHandler();
        this.c = new C0654v4();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0196db
    public final void a(AppMetricaConfig appMetricaConfig, InterfaceC0557rb interfaceC0557rb) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0196db
    public final Handler b() {
        return this.f1271a;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0196db
    public final C0238f2 c() {
        return new C0238f2();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0196db
    public final Mb d() {
        return new Mb();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0196db
    public final ICommonExecutor getDefaultExecutor() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0196db
    public final C0654v4 a() {
        return this.c;
    }
}
