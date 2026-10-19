package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* loaded from: classes5.dex */
public final class N6 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Ug f684a;

    public N6() {
        this(new Ug());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0442n6 fromModel(M6 m6) {
        C0442n6 fromModel = this.f684a.fromModel(m6.f664a);
        fromModel.g = 1;
        C0416m6 c0416m6 = new C0416m6();
        fromModel.h = c0416m6;
        c0416m6.f1098a = StringUtils.correctIllFormedString(m6.b);
        return fromModel;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0442n6 c0442n6 = (C0442n6) obj;
        throw new UnsupportedOperationException();
    }

    public N6(Ug ug) {
        this.f684a = ug;
    }

    public final M6 a(C0442n6 c0442n6) {
        throw new UnsupportedOperationException();
    }
}
