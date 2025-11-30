package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
/* loaded from: classes5.dex */
public final class c0 implements Converter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final P fromModel(a0 a0Var) {
        P p = new P();
        p.f1347a = a0Var.f1356a;
        p.b = a0Var.b;
        return p;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        P p = (P) obj;
        return new a0(p.f1347a, p.b);
    }

    public final a0 a(P p) {
        return new a0(p.f1347a, p.b);
    }
}
