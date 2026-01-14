package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
/* renamed from: io.appmetrica.analytics.impl.j3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0341j3 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Gf f1055a;
    public final C0645v7 b;
    public final C0703xf c;
    public final C0277gg d;

    public C0341j3() {
        this(new Gf(), new C0645v7(), new C0703xf(), new C0277gg());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Di fromModel(C0367k3 c0367k3) {
        Di di;
        C0217e8 c0217e8 = new C0217e8();
        Di fromModel = this.f1055a.fromModel(c0367k3.f1074a);
        c0217e8.f975a = (C0447n8) fromModel.f553a;
        c0217e8.c = this.b.fromModel(c0367k3.b);
        Di fromModel2 = this.c.fromModel(c0367k3.c);
        c0217e8.d = (C0422m8) fromModel2.f553a;
        C0704xg c0704xg = c0367k3.d;
        if (c0704xg != null) {
            di = this.d.fromModel(c0704xg);
            c0217e8.b = (C0497p8) di.f553a;
        } else {
            di = null;
        }
        return new Di(c0217e8, new C0109a3(C0109a3.b(fromModel, fromModel2, di)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Di di = (Di) obj;
        throw new UnsupportedOperationException();
    }

    public C0341j3(Gf gf, C0645v7 c0645v7, C0703xf c0703xf, C0277gg c0277gg) {
        this.f1055a = gf;
        this.b = c0645v7;
        this.c = c0703xf;
        this.d = c0277gg;
    }

    public final C0367k3 a(Di di) {
        throw new UnsupportedOperationException();
    }
}
