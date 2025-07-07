package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.internal.IAppMetricaService;
/* loaded from: classes4.dex */
public final class Hn extends Ih {
    public final int e;
    public final Bundle f;

    public Hn(C0426m0 c0426m0, Wk wk, int i, Bundle bundle) {
        super(c0426m0, wk);
        this.e = i;
        this.f = bundle;
    }

    @Override // io.appmetrica.analytics.impl.Ih
    public final void a(IAppMetricaService iAppMetricaService) {
        iAppMetricaService.reportData(this.e, this.f);
    }
}
