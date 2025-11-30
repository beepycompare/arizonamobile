package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
/* renamed from: io.appmetrica.analytics.impl.k3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0363k3 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Hf f967a;
    public final C0667w7 b;
    public final C0725yf c;
    public final C0299hg d;

    public C0363k3() {
        this(new Hf(), new C0667w7(), new C0725yf(), new C0299hg());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Ei fromModel(C0389l3 c0389l3) {
        Ei ei;
        C0239f8 c0239f8 = new C0239f8();
        Ei fromModel = this.f967a.fromModel(c0389l3.f985a);
        c0239f8.f887a = (C0469o8) fromModel.f463a;
        c0239f8.c = this.b.fromModel(c0389l3.b);
        Ei fromModel2 = this.c.fromModel(c0389l3.c);
        c0239f8.d = (C0444n8) fromModel2.f463a;
        C0726yg c0726yg = c0389l3.d;
        if (c0726yg != null) {
            ei = this.d.fromModel(c0726yg);
            c0239f8.b = (C0519q8) ei.f463a;
        } else {
            ei = null;
        }
        return new Ei(c0239f8, new C0131b3(C0131b3.b(fromModel, fromModel2, ei)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Ei ei = (Ei) obj;
        throw new UnsupportedOperationException();
    }

    public C0363k3(Hf hf, C0667w7 c0667w7, C0725yf c0725yf, C0299hg c0299hg) {
        this.f967a = hf;
        this.b = c0667w7;
        this.c = c0725yf;
        this.d = c0299hg;
    }

    public final C0389l3 a(Ei ei) {
        throw new UnsupportedOperationException();
    }
}
