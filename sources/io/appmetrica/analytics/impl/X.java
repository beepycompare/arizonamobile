package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* loaded from: classes4.dex */
public final class X implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final V7 f732a;
    public final Sa b;

    public X() {
        this(new V7(), new Sa(20));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Zi fromModel(Y y) {
        B8 b8 = new B8();
        b8.b = this.f732a.fromModel(y.f749a);
        Sn a2 = this.b.a(y.b);
        b8.f365a = StringUtils.getUTF8Bytes((String) a2.f675a);
        return new Zi(b8, new C0749z3(C0749z3.b(a2)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Zi zi = (Zi) obj;
        throw new UnsupportedOperationException();
    }

    public X(V7 v7, Sa sa) {
        this.f732a = v7;
        this.b = sa;
    }

    public final Y a(Zi zi) {
        throw new UnsupportedOperationException();
    }
}
