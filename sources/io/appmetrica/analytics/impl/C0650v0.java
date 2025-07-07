package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.v0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0650v0 implements Pc {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0700x0 f1082a;
    public final /* synthetic */ AppMetricaConfig b;
    public final /* synthetic */ PublicLogger c;

    public C0650v0(C0700x0 c0700x0, AppMetricaConfig appMetricaConfig, PublicLogger publicLogger) {
        this.f1082a = c0700x0;
        this.b = appMetricaConfig;
        this.c = publicLogger;
    }

    @Override // io.appmetrica.analytics.impl.Pc
    public final Ac a() {
        C0700x0 c0700x0 = this.f1082a;
        return c0700x0.g.b(this.b, this.c, c0700x0.i.g);
    }
}
