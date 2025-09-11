package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public final class H3 implements A8 {

    /* renamed from: a  reason: collision with root package name */
    public final I3 f470a;

    public H3() {
        this(new I3());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Zi> fromModel(G3 g3) {
        T8 t8 = new T8();
        t8.e = new C8();
        Zi fromModel = this.f470a.fromModel(g3.b);
        t8.e.f385a = (D8) fromModel.f776a;
        t8.f682a = g3.f454a;
        return Collections.singletonList(new Zi(t8, new C0749z3(C0749z3.b(fromModel))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public H3(I3 i3) {
        this.f470a = i3;
    }

    public final G3 a(List<Zi> list) {
        throw new UnsupportedOperationException();
    }
}
