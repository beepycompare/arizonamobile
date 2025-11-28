package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import java.util.Collection;
import java.util.List;
/* loaded from: classes5.dex */
public final class Cf implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Y f425a;
    public final Df b;

    public Cf() {
        this(new Y(), new Df(30));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Ii fromModel(Ef ef) {
        int i;
        C0568s8 c0568s8 = new C0568s8();
        Ii fromModel = this.f425a.fromModel(ef.f459a);
        c0568s8.f1109a = (C0317i8) fromModel.f530a;
        On a2 = this.b.a(ef.b);
        if (no.a((Collection) a2.f625a)) {
            i = 0;
        } else {
            c0568s8.b = new C0317i8[((List) a2.f625a).size()];
            i = 0;
            for (int i2 = 0; i2 < ((List) a2.f625a).size(); i2++) {
                Ii fromModel2 = this.f425a.fromModel((Z) ((List) a2.f625a).get(i2));
                c0568s8.b[i2] = (C0317i8) fromModel2.f530a;
                i += fromModel2.b.getBytesTruncated();
            }
        }
        return new Ii(c0568s8, new C0312i3(C0312i3.b(fromModel, a2, new C0312i3(i))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Ii ii = (Ii) obj;
        throw new UnsupportedOperationException();
    }

    public Cf(Y y, Df df) {
        this.f425a = y;
        this.b = df;
    }

    public final Ef a(Ii ii) {
        throw new UnsupportedOperationException();
    }
}
