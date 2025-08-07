package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes4.dex */
public final class X9 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0567rm fromModel(W9 w9) {
        C0567rm c0567rm = new C0567rm();
        if (w9 != null) {
            c0567rm.f1042a = w9.f699a;
        }
        return c0567rm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new W9(((C0567rm) obj).f1042a);
    }

    public final W9 a(C0567rm c0567rm) {
        return new W9(c0567rm.f1042a);
    }
}
