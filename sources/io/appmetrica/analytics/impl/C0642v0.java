package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.v0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0642v0 implements Pc {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0692x0 f1083a;
    public final /* synthetic */ AppMetricaConfig b;
    public final /* synthetic */ PublicLogger c;

    public C0642v0(C0692x0 c0692x0, AppMetricaConfig appMetricaConfig, PublicLogger publicLogger) {
        this.f1083a = c0692x0;
        this.b = appMetricaConfig;
        this.c = publicLogger;
    }

    @Override // io.appmetrica.analytics.impl.Pc
    public final Ac a() {
        C0692x0 c0692x0 = this.f1083a;
        return c0692x0.g.b(this.b, this.c, c0692x0.i.g);
    }
}
