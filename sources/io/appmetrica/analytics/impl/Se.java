package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes4.dex */
public final class Se implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Dm fromModel(Re re) {
        Dm dm = new Dm();
        dm.f415a = re.f655a;
        dm.b = re.b;
        return dm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Dm dm = (Dm) obj;
        return new Re(dm.f415a, dm.b);
    }

    public final Re a(Dm dm) {
        return new Re(dm.f415a, dm.b);
    }
}
