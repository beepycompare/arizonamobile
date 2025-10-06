package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.c0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0162c0 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final V f817a;
    public final G6 b;

    public C0162c0() {
        this(new V(new Dn()), new G6());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0553r6 fromModel(C0136b0 c0136b0) {
        C0553r6 c0553r6 = new C0553r6();
        c0553r6.f1063a = this.f817a.fromModel(c0136b0.f801a);
        String str = c0136b0.b;
        if (str != null) {
            c0553r6.b = str;
        }
        c0553r6.c = this.b.a(c0136b0.c);
        return c0553r6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0553r6 c0553r6 = (C0553r6) obj;
        throw new UnsupportedOperationException();
    }

    public C0162c0(V v, G6 g6) {
        this.f817a = v;
        this.b = g6;
    }

    public final C0136b0 a(C0553r6 c0553r6) {
        throw new UnsupportedOperationException();
    }
}
