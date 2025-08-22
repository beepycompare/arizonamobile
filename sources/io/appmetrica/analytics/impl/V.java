package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes4.dex */
public final class V implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0765zn f685a;

    public V(C0765zn c0765zn) {
        this.f685a = c0765zn;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0449n6 fromModel(U u) {
        C0449n6 c0449n6 = new C0449n6();
        C0740yn c0740yn = u.f668a;
        if (c0740yn != null) {
            c0449n6.f980a = this.f685a.fromModel(c0740yn);
        }
        c0449n6.b = new C0673w6[u.b.size()];
        int i = 0;
        for (C0740yn c0740yn2 : u.b) {
            c0449n6.b[i] = this.f685a.fromModel(c0740yn2);
            i++;
        }
        String str = u.c;
        if (str != null) {
            c0449n6.c = str;
        }
        return c0449n6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0449n6 c0449n6 = (C0449n6) obj;
        throw new UnsupportedOperationException();
    }

    public final U a(C0449n6 c0449n6) {
        throw new UnsupportedOperationException();
    }
}
