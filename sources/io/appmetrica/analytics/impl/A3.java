package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
/* loaded from: classes5.dex */
public final class A3 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0302hg f451a;
    public final N7 b;
    public final Yf c;
    public final C0742yg d;

    public A3() {
        this(new C0302hg(), new N7(), new Yf(), new C0742yg());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Xi fromModel(B3 b3) {
        Xi xi;
        C0708x8 c0708x8 = new C0708x8();
        Xi fromModel = this.f451a.fromModel(b3.f468a);
        c0708x8.f1279a = (G8) fromModel.f841a;
        c0708x8.c = this.b.fromModel(b3.b);
        Xi fromModel2 = this.c.fromModel(b3.c);
        c0708x8.d = (F8) fromModel2.f841a;
        Ng ng = b3.d;
        if (ng != null) {
            xi = this.d.fromModel(ng);
            c0708x8.b = (I8) xi.f841a;
        } else {
            xi = null;
        }
        return new Xi(c0708x8, new C0522q3(C0522q3.b(fromModel, fromModel2, xi)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Xi xi = (Xi) obj;
        throw new UnsupportedOperationException();
    }

    public A3(C0302hg c0302hg, N7 n7, Yf yf, C0742yg c0742yg) {
        this.f451a = c0302hg;
        this.b = n7;
        this.c = yf;
        this.d = c0742yg;
    }

    public final B3 a(Xi xi) {
        throw new UnsupportedOperationException();
    }
}
