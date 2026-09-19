package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.hg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0302hg implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Te f1018a;
    public final Yf b;
    public final C3 c;
    public final C0353jg d;
    public final Va e;
    public final Va f;

    public C0302hg() {
        this(new Te(), new Yf(), new C3(), new C0353jg(), new Va(100), new Va(1000));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Xi fromModel(C0327ig c0327ig) {
        Xi xi;
        Xi xi2;
        Xi xi3;
        Xi xi4;
        G8 g8 = new G8();
        C0517po a2 = this.e.a(c0327ig.f1035a);
        g8.f563a = StringUtils.getUTF8Bytes((String) a2.f1155a);
        C0517po a3 = this.f.a(c0327ig.b);
        g8.b = StringUtils.getUTF8Bytes((String) a3.f1155a);
        List<String> list = c0327ig.c;
        Xi xi5 = null;
        if (list != null) {
            xi = this.c.fromModel(list);
            g8.c = (C0734y8) xi.f841a;
        } else {
            xi = null;
        }
        Map<String, String> map = c0327ig.d;
        if (map != null) {
            xi2 = this.f1018a.fromModel(map);
            g8.d = (E8) xi2.f841a;
        } else {
            xi2 = null;
        }
        C0121ag c0121ag = c0327ig.e;
        if (c0121ag != null) {
            xi3 = this.b.fromModel(c0121ag);
            g8.e = (F8) xi3.f841a;
        } else {
            xi3 = null;
        }
        C0121ag c0121ag2 = c0327ig.f;
        if (c0121ag2 != null) {
            xi4 = this.b.fromModel(c0121ag2);
            g8.f = (F8) xi4.f841a;
        } else {
            xi4 = null;
        }
        List<String> list2 = c0327ig.g;
        if (list2 != null) {
            xi5 = this.d.fromModel(list2);
            g8.g = (H8[]) xi5.f841a;
        }
        return new Xi(g8, new C0522q3(C0522q3.b(a2, a3, xi, xi2, xi3, xi4, xi5)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Xi xi = (Xi) obj;
        throw new UnsupportedOperationException();
    }

    public C0302hg(Te te, Yf yf, C3 c3, C0353jg c0353jg, Va va, Va va2) {
        this.f1018a = te;
        this.b = yf;
        this.c = c3;
        this.d = c0353jg;
        this.e = va;
        this.f = va2;
    }

    public final C0327ig a(Xi xi) {
        throw new UnsupportedOperationException();
    }
}
