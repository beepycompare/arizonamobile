package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes5.dex */
public final class Y implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0131ao f846a;

    public Y(C0131ao c0131ao) {
        this.f846a = c0131ao;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0294h6 fromModel(X x) {
        C0294h6 c0294h6 = new C0294h6();
        Zn zn = x.f833a;
        if (zn != null) {
            c0294h6.f1008a = this.f846a.fromModel(zn);
        }
        c0294h6.b = new C0527q6[x.b.size()];
        int i = 0;
        for (Zn zn2 : x.b) {
            c0294h6.b[i] = this.f846a.fromModel(zn2);
            i++;
        }
        String str = x.c;
        if (str != null) {
            c0294h6.c = str;
        }
        return c0294h6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0294h6 c0294h6 = (C0294h6) obj;
        throw new UnsupportedOperationException();
    }

    public final X a(C0294h6 c0294h6) {
        throw new UnsupportedOperationException();
    }
}
