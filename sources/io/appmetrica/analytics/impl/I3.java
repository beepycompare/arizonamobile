package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
/* loaded from: classes4.dex */
public final class I3 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0125ag f488a;
    public final V7 b;
    public final Rf c;
    public final Cg d;

    public I3() {
        this(new C0125ag(), new V7(), new Rf(), new Cg());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Zi fromModel(J3 j3) {
        Zi zi;
        D8 d8 = new D8();
        Zi fromModel = this.f488a.fromModel(j3.f509a);
        d8.f406a = (M8) fromModel.f777a;
        d8.c = this.b.fromModel(j3.b);
        Zi fromModel2 = this.c.fromModel(j3.c);
        d8.d = (L8) fromModel2.f777a;
        Tg tg = j3.d;
        if (tg != null) {
            zi = this.d.fromModel(tg);
            d8.b = (O8) zi.f777a;
        } else {
            zi = null;
        }
        return new Zi(d8, new C0749z3(C0749z3.b(fromModel, fromModel2, zi)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Zi zi = (Zi) obj;
        throw new UnsupportedOperationException();
    }

    public I3(C0125ag c0125ag, V7 v7, Rf rf, Cg cg) {
        this.f488a = c0125ag;
        this.b = v7;
        this.c = rf;
        this.d = cg;
    }

    public final J3 a(Zi zi) {
        throw new UnsupportedOperationException();
    }
}
