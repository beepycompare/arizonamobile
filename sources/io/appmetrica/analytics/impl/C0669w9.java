package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.w9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0669w9 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0619u9 fromModel(C0644v9 c0644v9) {
        C0619u9 c0619u9 = new C0619u9();
        String str = c0644v9.f1166a;
        if (str != null) {
            c0619u9.f1148a = str.getBytes();
        }
        return c0619u9;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0644v9 toModel(C0619u9 c0619u9) {
        return new C0644v9(new String(c0619u9.f1148a));
    }
}
