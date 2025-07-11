package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import java.util.Collection;
import java.util.List;
/* loaded from: classes4.dex */
public final class Jf implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final X f493a;
    public final Kf b;

    public Jf() {
        this(new X(), new Kf(30));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Ni fromModel(Lf lf) {
        int i;
        D8 d8 = new D8();
        Ni fromModel = this.f493a.fromModel(lf.f519a);
        d8.f387a = (C0600t8) fromModel.f557a;
        Gn a2 = this.b.a(lf.b);
        if (fo.a((Collection) a2.f450a)) {
            i = 0;
        } else {
            d8.b = new C0600t8[((List) a2.f450a).size()];
            i = 0;
            for (int i2 = 0; i2 < ((List) a2.f450a).size(); i2++) {
                Ni fromModel2 = this.f493a.fromModel((Y) ((List) a2.f450a).get(i2));
                d8.b[i2] = (C0600t8) fromModel2.f557a;
                i += fromModel2.b.getBytesTruncated();
            }
        }
        return new Ni(d8, new C0670w3(C0670w3.b(fromModel, a2, new C0670w3(i))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Ni ni = (Ni) obj;
        throw new UnsupportedOperationException();
    }

    public Jf(X x, Kf kf) {
        this.f493a = x;
        this.b = kf;
    }

    public final Lf a(Ni ni) {
        throw new UnsupportedOperationException();
    }
}
