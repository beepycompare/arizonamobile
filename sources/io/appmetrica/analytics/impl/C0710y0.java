package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.y0  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0710y0 implements Dc {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ A0 f1207a;
    public final /* synthetic */ AppMetricaConfig b;
    public final /* synthetic */ PublicLogger c;

    public C0710y0(A0 a0, AppMetricaConfig appMetricaConfig, PublicLogger publicLogger) {
        this.f1207a = a0;
        this.b = appMetricaConfig;
        this.c = publicLogger;
    }

    @Override // io.appmetrica.analytics.impl.Dc
    public final C0473oc a() {
        A0 a0 = this.f1207a;
        C0479oi c0479oi = a0.g;
        AppMetricaConfig appMetricaConfig = this.b;
        PublicLogger publicLogger = this.c;
        L7 l7 = a0.i;
        return c0479oi.a(appMetricaConfig, publicLogger, new C0386l0(l7.j, l7.h));
    }
}
