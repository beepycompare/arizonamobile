package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
/* loaded from: classes4.dex */
public final class Ac extends Tn {
    public final AppMetricaConfig b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Ac(InterfaceC0481ob interfaceC0481ob, AppMetricaConfig appMetricaConfig) {
        super(interfaceC0481ob);
        String str = appMetricaConfig.apiKey;
        this.b = appMetricaConfig;
    }

    public final InterfaceC0506pb a() {
        return this.f659a.a().a(this.b);
    }
}
