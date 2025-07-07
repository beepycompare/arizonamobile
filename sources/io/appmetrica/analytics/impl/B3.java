package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes4.dex */
public final class B3 implements ProtobufConverter {
    public final C0448mm a(C0753z3 c0753z3) {
        C0448mm c0448mm = new C0448mm();
        c0448mm.f945a = c0753z3.f1156a;
        return c0448mm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        C0448mm c0448mm = new C0448mm();
        c0448mm.f945a = ((C0753z3) obj).f1156a;
        return c0448mm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new C0753z3(((C0448mm) obj).f945a);
    }

    public final C0753z3 a(C0448mm c0448mm) {
        return new C0753z3(c0448mm.f945a);
    }
}
