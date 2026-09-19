package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.internal.IAppMetricaService;
/* loaded from: classes5.dex */
public final class Se extends Rh {
    public final C0173cg e;

    public Se(C0544r0 c0544r0, El el, C0173cg c0173cg) {
        super(c0544r0, el);
        this.e = c0173cg;
    }

    @Override // io.appmetrica.analytics.impl.Rh
    public final void a(IAppMetricaService iAppMetricaService) {
        Bundle bundle = new Bundle();
        C0173cg c0173cg = this.e;
        synchronized (c0173cg) {
            bundle.putParcelable("PROCESS_CFG_OBJ", c0173cg);
        }
        iAppMetricaService.pauseUserSession(bundle);
    }
}
