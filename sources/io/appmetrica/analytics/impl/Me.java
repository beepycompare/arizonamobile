package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes4.dex */
public final class Me implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0641um fromModel(Le le) {
        C0641um c0641um = new C0641um();
        c0641um.f1090a = le.f533a;
        c0641um.b = le.b;
        return c0641um;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0641um c0641um = (C0641um) obj;
        return new Le(c0641um.f1090a, c0641um.b);
    }

    public final Le a(C0641um c0641um) {
        return new Le(c0641um.f1090a, c0641um.b);
    }
}
