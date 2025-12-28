package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes5.dex */
public final class Em implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0656vm fromModel(Dm dm) {
        C0656vm c0656vm = new C0656vm();
        c0656vm.f1272a = dm.f548a;
        return c0656vm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new Dm(((C0656vm) obj).f1272a);
    }

    public final Dm a(C0656vm c0656vm) {
        return new Dm(c0656vm.f1272a);
    }
}
