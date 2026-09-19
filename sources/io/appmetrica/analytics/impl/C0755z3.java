package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.z3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0755z3 implements InterfaceC0630u8 {

    /* renamed from: a  reason: collision with root package name */
    public final A3 f1308a;

    public C0755z3() {
        this(new A3());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Xi> fromModel(C0729y3 c0729y3) {
        N8 n8 = new N8();
        n8.e = new C0682w8();
        Xi fromModel = this.f1308a.fromModel(c0729y3.b);
        n8.e.f1263a = (C0708x8) fromModel.f841a;
        n8.f682a = c0729y3.f1288a;
        return Collections.singletonList(new Xi(n8, new C0522q3(C0522q3.b(fromModel))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public C0755z3(A3 a3) {
        this.f1308a = a3;
    }

    public final C0729y3 a(List<Xi> list) {
        throw new UnsupportedOperationException();
    }
}
