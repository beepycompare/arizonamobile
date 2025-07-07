package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes4.dex */
public final class Ke implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0572rm fromModel(Je je) {
        C0572rm c0572rm = new C0572rm();
        c0572rm.f1031a = je.f491a;
        c0572rm.b = je.b;
        return c0572rm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0572rm c0572rm = (C0572rm) obj;
        return new Je(c0572rm.f1031a, c0572rm.b);
    }

    public final Je a(C0572rm c0572rm) {
        return new Je(c0572rm.f1031a, c0572rm.b);
    }
}
