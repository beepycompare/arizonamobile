package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes5.dex */
public final class Hm implements ProtobufConverter {
    public final C0660vm a(Gm gm) {
        C0660vm c0660vm = new C0660vm();
        c0660vm.f1275a = gm.f602a;
        return c0660vm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        C0660vm c0660vm = new C0660vm();
        c0660vm.f1275a = ((Gm) obj).f602a;
        return c0660vm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new Gm(((C0660vm) obj).f1275a);
    }

    public final Gm a(C0660vm c0660vm) {
        return new Gm(c0660vm.f1275a);
    }
}
