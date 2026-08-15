package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.client.ClientStorageProvider;
import io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences;
/* renamed from: io.appmetrica.analytics.impl.u4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0627u4 implements ClientStorageProvider {

    /* renamed from: a  reason: collision with root package name */
    public final Zl f1226a;

    public C0627u4(Zl zl) {
        this.f1226a = zl;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.ClientStorageProvider
    public final ModulePreferences modulePreferences(String str) {
        return new C0714xd(str, this.f1226a);
    }
}
