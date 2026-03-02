package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes5.dex */
public final class W implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0710xn f831a;

    public W(C0710xn c0710xn) {
        this.f831a = c0710xn;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final R5 fromModel(V v) {
        R5 r5 = new R5();
        C0685wn c0685wn = v.f817a;
        if (c0685wn != null) {
            r5.f761a = this.f831a.fromModel(c0685wn);
        }
        r5.b = new C0111a6[v.b.size()];
        int i = 0;
        for (C0685wn c0685wn2 : v.b) {
            r5.b[i] = this.f831a.fromModel(c0685wn2);
            i++;
        }
        String str = v.c;
        if (str != null) {
            r5.c = str;
        }
        return r5;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        R5 r5 = (R5) obj;
        throw new UnsupportedOperationException();
    }

    public final V a(R5 r5) {
        throw new UnsupportedOperationException();
    }
}
