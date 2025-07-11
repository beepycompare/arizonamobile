package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public final class Zk implements InterfaceC0575s8 {

    /* renamed from: a  reason: collision with root package name */
    public final C0337ij f742a;
    public final Pf b;

    public Zk() {
        this(new C0337ij(), new Pf());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Ni> fromModel(Yk yk) {
        L8 l8 = new L8();
        l8.f516a = 2;
        l8.c = new I8();
        Ni fromModel = this.f742a.fromModel(yk.b);
        l8.c.b = (H8) fromModel.f557a;
        Ni fromModel2 = this.b.fromModel(yk.f727a);
        l8.c.f473a = (E8) fromModel2.f557a;
        return Collections.singletonList(new Ni(l8, new C0670w3(C0670w3.b(fromModel, fromModel2))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public Zk(C0337ij c0337ij, Pf pf) {
        this.f742a = c0337ij;
        this.b = pf;
    }

    public final Yk a(List<Ni> list) {
        throw new UnsupportedOperationException();
    }
}
