package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* loaded from: classes5.dex */
public final class Y implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0666w7 f854a;
    public final C0594ta b;

    public Y() {
        this(new C0666w7(), new C0594ta(20));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Ei fromModel(Z z) {
        C0187d8 c0187d8 = new C0187d8();
        c0187d8.b = this.f854a.fromModel(z.f867a);
        Nn a2 = this.b.a(z.b);
        c0187d8.f942a = StringUtils.getUTF8Bytes((String) a2.f708a);
        return new Ei(c0187d8, new C0130b3(C0130b3.b(a2)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Ei ei = (Ei) obj;
        throw new UnsupportedOperationException();
    }

    public Y(C0666w7 c0666w7, C0594ta c0594ta) {
        this.f854a = c0666w7;
        this.b = c0594ta;
    }

    public final Z a(Ei ei) {
        throw new UnsupportedOperationException();
    }
}
