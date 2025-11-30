package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import java.util.Collection;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.yf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0725yf implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Y f1219a;
    public final C0750zf b;

    public C0725yf() {
        this(new Y(), new C0750zf(30));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Ei fromModel(Af af) {
        int i;
        C0444n8 c0444n8 = new C0444n8();
        Ei fromModel = this.f1219a.fromModel(af.f396a);
        c0444n8.f1026a = (C0188d8) fromModel.f463a;
        Nn a2 = this.b.a(af.b);
        if (mo.a((Collection) a2.f611a)) {
            i = 0;
        } else {
            c0444n8.b = new C0188d8[((List) a2.f611a).size()];
            i = 0;
            for (int i2 = 0; i2 < ((List) a2.f611a).size(); i2++) {
                Ei fromModel2 = this.f1219a.fromModel((Z) ((List) a2.f611a).get(i2));
                c0444n8.b[i2] = (C0188d8) fromModel2.f463a;
                i += fromModel2.b.getBytesTruncated();
            }
        }
        return new Ei(c0444n8, new C0131b3(C0131b3.b(fromModel, a2, new C0131b3(i))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Ei ei = (Ei) obj;
        throw new UnsupportedOperationException();
    }

    public C0725yf(Y y, C0750zf c0750zf) {
        this.f1219a = y;
        this.b = c0750zf;
    }

    public final Af a(Ei ei) {
        throw new UnsupportedOperationException();
    }
}
