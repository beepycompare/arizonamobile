package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.f3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0238f3 implements ProtobufConverter {
    public final C0486om a(C0187d3 c0187d3) {
        C0486om c0486om = new C0486om();
        c0486om.f1162a = c0187d3.f951a;
        return c0486om;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        C0486om c0486om = new C0486om();
        c0486om.f1162a = ((C0187d3) obj).f951a;
        return c0486om;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new C0187d3(((C0486om) obj).f1162a);
    }

    public final C0187d3 a(C0486om c0486om) {
        return new C0187d3(c0486om.f1162a);
    }
}
