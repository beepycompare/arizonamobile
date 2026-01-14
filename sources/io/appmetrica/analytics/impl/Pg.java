package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.internal.IAppMetricaService;
/* loaded from: classes5.dex */
public class Pg extends AbstractCallableC0705xh {
    public final C0655vh e;

    public Pg(C0489p0 c0489p0, Zk zk, C0655vh c0655vh) {
        super(c0489p0, zk);
        this.e = c0655vh;
    }

    @Override // io.appmetrica.analytics.impl.AbstractCallableC0705xh
    public final void a(Throwable th) {
    }

    @Override // io.appmetrica.analytics.impl.AbstractCallableC0705xh
    public final void a(IAppMetricaService iAppMetricaService) {
        C0655vh c0655vh = this.e;
        iAppMetricaService.reportData(c0655vh.c, c0655vh.f1273a.d(c0655vh.e.c()));
    }
}
