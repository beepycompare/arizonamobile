package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import java.util.Collection;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.yf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0724yf implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Y f1316a;
    public final C0749zf b;

    public C0724yf() {
        this(new Y(), new C0749zf(30));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Ei fromModel(Af af) {
        int i;
        C0443n8 c0443n8 = new C0443n8();
        Ei fromModel = this.f1316a.fromModel(af.f493a);
        c0443n8.f1123a = (C0187d8) fromModel.f560a;
        Nn a2 = this.b.a(af.b);
        if (mo.a((Collection) a2.f708a)) {
            i = 0;
        } else {
            c0443n8.b = new C0187d8[((List) a2.f708a).size()];
            i = 0;
            for (int i2 = 0; i2 < ((List) a2.f708a).size(); i2++) {
                Ei fromModel2 = this.f1316a.fromModel((Z) ((List) a2.f708a).get(i2));
                c0443n8.b[i2] = (C0187d8) fromModel2.f560a;
                i += fromModel2.b.getBytesTruncated();
            }
        }
        return new Ei(c0443n8, new C0130b3(C0130b3.b(fromModel, a2, new C0130b3(i))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Ei ei = (Ei) obj;
        throw new UnsupportedOperationException();
    }

    public C0724yf(Y y, C0749zf c0749zf) {
        this.f1316a = y;
        this.b = c0749zf;
    }

    public final Af a(Ei ei) {
        throw new UnsupportedOperationException();
    }
}
