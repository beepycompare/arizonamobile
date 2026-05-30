package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.f0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0236f0 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Y f971a;
    public final C0708x6 b;

    public C0236f0() {
        this(new Y(new C0131ao()), new C0708x6());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0320i6 fromModel(C0210e0 c0210e0) {
        C0320i6 c0320i6 = new C0320i6();
        c0320i6.f1029a = this.f971a.fromModel(c0210e0.f953a);
        String str = c0210e0.b;
        if (str != null) {
            c0320i6.b = str;
        }
        c0320i6.c = this.b.a(c0210e0.c);
        return c0320i6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0320i6 c0320i6 = (C0320i6) obj;
        throw new UnsupportedOperationException();
    }

    public C0236f0(Y y, C0708x6 c0708x6) {
        this.f971a = y;
        this.b = c0708x6;
    }

    public final C0210e0 a(C0320i6 c0320i6) {
        throw new UnsupportedOperationException();
    }
}
