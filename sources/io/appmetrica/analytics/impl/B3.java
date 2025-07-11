package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes4.dex */
public final class B3 implements ProtobufConverter {
    public final C0440mm a(C0745z3 c0745z3) {
        C0440mm c0440mm = new C0440mm();
        c0440mm.f946a = c0745z3.f1157a;
        return c0440mm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        C0440mm c0440mm = new C0440mm();
        c0440mm.f946a = ((C0745z3) obj).f1157a;
        return c0440mm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new C0745z3(((C0440mm) obj).f946a);
    }

    public final C0745z3 a(C0440mm c0440mm) {
        return new C0745z3(c0440mm.f946a);
    }
}
