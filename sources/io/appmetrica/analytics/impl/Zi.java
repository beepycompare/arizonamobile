package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public final class Zi implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0598te f865a;
    public final C0413m3 b;
    public final C0594ta c;
    public final C0594ta d;

    public Zi() {
        this(new C0598te(), new C0413m3(), new C0594ta(100), new C0594ta(1000));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Ei fromModel(C0198dj c0198dj) {
        Ei ei;
        C0542r8 c0542r8 = new C0542r8();
        Nn a2 = this.c.a(c0198dj.f937a);
        c0542r8.f1182a = StringUtils.getUTF8Bytes((String) a2.f694a);
        List<String> list = c0198dj.b;
        Ei ei2 = null;
        if (list != null) {
            ei = this.b.fromModel(list);
            c0542r8.b = (C0264g8) ei.f546a;
        } else {
            ei = null;
        }
        Nn a3 = this.d.a(c0198dj.c);
        c0542r8.c = StringUtils.getUTF8Bytes((String) a3.f694a);
        Map<String, String> map = c0198dj.d;
        if (map != null) {
            ei2 = this.f865a.fromModel(map);
            c0542r8.d = (C0418m8) ei2.f546a;
        }
        return new Ei(c0542r8, new C0130b3(C0130b3.b(a2, ei, a3, ei2)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Ei ei = (Ei) obj;
        throw new UnsupportedOperationException();
    }

    public Zi(C0598te c0598te, C0413m3 c0413m3, C0594ta c0594ta, C0594ta c0594ta2) {
        this.f865a = c0598te;
        this.b = c0413m3;
        this.c = c0594ta;
        this.d = c0594ta2;
    }

    public final C0198dj a(Ei ei) {
        throw new UnsupportedOperationException();
    }
}
