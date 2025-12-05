package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.j3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0336j3 implements InterfaceC0161c8 {

    /* renamed from: a  reason: collision with root package name */
    public final C0362k3 f1032a;

    public C0336j3() {
        this(new C0362k3());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Ei> fromModel(C0311i3 c0311i3) {
        C0642v8 c0642v8 = new C0642v8();
        c0642v8.e = new C0212e8();
        Ei fromModel = this.f1032a.fromModel(c0311i3.b);
        c0642v8.e.f950a = (C0238f8) fromModel.f546a;
        c0642v8.f1248a = c0311i3.f1016a;
        return Collections.singletonList(new Ei(c0642v8, new C0130b3(C0130b3.b(fromModel))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public C0336j3(C0362k3 c0362k3) {
        this.f1032a = c0362k3;
    }

    public final C0311i3 a(List<Ei> list) {
        throw new UnsupportedOperationException();
    }
}
