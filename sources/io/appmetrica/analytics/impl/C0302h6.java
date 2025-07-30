package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.identifiers.PlatformIdentifiers;
import io.appmetrica.analytics.coreapi.internal.identifiers.SdkIdentifiers;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.SdkEnvironmentProvider;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
/* renamed from: io.appmetrica.analytics.impl.h6  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0302h6 extends BaseRequestConfig.DataSource {

    /* renamed from: a  reason: collision with root package name */
    public final C0267fm f879a;
    public final SdkEnvironmentProvider b;

    public C0302h6(C0267fm c0267fm, SdkEnvironmentProvider sdkEnvironmentProvider, PlatformIdentifiers platformIdentifiers, Object obj) {
        super(new SdkIdentifiers(c0267fm.e(), c0267fm.a(), c0267fm.b()), sdkEnvironmentProvider, platformIdentifiers, obj);
        this.f879a = c0267fm;
        this.b = sdkEnvironmentProvider;
    }
}
