package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
/* loaded from: classes5.dex */
public final class Hc extends AbstractC0771zo {
    public final AppMetricaConfig b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Hc(InterfaceC0550rb interfaceC0550rb, AppMetricaConfig appMetricaConfig) {
        super(interfaceC0550rb);
        String str = appMetricaConfig.apiKey;
        this.b = appMetricaConfig;
    }

    public final InterfaceC0602tb a() {
        return this.f1328a.a().a(this.b);
    }
}
