package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.t3  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0588t3 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0720ya f1124a;

    public C0588t3() {
        this(new C0720ya(20, 100));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Ii fromModel(List<String> list) {
        On a2 = this.f1124a.a((List<Object>) list);
        C0394l8 c0394l8 = new C0394l8();
        c0394l8.f987a = StringUtils.getUTF8Bytes((List) a2.f625a);
        InterfaceC0337j3 interfaceC0337j3 = a2.b;
        int i = ((C0614u4) interfaceC0337j3).f923a;
        return new Ii(c0394l8, interfaceC0337j3);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Ii ii = (Ii) obj;
        throw new UnsupportedOperationException();
    }

    public C0588t3(C0720ya c0720ya) {
        this.f1124a = c0720ya;
    }

    public final List<String> a(Ii ii) {
        throw new UnsupportedOperationException();
    }
}
