package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.ye  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0726ye implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0609tm fromModel(C0701xe c0701xe) {
        C0609tm c0609tm = new C0609tm();
        c0609tm.f1241a = c0701xe.f1305a;
        c0609tm.b = c0701xe.b;
        return c0609tm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0609tm c0609tm = (C0609tm) obj;
        return new C0701xe(c0609tm.f1241a, c0609tm.b);
    }

    public final C0701xe a(C0609tm c0609tm) {
        return new C0701xe(c0609tm.f1241a, c0609tm.b);
    }
}
