package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes4.dex */
public final class B3 implements ProtobufConverter {
    public final C0639um a(C0745z3 c0745z3) {
        C0639um c0639um = new C0639um();
        c0639um.f1093a = c0745z3.f1171a;
        return c0639um;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        C0639um c0639um = new C0639um();
        c0639um.f1093a = ((C0745z3) obj).f1171a;
        return c0639um;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new C0745z3(((C0639um) obj).f1093a);
    }

    public final C0745z3 a(C0639um c0639um) {
        return new C0745z3(c0639um.f1093a);
    }
}
