package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.internal.IAppMetricaService;
/* loaded from: classes4.dex */
public final class Tn extends Th {
    public final int e;
    public final Bundle f;

    public Tn(C0472o0 c0472o0, InterfaceC0337il interfaceC0337il, int i, Bundle bundle) {
        super(c0472o0, interfaceC0337il);
        this.e = i;
        this.f = bundle;
    }

    @Override // io.appmetrica.analytics.impl.Th
    public final void a(IAppMetricaService iAppMetricaService) {
        iAppMetricaService.reportData(this.e, this.f);
    }
}
