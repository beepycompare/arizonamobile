package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.fn  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0258fn implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Wm fromModel(C0232en c0232en) {
        Wm wm = new Wm();
        wm.f833a = c0232en.f971a;
        return wm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new C0232en(((Wm) obj).f833a);
    }

    public final C0232en a(Wm wm) {
        return new C0232en(wm.f833a);
    }
}
