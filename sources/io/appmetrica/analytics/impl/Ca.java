package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes5.dex */
public final class Ca implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Ne f492a;

    public Ca() {
        this(new C0646um());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Tm fromModel(C4 c4) {
        Tm tm = new Tm();
        tm.b = c4.b;
        tm.f780a = c4.f486a;
        tm.c = c4.c;
        tm.d = c4.d;
        tm.e = c4.e;
        tm.f = this.f492a.a(c4.f);
        return tm;
    }

    public Ca(C0646um c0646um) {
        this.f492a = c0646um;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C4 toModel(Tm tm) {
        A4 a4 = new A4();
        a4.d = tm.d;
        a4.c = tm.c;
        a4.b = tm.b;
        a4.f449a = tm.f780a;
        a4.e = tm.e;
        a4.f = this.f492a.a(tm.f);
        return new C4(a4);
    }
}
