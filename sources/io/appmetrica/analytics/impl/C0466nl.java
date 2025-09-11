package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.nl  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0466nl implements A8 {

    /* renamed from: a  reason: collision with root package name */
    public final C0125ag f1007a;
    public final Cg b;

    public C0466nl() {
        this(new C0125ag(), new Cg());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Zi> fromModel(C0440ml c0440ml) {
        Zi zi;
        T8 t8 = new T8();
        t8.f682a = 3;
        t8.d = new R8();
        Zi fromModel = this.f1007a.fromModel(c0440ml.f994a);
        t8.d.f652a = (M8) fromModel.f776a;
        Tg tg = c0440ml.b;
        if (tg != null) {
            zi = this.b.fromModel(tg);
            t8.d.b = (O8) zi.f776a;
        } else {
            zi = null;
        }
        return Collections.singletonList(new Zi(t8, new C0749z3(C0749z3.b(fromModel, zi))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public C0466nl(C0125ag c0125ag, Cg cg) {
        this.f1007a = c0125ag;
        this.b = cg;
    }

    public final C0440ml a(List<Zi> list) {
        throw new UnsupportedOperationException();
    }
}
