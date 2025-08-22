package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.internal.IAppMetricaService;
/* loaded from: classes4.dex */
public final class Wi extends Ph {
    public final Rf e;

    public Wi(C0418m0 c0418m0, InterfaceC0233el interfaceC0233el, Rf rf) {
        super(c0418m0, interfaceC0233el);
        this.e = rf;
    }

    @Override // io.appmetrica.analytics.impl.Ph
    public final void a(IAppMetricaService iAppMetricaService) {
        Bundle bundle = new Bundle();
        Rf rf = this.e;
        synchronized (rf) {
            bundle.putParcelable("PROCESS_CFG_OBJ", rf);
        }
        iAppMetricaService.resumeUserSession(bundle);
    }
}
