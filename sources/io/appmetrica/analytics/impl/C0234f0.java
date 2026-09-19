package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.f0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0234f0 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Y f973a;
    public final C0706x6 b;

    public C0234f0() {
        this(new Y(new C0129ao()), new C0706x6());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0318i6 fromModel(C0208e0 c0208e0) {
        C0318i6 c0318i6 = new C0318i6();
        c0318i6.f1031a = this.f973a.fromModel(c0208e0.f955a);
        String str = c0208e0.b;
        if (str != null) {
            c0318i6.b = str;
        }
        c0318i6.c = this.b.a(c0208e0.c);
        return c0318i6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0318i6 c0318i6 = (C0318i6) obj;
        throw new UnsupportedOperationException();
    }

    public C0234f0(Y y, C0706x6 c0706x6) {
        this.f973a = y;
        this.b = c0706x6;
    }

    public final C0208e0 a(C0318i6 c0318i6) {
        throw new UnsupportedOperationException();
    }
}
