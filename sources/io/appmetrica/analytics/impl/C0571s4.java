package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.identifiers.SdkIdentifiers;
import io.appmetrica.analytics.modulesapi.internal.client.ModuleServiceConfig;
/* renamed from: io.appmetrica.analytics.impl.s4  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0571s4 implements ModuleServiceConfig {

    /* renamed from: a  reason: collision with root package name */
    public final SdkIdentifiers f1037a;
    public final Object b;

    public C0571s4(SdkIdentifiers sdkIdentifiers, Object obj) {
        this.f1037a = sdkIdentifiers;
        this.b = obj;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.ModuleServiceConfig
    public final Object getFeaturesConfig() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.ModuleServiceConfig
    public final SdkIdentifiers getIdentifiers() {
        return this.f1037a;
    }
}
