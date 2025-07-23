package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes4.dex */
public final class Aa implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Be f336a;

    public Aa() {
        this(new Sl());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0591sm fromModel(G4 g4) {
        C0591sm c0591sm = new C0591sm();
        c0591sm.b = g4.b;
        c0591sm.f1056a = g4.f446a;
        c0591sm.c = g4.c;
        c0591sm.d = g4.d;
        c0591sm.e = g4.e;
        c0591sm.f = this.f336a.a(g4.f);
        return c0591sm;
    }

    public Aa(Sl sl) {
        this.f336a = sl;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final G4 toModel(C0591sm c0591sm) {
        E4 e4 = new E4();
        e4.d = c0591sm.d;
        e4.c = c0591sm.c;
        e4.b = c0591sm.b;
        e4.f410a = c0591sm.f1056a;
        e4.e = c0591sm.e;
        e4.f = this.f336a.a(c0591sm.f);
        return new G4(e4);
    }
}
