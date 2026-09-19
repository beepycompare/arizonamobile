package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.jn  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0360jn implements ProtobufConverter {
    public final Xm a(C0334in c0334in) {
        Xm xm = new Xm();
        xm.f845a = c0334in.f1042a;
        return xm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        Xm xm = new Xm();
        xm.f845a = ((C0334in) obj).f1042a;
        return xm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new C0334in(((Xm) obj).f845a);
    }

    public final C0334in a(Xm xm) {
        return new C0334in(xm.f845a);
    }
}
