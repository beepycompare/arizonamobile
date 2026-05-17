package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes5.dex */
public final class A0 implements InterfaceC0674wc {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0 f496a;
    public final /* synthetic */ AppMetricaConfig b;
    public final /* synthetic */ PublicLogger c;

    public A0(C0 c0, AppMetricaConfig appMetricaConfig, PublicLogger publicLogger) {
        this.f496a = c0;
        this.b = appMetricaConfig;
        this.c = publicLogger;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0674wc
    public final C0298hc a() {
        C0 c0 = this.f496a;
        C0355ji c0355ji = c0.g;
        AppMetricaConfig appMetricaConfig = this.b;
        PublicLogger publicLogger = this.c;
        D7 d7 = c0.i;
        return c0355ji.a(appMetricaConfig, publicLogger, new C0388l0(d7.j, d7.h));
    }
}
