package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.d0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0180d0 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final W f839a;
    public final C0315i6 b;

    public C0180d0() {
        this(new W(new C0733yn()), new C0315i6());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final T5 fromModel(C0154c0 c0154c0) {
        T5 t5 = new T5();
        t5.f689a = this.f839a.fromModel(c0154c0.f821a);
        String str = c0154c0.b;
        if (str != null) {
            t5.b = str;
        }
        t5.c = this.b.a(c0154c0.c);
        return t5;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        T5 t5 = (T5) obj;
        throw new UnsupportedOperationException();
    }

    public C0180d0(W w, C0315i6 c0315i6) {
        this.f839a = w;
        this.b = c0315i6;
    }

    public final C0154c0 a(T5 t5) {
        throw new UnsupportedOperationException();
    }
}
