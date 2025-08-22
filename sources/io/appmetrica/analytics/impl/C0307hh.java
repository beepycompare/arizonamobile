package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.internal.IAppMetricaService;
/* renamed from: io.appmetrica.analytics.impl.hh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C0307hh extends Ph {
    public final Nh e;

    public C0307hh(C0418m0 c0418m0, InterfaceC0233el interfaceC0233el, Nh nh) {
        super(c0418m0, interfaceC0233el);
        this.e = nh;
    }

    @Override // io.appmetrica.analytics.impl.Ph
    public final void a(Throwable th) {
    }

    @Override // io.appmetrica.analytics.impl.Ph
    public final void a(IAppMetricaService iAppMetricaService) {
        Nh nh = this.e;
        iAppMetricaService.reportData(nh.c, nh.f580a.d(nh.e.c()));
    }
}
