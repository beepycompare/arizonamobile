package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.nb  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public interface InterfaceC0456nb extends InterfaceC0481ob {
    InterfaceC0205db a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, boolean z);

    @Override // io.appmetrica.analytics.impl.InterfaceC0481ob
    /* synthetic */ InterfaceC0456nb a();

    InterfaceC0506pb a(AppMetricaConfig appMetricaConfig);

    void a(ReporterConfig reporterConfig);

    InterfaceC0205db b(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, boolean z);

    InterfaceC0431mb b(ReporterConfig reporterConfig);
}
