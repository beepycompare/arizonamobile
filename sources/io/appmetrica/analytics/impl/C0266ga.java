package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.ga  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0266ga implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final AbstractC0449ne f1001a;

    public C0266ga() {
        this(new Tl());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0581sm fromModel(C0414m4 c0414m4) {
        C0581sm c0581sm = new C0581sm();
        c0581sm.b = c0414m4.b;
        c0581sm.f1221a = c0414m4.f1100a;
        c0581sm.c = c0414m4.c;
        c0581sm.d = c0414m4.d;
        c0581sm.e = c0414m4.e;
        c0581sm.f = this.f1001a.a(c0414m4.f);
        return c0581sm;
    }

    public C0266ga(Tl tl) {
        this.f1001a = tl;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0414m4 toModel(C0581sm c0581sm) {
        C0363k4 c0363k4 = new C0363k4();
        c0363k4.d = c0581sm.d;
        c0363k4.c = c0581sm.c;
        c0363k4.b = c0581sm.b;
        c0363k4.f1065a = c0581sm.f1221a;
        c0363k4.e = c0581sm.e;
        c0363k4.f = this.f1001a.a(c0581sm.f);
        return new C0414m4(c0363k4);
    }
}
