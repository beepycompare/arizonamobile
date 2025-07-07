package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.b0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0150b0 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final V f761a;
    public final A6 b;

    public C0150b0() {
        this(new V(new C0573rn()), new A6());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0407l6 fromModel(C0124a0 c0124a0) {
        C0407l6 c0407l6 = new C0407l6();
        c0407l6.f918a = this.f761a.fromModel(c0124a0.f746a);
        String str = c0124a0.b;
        if (str != null) {
            c0407l6.b = str;
        }
        c0407l6.c = this.b.a(c0124a0.c);
        return c0407l6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0407l6 c0407l6 = (C0407l6) obj;
        throw new UnsupportedOperationException();
    }

    public C0150b0(V v, A6 a6) {
        this.f761a = v;
        this.b = a6;
    }

    public final C0124a0 a(C0407l6 c0407l6) {
        throw new UnsupportedOperationException();
    }
}
