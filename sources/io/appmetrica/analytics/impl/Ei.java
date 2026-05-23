package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes5.dex */
public final class Ei implements InterfaceC0532qb {
    @Override // io.appmetrica.analytics.impl.InterfaceC0532qb, io.appmetrica.analytics.impl.InterfaceC0557rb
    public final InterfaceC0532qb a() {
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0532qb
    public final void a(ReporterConfig reporterConfig) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0532qb
    public final InterfaceC0376kb b(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, C0443n0 c0443n0) {
        return new Yc();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0532qb
    public final InterfaceC0506pb b(ReporterConfig reporterConfig) {
        return new Bi();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0532qb
    public final InterfaceC0376kb a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, C0443n0 c0443n0) {
        return new Yc();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0532qb
    public final InterfaceC0609tb a(AppMetricaConfig appMetricaConfig) {
        return new Bi();
    }
}
