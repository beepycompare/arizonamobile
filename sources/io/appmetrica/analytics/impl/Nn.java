package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.internal.IAppMetricaService;
/* loaded from: classes5.dex */
public final class Nn extends AbstractCallableC0704xh {
    public final int e;
    public final Bundle f;

    public Nn(C0488p0 c0488p0, Zk zk, int i, Bundle bundle) {
        super(c0488p0, zk);
        this.e = i;
        this.f = bundle;
    }

    @Override // io.appmetrica.analytics.impl.AbstractCallableC0704xh
    public final void a(IAppMetricaService iAppMetricaService) {
        iAppMetricaService.reportData(this.e, this.f);
    }
}
