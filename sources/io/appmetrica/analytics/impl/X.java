package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* loaded from: classes4.dex */
public final class X implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final O7 f694a;
    public final La b;

    public X() {
        this(new O7(), new La(20));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Ni fromModel(Y y) {
        C0608t8 c0608t8 = new C0608t8();
        c0608t8.b = this.f694a.fromModel(y.f712a);
        Gn a2 = this.b.a(y.b);
        c0608t8.f1055a = StringUtils.getUTF8Bytes((String) a2.f449a);
        return new Ni(c0608t8, new C0678w3(C0678w3.b(a2)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Ni ni = (Ni) obj;
        throw new UnsupportedOperationException();
    }

    public X(O7 o7, La la) {
        this.f694a = o7;
        this.b = la;
    }

    public final Y a(Ni ni) {
        throw new UnsupportedOperationException();
    }
}
