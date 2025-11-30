package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.internal.IAppMetricaService;
/* loaded from: classes5.dex */
public class Qg extends AbstractCallableC0727yh {
    public final C0677wh e;

    public Qg(C0486p0 c0486p0, InterfaceC0123al interfaceC0123al, C0677wh c0677wh) {
        super(c0486p0, interfaceC0123al);
        this.e = c0677wh;
    }

    @Override // io.appmetrica.analytics.impl.AbstractCallableC0727yh
    public final void a(Throwable th) {
    }

    @Override // io.appmetrica.analytics.impl.AbstractCallableC0727yh
    public final void a(IAppMetricaService iAppMetricaService) {
        C0677wh c0677wh = this.e;
        iAppMetricaService.reportData(c0677wh.c, c0677wh.f1184a.d(c0677wh.e.c()));
    }
}
