package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* renamed from: io.appmetrica.analytics.impl.yg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0737yg implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0766zj f1302a;
    public final Va b;
    public final Va c;

    public C0737yg() {
        this(new C0766zj(), new Va(100), new Va(2048));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Xi fromModel(Ng ng) {
        Xi xi;
        I8 i8 = new I8();
        C0512po a2 = this.b.a(ng.f691a);
        i8.f596a = StringUtils.getUTF8Bytes((String) a2.f1158a);
        C0512po a3 = this.c.a(ng.b);
        i8.b = StringUtils.getUTF8Bytes((String) a3.f1158a);
        Dj dj = ng.c;
        if (dj != null) {
            xi = this.f1302a.fromModel(dj);
            i8.c = (J8) xi.f844a;
        } else {
            xi = null;
        }
        return new Xi(i8, new C0517q3(C0517q3.b(a2, a3, xi)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Xi xi = (Xi) obj;
        throw new UnsupportedOperationException();
    }

    public C0737yg(C0766zj c0766zj, Va va, Va va2) {
        this.f1302a = c0766zj;
        this.b = va;
        this.c = va2;
    }

    public final Ng a(Xi xi) {
        throw new UnsupportedOperationException();
    }
}
