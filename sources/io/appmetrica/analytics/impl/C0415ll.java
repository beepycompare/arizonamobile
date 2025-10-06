package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.ll  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0415ll implements A8 {

    /* renamed from: a  reason: collision with root package name */
    public final C0641uj f978a;
    public final C0126ag b;

    public C0415ll() {
        this(new C0641uj(), new C0126ag());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Zi> fromModel(C0389kl c0389kl) {
        T8 t8 = new T8();
        t8.f683a = 2;
        t8.c = new Q8();
        Zi fromModel = this.f978a.fromModel(c0389kl.b);
        t8.c.b = (P8) fromModel.f777a;
        Zi fromModel2 = this.b.fromModel(c0389kl.f959a);
        t8.c.f639a = (M8) fromModel2.f777a;
        return Collections.singletonList(new Zi(t8, new C0750z3(C0750z3.b(fromModel, fromModel2))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public C0415ll(C0641uj c0641uj, C0126ag c0126ag) {
        this.f978a = c0641uj;
        this.b = c0126ag;
    }

    public final C0389kl a(List<Zi> list) {
        throw new UnsupportedOperationException();
    }
}
