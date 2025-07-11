package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
/* renamed from: io.appmetrica.analytics.impl.yc  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0729yc extends Qn {
    public final AppMetricaConfig b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0729yc(InterfaceC0429mb interfaceC0429mb, AppMetricaConfig appMetricaConfig) {
        super(interfaceC0429mb);
        String str = appMetricaConfig.apiKey;
        this.b = appMetricaConfig;
    }

    public final InterfaceC0454nb a() {
        return this.f600a.a().a(this.b);
    }
}
