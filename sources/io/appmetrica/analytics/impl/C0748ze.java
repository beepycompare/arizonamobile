package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.ze  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0748ze implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0631um fromModel(C0723ye c0723ye) {
        C0631um c0631um = new C0631um();
        c0631um.f1237a = c0723ye.f1301a;
        c0631um.b = c0723ye.b;
        return c0631um;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0631um c0631um = (C0631um) obj;
        return new C0723ye(c0631um.f1237a, c0631um.b);
    }

    public final C0723ye a(C0631um c0631um) {
        return new C0723ye(c0631um.f1237a, c0631um.b);
    }
}
