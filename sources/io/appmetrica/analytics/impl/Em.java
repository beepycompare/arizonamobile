package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes5.dex */
public final class Em implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0657vm fromModel(Dm dm) {
        C0657vm c0657vm = new C0657vm();
        c0657vm.f1174a = dm.f450a;
        return c0657vm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new Dm(((C0657vm) obj).f1174a);
    }

    public final Dm a(C0657vm c0657vm) {
        return new Dm(c0657vm.f1174a);
    }
}
