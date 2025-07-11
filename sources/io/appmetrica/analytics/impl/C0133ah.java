package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.internal.IAppMetricaService;
/* renamed from: io.appmetrica.analytics.impl.ah  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C0133ah extends Ih {
    public final Gh e;

    public C0133ah(C0418m0 c0418m0, Wk wk, Gh gh) {
        super(c0418m0, wk);
        this.e = gh;
    }

    @Override // io.appmetrica.analytics.impl.Ih
    public final void a(Throwable th) {
    }

    @Override // io.appmetrica.analytics.impl.Ih
    public final void a(IAppMetricaService iAppMetricaService) {
        Gh gh = this.e;
        iAppMetricaService.reportData(gh.c, gh.f446a.d(gh.e.c()));
    }
}
