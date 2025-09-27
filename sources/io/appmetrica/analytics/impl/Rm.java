package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes4.dex */
public final class Rm implements ProtobufConverter {
    public final Fm a(Qm qm) {
        Fm fm = new Fm();
        fm.f451a = qm.f646a;
        return fm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        Fm fm = new Fm();
        fm.f451a = ((Qm) obj).f646a;
        return fm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new Qm(((Fm) obj).f451a);
    }

    public final Qm a(Fm fm) {
        return new Qm(fm.f451a);
    }
}
