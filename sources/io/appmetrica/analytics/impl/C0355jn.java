package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.jn  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0355jn implements ProtobufConverter {
    public final Xm a(C0329in c0329in) {
        Xm xm = new Xm();
        xm.f848a = c0329in.f1045a;
        return xm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        Xm xm = new Xm();
        xm.f848a = ((C0329in) obj).f1045a;
        return xm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new C0329in(((Xm) obj).f848a);
    }

    public final C0329in a(Xm xm) {
        return new C0329in(xm.f848a);
    }
}
