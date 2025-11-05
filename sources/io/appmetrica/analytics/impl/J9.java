package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes3.dex */
public final class J9 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0632um fromModel(I9 i9) {
        C0632um c0632um = new C0632um();
        if (i9 != null) {
            c0632um.f1157a = i9.f524a;
        }
        return c0632um;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new I9(((C0632um) obj).f1157a);
    }

    public final I9 a(C0632um c0632um) {
        return new I9(c0632um.f1157a);
    }
}
