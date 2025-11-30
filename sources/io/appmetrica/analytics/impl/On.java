package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.internal.IAppMetricaService;
/* loaded from: classes5.dex */
public final class On extends AbstractCallableC0727yh {
    public final int e;
    public final Bundle f;

    public On(C0486p0 c0486p0, InterfaceC0123al interfaceC0123al, int i, Bundle bundle) {
        super(c0486p0, interfaceC0123al);
        this.e = i;
        this.f = bundle;
    }

    @Override // io.appmetrica.analytics.impl.AbstractCallableC0727yh
    public final void a(IAppMetricaService iAppMetricaService) {
        iAppMetricaService.reportData(this.e, this.f);
    }
}
