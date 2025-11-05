package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.n3  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0439n3 implements ProtobufConverter {
    public final C0582sm a(C0389l3 c0389l3) {
        C0582sm c0582sm = new C0582sm();
        c0582sm.f1119a = c0389l3.f982a;
        return c0582sm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        C0582sm c0582sm = new C0582sm();
        c0582sm.f1119a = ((C0389l3) obj).f982a;
        return c0582sm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new C0389l3(((C0582sm) obj).f1119a);
    }

    public final C0389l3 a(C0582sm c0582sm) {
        return new C0389l3(c0582sm.f1119a);
    }
}
