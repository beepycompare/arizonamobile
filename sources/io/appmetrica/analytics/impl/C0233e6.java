package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.identifiers.PlatformIdentifiers;
import io.appmetrica.analytics.coreapi.internal.identifiers.SdkIdentifiers;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.SdkEnvironmentProvider;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
/* renamed from: io.appmetrica.analytics.impl.e6  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0233e6 extends BaseRequestConfig.DataSource {

    /* renamed from: a  reason: collision with root package name */
    public final C0198cm f816a;
    public final SdkEnvironmentProvider b;

    public C0233e6(C0198cm c0198cm, SdkEnvironmentProvider sdkEnvironmentProvider, PlatformIdentifiers platformIdentifiers, Object obj) {
        super(new SdkIdentifiers(c0198cm.e(), c0198cm.a(), c0198cm.b()), sdkEnvironmentProvider, platformIdentifiers, obj);
        this.f816a = c0198cm;
        this.b = sdkEnvironmentProvider;
    }
}
