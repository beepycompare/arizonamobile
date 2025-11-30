package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* renamed from: io.appmetrica.analytics.impl.hg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0299hg implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Zi f924a;
    public final C0595ta b;
    public final C0595ta c;

    public C0299hg() {
        this(new Zi(), new C0595ta(100), new C0595ta(2048));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Ei fromModel(C0726yg c0726yg) {
        Ei ei;
        C0519q8 c0519q8 = new C0519q8();
        Nn a2 = this.b.a(c0726yg.f1220a);
        c0519q8.f1084a = StringUtils.getUTF8Bytes((String) a2.f611a);
        Nn a3 = this.c.a(c0726yg.b);
        c0519q8.b = StringUtils.getUTF8Bytes((String) a3.f611a);
        C0199dj c0199dj = c0726yg.c;
        if (c0199dj != null) {
            ei = this.f924a.fromModel(c0199dj);
            c0519q8.c = (C0543r8) ei.f463a;
        } else {
            ei = null;
        }
        return new Ei(c0519q8, new C0131b3(C0131b3.b(a2, a3, ei)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Ei ei = (Ei) obj;
        throw new UnsupportedOperationException();
    }

    public C0299hg(Zi zi, C0595ta c0595ta, C0595ta c0595ta2) {
        this.f924a = zi;
        this.b = c0595ta;
        this.c = c0595ta2;
    }

    public final C0726yg a(Ei ei) {
        throw new UnsupportedOperationException();
    }
}
