package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.fl  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0252fl implements InterfaceC0162c8 {

    /* renamed from: a  reason: collision with root package name */
    public final Hf f895a;
    public final C0299hg b;

    public C0252fl() {
        this(new Hf(), new C0299hg());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Ei> fromModel(C0226el c0226el) {
        Ei ei;
        C0643v8 c0643v8 = new C0643v8();
        c0643v8.f1165a = 3;
        c0643v8.d = new C0593t8();
        Ei fromModel = this.f895a.fromModel(c0226el.f874a);
        c0643v8.d.f1131a = (C0469o8) fromModel.f463a;
        C0726yg c0726yg = c0226el.b;
        if (c0726yg != null) {
            ei = this.b.fromModel(c0726yg);
            c0643v8.d.b = (C0519q8) ei.f463a;
        } else {
            ei = null;
        }
        return Collections.singletonList(new Ei(c0643v8, new C0131b3(C0131b3.b(fromModel, ei))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public C0252fl(Hf hf, C0299hg c0299hg) {
        this.f895a = hf;
        this.b = c0299hg;
    }

    public final C0226el a(List<Ei> list) {
        throw new UnsupportedOperationException();
    }
}
