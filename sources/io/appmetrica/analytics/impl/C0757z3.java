package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.z3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0757z3 implements InterfaceC0632u8 {

    /* renamed from: a  reason: collision with root package name */
    public final A3 f1305a;

    public C0757z3() {
        this(new A3());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Xi> fromModel(C0731y3 c0731y3) {
        N8 n8 = new N8();
        n8.e = new C0684w8();
        Xi fromModel = this.f1305a.fromModel(c0731y3.b);
        n8.e.f1260a = (C0710x8) fromModel.f838a;
        n8.f679a = c0731y3.f1285a;
        return Collections.singletonList(new Xi(n8, new C0524q3(C0524q3.b(fromModel))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public C0757z3(A3 a3) {
        this.f1305a = a3;
    }

    public final C0731y3 a(List<Xi> list) {
        throw new UnsupportedOperationException();
    }
}
