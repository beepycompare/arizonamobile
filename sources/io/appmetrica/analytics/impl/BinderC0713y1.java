package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.internal.IAppMetricaService;
/* renamed from: io.appmetrica.analytics.impl.y1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class BinderC0713y1 extends IAppMetricaService.Stub {

    /* renamed from: a  reason: collision with root package name */
    public final A1 f1320a;

    public BinderC0713y1(A1 a1) {
        this.f1320a = a1;
    }

    @Override // io.appmetrica.analytics.internal.IAppMetricaService
    public final void pauseUserSession(Bundle bundle) {
        ((B1) this.f1320a).pauseUserSession(bundle);
    }

    @Override // io.appmetrica.analytics.internal.IAppMetricaService
    public final void reportData(int i, Bundle bundle) {
        ((B1) this.f1320a).reportData(i, bundle);
    }

    @Override // io.appmetrica.analytics.internal.IAppMetricaService
    public final void resumeUserSession(Bundle bundle) {
        ((B1) this.f1320a).resumeUserSession(bundle);
    }
}
