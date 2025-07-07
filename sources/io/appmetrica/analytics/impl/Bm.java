package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes4.dex */
public final class Bm implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0597sm fromModel(Am am) {
        C0597sm c0597sm = new C0597sm();
        c0597sm.f1048a = am.f341a;
        return c0597sm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new Am(((C0597sm) obj).f1048a);
    }

    public final Am a(C0597sm c0597sm) {
        return new Am(c0597sm.f1048a);
    }
}
