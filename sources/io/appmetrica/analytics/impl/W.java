package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes5.dex */
public final class W implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0711xn f832a;

    public W(C0711xn c0711xn) {
        this.f832a = c0711xn;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final R5 fromModel(V v) {
        R5 r5 = new R5();
        C0686wn c0686wn = v.f818a;
        if (c0686wn != null) {
            r5.f762a = this.f832a.fromModel(c0686wn);
        }
        r5.b = new C0112a6[v.b.size()];
        int i = 0;
        for (C0686wn c0686wn2 : v.b) {
            r5.b[i] = this.f832a.fromModel(c0686wn2);
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
