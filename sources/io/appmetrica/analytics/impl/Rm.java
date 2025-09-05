package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes4.dex */
public final class Rm implements ProtobufConverter {
    public final Fm a(Qm qm) {
        Fm fm = new Fm();
        fm.f446a = qm.f641a;
        return fm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        Fm fm = new Fm();
        fm.f446a = ((Qm) obj).f641a;
        return fm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new Qm(((Fm) obj).f446a);
    }

    public final Qm a(Fm fm) {
        return new Qm(fm.f446a);
    }
}
