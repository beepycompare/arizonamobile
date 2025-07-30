package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes4.dex */
public final class Em implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0666vm fromModel(Dm dm) {
        C0666vm c0666vm = new C0666vm();
        c0666vm.f1106a = dm.f403a;
        return c0666vm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new Dm(((C0666vm) obj).f1106a);
    }

    public final Dm a(C0666vm c0666vm) {
        return new Dm(c0666vm.f1106a);
    }
}
