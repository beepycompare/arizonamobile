package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.client.ClientStorageProvider;
import io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences;
/* renamed from: io.appmetrica.analytics.impl.y4  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0724y4 implements ClientStorageProvider {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0641ul f1147a;

    public C0724y4(InterfaceC0641ul interfaceC0641ul) {
        this.f1147a = interfaceC0641ul;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.ClientStorageProvider
    public final ModulePreferences modulePreferences(String str) {
        return new C0583sd(str, this.f1147a);
    }
}
