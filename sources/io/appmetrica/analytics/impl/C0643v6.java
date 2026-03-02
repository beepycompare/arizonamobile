package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* renamed from: io.appmetrica.analytics.impl.v6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0643v6 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Eg f1269a;

    public C0643v6() {
        this(new Eg());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final X5 fromModel(C0618u6 c0618u6) {
        X5 fromModel = this.f1269a.fromModel(c0618u6.f1250a);
        fromModel.g = 1;
        W5 w5 = new W5();
        fromModel.h = w5;
        w5.f836a = StringUtils.correctIllFormedString(c0618u6.b);
        return fromModel;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        X5 x5 = (X5) obj;
        throw new UnsupportedOperationException();
    }

    public C0643v6(Eg eg) {
        this.f1269a = eg;
    }

    public final C0618u6 a(X5 x5) {
        throw new UnsupportedOperationException();
    }
}
