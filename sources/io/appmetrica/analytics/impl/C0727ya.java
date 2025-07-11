package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.ya  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0727ya implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final AbstractC0756ze f1144a;

    public C0727ya() {
        this(new Pl());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0515pm fromModel(G4 g4) {
        C0515pm c0515pm = new C0515pm();
        c0515pm.b = g4.b;
        c0515pm.f995a = g4.f438a;
        c0515pm.c = g4.c;
        c0515pm.d = g4.d;
        c0515pm.e = g4.e;
        c0515pm.f = this.f1144a.a(g4.f);
        return c0515pm;
    }

    public C0727ya(Pl pl) {
        this.f1144a = pl;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final G4 toModel(C0515pm c0515pm) {
        E4 e4 = new E4();
        e4.d = c0515pm.d;
        e4.c = c0515pm.c;
        e4.b = c0515pm.b;
        e4.f401a = c0515pm.f995a;
        e4.e = c0515pm.e;
        e4.f = this.f1144a.a(c0515pm.f);
        return new G4(e4);
    }
}
