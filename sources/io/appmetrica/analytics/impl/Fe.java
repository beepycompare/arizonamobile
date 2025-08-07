package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.internal.IAppMetricaService;
/* loaded from: classes4.dex */
public final class Fe extends Kh {
    public final Pf e;

    public Fe(C0421m0 c0421m0, Zk zk, Pf pf) {
        super(c0421m0, zk);
        this.e = pf;
    }

    @Override // io.appmetrica.analytics.impl.Kh
    public final void a(IAppMetricaService iAppMetricaService) {
        Bundle bundle = new Bundle();
        Pf pf = this.e;
        synchronized (pf) {
            bundle.putParcelable("PROCESS_CFG_OBJ", pf);
        }
        iAppMetricaService.pauseUserSession(bundle);
    }
}
