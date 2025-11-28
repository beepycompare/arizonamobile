package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes5.dex */
public final class W implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0758zn f738a;

    public W(C0758zn c0758zn) {
        this.f738a = c0758zn;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Y5 fromModel(V v) {
        Y5 y5 = new Y5();
        C0733yn c0733yn = v.f725a;
        if (c0733yn != null) {
            y5.f766a = this.f738a.fromModel(c0733yn);
        }
        y5.b = new C0289h6[v.b.size()];
        int i = 0;
        for (C0733yn c0733yn2 : v.b) {
            y5.b[i] = this.f738a.fromModel(c0733yn2);
            i++;
        }
        String str = v.c;
        if (str != null) {
            y5.c = str;
        }
        return y5;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Y5 y5 = (Y5) obj;
        throw new UnsupportedOperationException();
    }

    public final V a(Y5 y5) {
        throw new UnsupportedOperationException();
    }
}
