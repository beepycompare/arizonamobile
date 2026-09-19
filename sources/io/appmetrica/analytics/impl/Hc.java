package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
/* loaded from: classes5.dex */
public final class Hc extends AbstractC0776zo {
    public final AppMetricaConfig b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Hc(InterfaceC0555rb interfaceC0555rb, AppMetricaConfig appMetricaConfig) {
        super(interfaceC0555rb);
        String str = appMetricaConfig.apiKey;
        this.b = appMetricaConfig;
    }

    public final InterfaceC0607tb a() {
        return this.f1325a.a().a(this.b);
    }
}
