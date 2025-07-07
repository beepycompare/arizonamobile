package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.internal.IAppMetricaService;
/* loaded from: classes4.dex */
public final class De extends Ih {
    public final Nf e;

    public De(C0426m0 c0426m0, Wk wk, Nf nf) {
        super(c0426m0, wk);
        this.e = nf;
    }

    @Override // io.appmetrica.analytics.impl.Ih
    public final void a(IAppMetricaService iAppMetricaService) {
        Bundle bundle = new Bundle();
        Nf nf = this.e;
        synchronized (nf) {
            bundle.putParcelable("PROCESS_CFG_OBJ", nf);
        }
        iAppMetricaService.pauseUserSession(bundle);
    }
}
