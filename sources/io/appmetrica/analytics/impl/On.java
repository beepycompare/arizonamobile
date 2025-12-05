package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.internal.IAppMetricaService;
/* loaded from: classes5.dex */
public final class On extends AbstractCallableC0726yh {
    public final int e;
    public final Bundle f;

    public On(C0485p0 c0485p0, InterfaceC0122al interfaceC0122al, int i, Bundle bundle) {
        super(c0485p0, interfaceC0122al);
        this.e = i;
        this.f = bundle;
    }

    @Override // io.appmetrica.analytics.impl.AbstractCallableC0726yh
    public final void a(IAppMetricaService iAppMetricaService) {
        iAppMetricaService.reportData(this.e, this.f);
    }
}
