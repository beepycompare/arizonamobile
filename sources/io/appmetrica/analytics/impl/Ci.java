package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes4.dex */
public final class Ci implements InterfaceC0504pb {
    @Override // io.appmetrica.analytics.impl.InterfaceC0504pb, io.appmetrica.analytics.impl.InterfaceC0529qb
    public final InterfaceC0504pb a() {
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0504pb
    public final void a(ReporterConfig reporterConfig) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0504pb
    public final InterfaceC0249fb b(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, boolean z) {
        return new Uc();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0504pb
    public final InterfaceC0479ob b(ReporterConfig reporterConfig) {
        return new C0760zi();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0504pb
    public final InterfaceC0249fb a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, boolean z) {
        return new Uc();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0504pb
    public final InterfaceC0553rb a(AppMetricaConfig appMetricaConfig) {
        return new C0760zi();
    }
}
