package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* renamed from: io.appmetrica.analytics.impl.a0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0106a0 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final N7 f880a;
    public final Va b;

    public C0106a0() {
        this(new N7(), new Va(20));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Xi fromModel(C0132b0 c0132b0) {
        C0657v8 c0657v8 = new C0657v8();
        c0657v8.b = this.f880a.fromModel(c0132b0.f898a);
        C0518po a2 = this.b.a(c0132b0.b);
        c0657v8.f1247a = StringUtils.getUTF8Bytes((String) a2.f1155a);
        return new Xi(c0657v8, new C0523q3(C0523q3.b(a2)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Xi xi = (Xi) obj;
        throw new UnsupportedOperationException();
    }

    public C0106a0(N7 n7, Va va) {
        this.f880a = n7;
        this.b = va;
    }

    public final C0132b0 a(Xi xi) {
        throw new UnsupportedOperationException();
    }
}
