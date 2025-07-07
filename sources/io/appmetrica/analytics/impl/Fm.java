package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes4.dex */
public final class Fm implements ProtobufConverter {
    public final C0622tm a(Em em) {
        C0622tm c0622tm = new C0622tm();
        c0622tm.f1063a = em.f415a;
        return c0622tm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        C0622tm c0622tm = new C0622tm();
        c0622tm.f1063a = ((Em) obj).f415a;
        return c0622tm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new Em(((C0622tm) obj).f1063a);
    }

    public final Em a(C0622tm c0622tm) {
        return new Em(c0622tm.f1063a);
    }
}
