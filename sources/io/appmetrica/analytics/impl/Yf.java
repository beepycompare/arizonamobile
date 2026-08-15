package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import java.util.Collection;
import java.util.List;
/* loaded from: classes5.dex */
public final class Yf implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0106a0 f859a;
    public final Zf b;

    public Yf() {
        this(new C0106a0(), new Zf(30));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Xi fromModel(C0122ag c0122ag) {
        int i;
        F8 f8 = new F8();
        Xi fromModel = this.f859a.fromModel(c0122ag.f889a);
        f8.f543a = (C0657v8) fromModel.f841a;
        C0518po a2 = this.b.a(c0122ag.b);
        if (Oo.a((Collection) a2.f1155a)) {
            i = 0;
        } else {
            f8.b = new C0657v8[((List) a2.f1155a).size()];
            i = 0;
            for (int i2 = 0; i2 < ((List) a2.f1155a).size(); i2++) {
                Xi fromModel2 = this.f859a.fromModel((C0132b0) ((List) a2.f1155a).get(i2));
                f8.b[i2] = (C0657v8) fromModel2.f841a;
                i += fromModel2.b.getBytesTruncated();
            }
        }
        return new Xi(f8, new C0523q3(C0523q3.b(fromModel, a2, new C0523q3(i))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Xi xi = (Xi) obj;
        throw new UnsupportedOperationException();
    }

    public Yf(C0106a0 c0106a0, Zf zf) {
        this.f859a = c0106a0;
        this.b = zf;
    }

    public final C0122ag a(Xi xi) {
        throw new UnsupportedOperationException();
    }
}
