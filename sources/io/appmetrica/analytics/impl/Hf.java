package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public final class Hf implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0598te f591a;
    public final C0724yf b;
    public final C0413m3 c;
    public final Jf d;
    public final C0594ta e;
    public final C0594ta f;

    public Hf() {
        this(new C0598te(), new C0724yf(), new C0413m3(), new Jf(), new C0594ta(100), new C0594ta(1000));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Ei fromModel(If r10) {
        Ei ei;
        Ei ei2;
        Ei ei3;
        Ei ei4;
        C0468o8 c0468o8 = new C0468o8();
        Nn a2 = this.e.a(r10.f607a);
        c0468o8.f1127a = StringUtils.getUTF8Bytes((String) a2.f694a);
        Nn a3 = this.f.a(r10.b);
        c0468o8.b = StringUtils.getUTF8Bytes((String) a3.f694a);
        List<String> list = r10.c;
        Ei ei5 = null;
        if (list != null) {
            ei = this.c.fromModel(list);
            c0468o8.c = (C0264g8) ei.f546a;
        } else {
            ei = null;
        }
        Map<String, String> map = r10.d;
        if (map != null) {
            ei2 = this.f591a.fromModel(map);
            c0468o8.d = (C0418m8) ei2.f546a;
        } else {
            ei2 = null;
        }
        Af af = r10.e;
        if (af != null) {
            ei3 = this.b.fromModel(af);
            c0468o8.e = (C0443n8) ei3.f546a;
        } else {
            ei3 = null;
        }
        Af af2 = r10.f;
        if (af2 != null) {
            ei4 = this.b.fromModel(af2);
            c0468o8.f = (C0443n8) ei4.f546a;
        } else {
            ei4 = null;
        }
        List<String> list2 = r10.g;
        if (list2 != null) {
            ei5 = this.d.fromModel(list2);
            c0468o8.g = (C0493p8[]) ei5.f546a;
        }
        return new Ei(c0468o8, new C0130b3(C0130b3.b(a2, a3, ei, ei2, ei3, ei4, ei5)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Ei ei = (Ei) obj;
        throw new UnsupportedOperationException();
    }

    public Hf(C0598te c0598te, C0724yf c0724yf, C0413m3 c0413m3, Jf jf, C0594ta c0594ta, C0594ta c0594ta2) {
        this.f591a = c0598te;
        this.b = c0724yf;
        this.c = c0413m3;
        this.d = jf;
        this.e = c0594ta;
        this.f = c0594ta2;
    }

    public final If a(Ei ei) {
        throw new UnsupportedOperationException();
    }
}
