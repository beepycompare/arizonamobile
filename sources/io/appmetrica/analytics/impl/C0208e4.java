package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.client.ClientStorageProvider;
import io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences;
/* renamed from: io.appmetrica.analytics.impl.e4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0208e4 implements ClientStorageProvider {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0655vl f961a;

    public C0208e4(InterfaceC0655vl interfaceC0655vl) {
        this.f961a = interfaceC0655vl;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.ClientStorageProvider
    public final ModulePreferences modulePreferences(String str) {
        return new Yc(str, this.f961a);
    }
}
