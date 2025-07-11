package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.b0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0142b0 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final V f762a;
    public final A6 b;

    public C0142b0() {
        this(new V(new C0565rn()), new A6());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0399l6 fromModel(C0116a0 c0116a0) {
        C0399l6 c0399l6 = new C0399l6();
        c0399l6.f919a = this.f762a.fromModel(c0116a0.f747a);
        String str = c0116a0.b;
        if (str != null) {
            c0399l6.b = str;
        }
        c0399l6.c = this.b.a(c0116a0.c);
        return c0399l6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0399l6 c0399l6 = (C0399l6) obj;
        throw new UnsupportedOperationException();
    }

    public C0142b0(V v, A6 a6) {
        this.f762a = v;
        this.b = a6;
    }

    public final C0116a0 a(C0399l6 c0399l6) {
        throw new UnsupportedOperationException();
    }
}
