package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.internal.IAppMetricaService;
/* loaded from: classes4.dex */
public final class Le extends Th {
    public final Vf e;

    public Le(C0472o0 c0472o0, InterfaceC0337il interfaceC0337il, Vf vf) {
        super(c0472o0, interfaceC0337il);
        this.e = vf;
    }

    @Override // io.appmetrica.analytics.impl.Th
    public final void a(IAppMetricaService iAppMetricaService) {
        Bundle bundle = new Bundle();
        Vf vf = this.e;
        synchronized (vf) {
            bundle.putParcelable("PROCESS_CFG_OBJ", vf);
        }
        iAppMetricaService.pauseUserSession(bundle);
    }
}
