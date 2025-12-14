package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentModuleConfig;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* renamed from: io.appmetrica.analytics.impl.ak  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0121ak implements ServiceComponentModuleConfig {

    /* renamed from: a  reason: collision with root package name */
    public final C0489p4 f900a;

    public C0121ak(C0489p4 c0489p4) {
        this.f900a = c0489p4;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentModuleConfig
    public final boolean isRevenueAutoTrackingEnabled() {
        return ((Boolean) WrapUtils.getOrDefault(this.f900a.m, Boolean.TRUE)).booleanValue();
    }
}
