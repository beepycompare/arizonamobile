package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
/* loaded from: classes5.dex */
public final class C3 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Ua f488a;

    public C3() {
        this(new Ua(20, 100));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Xi fromModel(List<String> list) {
        C0518po a2 = this.f488a.a((List<Object>) list);
        C0735y8 c0735y8 = new C0735y8();
        c0735y8.f1292a = StringUtils.getUTF8Bytes((List) a2.f1155a);
        InterfaceC0548r3 interfaceC0548r3 = a2.b;
        int i = ((E4) interfaceC0548r3).f1160a;
        return new Xi(c0735y8, interfaceC0548r3);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Xi xi = (Xi) obj;
        throw new UnsupportedOperationException();
    }

    public C3(Ua ua) {
        this.f488a = ua;
    }

    public final List<String> a(Xi xi) {
        throw new UnsupportedOperationException();
    }
}
