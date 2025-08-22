package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
/* loaded from: classes4.dex */
public final class H3 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Oa f468a;

    public H3() {
        this(new Oa(20, 100));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Vi fromModel(List<String> list) {
        On a2 = this.f468a.a((List<Object>) list);
        B8 b8 = new B8();
        b8.f359a = StringUtils.getUTF8Bytes((List) a2.f594a);
        InterfaceC0695x3 interfaceC0695x3 = a2.b;
        int i = ((I4) interfaceC0695x3).f1113a;
        return new Vi(b8, interfaceC0695x3);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Vi vi = (Vi) obj;
        throw new UnsupportedOperationException();
    }

    public H3(Oa oa) {
        this.f468a = oa;
    }

    public final List<String> a(Vi vi) {
        throw new UnsupportedOperationException();
    }
}
