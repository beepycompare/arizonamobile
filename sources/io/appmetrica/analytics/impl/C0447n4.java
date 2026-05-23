package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.identifiers.SdkIdentifiers;
import io.appmetrica.analytics.modulesapi.internal.client.ModuleServiceConfig;
/* renamed from: io.appmetrica.analytics.impl.n4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0447n4 implements ModuleServiceConfig {

    /* renamed from: a  reason: collision with root package name */
    public final SdkIdentifiers f1107a;
    public final Object b;

    public C0447n4(SdkIdentifiers sdkIdentifiers, Object obj) {
        this.f1107a = sdkIdentifiers;
        this.b = obj;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.ModuleServiceConfig
    public final Object getFeaturesConfig() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.ModuleServiceConfig
    public final SdkIdentifiers getIdentifiers() {
        return this.f1107a;
    }
}
