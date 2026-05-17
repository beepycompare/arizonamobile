package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* loaded from: classes5.dex */
public final class Y implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0644v7 f863a;
    public final C0572sa b;

    public Y() {
        this(new C0644v7(), new C0572sa(20));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Di fromModel(Z z) {
        C0165c8 c0165c8 = new C0165c8();
        c0165c8.b = this.f863a.fromModel(z.f879a);
        Mn a2 = this.b.a(z.b);
        c0165c8.f937a = StringUtils.getUTF8Bytes((String) a2.f704a);
        return new Di(c0165c8, new C0108a3(C0108a3.b(a2)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Di di = (Di) obj;
        throw new UnsupportedOperationException();
    }

    public Y(C0644v7 c0644v7, C0572sa c0572sa) {
        this.f863a = c0644v7;
        this.b = c0572sa;
    }

    public final Z a(Di di) {
        throw new UnsupportedOperationException();
    }
}
