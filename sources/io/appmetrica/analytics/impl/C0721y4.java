package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.client.ClientStorageProvider;
import io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences;
/* renamed from: io.appmetrica.analytics.impl.y4  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0721y4 implements ClientStorageProvider {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0563rl f1139a;

    public C0721y4(InterfaceC0563rl interfaceC0563rl) {
        this.f1139a = interfaceC0563rl;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.ClientStorageProvider
    public final ModulePreferences modulePreferences(String str) {
        return new C0531qd(str, this.f1139a);
    }
}
