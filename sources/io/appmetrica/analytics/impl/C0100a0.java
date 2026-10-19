package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* renamed from: io.appmetrica.analytics.impl.a0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0100a0 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final N7 f883a;
    public final Va b;

    public C0100a0() {
        this(new N7(), new Va(20));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Xi fromModel(C0126b0 c0126b0) {
        C0651v8 c0651v8 = new C0651v8();
        c0651v8.b = this.f883a.fromModel(c0126b0.f901a);
        C0512po a2 = this.b.a(c0126b0.b);
        c0651v8.f1250a = StringUtils.getUTF8Bytes((String) a2.f1158a);
        return new Xi(c0651v8, new C0517q3(C0517q3.b(a2)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Xi xi = (Xi) obj;
        throw new UnsupportedOperationException();
    }

    public C0100a0(N7 n7, Va va) {
        this.f883a = n7;
        this.b = va;
    }

    public final C0126b0 a(Xi xi) {
        throw new UnsupportedOperationException();
    }
}
