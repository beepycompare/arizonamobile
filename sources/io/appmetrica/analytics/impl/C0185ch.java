package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.internal.IAppMetricaService;
/* renamed from: io.appmetrica.analytics.impl.ch  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C0185ch extends Kh {
    public final Ih e;

    public C0185ch(C0420m0 c0420m0, Zk zk, Ih ih) {
        super(c0420m0, zk);
        this.e = ih;
    }

    @Override // io.appmetrica.analytics.impl.Kh
    public final void a(Throwable th) {
    }

    @Override // io.appmetrica.analytics.impl.Kh
    public final void a(IAppMetricaService iAppMetricaService) {
        Ih ih = this.e;
        iAppMetricaService.reportData(ih.c, ih.f492a.d(ih.e.c()));
    }
}
