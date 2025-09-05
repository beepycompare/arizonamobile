package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.internal.CounterConfiguration;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* loaded from: classes4.dex */
public final class L6 {

    /* renamed from: a  reason: collision with root package name */
    public final Si f549a;
    public final C0153bi b;

    public L6(Vf vf, C0144b9 c0144b9, Si si, AppMetricaConfig appMetricaConfig) {
        this.f549a = si;
        this.b = new C0153bi(vf, new CounterConfiguration(appMetricaConfig, CounterConfigurationReporterType.CRASH), c0144b9, appMetricaConfig.userProfileID);
    }

    public final C0153bi a() {
        return this.b;
    }
}
