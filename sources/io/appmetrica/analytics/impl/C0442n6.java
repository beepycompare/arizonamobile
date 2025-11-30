package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.internal.CounterConfiguration;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* renamed from: io.appmetrica.analytics.impl.n6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0442n6 {

    /* renamed from: a  reason: collision with root package name */
    public final C0703xi f1024a;
    public final Gh b;

    public C0442n6(Cf cf, E8 e8, C0703xi c0703xi, AppMetricaConfig appMetricaConfig) {
        this.f1024a = c0703xi;
        this.b = new Gh(cf, new CounterConfiguration(appMetricaConfig, CounterConfigurationReporterType.CRASH), e8, appMetricaConfig.userProfileID);
    }

    public final Gh a() {
        return this.b;
    }
}
