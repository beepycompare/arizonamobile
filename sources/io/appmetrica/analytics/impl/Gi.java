package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes4.dex */
public final class Gi implements InterfaceC0582sb {
    @Override // io.appmetrica.analytics.impl.InterfaceC0582sb, io.appmetrica.analytics.impl.InterfaceC0607tb
    public final InterfaceC0582sb a() {
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0582sb
    public final void a(ReporterConfig reporterConfig) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0582sb
    public final InterfaceC0327ib b(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, C0367k0 c0367k0) {
        return new Xc();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0582sb
    public final InterfaceC0557rb b(ReporterConfig reporterConfig) {
        return new Di();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0582sb
    public final InterfaceC0327ib a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, C0367k0 c0367k0) {
        return new Xc();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0582sb
    public final InterfaceC0632ub a(AppMetricaConfig appMetricaConfig) {
        return new Di();
    }
}
