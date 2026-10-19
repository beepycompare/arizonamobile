package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.fn  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0252fn implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Wm fromModel(C0226en c0226en) {
        Wm wm = new Wm();
        wm.f836a = c0226en.f974a;
        return wm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new C0226en(((Wm) obj).f836a);
    }

    public final C0226en a(Wm wm) {
        return new C0226en(wm.f836a);
    }
}
