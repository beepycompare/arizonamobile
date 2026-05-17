package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.f3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0237f3 implements ProtobufConverter {
    public final C0485om a(C0186d3 c0186d3) {
        C0485om c0485om = new C0485om();
        c0485om.f1166a = c0186d3.f955a;
        return c0485om;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        C0485om c0485om = new C0485om();
        c0485om.f1166a = ((C0186d3) obj).f955a;
        return c0485om;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new C0186d3(((C0485om) obj).f1166a);
    }

    public final C0186d3 a(C0485om c0485om) {
        return new C0186d3(c0485om.f1166a);
    }
}
