package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* loaded from: classes4.dex */
public final class X implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final V7 f733a;
    public final Sa b;

    public X() {
        this(new V7(), new Sa(20));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Zi fromModel(Y y) {
        B8 b8 = new B8();
        b8.b = this.f733a.fromModel(y.f750a);
        Sn a2 = this.b.a(y.b);
        b8.f366a = StringUtils.getUTF8Bytes((String) a2.f676a);
        return new Zi(b8, new C0749z3(C0749z3.b(a2)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Zi zi = (Zi) obj;
        throw new UnsupportedOperationException();
    }

    public X(V7 v7, Sa sa) {
        this.f733a = v7;
        this.b = sa;
    }

    public final Y a(Zi zi) {
        throw new UnsupportedOperationException();
    }
}
