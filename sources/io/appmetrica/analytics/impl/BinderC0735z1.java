package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.internal.IAppMetricaService;
/* renamed from: io.appmetrica.analytics.impl.z1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class BinderC0735z1 extends IAppMetricaService.Stub {

    /* renamed from: a  reason: collision with root package name */
    public final B1 f1324a;

    public BinderC0735z1(B1 b1) {
        this.f1324a = b1;
    }

    @Override // io.appmetrica.analytics.internal.IAppMetricaService
    public final void pauseUserSession(Bundle bundle) {
        ((C1) this.f1324a).pauseUserSession(bundle);
    }

    @Override // io.appmetrica.analytics.internal.IAppMetricaService
    public final void reportData(int i, Bundle bundle) {
        ((C1) this.f1324a).reportData(i, bundle);
    }

    @Override // io.appmetrica.analytics.internal.IAppMetricaService
    public final void resumeUserSession(Bundle bundle) {
        ((C1) this.f1324a).resumeUserSession(bundle);
    }
}
