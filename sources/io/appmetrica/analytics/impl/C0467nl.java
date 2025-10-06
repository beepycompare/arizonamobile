package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.nl  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0467nl implements A8 {

    /* renamed from: a  reason: collision with root package name */
    public final C0126ag f1008a;
    public final Cg b;

    public C0467nl() {
        this(new C0126ag(), new Cg());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Zi> fromModel(C0441ml c0441ml) {
        Zi zi;
        T8 t8 = new T8();
        t8.f683a = 3;
        t8.d = new R8();
        Zi fromModel = this.f1008a.fromModel(c0441ml.f995a);
        t8.d.f653a = (M8) fromModel.f777a;
        Tg tg = c0441ml.b;
        if (tg != null) {
            zi = this.b.fromModel(tg);
            t8.d.b = (O8) zi.f777a;
        } else {
            zi = null;
        }
        return Collections.singletonList(new Zi(t8, new C0750z3(C0750z3.b(fromModel, zi))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public C0467nl(C0126ag c0126ag, Cg cg) {
        this.f1008a = c0126ag;
        this.b = cg;
    }

    public final C0441ml a(List<Zi> list) {
        throw new UnsupportedOperationException();
    }
}
