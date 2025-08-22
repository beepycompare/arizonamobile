package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes4.dex */
public final class Ca implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final De f379a;

    public Ca() {
        this(new Xl());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0714xm fromModel(G4 g4) {
        C0714xm c0714xm = new C0714xm();
        c0714xm.b = g4.b;
        c0714xm.f1145a = g4.f448a;
        c0714xm.c = g4.c;
        c0714xm.d = g4.d;
        c0714xm.e = g4.e;
        c0714xm.f = this.f379a.a(g4.f);
        return c0714xm;
    }

    public Ca(Xl xl) {
        this.f379a = xl;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final G4 toModel(C0714xm c0714xm) {
        E4 e4 = new E4();
        e4.d = c0714xm.d;
        e4.c = c0714xm.c;
        e4.b = c0714xm.b;
        e4.f407a = c0714xm.f1145a;
        e4.e = c0714xm.e;
        e4.f = this.f379a.a(c0714xm.f);
        return new G4(e4);
    }
}
