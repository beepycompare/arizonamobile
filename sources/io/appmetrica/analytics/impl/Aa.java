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
    public final C0592sm fromModel(G4 g4) {
        C0592sm c0592sm = new C0592sm();
        c0592sm.b = g4.b;
        c0592sm.f1056a = g4.f446a;
        c0592sm.c = g4.c;
        c0592sm.d = g4.d;
        c0592sm.e = g4.e;
        c0592sm.f = this.f336a.a(g4.f);
        return c0592sm;
    }

    public Aa(Sl sl) {
        this.f336a = sl;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final G4 toModel(C0592sm c0592sm) {
        E4 e4 = new E4();
        e4.d = c0592sm.d;
        e4.c = c0592sm.c;
        e4.b = c0592sm.b;
        e4.f410a = c0592sm.f1056a;
        e4.e = c0592sm.e;
        e4.f = this.f336a.a(c0592sm.f);
        return new G4(e4);
    }
}
