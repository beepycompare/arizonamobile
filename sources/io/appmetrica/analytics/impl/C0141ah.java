package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.internal.IAppMetricaService;
/* renamed from: io.appmetrica.analytics.impl.ah  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C0141ah extends Ih {
    public final Gh e;

    public C0141ah(C0426m0 c0426m0, Wk wk, Gh gh) {
        super(c0426m0, wk);
        this.e = gh;
    }

    @Override // io.appmetrica.analytics.impl.Ih
    public final void a(Throwable th) {
    }

    @Override // io.appmetrica.analytics.impl.Ih
    public final void a(IAppMetricaService iAppMetricaService) {
        Gh gh = this.e;
        iAppMetricaService.reportData(gh.c, gh.f445a.d(gh.e.c()));
    }
}
