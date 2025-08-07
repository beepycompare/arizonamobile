package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.internal.IAppMetricaService;
/* loaded from: classes4.dex */
public final class Kn extends Kh {
    public final int e;
    public final Bundle f;

    public Kn(C0421m0 c0421m0, Zk zk, int i, Bundle bundle) {
        super(c0421m0, zk);
        this.e = i;
        this.f = bundle;
    }

    @Override // io.appmetrica.analytics.impl.Kh
    public final void a(IAppMetricaService iAppMetricaService) {
        iAppMetricaService.reportData(this.e, this.f);
    }
}
