package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentModuleConfig;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* loaded from: classes5.dex */
public final class Bk implements ServiceComponentModuleConfig {

    /* renamed from: a  reason: collision with root package name */
    public final F4 f482a;

    public Bk(F4 f4) {
        this.f482a = f4;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentModuleConfig
    public final boolean isRevenueAutoTrackingEnabled() {
        return ((Boolean) WrapUtils.getOrDefault(this.f482a.m, Boolean.TRUE)).booleanValue();
    }
}
