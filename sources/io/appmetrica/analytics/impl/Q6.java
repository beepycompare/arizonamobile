package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* loaded from: classes4.dex */
public final class Q6 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Rg f608a;

    public Q6() {
        this(new Rg());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0601t6 fromModel(P6 p6) {
        C0601t6 fromModel = this.f608a.fromModel(p6.f590a);
        fromModel.g = 1;
        C0576s6 c0576s6 = new C0576s6();
        fromModel.h = c0576s6;
        c0576s6.f1049a = StringUtils.correctIllFormedString(p6.b);
        return fromModel;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0601t6 c0601t6 = (C0601t6) obj;
        throw new UnsupportedOperationException();
    }

    public Q6(Rg rg) {
        this.f608a = rg;
    }

    public final P6 a(C0601t6 c0601t6) {
        throw new UnsupportedOperationException();
    }
}
