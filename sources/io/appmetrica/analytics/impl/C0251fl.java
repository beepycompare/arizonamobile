package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.fl  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0251fl implements InterfaceC0161c8 {

    /* renamed from: a  reason: collision with root package name */
    public final Hf f993a;
    public final C0298hg b;

    public C0251fl() {
        this(new Hf(), new C0298hg());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Ei> fromModel(C0225el c0225el) {
        Ei ei;
        C0642v8 c0642v8 = new C0642v8();
        c0642v8.f1263a = 3;
        c0642v8.d = new C0592t8();
        Ei fromModel = this.f993a.fromModel(c0225el.f972a);
        c0642v8.d.f1229a = (C0468o8) fromModel.f561a;
        C0725yg c0725yg = c0225el.b;
        if (c0725yg != null) {
            ei = this.b.fromModel(c0725yg);
            c0642v8.d.b = (C0518q8) ei.f561a;
        } else {
            ei = null;
        }
        return Collections.singletonList(new Ei(c0642v8, new C0130b3(C0130b3.b(fromModel, ei))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public C0251fl(Hf hf, C0298hg c0298hg) {
        this.f993a = hf;
        this.b = c0298hg;
    }

    public final C0225el a(List<Ei> list) {
        throw new UnsupportedOperationException();
    }
}
