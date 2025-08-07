package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
/* loaded from: classes4.dex */
public final class Ac extends Tn {
    public final AppMetricaConfig b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Ac(InterfaceC0482ob interfaceC0482ob, AppMetricaConfig appMetricaConfig) {
        super(interfaceC0482ob);
        String str = appMetricaConfig.apiKey;
        this.b = appMetricaConfig;
    }

    public final InterfaceC0507pb a() {
        return this.f659a.a().a(this.b);
    }
}
