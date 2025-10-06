package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* loaded from: classes4.dex */
public final class U6 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0127ah f696a;

    public U6() {
        this(new C0127ah());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0678w6 fromModel(T6 t6) {
        C0678w6 fromModel = this.f696a.fromModel(t6.f681a);
        fromModel.g = 1;
        C0653v6 c0653v6 = new C0653v6();
        fromModel.h = c0653v6;
        c0653v6.f1121a = StringUtils.correctIllFormedString(t6.b);
        return fromModel;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0678w6 c0678w6 = (C0678w6) obj;
        throw new UnsupportedOperationException();
    }

    public U6(C0127ah c0127ah) {
        this.f696a = c0127ah;
    }

    public final T6 a(C0678w6 c0678w6) {
        throw new UnsupportedOperationException();
    }
}
