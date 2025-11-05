package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.internal.IAppMetricaService;
/* loaded from: classes3.dex */
public final class Pn extends Ch {
    public final int e;
    public final Bundle f;

    public Pn(C0486p0 c0486p0, InterfaceC0201dl interfaceC0201dl, int i, Bundle bundle) {
        super(c0486p0, interfaceC0201dl);
        this.e = i;
        this.f = bundle;
    }

    @Override // io.appmetrica.analytics.impl.Ch
    public final void a(IAppMetricaService iAppMetricaService) {
        iAppMetricaService.reportData(this.e, this.f);
    }
}
