package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes4.dex */
public final class V implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0573rn f664a;

    public V(C0573rn c0573rn) {
        this.f664a = c0573rn;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0382k6 fromModel(U u) {
        C0382k6 c0382k6 = new C0382k6();
        C0549qn c0549qn = u.f648a;
        if (c0549qn != null) {
            c0382k6.f901a = this.f664a.fromModel(c0549qn);
        }
        c0382k6.b = new C0606t6[u.b.size()];
        int i = 0;
        for (C0549qn c0549qn2 : u.b) {
            c0382k6.b[i] = this.f664a.fromModel(c0549qn2);
            i++;
        }
        String str = u.c;
        if (str != null) {
            c0382k6.c = str;
        }
        return c0382k6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0382k6 c0382k6 = (C0382k6) obj;
        throw new UnsupportedOperationException();
    }

    public final U a(C0382k6 c0382k6) {
        throw new UnsupportedOperationException();
    }
}
