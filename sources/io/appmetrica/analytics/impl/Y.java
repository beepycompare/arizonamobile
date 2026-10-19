package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes5.dex */
public final class Y implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0124ao f851a;

    public Y(C0124ao c0124ao) {
        this.f851a = c0124ao;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0287h6 fromModel(X x) {
        C0287h6 c0287h6 = new C0287h6();
        Zn zn = x.f838a;
        if (zn != null) {
            c0287h6.f1013a = this.f851a.fromModel(zn);
        }
        c0287h6.b = new C0520q6[x.b.size()];
        int i = 0;
        for (Zn zn2 : x.b) {
            c0287h6.b[i] = this.f851a.fromModel(zn2);
            i++;
        }
        String str = x.c;
        if (str != null) {
            c0287h6.c = str;
        }
        return c0287h6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0287h6 c0287h6 = (C0287h6) obj;
        throw new UnsupportedOperationException();
    }

    public final X a(C0287h6 c0287h6) {
        throw new UnsupportedOperationException();
    }
}
