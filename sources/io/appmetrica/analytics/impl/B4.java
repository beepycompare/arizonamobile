package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.client.ClientStorageProvider;
import io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences;
/* loaded from: classes4.dex */
public final class B4 implements ClientStorageProvider {

    /* renamed from: a  reason: collision with root package name */
    public final Dl f358a;

    public B4(Dl dl) {
        this.f358a = dl;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.ClientStorageProvider
    public final ModulePreferences modulePreferences(String str) {
        return new C0709xd(str, this.f358a);
    }
}
