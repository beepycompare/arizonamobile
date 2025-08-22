package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.b0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0135b0 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final V f786a;
    public final D6 b;

    public C0135b0() {
        this(new V(new C0765zn()), new D6());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0474o6 fromModel(C0109a0 c0109a0) {
        C0474o6 c0474o6 = new C0474o6();
        c0474o6.f996a = this.f786a.fromModel(c0109a0.f766a);
        String str = c0109a0.b;
        if (str != null) {
            c0474o6.b = str;
        }
        c0474o6.c = this.b.a(c0109a0.c);
        return c0474o6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0474o6 c0474o6 = (C0474o6) obj;
        throw new UnsupportedOperationException();
    }

    public C0135b0(V v, D6 d6) {
        this.f786a = v;
        this.b = d6;
    }

    public final C0109a0 a(C0474o6 c0474o6) {
        throw new UnsupportedOperationException();
    }
}
