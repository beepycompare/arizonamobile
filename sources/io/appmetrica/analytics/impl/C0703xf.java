package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import java.util.Collection;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.xf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0703xf implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Y f1306a;
    public final C0728yf b;

    public C0703xf() {
        this(new Y(), new C0728yf(30));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Di fromModel(C0753zf c0753zf) {
        int i;
        C0422m8 c0422m8 = new C0422m8();
        Di fromModel = this.f1306a.fromModel(c0753zf.f1333a);
        c0422m8.f1113a = (C0166c8) fromModel.f552a;
        Mn a2 = this.b.a(c0753zf.b);
        if (lo.a((Collection) a2.f699a)) {
            i = 0;
        } else {
            c0422m8.b = new C0166c8[((List) a2.f699a).size()];
            i = 0;
            for (int i2 = 0; i2 < ((List) a2.f699a).size(); i2++) {
                Di fromModel2 = this.f1306a.fromModel((Z) ((List) a2.f699a).get(i2));
                c0422m8.b[i2] = (C0166c8) fromModel2.f552a;
                i += fromModel2.b.getBytesTruncated();
            }
        }
        return new Di(c0422m8, new C0109a3(C0109a3.b(fromModel, a2, new C0109a3(i))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Di di = (Di) obj;
        throw new UnsupportedOperationException();
    }

    public C0703xf(Y y, C0728yf c0728yf) {
        this.f1306a = y;
        this.b = c0728yf;
    }

    public final C0753zf a(Di di) {
        throw new UnsupportedOperationException();
    }
}
