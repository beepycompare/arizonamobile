package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public final class Lf implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0724ye f576a;
    public final Cf b;
    public final C0588t3 c;
    public final Nf d;
    public final C0745za e;
    public final C0745za f;

    public Lf() {
        this(new C0724ye(), new Cf(), new C0588t3(), new Nf(), new C0745za(100), new C0745za(1000));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Ii fromModel(Mf mf) {
        Ii ii;
        Ii ii2;
        Ii ii3;
        Ii ii4;
        C0593t8 c0593t8 = new C0593t8();
        On a2 = this.e.a(mf.f592a);
        c0593t8.f1129a = StringUtils.getUTF8Bytes((String) a2.f625a);
        On a3 = this.f.a(mf.b);
        c0593t8.b = StringUtils.getUTF8Bytes((String) a3.f625a);
        List<String> list = mf.c;
        Ii ii5 = null;
        if (list != null) {
            ii = this.c.fromModel(list);
            c0593t8.c = (C0394l8) ii.f530a;
        } else {
            ii = null;
        }
        Map<String, String> map = mf.d;
        if (map != null) {
            ii2 = this.f576a.fromModel(map);
            c0593t8.d = (C0543r8) ii2.f530a;
        } else {
            ii2 = null;
        }
        Ef ef = mf.e;
        if (ef != null) {
            ii3 = this.b.fromModel(ef);
            c0593t8.e = (C0568s8) ii3.f530a;
        } else {
            ii3 = null;
        }
        Ef ef2 = mf.f;
        if (ef2 != null) {
            ii4 = this.b.fromModel(ef2);
            c0593t8.f = (C0568s8) ii4.f530a;
        } else {
            ii4 = null;
        }
        List<String> list2 = mf.g;
        if (list2 != null) {
            ii5 = this.d.fromModel(list2);
            c0593t8.g = (C0618u8[]) ii5.f530a;
        }
        return new Ii(c0593t8, new C0312i3(C0312i3.b(a2, a3, ii, ii2, ii3, ii4, ii5)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Ii ii = (Ii) obj;
        throw new UnsupportedOperationException();
    }

    public Lf(C0724ye c0724ye, Cf cf, C0588t3 c0588t3, Nf nf, C0745za c0745za, C0745za c0745za2) {
        this.f576a = c0724ye;
        this.b = cf;
        this.c = c0588t3;
        this.d = nf;
        this.e = c0745za;
        this.f = c0745za2;
    }

    public final Mf a(Ii ii) {
        throw new UnsupportedOperationException();
    }
}
