package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes5.dex */
public final class B0 implements InterfaceC0696xc {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0 f500a;
    public final /* synthetic */ AppMetricaConfig b;
    public final /* synthetic */ PublicLogger c;

    public B0(C0 c0, AppMetricaConfig appMetricaConfig, PublicLogger publicLogger) {
        this.f500a = c0;
        this.b = appMetricaConfig;
        this.c = publicLogger;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0696xc
    public final C0320ic a() {
        C0 c0 = this.f500a;
        C0377ki c0377ki = c0.g;
        AppMetricaConfig appMetricaConfig = this.b;
        PublicLogger publicLogger = this.c;
        E7 e7 = c0.i;
        return c0377ki.b(appMetricaConfig, publicLogger, new C0385l0(e7.j, e7.h));
    }
}
