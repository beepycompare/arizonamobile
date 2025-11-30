package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public final class Hf implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0599te f508a;
    public final C0725yf b;
    public final C0414m3 c;
    public final Jf d;
    public final C0595ta e;
    public final C0595ta f;

    public Hf() {
        this(new C0599te(), new C0725yf(), new C0414m3(), new Jf(), new C0595ta(100), new C0595ta(1000));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Ei fromModel(If r10) {
        Ei ei;
        Ei ei2;
        Ei ei3;
        Ei ei4;
        C0469o8 c0469o8 = new C0469o8();
        Nn a2 = this.e.a(r10.f524a);
        c0469o8.f1044a = StringUtils.getUTF8Bytes((String) a2.f611a);
        Nn a3 = this.f.a(r10.b);
        c0469o8.b = StringUtils.getUTF8Bytes((String) a3.f611a);
        List<String> list = r10.c;
        Ei ei5 = null;
        if (list != null) {
            ei = this.c.fromModel(list);
            c0469o8.c = (C0265g8) ei.f463a;
        } else {
            ei = null;
        }
        Map<String, String> map = r10.d;
        if (map != null) {
            ei2 = this.f508a.fromModel(map);
            c0469o8.d = (C0419m8) ei2.f463a;
        } else {
            ei2 = null;
        }
        Af af = r10.e;
        if (af != null) {
            ei3 = this.b.fromModel(af);
            c0469o8.e = (C0444n8) ei3.f463a;
        } else {
            ei3 = null;
        }
        Af af2 = r10.f;
        if (af2 != null) {
            ei4 = this.b.fromModel(af2);
            c0469o8.f = (C0444n8) ei4.f463a;
        } else {
            ei4 = null;
        }
        List<String> list2 = r10.g;
        if (list2 != null) {
            ei5 = this.d.fromModel(list2);
            c0469o8.g = (C0494p8[]) ei5.f463a;
        }
        return new Ei(c0469o8, new C0131b3(C0131b3.b(a2, a3, ei, ei2, ei3, ei4, ei5)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Ei ei = (Ei) obj;
        throw new UnsupportedOperationException();
    }

    public Hf(C0599te c0599te, C0725yf c0725yf, C0414m3 c0414m3, Jf jf, C0595ta c0595ta, C0595ta c0595ta2) {
        this.f508a = c0599te;
        this.b = c0725yf;
        this.c = c0414m3;
        this.d = jf;
        this.e = c0595ta;
        this.f = c0595ta2;
    }

    public final If a(Ei ei) {
        throw new UnsupportedOperationException();
    }
}
