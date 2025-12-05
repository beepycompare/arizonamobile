package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes5.dex */
public final class D9 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0556rm fromModel(C9 c9) {
        C0556rm c0556rm = new C0556rm();
        if (c9 != null) {
            c0556rm.f1189a = c9.f510a;
        }
        return c0556rm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new C9(((C0556rm) obj).f1189a);
    }

    public final C9 a(C0556rm c0556rm) {
        return new C9(c0556rm.f1189a);
    }
}
