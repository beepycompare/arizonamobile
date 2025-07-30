package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public final class E3 implements InterfaceC0652v8 {

    /* renamed from: a  reason: collision with root package name */
    public final F3 f410a;

    public E3() {
        this(new F3());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Qi> fromModel(D3 d3) {
        O8 o8 = new O8();
        o8.e = new C0702x8();
        Qi fromModel = this.f410a.fromModel(d3.b);
        o8.e.f1134a = (C0727y8) fromModel.f613a;
        o8.f576a = d3.f390a;
        return Collections.singletonList(new Qi(o8, new C0672w3(C0672w3.b(fromModel))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public E3(F3 f3) {
        this.f410a = f3;
    }

    public final D3 a(List<Qi> list) {
        throw new UnsupportedOperationException();
    }
}
