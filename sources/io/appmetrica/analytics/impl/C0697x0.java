package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.x0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0697x0 implements Wc {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0747z0 f1148a;
    public final /* synthetic */ AppMetricaConfig b;
    public final /* synthetic */ PublicLogger c;

    public C0697x0(C0747z0 c0747z0, AppMetricaConfig appMetricaConfig, PublicLogger publicLogger) {
        this.f1148a = c0747z0;
        this.b = appMetricaConfig;
        this.c = publicLogger;
    }

    @Override // io.appmetrica.analytics.impl.Wc
    public final Hc a() {
        C0747z0 c0747z0 = this.f1148a;
        Fi fi = c0747z0.g;
        AppMetricaConfig appMetricaConfig = this.b;
        PublicLogger publicLogger = this.c;
        C0196d8 c0196d8 = c0747z0.i;
        return fi.a(appMetricaConfig, publicLogger, new C0368k0(c0196d8.i, c0196d8.g));
    }
}
