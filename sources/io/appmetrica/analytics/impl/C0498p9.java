package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.p9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0498p9 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0448n9 fromModel(C0473o9 c0473o9) {
        C0448n9 c0448n9 = new C0448n9();
        String str = c0473o9.f1151a;
        if (str != null) {
            c0448n9.f1133a = str.getBytes();
        }
        return c0448n9;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0473o9 toModel(C0448n9 c0448n9) {
        return new C0473o9(new String(c0448n9.f1133a));
    }
}
