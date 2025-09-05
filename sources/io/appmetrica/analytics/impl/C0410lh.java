package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.internal.IAppMetricaService;
/* renamed from: io.appmetrica.analytics.impl.lh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C0410lh extends Th {
    public final Rh e;

    public C0410lh(C0471o0 c0471o0, InterfaceC0336il interfaceC0336il, Rh rh) {
        super(c0471o0, interfaceC0336il);
        this.e = rh;
    }

    @Override // io.appmetrica.analytics.impl.Th
    public final void a(Throwable th) {
    }

    @Override // io.appmetrica.analytics.impl.Th
    public final void a(IAppMetricaService iAppMetricaService) {
        Rh rh = this.e;
        iAppMetricaService.reportData(rh.c, rh.f653a.d(rh.e.c()));
    }
}
