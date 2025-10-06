package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes4.dex */
public final class Gi implements InterfaceC0583sb {
    @Override // io.appmetrica.analytics.impl.InterfaceC0583sb, io.appmetrica.analytics.impl.InterfaceC0608tb
    public final InterfaceC0583sb a() {
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0583sb
    public final void a(ReporterConfig reporterConfig) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0583sb
    public final InterfaceC0328ib b(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, C0368k0 c0368k0) {
        return new Xc();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0583sb
    public final InterfaceC0558rb b(ReporterConfig reporterConfig) {
        return new Di();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0583sb
    public final InterfaceC0328ib a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, C0368k0 c0368k0) {
        return new Xc();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0583sb
    public final InterfaceC0633ub a(AppMetricaConfig appMetricaConfig) {
        return new Di();
    }
}
