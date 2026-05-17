package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.identifiers.PlatformIdentifiers;
import io.appmetrica.analytics.coreapi.internal.identifiers.SdkIdentifiers;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.SdkEnvironmentProvider;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
/* loaded from: classes5.dex */
public final class L5 extends BaseRequestConfig.DataSource {

    /* renamed from: a  reason: collision with root package name */
    public final C0256fm f676a;
    public final SdkEnvironmentProvider b;

    public L5(C0256fm c0256fm, SdkEnvironmentProvider sdkEnvironmentProvider, PlatformIdentifiers platformIdentifiers, Object obj) {
        super(new SdkIdentifiers(c0256fm.c(), c0256fm.a(), c0256fm.b()), sdkEnvironmentProvider, platformIdentifiers, obj);
        this.f676a = c0256fm;
        this.b = sdkEnvironmentProvider;
    }
}
