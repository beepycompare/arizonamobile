package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.internal.IAppMetricaService;
/* renamed from: io.appmetrica.analytics.impl.se  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0573se extends AbstractCallableC0726yh {
    public final Cf e;

    public C0573se(C0485p0 c0485p0, InterfaceC0122al interfaceC0122al, Cf cf) {
        super(c0485p0, interfaceC0122al);
        this.e = cf;
    }

    @Override // io.appmetrica.analytics.impl.AbstractCallableC0726yh
    public final void a(IAppMetricaService iAppMetricaService) {
        Bundle bundle = new Bundle();
        Cf cf = this.e;
        synchronized (cf) {
            bundle.putParcelable("PROCESS_CFG_OBJ", cf);
        }
        iAppMetricaService.pauseUserSession(bundle);
    }
}
