package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
/* renamed from: io.appmetrica.analytics.screenshot.impl.g  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0775g implements Converter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final K fromModel(C0773e c0773e) {
        K k = new K();
        k.f1280a = c0773e.f1299a;
        return k;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new C0773e(((K) obj).f1280a);
    }

    public final C0773e a(K k) {
        return new C0773e(k.f1280a);
    }
}
