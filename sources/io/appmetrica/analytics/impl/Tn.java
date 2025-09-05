package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.internal.IAppMetricaService;
/* loaded from: classes4.dex */
public final class Tn extends Th {
    public final int e;
    public final Bundle f;

    public Tn(C0471o0 c0471o0, InterfaceC0336il interfaceC0336il, int i, Bundle bundle) {
        super(c0471o0, interfaceC0336il);
        this.e = i;
        this.f = bundle;
    }

    @Override // io.appmetrica.analytics.impl.Th
    public final void a(IAppMetricaService iAppMetricaService) {
        iAppMetricaService.reportData(this.e, this.f);
    }
}
