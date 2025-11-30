package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentModuleConfig;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* renamed from: io.appmetrica.analytics.impl.ak  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0122ak implements ServiceComponentModuleConfig {

    /* renamed from: a  reason: collision with root package name */
    public final C0490p4 f803a;

    public C0122ak(C0490p4 c0490p4) {
        this.f803a = c0490p4;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentModuleConfig
    public final boolean isRevenueAutoTrackingEnabled() {
        return ((Boolean) WrapUtils.getOrDefault(this.f803a.m, Boolean.TRUE)).booleanValue();
    }
}
