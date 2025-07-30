package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.w0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0669w0 implements Rc {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0694x0 f1110a;
    public final /* synthetic */ AppMetricaConfig b;
    public final /* synthetic */ PublicLogger c;

    public C0669w0(C0694x0 c0694x0, AppMetricaConfig appMetricaConfig, PublicLogger publicLogger) {
        this.f1110a = c0694x0;
        this.b = appMetricaConfig;
        this.c = publicLogger;
    }

    @Override // io.appmetrica.analytics.impl.Rc
    public final Cc a() {
        C0694x0 c0694x0 = this.f1110a;
        return c0694x0.g.a(this.b, this.c, c0694x0.i.g);
    }
}
