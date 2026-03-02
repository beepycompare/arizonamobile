package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.internal.IAppMetricaService;
/* renamed from: io.appmetrica.analytics.impl.re  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0551re extends AbstractCallableC0704xh {
    public final Bf e;

    public C0551re(C0488p0 c0488p0, Zk zk, Bf bf) {
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
        iAppMetricaService.pauseUserSession(bundle);
    }
}
