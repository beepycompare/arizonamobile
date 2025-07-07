package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
/* renamed from: io.appmetrica.analytics.impl.yc  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0737yc extends Qn {
    public final AppMetricaConfig b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0737yc(InterfaceC0437mb interfaceC0437mb, AppMetricaConfig appMetricaConfig) {
        super(interfaceC0437mb);
        String str = appMetricaConfig.apiKey;
        this.b = appMetricaConfig;
    }

    public final InterfaceC0462nb a() {
        return this.f599a.a().a(this.b);
    }
}
