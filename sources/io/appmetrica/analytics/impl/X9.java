package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes4.dex */
public final class X9 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0566rm fromModel(W9 w9) {
        C0566rm c0566rm = new C0566rm();
        if (w9 != null) {
            c0566rm.f1043a = w9.f700a;
        }
        return c0566rm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new W9(((C0566rm) obj).f1043a);
    }

    public final W9 a(C0566rm c0566rm) {
        return new W9(c0566rm.f1043a);
    }
}
