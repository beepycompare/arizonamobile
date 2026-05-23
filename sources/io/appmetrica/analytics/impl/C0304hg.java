package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.hg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0304hg implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Te f1015a;
    public final Yf b;
    public final C3 c;
    public final C0355jg d;
    public final Va e;
    public final Va f;

    public C0304hg() {
        this(new Te(), new Yf(), new C3(), new C0355jg(), new Va(100), new Va(1000));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Xi fromModel(C0329ig c0329ig) {
        Xi xi;
        Xi xi2;
        Xi xi3;
        Xi xi4;
        G8 g8 = new G8();
        C0519po a2 = this.e.a(c0329ig.f1032a);
        g8.f560a = StringUtils.getUTF8Bytes((String) a2.f1152a);
        C0519po a3 = this.f.a(c0329ig.b);
        g8.b = StringUtils.getUTF8Bytes((String) a3.f1152a);
        List<String> list = c0329ig.c;
        Xi xi5 = null;
        if (list != null) {
            xi = this.c.fromModel(list);
            g8.c = (C0736y8) xi.f838a;
        } else {
            xi = null;
        }
        Map<String, String> map = c0329ig.d;
        if (map != null) {
            xi2 = this.f1015a.fromModel(map);
            g8.d = (E8) xi2.f838a;
        } else {
            xi2 = null;
        }
        C0123ag c0123ag = c0329ig.e;
        if (c0123ag != null) {
            xi3 = this.b.fromModel(c0123ag);
            g8.e = (F8) xi3.f838a;
        } else {
            xi3 = null;
        }
        C0123ag c0123ag2 = c0329ig.f;
        if (c0123ag2 != null) {
            xi4 = this.b.fromModel(c0123ag2);
            g8.f = (F8) xi4.f838a;
        } else {
            xi4 = null;
        }
        List<String> list2 = c0329ig.g;
        if (list2 != null) {
            xi5 = this.d.fromModel(list2);
            g8.g = (H8[]) xi5.f838a;
        }
        return new Xi(g8, new C0524q3(C0524q3.b(a2, a3, xi, xi2, xi3, xi4, xi5)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Xi xi = (Xi) obj;
        throw new UnsupportedOperationException();
    }

    public C0304hg(Te te, Yf yf, C3 c3, C0355jg c0355jg, Va va, Va va2) {
        this.f1015a = te;
        this.b = yf;
        this.c = c3;
        this.d = c0355jg;
        this.e = va;
        this.f = va2;
    }

    public final C0329ig a(Xi xi) {
        throw new UnsupportedOperationException();
    }
}
