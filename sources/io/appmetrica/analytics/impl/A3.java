package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
/* loaded from: classes5.dex */
public final class A3 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0297hg f454a;
    public final N7 b;
    public final Yf c;
    public final C0737yg d;

    public A3() {
        this(new C0297hg(), new N7(), new Yf(), new C0737yg());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Xi fromModel(B3 b3) {
        Xi xi;
        C0703x8 c0703x8 = new C0703x8();
        Xi fromModel = this.f454a.fromModel(b3.f471a);
        c0703x8.f1282a = (G8) fromModel.f844a;
        c0703x8.c = this.b.fromModel(b3.b);
        Xi fromModel2 = this.c.fromModel(b3.c);
        c0703x8.d = (F8) fromModel2.f844a;
        Ng ng = b3.d;
        if (ng != null) {
            xi = this.d.fromModel(ng);
            c0703x8.b = (I8) xi.f844a;
        } else {
            xi = null;
        }
        return new Xi(c0703x8, new C0517q3(C0517q3.b(fromModel, fromModel2, xi)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Xi xi = (Xi) obj;
        throw new UnsupportedOperationException();
    }

    public A3(C0297hg c0297hg, N7 n7, Yf yf, C0737yg c0737yg) {
        this.f454a = c0297hg;
        this.b = n7;
        this.c = yf;
        this.d = c0737yg;
    }

    public final B3 a(Xi xi) {
        throw new UnsupportedOperationException();
    }
}
