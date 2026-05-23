package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes5.dex */
public final class X9 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Sm fromModel(W9 w9) {
        Sm sm = new Sm();
        if (w9 != null) {
            sm.f766a = w9.f822a;
        }
        return sm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new W9(((Sm) obj).f766a);
    }

    public final W9 a(Sm sm) {
        return new W9(sm.f766a);
    }
}
