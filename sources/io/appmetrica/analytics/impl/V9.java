package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes4.dex */
public final class V9 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0490om fromModel(U9 u9) {
        C0490om c0490om = new C0490om();
        if (u9 != null) {
            c0490om.f980a = u9.f657a;
        }
        return c0490om;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new U9(((C0490om) obj).f980a);
    }

    public final U9 a(C0490om c0490om) {
        return new U9(c0490om.f980a);
    }
}
