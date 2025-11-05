package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.gl  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0278gl implements InterfaceC0291h8 {

    /* renamed from: a  reason: collision with root package name */
    public final C0199dj f900a;
    public final Lf b;

    public C0278gl() {
        this(new C0199dj(), new Lf());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Ii> fromModel(C0252fl c0252fl) {
        A8 a8 = new A8();
        a8.f393a = 2;
        a8.c = new C0693x8();
        Ii fromModel = this.f900a.fromModel(c0252fl.b);
        a8.c.b = (C0668w8) fromModel.f530a;
        Ii fromModel2 = this.b.fromModel(c0252fl.f881a);
        a8.c.f1200a = (C0593t8) fromModel2.f530a;
        return Collections.singletonList(new Ii(a8, new C0312i3(C0312i3.b(fromModel, fromModel2))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public C0278gl(C0199dj c0199dj, Lf lf) {
        this.f900a = c0199dj;
        this.b = lf;
    }

    public final C0252fl a(List<Ii> list) {
        throw new UnsupportedOperationException();
    }
}
