package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.identifiers.PlatformIdentifiers;
import io.appmetrica.analytics.coreapi.internal.identifiers.SdkIdentifiers;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.SdkEnvironmentProvider;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
/* renamed from: io.appmetrica.analytics.impl.k6  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0374k6 extends BaseRequestConfig.DataSource {

    /* renamed from: a  reason: collision with root package name */
    public final C0494om f950a;
    public final SdkEnvironmentProvider b;

    public C0374k6(C0494om c0494om, SdkEnvironmentProvider sdkEnvironmentProvider, PlatformIdentifiers platformIdentifiers, Object obj) {
        super(new SdkIdentifiers(c0494om.e(), c0494om.a(), c0494om.b()), sdkEnvironmentProvider, platformIdentifiers, obj);
        this.f950a = c0494om;
        this.b = sdkEnvironmentProvider;
    }
}
