package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes5.dex */
public final class D9 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0557rm fromModel(C9 c9) {
        C0557rm c0557rm = new C0557rm();
        if (c9 != null) {
            c0557rm.f1106a = c9.f427a;
        }
        return c0557rm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new C9(((C0557rm) obj).f1106a);
    }

    public final C9 a(C0557rm c0557rm) {
        return new C9(c0557rm.f1106a);
    }
}
