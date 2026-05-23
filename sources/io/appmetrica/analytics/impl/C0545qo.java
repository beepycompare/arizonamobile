package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.internal.IAppMetricaService;
/* renamed from: io.appmetrica.analytics.impl.qo  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0545qo extends Rh {
    public final int e;
    public final Bundle f;

    public C0545qo(C0546r0 c0546r0, El el, int i, Bundle bundle) {
        super(c0546r0, el);
        this.e = i;
        this.f = bundle;
    }

    @Override // io.appmetrica.analytics.impl.Rh
    public final void a(IAppMetricaService iAppMetricaService) {
        iAppMetricaService.reportData(this.e, this.f);
    }
}
