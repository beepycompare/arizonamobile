package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.f0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0229f0 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Y f976a;
    public final C0701x6 b;

    public C0229f0() {
        this(new Y(new C0124ao()), new C0701x6());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0313i6 fromModel(C0203e0 c0203e0) {
        C0313i6 c0313i6 = new C0313i6();
        c0313i6.f1034a = this.f976a.fromModel(c0203e0.f958a);
        String str = c0203e0.b;
        if (str != null) {
            c0313i6.b = str;
        }
        c0313i6.c = this.b.a(c0203e0.c);
        return c0313i6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0313i6 c0313i6 = (C0313i6) obj;
        throw new UnsupportedOperationException();
    }

    public C0229f0(Y y, C0701x6 c0701x6) {
        this.f976a = y;
        this.b = c0701x6;
    }

    public final C0203e0 a(C0313i6 c0313i6) {
        throw new UnsupportedOperationException();
    }
}
