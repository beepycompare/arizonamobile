package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes5.dex */
public final class Dm implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0634um fromModel(Cm cm) {
        C0634um c0634um = new C0634um();
        c0634um.f1261a = cm.f539a;
        return c0634um;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new Cm(((C0634um) obj).f1261a);
    }

    public final Cm a(C0634um c0634um) {
        return new Cm(c0634um.f1261a);
    }
}
