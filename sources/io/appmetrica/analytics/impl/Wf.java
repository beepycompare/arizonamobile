package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public final class Wf implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Ie f710a;
    public final Nf b;
    public final H3 c;
    public final C0125ag d;
    public final Pa e;
    public final Pa f;

    public Wf() {
        this(new Ie(), new Nf(), new H3(), new C0125ag(), new Pa(100), new Pa(1000));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Vi fromModel(Zf zf) {
        Vi vi;
        Vi vi2;
        Vi vi3;
        Vi vi4;
        J8 j8 = new J8();
        On a2 = this.e.a(zf.f759a);
        j8.f512a = StringUtils.getUTF8Bytes((String) a2.f594a);
        On a3 = this.f.a(zf.b);
        j8.b = StringUtils.getUTF8Bytes((String) a3.f594a);
        List<String> list = zf.c;
        Vi vi5 = null;
        if (list != null) {
            vi = this.c.fromModel(list);
            j8.c = (B8) vi.f697a;
        } else {
            vi = null;
        }
        Map<String, String> map = zf.d;
        if (map != null) {
            vi2 = this.f710a.fromModel(map);
            j8.d = (H8) vi2.f697a;
        } else {
            vi2 = null;
        }
        Pf pf = zf.e;
        if (pf != null) {
            vi3 = this.b.fromModel(pf);
            j8.e = (I8) vi3.f697a;
        } else {
            vi3 = null;
        }
        Pf pf2 = zf.f;
        if (pf2 != null) {
            vi4 = this.b.fromModel(pf2);
            j8.f = (I8) vi4.f697a;
        } else {
            vi4 = null;
        }
        List<String> list2 = zf.g;
        if (list2 != null) {
            vi5 = this.d.fromModel(list2);
            j8.g = (K8[]) vi5.f697a;
        }
        return new Vi(j8, new C0670w3(C0670w3.b(a2, a3, vi, vi2, vi3, vi4, vi5)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Vi vi = (Vi) obj;
        throw new UnsupportedOperationException();
    }

    public Wf(Ie ie, Nf nf, H3 h3, C0125ag c0125ag, Pa pa, Pa pa2) {
        this.f710a = ie;
        this.b = nf;
        this.c = h3;
        this.d = c0125ag;
        this.e = pa;
        this.f = pa2;
    }

    public final Zf a(Vi vi) {
        throw new UnsupportedOperationException();
    }
}
