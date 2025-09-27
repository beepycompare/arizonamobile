package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* loaded from: classes4.dex */
public final class Cg implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0640uj f391a;
    public final Sa b;
    public final Sa c;

    public Cg() {
        this(new C0640uj(), new Sa(100), new Sa(2048));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Zi fromModel(Tg tg) {
        Zi zi;
        O8 o8 = new O8();
        Sn a2 = this.b.a(tg.f687a);
        o8.f606a = StringUtils.getUTF8Bytes((String) a2.f676a);
        Sn a3 = this.c.a(tg.b);
        o8.b = StringUtils.getUTF8Bytes((String) a3.f676a);
        C0740yj c0740yj = tg.c;
        if (c0740yj != null) {
            zi = this.f391a.fromModel(c0740yj);
            o8.c = (P8) zi.f777a;
        } else {
            zi = null;
        }
        return new Zi(o8, new C0749z3(C0749z3.b(a2, a3, zi)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Zi zi = (Zi) obj;
        throw new UnsupportedOperationException();
    }

    public Cg(C0640uj c0640uj, Sa sa, Sa sa2) {
        this.f391a = c0640uj;
        this.b = sa;
        this.c = sa2;
    }

    public final Tg a(Zi zi) {
        throw new UnsupportedOperationException();
    }
}
