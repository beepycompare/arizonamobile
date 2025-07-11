package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
/* renamed from: io.appmetrica.analytics.screenshot.impl.g  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0772g implements Converter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final K fromModel(C0770e c0770e) {
        K k = new K();
        k.f1277a = c0770e.f1296a;
        return k;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new C0770e(((K) obj).f1277a);
    }

    public final C0770e a(K k) {
        return new C0770e(k.f1277a);
    }
}
