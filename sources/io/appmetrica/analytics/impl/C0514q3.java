package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.q3  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0514q3 implements InterfaceC0291h8 {

    /* renamed from: a  reason: collision with root package name */
    public final C0538r3 f1064a;

    public C0514q3() {
        this(new C0538r3());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Ii> fromModel(C0489p3 c0489p3) {
        A8 a8 = new A8();
        a8.e = new C0342j8();
        Ii fromModel = this.f1064a.fromModel(c0489p3.b);
        a8.e.f948a = (C0368k8) fromModel.f530a;
        a8.f393a = c0489p3.f1050a;
        return Collections.singletonList(new Ii(a8, new C0312i3(C0312i3.b(fromModel))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public C0514q3(C0538r3 c0538r3) {
        this.f1064a = c0538r3;
    }

    public final C0489p3 a(List<Ii> list) {
        throw new UnsupportedOperationException();
    }
}
