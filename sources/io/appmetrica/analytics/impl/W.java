package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes5.dex */
public final class W implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0733yn f729a;

    public W(C0733yn c0733yn) {
        this.f729a = c0733yn;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final S5 fromModel(V v) {
        S5 s5 = new S5();
        C0708xn c0708xn = v.f716a;
        if (c0708xn != null) {
            s5.f673a = this.f729a.fromModel(c0708xn);
        }
        s5.b = new C0134b6[v.b.size()];
        int i = 0;
        for (C0708xn c0708xn2 : v.b) {
            s5.b[i] = this.f729a.fromModel(c0708xn2);
            i++;
        }
        String str = v.c;
        if (str != null) {
            s5.c = str;
        }
        return s5;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        S5 s5 = (S5) obj;
        throw new UnsupportedOperationException();
    }

    public final V a(S5 s5) {
        throw new UnsupportedOperationException();
    }
}
