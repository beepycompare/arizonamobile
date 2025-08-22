package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes4.dex */
public final class Nm implements ProtobufConverter {
    public final Bm a(Mm mm) {
        Bm bm = new Bm();
        bm.f368a = mm.f566a;
        return bm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        Bm bm = new Bm();
        bm.f368a = ((Mm) obj).f566a;
        return bm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new Mm(((Bm) obj).f368a);
    }

    public final Mm a(Bm bm) {
        return new Mm(bm.f368a);
    }
}
