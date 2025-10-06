package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.pl  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0519pl implements A8 {

    /* renamed from: a  reason: collision with root package name */
    public final C0641uj f1039a;

    public C0519pl() {
        this(new C0641uj());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Zi> fromModel(C0493ol c0493ol) {
        T8 t8 = new T8();
        t8.f683a = 1;
        t8.b = new S8();
        Zi fromModel = this.f1039a.fromModel(c0493ol.f1024a);
        t8.b.f669a = (P8) fromModel.f777a;
        C0750z3 c0750z3 = new C0750z3(C0750z3.b(fromModel));
        fromModel.b.getBytesTruncated();
        return Collections.singletonList(new Zi(t8, c0750z3));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public C0519pl(C0641uj c0641uj) {
        this.f1039a = c0641uj;
    }

    public final C0493ol a(List<Zi> list) {
        throw new UnsupportedOperationException();
    }
}
