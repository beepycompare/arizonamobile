package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentModuleConfig;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* renamed from: io.appmetrica.analytics.impl.ek  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0225ek implements ServiceComponentModuleConfig {

    /* renamed from: a  reason: collision with root package name */
    public final C0639v4 f865a;

    public C0225ek(C0639v4 c0639v4) {
        this.f865a = c0639v4;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentModuleConfig
    public final boolean isRevenueAutoTrackingEnabled() {
        return ((Boolean) WrapUtils.getOrDefault(this.f865a.m, Boolean.TRUE)).booleanValue();
    }
}
