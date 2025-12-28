package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
/* renamed from: io.appmetrica.analytics.impl.k3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0362k3 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Hf f1065a;
    public final C0666w7 b;
    public final C0724yf c;
    public final C0298hg d;

    public C0362k3() {
        this(new Hf(), new C0666w7(), new C0724yf(), new C0298hg());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Ei fromModel(C0388l3 c0388l3) {
        Ei ei;
        C0238f8 c0238f8 = new C0238f8();
        Ei fromModel = this.f1065a.fromModel(c0388l3.f1083a);
        c0238f8.f985a = (C0468o8) fromModel.f561a;
        c0238f8.c = this.b.fromModel(c0388l3.b);
        Ei fromModel2 = this.c.fromModel(c0388l3.c);
        c0238f8.d = (C0443n8) fromModel2.f561a;
        C0725yg c0725yg = c0388l3.d;
        if (c0725yg != null) {
            ei = this.d.fromModel(c0725yg);
            c0238f8.b = (C0518q8) ei.f561a;
        } else {
            ei = null;
        }
        return new Ei(c0238f8, new C0130b3(C0130b3.b(fromModel, fromModel2, ei)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Ei ei = (Ei) obj;
        throw new UnsupportedOperationException();
    }

    public C0362k3(Hf hf, C0666w7 c0666w7, C0724yf c0724yf, C0298hg c0298hg) {
        this.f1065a = hf;
        this.b = c0666w7;
        this.c = c0724yf;
        this.d = c0298hg;
    }

    public final C0388l3 a(Ei ei) {
        throw new UnsupportedOperationException();
    }
}
