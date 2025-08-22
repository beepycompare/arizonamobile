package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes4.dex */
public final class M9 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final K9 fromModel(L9 l9) {
        K9 k9 = new K9();
        String str = l9.f540a;
        if (str != null) {
            k9.f528a = str.getBytes();
        }
        return k9;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final L9 toModel(K9 k9) {
        return new L9(new String(k9.f528a));
    }
}
