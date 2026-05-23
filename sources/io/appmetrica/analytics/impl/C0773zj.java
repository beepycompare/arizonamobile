package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.zj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0773zj implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Te f1318a;
    public final C3 b;
    public final Va c;
    public final Va d;

    public C0773zj() {
        this(new Te(), new C3(), new Va(100), new Va(1000));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Xi fromModel(Dj dj) {
        Xi xi;
        J8 j8 = new J8();
        C0519po a2 = this.c.a(dj.f514a);
        j8.f608a = StringUtils.getUTF8Bytes((String) a2.f1152a);
        List<String> list = dj.b;
        Xi xi2 = null;
        if (list != null) {
            xi = this.b.fromModel(list);
            j8.b = (C0736y8) xi.f838a;
        } else {
            xi = null;
        }
        C0519po a3 = this.d.a(dj.c);
        j8.c = StringUtils.getUTF8Bytes((String) a3.f1152a);
        Map<String, String> map = dj.d;
        if (map != null) {
            xi2 = this.f1318a.fromModel(map);
            j8.d = (E8) xi2.f838a;
        }
        return new Xi(j8, new C0524q3(C0524q3.b(a2, xi, a3, xi2)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Xi xi = (Xi) obj;
        throw new UnsupportedOperationException();
    }

    public C0773zj(Te te, C3 c3, Va va, Va va2) {
        this.f1318a = te;
        this.b = c3;
        this.c = va;
        this.d = va2;
    }

    public final Dj a(Xi xi) {
        throw new UnsupportedOperationException();
    }
}
