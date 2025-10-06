package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.internal.CounterConfiguration;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* loaded from: classes4.dex */
public final class L6 {

    /* renamed from: a  reason: collision with root package name */
    public final Si f554a;
    public final C0154bi b;

    public L6(Vf vf, C0145b9 c0145b9, Si si, AppMetricaConfig appMetricaConfig) {
        this.f554a = si;
        this.b = new C0154bi(vf, new CounterConfiguration(appMetricaConfig, CounterConfigurationReporterType.CRASH), c0145b9, appMetricaConfig.userProfileID);
    }

    public final C0154bi a() {
        return this.b;
    }
}
