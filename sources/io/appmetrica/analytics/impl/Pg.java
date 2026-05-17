package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.internal.IAppMetricaService;
/* loaded from: classes5.dex */
public class Pg extends AbstractCallableC0704xh {
    public final C0654vh e;

    public Pg(C0488p0 c0488p0, Zk zk, C0654vh c0654vh) {
        super(c0488p0, zk);
        this.e = c0654vh;
    }

    @Override // io.appmetrica.analytics.impl.AbstractCallableC0704xh
    public final void a(Throwable th) {
    }

    @Override // io.appmetrica.analytics.impl.AbstractCallableC0704xh
    public final void a(IAppMetricaService iAppMetricaService) {
        C0654vh c0654vh = this.e;
        iAppMetricaService.reportData(c0654vh.c, c0654vh.f1277a.d(c0654vh.e.c()));
    }
}
