package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes5.dex */
public final class Dm implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0635um fromModel(Cm cm) {
        C0635um c0635um = new C0635um();
        c0635um.f1262a = cm.f540a;
        return c0635um;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new Cm(((C0635um) obj).f1262a);
    }

    public final Cm a(C0635um c0635um) {
        return new Cm(c0635um.f1262a);
    }
}
