package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
/* loaded from: classes5.dex */
public final class Hc extends AbstractC0778zo {
    public final AppMetricaConfig b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Hc(InterfaceC0557rb interfaceC0557rb, AppMetricaConfig appMetricaConfig) {
        super(interfaceC0557rb);
        String str = appMetricaConfig.apiKey;
        this.b = appMetricaConfig;
    }

    public final InterfaceC0609tb a() {
        return this.f1323a.a().a(this.b);
    }
}
