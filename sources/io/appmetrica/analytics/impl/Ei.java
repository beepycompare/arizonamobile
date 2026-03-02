package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.internal.IAppMetricaService;
/* loaded from: classes5.dex */
public final class Ei extends AbstractCallableC0704xh {
    public final Bf e;

    public Ei(C0488p0 c0488p0, Zk zk, Bf bf) {
        super(c0488p0, zk);
        this.e = bf;
    }

    @Override // io.appmetrica.analytics.impl.AbstractCallableC0704xh
    public final void a(IAppMetricaService iAppMetricaService) {
        Bundle bundle = new Bundle();
        Bf bf = this.e;
        synchronized (bf) {
            bundle.putParcelable("PROCESS_CFG_OBJ", bf);
        }
        iAppMetricaService.resumeUserSession(bundle);
    }
}
