package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.identifiers.PlatformIdentifiers;
import io.appmetrica.analytics.coreapi.internal.identifiers.SdkIdentifiers;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.SdkEnvironmentProvider;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
/* renamed from: io.appmetrica.analytics.impl.b6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0139b6 extends BaseRequestConfig.DataSource {

    /* renamed from: a  reason: collision with root package name */
    public final Hm f901a;
    public final SdkEnvironmentProvider b;

    public C0139b6(Hm hm, SdkEnvironmentProvider sdkEnvironmentProvider, PlatformIdentifiers platformIdentifiers, Object obj) {
        super(new SdkIdentifiers(hm.c(), hm.a(), hm.b()), sdkEnvironmentProvider, platformIdentifiers, obj);
        this.f901a = hm;
        this.b = sdkEnvironmentProvider;
    }
}
