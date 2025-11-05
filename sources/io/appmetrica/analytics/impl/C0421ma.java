package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.ma  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0421ma implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final AbstractC0599te f1007a;

    public C0421ma() {
        this(new Wl());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0657vm fromModel(C0564s4 c0564s4) {
        C0657vm c0657vm = new C0657vm();
        c0657vm.b = c0564s4.b;
        c0657vm.f1175a = c0564s4.f1105a;
        c0657vm.c = c0564s4.c;
        c0657vm.d = c0564s4.d;
        c0657vm.e = c0564s4.e;
        c0657vm.f = this.f1007a.a(c0564s4.f);
        return c0657vm;
    }

    public C0421ma(Wl wl) {
        this.f1007a = wl;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0564s4 toModel(C0657vm c0657vm) {
        C0515q4 c0515q4 = new C0515q4();
        c0515q4.d = c0657vm.d;
        c0515q4.c = c0657vm.c;
        c0515q4.b = c0657vm.b;
        c0515q4.f1065a = c0657vm.f1175a;
        c0515q4.e = c0657vm.e;
        c0515q4.f = this.f1007a.a(c0657vm.f);
        return new C0564s4(c0515q4);
    }
}
