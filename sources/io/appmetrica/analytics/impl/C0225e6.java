package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.identifiers.PlatformIdentifiers;
import io.appmetrica.analytics.coreapi.internal.identifiers.SdkIdentifiers;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.SdkEnvironmentProvider;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
/* renamed from: io.appmetrica.analytics.impl.e6  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0225e6 extends BaseRequestConfig.DataSource {

    /* renamed from: a  reason: collision with root package name */
    public final C0190cm f817a;
    public final SdkEnvironmentProvider b;

    public C0225e6(C0190cm c0190cm, SdkEnvironmentProvider sdkEnvironmentProvider, PlatformIdentifiers platformIdentifiers, Object obj) {
        super(new SdkIdentifiers(c0190cm.e(), c0190cm.a(), c0190cm.b()), sdkEnvironmentProvider, platformIdentifiers, obj);
        this.f817a = c0190cm;
        this.b = sdkEnvironmentProvider;
    }
}
