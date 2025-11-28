package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.z0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0735z0 implements Dc {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ A0 f1222a;
    public final /* synthetic */ AppMetricaConfig b;
    public final /* synthetic */ PublicLogger c;

    public C0735z0(A0 a0, AppMetricaConfig appMetricaConfig, PublicLogger publicLogger) {
        this.f1222a = a0;
        this.b = appMetricaConfig;
        this.c = publicLogger;
    }

    @Override // io.appmetrica.analytics.impl.Dc
    public final C0473oc a() {
        A0 a0 = this.f1222a;
        C0479oi c0479oi = a0.g;
        AppMetricaConfig appMetricaConfig = this.b;
        PublicLogger publicLogger = this.c;
        L7 l7 = a0.i;
        return c0479oi.b(appMetricaConfig, publicLogger, new C0386l0(l7.j, l7.h));
    }
}
