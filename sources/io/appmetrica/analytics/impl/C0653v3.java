package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.v3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0653v3 implements ProtobufConverter {
    public final Qm a(C0601t3 c0601t3) {
        Qm qm = new Qm();
        qm.f736a = c0601t3.f1207a;
        return qm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        Qm qm = new Qm();
        qm.f736a = ((C0601t3) obj).f1207a;
        return qm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new C0601t3(((Qm) obj).f736a);
    }

    public final C0601t3 a(Qm qm) {
        return new C0601t3(qm.f736a);
    }
}
