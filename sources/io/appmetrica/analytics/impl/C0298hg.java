package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* renamed from: io.appmetrica.analytics.impl.hg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0298hg implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Zi f1007a;
    public final C0594ta b;
    public final C0594ta c;

    public C0298hg() {
        this(new Zi(), new C0594ta(100), new C0594ta(2048));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Ei fromModel(C0725yg c0725yg) {
        Ei ei;
        C0518q8 c0518q8 = new C0518q8();
        Nn a2 = this.b.a(c0725yg.f1303a);
        c0518q8.f1167a = StringUtils.getUTF8Bytes((String) a2.f694a);
        Nn a3 = this.c.a(c0725yg.b);
        c0518q8.b = StringUtils.getUTF8Bytes((String) a3.f694a);
        C0198dj c0198dj = c0725yg.c;
        if (c0198dj != null) {
            ei = this.f1007a.fromModel(c0198dj);
            c0518q8.c = (C0542r8) ei.f546a;
        } else {
            ei = null;
        }
        return new Ei(c0518q8, new C0130b3(C0130b3.b(a2, a3, ei)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Ei ei = (Ei) obj;
        throw new UnsupportedOperationException();
    }

    public C0298hg(Zi zi, C0594ta c0594ta, C0594ta c0594ta2) {
        this.f1007a = zi;
        this.b = c0594ta;
        this.c = c0594ta2;
    }

    public final C0725yg a(Ei ei) {
        throw new UnsupportedOperationException();
    }
}
