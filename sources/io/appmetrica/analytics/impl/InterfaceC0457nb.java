package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.nb  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public interface InterfaceC0457nb extends InterfaceC0482ob {
    InterfaceC0206db a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, boolean z);

    @Override // io.appmetrica.analytics.impl.InterfaceC0482ob
    /* synthetic */ InterfaceC0457nb a();

    InterfaceC0507pb a(AppMetricaConfig appMetricaConfig);

    void a(ReporterConfig reporterConfig);

    InterfaceC0206db b(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, boolean z);

    InterfaceC0432mb b(ReporterConfig reporterConfig);
}
