package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes5.dex */
public final class Y implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0129ao f848a;

    public Y(C0129ao c0129ao) {
        this.f848a = c0129ao;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0292h6 fromModel(X x) {
        C0292h6 c0292h6 = new C0292h6();
        Zn zn = x.f835a;
        if (zn != null) {
            c0292h6.f1010a = this.f848a.fromModel(zn);
        }
        c0292h6.b = new C0525q6[x.b.size()];
        int i = 0;
        for (Zn zn2 : x.b) {
            c0292h6.b[i] = this.f848a.fromModel(zn2);
            i++;
        }
        String str = x.c;
        if (str != null) {
            c0292h6.c = str;
        }
        return c0292h6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0292h6 c0292h6 = (C0292h6) obj;
        throw new UnsupportedOperationException();
    }

    public final X a(C0292h6 c0292h6) {
        throw new UnsupportedOperationException();
    }
}
