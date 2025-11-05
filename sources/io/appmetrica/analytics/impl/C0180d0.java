package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.d0  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0180d0 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final W f836a;
    public final C0467o6 b;

    public C0180d0() {
        this(new W(new C0758zn()), new C0467o6());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Z5 fromModel(C0154c0 c0154c0) {
        Z5 z5 = new Z5();
        z5.f781a = this.f836a.fromModel(c0154c0.f821a);
        String str = c0154c0.b;
        if (str != null) {
            z5.b = str;
        }
        z5.c = this.b.a(c0154c0.c);
        return z5;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Z5 z5 = (Z5) obj;
        throw new UnsupportedOperationException();
    }

    public C0180d0(W w, C0467o6 c0467o6) {
        this.f836a = w;
        this.b = c0467o6;
    }

    public final C0154c0 a(Z5 z5) {
        throw new UnsupportedOperationException();
    }
}
