package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.z3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0750z3 implements InterfaceC0625u8 {

    /* renamed from: a  reason: collision with root package name */
    public final A3 f1311a;

    public C0750z3() {
        this(new A3());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Xi> fromModel(C0724y3 c0724y3) {
        N8 n8 = new N8();
        n8.e = new C0677w8();
        Xi fromModel = this.f1311a.fromModel(c0724y3.b);
        n8.e.f1266a = (C0703x8) fromModel.f844a;
        n8.f685a = c0724y3.f1291a;
        return Collections.singletonList(new Xi(n8, new C0517q3(C0517q3.b(fromModel))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public C0750z3(A3 a3) {
        this.f1311a = a3;
    }

    public final C0724y3 a(List<Xi> list) {
        throw new UnsupportedOperationException();
    }
}
