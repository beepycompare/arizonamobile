package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.j3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0337j3 implements InterfaceC0162c8 {

    /* renamed from: a  reason: collision with root package name */
    public final C0363k3 f949a;

    public C0337j3() {
        this(new C0363k3());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Ei> fromModel(C0312i3 c0312i3) {
        C0643v8 c0643v8 = new C0643v8();
        c0643v8.e = new C0213e8();
        Ei fromModel = this.f949a.fromModel(c0312i3.b);
        c0643v8.e.f867a = (C0239f8) fromModel.f463a;
        c0643v8.f1165a = c0312i3.f933a;
        return Collections.singletonList(new Ei(c0643v8, new C0131b3(C0131b3.b(fromModel))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public C0337j3(C0363k3 c0363k3) {
        this.f949a = c0363k3;
    }

    public final C0312i3 a(List<Ei> list) {
        throw new UnsupportedOperationException();
    }
}
