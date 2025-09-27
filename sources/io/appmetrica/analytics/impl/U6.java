package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* loaded from: classes4.dex */
public final class U6 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0126ah f696a;

    public U6() {
        this(new C0126ah());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0677w6 fromModel(T6 t6) {
        C0677w6 fromModel = this.f696a.fromModel(t6.f681a);
        fromModel.g = 1;
        C0652v6 c0652v6 = new C0652v6();
        fromModel.h = c0652v6;
        c0652v6.f1121a = StringUtils.correctIllFormedString(t6.b);
        return fromModel;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0677w6 c0677w6 = (C0677w6) obj;
        throw new UnsupportedOperationException();
    }

    public U6(C0126ah c0126ah) {
        this.f696a = c0126ah;
    }

    public final T6 a(C0677w6 c0677w6) {
        throw new UnsupportedOperationException();
    }
}
