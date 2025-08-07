package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes4.dex */
public final class Im implements ProtobufConverter {
    public final C0692wm a(Hm hm) {
        C0692wm c0692wm = new C0692wm();
        c0692wm.f1125a = hm.f477a;
        return c0692wm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        C0692wm c0692wm = new C0692wm();
        c0692wm.f1125a = ((Hm) obj).f477a;
        return c0692wm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new Hm(((C0692wm) obj).f1125a);
    }

    public final Hm a(C0692wm c0692wm) {
        return new Hm(c0692wm.f1125a);
    }
}
