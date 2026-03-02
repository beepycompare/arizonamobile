package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes5.dex */
public final class Hm implements ProtobufConverter {
    public final C0659vm a(Gm gm) {
        C0659vm c0659vm = new C0659vm();
        c0659vm.f1275a = gm.f602a;
        return c0659vm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        C0659vm c0659vm = new C0659vm();
        c0659vm.f1275a = ((Gm) obj).f602a;
        return c0659vm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new Gm(((C0659vm) obj).f1275a);
    }

    public final Gm a(C0659vm c0659vm) {
        return new Gm(c0659vm.f1275a);
    }
}
