package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
/* renamed from: io.appmetrica.analytics.screenshot.impl.g  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0777g implements Converter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final K fromModel(C0775e c0775e) {
        K k = new K();
        k.f1300a = c0775e.f1319a;
        return k;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new C0775e(((K) obj).f1300a);
    }

    public final C0775e a(K k) {
        return new C0775e(k.f1300a);
    }
}
