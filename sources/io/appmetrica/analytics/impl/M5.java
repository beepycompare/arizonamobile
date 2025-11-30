package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.identifiers.PlatformIdentifiers;
import io.appmetrica.analytics.coreapi.internal.identifiers.SdkIdentifiers;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.SdkEnvironmentProvider;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
/* loaded from: classes5.dex */
public final class M5 extends BaseRequestConfig.DataSource {

    /* renamed from: a  reason: collision with root package name */
    public final C0279gm f583a;
    public final SdkEnvironmentProvider b;

    public M5(C0279gm c0279gm, SdkEnvironmentProvider sdkEnvironmentProvider, PlatformIdentifiers platformIdentifiers, Object obj) {
        super(new SdkIdentifiers(c0279gm.c(), c0279gm.a(), c0279gm.b()), sdkEnvironmentProvider, platformIdentifiers, obj);
        this.f583a = c0279gm;
        this.b = sdkEnvironmentProvider;
    }
}
