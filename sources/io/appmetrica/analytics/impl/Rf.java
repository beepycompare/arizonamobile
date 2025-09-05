package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import java.util.Collection;
import java.util.List;
/* loaded from: classes4.dex */
public final class Rf implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final X f652a;
    public final Sf b;

    public Rf() {
        this(new X(), new Sf(30));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Zi fromModel(Tf tf) {
        int i;
        L8 l8 = new L8();
        Zi fromModel = this.f652a.fromModel(tf.f681a);
        l8.f551a = (B8) fromModel.f772a;
        Sn a2 = this.b.a(tf.b);
        if (ro.a((Collection) a2.f671a)) {
            i = 0;
        } else {
            l8.b = new B8[((List) a2.f671a).size()];
            i = 0;
            for (int i2 = 0; i2 < ((List) a2.f671a).size(); i2++) {
                Zi fromModel2 = this.f652a.fromModel((Y) ((List) a2.f671a).get(i2));
                l8.b[i2] = (B8) fromModel2.f772a;
                i += fromModel2.b.getBytesTruncated();
            }
        }
        return new Zi(l8, new C0749z3(C0749z3.b(fromModel, a2, new C0749z3(i))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Zi zi = (Zi) obj;
        throw new UnsupportedOperationException();
    }

    public Rf(X x, Sf sf) {
        this.f652a = x;
        this.b = sf;
    }

    public final Tf a(Zi zi) {
        throw new UnsupportedOperationException();
    }
}
