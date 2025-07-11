package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
/* loaded from: classes4.dex */
public final class Z implements Converter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final M fromModel(X x) {
        M m = new M();
        m.f1279a = x.f1287a;
        m.b = x.b;
        return m;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        M m = (M) obj;
        return new X(m.f1279a, m.b);
    }

    public final X a(M m) {
        return new X(m.f1279a, m.b);
    }
}
