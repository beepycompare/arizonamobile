package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
/* renamed from: io.appmetrica.analytics.screenshot.impl.g  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0768g implements Converter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final N fromModel(C0766e c0766e) {
        N n = new N();
        n.f1452a = c0766e.f1468a;
        return n;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new C0766e(((N) obj).f1452a);
    }

    public final C0766e a(N n) {
        return new C0766e(n.f1452a);
    }
}
