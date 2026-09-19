package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.fn  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0257fn implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Wm fromModel(C0231en c0231en) {
        Wm wm = new Wm();
        wm.f833a = c0231en.f971a;
        return wm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new C0231en(((Wm) obj).f833a);
    }

    public final C0231en a(Wm wm) {
        return new C0231en(wm.f833a);
    }
}
