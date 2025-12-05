package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.identifiers.PlatformIdentifiers;
import io.appmetrica.analytics.coreapi.internal.identifiers.SdkIdentifiers;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.SdkEnvironmentProvider;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
/* loaded from: classes5.dex */
public final class M5 extends BaseRequestConfig.DataSource {

    /* renamed from: a  reason: collision with root package name */
    public final C0278gm f666a;
    public final SdkEnvironmentProvider b;

    public M5(C0278gm c0278gm, SdkEnvironmentProvider sdkEnvironmentProvider, PlatformIdentifiers platformIdentifiers, Object obj) {
        super(new SdkIdentifiers(c0278gm.c(), c0278gm.a(), c0278gm.b()), sdkEnvironmentProvider, platformIdentifiers, obj);
        this.f666a = c0278gm;
        this.b = sdkEnvironmentProvider;
    }
}
