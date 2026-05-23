package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentModuleConfig;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* loaded from: classes5.dex */
public final class Bk implements ServiceComponentModuleConfig {

    /* renamed from: a  reason: collision with root package name */
    public final F4 f479a;

    public Bk(F4 f4) {
        this.f479a = f4;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentModuleConfig
    public final boolean isRevenueAutoTrackingEnabled() {
        return ((Boolean) WrapUtils.getOrDefault(this.f479a.m, Boolean.TRUE)).booleanValue();
    }
}
