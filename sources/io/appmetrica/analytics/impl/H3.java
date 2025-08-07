package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
/* loaded from: classes4.dex */
public final class H3 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Ma f463a;

    public H3() {
        this(new Ma(20, 100));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Qi fromModel(List<String> list) {
        Jn a2 = this.f463a.a((List<Object>) list);
        C0753z8 c0753z8 = new C0753z8();
        c0753z8.f1166a = StringUtils.getUTF8Bytes((List) a2.f511a);
        InterfaceC0698x3 interfaceC0698x3 = a2.b;
        int i = ((I4) interfaceC0698x3).f1111a;
        return new Qi(c0753z8, interfaceC0698x3);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Qi qi = (Qi) obj;
        throw new UnsupportedOperationException();
    }

    public H3(Ma ma) {
        this.f463a = ma;
    }

    public final List<String> a(Qi qi) {
        throw new UnsupportedOperationException();
    }
}
