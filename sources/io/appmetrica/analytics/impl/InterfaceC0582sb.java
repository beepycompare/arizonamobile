package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.sb  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public interface InterfaceC0582sb extends InterfaceC0607tb {
    InterfaceC0327ib a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, C0367k0 c0367k0);

    @Override // io.appmetrica.analytics.impl.InterfaceC0607tb
    /* synthetic */ InterfaceC0582sb a();

    InterfaceC0632ub a(AppMetricaConfig appMetricaConfig);

    void a(ReporterConfig reporterConfig);

    InterfaceC0327ib b(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, C0367k0 c0367k0);

    InterfaceC0557rb b(ReporterConfig reporterConfig);
}
