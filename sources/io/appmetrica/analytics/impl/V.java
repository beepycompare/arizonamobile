package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes4.dex */
public final class V implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0565rn f665a;

    public V(C0565rn c0565rn) {
        this.f665a = c0565rn;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0374k6 fromModel(U u) {
        C0374k6 c0374k6 = new C0374k6();
        C0541qn c0541qn = u.f649a;
        if (c0541qn != null) {
            c0374k6.f902a = this.f665a.fromModel(c0541qn);
        }
        c0374k6.b = new C0598t6[u.b.size()];
        int i = 0;
        for (C0541qn c0541qn2 : u.b) {
            c0374k6.b[i] = this.f665a.fromModel(c0541qn2);
            i++;
        }
        String str = u.c;
        if (str != null) {
            c0374k6.c = str;
        }
        return c0374k6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0374k6 c0374k6 = (C0374k6) obj;
        throw new UnsupportedOperationException();
    }

    public final U a(C0374k6 c0374k6) {
        throw new UnsupportedOperationException();
    }
}
