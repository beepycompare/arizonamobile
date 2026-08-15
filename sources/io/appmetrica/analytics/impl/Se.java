package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.internal.IAppMetricaService;
/* loaded from: classes5.dex */
public final class Se extends Rh {
    public final C0174cg e;

    public Se(C0545r0 c0545r0, El el, C0174cg c0174cg) {
        super(c0545r0, el);
        this.e = c0174cg;
    }

    @Override // io.appmetrica.analytics.impl.Rh
    public final void a(IAppMetricaService iAppMetricaService) {
        Bundle bundle = new Bundle();
        C0174cg c0174cg = this.e;
        synchronized (c0174cg) {
            bundle.putParcelable("PROCESS_CFG_OBJ", c0174cg);
        }
        iAppMetricaService.pauseUserSession(bundle);
    }
}
