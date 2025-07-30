package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.client.ClientStorageProvider;
import io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences;
/* renamed from: io.appmetrica.analytics.impl.y4  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0723y4 implements ClientStorageProvider {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0640ul f1148a;

    public C0723y4(InterfaceC0640ul interfaceC0640ul) {
        this.f1148a = interfaceC0640ul;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.ClientStorageProvider
    public final ModulePreferences modulePreferences(String str) {
        return new C0582sd(str, this.f1148a);
    }
}
