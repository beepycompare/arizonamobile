package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.el  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0240el implements InterfaceC0652v8 {

    /* renamed from: a  reason: collision with root package name */
    public final Rf f833a;
    public final C0610tg b;

    public C0240el() {
        this(new Rf(), new C0610tg());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Qi> fromModel(C0215dl c0215dl) {
        Qi qi;
        O8 o8 = new O8();
        o8.f575a = 3;
        o8.d = new M8();
        Qi fromModel = this.f833a.fromModel(c0215dl.f818a);
        o8.d.f546a = (H8) fromModel.f612a;
        Kg kg = c0215dl.b;
        if (kg != null) {
            qi = this.b.fromModel(kg);
            o8.d.b = (J8) qi.f612a;
        } else {
            qi = null;
        }
        return Collections.singletonList(new Qi(o8, new C0672w3(C0672w3.b(fromModel, qi))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public C0240el(Rf rf, C0610tg c0610tg) {
        this.f833a = rf;
        this.b = c0610tg;
    }

    public final C0215dl a(List<Qi> list) {
        throw new UnsupportedOperationException();
    }
}
