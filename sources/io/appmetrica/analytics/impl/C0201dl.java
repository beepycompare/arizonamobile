package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.dl  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0201dl implements InterfaceC0162c8 {

    /* renamed from: a  reason: collision with root package name */
    public final Zi f856a;
    public final Hf b;

    public C0201dl() {
        this(new Zi(), new Hf());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Ei> fromModel(C0175cl c0175cl) {
        C0643v8 c0643v8 = new C0643v8();
        c0643v8.f1165a = 2;
        c0643v8.c = new C0568s8();
        Ei fromModel = this.f856a.fromModel(c0175cl.b);
        c0643v8.c.b = (C0543r8) fromModel.f463a;
        Ei fromModel2 = this.b.fromModel(c0175cl.f837a);
        c0643v8.c.f1116a = (C0469o8) fromModel2.f463a;
        return Collections.singletonList(new Ei(c0643v8, new C0131b3(C0131b3.b(fromModel, fromModel2))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public C0201dl(Zi zi, Hf hf) {
        this.f856a = zi;
        this.b = hf;
    }

    public final C0175cl a(List<Ei> list) {
        throw new UnsupportedOperationException();
    }
}
