package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes5.dex */
public final class Ze implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Vm fromModel(Ye ye) {
        Vm vm = new Vm();
        vm.f813a = ye.f856a;
        vm.b = ye.b;
        return vm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Vm vm = (Vm) obj;
        return new Ye(vm.f813a, vm.b);
    }

    public final Ye a(Vm vm) {
        return new Ye(vm.f813a, vm.b);
    }
}
