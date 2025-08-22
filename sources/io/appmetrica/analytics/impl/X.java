package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* loaded from: classes4.dex */
public final class X implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final S7 f715a;
    public final Pa b;

    public X() {
        this(new S7(), new Pa(20));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Vi fromModel(Y y) {
        C0725y8 c0725y8 = new C0725y8();
        c0725y8.b = this.f715a.fromModel(y.f731a);
        On a2 = this.b.a(y.b);
        c0725y8.f1154a = StringUtils.getUTF8Bytes((String) a2.f594a);
        return new Vi(c0725y8, new C0670w3(C0670w3.b(a2)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Vi vi = (Vi) obj;
        throw new UnsupportedOperationException();
    }

    public X(S7 s7, Pa pa) {
        this.f715a = s7;
        this.b = pa;
    }

    public final Y a(Vi vi) {
        throw new UnsupportedOperationException();
    }
}
