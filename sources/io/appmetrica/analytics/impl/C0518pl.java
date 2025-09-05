package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.pl  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0518pl implements A8 {

    /* renamed from: a  reason: collision with root package name */
    public final C0640uj f1034a;

    public C0518pl() {
        this(new C0640uj());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Zi> fromModel(C0492ol c0492ol) {
        T8 t8 = new T8();
        t8.f678a = 1;
        t8.b = new S8();
        Zi fromModel = this.f1034a.fromModel(c0492ol.f1019a);
        t8.b.f664a = (P8) fromModel.f772a;
        C0749z3 c0749z3 = new C0749z3(C0749z3.b(fromModel));
        fromModel.b.getBytesTruncated();
        return Collections.singletonList(new Zi(t8, c0749z3));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public C0518pl(C0640uj c0640uj) {
        this.f1034a = c0640uj;
    }

    public final C0492ol a(List<Zi> list) {
        throw new UnsupportedOperationException();
    }
}
