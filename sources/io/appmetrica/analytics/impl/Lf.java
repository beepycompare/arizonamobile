package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import java.util.Collection;
import java.util.List;
/* loaded from: classes4.dex */
public final class Lf implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final X f533a;
    public final Mf b;

    public Lf() {
        this(new X(), new Mf(30));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Qi fromModel(Nf nf) {
        int i;
        G8 g8 = new G8();
        Qi fromModel = this.f533a.fromModel(nf.f564a);
        g8.f450a = (C0678w8) fromModel.f612a;
        Jn a2 = this.b.a(nf.b);
        if (io.a((Collection) a2.f511a)) {
            i = 0;
        } else {
            g8.b = new C0678w8[((List) a2.f511a).size()];
            i = 0;
            for (int i2 = 0; i2 < ((List) a2.f511a).size(); i2++) {
                Qi fromModel2 = this.f533a.fromModel((Y) ((List) a2.f511a).get(i2));
                g8.b[i2] = (C0678w8) fromModel2.f612a;
                i += fromModel2.b.getBytesTruncated();
            }
        }
        return new Qi(g8, new C0673w3(C0673w3.b(fromModel, a2, new C0673w3(i))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Qi qi = (Qi) obj;
        throw new UnsupportedOperationException();
    }

    public Lf(X x, Mf mf) {
        this.f533a = x;
        this.b = mf;
    }

    public final Nf a(Qi qi) {
        throw new UnsupportedOperationException();
    }
}
