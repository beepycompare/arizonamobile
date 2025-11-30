package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.internal.IAppMetricaService;
/* loaded from: classes5.dex */
public final class Fi extends AbstractCallableC0727yh {
    public final Cf e;

    public Fi(C0486p0 c0486p0, InterfaceC0123al interfaceC0123al, Cf cf) {
        super(c0486p0, interfaceC0123al);
        this.e = cf;
    }

    @Override // io.appmetrica.analytics.impl.AbstractCallableC0727yh
    public final void a(IAppMetricaService iAppMetricaService) {
        Bundle bundle = new Bundle();
        Cf cf = this.e;
        synchronized (cf) {
            bundle.putParcelable("PROCESS_CFG_OBJ", cf);
        }
        iAppMetricaService.resumeUserSession(bundle);
    }
}
