package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes5.dex */
public final class Ei implements InterfaceC0531qb {
    @Override // io.appmetrica.analytics.impl.InterfaceC0531qb, io.appmetrica.analytics.impl.InterfaceC0556rb
    public final InterfaceC0531qb a() {
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0531qb
    public final void a(ReporterConfig reporterConfig) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0531qb
    public final InterfaceC0375kb b(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, C0442n0 c0442n0) {
        return new Yc();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0531qb
    public final InterfaceC0505pb b(ReporterConfig reporterConfig) {
        return new Bi();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0531qb
    public final InterfaceC0375kb a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, C0442n0 c0442n0) {
        return new Yc();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0531qb
    public final InterfaceC0608tb a(AppMetricaConfig appMetricaConfig) {
        return new Bi();
    }
}
