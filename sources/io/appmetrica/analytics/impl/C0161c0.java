package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.c0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0161c0 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final V f812a;
    public final G6 b;

    public C0161c0() {
        this(new V(new Dn()), new G6());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0552r6 fromModel(C0135b0 c0135b0) {
        C0552r6 c0552r6 = new C0552r6();
        c0552r6.f1058a = this.f812a.fromModel(c0135b0.f796a);
        String str = c0135b0.b;
        if (str != null) {
            c0552r6.b = str;
        }
        c0552r6.c = this.b.a(c0135b0.c);
        return c0552r6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0552r6 c0552r6 = (C0552r6) obj;
        throw new UnsupportedOperationException();
    }

    public C0161c0(V v, G6 g6) {
        this.f812a = v;
        this.b = g6;
    }

    public final C0135b0 a(C0552r6 c0552r6) {
        throw new UnsupportedOperationException();
    }
}
