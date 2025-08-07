package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes4.dex */
public final class V implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0643un f677a;

    public V(C0643un c0643un) {
        this.f677a = c0643un;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0452n6 fromModel(U u) {
        C0452n6 c0452n6 = new C0452n6();
        C0618tn c0618tn = u.f660a;
        if (c0618tn != null) {
            c0452n6.f965a = this.f677a.fromModel(c0618tn);
        }
        c0452n6.b = new C0676w6[u.b.size()];
        int i = 0;
        for (C0618tn c0618tn2 : u.b) {
            c0452n6.b[i] = this.f677a.fromModel(c0618tn2);
            i++;
        }
        String str = u.c;
        if (str != null) {
            c0452n6.c = str;
        }
        return c0452n6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0452n6 c0452n6 = (C0452n6) obj;
        throw new UnsupportedOperationException();
    }

    public final U a(C0452n6 c0452n6) {
        throw new UnsupportedOperationException();
    }
}
