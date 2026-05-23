package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.internal.CounterConfiguration;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* loaded from: classes5.dex */
public final class C6 {

    /* renamed from: a  reason: collision with root package name */
    public final Qi f488a;
    public final Zh b;

    public C6(C0175cg c0175cg, W8 w8, Qi qi, AppMetricaConfig appMetricaConfig) {
        this.f488a = qi;
        this.b = new Zh(c0175cg, new CounterConfiguration(appMetricaConfig, CounterConfigurationReporterType.CRASH), w8, appMetricaConfig.userProfileID);
    }

    public final Zh a() {
        return this.b;
    }
}
