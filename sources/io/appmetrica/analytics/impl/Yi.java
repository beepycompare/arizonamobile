package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.internal.IAppMetricaService;
/* loaded from: classes5.dex */
public final class Yi extends Rh {
    public final C0175cg e;

    public Yi(C0546r0 c0546r0, El el, C0175cg c0175cg) {
        super(c0546r0, el);
        this.e = c0175cg;
    }

    @Override // io.appmetrica.analytics.impl.Rh
    public final void a(IAppMetricaService iAppMetricaService) {
        Bundle bundle = new Bundle();
        C0175cg c0175cg = this.e;
        synchronized (c0175cg) {
            bundle.putParcelable("PROCESS_CFG_OBJ", c0175cg);
        }
        iAppMetricaService.resumeUserSession(bundle);
    }
}
