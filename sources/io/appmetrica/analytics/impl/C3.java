package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
/* loaded from: classes5.dex */
public final class C3 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Ua f486a;

    public C3() {
        this(new Ua(20, 100));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Xi fromModel(List<String> list) {
        C0519po a2 = this.f486a.a((List<Object>) list);
        C0736y8 c0736y8 = new C0736y8();
        c0736y8.f1290a = StringUtils.getUTF8Bytes((List) a2.f1153a);
        InterfaceC0549r3 interfaceC0549r3 = a2.b;
        int i = ((E4) interfaceC0549r3).f1158a;
        return new Xi(c0736y8, interfaceC0549r3);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Xi xi = (Xi) obj;
        throw new UnsupportedOperationException();
    }

    public C3(Ua ua) {
        this.f486a = ua;
    }

    public final List<String> a(Xi xi) {
        throw new UnsupportedOperationException();
    }
}
