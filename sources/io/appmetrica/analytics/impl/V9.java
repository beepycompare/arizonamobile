package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes4.dex */
public final class V9 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0498om fromModel(U9 u9) {
        C0498om c0498om = new C0498om();
        if (u9 != null) {
            c0498om.f979a = u9.f656a;
        }
        return c0498om;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new U9(((C0498om) obj).f979a);
    }

    public final U9 a(C0498om c0498om) {
        return new U9(c0498om.f979a);
    }
}
