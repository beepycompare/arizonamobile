package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes4.dex */
public final class E3 implements ProtobufConverter {
    public final C0744ym a(C3 c3) {
        C0744ym c0744ym = new C0744ym();
        c0744ym.f1177a = c3.f382a;
        return c0744ym;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        C0744ym c0744ym = new C0744ym();
        c0744ym.f1177a = ((C3) obj).f382a;
        return c0744ym;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new C3(((C0744ym) obj).f1177a);
    }

    public final C3 a(C0744ym c0744ym) {
        return new C3(c0744ym.f1177a);
    }
}
