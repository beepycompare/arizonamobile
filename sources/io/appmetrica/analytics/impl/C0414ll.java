package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.ll  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0414ll implements A8 {

    /* renamed from: a  reason: collision with root package name */
    public final C0640uj f977a;
    public final C0125ag b;

    public C0414ll() {
        this(new C0640uj(), new C0125ag());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Zi> fromModel(C0388kl c0388kl) {
        T8 t8 = new T8();
        t8.f682a = 2;
        t8.c = new Q8();
        Zi fromModel = this.f977a.fromModel(c0388kl.b);
        t8.c.b = (P8) fromModel.f776a;
        Zi fromModel2 = this.b.fromModel(c0388kl.f958a);
        t8.c.f638a = (M8) fromModel2.f776a;
        return Collections.singletonList(new Zi(t8, new C0749z3(C0749z3.b(fromModel, fromModel2))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public C0414ll(C0640uj c0640uj, C0125ag c0125ag) {
        this.f977a = c0640uj;
        this.b = c0125ag;
    }

    public final C0388kl a(List<Zi> list) {
        throw new UnsupportedOperationException();
    }
}
