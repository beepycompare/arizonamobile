package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.internal.IAppMetricaService;
/* renamed from: io.appmetrica.analytics.impl.aj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0128aj extends Th {
    public final Vf e;

    public C0128aj(C0471o0 c0471o0, InterfaceC0336il interfaceC0336il, Vf vf) {
        super(c0471o0, interfaceC0336il);
        this.e = vf;
    }

    @Override // io.appmetrica.analytics.impl.Th
    public final void a(IAppMetricaService iAppMetricaService) {
        Bundle bundle = new Bundle();
        Vf vf = this.e;
        synchronized (vf) {
            bundle.putParcelable("PROCESS_CFG_OBJ", vf);
        }
        iAppMetricaService.resumeUserSession(bundle);
    }
}
