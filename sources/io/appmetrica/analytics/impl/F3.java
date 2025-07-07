package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
/* loaded from: classes4.dex */
public final class F3 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Pf f421a;
    public final O7 b;
    public final Jf c;
    public final C0566rg d;

    public F3() {
        this(new Pf(), new O7(), new Jf(), new C0566rg());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Ni fromModel(G3 g3) {
        Ni ni;
        C0658v8 c0658v8 = new C0658v8();
        Ni fromModel = this.f421a.fromModel(g3.f436a);
        c0658v8.f1087a = (E8) fromModel.f556a;
        c0658v8.c = this.b.fromModel(g3.b);
        Ni fromModel2 = this.c.fromModel(g3.c);
        c0658v8.d = (D8) fromModel2.f556a;
        Ig ig = g3.d;
        if (ig != null) {
            ni = this.d.fromModel(ig);
            c0658v8.b = (G8) ni.f556a;
        } else {
            ni = null;
        }
        return new Ni(c0658v8, new C0678w3(C0678w3.b(fromModel, fromModel2, ni)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Ni ni = (Ni) obj;
        throw new UnsupportedOperationException();
    }

    public F3(Pf pf, O7 o7, Jf jf, C0566rg c0566rg) {
        this.f421a = pf;
        this.b = o7;
        this.c = jf;
        this.d = c0566rg;
    }

    public final G3 a(Ni ni) {
        throw new UnsupportedOperationException();
    }
}
