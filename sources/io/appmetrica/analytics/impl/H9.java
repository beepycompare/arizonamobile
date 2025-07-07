package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes4.dex */
public final class H9 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final F9 fromModel(G9 g9) {
        F9 f9 = new F9();
        String str = g9.f442a;
        if (str != null) {
            f9.f427a = str.getBytes();
        }
        return f9;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final G9 toModel(F9 f9) {
        return new G9(new String(f9.f427a));
    }
}
