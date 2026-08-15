package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.jn  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0361jn implements ProtobufConverter {
    public final Xm a(C0335in c0335in) {
        Xm xm = new Xm();
        xm.f845a = c0335in.f1042a;
        return xm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        Xm xm = new Xm();
        xm.f845a = ((C0335in) obj).f1042a;
        return xm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new C0335in(((Xm) obj).f845a);
    }

    public final C0335in a(Xm xm) {
        return new C0335in(xm.f845a);
    }
}
