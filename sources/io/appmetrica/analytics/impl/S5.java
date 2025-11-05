package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.identifiers.PlatformIdentifiers;
import io.appmetrica.analytics.coreapi.internal.identifiers.SdkIdentifiers;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.SdkEnvironmentProvider;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
/* loaded from: classes3.dex */
public final class S5 extends BaseRequestConfig.DataSource {

    /* renamed from: a  reason: collision with root package name */
    public final C0356jm f677a;
    public final SdkEnvironmentProvider b;

    public S5(C0356jm c0356jm, SdkEnvironmentProvider sdkEnvironmentProvider, PlatformIdentifiers platformIdentifiers, Object obj) {
        super(new SdkIdentifiers(c0356jm.c(), c0356jm.a(), c0356jm.b()), sdkEnvironmentProvider, platformIdentifiers, obj);
        this.f677a = c0356jm;
        this.b = sdkEnvironmentProvider;
    }
}
