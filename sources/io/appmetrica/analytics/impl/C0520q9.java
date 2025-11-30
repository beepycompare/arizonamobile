package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.q9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0520q9 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0470o9 fromModel(C0495p9 c0495p9) {
        C0470o9 c0470o9 = new C0470o9();
        String str = c0495p9.f1063a;
        if (str != null) {
            c0470o9.f1045a = str.getBytes();
        }
        return c0470o9;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0495p9 toModel(C0470o9 c0470o9) {
        return new C0495p9(new String(c0470o9.f1045a));
    }
}
