package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
/* loaded from: classes5.dex */
public final class Hc extends AbstractC0777zo {
    public final AppMetricaConfig b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Hc(InterfaceC0556rb interfaceC0556rb, AppMetricaConfig appMetricaConfig) {
        super(interfaceC0556rb);
        String str = appMetricaConfig.apiKey;
        this.b = appMetricaConfig;
    }

    public final InterfaceC0608tb a() {
        return this.f1325a.a().a(this.b);
    }
}
