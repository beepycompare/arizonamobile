package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* loaded from: classes4.dex */
public final class X implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final O7 f695a;
    public final La b;

    public X() {
        this(new O7(), new La(20));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Ni fromModel(Y y) {
        C0600t8 c0600t8 = new C0600t8();
        c0600t8.b = this.f695a.fromModel(y.f713a);
        Gn a2 = this.b.a(y.b);
        c0600t8.f1056a = StringUtils.getUTF8Bytes((String) a2.f450a);
        return new Ni(c0600t8, new C0670w3(C0670w3.b(a2)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Ni ni = (Ni) obj;
        throw new UnsupportedOperationException();
    }

    public X(O7 o7, La la) {
        this.f695a = o7;
        this.b = la;
    }

    public final Y a(Ni ni) {
        throw new UnsupportedOperationException();
    }
}
