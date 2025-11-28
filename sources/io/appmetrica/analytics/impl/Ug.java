package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.internal.IAppMetricaService;
/* loaded from: classes5.dex */
public class Ug extends Ch {
    public final Ah e;

    public Ug(C0486p0 c0486p0, InterfaceC0201dl interfaceC0201dl, Ah ah) {
        super(c0486p0, interfaceC0201dl);
        this.e = ah;
    }

    @Override // io.appmetrica.analytics.impl.Ch
    public final void a(Throwable th) {
    }

    @Override // io.appmetrica.analytics.impl.Ch
    public final void a(IAppMetricaService iAppMetricaService) {
        Ah ah = this.e;
        iAppMetricaService.reportData(ah.c, ah.f397a.d(ah.e.c()));
    }
}
