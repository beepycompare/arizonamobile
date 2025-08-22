package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* loaded from: classes4.dex */
public final class R6 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Wg f630a;

    public R6() {
        this(new Wg());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0598t6 fromModel(Q6 q6) {
        C0598t6 fromModel = this.f630a.fromModel(q6.f615a);
        fromModel.g = 1;
        C0573s6 c0573s6 = new C0573s6();
        fromModel.h = c0573s6;
        c0573s6.f1055a = StringUtils.correctIllFormedString(q6.b);
        return fromModel;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0598t6 c0598t6 = (C0598t6) obj;
        throw new UnsupportedOperationException();
    }

    public R6(Wg wg) {
        this.f630a = wg;
    }

    public final Q6 a(C0598t6 c0598t6) {
        throw new UnsupportedOperationException();
    }
}
