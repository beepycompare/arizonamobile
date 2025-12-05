package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes5.dex */
public interface Ta extends Ua {
    Ja a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, C0385l0 c0385l0);

    @Override // io.appmetrica.analytics.impl.Ua
    /* synthetic */ Ta a();

    Va a(AppMetricaConfig appMetricaConfig);

    void a(ReporterConfig reporterConfig);

    Ja b(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, C0385l0 c0385l0);

    Sa b(ReporterConfig reporterConfig);
}
