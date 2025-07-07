package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.lb  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public interface InterfaceC0412lb extends InterfaceC0437mb {
    InterfaceC0161bb a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, boolean z);

    @Override // io.appmetrica.analytics.impl.InterfaceC0437mb
    /* synthetic */ InterfaceC0412lb a();

    InterfaceC0462nb a(AppMetricaConfig appMetricaConfig);

    void a(ReporterConfig reporterConfig);

    InterfaceC0161bb b(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, boolean z);

    InterfaceC0387kb b(ReporterConfig reporterConfig);
}
