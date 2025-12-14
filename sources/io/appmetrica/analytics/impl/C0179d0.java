package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.d0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0179d0 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final W f936a;
    public final C0314i6 b;

    public C0179d0() {
        this(new W(new C0732yn()), new C0314i6());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final T5 fromModel(C0153c0 c0153c0) {
        T5 t5 = new T5();
        t5.f786a = this.f936a.fromModel(c0153c0.f918a);
        String str = c0153c0.b;
        if (str != null) {
            t5.b = str;
        }
        t5.c = this.b.a(c0153c0.c);
        return t5;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        T5 t5 = (T5) obj;
        throw new UnsupportedOperationException();
    }

    public C0179d0(W w, C0314i6 c0314i6) {
        this.f936a = w;
        this.b = c0314i6;
    }

    public final C0153c0 a(T5 t5) {
        throw new UnsupportedOperationException();
    }
}
