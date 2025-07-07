package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.vi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0668vi implements InterfaceC0412lb {
    @Override // io.appmetrica.analytics.impl.InterfaceC0412lb, io.appmetrica.analytics.impl.InterfaceC0437mb
    public final InterfaceC0412lb a() {
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0412lb
    public final void a(ReporterConfig reporterConfig) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0412lb
    public final InterfaceC0161bb b(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, boolean z) {
        return new Qc();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0412lb
    public final InterfaceC0387kb b(ReporterConfig reporterConfig) {
        return new C0593si();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0412lb
    public final InterfaceC0161bb a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, boolean z) {
        return new Qc();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0412lb
    public final InterfaceC0462nb a(AppMetricaConfig appMetricaConfig) {
        return new C0593si();
    }
}
