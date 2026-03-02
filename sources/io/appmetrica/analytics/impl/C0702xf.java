package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import java.util.Collection;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.xf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0702xf implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Y f1306a;
    public final C0727yf b;

    public C0702xf() {
        this(new Y(), new C0727yf(30));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Di fromModel(C0752zf c0752zf) {
        int i;
        C0421m8 c0421m8 = new C0421m8();
        Di fromModel = this.f1306a.fromModel(c0752zf.f1333a);
        c0421m8.f1113a = (C0165c8) fromModel.f552a;
        Mn a2 = this.b.a(c0752zf.b);
        if (lo.a((Collection) a2.f699a)) {
            i = 0;
        } else {
            c0421m8.b = new C0165c8[((List) a2.f699a).size()];
            i = 0;
            for (int i2 = 0; i2 < ((List) a2.f699a).size(); i2++) {
                Di fromModel2 = this.f1306a.fromModel((Z) ((List) a2.f699a).get(i2));
                c0421m8.b[i2] = (C0165c8) fromModel2.f552a;
                i += fromModel2.b.getBytesTruncated();
            }
        }
        return new Di(c0421m8, new C0108a3(C0108a3.b(fromModel, a2, new C0108a3(i))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Di di = (Di) obj;
        throw new UnsupportedOperationException();
    }

    public C0702xf(Y y, C0727yf c0727yf) {
        this.f1306a = y;
        this.b = c0727yf;
    }

    public final C0752zf a(Di di) {
        throw new UnsupportedOperationException();
    }
}
