package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes3.dex */
public final class Ee implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0707xm fromModel(De de) {
        C0707xm c0707xm = new C0707xm();
        c0707xm.f1204a = de.f441a;
        c0707xm.b = de.b;
        return c0707xm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0707xm c0707xm = (C0707xm) obj;
        return new De(c0707xm.f1204a, c0707xm.b);
    }

    public final De a(C0707xm c0707xm) {
        return new De(c0707xm.f1204a, c0707xm.b);
    }
}
