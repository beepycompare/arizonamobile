package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.internal.IAppMetricaService;
/* loaded from: classes5.dex */
public final class A1 extends IAppMetricaService.Stub {

    /* renamed from: a  reason: collision with root package name */
    public final C1 f447a;

    public A1(C1 c1) {
        this.f447a = c1;
    }

    @Override // io.appmetrica.analytics.internal.IAppMetricaService
    public final void pauseUserSession(Bundle bundle) {
        this.f447a.pauseUserSession(bundle);
    }

    @Override // io.appmetrica.analytics.internal.IAppMetricaService
    public final void reportData(int i, Bundle bundle) {
        this.f447a.reportData(i, bundle);
    }

    @Override // io.appmetrica.analytics.internal.IAppMetricaService
    public final void resumeUserSession(Bundle bundle) {
        this.f447a.resumeUserSession(bundle);
    }
}
