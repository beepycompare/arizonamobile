package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.g3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0259g3 implements ProtobufConverter {
    public final C0507pm a(C0207e3 c0207e3) {
        C0507pm c0507pm = new C0507pm();
        c0507pm.f1171a = c0207e3.f960a;
        return c0507pm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        C0507pm c0507pm = new C0507pm();
        c0507pm.f1171a = ((C0207e3) obj).f960a;
        return c0507pm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new C0207e3(((C0507pm) obj).f1171a);
    }

    public final C0207e3 a(C0507pm c0507pm) {
        return new C0207e3(c0507pm.f1171a);
    }
}
