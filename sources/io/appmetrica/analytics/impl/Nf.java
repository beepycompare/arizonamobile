package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import java.util.Collection;
import java.util.List;
/* loaded from: classes4.dex */
public final class Nf implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final X f579a;
    public final Of b;

    public Nf() {
        this(new X(), new Of(30));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Vi fromModel(Pf pf) {
        int i;
        I8 i8 = new I8();
        Vi fromModel = this.f579a.fromModel(pf.f605a);
        i8.f493a = (C0725y8) fromModel.f697a;
        On a2 = this.b.a(pf.b);
        if (no.a((Collection) a2.f594a)) {
            i = 0;
        } else {
            i8.b = new C0725y8[((List) a2.f594a).size()];
            i = 0;
            for (int i2 = 0; i2 < ((List) a2.f594a).size(); i2++) {
                Vi fromModel2 = this.f579a.fromModel((Y) ((List) a2.f594a).get(i2));
                i8.b[i2] = (C0725y8) fromModel2.f697a;
                i += fromModel2.b.getBytesTruncated();
            }
        }
        return new Vi(i8, new C0670w3(C0670w3.b(fromModel, a2, new C0670w3(i))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Vi vi = (Vi) obj;
        throw new UnsupportedOperationException();
    }

    public Nf(X x, Of of) {
        this.f579a = x;
        this.b = of;
    }

    public final Pf a(Vi vi) {
        throw new UnsupportedOperationException();
    }
}
