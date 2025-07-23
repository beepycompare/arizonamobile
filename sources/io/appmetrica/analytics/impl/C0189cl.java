package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.cl  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0189cl implements InterfaceC0652v8 {

    /* renamed from: a  reason: collision with root package name */
    public final C0414lj f802a;
    public final Rf b;

    public C0189cl() {
        this(new C0414lj(), new Rf());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Qi> fromModel(C0163bl c0163bl) {
        O8 o8 = new O8();
        o8.f575a = 2;
        o8.c = new L8();
        Qi fromModel = this.f802a.fromModel(c0163bl.b);
        o8.c.b = (K8) fromModel.f612a;
        Qi fromModel2 = this.b.fromModel(c0163bl.f788a);
        o8.c.f530a = (H8) fromModel2.f612a;
        return Collections.singletonList(new Qi(o8, new C0672w3(C0672w3.b(fromModel, fromModel2))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public C0189cl(C0414lj c0414lj, Rf rf) {
        this.f802a = c0414lj;
        this.b = rf;
    }

    public final C0163bl a(List<Qi> list) {
        throw new UnsupportedOperationException();
    }
}
