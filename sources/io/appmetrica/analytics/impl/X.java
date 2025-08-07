package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* loaded from: classes4.dex */
public final class X implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final R7 f708a;
    public final Na b;

    public X() {
        this(new R7(), new Na(20));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Qi fromModel(Y y) {
        C0678w8 c0678w8 = new C0678w8();
        c0678w8.b = this.f708a.fromModel(y.f724a);
        Jn a2 = this.b.a(y.b);
        c0678w8.f1116a = StringUtils.getUTF8Bytes((String) a2.f511a);
        return new Qi(c0678w8, new C0673w3(C0673w3.b(a2)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Qi qi = (Qi) obj;
        throw new UnsupportedOperationException();
    }

    public X(R7 r7, Na na) {
        this.f708a = r7;
        this.b = na;
    }

    public final Y a(Qi qi) {
        throw new UnsupportedOperationException();
    }
}
