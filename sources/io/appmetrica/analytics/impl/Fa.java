package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes4.dex */
public final class Fa implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final He f443a;

    public Fa() {
        this(new C0157bm());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Bm fromModel(J4 j4) {
        Bm bm = new Bm();
        bm.b = j4.b;
        bm.f375a = j4.f509a;
        bm.c = j4.c;
        bm.d = j4.d;
        bm.e = j4.e;
        bm.f = this.f443a.a(j4.f);
        return bm;
    }

    public Fa(C0157bm c0157bm) {
        this.f443a = c0157bm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final J4 toModel(Bm bm) {
        H4 h4 = new H4();
        h4.d = bm.d;
        h4.c = bm.c;
        h4.b = bm.b;
        h4.f471a = bm.f375a;
        h4.e = bm.e;
        h4.f = this.f443a.a(bm.f);
        return new J4(h4);
    }
}
