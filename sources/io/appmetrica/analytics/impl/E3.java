package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes4.dex */
public final class E3 implements ProtobufConverter {
    public final C0743ym a(C3 c3) {
        C0743ym c0743ym = new C0743ym();
        c0743ym.f1172a = c3.f377a;
        return c0743ym;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        C0743ym c0743ym = new C0743ym();
        c0743ym.f1172a = ((C3) obj).f377a;
        return c0743ym;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new C3(((C0743ym) obj).f1172a);
    }

    public final C3 a(C0743ym c0743ym) {
        return new C3(c0743ym.f1172a);
    }
}
