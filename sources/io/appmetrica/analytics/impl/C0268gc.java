package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
/* renamed from: io.appmetrica.analytics.impl.gc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0268gc extends Xn {
    public final AppMetricaConfig b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0268gc(Ua ua, AppMetricaConfig appMetricaConfig) {
        super(ua);
        String str = appMetricaConfig.apiKey;
        this.b = appMetricaConfig;
    }

    public final Va a() {
        return this.f839a.a().a(this.b);
    }
}
