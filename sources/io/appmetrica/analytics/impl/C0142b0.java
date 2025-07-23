package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.b0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0142b0 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final V f775a;
    public final D6 b;

    public C0142b0() {
        this(new V(new C0642un()), new D6());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0476o6 fromModel(C0116a0 c0116a0) {
        C0476o6 c0476o6 = new C0476o6();
        c0476o6.f982a = this.f775a.fromModel(c0116a0.f757a);
        String str = c0116a0.b;
        if (str != null) {
            c0476o6.b = str;
        }
        c0476o6.c = this.b.a(c0116a0.c);
        return c0476o6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0476o6 c0476o6 = (C0476o6) obj;
        throw new UnsupportedOperationException();
    }

    public C0142b0(V v, D6 d6) {
        this.f775a = v;
        this.b = d6;
    }

    public final C0116a0 a(C0476o6 c0476o6) {
        throw new UnsupportedOperationException();
    }
}
