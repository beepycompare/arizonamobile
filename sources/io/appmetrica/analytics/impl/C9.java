package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes5.dex */
public final class C9 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0535qm fromModel(B9 b9) {
        C0535qm c0535qm = new C0535qm();
        if (b9 != null) {
            c0535qm.f1193a = b9.f515a;
        }
        return c0535qm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new B9(((C0535qm) obj).f1193a);
    }

    public final B9 a(C0535qm c0535qm) {
        return new B9(c0535qm.f1193a);
    }
}
