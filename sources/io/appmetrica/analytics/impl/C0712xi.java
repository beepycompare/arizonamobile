package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.xi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0712xi implements InterfaceC0456nb {
    @Override // io.appmetrica.analytics.impl.InterfaceC0456nb, io.appmetrica.analytics.impl.InterfaceC0481ob
    public final InterfaceC0456nb a() {
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0456nb
    public final void a(ReporterConfig reporterConfig) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0456nb
    public final InterfaceC0205db b(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, boolean z) {
        return new Sc();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0456nb
    public final InterfaceC0431mb b(ReporterConfig reporterConfig) {
        return new C0637ui();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0456nb
    public final InterfaceC0205db a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, boolean z) {
        return new Sc();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0456nb
    public final InterfaceC0506pb a(AppMetricaConfig appMetricaConfig) {
        return new C0637ui();
    }
}
