package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.internal.IAppMetricaService;
/* renamed from: io.appmetrica.analytics.impl.xe  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0699xe extends Ch {
    public final Gf e;

    public C0699xe(C0486p0 c0486p0, InterfaceC0201dl interfaceC0201dl, Gf gf) {
        super(c0486p0, interfaceC0201dl);
        this.e = gf;
    }

    @Override // io.appmetrica.analytics.impl.Ch
    public final void a(IAppMetricaService iAppMetricaService) {
        Bundle bundle = new Bundle();
        Gf gf = this.e;
        synchronized (gf) {
            bundle.putParcelable("PROCESS_CFG_OBJ", gf);
        }
        iAppMetricaService.pauseUserSession(bundle);
    }
}
