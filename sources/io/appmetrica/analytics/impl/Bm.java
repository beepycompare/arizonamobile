package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes4.dex */
public final class Bm implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0589sm fromModel(Am am) {
        C0589sm c0589sm = new C0589sm();
        c0589sm.f1049a = am.f342a;
        return c0589sm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new Am(((C0589sm) obj).f1049a);
    }

    public final Am a(C0589sm c0589sm) {
        return new Am(c0589sm.f1049a);
    }
}
