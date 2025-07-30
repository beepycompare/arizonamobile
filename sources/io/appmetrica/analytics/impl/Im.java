package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes4.dex */
public final class Im implements ProtobufConverter {
    public final C0691wm a(Hm hm) {
        C0691wm c0691wm = new C0691wm();
        c0691wm.f1126a = hm.f478a;
        return c0691wm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        C0691wm c0691wm = new C0691wm();
        c0691wm.f1126a = ((Hm) obj).f478a;
        return c0691wm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new Hm(((C0691wm) obj).f1126a);
    }

    public final Hm a(C0691wm c0691wm) {
        return new Hm(c0691wm.f1126a);
    }
}
