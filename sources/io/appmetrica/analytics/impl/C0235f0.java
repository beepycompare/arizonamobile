package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.f0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0235f0 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Y f973a;
    public final C0707x6 b;

    public C0235f0() {
        this(new Y(new C0130ao()), new C0707x6());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0319i6 fromModel(C0209e0 c0209e0) {
        C0319i6 c0319i6 = new C0319i6();
        c0319i6.f1031a = this.f973a.fromModel(c0209e0.f955a);
        String str = c0209e0.b;
        if (str != null) {
            c0319i6.b = str;
        }
        c0319i6.c = this.b.a(c0209e0.c);
        return c0319i6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0319i6 c0319i6 = (C0319i6) obj;
        throw new UnsupportedOperationException();
    }

    public C0235f0(Y y, C0707x6 c0707x6) {
        this.f973a = y;
        this.b = c0707x6;
    }

    public final C0209e0 a(C0319i6 c0319i6) {
        throw new UnsupportedOperationException();
    }
}
