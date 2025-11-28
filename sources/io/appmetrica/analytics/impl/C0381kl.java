package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.kl  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0381kl implements InterfaceC0291h8 {

    /* renamed from: a  reason: collision with root package name */
    public final C0199dj f977a;

    public C0381kl() {
        this(new C0199dj());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Ii> fromModel(C0355jl c0355jl) {
        A8 a8 = new A8();
        a8.f393a = 1;
        a8.b = new C0743z8();
        Ii fromModel = this.f977a.fromModel(c0355jl.f958a);
        a8.b.f1227a = (C0668w8) fromModel.f530a;
        C0312i3 c0312i3 = new C0312i3(C0312i3.b(fromModel));
        fromModel.b.getBytesTruncated();
        return Collections.singletonList(new Ii(a8, c0312i3));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public C0381kl(C0199dj c0199dj) {
        this.f977a = c0199dj;
    }

    public final C0355jl a(List<Ii> list) {
        throw new UnsupportedOperationException();
    }
}
