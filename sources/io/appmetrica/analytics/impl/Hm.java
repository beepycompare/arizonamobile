package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes5.dex */
public final class Hm implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0732ym fromModel(Gm gm) {
        C0732ym c0732ym = new C0732ym();
        c0732ym.f1218a = gm.f496a;
        return c0732ym;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new Gm(((C0732ym) obj).f1218a);
    }

    public final Gm a(C0732ym c0732ym) {
        return new Gm(c0732ym.f1218a);
    }
}
