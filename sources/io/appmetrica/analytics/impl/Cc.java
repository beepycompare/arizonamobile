package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
/* loaded from: classes4.dex */
public final class Cc extends Yn {
    public final AppMetricaConfig b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Cc(InterfaceC0529qb interfaceC0529qb, AppMetricaConfig appMetricaConfig) {
        super(interfaceC0529qb);
        String str = appMetricaConfig.apiKey;
        this.b = appMetricaConfig;
    }

    public final InterfaceC0553rb a() {
        return this.f748a.a().a(this.b);
    }
}
