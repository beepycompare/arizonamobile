package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.qb  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC0531qb extends InterfaceC0556rb {
    InterfaceC0375kb a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, C0442n0 c0442n0);

    @Override // io.appmetrica.analytics.impl.InterfaceC0556rb
    /* synthetic */ InterfaceC0531qb a();

    InterfaceC0608tb a(AppMetricaConfig appMetricaConfig);

    void a(ReporterConfig reporterConfig);

    InterfaceC0375kb b(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, C0442n0 c0442n0);

    InterfaceC0505pb b(ReporterConfig reporterConfig);
}
