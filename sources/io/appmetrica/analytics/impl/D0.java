package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes5.dex */
public final class D0 implements Xc {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ E0 f505a;
    public final /* synthetic */ AppMetricaConfig b;
    public final /* synthetic */ PublicLogger c;

    public D0(E0 e0, AppMetricaConfig appMetricaConfig, PublicLogger publicLogger) {
        this.f505a = e0;
        this.b = appMetricaConfig;
        this.c = publicLogger;
    }

    @Override // io.appmetrica.analytics.impl.Xc
    public final Jc a() {
        E0 e0 = this.f505a;
        Di di = e0.g;
        AppMetricaConfig appMetricaConfig = this.b;
        PublicLogger publicLogger = this.c;
        V7 v7 = e0.i;
        return di.b(appMetricaConfig, publicLogger, new C0443n0(v7.j, v7.h));
    }
}
