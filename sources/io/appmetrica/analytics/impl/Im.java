package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes5.dex */
public final class Im implements ProtobufConverter {
    public final C0681wm a(Hm hm) {
        C0681wm c0681wm = new C0681wm();
        c0681wm.f1285a = hm.f611a;
        return c0681wm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        C0681wm c0681wm = new C0681wm();
        c0681wm.f1285a = ((Hm) obj).f611a;
        return c0681wm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new Hm(((C0681wm) obj).f1285a);
    }

    public final Hm a(C0681wm c0681wm) {
        return new Hm(c0681wm.f1285a);
    }
}
