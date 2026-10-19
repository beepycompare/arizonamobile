package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes5.dex */
public final class Ca implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Ne f498a;

    public Ca() {
        this(new C0639um());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Tm fromModel(C4 c4) {
        Tm tm = new Tm();
        tm.b = c4.b;
        tm.f786a = c4.f492a;
        tm.c = c4.c;
        tm.d = c4.d;
        tm.e = c4.e;
        tm.f = this.f498a.a(c4.f);
        return tm;
    }

    public Ca(C0639um c0639um) {
        this.f498a = c0639um;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C4 toModel(Tm tm) {
        A4 a4 = new A4();
        a4.d = tm.d;
        a4.c = tm.c;
        a4.b = tm.b;
        a4.f455a = tm.f786a;
        a4.e = tm.e;
        a4.f = this.f498a.a(tm.f);
        return new C4(a4);
    }
}
