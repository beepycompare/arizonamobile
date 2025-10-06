package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.sb  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public interface InterfaceC0583sb extends InterfaceC0608tb {
    InterfaceC0328ib a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, C0368k0 c0368k0);

    @Override // io.appmetrica.analytics.impl.InterfaceC0608tb
    /* synthetic */ InterfaceC0583sb a();

    InterfaceC0633ub a(AppMetricaConfig appMetricaConfig);

    void a(ReporterConfig reporterConfig);

    InterfaceC0328ib b(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, C0368k0 c0368k0);

    InterfaceC0558rb b(ReporterConfig reporterConfig);
}
