package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.qb  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC0525qb extends InterfaceC0550rb {
    InterfaceC0369kb a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, C0436n0 c0436n0);

    @Override // io.appmetrica.analytics.impl.InterfaceC0550rb
    /* synthetic */ InterfaceC0525qb a();

    InterfaceC0602tb a(AppMetricaConfig appMetricaConfig);

    void a(ReporterConfig reporterConfig);

    InterfaceC0369kb b(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, C0436n0 c0436n0);

    InterfaceC0499pb b(ReporterConfig reporterConfig);
}
