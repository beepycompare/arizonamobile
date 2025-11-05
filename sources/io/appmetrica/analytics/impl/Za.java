package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes3.dex */
public interface Za extends InterfaceC0113ab {
    Pa a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, C0386l0 c0386l0);

    @Override // io.appmetrica.analytics.impl.InterfaceC0113ab
    /* synthetic */ Za a();

    InterfaceC0139bb a(AppMetricaConfig appMetricaConfig);

    void a(ReporterConfig reporterConfig);

    Pa b(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, C0386l0 c0386l0);

    Ya b(ReporterConfig reporterConfig);
}
