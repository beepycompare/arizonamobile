package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.w0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0675w0 implements Pc {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0700x0 f1095a;
    public final /* synthetic */ AppMetricaConfig b;
    public final /* synthetic */ PublicLogger c;

    public C0675w0(C0700x0 c0700x0, AppMetricaConfig appMetricaConfig, PublicLogger publicLogger) {
        this.f1095a = c0700x0;
        this.b = appMetricaConfig;
        this.c = publicLogger;
    }

    @Override // io.appmetrica.analytics.impl.Pc
    public final Ac a() {
        C0700x0 c0700x0 = this.f1095a;
        return c0700x0.g.a(this.b, this.c, c0700x0.i.g);
    }
}
