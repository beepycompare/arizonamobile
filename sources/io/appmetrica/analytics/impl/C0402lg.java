package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* renamed from: io.appmetrica.analytics.impl.lg  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0402lg implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0199dj f991a;
    public final C0745za b;
    public final C0745za c;

    public C0402lg() {
        this(new C0199dj(), new C0745za(100), new C0745za(2048));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Ii fromModel(Cg cg) {
        Ii ii;
        C0643v8 c0643v8 = new C0643v8();
        On a2 = this.b.a(cg.f426a);
        c0643v8.f1165a = StringUtils.getUTF8Bytes((String) a2.f625a);
        On a3 = this.c.a(cg.b);
        c0643v8.b = StringUtils.getUTF8Bytes((String) a3.f625a);
        C0302hj c0302hj = cg.c;
        if (c0302hj != null) {
            ii = this.f991a.fromModel(c0302hj);
            c0643v8.c = (C0668w8) ii.f530a;
        } else {
            ii = null;
        }
        return new Ii(c0643v8, new C0312i3(C0312i3.b(a2, a3, ii)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Ii ii = (Ii) obj;
        throw new UnsupportedOperationException();
    }

    public C0402lg(C0199dj c0199dj, C0745za c0745za, C0745za c0745za2) {
        this.f991a = c0199dj;
        this.b = c0745za;
        this.c = c0745za2;
    }

    public final Cg a(Ii ii) {
        throw new UnsupportedOperationException();
    }
}
