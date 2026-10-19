package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.v3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0646v3 implements ProtobufConverter {
    public final Qm a(C0594t3 c0594t3) {
        Qm qm = new Qm();
        qm.f742a = c0594t3.f1213a;
        return qm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        Qm qm = new Qm();
        qm.f742a = ((C0594t3) obj).f1213a;
        return qm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new C0594t3(((Qm) obj).f742a);
    }

    public final C0594t3 a(Qm qm) {
        return new C0594t3(qm.f742a);
    }
}
