package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes4.dex */
public final class Me implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0642um fromModel(Le le) {
        C0642um c0642um = new C0642um();
        c0642um.f1089a = le.f532a;
        c0642um.b = le.b;
        return c0642um;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0642um c0642um = (C0642um) obj;
        return new Le(c0642um.f1089a, c0642um.b);
    }

    public final Le a(C0642um c0642um) {
        return new Le(c0642um.f1089a, c0642um.b);
    }
}
