package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes4.dex */
public final class P9 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final N9 fromModel(O9 o9) {
        N9 n9 = new N9();
        String str = o9.f602a;
        if (str != null) {
            n9.f588a = str.getBytes();
        }
        return n9;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final O9 toModel(N9 n9) {
        return new O9(new String(n9.f588a));
    }
}
