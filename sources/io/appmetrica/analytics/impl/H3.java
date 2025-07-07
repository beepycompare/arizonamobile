package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
/* loaded from: classes4.dex */
public final class H3 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Ka f453a;

    public H3() {
        this(new Ka(20, 100));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Ni fromModel(List<String> list) {
        Gn a2 = this.f453a.a((List<Object>) list);
        C0683w8 c0683w8 = new C0683w8();
        c0683w8.f1101a = StringUtils.getUTF8Bytes((List) a2.f449a);
        InterfaceC0703x3 interfaceC0703x3 = a2.b;
        int i = ((I4) interfaceC0703x3).f1097a;
        return new Ni(c0683w8, interfaceC0703x3);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Ni ni = (Ni) obj;
        throw new UnsupportedOperationException();
    }

    public H3(Ka ka) {
        this.f453a = ka;
    }

    public final List<String> a(Ni ni) {
        throw new UnsupportedOperationException();
    }
}
