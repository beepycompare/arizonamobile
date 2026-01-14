package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.ki  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0382ki implements Sa {
    @Override // io.appmetrica.analytics.impl.Sa, io.appmetrica.analytics.impl.Ta
    public final Sa a() {
        return this;
    }

    @Override // io.appmetrica.analytics.impl.Sa
    public final void a(ReporterConfig reporterConfig) {
    }

    @Override // io.appmetrica.analytics.impl.Sa
    public final Ia b(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, C0389l0 c0389l0) {
        return new C0700xc();
    }

    @Override // io.appmetrica.analytics.impl.Sa
    public final Ra b(ReporterConfig reporterConfig) {
        return new C0305hi();
    }

    @Override // io.appmetrica.analytics.impl.Sa
    public final Ia a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, C0389l0 c0389l0) {
        return new C0700xc();
    }

    @Override // io.appmetrica.analytics.impl.Sa
    public final Ua a(AppMetricaConfig appMetricaConfig) {
        return new C0305hi();
    }
}
