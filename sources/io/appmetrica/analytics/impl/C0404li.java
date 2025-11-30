package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.li  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0404li implements Ta {
    @Override // io.appmetrica.analytics.impl.Ta, io.appmetrica.analytics.impl.Ua
    public final Ta a() {
        return this;
    }

    @Override // io.appmetrica.analytics.impl.Ta
    public final void a(ReporterConfig reporterConfig) {
    }

    @Override // io.appmetrica.analytics.impl.Ta
    public final Ja b(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, C0386l0 c0386l0) {
        return new C0722yc();
    }

    @Override // io.appmetrica.analytics.impl.Ta
    public final Sa b(ReporterConfig reporterConfig) {
        return new C0326ii();
    }

    @Override // io.appmetrica.analytics.impl.Ta
    public final Ja a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, C0386l0 c0386l0) {
        return new C0722yc();
    }

    @Override // io.appmetrica.analytics.impl.Ta
    public final Va a(AppMetricaConfig appMetricaConfig) {
        return new C0326ii();
    }
}
