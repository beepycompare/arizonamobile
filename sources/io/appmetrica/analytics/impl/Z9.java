package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes4.dex */
public final class Z9 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0689wm fromModel(Y9 y9) {
        C0689wm c0689wm = new C0689wm();
        if (y9 != null) {
            c0689wm.f1128a = y9.f739a;
        }
        return c0689wm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new Y9(((C0689wm) obj).f1128a);
    }

    public final Y9 a(C0689wm c0689wm) {
        return new Y9(c0689wm.f1128a);
    }
}
