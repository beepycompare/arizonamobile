package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
/* renamed from: io.appmetrica.analytics.impl.fc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0247fc extends Wn {
    public final AppMetricaConfig b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0247fc(Ta ta, AppMetricaConfig appMetricaConfig) {
        super(ta);
        String str = appMetricaConfig.apiKey;
        this.b = appMetricaConfig;
    }

    public final Ua a() {
        return this.f845a.a().a(this.b);
    }
}
