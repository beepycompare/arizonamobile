package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.pb  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public interface InterfaceC0504pb extends InterfaceC0529qb {
    InterfaceC0249fb a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, boolean z);

    @Override // io.appmetrica.analytics.impl.InterfaceC0529qb
    /* synthetic */ InterfaceC0504pb a();

    InterfaceC0553rb a(AppMetricaConfig appMetricaConfig);

    void a(ReporterConfig reporterConfig);

    InterfaceC0249fb b(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, boolean z);

    InterfaceC0479ob b(ReporterConfig reporterConfig);
}
