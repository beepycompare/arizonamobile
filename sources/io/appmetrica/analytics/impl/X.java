package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* loaded from: classes4.dex */
public final class X implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final R7 f709a;
    public final Na b;

    public X() {
        this(new R7(), new Na(20));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Qi fromModel(Y y) {
        C0677w8 c0677w8 = new C0677w8();
        c0677w8.b = this.f709a.fromModel(y.f725a);
        Jn a2 = this.b.a(y.b);
        c0677w8.f1117a = StringUtils.getUTF8Bytes((String) a2.f512a);
        return new Qi(c0677w8, new C0672w3(C0672w3.b(a2)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Qi qi = (Qi) obj;
        throw new UnsupportedOperationException();
    }

    public X(R7 r7, Na na) {
        this.f709a = r7;
        this.b = na;
    }

    public final Y a(Qi qi) {
        throw new UnsupportedOperationException();
    }
}
