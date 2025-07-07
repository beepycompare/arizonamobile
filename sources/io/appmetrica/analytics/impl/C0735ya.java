package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.ya  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0735ya implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final AbstractC0764ze f1143a;

    public C0735ya() {
        this(new Pl());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0523pm fromModel(G4 g4) {
        C0523pm c0523pm = new C0523pm();
        c0523pm.b = g4.b;
        c0523pm.f994a = g4.f437a;
        c0523pm.c = g4.c;
        c0523pm.d = g4.d;
        c0523pm.e = g4.e;
        c0523pm.f = this.f1143a.a(g4.f);
        return c0523pm;
    }

    public C0735ya(Pl pl) {
        this.f1143a = pl;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final G4 toModel(C0523pm c0523pm) {
        E4 e4 = new E4();
        e4.d = c0523pm.d;
        e4.c = c0523pm.c;
        e4.b = c0523pm.b;
        e4.f400a = c0523pm.f994a;
        e4.e = c0523pm.e;
        e4.f = this.f1143a.a(c0523pm.f);
        return new G4(e4);
    }
}
