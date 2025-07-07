package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public final class E3 implements InterfaceC0583s8 {

    /* renamed from: a  reason: collision with root package name */
    public final F3 f399a;

    public E3() {
        this(new F3());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Ni> fromModel(D3 d3) {
        L8 l8 = new L8();
        l8.e = new C0633u8();
        Ni fromModel = this.f399a.fromModel(d3.b);
        l8.e.f1070a = (C0658v8) fromModel.f556a;
        l8.f515a = d3.f382a;
        return Collections.singletonList(new Ni(l8, new C0678w3(C0678w3.b(fromModel))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public E3(F3 f3) {
        this.f399a = f3;
    }

    public final D3 a(List<Ni> list) {
        throw new UnsupportedOperationException();
    }
}
