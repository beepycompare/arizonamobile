package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes4.dex */
public final class B3 implements ProtobufConverter {
    public final C0518pm a(C0748z3 c0748z3) {
        C0518pm c0518pm = new C0518pm();
        c0518pm.f1007a = c0748z3.f1162a;
        return c0518pm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        C0518pm c0518pm = new C0518pm();
        c0518pm.f1007a = ((C0748z3) obj).f1162a;
        return c0518pm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new C0748z3(((C0518pm) obj).f1007a);
    }

    public final C0748z3 a(C0518pm c0518pm) {
        return new C0748z3(c0518pm.f1007a);
    }
}
