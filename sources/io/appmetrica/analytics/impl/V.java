package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes4.dex */
public final class V implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Dn f706a;

    public V(Dn dn) {
        this.f706a = dn;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0529q6 fromModel(U u) {
        C0529q6 c0529q6 = new C0529q6();
        Cn cn = u.f691a;
        if (cn != null) {
            c0529q6.f1047a = this.f706a.fromModel(cn);
        }
        c0529q6.b = new C0753z6[u.b.size()];
        int i = 0;
        for (Cn cn2 : u.b) {
            c0529q6.b[i] = this.f706a.fromModel(cn2);
            i++;
        }
        String str = u.c;
        if (str != null) {
            c0529q6.c = str;
        }
        return c0529q6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0529q6 c0529q6 = (C0529q6) obj;
        throw new UnsupportedOperationException();
    }

    public final U a(C0529q6 c0529q6) {
        throw new UnsupportedOperationException();
    }
}
