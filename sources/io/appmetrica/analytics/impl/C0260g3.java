package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.g3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0260g3 implements ProtobufConverter {
    public final C0508pm a(C0208e3 c0208e3) {
        C0508pm c0508pm = new C0508pm();
        c0508pm.f1074a = c0208e3.f863a;
        return c0508pm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        C0508pm c0508pm = new C0508pm();
        c0508pm.f1074a = ((C0208e3) obj).f863a;
        return c0508pm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new C0208e3(((C0508pm) obj).f1074a);
    }

    public final C0208e3 a(C0508pm c0508pm) {
        return new C0208e3(c0508pm.f1074a);
    }
}
