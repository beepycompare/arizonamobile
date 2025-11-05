package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.il  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0329il implements InterfaceC0291h8 {

    /* renamed from: a  reason: collision with root package name */
    public final Lf f938a;
    public final C0402lg b;

    public C0329il() {
        this(new Lf(), new C0402lg());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Ii> fromModel(C0304hl c0304hl) {
        Ii ii;
        A8 a8 = new A8();
        a8.f393a = 3;
        a8.d = new C0718y8();
        Ii fromModel = this.f938a.fromModel(c0304hl.f916a);
        a8.d.f1212a = (C0593t8) fromModel.f530a;
        Cg cg = c0304hl.b;
        if (cg != null) {
            ii = this.b.fromModel(cg);
            a8.d.b = (C0643v8) ii.f530a;
        } else {
            ii = null;
        }
        return Collections.singletonList(new Ii(a8, new C0312i3(C0312i3.b(fromModel, ii))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public C0329il(Lf lf, C0402lg c0402lg) {
        this.f938a = lf;
        this.b = c0402lg;
    }

    public final C0304hl a(List<Ii> list) {
        throw new UnsupportedOperationException();
    }
}
