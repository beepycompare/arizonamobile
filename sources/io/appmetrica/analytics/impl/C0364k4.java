package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.client.ClientStorageProvider;
import io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences;
/* renamed from: io.appmetrica.analytics.impl.k4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0364k4 implements ClientStorageProvider {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0731yl f966a;

    public C0364k4(InterfaceC0731yl interfaceC0731yl) {
        this.f966a = interfaceC0731yl;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.ClientStorageProvider
    public final ModulePreferences modulePreferences(String str) {
        return new C0218ed(str, this.f966a);
    }
}
