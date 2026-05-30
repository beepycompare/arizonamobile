package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* renamed from: io.appmetrica.analytics.impl.yg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0744yg implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0773zj f1297a;
    public final Va b;
    public final Va c;

    public C0744yg() {
        this(new C0773zj(), new Va(100), new Va(2048));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Xi fromModel(Ng ng) {
        Xi xi;
        I8 i8 = new I8();
        C0519po a2 = this.b.a(ng.f686a);
        i8.f591a = StringUtils.getUTF8Bytes((String) a2.f1153a);
        C0519po a3 = this.c.a(ng.b);
        i8.b = StringUtils.getUTF8Bytes((String) a3.f1153a);
        Dj dj = ng.c;
        if (dj != null) {
            xi = this.f1297a.fromModel(dj);
            i8.c = (J8) xi.f839a;
        } else {
            xi = null;
        }
        return new Xi(i8, new C0524q3(C0524q3.b(a2, a3, xi)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Xi xi = (Xi) obj;
        throw new UnsupportedOperationException();
    }

    public C0744yg(C0773zj c0773zj, Va va, Va va2) {
        this.f1297a = c0773zj;
        this.b = va;
        this.c = va2;
    }

    public final Ng a(Xi xi) {
        throw new UnsupportedOperationException();
    }
}
