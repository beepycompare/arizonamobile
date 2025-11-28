package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes5.dex */
public final class Lm implements ProtobufConverter {
    public final C0757zm a(Km km) {
        C0757zm c0757zm = new C0757zm();
        c0757zm.f1236a = km.f564a;
        return c0757zm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        C0757zm c0757zm = new C0757zm();
        c0757zm.f1236a = ((Km) obj).f564a;
        return c0757zm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new Km(((C0757zm) obj).f1236a);
    }

    public final Km a(C0757zm c0757zm) {
        return new Km(c0757zm.f1236a);
    }
}
