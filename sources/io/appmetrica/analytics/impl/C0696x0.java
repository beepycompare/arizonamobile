package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.x0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0696x0 implements Wc {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0746z0 f1147a;
    public final /* synthetic */ AppMetricaConfig b;
    public final /* synthetic */ PublicLogger c;

    public C0696x0(C0746z0 c0746z0, AppMetricaConfig appMetricaConfig, PublicLogger publicLogger) {
        this.f1147a = c0746z0;
        this.b = appMetricaConfig;
        this.c = publicLogger;
    }

    @Override // io.appmetrica.analytics.impl.Wc
    public final Hc a() {
        C0746z0 c0746z0 = this.f1147a;
        Fi fi = c0746z0.g;
        AppMetricaConfig appMetricaConfig = this.b;
        PublicLogger publicLogger = this.c;
        C0195d8 c0195d8 = c0746z0.i;
        return fi.a(appMetricaConfig, publicLogger, new C0367k0(c0195d8.i, c0195d8.g));
    }
}
