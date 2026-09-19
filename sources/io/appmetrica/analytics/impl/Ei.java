package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes5.dex */
public final class Ei implements InterfaceC0530qb {
    @Override // io.appmetrica.analytics.impl.InterfaceC0530qb, io.appmetrica.analytics.impl.InterfaceC0555rb
    public final InterfaceC0530qb a() {
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0530qb
    public final void a(ReporterConfig reporterConfig) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0530qb
    public final InterfaceC0374kb b(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, C0441n0 c0441n0) {
        return new Yc();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0530qb
    public final InterfaceC0504pb b(ReporterConfig reporterConfig) {
        return new Bi();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0530qb
    public final InterfaceC0374kb a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, C0441n0 c0441n0) {
        return new Yc();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0530qb
    public final InterfaceC0607tb a(AppMetricaConfig appMetricaConfig) {
        return new Bi();
    }
}
