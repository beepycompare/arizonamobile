package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* loaded from: classes4.dex */
public final class N6 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Pg f549a;

    public N6() {
        this(new Pg());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0532q6 fromModel(M6 m6) {
        C0532q6 fromModel = this.f549a.fromModel(m6.f530a);
        fromModel.g = 1;
        C0507p6 c0507p6 = new C0507p6();
        fromModel.h = c0507p6;
        c0507p6.f986a = StringUtils.correctIllFormedString(m6.b);
        return fromModel;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0532q6 c0532q6 = (C0532q6) obj;
        throw new UnsupportedOperationException();
    }

    public N6(Pg pg) {
        this.f549a = pg;
    }

    public final M6 a(C0532q6 c0532q6) {
        throw new UnsupportedOperationException();
    }
}
