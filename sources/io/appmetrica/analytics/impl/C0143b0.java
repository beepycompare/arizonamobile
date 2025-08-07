package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.b0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0143b0 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final V f775a;
    public final D6 b;

    public C0143b0() {
        this(new V(new C0643un()), new D6());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0477o6 fromModel(C0117a0 c0117a0) {
        C0477o6 c0477o6 = new C0477o6();
        c0477o6.f982a = this.f775a.fromModel(c0117a0.f757a);
        String str = c0117a0.b;
        if (str != null) {
            c0477o6.b = str;
        }
        c0477o6.c = this.b.a(c0117a0.c);
        return c0477o6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0477o6 c0477o6 = (C0477o6) obj;
        throw new UnsupportedOperationException();
    }

    public C0143b0(V v, D6 d6) {
        this.f775a = v;
        this.b = d6;
    }

    public final C0117a0 a(C0477o6 c0477o6) {
        throw new UnsupportedOperationException();
    }
}
