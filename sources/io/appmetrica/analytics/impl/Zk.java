package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public final class Zk implements InterfaceC0583s8 {

    /* renamed from: a  reason: collision with root package name */
    public final C0345ij f741a;
    public final Pf b;

    public Zk() {
        this(new C0345ij(), new Pf());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Ni> fromModel(Yk yk) {
        L8 l8 = new L8();
        l8.f515a = 2;
        l8.c = new I8();
        Ni fromModel = this.f741a.fromModel(yk.b);
        l8.c.b = (H8) fromModel.f556a;
        Ni fromModel2 = this.b.fromModel(yk.f726a);
        l8.c.f472a = (E8) fromModel2.f556a;
        return Collections.singletonList(new Ni(l8, new C0678w3(C0678w3.b(fromModel, fromModel2))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public Zk(C0345ij c0345ij, Pf pf) {
        this.f741a = c0345ij;
        this.b = pf;
    }

    public final Yk a(List<Ni> list) {
        throw new UnsupportedOperationException();
    }
}
