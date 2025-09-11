package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes4.dex */
public final class Nm implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Em fromModel(Mm mm) {
        Em em = new Em();
        em.f431a = mm.f582a;
        return em;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new Mm(((Em) obj).f431a);
    }

    public final Mm a(Em em) {
        return new Mm(em.f431a);
    }
}
