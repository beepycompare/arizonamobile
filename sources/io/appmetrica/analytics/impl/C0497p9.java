package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.p9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0497p9 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0447n9 fromModel(C0472o9 c0472o9) {
        C0447n9 c0447n9 = new C0447n9();
        String str = c0472o9.f1155a;
        if (str != null) {
            c0447n9.f1137a = str.getBytes();
        }
        return c0447n9;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0472o9 toModel(C0447n9 c0447n9) {
        return new C0472o9(new String(c0447n9.f1137a));
    }
}
