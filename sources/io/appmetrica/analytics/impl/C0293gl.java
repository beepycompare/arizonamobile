package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.gl  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0293gl implements InterfaceC0653v8 {

    /* renamed from: a  reason: collision with root package name */
    public final C0415lj f870a;

    public C0293gl() {
        this(new C0415lj());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Qi> fromModel(C0267fl c0267fl) {
        O8 o8 = new O8();
        o8.f575a = 1;
        o8.b = new N8();
        Qi fromModel = this.f870a.fromModel(c0267fl.f850a);
        o8.b.f561a = (K8) fromModel.f612a;
        C0673w3 c0673w3 = new C0673w3(C0673w3.b(fromModel));
        fromModel.b.getBytesTruncated();
        return Collections.singletonList(new Qi(o8, c0673w3));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public C0293gl(C0415lj c0415lj) {
        this.f870a = c0415lj;
    }

    public final C0267fl a(List<Qi> list) {
        throw new UnsupportedOperationException();
    }
}
