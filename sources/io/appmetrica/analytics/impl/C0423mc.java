package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
/* renamed from: io.appmetrica.analytics.impl.mc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0423mc extends Yn {
    public final AppMetricaConfig b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0423mc(InterfaceC0113ab interfaceC0113ab, AppMetricaConfig appMetricaConfig) {
        super(interfaceC0113ab);
        String str = appMetricaConfig.apiKey;
        this.b = appMetricaConfig;
    }

    public final InterfaceC0139bb a() {
        return this.f776a.a().a(this.b);
    }
}
