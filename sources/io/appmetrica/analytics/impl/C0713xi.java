package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.xi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0713xi implements InterfaceC0457nb {
    @Override // io.appmetrica.analytics.impl.InterfaceC0457nb, io.appmetrica.analytics.impl.InterfaceC0482ob
    public final InterfaceC0457nb a() {
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0457nb
    public final void a(ReporterConfig reporterConfig) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0457nb
    public final InterfaceC0206db b(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, boolean z) {
        return new Sc();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0457nb
    public final InterfaceC0432mb b(ReporterConfig reporterConfig) {
        return new C0638ui();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0457nb
    public final InterfaceC0206db a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, boolean z) {
        return new Sc();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0457nb
    public final InterfaceC0507pb a(AppMetricaConfig appMetricaConfig) {
        return new C0638ui();
    }
}
