package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes4.dex */
public final class Oe implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0764zm fromModel(Ne ne) {
        C0764zm c0764zm = new C0764zm();
        c0764zm.f1185a = ne.f578a;
        c0764zm.b = ne.b;
        return c0764zm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0764zm c0764zm = (C0764zm) obj;
        return new Ne(c0764zm.f1185a, c0764zm.b);
    }

    public final Ne a(C0764zm c0764zm) {
        return new Ne(c0764zm.f1185a, c0764zm.b);
    }
}
