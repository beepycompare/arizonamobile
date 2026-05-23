package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.qb  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC0532qb extends InterfaceC0557rb {
    InterfaceC0376kb a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, C0443n0 c0443n0);

    @Override // io.appmetrica.analytics.impl.InterfaceC0557rb
    /* synthetic */ InterfaceC0532qb a();

    InterfaceC0609tb a(AppMetricaConfig appMetricaConfig);

    void a(ReporterConfig reporterConfig);

    InterfaceC0376kb b(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, C0443n0 c0443n0);

    InterfaceC0506pb b(ReporterConfig reporterConfig);
}
