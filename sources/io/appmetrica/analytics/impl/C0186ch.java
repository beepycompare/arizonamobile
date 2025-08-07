package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.internal.IAppMetricaService;
/* renamed from: io.appmetrica.analytics.impl.ch  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C0186ch extends Kh {
    public final Ih e;

    public C0186ch(C0421m0 c0421m0, Zk zk, Ih ih) {
        super(c0421m0, zk);
        this.e = ih;
    }

    @Override // io.appmetrica.analytics.impl.Kh
    public final void a(Throwable th) {
    }

    @Override // io.appmetrica.analytics.impl.Kh
    public final void a(IAppMetricaService iAppMetricaService) {
        Ih ih = this.e;
        iAppMetricaService.reportData(ih.c, ih.f491a.d(ih.e.c()));
    }
}
