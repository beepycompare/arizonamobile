package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes4.dex */
public final class Fa implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final He f444a;

    public Fa() {
        this(new C0158bm());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Bm fromModel(J4 j4) {
        Bm bm = new Bm();
        bm.b = j4.b;
        bm.f376a = j4.f510a;
        bm.c = j4.c;
        bm.d = j4.d;
        bm.e = j4.e;
        bm.f = this.f444a.a(j4.f);
        return bm;
    }

    public Fa(C0158bm c0158bm) {
        this.f444a = c0158bm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final J4 toModel(Bm bm) {
        H4 h4 = new H4();
        h4.d = bm.d;
        h4.c = bm.c;
        h4.b = bm.b;
        h4.f472a = bm.f376a;
        h4.e = bm.e;
        h4.f = this.f444a.a(bm.f);
        return new J4(h4);
    }
}
