package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.internal.CounterConfiguration;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* renamed from: io.appmetrica.analytics.impl.t6  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0591t6 {

    /* renamed from: a  reason: collision with root package name */
    public final Bi f1127a;
    public final Kh b;

    public C0591t6(Gf gf, I8 i8, Bi bi, AppMetricaConfig appMetricaConfig) {
        this.f1127a = bi;
        this.b = new Kh(gf, new CounterConfiguration(appMetricaConfig, CounterConfigurationReporterType.CRASH), i8, appMetricaConfig.userProfileID);
    }

    public final Kh a() {
        return this.b;
    }
}
