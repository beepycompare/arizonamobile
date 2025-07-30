package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes4.dex */
public final class B3 implements ProtobufConverter {
    public final C0517pm a(C0747z3 c0747z3) {
        C0517pm c0517pm = new C0517pm();
        c0517pm.f1008a = c0747z3.f1163a;
        return c0517pm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        C0517pm c0517pm = new C0517pm();
        c0517pm.f1008a = ((C0747z3) obj).f1163a;
        return c0517pm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new C0747z3(((C0517pm) obj).f1008a);
    }

    public final C0747z3 a(C0517pm c0517pm) {
        return new C0747z3(c0517pm.f1008a);
    }
}
