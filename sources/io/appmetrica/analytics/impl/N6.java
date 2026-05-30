package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* loaded from: classes5.dex */
public final class N6 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Ug f679a;

    public N6() {
        this(new Ug());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0449n6 fromModel(M6 m6) {
        C0449n6 fromModel = this.f679a.fromModel(m6.f659a);
        fromModel.g = 1;
        C0423m6 c0423m6 = new C0423m6();
        fromModel.h = c0423m6;
        c0423m6.f1093a = StringUtils.correctIllFormedString(m6.b);
        return fromModel;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0449n6 c0449n6 = (C0449n6) obj;
        throw new UnsupportedOperationException();
    }

    public N6(Ug ug) {
        this.f679a = ug;
    }

    public final M6 a(C0449n6 c0449n6) {
        throw new UnsupportedOperationException();
    }
}
