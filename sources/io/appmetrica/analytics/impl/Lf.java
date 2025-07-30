package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import java.util.Collection;
import java.util.List;
/* loaded from: classes4.dex */
public final class Lf implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final X f534a;
    public final Mf b;

    public Lf() {
        this(new X(), new Mf(30));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Qi fromModel(Nf nf) {
        int i;
        G8 g8 = new G8();
        Qi fromModel = this.f534a.fromModel(nf.f565a);
        g8.f451a = (C0677w8) fromModel.f613a;
        Jn a2 = this.b.a(nf.b);
        if (io.a((Collection) a2.f512a)) {
            i = 0;
        } else {
            g8.b = new C0677w8[((List) a2.f512a).size()];
            i = 0;
            for (int i2 = 0; i2 < ((List) a2.f512a).size(); i2++) {
                Qi fromModel2 = this.f534a.fromModel((Y) ((List) a2.f512a).get(i2));
                g8.b[i2] = (C0677w8) fromModel2.f613a;
                i += fromModel2.b.getBytesTruncated();
            }
        }
        return new Qi(g8, new C0672w3(C0672w3.b(fromModel, a2, new C0672w3(i))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Qi qi = (Qi) obj;
        throw new UnsupportedOperationException();
    }

    public Lf(X x, Mf mf) {
        this.f534a = x;
        this.b = mf;
    }

    public final Nf a(Qi qi) {
        throw new UnsupportedOperationException();
    }
}
