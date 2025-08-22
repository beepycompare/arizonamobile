package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.internal.CounterConfiguration;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* loaded from: classes4.dex */
public final class I6 {

    /* renamed from: a  reason: collision with root package name */
    public final Oi f491a;
    public final Xh b;

    public I6(Rf rf, Y8 y8, Oi oi, AppMetricaConfig appMetricaConfig) {
        this.f491a = oi;
        this.b = new Xh(rf, new CounterConfiguration(appMetricaConfig, CounterConfigurationReporterType.CRASH), y8, appMetricaConfig.userProfileID);
    }

    public final Xh a() {
        return this.b;
    }
}
