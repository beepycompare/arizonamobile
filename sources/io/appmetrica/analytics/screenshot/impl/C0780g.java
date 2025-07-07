package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
/* renamed from: io.appmetrica.analytics.screenshot.impl.g  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0780g implements Converter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final K fromModel(C0778e c0778e) {
        K k = new K();
        k.f1276a = c0778e.f1295a;
        return k;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new C0778e(((K) obj).f1276a);
    }

    public final C0778e a(K k) {
        return new C0778e(k.f1276a);
    }
}
