package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* loaded from: classes5.dex */
public final class Y implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0645v7 f858a;
    public final C0573sa b;

    public Y() {
        this(new C0645v7(), new C0573sa(20));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Di fromModel(Z z) {
        C0166c8 c0166c8 = new C0166c8();
        c0166c8.b = this.f858a.fromModel(z.f874a);
        Mn a2 = this.b.a(z.b);
        c0166c8.f932a = StringUtils.getUTF8Bytes((String) a2.f699a);
        return new Di(c0166c8, new C0109a3(C0109a3.b(a2)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Di di = (Di) obj;
        throw new UnsupportedOperationException();
    }

    public Y(C0645v7 c0645v7, C0573sa c0573sa) {
        this.f858a = c0645v7;
        this.b = c0573sa;
    }

    public final Z a(Di di) {
        throw new UnsupportedOperationException();
    }
}
