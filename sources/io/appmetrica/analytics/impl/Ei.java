package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes5.dex */
public final class Ei implements InterfaceC0525qb {
    @Override // io.appmetrica.analytics.impl.InterfaceC0525qb, io.appmetrica.analytics.impl.InterfaceC0550rb
    public final InterfaceC0525qb a() {
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0525qb
    public final void a(ReporterConfig reporterConfig) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0525qb
    public final InterfaceC0369kb b(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, C0436n0 c0436n0) {
        return new Yc();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0525qb
    public final InterfaceC0499pb b(ReporterConfig reporterConfig) {
        return new Bi();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0525qb
    public final InterfaceC0369kb a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, C0436n0 c0436n0) {
        return new Yc();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0525qb
    public final InterfaceC0602tb a(AppMetricaConfig appMetricaConfig) {
        return new Bi();
    }
}
