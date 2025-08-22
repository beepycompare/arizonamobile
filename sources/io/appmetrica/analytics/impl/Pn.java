package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.internal.IAppMetricaService;
/* loaded from: classes4.dex */
public final class Pn extends Ph {
    public final int e;
    public final Bundle f;

    public Pn(C0418m0 c0418m0, InterfaceC0233el interfaceC0233el, int i, Bundle bundle) {
        super(c0418m0, interfaceC0233el);
        this.e = i;
        this.f = bundle;
    }

    @Override // io.appmetrica.analytics.impl.Ph
    public final void a(IAppMetricaService iAppMetricaService) {
        iAppMetricaService.reportData(this.e, this.f);
    }
}
