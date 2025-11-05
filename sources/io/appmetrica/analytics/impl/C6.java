package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* loaded from: classes3.dex */
public final class C6 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Jg f422a;

    public C6() {
        this(new Jg());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0211e6 fromModel(B6 b6) {
        C0211e6 fromModel = this.f422a.fromModel(b6.f408a);
        fromModel.g = 1;
        C0186d6 c0186d6 = new C0186d6();
        fromModel.h = c0186d6;
        c0186d6.f842a = StringUtils.correctIllFormedString(b6.b);
        return fromModel;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0211e6 c0211e6 = (C0211e6) obj;
        throw new UnsupportedOperationException();
    }

    public C6(Jg jg) {
        this.f422a = jg;
    }

    public final B6 a(C0211e6 c0211e6) {
        throw new UnsupportedOperationException();
    }
}
