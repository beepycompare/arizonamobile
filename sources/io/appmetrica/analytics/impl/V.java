package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes4.dex */
public final class V implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Dn f705a;

    public V(Dn dn) {
        this.f705a = dn;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0528q6 fromModel(U u) {
        C0528q6 c0528q6 = new C0528q6();
        Cn cn = u.f690a;
        if (cn != null) {
            c0528q6.f1046a = this.f705a.fromModel(cn);
        }
        c0528q6.b = new C0752z6[u.b.size()];
        int i = 0;
        for (Cn cn2 : u.b) {
            c0528q6.b[i] = this.f705a.fromModel(cn2);
            i++;
        }
        String str = u.c;
        if (str != null) {
            c0528q6.c = str;
        }
        return c0528q6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0528q6 c0528q6 = (C0528q6) obj;
        throw new UnsupportedOperationException();
    }

    public final U a(C0528q6 c0528q6) {
        throw new UnsupportedOperationException();
    }
}
