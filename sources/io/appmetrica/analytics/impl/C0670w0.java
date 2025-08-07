package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.w0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0670w0 implements Rc {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0695x0 f1109a;
    public final /* synthetic */ AppMetricaConfig b;
    public final /* synthetic */ PublicLogger c;

    public C0670w0(C0695x0 c0695x0, AppMetricaConfig appMetricaConfig, PublicLogger publicLogger) {
        this.f1109a = c0695x0;
        this.b = appMetricaConfig;
        this.c = publicLogger;
    }

    @Override // io.appmetrica.analytics.impl.Rc
    public final Cc a() {
        C0695x0 c0695x0 = this.f1109a;
        return c0695x0.g.a(this.b, this.c, c0695x0.i.g);
    }
}
