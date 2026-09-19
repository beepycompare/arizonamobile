package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.v3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0651v3 implements ProtobufConverter {
    public final Qm a(C0599t3 c0599t3) {
        Qm qm = new Qm();
        qm.f739a = c0599t3.f1210a;
        return qm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        Qm qm = new Qm();
        qm.f739a = ((C0599t3) obj).f1210a;
        return qm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new C0599t3(((Qm) obj).f739a);
    }

    public final C0599t3 a(Qm qm) {
        return new C0599t3(qm.f739a);
    }
}
