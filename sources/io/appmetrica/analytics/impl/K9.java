package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes4.dex */
public final class K9 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final I9 fromModel(J9 j9) {
        I9 i9 = new I9();
        String str = j9.f503a;
        if (str != null) {
            i9.f489a = str.getBytes();
        }
        return i9;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final J9 toModel(I9 i9) {
        return new J9(new String(i9.f489a));
    }
}
