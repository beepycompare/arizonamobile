package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public final class Pf implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Ee f582a;
    public final Jf b;
    public final H3 c;
    public final Tf d;
    public final La e;
    public final La f;

    public Pf() {
        this(new Ee(), new Jf(), new H3(), new Tf(), new La(100), new La(1000));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Ni fromModel(Sf sf) {
        Ni ni;
        Ni ni2;
        Ni ni3;
        Ni ni4;
        E8 e8 = new E8();
        Gn a2 = this.e.a(sf.f627a);
        e8.f405a = StringUtils.getUTF8Bytes((String) a2.f450a);
        Gn a3 = this.f.a(sf.b);
        e8.b = StringUtils.getUTF8Bytes((String) a3.f450a);
        List<String> list = sf.c;
        Ni ni5 = null;
        if (list != null) {
            ni = this.c.fromModel(list);
            e8.c = (C0675w8) ni.f557a;
        } else {
            ni = null;
        }
        Map<String, String> map = sf.d;
        if (map != null) {
            ni2 = this.f582a.fromModel(map);
            e8.d = (C8) ni2.f557a;
        } else {
            ni2 = null;
        }
        Lf lf = sf.e;
        if (lf != null) {
            ni3 = this.b.fromModel(lf);
            e8.e = (D8) ni3.f557a;
        } else {
            ni3 = null;
        }
        Lf lf2 = sf.f;
        if (lf2 != null) {
            ni4 = this.b.fromModel(lf2);
            e8.f = (D8) ni4.f557a;
        } else {
            ni4 = null;
        }
        List<String> list2 = sf.g;
        if (list2 != null) {
            ni5 = this.d.fromModel(list2);
            e8.g = (F8[]) ni5.f557a;
        }
        return new Ni(e8, new C0670w3(C0670w3.b(a2, a3, ni, ni2, ni3, ni4, ni5)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Ni ni = (Ni) obj;
        throw new UnsupportedOperationException();
    }

    public Pf(Ee ee, Jf jf, H3 h3, Tf tf, La la, La la2) {
        this.f582a = ee;
        this.b = jf;
        this.c = h3;
        this.d = tf;
        this.e = la;
        this.f = la2;
    }

    public final Sf a(Ni ni) {
        throw new UnsupportedOperationException();
    }
}
