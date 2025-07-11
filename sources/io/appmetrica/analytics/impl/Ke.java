package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes4.dex */
public final class Ke implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0564rm fromModel(Je je) {
        C0564rm c0564rm = new C0564rm();
        c0564rm.f1032a = je.f492a;
        c0564rm.b = je.b;
        return c0564rm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0564rm c0564rm = (C0564rm) obj;
        return new Je(c0564rm.f1032a, c0564rm.b);
    }

    public final Je a(C0564rm c0564rm) {
        return new Je(c0564rm.f1032a, c0564rm.b);
    }
}
