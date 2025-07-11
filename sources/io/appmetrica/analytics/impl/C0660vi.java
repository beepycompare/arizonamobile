package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.vi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0660vi implements InterfaceC0404lb {
    @Override // io.appmetrica.analytics.impl.InterfaceC0404lb, io.appmetrica.analytics.impl.InterfaceC0429mb
    public final InterfaceC0404lb a() {
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0404lb
    public final void a(ReporterConfig reporterConfig) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0404lb
    public final InterfaceC0153bb b(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, boolean z) {
        return new Qc();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0404lb
    public final InterfaceC0379kb b(ReporterConfig reporterConfig) {
        return new C0585si();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0404lb
    public final InterfaceC0153bb a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, boolean z) {
        return new Qc();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0404lb
    public final InterfaceC0454nb a(AppMetricaConfig appMetricaConfig) {
        return new C0585si();
    }
}
