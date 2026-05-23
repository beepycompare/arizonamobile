package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.client.ClientStorageProvider;
import io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences;
/* renamed from: io.appmetrica.analytics.impl.u4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0628u4 implements ClientStorageProvider {

    /* renamed from: a  reason: collision with root package name */
    public final Zl f1223a;

    public C0628u4(Zl zl) {
        this.f1223a = zl;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.ClientStorageProvider
    public final ModulePreferences modulePreferences(String str) {
        return new C0715xd(str, this.f1223a);
    }
}
