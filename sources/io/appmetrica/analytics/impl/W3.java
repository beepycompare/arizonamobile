package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.identifiers.SdkIdentifiers;
import io.appmetrica.analytics.modulesapi.internal.client.ModuleServiceConfig;
/* loaded from: classes5.dex */
public final class W3 implements ModuleServiceConfig {

    /* renamed from: a  reason: collision with root package name */
    public final SdkIdentifiers f839a;
    public final Object b;

    public W3(SdkIdentifiers sdkIdentifiers, Object obj) {
        this.f839a = sdkIdentifiers;
        this.b = obj;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.ModuleServiceConfig
    public final Object getFeaturesConfig() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.ModuleServiceConfig
    public final SdkIdentifiers getIdentifiers() {
        return this.f839a;
    }
}
