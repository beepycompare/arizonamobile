package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.dl  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0200dl implements InterfaceC0161c8 {

    /* renamed from: a  reason: collision with root package name */
    public final Zi f939a;
    public final Hf b;

    public C0200dl() {
        this(new Zi(), new Hf());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Ei> fromModel(C0174cl c0174cl) {
        C0642v8 c0642v8 = new C0642v8();
        c0642v8.f1248a = 2;
        c0642v8.c = new C0567s8();
        Ei fromModel = this.f939a.fromModel(c0174cl.b);
        c0642v8.c.b = (C0542r8) fromModel.f546a;
        Ei fromModel2 = this.b.fromModel(c0174cl.f920a);
        c0642v8.c.f1199a = (C0468o8) fromModel2.f546a;
        return Collections.singletonList(new Ei(c0642v8, new C0130b3(C0130b3.b(fromModel, fromModel2))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public C0200dl(Zi zi, Hf hf) {
        this.f939a = zi;
        this.b = hf;
    }

    public final C0174cl a(List<Ei> list) {
        throw new UnsupportedOperationException();
    }
}
