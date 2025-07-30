package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public final class Rf implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Ge f624a;
    public final Lf b;
    public final H3 c;
    public final Vf d;
    public final Na e;
    public final Na f;

    public Rf() {
        this(new Ge(), new Lf(), new H3(), new Vf(), new Na(100), new Na(1000));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Qi fromModel(Uf uf) {
        Qi qi;
        Qi qi2;
        Qi qi3;
        Qi qi4;
        H8 h8 = new H8();
        Jn a2 = this.e.a(uf.f672a);
        h8.f469a = StringUtils.getUTF8Bytes((String) a2.f512a);
        Jn a3 = this.f.a(uf.b);
        h8.b = StringUtils.getUTF8Bytes((String) a3.f512a);
        List<String> list = uf.c;
        Qi qi5 = null;
        if (list != null) {
            qi = this.c.fromModel(list);
            h8.c = (C0752z8) qi.f613a;
        } else {
            qi = null;
        }
        Map<String, String> map = uf.d;
        if (map != null) {
            qi2 = this.f624a.fromModel(map);
            h8.d = (F8) qi2.f613a;
        } else {
            qi2 = null;
        }
        Nf nf = uf.e;
        if (nf != null) {
            qi3 = this.b.fromModel(nf);
            h8.e = (G8) qi3.f613a;
        } else {
            qi3 = null;
        }
        Nf nf2 = uf.f;
        if (nf2 != null) {
            qi4 = this.b.fromModel(nf2);
            h8.f = (G8) qi4.f613a;
        } else {
            qi4 = null;
        }
        List<String> list2 = uf.g;
        if (list2 != null) {
            qi5 = this.d.fromModel(list2);
            h8.g = (I8[]) qi5.f613a;
        }
        return new Qi(h8, new C0672w3(C0672w3.b(a2, a3, qi, qi2, qi3, qi4, qi5)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Qi qi = (Qi) obj;
        throw new UnsupportedOperationException();
    }

    public Rf(Ge ge, Lf lf, H3 h3, Vf vf, Na na, Na na2) {
        this.f624a = ge;
        this.b = lf;
        this.c = h3;
        this.d = vf;
        this.e = na;
        this.f = na2;
    }

    public final Uf a(Qi qi) {
        throw new UnsupportedOperationException();
    }
}
