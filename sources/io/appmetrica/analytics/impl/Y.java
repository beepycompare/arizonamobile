package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* loaded from: classes5.dex */
public final class Y implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final D7 f761a;
    public final C0745za b;

    public Y() {
        this(new D7(), new C0745za(20));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Ii fromModel(Z z) {
        C0317i8 c0317i8 = new C0317i8();
        c0317i8.b = this.f761a.fromModel(z.f777a);
        On a2 = this.b.a(z.b);
        c0317i8.f928a = StringUtils.getUTF8Bytes((String) a2.f625a);
        return new Ii(c0317i8, new C0312i3(C0312i3.b(a2)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Ii ii = (Ii) obj;
        throw new UnsupportedOperationException();
    }

    public Y(D7 d7, C0745za c0745za) {
        this.f761a = d7;
        this.b = c0745za;
    }

    public final Z a(Ii ii) {
        throw new UnsupportedOperationException();
    }
}
