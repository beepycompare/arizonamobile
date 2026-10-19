package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import java.util.Collection;
import java.util.List;
/* loaded from: classes5.dex */
public final class Yf implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0100a0 f862a;
    public final Zf b;

    public Yf() {
        this(new C0100a0(), new Zf(30));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Xi fromModel(C0116ag c0116ag) {
        int i;
        F8 f8 = new F8();
        Xi fromModel = this.f862a.fromModel(c0116ag.f892a);
        f8.f546a = (C0651v8) fromModel.f844a;
        C0512po a2 = this.b.a(c0116ag.b);
        if (Oo.a((Collection) a2.f1158a)) {
            i = 0;
        } else {
            f8.b = new C0651v8[((List) a2.f1158a).size()];
            i = 0;
            for (int i2 = 0; i2 < ((List) a2.f1158a).size(); i2++) {
                Xi fromModel2 = this.f862a.fromModel((C0126b0) ((List) a2.f1158a).get(i2));
                f8.b[i2] = (C0651v8) fromModel2.f844a;
                i += fromModel2.b.getBytesTruncated();
            }
        }
        return new Xi(f8, new C0517q3(C0517q3.b(fromModel, a2, new C0517q3(i))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Xi xi = (Xi) obj;
        throw new UnsupportedOperationException();
    }

    public Yf(C0100a0 c0100a0, Zf zf) {
        this.f862a = c0100a0;
        this.b = zf;
    }

    public final C0116ag a(Xi xi) {
        throw new UnsupportedOperationException();
    }
}
