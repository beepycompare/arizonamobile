package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public final class E3 implements InterfaceC0700x8 {

    /* renamed from: a  reason: collision with root package name */
    public final F3 f406a;

    public E3() {
        this(new F3());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Vi> fromModel(D3 d3) {
        Q8 q8 = new Q8();
        q8.e = new C0750z8();
        Vi fromModel = this.f406a.fromModel(d3.b);
        q8.e.f1175a = (A8) fromModel.f697a;
        q8.f617a = d3.f389a;
        return Collections.singletonList(new Vi(q8, new C0670w3(C0670w3.b(fromModel))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public E3(F3 f3) {
        this.f406a = f3;
    }

    public final D3 a(List<Vi> list) {
        throw new UnsupportedOperationException();
    }
}
