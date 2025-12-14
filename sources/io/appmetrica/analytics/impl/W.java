package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes5.dex */
public final class W implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0732yn f826a;

    public W(C0732yn c0732yn) {
        this.f826a = c0732yn;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final S5 fromModel(V v) {
        S5 s5 = new S5();
        C0707xn c0707xn = v.f813a;
        if (c0707xn != null) {
            s5.f770a = this.f826a.fromModel(c0707xn);
        }
        s5.b = new C0133b6[v.b.size()];
        int i = 0;
        for (C0707xn c0707xn2 : v.b) {
            s5.b[i] = this.f826a.fromModel(c0707xn2);
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
