package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes5.dex */
public final class C9 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0536qm fromModel(B9 b9) {
        C0536qm c0536qm = new C0536qm();
        if (b9 != null) {
            c0536qm.f1194a = b9.f516a;
        }
        return c0536qm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new B9(((C0536qm) obj).f1194a);
    }

    public final B9 a(C0536qm c0536qm) {
        return new B9(c0536qm.f1194a);
    }
}
