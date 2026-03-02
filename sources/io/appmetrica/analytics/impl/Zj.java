package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentModuleConfig;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* loaded from: classes5.dex */
public final class Zj implements ServiceComponentModuleConfig {

    /* renamed from: a  reason: collision with root package name */
    public final C0467o4 f890a;

    public Zj(C0467o4 c0467o4) {
        this.f890a = c0467o4;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentModuleConfig
    public final boolean isRevenueAutoTrackingEnabled() {
        return ((Boolean) WrapUtils.getOrDefault(this.f890a.m, Boolean.TRUE)).booleanValue();
    }
}
