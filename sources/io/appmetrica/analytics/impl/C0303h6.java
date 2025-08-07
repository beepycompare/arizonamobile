package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.identifiers.PlatformIdentifiers;
import io.appmetrica.analytics.coreapi.internal.identifiers.SdkIdentifiers;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.SdkEnvironmentProvider;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
/* renamed from: io.appmetrica.analytics.impl.h6  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0303h6 extends BaseRequestConfig.DataSource {

    /* renamed from: a  reason: collision with root package name */
    public final C0268fm f878a;
    public final SdkEnvironmentProvider b;

    public C0303h6(C0268fm c0268fm, SdkEnvironmentProvider sdkEnvironmentProvider, PlatformIdentifiers platformIdentifiers, Object obj) {
        super(new SdkIdentifiers(c0268fm.e(), c0268fm.a(), c0268fm.b()), sdkEnvironmentProvider, platformIdentifiers, obj);
        this.f878a = c0268fm;
        this.b = sdkEnvironmentProvider;
    }
}
