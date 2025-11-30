package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes5.dex */
public final class A0 implements InterfaceC0697xc {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0 f390a;
    public final /* synthetic */ AppMetricaConfig b;
    public final /* synthetic */ PublicLogger c;

    public A0(C0 c0, AppMetricaConfig appMetricaConfig, PublicLogger publicLogger) {
        this.f390a = c0;
        this.b = appMetricaConfig;
        this.c = publicLogger;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0697xc
    public final C0321ic a() {
        C0 c0 = this.f390a;
        C0378ki c0378ki = c0.g;
        AppMetricaConfig appMetricaConfig = this.b;
        PublicLogger publicLogger = this.c;
        E7 e7 = c0.i;
        return c0378ki.a(appMetricaConfig, publicLogger, new C0386l0(e7.j, e7.h));
    }
}
