package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.gl  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0292gl implements InterfaceC0652v8 {

    /* renamed from: a  reason: collision with root package name */
    public final C0414lj f871a;

    public C0292gl() {
        this(new C0414lj());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Qi> fromModel(C0266fl c0266fl) {
        O8 o8 = new O8();
        o8.f576a = 1;
        o8.b = new N8();
        Qi fromModel = this.f871a.fromModel(c0266fl.f851a);
        o8.b.f562a = (K8) fromModel.f613a;
        C0672w3 c0672w3 = new C0672w3(C0672w3.b(fromModel));
        fromModel.b.getBytesTruncated();
        return Collections.singletonList(new Qi(o8, c0672w3));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public C0292gl(C0414lj c0414lj) {
        this.f871a = c0414lj;
    }

    public final C0266fl a(List<Qi> list) {
        throw new UnsupportedOperationException();
    }
}
