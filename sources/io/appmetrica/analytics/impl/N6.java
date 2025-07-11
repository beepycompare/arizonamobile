package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* loaded from: classes4.dex */
public final class N6 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Pg f550a;

    public N6() {
        this(new Pg());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0524q6 fromModel(M6 m6) {
        C0524q6 fromModel = this.f550a.fromModel(m6.f531a);
        fromModel.g = 1;
        C0499p6 c0499p6 = new C0499p6();
        fromModel.h = c0499p6;
        c0499p6.f987a = StringUtils.correctIllFormedString(m6.b);
        return fromModel;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0524q6 c0524q6 = (C0524q6) obj;
        throw new UnsupportedOperationException();
    }

    public N6(Pg pg) {
        this.f550a = pg;
    }

    public final M6 a(C0524q6 c0524q6) {
        throw new UnsupportedOperationException();
    }
}
