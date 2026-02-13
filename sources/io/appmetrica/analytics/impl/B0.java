package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes5.dex */
public final class B0 implements InterfaceC0675wc {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0 f506a;
    public final /* synthetic */ AppMetricaConfig b;
    public final /* synthetic */ PublicLogger c;

    public B0(C0 c0, AppMetricaConfig appMetricaConfig, PublicLogger publicLogger) {
        this.f506a = c0;
        this.b = appMetricaConfig;
        this.c = publicLogger;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0675wc
    public final C0299hc a() {
        C0 c0 = this.f506a;
        C0356ji c0356ji = c0.g;
        AppMetricaConfig appMetricaConfig = this.b;
        PublicLogger publicLogger = this.c;
        D7 d7 = c0.i;
        return c0356ji.b(appMetricaConfig, publicLogger, new C0389l0(d7.j, d7.h));
    }
}
