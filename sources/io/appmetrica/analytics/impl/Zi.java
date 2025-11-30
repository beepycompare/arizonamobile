package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public final class Zi implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0599te f782a;
    public final C0414m3 b;
    public final C0595ta c;
    public final C0595ta d;

    public Zi() {
        this(new C0599te(), new C0414m3(), new C0595ta(100), new C0595ta(1000));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Ei fromModel(C0199dj c0199dj) {
        Ei ei;
        C0543r8 c0543r8 = new C0543r8();
        Nn a2 = this.c.a(c0199dj.f854a);
        c0543r8.f1099a = StringUtils.getUTF8Bytes((String) a2.f611a);
        List<String> list = c0199dj.b;
        Ei ei2 = null;
        if (list != null) {
            ei = this.b.fromModel(list);
            c0543r8.b = (C0265g8) ei.f463a;
        } else {
            ei = null;
        }
        Nn a3 = this.d.a(c0199dj.c);
        c0543r8.c = StringUtils.getUTF8Bytes((String) a3.f611a);
        Map<String, String> map = c0199dj.d;
        if (map != null) {
            ei2 = this.f782a.fromModel(map);
            c0543r8.d = (C0419m8) ei2.f463a;
        }
        return new Ei(c0543r8, new C0131b3(C0131b3.b(a2, ei, a3, ei2)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Ei ei = (Ei) obj;
        throw new UnsupportedOperationException();
    }

    public Zi(C0599te c0599te, C0414m3 c0414m3, C0595ta c0595ta, C0595ta c0595ta2) {
        this.f782a = c0599te;
        this.b = c0414m3;
        this.c = c0595ta;
        this.d = c0595ta2;
    }

    public final C0199dj a(Ei ei) {
        throw new UnsupportedOperationException();
    }
}
