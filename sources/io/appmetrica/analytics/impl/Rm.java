package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes4.dex */
public final class Rm implements ProtobufConverter {
    public final Fm a(Qm qm) {
        Fm fm = new Fm();
        fm.f450a = qm.f645a;
        return fm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        Fm fm = new Fm();
        fm.f450a = ((Qm) obj).f645a;
        return fm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new Qm(((Fm) obj).f450a);
    }

    public final Qm a(Fm fm) {
        return new Qm(fm.f450a);
    }
}
