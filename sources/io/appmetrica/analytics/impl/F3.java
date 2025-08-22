package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
/* loaded from: classes4.dex */
public final class F3 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Wf f425a;
    public final S7 b;
    public final Nf c;
    public final C0733yg d;

    public F3() {
        this(new Wf(), new S7(), new Nf(), new C0733yg());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Vi fromModel(G3 g3) {
        Vi vi;
        A8 a8 = new A8();
        Vi fromModel = this.f425a.fromModel(g3.f447a);
        a8.f342a = (J8) fromModel.f697a;
        a8.c = this.b.fromModel(g3.b);
        Vi fromModel2 = this.c.fromModel(g3.c);
        a8.d = (I8) fromModel2.f697a;
        Pg pg = g3.d;
        if (pg != null) {
            vi = this.d.fromModel(pg);
            a8.b = (L8) vi.f697a;
        } else {
            vi = null;
        }
        return new Vi(a8, new C0670w3(C0670w3.b(fromModel, fromModel2, vi)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Vi vi = (Vi) obj;
        throw new UnsupportedOperationException();
    }

    public F3(Wf wf, S7 s7, Nf nf, C0733yg c0733yg) {
        this.f425a = wf;
        this.b = s7;
        this.c = nf;
        this.d = c0733yg;
    }

    public final G3 a(Vi vi) {
        throw new UnsupportedOperationException();
    }
}
