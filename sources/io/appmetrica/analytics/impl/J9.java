package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes5.dex */
public final class J9 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final H9 fromModel(I9 i9) {
        H9 h9 = new H9();
        String str = i9.f591a;
        if (str != null) {
            h9.f575a = str.getBytes();
        }
        return h9;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final I9 toModel(H9 h9) {
        return new I9(new String(h9.f575a));
    }
}
