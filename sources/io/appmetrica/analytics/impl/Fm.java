package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes4.dex */
public final class Fm implements ProtobufConverter {
    public final C0614tm a(Em em) {
        C0614tm c0614tm = new C0614tm();
        c0614tm.f1064a = em.f416a;
        return c0614tm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        C0614tm c0614tm = new C0614tm();
        c0614tm.f1064a = ((Em) obj).f416a;
        return c0614tm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new Em(((C0614tm) obj).f1064a);
    }

    public final Em a(C0614tm c0614tm) {
        return new Em(c0614tm.f1064a);
    }
}
