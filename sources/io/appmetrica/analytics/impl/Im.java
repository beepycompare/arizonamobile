package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes5.dex */
public final class Im implements ProtobufConverter {
    public final C0682wm a(Hm hm) {
        C0682wm c0682wm = new C0682wm();
        c0682wm.f1187a = hm.f513a;
        return c0682wm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        C0682wm c0682wm = new C0682wm();
        c0682wm.f1187a = ((Hm) obj).f513a;
        return c0682wm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new Hm(((C0682wm) obj).f1187a);
    }

    public final Hm a(C0682wm c0682wm) {
        return new Hm(c0682wm.f1187a);
    }
}
