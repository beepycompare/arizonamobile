package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.ye  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0727ye implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0610tm fromModel(C0702xe c0702xe) {
        C0610tm c0610tm = new C0610tm();
        c0610tm.f1242a = c0702xe.f1306a;
        c0610tm.b = c0702xe.b;
        return c0610tm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0610tm c0610tm = (C0610tm) obj;
        return new C0702xe(c0610tm.f1242a, c0610tm.b);
    }

    public final C0702xe a(C0610tm c0610tm) {
        return new C0702xe(c0610tm.f1242a, c0610tm.b);
    }
}
