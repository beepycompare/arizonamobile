package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.internal.IAppMetricaService;
/* renamed from: io.appmetrica.analytics.impl.fh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C0252fh extends Rh {
    public final Ph e;

    public C0252fh(C0545r0 c0545r0, El el, Ph ph) {
        super(c0545r0, el);
        this.e = ph;
    }

    @Override // io.appmetrica.analytics.impl.Rh
    public final void a(Throwable th) {
    }

    @Override // io.appmetrica.analytics.impl.Rh
    public final void a(IAppMetricaService iAppMetricaService) {
        Ph ph = this.e;
        iAppMetricaService.reportData(ph.c, ph.f720a.d(ph.e.c()));
    }
}
