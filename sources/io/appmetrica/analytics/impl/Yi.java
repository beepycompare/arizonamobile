package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.internal.IAppMetricaService;
/* loaded from: classes5.dex */
public final class Yi extends Rh {
    public final C0168cg e;

    public Yi(C0539r0 c0539r0, El el, C0168cg c0168cg) {
        super(c0539r0, el);
        this.e = c0168cg;
    }

    @Override // io.appmetrica.analytics.impl.Rh
    public final void a(IAppMetricaService iAppMetricaService) {
        Bundle bundle = new Bundle();
        C0168cg c0168cg = this.e;
        synchronized (c0168cg) {
            bundle.putParcelable("PROCESS_CFG_OBJ", c0168cg);
        }
        iAppMetricaService.resumeUserSession(bundle);
    }
}
