package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.ga  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0267ga implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final AbstractC0450ne f904a;

    public C0267ga() {
        this(new Tl());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0582sm fromModel(C0415m4 c0415m4) {
        C0582sm c0582sm = new C0582sm();
        c0582sm.b = c0415m4.b;
        c0582sm.f1124a = c0415m4.f1003a;
        c0582sm.c = c0415m4.c;
        c0582sm.d = c0415m4.d;
        c0582sm.e = c0415m4.e;
        c0582sm.f = this.f904a.a(c0415m4.f);
        return c0582sm;
    }

    public C0267ga(Tl tl) {
        this.f904a = tl;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0415m4 toModel(C0582sm c0582sm) {
        C0364k4 c0364k4 = new C0364k4();
        c0364k4.d = c0582sm.d;
        c0364k4.c = c0582sm.c;
        c0364k4.b = c0582sm.b;
        c0364k4.f968a = c0582sm.f1124a;
        c0364k4.e = c0582sm.e;
        c0364k4.f = this.f904a.a(c0582sm.f);
        return new C0415m4(c0364k4);
    }
}
