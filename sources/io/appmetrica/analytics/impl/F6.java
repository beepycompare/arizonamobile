package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.internal.CounterConfiguration;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* loaded from: classes4.dex */
public final class F6 {

    /* renamed from: a  reason: collision with root package name */
    public final Gi f424a;
    public final Qh b;

    public F6(Nf nf, T8 t8, Gi gi, AppMetricaConfig appMetricaConfig) {
        this.f424a = gi;
        this.b = new Qh(nf, new CounterConfiguration(appMetricaConfig, CounterConfigurationReporterType.CRASH), t8, appMetricaConfig.userProfileID);
    }

    public final Qh a() {
        return this.b;
    }
}
