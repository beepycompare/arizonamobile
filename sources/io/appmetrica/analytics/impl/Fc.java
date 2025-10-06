package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
/* loaded from: classes4.dex */
public final class Fc extends AbstractC0186co {
    public final AppMetricaConfig b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Fc(InterfaceC0608tb interfaceC0608tb, AppMetricaConfig appMetricaConfig) {
        super(interfaceC0608tb);
        String str = appMetricaConfig.apiKey;
        this.b = appMetricaConfig;
    }

    public final InterfaceC0633ub a() {
        return this.f831a.a().a(this.b);
    }
}
