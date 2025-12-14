package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.internal.IAppMetricaService;
/* loaded from: classes5.dex */
public class Qg extends AbstractCallableC0726yh {
    public final C0676wh e;

    public Qg(C0485p0 c0485p0, InterfaceC0122al interfaceC0122al, C0676wh c0676wh) {
        super(c0485p0, interfaceC0122al);
        this.e = c0676wh;
    }

    @Override // io.appmetrica.analytics.impl.AbstractCallableC0726yh
    public final void a(Throwable th) {
    }

    @Override // io.appmetrica.analytics.impl.AbstractCallableC0726yh
    public final void a(IAppMetricaService iAppMetricaService) {
        C0676wh c0676wh = this.e;
        iAppMetricaService.reportData(c0676wh.c, c0676wh.f1281a.d(c0676wh.e.c()));
    }
}
