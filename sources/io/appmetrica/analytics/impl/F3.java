package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
/* loaded from: classes4.dex */
public final class F3 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Rf f428a;
    public final R7 b;
    public final Lf c;
    public final C0611tg d;

    public F3() {
        this(new Rf(), new R7(), new Lf(), new C0611tg());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Qi fromModel(G3 g3) {
        Qi qi;
        C0728y8 c0728y8 = new C0728y8();
        Qi fromModel = this.f428a.fromModel(g3.f445a);
        c0728y8.f1150a = (H8) fromModel.f612a;
        c0728y8.c = this.b.fromModel(g3.b);
        Qi fromModel2 = this.c.fromModel(g3.c);
        c0728y8.d = (G8) fromModel2.f612a;
        Kg kg = g3.d;
        if (kg != null) {
            qi = this.d.fromModel(kg);
            c0728y8.b = (J8) qi.f612a;
        } else {
            qi = null;
        }
        return new Qi(c0728y8, new C0673w3(C0673w3.b(fromModel, fromModel2, qi)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Qi qi = (Qi) obj;
        throw new UnsupportedOperationException();
    }

    public F3(Rf rf, R7 r7, Lf lf, C0611tg c0611tg) {
        this.f428a = rf;
        this.b = r7;
        this.c = lf;
        this.d = c0611tg;
    }

    public final G3 a(Qi qi) {
        throw new UnsupportedOperationException();
    }
}
