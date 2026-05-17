package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.internal.CounterConfiguration;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* renamed from: io.appmetrica.analytics.impl.m6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0419m6 {

    /* renamed from: a  reason: collision with root package name */
    public final C0680wi f1116a;
    public final Fh b;

    public C0419m6(Bf bf, D8 d8, C0680wi c0680wi, AppMetricaConfig appMetricaConfig) {
        this.f1116a = c0680wi;
        this.b = new Fh(bf, new CounterConfiguration(appMetricaConfig, CounterConfigurationReporterType.CRASH), d8, appMetricaConfig.userProfileID);
    }

    public final Fh a() {
        return this.b;
    }
}
