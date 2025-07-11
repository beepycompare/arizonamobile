package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.lb  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public interface InterfaceC0404lb extends InterfaceC0429mb {
    InterfaceC0153bb a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, boolean z);

    @Override // io.appmetrica.analytics.impl.InterfaceC0429mb
    /* synthetic */ InterfaceC0404lb a();

    InterfaceC0454nb a(AppMetricaConfig appMetricaConfig);

    void a(ReporterConfig reporterConfig);

    InterfaceC0153bb b(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, boolean z);

    InterfaceC0379kb b(ReporterConfig reporterConfig);
}
