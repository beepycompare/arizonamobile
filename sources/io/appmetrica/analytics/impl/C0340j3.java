package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
/* renamed from: io.appmetrica.analytics.impl.j3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0340j3 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Gf f1054a;
    public final C0644v7 b;
    public final C0702xf c;
    public final C0276gg d;

    public C0340j3() {
        this(new Gf(), new C0644v7(), new C0702xf(), new C0276gg());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Di fromModel(C0366k3 c0366k3) {
        Di di;
        C0216e8 c0216e8 = new C0216e8();
        Di fromModel = this.f1054a.fromModel(c0366k3.f1073a);
        c0216e8.f974a = (C0446n8) fromModel.f552a;
        c0216e8.c = this.b.fromModel(c0366k3.b);
        Di fromModel2 = this.c.fromModel(c0366k3.c);
        c0216e8.d = (C0421m8) fromModel2.f552a;
        C0703xg c0703xg = c0366k3.d;
        if (c0703xg != null) {
            di = this.d.fromModel(c0703xg);
            c0216e8.b = (C0496p8) di.f552a;
        } else {
            di = null;
        }
        return new Di(c0216e8, new C0108a3(C0108a3.b(fromModel, fromModel2, di)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Di di = (Di) obj;
        throw new UnsupportedOperationException();
    }

    public C0340j3(Gf gf, C0644v7 c0644v7, C0702xf c0702xf, C0276gg c0276gg) {
        this.f1054a = gf;
        this.b = c0644v7;
        this.c = c0702xf;
        this.d = c0276gg;
    }

    public final C0366k3 a(Di di) {
        throw new UnsupportedOperationException();
    }
}
