package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.ze  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0749ze implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0632um fromModel(C0724ye c0724ye) {
        C0632um c0632um = new C0632um();
        c0632um.f1154a = c0724ye.f1218a;
        c0632um.b = c0724ye.b;
        return c0632um;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0632um c0632um = (C0632um) obj;
        return new C0724ye(c0632um.f1154a, c0632um.b);
    }

    public final C0724ye a(C0632um c0632um) {
        return new C0724ye(c0632um.f1154a, c0632um.b);
    }
}
