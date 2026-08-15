package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.z3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0756z3 implements InterfaceC0631u8 {

    /* renamed from: a  reason: collision with root package name */
    public final A3 f1308a;

    public C0756z3() {
        this(new A3());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Xi> fromModel(C0730y3 c0730y3) {
        N8 n8 = new N8();
        n8.e = new C0683w8();
        Xi fromModel = this.f1308a.fromModel(c0730y3.b);
        n8.e.f1263a = (C0709x8) fromModel.f841a;
        n8.f682a = c0730y3.f1288a;
        return Collections.singletonList(new Xi(n8, new C0523q3(C0523q3.b(fromModel))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public C0756z3(A3 a3) {
        this.f1308a = a3;
    }

    public final C0730y3 a(List<Xi> list) {
        throw new UnsupportedOperationException();
    }
}
