package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.internal.IAppMetricaService;
/* renamed from: io.appmetrica.analytics.impl.lh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C0411lh extends Th {
    public final Rh e;

    public C0411lh(C0472o0 c0472o0, InterfaceC0337il interfaceC0337il, Rh rh) {
        super(c0472o0, interfaceC0337il);
        this.e = rh;
    }

    @Override // io.appmetrica.analytics.impl.Th
    public final void a(Throwable th) {
    }

    @Override // io.appmetrica.analytics.impl.Th
    public final void a(IAppMetricaService iAppMetricaService) {
        Rh rh = this.e;
        iAppMetricaService.reportData(rh.c, rh.f658a.d(rh.e.c()));
    }
}
