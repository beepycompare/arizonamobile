package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes4.dex */
public final class V implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0642un f677a;

    public V(C0642un c0642un) {
        this.f677a = c0642un;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0451n6 fromModel(U u) {
        C0451n6 c0451n6 = new C0451n6();
        C0617tn c0617tn = u.f660a;
        if (c0617tn != null) {
            c0451n6.f965a = this.f677a.fromModel(c0617tn);
        }
        c0451n6.b = new C0675w6[u.b.size()];
        int i = 0;
        for (C0617tn c0617tn2 : u.b) {
            c0451n6.b[i] = this.f677a.fromModel(c0617tn2);
            i++;
        }
        String str = u.c;
        if (str != null) {
            c0451n6.c = str;
        }
        return c0451n6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0451n6 c0451n6 = (C0451n6) obj;
        throw new UnsupportedOperationException();
    }

    public final U a(C0451n6 c0451n6) {
        throw new UnsupportedOperationException();
    }
}
