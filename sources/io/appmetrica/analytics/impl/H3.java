package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
/* loaded from: classes4.dex */
public final class H3 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Ka f454a;

    public H3() {
        this(new Ka(20, 100));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Ni fromModel(List<String> list) {
        Gn a2 = this.f454a.a((List<Object>) list);
        C0675w8 c0675w8 = new C0675w8();
        c0675w8.f1102a = StringUtils.getUTF8Bytes((List) a2.f450a);
        InterfaceC0695x3 interfaceC0695x3 = a2.b;
        int i = ((I4) interfaceC0695x3).f1098a;
        return new Ni(c0675w8, interfaceC0695x3);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Ni ni = (Ni) obj;
        throw new UnsupportedOperationException();
    }

    public H3(Ka ka) {
        this.f454a = ka;
    }

    public final List<String> a(Ni ni) {
        throw new UnsupportedOperationException();
    }
}
