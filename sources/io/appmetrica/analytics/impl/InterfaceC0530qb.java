package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.qb  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC0530qb extends InterfaceC0555rb {
    InterfaceC0374kb a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, C0441n0 c0441n0);

    @Override // io.appmetrica.analytics.impl.InterfaceC0555rb
    /* synthetic */ InterfaceC0530qb a();

    InterfaceC0607tb a(AppMetricaConfig appMetricaConfig);

    void a(ReporterConfig reporterConfig);

    InterfaceC0374kb b(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, C0441n0 c0441n0);

    InterfaceC0504pb b(ReporterConfig reporterConfig);
}
