package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.identifiers.PlatformIdentifiers;
import io.appmetrica.analytics.coreapi.internal.identifiers.SdkIdentifiers;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.SdkEnvironmentProvider;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
/* loaded from: classes5.dex */
public final class L5 extends BaseRequestConfig.DataSource {

    /* renamed from: a  reason: collision with root package name */
    public final C0257fm f671a;
    public final SdkEnvironmentProvider b;

    public L5(C0257fm c0257fm, SdkEnvironmentProvider sdkEnvironmentProvider, PlatformIdentifiers platformIdentifiers, Object obj) {
        super(new SdkIdentifiers(c0257fm.c(), c0257fm.a(), c0257fm.b()), sdkEnvironmentProvider, platformIdentifiers, obj);
        this.f671a = c0257fm;
        this.b = sdkEnvironmentProvider;
    }
}
