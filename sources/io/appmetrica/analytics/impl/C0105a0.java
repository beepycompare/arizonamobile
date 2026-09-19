package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* renamed from: io.appmetrica.analytics.impl.a0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0105a0 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final N7 f880a;
    public final Va b;

    public C0105a0() {
        this(new N7(), new Va(20));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Xi fromModel(C0131b0 c0131b0) {
        C0656v8 c0656v8 = new C0656v8();
        c0656v8.b = this.f880a.fromModel(c0131b0.f898a);
        C0517po a2 = this.b.a(c0131b0.b);
        c0656v8.f1247a = StringUtils.getUTF8Bytes((String) a2.f1155a);
        return new Xi(c0656v8, new C0522q3(C0522q3.b(a2)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Xi xi = (Xi) obj;
        throw new UnsupportedOperationException();
    }

    public C0105a0(N7 n7, Va va) {
        this.f880a = n7;
        this.b = va;
    }

    public final C0131b0 a(Xi xi) {
        throw new UnsupportedOperationException();
    }
}
