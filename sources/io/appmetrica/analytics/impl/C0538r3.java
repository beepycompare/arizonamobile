package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
/* renamed from: io.appmetrica.analytics.impl.r3  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0538r3 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Lf f1085a;
    public final D7 b;
    public final Cf c;
    public final C0402lg d;

    public C0538r3() {
        this(new Lf(), new D7(), new Cf(), new C0402lg());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Ii fromModel(C0563s3 c0563s3) {
        Ii ii;
        C0368k8 c0368k8 = new C0368k8();
        Ii fromModel = this.f1085a.fromModel(c0563s3.f1104a);
        c0368k8.f969a = (C0593t8) fromModel.f530a;
        c0368k8.c = this.b.fromModel(c0563s3.b);
        Ii fromModel2 = this.c.fromModel(c0563s3.c);
        c0368k8.d = (C0568s8) fromModel2.f530a;
        Cg cg = c0563s3.d;
        if (cg != null) {
            ii = this.d.fromModel(cg);
            c0368k8.b = (C0643v8) ii.f530a;
        } else {
            ii = null;
        }
        return new Ii(c0368k8, new C0312i3(C0312i3.b(fromModel, fromModel2, ii)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Ii ii = (Ii) obj;
        throw new UnsupportedOperationException();
    }

    public C0538r3(Lf lf, D7 d7, Cf cf, C0402lg c0402lg) {
        this.f1085a = lf;
        this.b = d7;
        this.c = cf;
        this.d = c0402lg;
    }

    public final C0563s3 a(Ii ii) {
        throw new UnsupportedOperationException();
    }
}
