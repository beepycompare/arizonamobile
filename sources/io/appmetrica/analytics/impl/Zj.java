package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentModuleConfig;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* loaded from: classes5.dex */
public final class Zj implements ServiceComponentModuleConfig {

    /* renamed from: a  reason: collision with root package name */
    public final C0468o4 f891a;

    public Zj(C0468o4 c0468o4) {
        this.f891a = c0468o4;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentModuleConfig
    public final boolean isRevenueAutoTrackingEnabled() {
        return ((Boolean) WrapUtils.getOrDefault(this.f891a.m, Boolean.TRUE)).booleanValue();
    }
}
