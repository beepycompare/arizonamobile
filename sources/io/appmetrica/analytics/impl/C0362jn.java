package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.jn  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0362jn implements ProtobufConverter {
    public final Xm a(C0336in c0336in) {
        Xm xm = new Xm();
        xm.f843a = c0336in.f1040a;
        return xm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        Xm xm = new Xm();
        xm.f843a = ((C0336in) obj).f1040a;
        return xm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new C0336in(((Xm) obj).f843a);
    }

    public final C0336in a(Xm xm) {
        return new C0336in(xm.f843a);
    }
}
